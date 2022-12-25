package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.HostDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Controller2 {

    public Button signUpBtn;
    public TextField nameHost;
    public TextField surnameHost;
    public TextField numberHost;
    public TextField emailHost;
    @FXML
    private GridPane scenePanee;

    @FXML
    public void initialize() {

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
    }


    public void back(ActionEvent actionEvent) throws IOException {
        final Stage login=(Stage) scenePanee.getScene().getWindow();
        Stage  stage=new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/fxmly.fxml"));
        loader.load();
        stage.setTitle("EXTRANET");
        stage.setScene(new Scene(loader.getRoot(),USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();
        login.hide();
    }

    public void close(ActionEvent actionEvent) {
        Stage stage=(Stage) scenePanee.getScene().getWindow();
        stage.close();
    }

    public void signUP(ActionEvent actionEvent) throws Exceptionss {
        Host host =new Host();
        host.setName(nameHost.getText()+surnameHost.getText());
        host.setEmail(emailHost.getText());
        host.setId(DaoFactory.HostDao().getAll().size()+1);
        host.setNumber(numberHost.getText());
        DaoFactory.HostDao().add(host);
    }
}
