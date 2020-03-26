package com.company;

import java.util.ArrayList;
import java.util.List;

public class Shell {
    private List<Command> commandList=new ArrayList<Command>();

    public Shell() {

    }

    public void addCommand(Command command){
        commandList.add(command);
    };

    public Command getCommand(String cmd){
        for( Command x : commandList ){
            if(x.getName().equals(cmd)){
                return x;
            }
        }
        return null;
    }

}
