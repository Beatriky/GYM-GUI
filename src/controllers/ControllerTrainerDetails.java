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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import resources.ModelTable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerTrainerDetails {
    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable,String> colnume;

    @FXML
    private Button back;

    @FXML
    private TableColumn<ModelTable,String> colfeed;

    @FXML
    private TableColumn<ModelTable,String>colore;



    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private ResultSet rs;

    ObservableList<ModelTable> oblist= FXCollections.observableArrayList();

    public void initialize() throws SQLException {
        handler = new DBHandler();
        try{
        connection = handler.getConnection();
         rs = connection.createStatement().executeQuery("select * from trainers ");
         while(rs.next()){      //ASTA FOLOSESTEI  CA SA BAGI ELEMENTE IN TABEL
             oblist.add(new ModelTable(rs.getString("fnameT"),rs.getString("workhoursT"),rs.getString("feedbackT")));
         }}
        catch(SQLException ex){
            Logger.getLogger(ControllerTrainerDetails.class.getName()).log(Level.SEVERE,null,ex);

        }

        table.setItems(oblist); //IMPORTANT

        colnume.setCellValueFactory(new PropertyValueFactory<>("name"));
        colore.setCellValueFactory(new PropertyValueFactory<>("hour"));
        colfeed.setCellValueFactory(new PropertyValueFactory<>("feedback"));

        connection.close();




    }
    @FXML
    void onClickActionback(ActionEvent event) {
        back.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/manager.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
