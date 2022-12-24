package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Guest;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GuestDaoSQLImpl extends AbstractDao<Guest> implements GuestDAO {


    public GuestDaoSQLImpl() {
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
        row.put("numberOfGuests", object.getNumberOfGuests());
        row.put("number", object.getGuestNumber());
        row.put("country", object.getCountry());
        return row;
    }
@Override
 public List<Guest>searchByName(String name) throws Exceptionss {
     return executeQuery("SELECT GuestCountry FROM guest WHERE GuestEmail = ?", new Object[]{name});

 }

    @Override
    public List<Guest> searchByCountryOfOrigin(String email) throws Exceptionss {

        return executeQuery("SELECT GuestCountry FROM guest WHERE GuestEmail = ?", new Object[]{email});
    }
}