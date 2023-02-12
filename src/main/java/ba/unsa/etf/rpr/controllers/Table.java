package ba.unsa.etf.rpr.controllers;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Table {

    private SimpleStringProperty resId;
    private SimpleStringProperty guestName;
    private SimpleStringProperty nmbGuests;
    private SimpleStringProperty dateIn;
    private SimpleStringProperty dateOut;
    private SimpleStringProperty dateRes;
    private SimpleStringProperty totalPrice;

    Table(String a, String b, String c, String d, String e, String f, String g){
        this.resId = new SimpleStringProperty(a);
        this.guestName = new SimpleStringProperty(b);
        this.nmbGuests = new SimpleStringProperty(c);
        this.dateIn = new SimpleStringProperty(d);
        this.dateOut = new SimpleStringProperty(e);
        this.dateRes = new SimpleStringProperty(f);
        this.totalPrice = new SimpleStringProperty(g);

    }

    public String getResId() {
        return resId.get();
    }

    public SimpleStringProperty resIdProperty() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId.set(resId);
    }

    public String getGuestName() {
        return guestName.get();
    }

    public SimpleStringProperty guestNameProperty() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName.set(guestName);
    }

    public String getNmbGuests() {
        return nmbGuests.get();
    }

    public SimpleStringProperty nmbGuestsProperty() {
        return nmbGuests;
    }

    public void setNmbGuests(String nmbGuests) {
        this.nmbGuests.set(nmbGuests);
    }

    public String getDateIn() {
        return dateIn.get();
    }

    public SimpleStringProperty dateInProperty() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn.set(dateIn);
    }

    public String getDateOut() {
        return dateOut.get();
    }

    public SimpleStringProperty dateOutProperty() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut.set(dateOut);
    }

    public String getDateRes() {
        return dateRes.get();
    }

    public SimpleStringProperty dateResProperty() {
        return dateRes;
    }

    public void setDateRes(String dateRes) {
        this.dateRes.set(dateRes);
    }

    public String getTotalPrice() {
        return totalPrice.get();
    }

    public SimpleStringProperty totalPriceProperty() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice.set(totalPrice);
    }
}
