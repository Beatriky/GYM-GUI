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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import resources.Plan;
import resources.Plan2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerPlan {
    @FXML
    private TableView<Plan> tableex;
    @FXML
    private TableView<Plan2> table;
    @FXML
    private ComboBox<String> cbname;

    @FXML
    private TableColumn<Plan, String> colex;

    @FXML
    private TableColumn<Plan, String> coltime;

    @FXML
    private TableColumn<Plan2, String> coldiet;
    @FXML
    private TableColumn<Plan2, String> coldiedet;

    @FXML
    private Button back,load;

    @FXML
    private ComboBox<String> cbday;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private ResultSet rs;

    ObservableList<Plan> oblist1= FXCollections.observableArrayList();
    ObservableList<Plan2> oblist2= FXCollections.observableArrayList();

    public String getDay () { //this is for fnameC
        return (String) cbday.getSelectionModel().getSelectedItem();
    }
    public String getName () { //this is for fnameC
        return (String) cbname.getSelectionModel().getSelectedItem();
    }

    public void initialize() {
        handler = new DBHandler();
//cb
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select days from weekdays ");
            while (rs.next()) {
                cbday.getItems().addAll(rs.getString("days"));
            }  } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
           try {
                connection = handler.getConnection();
                rs = connection.createStatement().executeQuery("select fnameC from clients ");
                while (rs.next()) {
                    cbname.getItems().addAll(rs.getString("fnameC"));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onclickback(ActionEvent event) {
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

    public void onactionload(ActionEvent actionEvent) {
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select * from exercises");
            while (rs.next()) {
                oblist1.add(new Plan(rs.getString("exType"), rs.getString("extime")));
            } } catch (SQLException ex) {
           ex.printStackTrace();
        }

        ResultSet rs1 = null;         //where fnameC='" + getName() + "'");
        try {
            rs1 = connection.createStatement().executeQuery("select * from diets");
            while (rs1.next())
                oblist2.add(new Plan2(rs1.getString("dietType"), rs1.getString("dietDetails")));

           //ResultSet rs3 = connection.createStatement().executeQuery("select * from diets");
          //  oblist2.add(new Plan2( rs1.getString("dietDetails")));
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }




        tableex.setItems(oblist1);
        colex.setCellValueFactory(new PropertyValueFactory<>("extype"));
        coltime.setCellValueFactory(new PropertyValueFactory<>("time"));
        table.setItems(oblist2);
        coldiet.setCellValueFactory(new PropertyValueFactory<>("diettype"));
        coldiedet.setCellValueFactory(new PropertyValueFactory<>("dietdet"));
    }

}
