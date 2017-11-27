import java.util.ArrayList;

public class Room{
	public enum RoomType{
		SMALL,BIG
	}

	private static int noOfRooms;
	private int id;
	private String name;
	private RoomType type;
	private ArrayList<Player> players;
	private ClientThread chatClient;

	public Room(String name, RoomType type){
		this.id = ++noOfRooms;
		this.name = name;
		this.type = type;
	}

	

	public void addPlayer(Player p){
		this.players.add(p);
	}
	public void removePlayer(Player p){
		this.players.remove(p);
	}
}