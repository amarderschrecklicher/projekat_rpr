package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.Guest;

public interface GuestDAO extends Dao<Guest> {

    int numberOfGuests(String name);

    String countryOfOrigin(String email);

}
