package ba.unsa.etf.rpr;

import java.util.List;

public interface PropertyDAO extends Dao<Property>{

    List<Property> searchByType(String type);

    List<Property> searchByPrice(String price);
}
