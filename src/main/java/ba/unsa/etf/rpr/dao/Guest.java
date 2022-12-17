package ba.unsa.etf.rpr.dao;

import java.util.Objects;

public class Guest {

    private int id;
    private String name;

    private int numberOfGuests;

    private String guestNumber;
    private String country;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getGuestNumber() {
        return guestNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setGuestNumber(String guestNumber) {
        this.guestNumber = guestNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfGuests=" + numberOfGuests +
                ", guestNumber='" + guestNumber + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return id == guest.id && numberOfGuests == guest.numberOfGuests && name.equals(guest.name) && guestNumber.equals(guest.guestNumber) && country.equals(guest.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfGuests, guestNumber, country);
    }
}
