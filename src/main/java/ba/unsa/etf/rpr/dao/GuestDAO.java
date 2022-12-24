package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Guest;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

public interface GuestDAO extends Dao<Guest> {

    int numberOfGuests(String name) throws Exceptionss;

    String countryOfOrigin(String email) throws Exceptionss;

}
