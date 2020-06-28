package controllers;

import dbconnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class ControllerNotif {

        @FXML
        private ComboBox<String> cbname;

        @FXML
        private TextField usern;

        @FXML
        private Button backfeedback;

        @FXML
        private TextArea message;

        @FXML
        private Button send;
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private ResultSet rs;



    public void initialize() {
        handler = new DBHandler();
//cb
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select fnameT from trainers ");
            while (rs.next()) {
                cbname.getItems().addAll(rs.getString("fnameT"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public String getName () { //this is for fnameC
        return (String) cbname.getSelectionModel().getSelectedItem();
    }

    private Component frame;

        @FXML
        void onClickActionbackfeedback(ActionEvent event) {
            backfeedback.getScene().getWindow().hide();
            try { Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/checktrainerprofile.fxml"));
                Stage addScene = new Stage();
                addScene.setScene(new Scene(root));
                addScene.show();} catch (IOException e) {
                e.printStackTrace(); }
        }


        @FXML
        void onClickActionSend(ActionEvent event) {
            try {
                String sql1 = "INSERT INTO notification(notif,fnamec,fnamet)" + "VALUES(?, ?, ?)";        //"INSERT INTO trainers(feedbackT) SELECT fnameT FROM trainers WHERE fnameT='" + getNameCB() + "'";
                                                                                                        //WHERE fnameT='" + getName() + "
                ps = connection.prepareStatement(sql1);
                ps.setString(1, message.getText());
                ps.setString(2, usern.getText());
                ps.setString(3, getName());
                ps.execute();

                JOptionPane.showMessageDialog(frame, "Notification sent!");

            } catch (SQLException throwables) {
                throwables.printStackTrace();}
        }


    @FXML
    void onClickActioncbname(ActionEvent event) {

    }
}
