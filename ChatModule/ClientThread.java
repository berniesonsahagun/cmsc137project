import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ClientThread extends Thread {

  private String clientName = null;
  private DataInputStream is = null;
  private DataOutputStream os = null;
  private Socket clientSocket = null;
  private final ArrayList<ClientThread> threads;

  public ClientThread(Socket clientSocket, ArrayList<ClientThread> threads) {
    this.clientSocket = clientSocket;
    this.threads = threads;
  }

  public void run() {
    ArrayList<ClientThread> threads = this.threads;

    try {
      is = new DataInputStream(clientSocket.getInputStream());
      os = new DataOutputStream(clientSocket.getOutputStream());
      String name;
      while (true) {
        os.writeUTF("Enter your name.");
        name = is.readUTF().trim();
        if (name.indexOf('@') == -1) {
          break;
        } else {
          os.writeUTF("The name should not contain '@' character.");
        }
      }

      os.writeUTF("Welcome " + name
          + " to our chat room.\nTo leave enter /quit in a new line.");
      synchronized (this) {

        for(int i=0; i<threads.size(); i++){
          if (threads.get(i) == this) {
            clientName = "@" + name;
            break;
          }
        }
        
        for (int i = 0; i < threads.size(); i++) {
          if (threads.get(i) == this) {
            threads.get(i).os.writeUTF("*** A new user " + name
                + " entered the chat room !!! ***");
          }
        }
      }

      while (true) {
        String line = is.readUTF();
        if (line.startsWith("/quit")) {
          break;
        }

        if (line.startsWith("@")) {
          String[] words = line.split("\\s", 2);
          if (words.length > 1 && words[1] != null) {
            words[1] = words[1].trim();
            if (!words[1].isEmpty()) {
              synchronized (this) {
                for (int i = 0; i < threads.size(); i++) {
                  if (threads.get(i).clientName.equals(words[0])) {
                    threads.get(i).os.writeUTF("<" + name + "> " + words[1]);
                    
                    this.os.writeUTF(">" + name + "> " + words[1]);
                    break;
                  }
                }
              }
            }
          }
        } else {
          synchronized (this) {
            for (int i = 0; i < threads.size(); i++) {
              threads.get(i).os.writeUTF("<" + name + "> " + line);
            }
          }
        }
      }
      synchronized (this) {
        for (int i = 0; i < threads.size(); i++) {
          if (threads.get(i) != this) {
            threads.get(i).os.writeUTF("*** The user " + name
                + " is leaving the chat room !!! ***");
          }
        }
      }
      os.writeUTF("*** Bye " + name + " ***");


      synchronized (this) {
        threads.clear();
      }
      
      is.close();
      os.close();
      clientSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}