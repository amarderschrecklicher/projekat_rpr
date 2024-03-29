package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Guest;
import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class ReservationsController extends HostController implements Initializable {

    public  Label AC ;
    public Label propertyName;
    public TableView table;
    public Label locationn;
    public Label capacity;
    public Label price;
    public TableColumn resId = new TableColumn("Reservation ID");
    public TableColumn dateIn = new TableColumn("Check in");
    public TableColumn dateOut = new TableColumn("Check out");
    public TableColumn guestName = new TableColumn("Guest");
    public TableColumn nmbGuests = new TableColumn("People");
    public TableColumn totPrice = new TableColumn("Total price");
    public TableColumn dateRes = new TableColumn("Reservation date");


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
     * initialize method, showing info about Property
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        table.setFocusTraversable(false);
        table.setEditable(false);
         AC.setFocusTraversable(false); ;
         propertyName.setFocusTraversable(false);
         table.setFocusTraversable(false);
        locationn.setFocusTraversable(false);
         capacity.setFocusTraversable(false);
         price.setFocusTraversable(false);


        try {
            ArrayList<Reservations> lr = (ArrayList<Reservations>) DaoFactory.reservationsDao().getAll();
            if (lr != null) {
                guestName.setMinWidth(120); dateIn.setMinWidth(105); dateOut.setMinWidth(105);
                table.getColumns().addAll(resId,guestName,nmbGuests,dateIn,dateOut,totPrice);
                ObservableList<Table> tab = FXCollections.observableArrayList();
                for (Reservations r : lr) {
                    if (r.getGuestID() != 0 && r.getPropertyID()==PROPERTY.getId()) {
                        Guest g = DaoFactory.GuestDao().getById(r.getGuestID());
                        LocalDate ld = r.getDateIn().toLocalDate();
                        LocalDate ld2 = r.getDateOut().toLocalDate();
                        int nights = 0;
                        while (!ld.isEqual(ld2)) {
                            ld = ld.plusDays(1);
                            nights = nights + 1;
                        }
                        tab.add(new Table(Integer.toString(r.getId()), g.getName(), Integer.toString(g.getNumberOfGuests()),
                                r.getDateIn().toString(), r.getDateOut().toString(),
                                r.getReservationDate().toString(),
                                Double.toString(DaoFactory.propertyDao().getById(r.getPropertyID()).getPrice() * nights )+" €"));

                    }
                }

                resId.setCellValueFactory(new PropertyValueFactory<Table,String>("resId"));
                guestName.setCellValueFactory(new PropertyValueFactory<Table,String>("guestName"));
                nmbGuests.setCellValueFactory(new PropertyValueFactory<Table,String>("nmbGuests"));
                dateIn.setCellValueFactory(new PropertyValueFactory<Table,String>("dateIn"));
                dateOut.setCellValueFactory(new PropertyValueFactory<Table,String>("dateOut"));
                dateRes.setCellValueFactory(new PropertyValueFactory<Table,String>("dateRes"));
                totPrice.setCellValueFactory(new PropertyValueFactory<Table,String>("totalPrice"));

                table.setItems(tab);

            }
            } catch(Exceptionss e){
                throw new RuntimeException(e);
            }

        propertyName.setText(PROPERTY.getPropertyName());
      locationn.setText(locationn.getText()+" "+PROPERTY.getLocation());
      capacity.setText(capacity.getText()+" "+PROPERTY.getCapacity());
      price.setText(price.getText()+" "+PROPERTY.getPrice()+" €");
      if(PROPERTY.isAcH()){
          AC.setText(AC.getText()+" Yes");
      }else {
          AC.setText(AC.getText()+" No");
      }
    }
}
