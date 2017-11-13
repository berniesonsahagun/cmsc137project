import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient implements Runnable {

  private static Socket clientSocket = null;
  private static DataOutputStream os = null;
  private static DataInputStream is = null;

  private static BufferedReader inputLine = null;
  private static boolean isClosed = false;
  
  public static void main(String[] args) {
    int portNumber = 2222;
    String host = "localhost";

    if (args.length < 2) {
      System.out.println("Now using default host: "+ host +" in port: "+portNumber);
    } else {
      host = args[0];
      portNumber = Integer.valueOf(args[1]).intValue();
    }
    try {
      clientSocket = new Socket(host, portNumber);
      inputLine = new BufferedReader(new InputStreamReader(System.in));
      os = new DataOutputStream(clientSocket.getOutputStream());
      is = new DataInputStream(clientSocket.getInputStream());
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host " + host);
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to the host "
          + host);
    }
    if (clientSocket != null && os != null && is != null) {
      try{
        new Thread(new ChatClient()).start();
        
        while (!isClosed) {
          os.writeUTF(inputLine.readLine().trim());
        }
        
        os.close();
        is.close();
        clientSocket.close();
      } catch (IOException e) {
        System.err.println("IOException:  " + e);
      }
    }
  }
  public void run() {
    String responseLine;
    try {
      while ((responseLine = is.readUTF()) != null) {
        System.out.println(responseLine);
        if (responseLine.indexOf("*** Bye") != -1)
          break;
      }
      isClosed = true;
    } catch (IOException e) {
      System.err.println("IOException:  " + e);
    }
  }
}