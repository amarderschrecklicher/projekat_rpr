package ba.unsa.etf.rpr.dao;

import java.util.Date;

public interface PropertyDAO extends Dao<Property> {

   boolean hasAC(int idProperty);

   double pricePerNight(int idProperty);

   boolean isAvailable(Property property, Date d1,Date d2);


}
