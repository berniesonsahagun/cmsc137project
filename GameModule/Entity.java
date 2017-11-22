import java.awt.image.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public interface Entity{
	public enum EntityType{
		BLOCK, WALL, ALLY, FOE, WEAPON, BULLET, POWERBLOCK;
	}
	public void tick();
	public void render(Graphics g);
	public double getX();
	public double getY();
	public EntityType getType();
	public Controller getController();
	public int getHP();
	public void setX(double x);
	public void setY(double y);
	public void setType(EntityType type);
	public void setController(Controller controller);
	public void setHP(int hp);
	public Rectangle getBounds();
	public int getPowerType();
}