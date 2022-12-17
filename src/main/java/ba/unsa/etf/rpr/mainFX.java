package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class mainFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("fxmly.fxml"));
        stage.setTitle("JAVAFX");
        stage.setScene(new Scene(root , 300,400));
        stage.show();
    }
    public static void mainFX(String []args) {
        launch(args);
    }
}
