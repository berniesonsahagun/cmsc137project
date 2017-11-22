import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
	private double spdX;
	private double spdY;
	private Weapon weapon;
	public boolean isTop = false,isLeft = false,isRight = false,isBottom = false;

	public Player(double x, double y, Controller controller){
		super(x,y,controller);
		setType(EntityType.ALLY);
		this.spdX = 0;
		this.spdY = 0;
		this.weapon = new Laptop(x,y,controller,this);
		controller.addEntity(this.weapon);
	}

	public void tick(){
		setX(getX()+spdX);
		setY(getY()+spdY);

		if(CollisionChecker.isColliding(this,getController())) {
			setX(getX()-spdX);
			setY(getY()-spdY);
		}

		if(getX() <= 0 - 7)
			setX(0-7);
		if(getX() >= (Game.WIDTH*Game.SCALE) - 16)
			setX((Game.WIDTH*Game.SCALE) - 16);
		if(getY() <= 0)
			setY(0);
		if(getY() >= (Game.HEIGHT*Game.SCALE) - 32)
			setY((Game.HEIGHT*Game.SCALE) - 32);
	}

	public void render(Graphics g){
		g.setColor(Color.BLUE);
		g.drawRect((int)getX(), (int)getY(), 32, 32);
		
	}

	public double getSpdX(){
		return this.spdX;
	}
	public double getSpdY(){
		return this.spdY;
	}
	public Weapon getWeapon(){
		return this.weapon;
	}
	public void setSpdX(double spdX){
		this.spdX = spdX;
	}
	public void setSpdY(double spdY){
		this.spdY = spdY;
	}

}