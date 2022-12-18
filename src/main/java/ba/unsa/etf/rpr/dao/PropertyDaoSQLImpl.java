package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PropertyDaoSQLImpl implements PropertyDAO{
    private Connection connection;

    @Override
    public Property getById(int id) {
        return null;
    }

    @Override
    public Property add(Property item) {
        return null;
    }

    @Override
    public Property update(Property item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Property> getall() {
        return null;
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
