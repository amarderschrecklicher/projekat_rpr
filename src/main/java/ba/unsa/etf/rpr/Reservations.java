package ba.unsa.etf.rpr;

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
}
