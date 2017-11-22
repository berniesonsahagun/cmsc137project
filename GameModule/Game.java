import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.*;
import java.io.IOException;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	public static final int WIDTH = 384;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Millenial's War";

	private boolean running = false;
	private Thread thread;

	private long currentTime;
	private long timeElapsed;
	private long previousTime = 0;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage background = null;
	private BufferedImage map = null;

	private MapParser parser;
	private boolean is_shooting = false;

	private Player p;
	private Controller c;


	public void init(){
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			spriteSheet = loader.loadImage("/spritesheet.png");
			background = loader.loadImage("/background.png");
			map = loader.loadImage("/mapbig.png");
		}catch(IOException e){
			e.printStackTrace();
		}

		addKeyListener(new KeyInput(this));

		c = new Controller(this);

		parser = new MapParser(this,map,c);
		parser.parse();
		p = parser.getPlayer();
	}

	private synchronized void start(){
		if(running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop(){
		if(!running)
			return;

		running = false;
		try{
			thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.exit(1);
	}

	public void run(){
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();

		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	private void tick(){
		c.tick();
	}

	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

		c.render(g);

		g.dispose();
		bs.show();
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_RIGHT){
			p.setSpdX(5);
			p.isRight = true;
			p.isLeft = false;
		}else if(key == KeyEvent.VK_LEFT){
			p.setSpdX(-5);
			p.isRight = false;
			p.isLeft = true;
		}else if(key == KeyEvent.VK_DOWN){
			p.setSpdY(5);
			p.isBottom = true;
			p.isTop = false;
		}else if(key == KeyEvent.VK_UP){
			p.setSpdY(-5);
			p.isBottom = false;
			p.isTop = true;
		}else if(key == KeyEvent.VK_SPACE){
			currentTime = System.currentTimeMillis();
			timeElapsed = currentTime - previousTime;
			if(timeElapsed > ((int)p.getWeapon().getCooldown() * 1000))	{
				p.getWeapon().tick();
				previousTime = currentTime;
			}
		}
	}

	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_RIGHT){
			p.setSpdX(0);
		}else if(key == KeyEvent.VK_LEFT){
			p.setSpdX(0);
		}else if(key == KeyEvent.VK_DOWN){
			p.setSpdY(0);
		}else if(key == KeyEvent.VK_UP){
			p.setSpdY(0);
		}	
	}

	public static void main(String args[]){
		Game game = new Game();

		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();
	}

	public BufferedImage getSpriteSheet(){
		return spriteSheet;
	}
}