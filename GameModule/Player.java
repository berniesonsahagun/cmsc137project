import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class Player extends GameObject{
	private double spdX;
	private double spdY;
	private Weapon weapon;
	public boolean isTop = false,isLeft = false,isRight = false,isBottom = true;
	private int lastKeyPressed;

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
			collide();
		}

		if(getX() <= 0 - 7)
			setX(0-7);
		if(getX() >= (Game.WIDTH) - 16)
			setX((Game.WIDTH) - 16);
		if(getY() <= 0)
			setY(0);
		if(getY() >= (Game.HEIGHT) - 32)
			setY((Game.HEIGHT) - 32);
	}

	private void collide(){
		Entity collidedEntity = CollisionChecker.collidedEntity;
		Entity.EntityType type = collidedEntity.getType();

		if(type == Entity.EntityType.POWERBLOCK){
			getController().removeEntity(getWeapon());

			switch(collidedEntity.getPowerType()){
				case PowerBlock.KAPE_POWER:
					this.weapon = new Kape(getX(), getY(), getController(), this);
					getController().addEntity(this.weapon);
					break;
				case PowerBlock.LAPTOP_POWER:
					this.weapon = new Laptop(getX(), getY(), getController(), this);
					getController().addEntity(this.weapon);
					break;
				case PowerBlock.SELPON_POWER:
					this.weapon = new Selpon(getX(), getY(), getController(), this);
					getController().addEntity(this.weapon);
					break;
				case PowerBlock.SPRAY_POWER:
					this.weapon = new Spray(getX(), getY(), getController(), this);
					getController().addEntity(this.weapon);
					break;
			}
			getController().removeEntity(collidedEntity);
		}else{
			setX(getX()-spdX);
			setY(getY()-spdY);
		}
	}

	public void render(Graphics g){
		g.drawImage(getWeapon().getImage(),(int)getX(), (int)getY(), 32, 32,null);
	}

	public int getLastKeyPressed(){
		return this.lastKeyPressed;
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
	public void setWeapon(Weapon weapon){
		this.weapon = weapon;
	}
	public void setLastKeyPressed(int key){
		this.lastKeyPressed = key;
	}
}