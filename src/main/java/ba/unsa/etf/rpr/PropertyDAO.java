package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.List;

public interface PropertyDAO extends Dao<Property>{

   boolean hasAC(int idProperty);

   double pricePerNight(int idProperty);

   boolean isAvailable(Property property, Date d1,Date d2);


}
