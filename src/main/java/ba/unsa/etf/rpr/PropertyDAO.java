package ba.unsa.etf.rpr;

import java.util.List;

public interface PropertyDAO extends Dao<Property>{

   boolean hasAC(Property property);

   double pricePerNights(Property property);


}
