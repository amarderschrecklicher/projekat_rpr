package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.Property;
import com.sun.jdi.DoubleValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class property implements Initializable {


    public VBox vBox;
    public TextField propertyNname;
    public TextField propertyType;
    public TextArea propertyName;
    public ChoiceBox capacity;
    public ChoiceBox bathrooms;
    public ChoiceBox kitchens;
    
    public DatePicker date;
    public TextField price;
    public Button applyDate;
    public TextField country;
    public TextField location;
    public Button cancel;
    public Button apply;
    public RadioButton buttonNo;
    public RadioButton buttonYes;


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
        propertyNname.setFocusTraversable(false);
        propertyType.setFocusTraversable(false);
        propertyName.setFocusTraversable(false);
        capacity.setFocusTraversable(false);
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
    }

    public void cancelButton(ActionEvent actionEvent) {
        final Stage login=(Stage) vBox.getScene().getWindow();
        login.hide();
    }

    public void applyButton(ActionEvent actionEvent) {
        if(!propertyNname.getText().isEmpty() && !propertyType.getText().isEmpty()
        && !location.getText().isEmpty() && !country.getText().isEmpty() && !price.getText().isEmpty()
        && capacity.isShowing() && kitchens.isShowing() && bathrooms.isShowing())
        {
            Property p = new Property();
            p.setPropertyName(propertyName.getText());
            p.setPropertyType(propertyType.getText());
            p.setLocation(location.getText()+", "+country.getText());
            p.setKitchens(Integer.valueOf(kitchens.getId()));
            p.setBathrooms(Integer.valueOf(bathrooms.getId()));
            p.setPrice(Double.valueOf(price.getText()));
        }
    }

    public void yes(ActionEvent actionEvent) {
    }

    public void no(ActionEvent actionEvent) {
    }
}
