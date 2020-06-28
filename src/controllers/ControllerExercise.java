package controllers;

import dbconnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerExercise {

    @FXML
    private Button addex;

    @FXML
    private Button back;

    @FXML
    private TextField exname;

    @FXML
    private TextField extime;

    @FXML
    private ComboBox<String> cbday;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private PreparedStatement ps2;
    private ResultSet rs;
    public Component frame;

    public void initialize() {
        handler = new DBHandler();

        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select days from weekdays ");
            while (rs.next()) {
                cbday.getItems().addAll(rs.getString("days"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}

    public String getDay () { //this is for fnameC
        return (String) cbday.getSelectionModel().getSelectedItem();
    }

    @FXML
    void onClickActionaddex(ActionEvent event) {
        connection = handler.getConnection();

        try {

            String sql1 = "INSERT INTO exercises(exType,extime,day,idweekdays) " + "VALUES(?,?,?,?)";

            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, exname.getText());
            ps1.setString(2, extime.getText());
            ps1.setString(3,getDay());

            String sqlday="SELECT idweekdays from weekdays where days='"+ getDay() +"'";
            ps2 = connection.prepareStatement(sqlday);

            rs=ps2.executeQuery();
            while (rs.next())
                ps1.setInt(4, rs.getInt("idweekdays"));
            ps1.executeUpdate();


            JOptionPane.showMessageDialog(frame, "Exercise added!");

        } catch (SQLException eu) {
            eu.printStackTrace();
            System.err.println("Got an exception from update!");
            System.err.println(eu.getMessage());
        }
    }

    @FXML
    void onClickActionback(ActionEvent event) {
        back.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/trainer.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();} catch (IOException e) {
            e.printStackTrace(); }
    }

}
