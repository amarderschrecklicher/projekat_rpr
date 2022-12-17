package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.List;

public interface ReservationsDAO extends Dao<Reservations>{
    int nightsOfStay(int idReservation);

    List<Reservations> allOfReseravtions(Guest guest);

    Property  propertyDetails(Reservations reservation);

    Host hostOfReservation(Reservations reservation);

    boolean  capacityMatch(Reservations  reservation);

}

