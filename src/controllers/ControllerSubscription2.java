package controllers;

import dbconnection.DBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import resources.Tabel2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;
import static javafx.fxml.FXMLLoader.load;

public class ControllerSubscription2 {
    public Component frame;
    @FXML
    private Button next;
    @FXML
    private TableView<Tabel2> table;
    @FXML
    private TableColumn<Tabel2,String> colid;
    @FXML
    private TableColumn<Tabel2,String> colname,colrating;
    @FXML
    private ComboBox<String> cbname;
    @FXML
    private ComboBox<String> cbyourname;

    @FXML
    private Button traindet;

    @FXML
    private Button back;

    public static String TRAINERALES;
    ObservableList<Tabel2> oblist1= FXCollections.observableArrayList();

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private ResultSet rs;

    public void initialize() {

        handler = new DBHandler();
        //cb trainer:
        try {
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select fnameT from trainers ");
            while (rs.next()) {
                cbname.getItems().addAll(rs.getString("fnameT")); //denumirea cb ului
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //cb your name:
        try {
            connection = handler.getConnection();
           ResultSet rs1 = connection.createStatement().executeQuery("select fnameC from clients ");
            while (rs1.next()) {
                cbyourname.getItems().addAll(rs1.getString("fnameC"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //TABLEVIEW:

        try{        //tableview from db
            connection = handler.getConnection();
            rs = connection.createStatement().executeQuery("select * from trainers ");
            while(rs.next()){
                oblist1.add(new Tabel2(rs.getInt("trainerId"),rs.getString("fnameT"),rs.getInt("ratingT")));
            }}
        catch(SQLException ex){
            Logger.getLogger(ControllerTrainerDetails.class.getName()).log(Level.SEVERE,null,ex);
        }

//fx:id                                                         //nume var in cls Tabel2
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colrating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        table.setItems(oblist1);


        Tabel2 valoareid=table.getSelectionModel().getSelectedItem();
    }

        @FXML
        void onClickActioncbyourname (ActionEvent event){
        }

        public String getNameCB () { //this is for fname Trainer
            return (String) cbname.getSelectionModel().getSelectedItem();
        }

        public String getYourNameCB () { //this is for fnameC
            return (String) cbyourname.getSelectionModel().getSelectedItem();
        }

        @FXML
        void onClickActionback (ActionEvent event){
            back.getScene().getWindow().hide();
            try {
                Parent root = load(getClass().getResource("/resources/view/subscription.fxml"));
                Stage addScene = new Stage();
                addScene.setScene(new Scene(root));
                addScene.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        void onClickActiontraindet (ActionEvent event){
            traindet.getScene().getWindow();
            try {
                Parent root = load(getClass().getResource("/resources/view/checktrainer1.fxml"));
                Stage addScene = new Stage();
                addScene.setScene(new Scene(root));
                addScene.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @FXML
        void onClickActionnext (ActionEvent event) throws IOException {
            if(getNameCB()==null || getYourNameCB()==null )
                JOptionPane.showMessageDialog(frame, "Trainer not chosen!");
int ok=0;
                Tabel2 ID = table.getSelectionModel().getSelectedItem();

                System.out.println("VALOAREA SELECTATA:"+ID);


            ArrayList<Integer> arrayid = new ArrayList<Integer>();

            connection = handler.getConnection();
            String NAMEFROMCB = getNameCB();
        try {
            String sql2 = "SELECT trainerId FROM trainers WHERE fnameT = '" + NAMEFROMCB + "'";       //vr sa iau idul trainerului ales in cb
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            rs = ps2.executeQuery();
            Integer idultrainerului = null;
            TRAINERALES=getNameCB();
            int idT = 0;
            while (rs.next()) {

                idT = rs.getInt("trainerId");       //merge
                idultrainerului = rs.getInt("trainerId");           //merge
                arrayid.add(rs.getInt("trainerId"));                 //merge
            }
            System.out.println("Id trainer:" + arrayid.toString());


            System.out.println(NAMEFROMCB + "has id1:" + idT + " id2:" + idultrainerului);

           /* String sql = "INSERT INTO subscription(trainerId)" + "VALUES(?)";         merrge
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idultrainerului);
            ps.executeUpdate();
        */
            System.out.println("subscription merge  "+TRAINERALES);


            String sql1 = "UPDATE clients SET fnameT=?, trainerId=? WHERE fnameC='" + getYourNameCB() + "'";

            ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, getNameCB());
            ps1.setInt(2, idultrainerului);
            ps1.executeUpdate();


            System.out.println(TRAINERALES);
            JOptionPane.showMessageDialog(frame, "Trainer chosen!" +
                    " Subscription finished!");

        } catch (SQLException ei) {
        ei.printStackTrace();
        System.err.println("Got an exception from insert and select!");
        System.err.println(ei.getMessage());
    }


                next.getScene().getWindow().hide();
                Parent root = load(getClass().getClassLoader().getResource("resources/view/client.fxml"));
                Stage addStage = new Stage();
                addStage.setScene(new Scene(root));
                addStage.setTitle("The GYM-Subscription 3");
                addStage.show();
                addStage.setTitle("Lets get going!-The GYM");

        }


    @FXML
        void onClickActioncbname (ActionEvent event){ }
    }

