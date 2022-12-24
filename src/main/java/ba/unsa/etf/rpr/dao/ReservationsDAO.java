package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Guest;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

import java.util.List;

public interface ReservationsDAO extends Dao<Reservations> {
    int nightsOfStay(int idReservation);

    List<Reservations> allOfReseravtions(Guest guest)throws Exceptionss;

    Property propertyDetails(int idReservation)throws Exceptionss;

    Host hostOfReservation(int idReservation)throws Exceptionss;

    boolean  capacityMatch(int idReservation)throws Exceptionss;

}

