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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class signup  extends host implements Initializable {

    private  Host hostt = new Host();
    @FXML
    public Button signUpBtn;
    @FXML
    public TextField nameHost;
    @FXML
    public TextField surnameHost;
    @FXML
    public TextField numberHost;
    @FXML
    public TextField emailHost;
    @FXML
    private GridPane scenePanee;

    public Host hostNewGive(){return hostt;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
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

    public void signUP(ActionEvent actionEvent) throws Exceptionss, IOException {
        hostt.setName(nameHost.getText()+" "+surnameHost.getText());
        hostt.setEmail(emailHost.getText());
        hostt.setNumber(numberHost.getText());
        List<Host> list=DaoFactory.HostDao().getAll();
        for(Host x:list)if(x.getEmail().equals(hostt.getEmail()) || x.getNumber().equals(hostt.getNumber())) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error");alert1.setHeaderText(null);
            alert1.setContentText("User already exists!");
            alert1.showAndWait();
        }
        else {
            DaoFactory.HostDao().add(hostt);

            final Stage login=(Stage) scenePanee.getScene().getWindow();
            Stage  stage=new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/host.fxml"));
            loader.load();
            host set= loader.getController();

            String Welcome ="Hi, ";int i=0;

            while(hostt.getName().charAt(i)!=' ') {
                Welcome+=hostt.getName().charAt(i);i++;}
            Welcome+=" !";

            set.hiUser.setText(Welcome);

            List<Property> listP= null;
            try {
                listP = DaoFactory.propertyDao().hostProperties(hostt);
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
    }
}
