package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Guest;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GuestDaoSQLImpl extends AbstractDao<Guest> implements GuestDAO {

    private Connection connection;

    public GuestDaoSQLImpl(){
    super("Guest");
    }


    @Override
    public Guest row2object(ResultSet rs) throws Exceptionss {
        try {
            Guest guest = new Guest();
            guest.setId(rs.getInt(1));
            guest.setName(rs.getString(2));
            guest.setNumberOfGuests(rs.getInt(3));
            guest.setGuestNumber(rs.getString(4));
            guest.setCountry(rs.getString(5));
            return guest;
        } catch (SQLException e) {
            throw new Exceptionss(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Guest object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        row.put("numberOfGuests",object.getNumberOfGuests());
        row.put("number",object.getGuestNumber());
        row.put("country",object.getCountry());
        return row;
    }

    @Override
    public Guest getById(int id) {
        return null;
    }

    @Override
    public List<Guest> getall() {
        return null;
    }

    @Override
    public int numberOfGuests(String name) {
        String query = "SELECT numberofguests FROM guest WHERE GuestName = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) { // result set is iterator.
                return rs.getInt(3);
            }else {
                return 0; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }

        return 0;
    }

    @Override
    public String countryOfOrigin(String email) { String query = "SELECT GuestCountry FROM guest WHERE GuestEmail = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) { // result set is iterator.
                return rs.getString(4);
            }else {
                return "No guest"; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }

        return "No guest";
    }
}
