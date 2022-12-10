package ba.unsa.etf.rpr;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return id == property.id && beds == property.beds && bathrooms == property.bathrooms && kitchens == property.kitchens && acH == property.acH && Double.compare(property.price, price) == 0 && propertyType.equals(property.propertyType) && location.equals(property.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propertyType, beds, bathrooms, kitchens, location, acH, price);
    }
}
