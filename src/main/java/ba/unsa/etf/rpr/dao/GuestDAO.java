package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Guest;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

import java.util.List;

public interface GuestDAO extends Dao<Guest> {

    List<Guest> searchByName(String name) throws Exceptionss;

    List<Guest> searchByCountryOfOrigin(String email) throws Exceptionss;

}
