package dbconnection;
import dbconnection.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler  extends Config {
    Connection dbconnection;

    public Connection getConnection(){
        String connectionString="jdbc:mysql://"+Config.dbhost+":"+Config.dbport+"/"+Config.dbname+"?autoReconnect=true&useSSL=false";
/*
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {System.out.println("Where is your  JDBC Driver?");
            e.printStackTrace();
}*/
         // System.out.println(" JDBC Driver Registered!");
        try {
            dbconnection= DriverManager.getConnection(connectionString, Config.dbuser, Config.dbpass);
        } catch (SQLException e) { System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
        }
        return dbconnection;
    }
    public void disconnect()
    {
        try
        {
            if(dbconnection != null) dbconnection.close();
            System.out.println("Database connection disconnect!");
        }
        catch (Exception e) { e.printStackTrace(); }
    }
}