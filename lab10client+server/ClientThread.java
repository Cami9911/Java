package server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        boolean connectionOn = true;
        boolean ServerOn = true;

        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                System.out.print("Write a command: ");
                String toReturn = scanner.nextLine();
                out.println(toReturn);
                out.flush();

                System.out.print("Client command: ");
                String received = in.readLine();
                System.out.println(received);

                if (received.equals("stop")) {
                    System.out.println("Client " + this.socket + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}