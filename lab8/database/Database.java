package ro.uaic.info.myapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection connection;
    private static Database uniqObject;

    private Database() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","java","sql"); //se face conexiunea cu baza de date
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Database getObject() throws SQLException {
        if(uniqObject==null){
            uniqObject= new Database();
        }
        else{
            if (uniqObject.connection.isClosed()){ //daca conexiunea e inchisa, fac un obiect nou
                uniqObject=new Database();
            }
        }
        return uniqObject;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static void closeConnection() {
        try {
            uniqObject.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
