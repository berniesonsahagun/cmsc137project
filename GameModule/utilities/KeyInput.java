package cmsc137project.game.utilities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyInput extends KeyAdapter{
	Game game;

	public KeyInput(Game game){
		this.game = game;
	}

	public void keyPressed(KeyEvent e){
		game.keyPressed(e);
	}

	public void keyReleased(KeyEvent e){
		game.keyReleased(e);
	}
}