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
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


public class LoginController implements Initializable {

    public static Host lHOST = new Host();
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
                lHOST.setName(user); lHOST.setNumber(pass);

            if(DaoFactory.HostDao().searchHost(lHOST)) {

                lHOST = DaoFactory.HostDao().getByNumber(pass);
                final Stage login = (Stage) scenePane.getScene().getWindow();
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/host.fxml"));
                loader.setController(new HostController());
                loader.load();
                stage.setTitle("USER");
                stage.getIcons().add(new Image("/icons/host_icon.png"));
                HostController set = loader.getController();
                HostController.HOST = lHOST;

                set.hiUser.setText("Hi " + lHOST.getName().split(" ", 2)[0] +" !");

                List<Property> listP = null;
                try {
                    listP = DaoFactory.propertyDao().hostProperties(lHOST);
                } catch (Exceptionss e) {
                    throw new RuntimeException(e);
                }


                if (!listP.isEmpty()) {
                    String[] a = new String[listP.size()];
                    int i = 0;
                    for (Property p : listP) {
                        a[i] = p.getPropertyName() + "   : " + p.getPropertyType();
                        i++;
                    }
                    set.listProperty.getItems().addAll(a);
                }

                stage.setTitle("HOST MENU");
                stage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
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
    loader.setController(new SignupController());
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


}
