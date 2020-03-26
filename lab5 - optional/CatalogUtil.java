package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.Map;

public class CatalogUtil {

    public static void saveText(Catalog catalog) throws IOException {
        FileWriter fileWriter = new FileWriter(catalog.getPath()); //creez un obiect de tipul FileWriter
        PrintWriter printWriter = new PrintWriter(fileWriter); //permite scrierea intr-un fisier
        printWriter.println(catalog.getPath()); //scriu path ul in fisier
        printWriter.println(catalog.getName());
        printWriter.println(catalog.getDocuments().size());
        for (Document d : catalog.getDocuments()) {
            printWriter.println(d.getId());
            printWriter.println(d.getName());
            printWriter.println(d.getLocation());
            printWriter.println(d.getTags().size());
            for (Map.Entry<String, Object> x : d.getTags().entrySet()) {
                printWriter.println(x.getKey());
                printWriter.println(x.getValue());
            }
        }
        printWriter.close();
    }

    public static Catalog loadText(String path) throws IOException, FileNotFoundException {
        Catalog catalog = null;

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        String line2 = bufferedReader.readLine();
        String line_size = bufferedReader.readLine();
        catalog = new Catalog(line2, line);
        for (int i = 0; i < Integer.parseInt(line_size); i++) {
            Document document = new Document(bufferedReader.readLine(), bufferedReader.readLine(), bufferedReader.readLine());
            //am creat un document cu parametrii id, nume, locatie citite din fisier linie cu linie
            int size = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < size; j++) {
                document.addTag(bufferedReader.readLine(), (Object) bufferedReader.readLine());
                //adaug in document tag urile intr-un map care contine o cheie si o valoare
            }
            catalog.add(document); //imi adauga toate documentele in catalog
        }
        bufferedReader.close();

        return catalog;
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
