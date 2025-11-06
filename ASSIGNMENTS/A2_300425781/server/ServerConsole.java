package server;

import java.util.Scanner;

import client.ChatIF;

public class ServerConsole implements ChatIF {
    
    // instance variables
    Scanner consoleIn;
    EchoServer server;
    final public static int DEFAULT_PORT = 5555;

    // constructor
    public ServerConsole(String host, int port) {
        server = new EchoServer(port, this);
        
        try {
            server.listen(); //Start listening for connections
        } 
        catch (Exception ex) {
            System.out.println("ERROR - Could not listen for clients!");
        }

        consoleIn = new Scanner(System. in);
    }

    @Override
    public void display(String message) { System.out.println("SERVER MSG> " + message); }


    public void accept() {
        try {
            String message;

            while (true) {
                message = consoleIn.nextLine();
                server.handleMessageFromServerUI(message);
            }
        } catch (Exception e) {
            System.out.println("Unexpected error while reading from console. Terminating...");
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        int port = 0;

        // testing
        args = new String[1];
        args[0] = "1234";

        try {
            port = Integer.parseInt(args[0]); // Get port from command line
        } catch (Throwable t) {
            port = DEFAULT_PORT; // Set port to 5555
        }
        
        ServerConsole serv = new ServerConsole("localhost", port);
        System.out.println("Server console active.");
        serv.accept();
    }
}
