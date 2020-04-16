package ro.uaic.info.myapp.dao;

import ro.uaic.info.myapp.database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    private Database databaseConn;

    public AlbumController() {
        try {
            databaseConn=Database.getObject(); //ma conectez la baza de date
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean create(String name, int artistId, int releaseYear){
        String sqlStmt="INSERT INTO Albums(NAME,ARTIST_ID,release_year) VALUES('"+name+"',"+artistId+","+releaseYear+")";

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

    public String findByArtist(int artistId){
        String sqlStmt="SELECT name,release_year FROM Albums WHERE ARTIST_ID="+artistId; //daca gaseste elementul dupa id, returneaza numele si anul albumului
        try {
            Statement stmt=databaseConn.getConnection().createStatement();
            ResultSet exec= stmt.executeQuery(sqlStmt); //se executa in baza de date SELECTUL si se returneaza un set de rezultate
            if(exec.next())
                return exec.getString("name")+" "+exec.getInt("release_year");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
