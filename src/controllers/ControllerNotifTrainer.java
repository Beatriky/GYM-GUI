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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import resources.Notif;
import resources.Plan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerNotifTrainer {

    @FXML
    private TableColumn<Notif, String> colname;

    @FXML
    private TableColumn<Notif, String> colnotif;

    @FXML
    private Button back,refresh;
    @FXML
    private ComboBox<String> cbname;
    @FXML
    private TableView<Notif> table;
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private ResultSet rs;

    ObservableList<Notif> oblist1 = FXCollections.observableArrayList();

    public String getName() { //this is for fnameC
        return (String) cbname.getSelectionModel().getSelectedItem();
    }

    public void initialize() {
        handler = new DBHandler();

        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select fnameT from trainers ");
            while (rs.next()) {
                cbname.getItems().addAll(rs.getString("fnameT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickActionback(ActionEvent event) {
        back.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/view/trainer.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onclickefresh(ActionEvent actionEvent) {
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select * from notification  where fnamet= '" + getName() + "'");
            while (rs.next()) {
                oblist1.add(new Notif(rs.getString("notif"), rs.getString("fnamec")));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        table.setItems(oblist1);

        colnotif.setCellValueFactory(new PropertyValueFactory<>("notif"));
        colname.setCellValueFactory(new PropertyValueFactory<>("fname"));
    }
}
