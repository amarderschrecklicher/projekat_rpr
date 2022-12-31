package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class host extends login implements Initializable {

    public Label hiUser;
    private ObservableList<String> obsList;
    @FXML
    public ListView<String> listProperty;
    @FXML
    public BorderPane scenePn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Host hostForHi=hostGive();

        String Welcome;Welcome="Hi, ";int i=0;
        while(hostForHi.getName().charAt(i)!=' ') {
            Welcome+=hostForHi.getName().charAt(i);i++;}
        Welcome+=" !";
        hiUser.setText(Welcome);

        List<Property> listP= null;
        try {
            listP = DaoFactory.propertyDao().hostProperties(hostGive());
        } catch (Exceptionss e) {
            throw new RuntimeException(e);
        }

        if( !listP.isEmpty()) {
            String[]a = new String[1]; i=0;
            for(Property p:listP){a[i]=p.getPropertyName()+"   :"+p.getPropertyType();i++;}
            listProperty.getItems().addAll(a);
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
