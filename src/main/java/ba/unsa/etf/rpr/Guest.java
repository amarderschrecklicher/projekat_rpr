package ba.unsa.etf.rpr;

import java.util.Objects;

public class Guest {

    private int id;
    private String name;
    private int guestNumber;
    private String email;
    private String country;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGuestNumber() {
        return guestNumber;
    }

    public String getEmail() {
        return email;
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

    public void setGuestNumber(int guestNumber) {
        this.guestNumber = guestNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", guestNumber=" + guestNumber +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return id == guest.id && guestNumber == guest.guestNumber && name.equals(guest.name) && email.equals(guest.email) && country.equals(guest.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, guestNumber, email, country);
    }
}
