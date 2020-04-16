package ro.uaic.info.myapp.dao;

import ro.uaic.info.myapp.database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
    private Database databaseConn;

    public ArtistController() {
        try {
            databaseConn=Database.getObject(); //ma conectez la baza de date
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean create(String name, String country){
        String sqlStmt="INSERT INTO Artists(name,country) VALUES('"+name+"','"+country+"')";
        try {
            Statement stmt=databaseConn.getConnection().createStatement();
            int exec= stmt.executeUpdate(sqlStmt); //se executa in baza de date insertul
            if(exec>0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public String findByName(String name){
        String sqlStmt="SELECT country FROM Artists WHERE name='"+name+"' "; //daca gaseste elementul dupa nume, returneaza tara
        try {
            Statement stmt=databaseConn.getConnection().createStatement();
            ResultSet exec= stmt.executeQuery(sqlStmt); //se executa in baza de date SELECTUL si se returneaza un set de rezultate
            if(exec.next())
                return exec.getString("country");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public int findIdByName(String name){ //am mai construit o metoda care cauta dupa nume id-ul, pentru a gasi mai usor albumele
        // in cazul in care am adaugat foarte multe
        String sqlStmt="SELECT id FROM Artists WHERE name='"+name+"' "; //daca gaseste elementul dupa id, returneaza id ul
        try {
            Statement stmt=databaseConn.getConnection().createStatement();
            ResultSet exec= stmt.executeQuery(sqlStmt); //se executa in baza de date SELECTUL si se returneaza un set de rezultate
            if(exec.next())
                return exec.getInt("ID");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }
}
