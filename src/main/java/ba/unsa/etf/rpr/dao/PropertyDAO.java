package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

import java.util.Date;

public interface PropertyDAO extends Dao<Property> {

   boolean hasAC(int idProperty) throws Exceptionss;

   double pricePerNight(int idProperty) throws Exceptionss;

   boolean isAvailable(Property property, Date d1,Date d2) throws Exceptionss;


}
