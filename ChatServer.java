import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ChatServer {
  private static ServerSocket serverSocket = null;
  private static Socket clientSocket = null;
  private static final ArrayList<ClientThread> threads= new ArrayList<ClientThread>();

  public static void main(String args[]) {

    int portNumber = 2222;

    if (args.length < 1) {
      System.out.println("Chat service available at port "+portNumber);
    } else {
      portNumber = Integer.valueOf(args[0]).intValue();
    }

    try {
      serverSocket = new ServerSocket(portNumber);
    } catch (IOException e) {
      System.out.println(e);
    }

    while (true) {
      try {
        clientSocket = serverSocket.accept();
        
        threads.add(new ClientThread(clientSocket, threads));
        threads.get(threads.size()-1).start();

      }catch(IOException e) {
        e.printStackTrace();
      }
    }
  }
}