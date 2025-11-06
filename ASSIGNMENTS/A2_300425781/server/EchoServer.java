package server;
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.IOException;

import client.ChatIF;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************

  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  ChatIF serverUI;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port, ChatIF serverUI) 
  {
    super(port);
    this.serverUI = serverUI;
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
    String message = msg.toString();

    if (message.contains("#login ")) {
      client.setInfo("login", message.substring(message.indexOf(" ") + 1));
      System.out.println("Client <" + client.getInfo("login") + "> has connected.");
      System.out.println("Message received: " + msg + " from <" + client.getInfo("login") + ">");
      System.out.println("<" + client.getInfo("login") + "> has logged in.");
    } else if (message.equals("#login")) {
      System.out.println("Illegal invocation of \"login\". Terminating...");
      
    } else {
      System.out.println("Message received: " + msg + " from <" + client.getInfo("login") + ">");
      this.sendToAllClients(client.getInfo("login").toString() + "> " + msg);
    }
  }
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }

  // exercise 1

  @Override
  protected void clientConnected(ConnectionToClient client) {
  }

  @Override
  protected void clientDisconnected(ConnectionToClient client) {
    System.out.println("Client <" + client.getInfo("login") + "> has disconnected.");
	}

  
  // exercise 2
  public void handleMessageFromServerUI(String message) {
      try {
        if (message.startsWith("#"))
            handleCommand(message);
        else {
            sendToAllClients("#" + message);
            System.out.println("SERVER MSG> " + message);
        }
      } catch (Exception e) {
        System.out.println("Failed to broadcast message.");
      }
  }


  private void handleCommand(String command) {
    command = command.toLowerCase().trim();

    if (command.equals("#quit")) {
      try {
        close();
      System.out.println("Terminating server...");
      } catch (IOException e) {
        System.out.println("Failed to close gracefully. Terminating server...");
        System.exit(0);
      }

      System.out.println("Successfully closed server.");
      System.exit(0);
    } else if (command.equals("#stop")) {
      stopListening();
      System.out.println("Halting listening for clients...");
    } else if (command.equals("#close")) {
      try {
        close();
      } catch (IOException e) {
        System.out.println("Failed to close gracefully. Terminating server...");
        System.exit(0);
      }
    } else if (command.contains("#setport ")) {
      if (isListening())
        System.out.println("Cannot invoke \"setport\" whilst listening.");
      else {
        int port0 = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
        setPort(port0);
      }
    } else if (command.equals("#start")) {
      if (isListening())
        System.out.println("Already listening.");
      else {
        try {
            listen(); 
        } catch (Exception ex) {
            System.out.println("ERROR - Could not listen for clients!");
        }
      }
    } else if (command.equals("#getport")) {
      System.out.println("Port: " + getPort());
    } else {
      System.out.println("Unknown command \"" + command.substring(1) + "\"");
    }
  }
}
//End of EchoServer class
