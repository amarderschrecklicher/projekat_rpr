package ba.unsa.etf.rpr;

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
}
