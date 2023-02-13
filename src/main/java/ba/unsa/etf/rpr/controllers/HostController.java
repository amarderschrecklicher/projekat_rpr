package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


public class HostController extends LoginController implements Initializable {

    public static Host HOST = lHOST;

    public static Property PROPERTY = null;

    @FXML
    public Label hiUser ;

    @FXML
    public ListView<String> listProperty;
    @FXML
    public BorderPane scenePn;
    @FXML
    public Button info;
    @FXML
    public Button update;
    @FXML
    public Button delete;

    public static void setHOST(Host host) {
        HOST = host;
    }

    /**
     * transition
     */
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


    /**
     * initialize method, Hi HOST!
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hiUser.setText("Hi " + HOST.getName().split(" ", 2)[0] +" !");
        List<Property> listP = null;
        try {
            listP = DaoFactory.propertyDao().hostProperties(HOST);
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
            listProperty.getItems().addAll(a);
        }
        listProperty.setFocusTraversable(false);
        update.setFocusTraversable(false);
        info.setFocusTraversable(false);
        delete.setFocusTraversable(false);
        update.setDisable(true);
        info.setDisable(true);
        delete.setDisable(true);

        listProperty.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> change) {
                update.setDisable(false);
                info.setDisable(false);
                delete.setDisable(false);
            }
        });

    }


    /**
     * log out
     */
    public void logOutA(ActionEvent actionEvent) throws IOException {
        final Stage login = (Stage) scenePn.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        loader.load();
        stage.setTitle("Login");
        stage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
        login.hide();;

    }


    /**
     * adding new property
     */
    public void newPropertyA(ActionEvent actionEvent) throws IOException, Exceptionss {
        Stage s = sTransition("/fxml/property.fxml", "NEW PROPERTY",new PropertyController());
        s.getIcons().add(new Image("/icons/property_icon.png"));
        final Stage login2=(Stage) scenePn.getScene().getWindow();
        login2.hide();
    }

    /**
     * finding the property in ListView
     */
    public void prop(ListView<String> lp) throws Exceptionss {
        String st = listProperty.getSelectionModel().getSelectedItem();
        st = st.split(" ")[0];
        ArrayList<Property> l = (ArrayList<Property>) DaoFactory.propertyDao().hostProperties(HOST);
        for(Property p : l) {
            if (p.getPropertyName().equals(st)) {
                PROPERTY = new Property();
                PROPERTY = p;
                break;
            }
        }
    }




    public void infoProperty(ActionEvent actionEvent) throws IOException, Exceptionss {
        prop(listProperty);
        Stage s = sTransition("/fxml/reservations.fxml", "PROPERTY INFO",new ReservationsController());
    }
    public void updateProperty(ActionEvent actionEvent) throws Exceptionss, IOException {
        prop(listProperty);
        Stage s = sTransition("/fxml/property.fxml", "PROPERTY INFO",new PropertyController());

    }
    public void deleteProp(ActionEvent actionEvent) throws Exceptionss, IOException {
        prop(listProperty);
            DaoFactory.reservationsDao().deleteByProperty(PROPERTY.getId());
            DaoFactory.propertyDao().delete(PROPERTY.getId());
        int i = listProperty.getSelectionModel().getSelectedIndex();
        listProperty.getItems().remove(i);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Property successfully deleted!");
        alert.showAndWait();

    }


}