package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    String name;
    Board board;
    List<String> tokensList=new ArrayList<>();

    public Player(String name, Board board) {
        this.name = name;
        this.board=board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        board.getTokens().remove(2);
        tokensList.add(name);
    }
}
