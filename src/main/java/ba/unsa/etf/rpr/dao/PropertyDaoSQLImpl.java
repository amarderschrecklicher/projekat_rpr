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
            q.setId(rs.getInt(4));
            q.setHostId(rs.getInt(3));
            q.setPropertyName(rs.getString(9));
            q.setPropertyType(rs.getString(10));
            q.setCapacity(rs.getInt(1));
            q.setBathrooms(rs.getInt(5));
            q.setKitchens(rs.getInt(6));
            q.setLocation(rs.getString(8));
            q.setAcH(rs.getBoolean(2));
            q.setPrice(rs.getDouble(7));
            return q;
        } catch (Exception e) {
            throw new Exceptionss(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Property object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("Capacity",object.getCapacity());
        row.put("Heating_AC",object.isAcH());
        row.put("HostId",object.getHostId());
        row.put("id", object.getId());
        row.put("NmbOfBathrooms",object.getBathrooms());
        row.put("NmbOfKitchens",object.getKitchens());
        row.put("PricePerNight",object.getPrice());
        row.put("PropertyLocation",object.getLocation());
        row.put("PropertyName",object.getPropertyName());
        row.put("PropertyType", object.getPropertyType());

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
