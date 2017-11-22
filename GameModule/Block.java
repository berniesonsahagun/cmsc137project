import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Block extends GameObject{
	//destructible, sometimes spawn weapons
	public Block(double x, double y, Controller controller){
		super(x,y,controller);
		setType(EntityType.BLOCK);
		//initialize image
	}
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		g.drawRect((int)getX(), (int)getY(), 32, 32);

	}
}