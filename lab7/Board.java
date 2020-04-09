package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Board {
    private int size;
    private List<Token> tokens;
    private static Board board;

    private Board(int size) {
        this.size = size;
        this.tokens = new ArrayList<>();
        IntStream.rangeClosed(0, size-1) //imi genereaza numere de la 0 la size
                .boxed()
                .forEach( //adauga un nou token pentru fiecare numar generat
                        (elem) -> tokens.add(new Token(elem))
                );
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static Board getBoard(int size) {
        if (board == null) { /*daca nu exista un board, il creeaza*/
            board = new Board(size);
        }
        /*altfel, il returneaza*/
        return board;
    }

    public boolean checkBoard(){ //verific daca board (lista de tokens) e gol
        if(tokens.isEmpty())
            return true;
        return false;
    }

    public synchronized Token getToken(int position){
        Token elem=tokens.get(position);
        tokens.remove(position);
        return elem; //returneaza elementul de pe pozitia aleasa
    }
    public int getCurrentSize(){
        return tokens.size();
    }

}
