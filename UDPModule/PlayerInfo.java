import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PlayerInfo{
	private String name;
	private InetAddress address;
	private int port;

	public PlayerInfo(String name, InetAddress address, int port){
		this.address = address;
		this.port = port;
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public InetAddress getAddress(){
		return this.address;
	}

	public int getPort(){
		return this.port;
	}
}