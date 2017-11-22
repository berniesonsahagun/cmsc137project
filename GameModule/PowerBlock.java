import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class PowerBlock extends GameObject{
	private static final Random rand = new Random();
	public static final int KAPE_POWER = 1;
	public static final int LAPTOP_POWER = 2;
	public static final int SELPON_POWER = 3;
	public static final int SPRAY_POWER = 4;
	private int powerType;

	public PowerBlock(double x, double y, Controller controller){
		super(x,y,controller);
		setType(EntityType.POWERBLOCK);
		this.powerType = rand.nextInt(4) + 1;
		//initialize image
	}
	
	public void render(Graphics g){
		switch(powerType){
			case KAPE_POWER:
				g.setColor(Color.darkGray);
				break;
			case LAPTOP_POWER:
				g.setColor(Color.yellow);
				break;
			case SELPON_POWER:
				g.setColor(Color.green);
				break;
			case SPRAY_POWER:
				g.setColor(Color.pink);
				break;
		}

		g.drawRect((int)getX(), (int)getY(), 32, 32);

	}

	public int getPowerType(){
		return this.powerType;
	}
}