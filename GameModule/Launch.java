public class Launch{
	public static void main(String[] args){
		if (args.length != 1){
			System.out.println("Enter ip address.");
			System.exit(1);
		}
		RoomsThread roomsThread = new RoomsThread();
		MainPanel main = new MainPanel("Millennial's War", args[0]);//just to launch the game
	}
}