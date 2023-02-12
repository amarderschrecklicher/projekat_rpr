package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Guest;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReservationsDaoSQLImpl extends AbstractDao<Reservations> implements ReservationsDAO{
    private Connection connection;

    public ReservationsDaoSQLImpl() {
        super("Reservations");
    }

    @Override
    public Reservations row2object(ResultSet rs) throws Exceptionss, SQLException {
        try{
        Reservations q = new Reservations();
        q.setId(rs.getInt(1));
        q.setGuestID(rs.getInt(4));
        q.setPropertyID(rs.getInt(5));
        q.setReservationDate(rs.getDate(6));
        q.setDateIn(rs.getDate(2));
        q.setDateOut(rs.getDate(3));
        return q;
    } catch (Exception e) {
        throw new Exceptionss(e.getMessage(), e);
    }
    }

    @Override
    public Map<String, Object> object2row(Reservations object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id", object.getId());
        row.put("guestId",object.getGuestID());
        row.put("propertyId",object.getPropertyID());
        row.put("reservationDate",object.getReservationDate());
        row.put("dateIn",object.getDateIn());
        row.put("dateOut",object.getDateOut());
        return row;
    }



    @Override
    public int nightsOfStay(int idReservation) {
        String query = "SELECT dateIn,dateOut FROM Reservations WHERE idreservations = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, idReservation);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                Date dateIn = rs.getDate(6);
                Date dateOut = rs.getDate(7);

                return (int) ChronoUnit.DAYS.between((Temporal) dateIn, (Temporal) dateOut);
            }
            else {
                return 0; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }

        return 0;

    }
/*
    @Override
    public List<Reservations> allOfReseravtions(Guest guest) {
        String query = "SELECT * FROM Reservations WHERE GuestID = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, guest.getId());
            ResultSet rs = stmt.executeQuery();
            List<Reservations> res = null;
            if(rs.next()) {
                Reservations rez=new Reservations();
                rez.setId(rs.getInt(1));
                rez.setHostID(rs.getInt(2));
                rez.setGuestID(rs.getInt(3));
                rez.setPropertyID(rs.getInt(4));
                rez.setReservationDate(rs.getDate(5));
                rez.setDateIn(rs.getDate(6));
                rez.setDateOut(rs.getDate(7));
                res.add(rez);
            }
            else {
                return null; // if there is no elements in the result set return null
            }

            return res;
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }


        return null;
    }
    */


    @Override
    public Property propertyDetails(int idReservation) {
        String query = "SELECT * FROM Reservations WHERE idReservationss = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, idReservation);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
            query="SELECT * FROM Property WHERE PropertyID = ?";
            stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, rs.getInt(4));
            ResultSet rs2=stmt.executeQuery();
            if(rs2.next()) {
                Property property =new Property();
                property.setId(rs2.getInt(1));
                property.setPropertyType(rs2.getString(2));
                property.setCapacity(rs2.getInt(3));
                property.setBathrooms(rs2.getInt(4));
                property.setKitchens(rs2.getInt(5));
                property.setLocation(rs2.getString(6));
                property.setAcH(rs2.getBoolean(7));
                property.setPrice(rs2.getDouble(8));
                return property;
            }

            }
            else {
                return null; // if there is no elements in the result set return null
            }

        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }

        return null;
    }

    @Override
    public Host hostOfReservation(int idReservation) {
        String query = "SELECT * FROM Reservations WHERE idReservationss = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, idReservation);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                query="SELECT * FROM Host WHERE idHost = ?";
                stmt = this.connection.prepareStatement(query);
                stmt.setInt(1, rs.getInt(2));
                ResultSet rs2=stmt.executeQuery();
                if(rs2.next()) {
                    Host host =new Host();
                    host.setId(rs2.getInt(1));
                    host.setName(rs2.getString(2));
                    host.setNumber(rs2.getString(3));
                    host.setEmail(rs2.getString(4));
                    return host;
                }

            }
            else {
                return null; // if there is no elements in the result set return null
            }

        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }


        return null;
    }

    @Override
    public boolean capacityMatch(int idReservation) {
        String query = "SELECT * FROM Reservations WHERE idReservationss = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, idReservation);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                query="SELECT * FROM Guest WHERE idGuest = ?";
                stmt = this.connection.prepareStatement(query);
                stmt.setInt(1, rs.getInt(3));
                ResultSet rs2=stmt.executeQuery();
                if(rs2.next()) {
                    query="SELECT * FROM Property WHERE PropertyID = ?";
                    stmt = this.connection.prepareStatement(query);
                    stmt.setInt(1, rs.getInt(4));
                    ResultSet rs3=stmt.executeQuery();

                if(rs3.next()) {
                    return rs3.getInt(3) == rs2.getInt(3);
                }
                else {
                    return false; // if there is no elements in the result set return null
                }

                }
                else {
                    return false; // if there is no elements in the result set return null
                }
            }
            else {
                return false; // if there is no elements in the result set return null
            }

        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }


        return false;
    }
}
