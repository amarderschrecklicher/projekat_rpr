package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


public class login  implements Initializable {

    private  Host host = new Host();
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
             host=DaoFactory.HostDao().getByNumber(pass);

            if(DaoFactory.HostDao().searchHost(host)){

                final Stage login=(Stage) scenePane.getScene().getWindow();
                Stage  stage=new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/host.fxml"));
                loader.load();
                host set= loader.getController();
                set.HOST = host;

                String Welcome ="Hi, ";int i=0;

                while(host.getName().charAt(i)!=' ') {
                    Welcome+=host.getName().charAt(i);i++;}
                Welcome+=" !";

                set.hiUser.setText(Welcome);

                List<Property> listP= null;
                try {
                    listP = DaoFactory.propertyDao().hostProperties(host);
                } catch (Exceptionss e) {
                    throw new RuntimeException(e);
                }

                if(!listP.isEmpty()) {
                    String[]a = new String[1]; i=0;
                    for(Property p:listP){a[i]=p.getPropertyName()+"   : "+p.getPropertyType();i++;}
                    set.listProperty.getItems().addAll(a);
                }

                stage.setTitle("HOST MENU");
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
    stage.show();
    login.hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        
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
