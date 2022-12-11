package ba.unsa.etf.rpr;

import java.util.List;

public interface GuestDAO extends Dao<Guest>{

    int numberOfGuests(String name);

    String countryOfOrigin(String email);

}
