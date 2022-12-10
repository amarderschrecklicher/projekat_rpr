package ba.unsa.etf.rpr;

import java.util.Objects;

public class Reservations {

    private int id;
    private String reservationDate;
    private String dateOfArrival;
    private int stayNights;

    public int getId() {
        return id;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public int getStayNights() {
        return stayNights;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
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
