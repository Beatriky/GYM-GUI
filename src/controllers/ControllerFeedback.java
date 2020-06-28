package controllers;

import dbconnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerFeedback {
    public Component frame;
    @FXML
    private Button backfeedback;
    @FXML
    private Button send;
    @FXML
    private TextArea feedback;
    @FXML
    private ComboBox<String> cbname;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private PreparedStatement ps2;
    private ResultSet rs;
    public void initialize() {


        handler = new DBHandler();
        //cb
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select fnameT from trainers ");
            while (rs.next()) {
                cbname.getItems().addAll(rs.getString("fnameT")); //denumirea cb ului
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public String getNameCB() { //this is zahshit
        return (String) cbname.getSelectionModel().getSelectedItem();
    }


    @FXML
    void onClickActionSend(ActionEvent event) {
        String value=getNameCB();//very important
int ok=0;
        System.out.println("THIS IS THE chosen trainer:"+value);
        connection = handler.getConnection();
        try {
            String sql1 = "UPDATE trainers SET feedbackT=? WHERE fnameT='" + getNameCB() + "'";          //"INSERT INTO trainers(feedbackT) SELECT fnameT FROM trainers WHERE fnameT='" + getNameCB() + "'";

            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, feedback.getText());
            ps1.execute();
            ok=1;
            JOptionPane.showMessageDialog(frame, "Feedback sent!");
            connection.close();
    } catch (SQLException throwables) {
            throwables.printStackTrace();}
                if(ok==1) {
                    send.getScene().getWindow().hide();
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


    public void onClickActionfeedback(ActionEvent actionEvent) {
    }

    public void onClickActioncbname(ActionEvent actionEvent) {

    }
    @FXML
    void onClickActionbackfeedback(ActionEvent event) {
        backfeedback.getScene().getWindow().hide();
        try { Parent root = FXMLLoader.load(getClass().getResource("/resources/view/client.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();} catch (IOException e) {
            e.printStackTrace();
        }

    }
}
