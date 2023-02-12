package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservationsController extends HostController implements Initializable {

    public  Label AC ;
    public Label propertyName;
    public TableView table;
    public Label locationn;
    public Label capacity;
    public Label price;

    @FXML
    public void cancelButton(ActionEvent actionEvent) {
    }
    @FXML
    public void applyButton(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.print(PROPERTY.getPropertyName());
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
