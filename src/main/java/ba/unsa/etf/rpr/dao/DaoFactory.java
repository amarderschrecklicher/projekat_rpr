package ba.unsa.etf.rpr.dao;

public class DaoFactory {
    private static final GuestDAO guestDao = new GuestDaoSQLImpl();
    private static final HostDAO hostDao = new HostDaoSQLImpl();
    private static final PropertyDAO propertyDao = new PropertyDaoSQLImpl();

    private static final ReservationsDAO reservationsDao = new ReservationsDaoSQLImpl();

    private DaoFactory(){
    }

    public static GuestDAO GuestDao(){
        return guestDao;
    }

    public static HostDAO HostDao(){
        return hostDao;
    }

    public static PropertyDAO propertyDao(){
        return propertyDao;
    }

    public static ReservationsDAO reservationsDao(){
        return reservationsDao;
    }

}
