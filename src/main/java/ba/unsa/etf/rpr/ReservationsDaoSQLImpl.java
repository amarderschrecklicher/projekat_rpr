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
