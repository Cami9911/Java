package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class GameServer {
    // se defineste portul la care asculta serverul
    public static final int PORT = 8100;

    public GameServer() throws IOException {

        Scanner scanner = new Scanner(System.in);
        boolean ServerOn = true;
        ServerSocket serverSocket = null;
        try {
            // serverul asculta la portul 8100
            serverSocket = new ServerSocket(PORT);

            System.out.println("Waiting for a client ...");
            // socketul accepta cererile pe care le primeste de la client
            Socket socket = serverSocket.accept();

            //creeaza un nou thread si apeleaza metoda start()
            new ClientThread(socket).start();

        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }

}
