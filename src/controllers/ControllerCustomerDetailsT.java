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
import resources.TabelClienti1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerCustomerDetailsT {
    @FXML
    private Button back;
    @FXML
    private ListView<TabelClienti1> list;
    @FXML
    private TableView<TabelClienti1> tableinfo;
    @FXML
    private TableColumn<TabelClienti1, String> colname;
    @FXML
    private TableColumn<TabelClienti1, String> colemail;
    @FXML
    private TableColumn<TabelClienti1, String> coldiet;

    //final ObservableList options=FXCollections.observableArrayList();
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private ResultSet rs1;

    ObservableList<TabelClienti1> oblist= FXCollections.observableArrayList();

    public void initialize() {
       // ListView list=new ListView(options);

        handler = new DBHandler();
        connection = handler.getConnection();
        try{
        rs1 = connection.createStatement().executeQuery("select fnameC,emailC,dietType from clients ");
        while(rs1.next())                   //FII ATENTA LA CLASA TABEL
            oblist.add(new TabelClienti1( rs1.getString("fnameC"),rs1.getString("emailC"), rs1.getString("dietType")));
        /*
        rs2 = connection.createStatement().executeQuery("select * from diets ");
            while(rs2.next())
                oblist2.add(new Diets(rs2.getInt("dietId")));   */
        } catch(SQLException e){
        Logger.getLogger(ControllerCustomerDetailsT.class.getName()).log(Level.SEVERE,null,e);
    }

         //IMPORTANT
       // tableinfo.setItems(oblist2);

        colname.setCellValueFactory(new PropertyValueFactory<>("fnameC"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("emailC"));
        coldiet.setCellValueFactory(new PropertyValueFactory<>("dietType"));
        tableinfo.setItems(oblist);
        }


private void inittable(){
        initcol();
    }
    private void initcol(){

       // coldiet.setCellFactory(new PropertyFactory<>(""));

    }
    private void editablecol(){
     //   coldiet.setCellValueFactory(TextFieldTableCell.forTableColumn());
      //  coldiet.setOnEditCommit(e -> {
      //  e.getTableView().getItems().get(e.getTablePosition().getRow()).setNewDietId((e.getNewValue()));
        //    });
    }

    public void onClickActionback(ActionEvent actionEvent) {
        back.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/trainer.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.setTitle("The GYM-Trainer");
            addScene.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 /*list.setOnMouseClicked(event -> {
            try{
                connection = handler.getConnection();
                String query="select * from clients where fnameC=? ";
                ps=connection.prepareStatement(query);
                rs = ps.executeQuery();

                while(rs.next()){      //ASTA FOLOSESTEI  CA SA BAGI ELEMENTE IN TABEL
                    colname.setText(rs.getString("fnameC"));
                }}
            catch(SQLException ex){
                Logger.getLogger(ControllerTrainerDetails.class.getName()).log(Level.SEVERE,null,ex);
        }); } */