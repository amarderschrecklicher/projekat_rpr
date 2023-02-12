package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Property implements Idable {

    private int id;
    private int hostId;
    private String propertyName;
    private String propertyType;
    private int capacity;
    private int bathrooms;
    private int kitchens;
    private String location;
    private boolean acH;
    private double price;

    public Property(){

    }

    public Property(String propertyName,String propertyType,int capacity,
                    int bathrooms,int kitchens,String location,boolean acH,double price){
        this.id = -1;
        this.propertyName = propertyName;
        this.capacity = capacity;
        this.bathrooms = bathrooms;
        this.kitchens = kitchens;
        this.location=location;
        this.acH = acH;
        this.price=price;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getKitchens() {
        return kitchens;
    }

    public void setKitchens(int kitchens) {
        this.kitchens = kitchens;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAcH() {
        return acH;
    }

    public void setAcH(boolean acH) {
        this.acH = acH;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", hostId=" + hostId +
                ", propertyName='" + propertyName + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", capacity=" + capacity +
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
        return id == property.id && hostId == property.hostId && capacity == property.capacity && bathrooms == property.bathrooms && kitchens == property.kitchens && acH == property.acH && Double.compare(property.price, price) == 0 && propertyName.equals(property.propertyName) && propertyType.equals(property.propertyType) && location.equals(property.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hostId, propertyName, propertyType, capacity, bathrooms, kitchens, location, acH, price);
    }
}
