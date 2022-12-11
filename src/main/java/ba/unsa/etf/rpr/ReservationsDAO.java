package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.List;

public interface ReservationsDAO extends Dao<Reservations>{
    List<Reservations> nightsOfStay(Date a, Date b);

    List<Reservations> allOfReseravtions(Guest guest);

    Property  propertyDetails(Reservations reservations);

    Host hostOfReservation(Reservations reservations);

    boolean  capacityMatch(Reservations  reservations);

}

