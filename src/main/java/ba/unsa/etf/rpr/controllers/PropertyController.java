package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class PropertyController extends HostController implements Initializable {


    public VBox vBox;
    public TextField propertyNname;
    public TextField propertyType;
    public TextArea propertyName;
    
    public DatePicker date;
    public TextField price;
    public Button applyDate;
    public TextField country;
    public TextField location;
    public Button cancel;
    public Button apply;
    public RadioButton buttonNo;
    public RadioButton buttonYes;
    public Spinner<Integer> people;
    public Spinner<Integer> bathrooms;
    public Spinner<Integer> kitchens;
    public Label DATE ;

    public DatePicker fromDate;
    public DatePicker toDate;

    public ArrayList<LocalDate> fromDates = new ArrayList<LocalDate>();
    public ArrayList<LocalDate> toDates = new ArrayList<LocalDate>();

    public Property p = new Property();


    /**
     * method for transiting through Controllers
     */

    Stage sTransition(String whereTo, String title, Object control) throws IOException {
        final Stage login = (Stage) vBox.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(whereTo));
        loader.setController(control);
        loader.load();
        stage.setTitle(title);
        stage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
        login.hide();
        return stage;
    }


    /**
     * adding available dates to Property
     */

    public void applyDateButton(ActionEvent actionEvent) throws Exceptionss {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        LocalDate from = fromDate.getValue();
        LocalDate to = toDate.getValue();

        if(from.isBefore(LocalDate.now()) || to.isBefore(LocalDate.now()) || to.isBefore(from) || from.isAfter(to)){
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid date!");
            alert.showAndWait();
        }
        else {

            Reservations r = new Reservations();
            r.setDateIn(Date.valueOf(from));
            r.setDateOut(Date.valueOf(to));
            r.setPropertyID(p.getId());
            r.setReservationDate(Date.valueOf(LocalDate.now()));
            r.setGuestID(0);
            DaoFactory.reservationsDao().add(r);
            fromDates.add(from);
            toDates.add(to);

            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Date added!");
            alert.showAndWait();

    }
    }

    /**
     * initialize method, setting up Sppiners
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(PROPERTY!=null ){
            SpinnerValueFactory<Integer> spnr1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
            spnr1.setValue(PROPERTY.getCapacity());
            SpinnerValueFactory<Integer> spnr2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
            spnr2.setValue(PROPERTY.getBathrooms());
            SpinnerValueFactory<Integer> spnr3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
            spnr3.setValue(PROPERTY.getKitchens());
            apply.setText("Update");
            propertyNname.setText(PROPERTY.getPropertyName());
            propertyType.setText(PROPERTY.getPropertyType());
            location.setText(PROPERTY.getLocation().split(",")[0]);
            country.setText(PROPERTY.getLocation().split(",")[1].substring(1));
            price.setText(String.valueOf(PROPERTY.getPrice()));
            people.setValueFactory(spnr1);
            bathrooms.setValueFactory(spnr2);
            kitchens.setValueFactory(spnr3);
            if(PROPERTY.isAcH())
            buttonYes.selectedProperty();
        }


        if(DATE.getText().equals(""))
        { SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date currDate = new java.util.Date();
        DATE.setText(formatter.format(currDate));}

        if(apply.getText().equals("Apply")) {
            applyDate.setDisable(true);
            fromDate.setDisable(true);
            toDate.setDisable(true);
        }

        SpinnerValueFactory<Integer> spnr1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        spnr1.setValue(1);
        SpinnerValueFactory<Integer> spnr2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        spnr2.setValue(1);
        SpinnerValueFactory<Integer> spnr3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        spnr3.setValue(1);
        people.setValueFactory(spnr1);
        bathrooms.setValueFactory(spnr2);
        kitchens.setValueFactory(spnr3);

        DATE.setFocusTraversable(true);


        propertyNname.textProperty().addListener((obs,stara,nova)->{
            if(propertyNname.getText().isEmpty()){
                propertyNname.getStyleClass().removeAll("Ispravno");
                propertyNname.getStyleClass().add("Neispravno");
            }else{
                propertyNname.getStyleClass().removeAll("Neispravno");
                propertyNname.getStyleClass().add("Ispravno");
            }
        });
        propertyType.textProperty().addListener((obs,stara,nova)->{
            if(propertyType.getText().isEmpty()){
                propertyType.getStyleClass().removeAll("Ispravno");
                propertyType.getStyleClass().add("Neispravno");
            }else{
                propertyType.getStyleClass().removeAll("Neispravno");
                propertyType.getStyleClass().add("Ispravno");
            }
        });
        price.textProperty().addListener((obs,stara,nova)->{
            if(price.getText().isEmpty()){
                price.getStyleClass().removeAll("Ispravno");
                price.getStyleClass().add("Neispravno");
            }else{
                price.getStyleClass().removeAll("Neispravno");
                price.getStyleClass().add("Ispravno");
            }
        });        country.textProperty().addListener((obs,stara,nova)->{
            if(country.getText().isEmpty()){
                country.getStyleClass().removeAll("Ispravno");
                country.getStyleClass().add("Neispravno");
            }else{
                country.getStyleClass().removeAll("Neispravno");
                country.getStyleClass().add("Ispravno");
            }
        });        location.textProperty().addListener((obs,stara,nova)->{
            if(location.getText().isEmpty()){
                location.getStyleClass().removeAll("Ispravno");
                location.getStyleClass().add("Neispravno");
            }else{
                location.getStyleClass().removeAll("Neispravno");
                location.getStyleClass().add("Ispravno");
            }
        });

    }

    /**
     * going back to HostController
     */
    public void cancelButton(ActionEvent actionEvent) throws IOException {
        setHOST(HOST);
        Stage s = sTransition("/fxml/host.fxml", "Login",new HostController());
        s.setTitle("USER");
        s.getIcons().add(new Image("/icons/host_icon.png"));

    }

    /**
     * adding new Property
     */
    public void applyButton(ActionEvent actionEvent) throws Exceptionss, IOException {

        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);

        if (!propertyNname.getText().isEmpty() && !propertyType.getText().isEmpty()
                && !location.getText().isEmpty() && !country.getText().isEmpty() && !price.getText().isEmpty()) {

            p.setHostId(HOST.getId());
            p.setPropertyName(propertyNname.getText());
            p.setPropertyType(propertyType.getText());
            p.setLocation(location.getText() + ", " + country.getText());
            p.setCapacity(people.getValue());
            p.setKitchens(kitchens.getValue());
            p.setBathrooms(bathrooms.getValue());
            p.setPrice(Double.parseDouble(price.getText()));
            p.setAcH(buttonYes.isSelected());
            ArrayList<Property> list = (ArrayList<Property>) DaoFactory.propertyDao().getAll();
            boolean b = true;
            int id = 0;
            for (Property x : list) {
                if (p.getPropertyName().equals(x.getPropertyName()) || p.getLocation().equals(x.getLocation())) {
                    b = false;
                    p.setId(x.getId());
                    break;
                }
                id = x.getId();
            }



            if (b || apply.getText().equals("Update")) {
                if(apply.getText().equals("Update")){
                    DaoFactory.propertyDao().update(p);
                }
                else {
                    DaoFactory.propertyDao().add(p);
                }
                alert1.setTitle("Success");
                alert1.setHeaderText(null);

                if(apply.getText().equals("Update")){
                    alert1.setContentText("Successfully updated property!");
                } else {
                    alert1.setContentText("Successfully added property!");
                }
                alert1.showAndWait();
                apply.setText("Update");
                applyDate.setDisable(false);
                fromDate.setDisable(false);
                toDate.setDisable(false);
                p.setId(id+1);

            } else {

                alert1.setTitle("Property exists");
                alert1.setHeaderText(null);
                alert1.setContentText("Property already exists!");
                alert1.showAndWait();

            }
        }
        else {
        alert1.setTitle("Error");
        alert1.setHeaderText(null);
        alert1.setContentText("Invalid info");
        alert1.showAndWait();}
    }

    public void yes(ActionEvent actionEvent) {
    }

    public void no(ActionEvent actionEvent) {
    }
}
