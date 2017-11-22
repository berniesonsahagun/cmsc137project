import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Wall extends GameObject{
	public Wall(double x, double y, Controller controller){
		super(x,y,controller);
		setType(EntityType.WALL);
	}

	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.drawRect((int)getX(), (int)getY(), 32, 32);
		
	}
}