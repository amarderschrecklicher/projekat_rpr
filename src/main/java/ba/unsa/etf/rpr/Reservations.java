package ba.unsa.etf.rpr;

import java.util.Objects;
import java.util.Date;

public class Reservations {

    private int id;
    private int hostID;
    private int guestID;
    private int propertyID;
    private Date reservationDate;
    private Date dateIn;
    private Date dateOut;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "id=" + id +
                ", hostID=" + hostID +
                ", guestID=" + guestID +
                ", propertyID=" + propertyID +
                ", reservationDate=" + reservationDate +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservations that = (Reservations) o;
        return id == that.id && hostID == that.hostID && guestID == that.guestID && propertyID == that.propertyID && reservationDate.equals(that.reservationDate) && dateIn.equals(that.dateIn) && dateOut.equals(that.dateOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hostID, guestID, propertyID, reservationDate, dateIn, dateOut);
    }
}
