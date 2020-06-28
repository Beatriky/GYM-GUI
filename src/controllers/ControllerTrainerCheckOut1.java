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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import resources.AVGRate;
import resources.Tabel2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerTrainerCheckOut1 {
    @FXML
    private TableView<Tabel2> table1;//aici schimbi
    @FXML
    private TableView<AVGRate> avgtable;
    @FXML
    private TableColumn<AVGRate,String> avgrate,colid;
    @FXML
    private TableColumn<Tabel2,String> colhour;

    @FXML
    private TableColumn<Tabel2,String> colname;

    @FXML
    private TableColumn<Tabel2,String> colemail;
    @FXML
    private TableColumn<Tabel2,String> colrating;



    private Connection connection;
    private DBHandler handler;
    private ResultSet rs;


    ObservableList<Tabel2> oblist1= FXCollections.observableArrayList();

    ObservableList<AVGRate> oblist2= FXCollections.observableArrayList();

    public void initialize() {
        handler = new DBHandler();
        try{        //tableview from db
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select * from trainers ");
            while(rs.next()){
                oblist1.add(new Tabel2(rs.getString("fnameT"),rs.getString("emailT"),rs.getString("workhoursT"),rs.getInt("ratingT")));
            }}
        catch(SQLException ex){
            Logger.getLogger(ControllerTrainerDetails.class.getName()).log(Level.SEVERE,null,ex);
        }

        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colhour.setCellValueFactory(new PropertyValueFactory<>("hour"));
        colrating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        table1.setItems(oblist1);

        try{        //tableview PT AVG RATE
            connection = handler.getConnection();
            ResultSet rs2 = connection.createStatement().executeQuery("select trainerId,avg(rating) as rating from ratings ");
            while(rs2.next()){
                oblist2.add(new AVGRate(rs2.getInt("trainerId"),rs2.getInt("rating")));
            }}
        catch(SQLException ex){
          ex.printStackTrace();
        }
        avgrate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        avgtable.setItems(oblist2);



    }


}



/*   table1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if(table1.getSelectionModel().getSelectedItem() != null)

                    { TableView.TableViewSelectionModel selectionModel = table1.getSelectionModel();
                    ObservableList selectedCells = selectionModel.getSelectedCells();
                    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                    Object val = tablePosition.getTableColumn().getCellData(newValue);
                    System.out.println("Selected Value" + val);}
                 }}*/

