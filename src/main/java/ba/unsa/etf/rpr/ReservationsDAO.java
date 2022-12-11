package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.List;

public interface ReservationsDAO extends Dao<Reservations>{
    List<Reservations> nightsOfStay(Date a, Date b);

}

