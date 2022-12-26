package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Controller3 extends Controller implements Initializable {

    private ObservableList<String> obsList;
    @FXML
    public ListView<String> listProperty;
    @FXML
    public BorderPane scenePn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Property> listP= null;
        try {
            listP = DaoFactory.propertyDao().hostProperties(hostGive());
        } catch (Exceptionss e) {
            throw new RuntimeException(e);
        }

        if( !listP.isEmpty()) {
            String[]a;int i=0;
            for(Property p:listP)a[i]=p.getPropertyType().toString();
            for(Property p:listP)
            listProperty.getItems().add(p.toString());
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

 */

    }

    public void userHi(InputMethodEvent inputMethodEvent) {
    }


}
