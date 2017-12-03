import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

public class UDPServer implements Runnable{
    DatagramSocket serverSocket = null;
	private Thread t = new Thread(this);
	String serverData;
	private ArrayList<PlayerInfo> players;

	public UDPServer(){
		players = new ArrayList<PlayerInfo>();
		try {
            serverSocket = new DatagramSocket(8000);
		} catch (IOException e) {
            System.err.println("Could not listen on port: "+8000);
            System.exit(-1);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Listening at papapapa");
		t.start();
	}

	public void run(){
		while(true){
			byte[] buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);

			try{
	 			serverSocket.receive(packet);
			}catch(Exception ioe){
				ioe.printStackTrace();
			}
			
			serverData=new String(buf);
			serverData=serverData.trim();
			System.out.println(serverData);
			String[] tokens = serverData.split(":");

			if(serverData.startsWith("CONNECT")){
				players.add(new PlayerInfo(tokens[1],packet.getAddress(),packet.getPort()));
				send(players.get(players.size()-1),"CONNECTED");
			}else if(serverData.startsWith("MSG")){
				for(int i=0; i<players.size(); i++){
					send(players.get(i),players.get(i).getName()+tokens[1]);
				}
			}
		}
	}

	public void send(PlayerInfo player, String msg){
		DatagramPacket packet;	
		byte buf[] = msg.getBytes();		
		packet = new DatagramPacket(buf, buf.length, player.getAddress(),player.getPort());
		try{
			serverSocket.send(packet);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	
	public static void main(String args[]){
		new UDPServer();
	}
}
