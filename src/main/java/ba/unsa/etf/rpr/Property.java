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
}
