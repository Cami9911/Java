package com.company;

import java.io.IOException;

public class LoadCommand extends Command {

    public LoadCommand(String name) {
        super(name);
    }

    public LoadCommand(String name, String arguments) {
        super(name, arguments);
    }

    @Override
    public Catalog execute(Catalog name, Object... args) throws ArgumentLipsaExceptii {
        if(args.length!=1){
            throw new ArgumentLipsaExceptii();
        }
        if (((String) args[0]).startsWith("c:")) {
            try {
                name = CatalogUtil.loadText((String) args[0]);
            } catch (IOException e) {
                System.out.println("e: " +e.getMessage());
                return null;
            }
            System.out.println(name.getName());
            return name;
        }
        else{
            try {
                throw new ExceptieArgumentInvalid();
            } catch (ExceptieArgumentInvalid exceptieArgumentInvalid) {
                System.out.println("exc: " +exceptieArgumentInvalid.getMessage());
            }
        }
        return null;
    }

}
