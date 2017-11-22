import java.awt.image.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public abstract class GameObject implements Entity{
	private double x = 0;
	private double y = 0;
	private int hp = 5;
	private EntityType type;
	private BufferedImage image;
	private Controller controller;

	public GameObject(double x, double y, Controller controller){
		this.x = x;
		this.y = y;
		this.controller = controller;
	}
	
	public void tick(){
		
	}

	public void render(Graphics g){
	}
	
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public EntityType getType(){
		return this.type;
	}
	public Controller getController(){
		return this.controller;
	}
	public int getHP(){
		return this.hp;
	}
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public void setType(EntityType type){
		this.type = type;
	}
	public void setController(Controller controller){
		this.controller = controller;
	}
	public void setHP(int hp){
		this.hp = hp;
	}    
	public Rectangle getBounds() {
        return new Rectangle((int) this.getX(), (int) this.getY(), 32, 32);
    }
}