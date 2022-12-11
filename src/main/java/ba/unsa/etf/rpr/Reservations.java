package ba.unsa.etf.rpr;

import java.util.Objects;
import java.util.Date;

public class Reservations {

    private int id;
    private Date reservationDate;
    private Date dateIn;
    private Date dateOut;

    public int getId() {
        return id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setDateOfArrival(Date dateIn) {
        this.dateIn = dateIn;
    }

    public void setStayNights(Date dateOut) {
        this.dateOut= dateOut;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "id=" + id +
                ", reservationDate='" + reservationDate + '\'' +
                ", dateIn='" + dateIn + '\'' +
                ", dateOut=" + dateOut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservations that = (Reservations) o;
        return id == that.id && dateOut == that.dateOut && reservationDate.equals(that.reservationDate) && dateIn.equals(that.dateIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservationDate, dateIn, dateOut);
    }
}
