package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


public class HostController extends LoginController implements Initializable {

    public static Host HOST = lHOST;

    public static Property PROPERTY = new Property();

    @FXML
    public Label hiUser;

    @FXML
    public ListView<String> listProperty;
    @FXML
    public BorderPane scenePn;
    @FXML
    public Button info;
    @FXML
    public Button update;

    public GridPane grdPn;

    Stage sTransition(String whereTo, String title,Object control) throws IOException {
        final Stage login = (Stage) scenePn.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(whereTo));
        loader.setController(control);
        loader.load();
        stage.setTitle(title);
        stage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
        return stage;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        update.setDisable(true);
        info.setDisable(true);

        if(listProperty.isPressed()){
            update.setDisable(false);
            info.setDisable(false);

        }

    }


    public void hostInfoA(ActionEvent actionEvent) {
    }

    public void logOutA(ActionEvent actionEvent) throws IOException {
        Stage s =sTransition("/fxml/login.fxml", "LOGIN",new LoginController());
        s.getIcons().add(new Image("/icons/login_icon.png"));
    }

    public void aboutA(ActionEvent actionEvent) {
    }

    public void newPropertyA(ActionEvent actionEvent) throws IOException, Exceptionss {
        Stage s = sTransition("/fxml/property.fxml", "NEW PROPERTY",new PropertyController());
        s.getIcons().add(new Image("/icons/property_icon.png"));
    }

    public void infoProperty(ActionEvent actionEvent) throws IOException, Exceptionss {
        String st = String.valueOf(listProperty.getSelectionModel());
        st = st.trim();
        ArrayList<Property> l = (ArrayList<Property>) DaoFactory.propertyDao().hostProperties(HOST);
        for(Property p : l){
            if(p.getPropertyName().equals(st)){
                PROPERTY = p; break;
            }
        }
        Stage s = sTransition("/fxml/reservations.fxml", "PROPERTY INFO",new ReservationsController());
    }
    public void updateProperty(ActionEvent actionEvent) {
    }

    public void helpA(ActionEvent actionEvent) {
    }
    public void editPropertyA(ActionEvent actionEvent) {
    }


}