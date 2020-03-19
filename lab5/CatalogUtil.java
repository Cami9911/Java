package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
        System.out.println("Obiectul a fost scris in fisier.");
    }

    public static Catalog load(String path) throws InvalidCatalogException, IOException {
        if( !new File(path).exists() )
            throw new FileNotFoundException("Cale invalida: " + path + " !");

        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fis);
        Catalog cat;
        try {
             cat = ((Catalog)in.readObject());

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return cat;
    }

    public static void view(Document doc) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        if (doc.getLocation().startsWith("http"))
            desktop.browse(URI.create(doc.getLocation()));
        else
            desktop.open(new File((doc.getLocation())));
    }

    public class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception ex) {
            super("Invalid catalog file.", ex);
        }
    }

}
