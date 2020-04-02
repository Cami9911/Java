package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    List<Token> tokens=new ArrayList<>();

    public List<Token> getTokens() {
        return tokens;
    }

    public Board(int size, List<Token> tokens) {
        this.size = size;
        this.tokens = tokens;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
