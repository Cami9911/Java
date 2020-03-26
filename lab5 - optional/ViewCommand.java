package com.company;

import java.io.IOException;

public class ViewCommand extends Command {
    public ViewCommand(String name) {
        super(name);
    }

    public ViewCommand(String name, String arguments) {
        super(name, arguments);
    }

    @Override
    public Catalog execute(Catalog name, Object... args) throws ArgumentLipsaExceptii {
        if(args.length!=1){
            throw new ArgumentLipsaExceptii();
        }
        Document doc = name.findById((String) args[0]);
        try {
            CatalogUtil.view(doc);
            System.out.println("si in view mere treaba");
            return name;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("am belit o si cu view-ul");
            return null;
        }
    }
}
