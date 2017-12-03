import java.awt.*;
import  javax.swing.*;

public class PlayScreen extends JPanel{

	public PlayScreen(){
        this.setLayout(null);
        this.add(Chatpanel);
        this.add(game);

	}

	private final ChatPanel Chatpanel = new ChatPanel();
	private final Game game = new Game();
}