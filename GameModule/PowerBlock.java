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

		switch(powerType){
			case KAPE_POWER:
				setImage(SpriteSheet.grabImage(getController().getImage(),5,1));
				break;
			case LAPTOP_POWER:
				setImage(SpriteSheet.grabImage(getController().getImage(),2,1));
				break;
			case SELPON_POWER:
				setImage(SpriteSheet.grabImage(getController().getImage(),4,1));
				break;
			case SPRAY_POWER:
				setImage(SpriteSheet.grabImage(getController().getImage(),6,1));
				break;
		}
	}
	
	public void render(Graphics g){
		g.drawImage(getImage(), (int)getX(), (int)getY(), 32, 32, null);
	}

	public int getPowerType(){
		return this.powerType;
	}
}