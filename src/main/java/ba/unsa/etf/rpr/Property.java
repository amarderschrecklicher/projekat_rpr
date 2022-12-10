package ba.unsa.etf.rpr;

public class Property {

    private int id;
    private String propertyType;
    private int beds;
    private int bathrooms;
    private int kitchens;
    private String location;
    private boolean acH;
    private double price;

    public int getId() {
        return id;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public int getBeds() {
        return beds;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getKitchens() {
        return kitchens;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAcH() {
        return acH;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setKitchens(int kitchens) {
        this.kitchens = kitchens;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAcH(boolean acH) {
        this.acH = acH;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", propertyType='" + propertyType + '\'' +
                ", beds=" + beds +
                ", bathrooms=" + bathrooms +
                ", kitchens=" + kitchens +
                ", location='" + location + '\'' +
                ", acH=" + acH +
                ", price=" + price +
                '}';
    }
}
