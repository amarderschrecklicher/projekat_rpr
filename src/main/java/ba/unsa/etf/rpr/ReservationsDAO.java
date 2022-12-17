package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.List;

public interface ReservationsDAO extends Dao<Reservations>{
    int nightsOfStay(int idReservation);

    List<Reservations> allOfReseravtions(Guest guest);

    Property  propertyDetails(int idReservation);

    Host hostOfReservation(int idReservation);

    boolean  capacityMatch(int idReservation);

}

