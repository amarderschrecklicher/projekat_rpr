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

    @FXML
    public Label hiUser;

    @FXML
    public ListView<String> listProperty;
    @FXML
    public BorderPane scenePn;
    public GridPane grdPn;

    FXMLLoader transition(String whereTo, String title) throws IOException {
        final Stage login = (Stage) scenePn.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(whereTo));
        loader.load();
        stage.setTitle(title);
        stage.getIcons().add(new Image(""));
        stage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();

        return loader;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void hostInfoA(ActionEvent actionEvent) {
    }

    public void logOutA(ActionEvent actionEvent) throws IOException {
        transition("/fxml/login.fxml", "LOGIN");
    }

    public void aboutA(ActionEvent actionEvent) {
    }

    public void newPropertyA(ActionEvent actionEvent) throws IOException, Exceptionss {
        transition("/fxml/property.fxml", "NEW PROPERTY");

    }

    public void editPropertyA(ActionEvent actionEvent) {
    }

    public void helpA(ActionEvent actionEvent) {
    }

}