package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Date;
import java.text.SimpleDateFormat;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class PropertyController implements Initializable {


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
    public Spinner people;
    public Spinner bathrooms;
    public Spinner kitchens;
    public Label DATE ;


    FXMLLoader transition(String whereTo , String title) throws IOException {
        final Stage login=(Stage) vBox.getScene().getWindow();
        Stage  stage=new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(whereTo));
        loader.load();
        stage.setTitle(title);
        stage.setScene(new Scene(loader.getRoot(),USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();
        login.hide();

        return loader;
    }

    public void applyDateButton(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(DATE.getText().equals(""))
        { SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date currDate = new Date();
        DATE.setText(formatter.format(currDate));}

        propertyNname.setFocusTraversable(false);
        propertyType.setFocusTraversable(false);
        DATE.setFocusTraversable(false);
        people.setFocusTraversable(false);
        bathrooms.setFocusTraversable(false);
        kitchens.setFocusTraversable(false);
        date.setFocusTraversable(false);
        price.setFocusTraversable(false);
        country.setFocusTraversable(false);
        location.setFocusTraversable(false);
        apply.setFocusTraversable(false);
        applyDate.setFocusTraversable(false);
        buttonNo.setFocusTraversable(false);
        buttonYes.setFocusTraversable(false);
        cancel.setFocusTraversable(false);

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
        });       propertyNname.textProperty().addListener((obs,stara,nova)->{
            if(propertyNname.getText().isEmpty()){
                propertyNname.getStyleClass().removeAll("Ispravno");
                propertyNname.getStyleClass().add("Neispravno");
            }else{
                propertyNname.getStyleClass().removeAll("Neispravno");
                propertyNname.getStyleClass().add("Ispravno");
            }
        });        propertyNname.textProperty().addListener((obs,stara,nova)->{
            if(propertyNname.getText().isEmpty()){
                propertyNname.getStyleClass().removeAll("Ispravno");
                propertyNname.getStyleClass().add("Neispravno");
            }else{
                propertyNname.getStyleClass().removeAll("Neispravno");
                propertyNname.getStyleClass().add("Ispravno");
            }
        });        propertyNname.textProperty().addListener((obs,stara,nova)->{
            if(propertyNname.getText().isEmpty()){
                propertyNname.getStyleClass().removeAll("Ispravno");
                propertyNname.getStyleClass().add("Neispravno");
            }else{
                propertyNname.getStyleClass().removeAll("Neispravno");
                propertyNname.getStyleClass().add("Ispravno");
            }
        });







    }

    public void cancelButton(ActionEvent actionEvent) {
        final Stage login=(Stage) vBox.getScene().getWindow();
        login.hide();
    }

    public void applyButton(ActionEvent actionEvent) throws Exceptionss, IOException {
        if(!propertyNname.getText().isEmpty() && !propertyType.getText().isEmpty()
        && !location.getText().isEmpty() && !country.getText().isEmpty() && !price.getText().isEmpty()
        && Integer.parseInt(people.getPromptText())>0 && Integer.parseInt(kitchens.getPromptText())>0 && Integer.parseInt(bathrooms.getPromptText())>0)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/host.fxml"));
            loader.load();
            HostController set= loader.getController();

            Property p = new Property();
            p.setHostId(set.HOST.getId());
            p.setPropertyName(propertyName.getText());
            p.setPropertyType(propertyType.getText());
            p.setLocation(location.getText()+", "+country.getText());
            p.setCapacity(Integer.parseInt(people.getPromptText()));
            p.setKitchens(Integer.parseInt(kitchens.getPromptText()));
            p.setBathrooms(Integer.parseInt(bathrooms.getPromptText()));
            p.setPrice(Double.parseDouble(price.getText()));

            ArrayList<Property> list = (ArrayList<Property>) DaoFactory.propertyDao().getAll(); boolean b = true;
            for(Property x : list){
                if(p.getPropertyName().equals(x.getPropertyName()) || p.getLocation().equals(x.getLocation())){
                    b=false; p.setId(x.getId()); break; }}

            if(b)DaoFactory.propertyDao().add(p);
            else DaoFactory.propertyDao().update(p);

        }
        else {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error");alert1.setHeaderText(null);
            alert1.setContentText("Invalid info");
            alert1.showAndWait();
        }
    }

    public void yes(ActionEvent actionEvent) {
    }

    public void no(ActionEvent actionEvent) {
    }
}
