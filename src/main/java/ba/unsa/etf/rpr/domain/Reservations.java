package ba.unsa.etf.rpr.domain;

import java.util.Objects;
import java.sql.Date;

public class Reservations implements Idable {

    private int id;
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
        return id == that.id  && guestID == that.guestID && propertyID == that.propertyID && reservationDate.equals(that.reservationDate) && dateIn.equals(that.dateIn) && dateOut.equals(that.dateOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,  guestID, propertyID, reservationDate, dateIn, dateOut);
    }
}
