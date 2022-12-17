package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
public class mainFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("fxmly.fxml"));
        Parent root = null;
        Controller controller = new Controller();
        loader.setController(controller);
        root = loader.load();
        Scene scene =new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        stage.setTitle("JAVAFX");
        stage.setScene(scene);
        stage.show();
    }
    public static void mainFX(String []args) {
        launch(args);
    }
}
