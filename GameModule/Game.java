import java.awt.*;
import java.awt.BorderLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


import javax.swing.JFrame;

public class Game extends JPanel implements Runnable{
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
	private PlayScreen ps;
	private Player p;
	private Controller c;
	private Room room;

	public Game(){
		super(new BorderLayout());
		this.room = room;
		init();
	}

	public void init(){
		
		this.setFocusable(true);

		spriteSheet = Misc.loadImage("spritesheet");
		background = Misc.loadImage("background");
		map = Misc.loadImage("map");

		this.addKeyListener(new KeyInput(this));

		c = new Controller(this);

		parser = new MapParser(this,map,c);
		parser.parse();
		p = parser.getPlayer();
	}

	protected synchronized void start(){
		if(running)
			return;
		running = true;
		requestFocus();
		thread = new Thread(this);
		thread.start();
	}

	protected synchronized void stop(){
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
			repaint();
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				System.out.println("TICKS:" +updates+" FPS: "+frames);
				timer += 1000;
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	private void tick(){
		if(running)	c.tick();
	}

	public void paintComponent(Graphics g){
		if(!running) return;
		Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        super.paintComponent(g);

        try {
            g2d.drawImage(background, 0, 0,
                this.getWidth(), this.getHeight(), null);

            g2d.setColor(new Color(1, 68, 33, 128));
            
            c.render(g);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		System.out.println("Pressed: "+e);
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



	public BufferedImage getSpriteSheet(){
		return spriteSheet;
	}
}