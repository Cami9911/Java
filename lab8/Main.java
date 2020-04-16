package ro.uaic.info.myapp;

import ro.uaic.info.myapp.dao.AlbumController;
import ro.uaic.info.myapp.dao.ArtistController;
import ro.uaic.info.myapp.database.Database;

import javax.xml.crypto.Data;
import java.sql.SQLException;

public class Main {

    private static void addData(ArtistController artist, AlbumController album){
        int artist_id;

        artist.create("Guns N Roses","SUA");
        artist_id=artist.findIdByName("Guns N Roses");
        album.create("Appetite for Destruction",artist_id,1987);

        artist.create("Arctic Monkeys","Great Britain");
        artist_id=artist.findIdByName("Arctic Monkeys");
        album.create("AM",artist_id,2013);

    }

    private static void printData(ArtistController artist, AlbumController album){
        String country=artist.findByName("Guns N Roses");
        if(country!=null)
            System.out.println("Trupa Guns N Roses provine din " +country);
        else{
            System.out.println("Trupa Guns N Roses nu exist in baza de date");
        }
        int artist_id=artist.findIdByName("Arctic Monkeys");
        String nume_an=album.findByArtist(artist_id);
        if(nume_an!=null)
            System.out.println("Numele albumului trupei Arctic Monkeys si anul aparitiei sunt. "+nume_an);
        else{
            System.out.println("Trupa Arctic Monkeys nu are niciun album.");
        }

    }

    public static void main(String[] args) {
        ArtistController artist= new ArtistController();
        AlbumController album= new AlbumController();

        Main.addData(artist,album);
        Main.printData(artist,album);

        Database.closeConnection();
    }
}

