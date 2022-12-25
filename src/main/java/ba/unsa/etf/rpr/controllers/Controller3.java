package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


public class Controller3 extends Controller {

    public ListView listProperty;
    private Property property = new Property();
    public BorderPane scenePn;

    @FXML
    public void initialize() throws Exceptionss, IOException {

        Host host=hostGive();

        List<Property> listP=DaoFactory.propertyDao().hostProperties(host);

        if( !listP.isEmpty()) {

            ObservableList list1 = (ObservableList) listP;
            listProperty.setItems(list1);
        }
/*
        nameHost.textProperty().addListener((obs,stara,nova)->{
            if(nameHost.getText().isEmpty()){
                nameHost.getStyleClass().removeAll("Ispravno");
                nameHost.getStyleClass().add("Neispravno");
            }else{
                nameHost.getStyleClass().removeAll("Neispravno");
                nameHost.getStyleClass().add("Ispravno");
            }
        });

        surnameHost.textProperty().addListener((obs,stara,nova)->{
            if(surnameHost.getText().isEmpty()){
                surnameHost.getStyleClass().removeAll("Ispravno");
                surnameHost.getStyleClass().add("Neispravno");
            }else{
                surnameHost.getStyleClass().removeAll("Neispravno");
                surnameHost.getStyleClass().add("Ispravno");
            }
        });

        numberHost.textProperty().addListener((obs,stara,nova)->{
            if(numberHost.getText().isEmpty()){
                numberHost.getStyleClass().removeAll("Ispravno");
                numberHost.getStyleClass().add("Neispravno");
            }else{
                numberHost.getStyleClass().removeAll("Neispravno");
                numberHost.getStyleClass().add("Ispravno");
            }
        });

        emailHost.textProperty().addListener((obs,stara,nova)->{
            if(emailHost.getText().isEmpty()){
                emailHost.getStyleClass().removeAll("Ispravno");
                emailHost.getStyleClass().add("Neispravno");
            }else{
                emailHost.getStyleClass().removeAll("Neispravno");
                emailHost.getStyleClass().add("Ispravno");
            }
        });
   */ }



    public void userHi(InputMethodEvent inputMethodEvent) {
    }

}
