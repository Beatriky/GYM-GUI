
package controllers;

import dbconnection.DBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import resources.Tabel2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerRateTrainers {

    @FXML
    private Slider slider;

    @FXML
    private ComboBox<String> cbname;

    @FXML
    private TextField textfield;

    @FXML
    private Button back, rate;
    public Component frame;


    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private ResultSet rs;

    public void initialize() {

        handler = new DBHandler();

        try {
            connection = handler.getConnection();
            ResultSet rs1 = connection.createStatement().executeQuery("select fnameT from trainers ");
            while (rs1.next()) {
                cbname.getItems().addAll(rs1.getString("fnameT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNameCB() {
        return (String) cbname.getSelectionModel().getSelectedItem();
    }

    @FXML
    void onClickActionrate(ActionEvent event) {
        String value = getNameCB();//very important
        // Integer ratingnr = Integer.valueOf(value);
        int ok = 0;
        System.out.println("THIS IS THE trainer you will rate :" + value);
        connection = handler.getConnection();
         /*if(ratingnr>10){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The number is too big!");
                    alert.setTitle("Error number too big");
                    alert.setHeaderText(null);
                    alert.show();}
         //else
                if(value==null){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setContentText("Input a number!");
                    alert.setTitle("Error number not found");
                     alert.setHeaderText(null);
                     alert.show();}
         else{*/
        try {
            String sql1 = "UPDATE trainers SET ratingT=? WHERE fnameT='" + getNameCB() + "'";          //"INSERT INTO trainers(ratingT) SELECT fnameT FROM trainers WHERE fnameT='" + getNameCB() + "'";

            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, textfield.getText());
            ps1.execute();
            ok = 1;
            JOptionPane.showMessageDialog(frame, "Trainer rated!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();}

        ArrayList<Integer> arrayid = new ArrayList<Integer>();

try{
            String sql2 = "SELECT trainerId FROM trainers WHERE fnameT = '" + getNameCB() + "'";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            rs = ps2.executeQuery();
           int idT=0;
            while (rs.next()) {
                idT = rs.getInt("trainerId");
                arrayid.add(rs.getInt("trainerId"));
            }
  //  String sql1 = "UPDATE rating SET trainerId=? WHERE fnameT='" + getNameCB() + "'";

    String sqlll="INSERT INTO ratings (rating,trainerId)"+ "VALUES(?,?)";
           PreparedStatement ps3 = connection.prepareStatement(sqlll);
            ps3.setString(1, textfield.getText());
            ps3.setInt(2, idT);
            ps3.executeUpdate();

} catch (SQLException throwables) {

    throwables.printStackTrace();}


        if (ok == 1) {
            rate.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/client.fxml"));
                Stage addStage = new Stage();
                addStage.setScene(new Scene(root));
                addStage.show();
                addStage.setTitle("The GYM-Welcome!");
            } catch (IOException e) {
                System.out.println("Ceva cu fxml");
                e.printStackTrace();
            }
        }
    }

    @FXML
    void onClickActiontextfield(ActionEvent event){}
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


}

