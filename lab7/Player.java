package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    private String name;
    private Board board;
    private int position;
    private List<Token> tokensList = new ArrayList<>();

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized void run() {
        System.out.println(name);
        while (!board.checkBoard()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            position = new Random().nextInt(board.getCurrentSize()); //generez o pozitie random
            System.out.println("Pozitie " + name + " " + position);
            notify();
        }
    }

    public synchronized void getToken() {
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(position);
        Token token = board.getToken(position); //iau token-ul din board
        tokensList.add(token); //adaug token-ul in lista
        System.out.println(name + " " + " currentSize " + board.getCurrentSize());
        for (Token x : tokensList) {
            System.out.print(x.getNumber() + " ");
        }
        System.out.println();
    }

    public synchronized boolean hasWon(int progressionSize) {
        if (progressionSize == 1)
            return true;
        if(progressionSize ==2 && tokensList.size()==2)
            return true;

        int diference = tokensList.get(tokensList.size() - 1).getNumber() - tokensList.get(tokensList.size() - 2).getNumber();
        int count = 2;
        for (int i = tokensList.size() - 1; i > 0; i--) {
            if (tokensList.get(i).getNumber() - tokensList.get(i - 1).getNumber() != diference) {
                return false;
            }
            count++;
            if (count == progressionSize)
                return true;
        }
    return false;
    }

}
