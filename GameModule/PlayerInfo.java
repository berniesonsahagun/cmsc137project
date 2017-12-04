public class PlayerInfo{
	private static String playerName;

	public PlayerInfo(String playerName){
		this.playerName = playerName;
	}

	public static String getName(){
		return playerName;
	}
}