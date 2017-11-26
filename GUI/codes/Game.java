import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter; //**NEW**
import java.awt.event.WindowEvent; //**NEW**

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;

public class Game extends JFrame{
	private static JPanel screenDeck = new JPanel(new CardLayout());
	private static Container gameContainer;

	public Game(String name){
		super(name);
		this.setFrame();
		this.addPanels();
		this.setFinalFrame();
	}

	private void setFrame(){//----------setting starting values of frame
		this.setPreferredSize(new Dimension(900,700));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  //**CHANGED**
		this.addWindowListener(new ConfirmOnClose());  //**NEW**
		this.setIconImage(Misc.loadImage("logo"));
	}
	private class ConfirmOnClose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			int choice = JOptionPane.showConfirmDialog(null, "Would you like to Exit the game?", "Millennial's War", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) { //user input: YES
				System.exit(1);
			}		
		}
	}
	private void addPanels(){
		gameContainer = this.getContentPane();
		screenDeck = new JPanel(new CardLayout());
		
		screenDeck.add(new OpeningScreen(), "Opening Screen");
		screenDeck.add(new HelpScreen(), "Help Screen");
		screenDeck.add(new MainMenu(),"Main Menu");
		screenDeck.add(new EnterName(),"Enter Name");
<<<<<<< HEAD
		screenDeck.add(new PlayScreen(), "PlayScreen");
=======
		screenDeck.add(new GameRoomList(),"Game Room List");
		screenDeck.add(new AddGameRoom(),"Add Room");
		screenDeck.add(new SmallRoom(),"Small Room");
		screenDeck.add(new LargeRoom(),"Large Room");
>>>>>>> d475b4de923dd02b25674fcfcf88f5195c013825
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
}