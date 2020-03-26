package com.company;

import java.util.stream.Stream;

public abstract class Command {
    private String name;
    private String arguments;

    public Command(String name){
        this.name = name;
    }

    public Command(String name, String arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public abstract Catalog execute(Catalog name, Object... args) throws ArgumentLipsaExceptii;
}
