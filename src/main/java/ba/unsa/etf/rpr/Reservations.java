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

    public void setStayNights(int stayNights) {
        this.stayNights = stayNights;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "id=" + id +
                ", reservationDate='" + reservationDate + '\'' +
                ", dateOfArrival='" + dateOfArrival + '\'' +
                ", stayNights=" + stayNights +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservations that = (Reservations) o;
        return id == that.id && stayNights == that.stayNights && reservationDate.equals(that.reservationDate) && dateOfArrival.equals(that.dateOfArrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservationDate, dateOfArrival, stayNights);
    }
}
