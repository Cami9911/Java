package com.company;

public class Game {
    public static void main(String[] args) {
        Board board= Board.getBoard(10);
        Player player1=new Player("jucator1", board);
        Player player2=new Player("jucator2", board);
        Game.StartGame(board,player1,player2,5);
    }

    public static void StartGame(Board board, Player player1, Player player2, int progressionSize){
        Thread thread1= new Thread(player1);
        Thread thread2= new Thread(player2);
        System.out.println("sunt in StartGAME");
        thread1.start(); //din player1 se apeleaza metoda run
        thread2.start(); //din player2 se apeleaza metoda run
        boolean won=false;

        while(!board.checkBoard()){
            player1.getToken();
            if(player1.hasWon(progressionSize)) {
                System.out.println(player1.getName() + " a castigat!");
                won = true;
                break;
            }
            player2.getToken();
            if(player2.hasWon(progressionSize)){
                System.out.println(player2.getName()+" a castigat!");
                won=true;
                break;
            }
        }

        if(!won){
            System.out.println("Nu a castigat nimeni. Remiza");
        }

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
