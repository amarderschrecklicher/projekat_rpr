package ba.unsa.etf.rpr.dao;

import java.util.List;

public interface ReservationsDAO extends Dao<Reservations> {
    int nightsOfStay(int idReservation);

    List<Reservations> allOfReseravtions(Guest guest);

    Property  propertyDetails(int idReservation);

    Host hostOfReservation(int idReservation);

    boolean  capacityMatch(int idReservation);

}

