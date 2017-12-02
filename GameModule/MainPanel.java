import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;

public class MainPanel extends JFrame{
	private static JPanel screenDeck = new JPanel(new CardLayout());
	private static Container gameContainer;
	private static String playerName;
	
	private OpeningScreen opening;
	private HelpScreen help;
	private MainMenu mainMenu;
	private EnterName enterName;
	private static Game game;
	private GameRoomList gameRoomList;
	private AddGameRoom addGameRoom;
	private LargeRoom largeRoom;
	private SmallRoom smallRoom;

	public MainPanel(String name){
		super(name);
		this.setFrame();
		this.addPanels();
		this.setFinalFrame();
	}


	private void setFrame(){
		this.setPreferredSize(new Dimension(900,700));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		this.addWindowListener(new ConfirmOnClose());
		this.setIconImage(Misc.loadImage("logo"));
	}

	private class ConfirmOnClose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			int choice = JOptionPane.showConfirmDialog(null, "Would you like to Exit the game?", "Millennial's War", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) { 
				System.exit(1);
			}		
		}
	}
	private void addPanels(){
		opening = new OpeningScreen();
		help = new HelpScreen();
		mainMenu = new MainMenu();
		enterName = new EnterName();
		game = new Game();
		gameRoomList = new GameRoomList();
		addGameRoom = new AddGameRoom();
		smallRoom = new SmallRoom();
		largeRoom = new LargeRoom();

		gameContainer = this.getContentPane();
		screenDeck = new JPanel(new CardLayout());
		
		screenDeck.add(opening, "Opening Screen");
		screenDeck.add(help, "Help Screen");
		screenDeck.add(mainMenu,"Main Menu");
		screenDeck.add(enterName,"Enter Name");
		screenDeck.add(game, "Game");
		screenDeck.add(gameRoomList,"Game Room List");
		screenDeck.add(addGameRoom,"Add Room");
		screenDeck.add(smallRoom,"Small Room");
		screenDeck.add(largeRoom,"Large Room");
		gameContainer.add(screenDeck);
	}
	private void setFinalFrame(){
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	//-------getters
	public static JPanel getCardsPanel(){return screenDeck;}
	public static Container getContainer(){return gameContainer;}
	public static void setPlayerName(String name){playerName = name;}
	public static void switchPanels(String tag){
		if(tag.equals("Game")){
			game.start();
		}
		CardLayout c = (CardLayout)MainPanel.getCardsPanel().getLayout();
		c.show(MainPanel.getCardsPanel(), tag);
	}
}