package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Guest;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.domain.Reservations;

import java.util.List;

public interface ReservationsDAO extends Dao<Reservations> {
    int nightsOfStay(int idReservation);

    List<Reservations> allOfReseravtions(Guest guest);

    Property propertyDetails(int idReservation);

    Host hostOfReservation(int idReservation);

    boolean  capacityMatch(int idReservation);

}

