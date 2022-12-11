package ba.unsa.etf.rpr;

import java.util.List;

public interface GuestDAO extends Dao<Guest>{

    List<Guest> searchByName(String name);

    List<Guest> searchByEmail(String email);

}
