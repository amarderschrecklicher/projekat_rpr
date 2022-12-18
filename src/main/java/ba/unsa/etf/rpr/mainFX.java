package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class mainFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/fxmly.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("JAVAFX");
        stage.setScene(new Scene(root , USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();
    }
    public static void mainFX(String []args) {
        launch(args);
    }
}
