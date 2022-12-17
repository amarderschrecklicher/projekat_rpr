package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.List;

public interface PropertyDAO extends Dao<Property>{

   boolean hasAC(Property property);

   double pricePerNight(Property property);

   boolean isAvailable(Property property, Date d);


}
