package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, CatalogUtil.InvalidCatalogException {
        Scanner scanner = new Scanner(System.in);
        Shell shell = new Shell();
        shell.addCommand(new LoadCommand("load"));
        shell.addCommand(new ListCommand("list"));
        shell.addCommand(new ViewCommand("view"));
        Catalog catalog = null;
        System.out.println("Comenzi disponibile: \n load, list, view");
        System.out.println("Introduceti o comanda: ");
        while (true) {

            System.out.print("> ");
            String line = scanner.nextLine();
            String[] lineArgs = line.split(" ");
            if (lineArgs[0].equals("load")) {
                if (lineArgs.length == 1) {
                    try {
                        throw new ArgumentLipsaExceptii();
                    } catch (ArgumentLipsaExceptii argumentLipsaExceptii) {
                        System.out.println("exc: " + argumentLipsaExceptii.getMessage());
                    }
                } else {
                    try {
                        catalog = shell.getCommand("load").execute(catalog, lineArgs[1]);
                    } catch (ArgumentLipsaExceptii argumentLipsaExceptii) {
                        System.out.println("exc: " + argumentLipsaExceptii.getMessage());
                    }
                }
            } else if (lineArgs[0].equals("view")) {
                if (lineArgs.length == 1) {
                    System.out.println("Nu sunt destule argumente. view docId");
                } else {
                    try {
                        catalog = shell.getCommand("view").execute(catalog, lineArgs[1]);
                    } catch (ArgumentLipsaExceptii argumentLipsaExceptii) {
                        System.out.println("exc: " + argumentLipsaExceptii.getMessage());
                    }
                }
            } else if (lineArgs[0].equals("list")) {
                if (lineArgs.length == 1) {
                    System.out.println("Nu sunt destule argumente. list \"docs\" ");
                } else {
                    try {
                        catalog = shell.getCommand("list").execute(catalog, lineArgs[1]);
                    } catch (ArgumentLipsaExceptii argumentLipsaExceptii) {
                        System.out.println("exc: " + argumentLipsaExceptii.getMessage());
                    }
                }
            } else {
                System.out.println("Comenzi disponibile: \n load, list, view");
            }
        }
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources", "c:/java/catalog.c.ser");
        Document doc = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);
        try {
            CatalogUtil.saveText(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testLoadView() throws IOException, CatalogUtil.InvalidCatalogException {
        Catalog catalog = CatalogUtil.loadText("c:/java/catalog.c.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }


}
