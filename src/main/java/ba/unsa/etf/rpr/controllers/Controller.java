package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


public class Controller {

    private final Host host = new Host();
    @FXML
    public Button closeButton;
    @FXML
    public Button signIn;
    @FXML
    public GridPane scenePane;
    public Button signUp;
    @FXML
    private PasswordField passWord;
    @FXML
    public TextField userName;

    public TableColumn<Host, String> idColumn;
    public TableColumn<Host, String> nameColumn;
    public TableColumn<Host, Date> numberColumn;
    public TableColumn<Host, Integer> emailColumn;


    Connection con;
    PreparedStatement ps;
    ResultSet  rez;

    public void click(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("haloooo!");

        alert.showAndWait();

    }
    public void click1(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, Exceptionss, IOException {
        String user = userName.getText(), pass = passWord.getText();
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);

        if(user.equals("") || pass.equals("") ){
            alert1.setTitle("Error");alert1.setHeaderText(null);
            alert1.setContentText("Username or password blank!");
            alert1.showAndWait();
        }
        else {
            host.setName(user);
            host.setNumber(pass);
            if(DaoFactory.HostDao().searchHost(host)){
                final Stage login=(Stage) scenePane.getScene().getWindow();
                Stage  stage=new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signUp.fxml"));
                loader.load();
                stage.setTitle("SIGN UP");
                stage.setScene(new Scene(loader.getRoot(),USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
                stage.show();
                login.hide();

            }
            else {
                alert1.setTitle("Error");alert1.setHeaderText(null);
                alert1.setContentText("Username or password wrong!");
                alert1.showAndWait();
            }

        }

    }
    public void click2(ActionEvent actionEvent) throws IOException {
    final Stage login=(Stage) scenePane.getScene().getWindow();
    Stage  stage=new Stage();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signUp.fxml"));
    loader.load();
    stage.setTitle("SIGN UP");
    stage.setScene(new Scene(loader.getRoot(),USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
    userName.requestFocus();
    stage.show();
    login.hide();
    }

    @FXML
    public void initialize() {
        
        userName.textProperty().addListener((obs,stara,nova)->{
            if(userName.getText().isEmpty()){
                userName.getStyleClass().removeAll("Ispravno");
                userName.getStyleClass().add("Neispravno");
            }else{
                userName.getStyleClass().removeAll("Neispravno");
                userName.getStyleClass().add("Ispravno");
            }
        });

        passWord.textProperty().addListener((obs,stara,nova)->{
            if(passWord.getText().isEmpty()){
                passWord.getStyleClass().removeAll("Ispravno");
                passWord.getStyleClass().add("Neispravno");
            }else{
                passWord.getStyleClass().removeAll("Neispravno");
                passWord.getStyleClass().add("Ispravno");
            }
        });
    }

    public void actionLoginBtn(ActionEvent actionEvent){

        System.out.println("Amar");

    }

    public void click3(ActionEvent actionEvent) {
        Stage stage=(Stage) scenePane.getScene().getWindow();
        stage.close();

    }


}
