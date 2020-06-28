package application;

import dbconnection.DBHandler;

import java.sql.*;
import dbconnection.DBHandler;
public class prob {
    public static void main(String[] args) throws SQLException {
        Connection connection;
        Statement statement;
        DBHandler handler;
        handler = new DBHandler();
        ResultSet rs, rs1;
        try {
            connection = handler.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * from clients ");
            while (rs.next()) {
                System.out.println(rs.getString("lnameC") + " " +
                        rs.getString("fnameC") + ", "
                        + rs.getInt("clientId") + ", " +
                        rs.getString("usernameC") + " " +
                        rs.getString("passwordC"));
            }
            rs1 = statement.executeQuery("SELECT * from trainers ");
            while (rs1.next()) {
                String fnameT = rs1.getString("fnameT");
                System.out.println(fnameT);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }// finally {
           // if (rs != null) {
                //Close resultSet
               // rs.close();
           // }
        }

   // }
        //Close Connection
        public static void dbDisconnect() {
             Connection connection;
            DBHandler handler ;
            handler = new DBHandler();
            connection = handler.getConnection();
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }}


