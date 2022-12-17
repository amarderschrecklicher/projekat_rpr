package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.List;

public class ReservationsDaoSQLImpl implements ReservationsDAO{
    @Override
    public Reservations getById(int id) {
        return null;
    }

    @Override
    public Reservations add(Reservations item) {
        return null;
    }

    @Override
    public Reservations update(Reservations item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Reservations> getall() {
        return null;
    }

    @Override
    public int nightsOfStay(Reservations reservation) {


        return 0;
    }

    @Override
    public List<Reservations> allOfReseravtions(Guest guest) {
        return null;
    }

    @Override
    public Property propertyDetails(Reservations reservations) {
        return null;
    }

    @Override
    public Host hostOfReservation(Reservations reservations) {
        return null;
    }

    @Override
    public boolean capacityMatch(Reservations reservations) {
        return false;
    }
}
