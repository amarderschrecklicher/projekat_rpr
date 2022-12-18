package ba.unsa.etf.rpr.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Controller {
    @FXML
    public Button closeButton;
    public AnchorPane scenePane;

    public void click(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("haloooo!");

        alert.showAndWait();

    }
    public void click1(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("haloooo!");

        alert.showAndWait();

    }
    public void click2(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("haloooo!");

        alert.showAndWait();

    }

    @FXML
    public void initialize() {

    }

    public void actionLoginBtn(ActionEvent actionEvent){

        System.out.println("Amar");

    }

    public void click3(ActionEvent actionEvent) {
      Stage stage=(Stage) scenePane.getScene().getWindow();
      stage.close();
    }
}
