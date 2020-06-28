package controllers;

import dbconnection.DBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import resources.ModelTable;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerSubscription {
    //pt adauagarea in bd
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private PreparedStatement ps2;
    private ResultSet rs;

    public Component frame;
    @FXML
    private Button back, next;
    @FXML
    private Button gold;
    @FXML
    private Button platinum;
    @FXML
    private TextField usern,time;
    @FXML
    private ComboBox<String> cbname,cbday;

   //ObservableList<ModelTable> cblist = FXCollections.observableArrayList();

    public void initialize() {


        handler = new DBHandler();
        //cb
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select fnameC from clients ");
            while (rs.next()) {
                cbname.getItems().addAll(rs.getString("fnameC")); //denumirea cb ului
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select days from weekdays ");
            while (rs.next()) {
                cbday.getItems().addAll(rs.getString("days"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNameCB() { //this is zahshit
        return (String) cbname.getSelectionModel().getSelectedItem();
    }
    public String getDay() { //this is zahshit
        return (String) cbday.getSelectionModel().getSelectedItem();
    }

    @FXML
    void onClickActionback(ActionEvent event) {
        back.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/client.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickActiongold(ActionEvent event) {


        connection = handler.getConnection();
        String NAMEFROMCB = getNameCB();
        try {
            String sql = "INSERT INTO subscription(gymId)" + "VALUES(?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, 1001);
            ps.executeUpdate();
        } catch (SQLException ei) {
            ei.printStackTrace();
            System.err.println("Got an exception from insert!");
            System.err.println(ei.getMessage());
        }


        try {
            String sql1 = "UPDATE clients SET gymLoc=? WHERE fnameC='" + getNameCB() + "'";
//update the gym for clients
            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, "Gold");
            ps1.executeUpdate();

            JOptionPane.showMessageDialog(frame, "GYM Gold chosen!");
//sa adaug date in gymcol din subs
        } catch (SQLException eu) {
            eu.printStackTrace();
            System.err.println("Got an exception from update!");
            System.err.println(eu.getMessage());}



//sa adaug date in gymcol din subs
        } /*catch (SQLException eu) {
            eu.printStackTrace();
            System.err.println("Got an exception from update!");
            System.err.println(eu.getMessage());
*/
            //boolean buttondisable = cbname.isPressed();
            //gold.setDisable(buttondisable);



    @FXML
    void onClickActionplatinum(ActionEvent event) {
        connection = handler.getConnection();
        String NAMEFROMCB = getNameCB();
        try {
            String sql = "INSERT INTO subscription(gymId)" + "VALUES(?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, 1002);
            ps.executeUpdate();
        } catch (SQLException ei) {
            ei.printStackTrace();
            System.err.println("Got an exception from insert!");
            System.err.println(ei.getMessage());
        }

        try {
            String sql1 = "UPDATE clients SET gymLoc=?  WHERE fnameC='" + getNameCB() + "'";
//update the gym for clients
            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, "Platinum");//prima valoare din tabelul clienti sa fie
            ps1.executeUpdate();

            JOptionPane.showMessageDialog(frame, "GYM Platinum chosen!");

        } catch (SQLException eu) {
            eu.printStackTrace();
            System.err.println("Got an exception from update!");
            System.err.println(eu.getMessage());
        }

    }

    public void onClickActioncbname(ActionEvent actionEvent) {
    }


    public void onClickActionnext(ActionEvent actionEvent) {

        try {
            String sql1 = "UPDATE clients SET gymtime=?, gymday=? WHERE fnameC='" + getNameCB() + "'";

            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1,time.getText());
            ps1.setString(2,getDay());
            ps1.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Subscription 1 completed");

        } catch (SQLException eu) {
            eu.printStackTrace();
            System.err.println("Got an exception from update!");
            System.err.println(eu.getMessage());
        }

        next.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/subscription2.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.setTitle("The GYM- Subscription 2");
            addScene.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
