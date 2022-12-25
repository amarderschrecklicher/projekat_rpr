package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PropertyDaoSQLImpl extends AbstractDao<Property> implements PropertyDAO{
    private Connection connection;

    public PropertyDaoSQLImpl() {
        super("Property");
    }

    @Override
    public Property row2object(ResultSet rs) throws Exceptionss {
        try {
            Property q = new Property();
            q.setId(rs.getInt(1));
            q.setHostId(rs.getInt(2));
            q.setPropertyType(rs.getString(3));
            q.setCapacity(rs.getInt(4));
            q.setBathrooms(rs.getInt(5));
            q.setKitchens(rs.getInt(6));
            q.setLocation(rs.getString(7));
            q.setAcH(rs.getBoolean(8));
            q.setPrice(rs.getDouble(9));
            return q;
        } catch (Exception e) {
            throw new Exceptionss(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Property object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id", object.getId());
        row.put("hostId",object.getHostId());
        row.put("type", object.getPropertyType());
        row.put("capacity",object.getCapacity());
        row.put("bathrooms",object.getBathrooms());
        row.put("kitchens",object.getKitchens());
        row.put("location",object.getLocation());
        row.put("AC/HEATING",object.isAcH());
        row.put("price",object.getPrice());
        return row;
    }


    @Override
    public List<Property> hostProperties(Host host) throws Exceptionss {
        return executeQuery("SELECT * FROM Property WHERE HostId = ?", new Object[]{host.getId()});
    }

    @Override
    public boolean hasAC(int idProperty) {
        String query = "SELECT * FROM Property WHERE PropertyID = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, idProperty);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return rs.getBoolean(7);
            }
            else {
                return false; // if there is no elements in the result set return null
            }

        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }

        return false;
    }

    @Override
    public double pricePerNight(int idProperty) {
        String query = "SELECT * FROM Property WHERE PropertyID = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, idProperty);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
            return rs.getDouble(8);
            }
            else {
                return 0; // if there is no elements in the result set return null
            }

        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }

        return 0;
    }

    @Override
    public boolean isAvailable(Property property, Date d1,Date d2) {
        String query = "SELECT * FROM Reservations WHERE PropertyID = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, property.getId());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
            Date date1=rs.getDate(6);
            Date date2=rs.getDate(7);
            if((d1.compareTo(date1)<0 && d2.compareTo(date1)<0) || (d1.compareTo(date2)>0 && d2.compareTo(date2)>0))
                return true;
            }
            else {
                return false; // if there is no elements in the result set return null
            }

        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }


        return false;
    }
}
