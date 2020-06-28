package controllers;

import dbconnection.DBHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import resources.ModelTable;
import resources.Tabel2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerTrainerCheckOut {
    @FXML
    private TableView<Tabel2> table1;        //aici schimbi
    @FXML
    private TableColumn<Tabel2,String> colhour;

    @FXML
    private TableColumn<Tabel2,String> colname;

    @FXML
    private TableColumn<Tabel2,String> colemail;
    @FXML
    private TableColumn<Tabel2,String> colrating;

    @FXML
    private Button back,trainerprofile;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private ResultSet rs,rs1;

    @FXML
    private ListView<Tabel2> listView;

    ObservableList<Tabel2> oblist1= FXCollections.observableArrayList();     //aici

    ObservableList<Tabel2> list= FXCollections.observableArrayList();

    public void initialize() {
        handler = new DBHandler();
        try{        //tableview from db
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select * from trainers ");      //SELECT AVG (rating) from ratings where iDtrainer=?
            while(rs.next()){

                oblist1.add(new Tabel2(rs.getString("fnameT"),rs.getString("emailT"),rs.getString("workhoursT"),rs.getInt("ratingT")));
            }}
        catch(SQLException ex){
            Logger.getLogger(ControllerTrainerDetails.class.getName()).log(Level.SEVERE,null,ex);
        }
         //IMPORTANT
//fx:id                                                         //nume var in cls Tabel2
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colhour.setCellValueFactory(new PropertyValueFactory<>("hour"));
        colrating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        table1.setItems(oblist1);

      // Tabel2 val= table1.getSelectionModel().getSelectedItem();
       // System.out.println(val.getName());

    }


    @FXML
    void onClickActionback(ActionEvent event) {
        back.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/checktrainerprofile.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClickActiontrainerprofile(ActionEvent actionEvent) {
        trainerprofile.getScene().getWindow().hide();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/resources/view/checktrainerprofile.fxml"));
            Stage addScene = new Stage();
            addScene.setScene(new Scene(root));
            addScene.setTitle("The GYM-Trainer Profile!");
            addScene.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

