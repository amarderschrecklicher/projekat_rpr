package ba.unsa.etf.rpr.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.*;


public class Controller {
    @FXML
    public Button closeButton;
    @FXML
    public Button signIn;
    @FXML
    public AnchorPane scenePane;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField passWord;

    Connection con;
    PreparedStatement ps;
    ResultSet  rez;

    public void click(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("haloooo!");

        alert.showAndWait();

    }
    public void click1(ActionEvent actionEvent) throws ClassNotFoundException, SQLException{
        String user = userName.getText(), pass = passWord.getText();
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);

        if(user.equals("") || pass.equals("") ){
            alert1.setTitle("Error");alert1.setHeaderText(null);
            alert1.setContentText("Username or password blank!");
            alert1.showAndWait();
        }
        else {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:myqsl://localhost/superpos","root","");
            ps=con.prepareStatement("select * from sql7583417 where username=? and password=?");
            ps.setString(1,user);
            ps.setString(2,pass);
            rez=ps.executeQuery();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            if(rez.next()) {
                alert.setTitle("Success");alert.setHeaderText(null);
                alert.setContentText("Login success!");
                alert.showAndWait();
            }
            else  {

                alert.setTitle("Failed");alert.setHeaderText(null);
                alert.setContentText("Login failed!");
                alert.showAndWait();

                userName.setText("");
                passWord.setText("");
                userName.requestFocus();
            }

        }

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

    public void userName(ActionEvent actionEvent) {
    }

    public void password(ActionEvent actionEvent) {
    }
}
