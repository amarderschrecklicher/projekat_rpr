package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class ReservationsController extends HostController implements Initializable {

    public  Label AC ;
    public Label propertyName;
    public TableView table;
    public Label locationn;
    public Label capacity;
    public Label price;

    Stage sTransition(String whereTo, String title, Object control) throws IOException {
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
    public void initialize(URL location, ResourceBundle resources) {

      propertyName.setText(PROPERTY.getPropertyName());
      locationn.setText(locationn.getText()+" "+PROPERTY.getLocation());
      capacity.setText(capacity.getText()+" "+PROPERTY.getCapacity());
      price.setText(price.getText()+" "+PROPERTY.getPrice());
      if(PROPERTY.isAcH()){
          AC.setText(AC.getText()+" Yes");
      }else {
          AC.setText(AC.getText()+" No");
      }
    }
}
