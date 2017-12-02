import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;


public class UDPClient implements Runnable{
	 DatagramSocket socket;
	 private boolean isConnected = false;
	 private String name = "Bernie";
	 private Thread t;
	 private String serverData;

	 public UDPClient(){
	 	try{
	 		socket = new DatagramSocket();
	 	}catch(IOException ioe){
	 		ioe.printStackTrace();
	 	}
	 	t = new Thread(this);
	 	t.start();
	 }

	 public boolean getIsConnected(){
	 	return this.isConnected;
	 }

	 public void run(){
	 	while(true){
	 		byte[] buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			try{
     			socket.receive(packet);
			}catch(Exception ioe){
				ioe.printStackTrace();
			}
			
			serverData=new String(buf);
			serverData=serverData.trim();
			System.out.println(serverData);

			if (!isConnected && serverData.startsWith("CONNECTED")){
				isConnected=true;
				System.out.println("Connected.");
			}else if (!isConnected){
				System.out.println("Connecting..");				
				send("CONNECT:"+name);
			}
	 	}
	 }

	 public void send(String msg){
		try{
			byte[] buf = msg.getBytes();
        	InetAddress address = InetAddress.getByName("localhost");
        	DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 8000);
        	socket.send(packet);
        }catch(Exception e){}
		
	}

	 public static void main(String args[]){
		UDPClient client = new UDPClient();
		BufferedReader inputLine = new BufferedReader(new InputStreamReader(System.in));
		client.send("CONNECT:Bernie");
		while(true){
			if(client.getIsConnected())	{
				try{
			 		client.send("MSG:"+inputLine.readLine());
			 	}catch(IOException ioe){
			 		ioe.printStackTrace();
			 	}
			}	
		}
	}
}