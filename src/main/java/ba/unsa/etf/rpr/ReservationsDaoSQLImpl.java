package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;

public class ReservationsDaoSQLImpl implements ReservationsDAO{
    private Connection connection;

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
        return false;
    }
}
