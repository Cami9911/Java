package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try {
            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket(serverAddress, PORT);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Client connected");
            while (true) {
                System.out.print("Server command: ");
                System.out.println(in.readLine());

                System.out.print("Write a command: ");
                String toSend = scanner.nextLine();
                out.println(toSend);
                out.flush();

                if (toSend.equals("stop")) {
                    System.out.println("Closing this connection");
                    socket.close();
                    System.out.println("Connection closed");
                    break;
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
