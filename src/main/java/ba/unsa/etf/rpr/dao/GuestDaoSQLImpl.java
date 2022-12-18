package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Guest;

import java.sql.*;
import java.util.List;

public class GuestDaoSQLImpl implements GuestDAO {

    private Connection connection;

    public GuestDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("url", "usr", "psw");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public Guest getById(int id) {
        String query = "SELECT * FROM guest WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Guest guest = new Guest();
                guest.setId(rs.getInt(1));
                guest.setName(rs.getString(2));
                guest.setNumberOfGuests(rs.getInt(3));
                guest.setGuestNumber(rs.getString(4));
                guest.setCountry(rs.getString(5));
                rs.close();
                return guest;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }

    @Override
    public Guest add(Guest item) {
        return null;
    }

    @Override
    public Guest update(Guest item) {
        return null;
    }

    @Override
    public void delete(int id) {

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
