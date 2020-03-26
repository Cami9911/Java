package com.company;

public class ListCommand extends Command{

    public ListCommand(String name) {
        super(name);
    }

    public ListCommand(String name, String arguments) {
        super(name, arguments);
    }

    @Override
    public Catalog execute(Catalog name, Object... args) throws ArgumentLipsaExceptii {
        if(args.length!=1){
            throw new ArgumentLipsaExceptii();
        }
        if(((String)args[0]).equals("docs")){
            for( Document x : name.getDocuments())
            {
                System.out.println(x.getName());
                System.out.println(x.getId());
                System.out.println(x.getLocation());
                System.out.println();
            }
        }
        return null;
    }
}
