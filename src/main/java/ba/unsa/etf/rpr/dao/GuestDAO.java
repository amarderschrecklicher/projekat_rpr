package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Guest;

public interface GuestDAO extends Dao<Guest> {

    int numberOfGuests(String name);

    String countryOfOrigin(String email);

}
