package client;
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 */
public class ChatClient extends AbstractClient
{
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI; 
  private String loginID;

  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  
  public ChatClient(String host, int port, ChatIF clientUI, String loginID) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    this.loginID = loginID;
    openConnection();

    sendToServer("#login " + loginID);
  }

  
  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) {
    String message = msg.toString();

    if (message.indexOf("#") == 0)
      System.out.println("SERVER MSG> " + message.substring(1));
    else
      System.out.println(msg);
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  public void handleMessageFromClientUI(String message)
  {
    try
    {
      if (message.startsWith("#"))
        handleCommand(message);
      else
        sendToServer(message);
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server. Terminating client.");
      quit();
    }
  }
  
  private void handleCommand(String command) {
    command = command.toLowerCase().trim();

    if (command.equals("#quit")) {
      System.out.println("Terminating process..."); // want a different display message
      System.exit(0);
    } else if (command.equals("#logoff")) {
      try {
        closeConnection();
      } catch (IOException e) {
        clientUI.display("Error trying to disconnect. Terminating process...");
        System.exit(0);
      }
    } else if (command.contains("#sethost ")) {
      if (isConnected())
        clientUI.display("Cannot invoke \"#sethost\" whilst connected to the server!");
      else {
        String host0 = command.substring(command.indexOf(" ") + 1);
        setHost(host0);
      }
    } else if (command.contains("#setport ")) {
      if (isConnected())
        clientUI.display("Cannot invoke \"setport\" whilst connected to the server!");
      else {
        int port0 = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
        setPort(port0);
      }
    } else if (command.equals("#login")) {
      if (isConnected())
        clientUI.display("Already connected!");
      else {
        try {
          openConnection();
          sendToServer("#login " + loginID);
          clientUI.display("Successfully connected to the server.");
        } catch (IOException e) {
          clientUI.display("Failed to connect to the server. Terminating process...");
          System.exit(0);
        }
      }
    } else if (command.equals("#gethost")) {
      clientUI.display("Host: " + getHost());
    } else if (command.equals("#getport")) {
      clientUI.display("Port: " + getPort());
    } else {
      clientUI.display("Unknown command \"" + command.substring(1) + "\"");
    }
  }


  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }


  // exercise 1

  @Override
  protected void connectionException(Exception exception) {
    clientUI.display("Connection to server lost.");
    
    try {
      closeConnection();
    } catch (IOException e) {
      clientUI.display("Failed to disconnect gracefully. Terminating process...");
      System.exit(0);
    }

  }

  protected void connectionClosed() {
    clientUI.display("Connection to the server has been terminated.");
  }

  
  public String getLoginID() { return loginID; }
}
//End of ChatClient class
