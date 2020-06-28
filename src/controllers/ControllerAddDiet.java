package controllers;

import dbconnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerAddDiet {

    @FXML
    private Button adddiet;

    @FXML
    private TextField diettype;

    @FXML
    private Button back;

    @FXML
    private TextArea details;

    private Component frame;
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private PreparedStatement ps2;
    private ResultSet rs;

    public void initialize() { handler = new DBHandler();}

    @FXML
    void onClickActiondiettype(ActionEvent event) {

    }

    @FXML
    void onClickActiondetails(ActionEvent event) {

    }

    @FXML
    void onClickActionadddiet(ActionEvent event) {

        connection = handler.getConnection();
        try {
            String sql1 = "INSERT INTO diets(dietType,dietDetails)" + "VALUES(?,?)";
          //  String sql1 = "UPDATE diets SET (dietType,dietDetails)"+ "VALUES(?,?)";

            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, diettype.getText());
            ps1.setString(2, details.getText());
            ps1.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Diet added!");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();}
    }
    @FXML
    void back(ActionEvent event) {
        back.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/trainer.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();} catch (IOException e) {
            e.printStackTrace(); }
    }

}
