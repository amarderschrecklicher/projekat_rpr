package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.DriverManager;
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
    public List<Guest> searchByName(String name) {
        return null;
    }

    @Override
    public List<Guest> searchByEmail(String email) {
        return null;
    }
}
