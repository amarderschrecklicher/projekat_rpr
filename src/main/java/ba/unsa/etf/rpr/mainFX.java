package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class mainFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene =new Scene(new Button("Prijava"),200,250);
        stage.setTitle("JAVAFX");
        stage.setScene(scene);
        stage.show();
        Stage stage2=new Stage();
        stage2.setTitle("DRUGI PROZOR");
        stage2.setScene(new Scene(new Button("drugo dugme"),100,100));
        stage2.show();
    }
    public static void mainFX(String []args) {
        launch(args);
    }
}
