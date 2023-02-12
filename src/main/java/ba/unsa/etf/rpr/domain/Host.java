package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Host implements Idable {

    private int id;
    private String name;
    private String number;
    private String email;

    public Host(){

    }

   public Host (String name,String number,String email){
        this.id = -1;
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Host{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Host host = (Host) o;
        return id == host.id && name.equals(host.name) && number.equals(host.number) && email.equals(host.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, email);
    }
}
