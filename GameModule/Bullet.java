import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject{
	private Weapon.WeaponType weaponType;
	private int direction;
	private double range;
	private double distanceX;
	private double distanceY;
	private double projectileSpeed;
	private double originX;
	private double originY;

	public Bullet(double x, double y, Controller controller, Weapon.WeaponType weaponType, int direction, double range, double projectileSpeed){
		super(x,y,controller);
		this.weaponType = weaponType;
		setType(EntityType.BULLET);
		this.originX = x;
		this.originY = y;
		this.range = range;
		this.projectileSpeed = projectileSpeed;
		this.direction = direction;
		this.distanceX = (direction == Weapon.NORTH || direction == Weapon.NORTHEAST || direction == Weapon.NORTHWEST) ? getX()-range : getX()+range;
		this.distanceY = (direction == Weapon.WEST || direction == Weapon.SOUTHWEST || direction == Weapon.NORTHWEST) ? getY()-range : getY()+range;
	}

	public void tick(){
		if(Math.abs(getX()-originX) >= range || Math.abs(getY()-originY) >= range){	
			getController().removeEntity((Entity)this);
			return;
		}
		switch(direction){
			case Weapon.NORTH:
				setX(getX());
				setY(getY()-(distanceY/(60*projectileSpeed)));
				break;
			case Weapon.NORTHEAST:
				setX(getX()+(distanceX/(60*projectileSpeed)));
				setY(getY()-(distanceY/(60*projectileSpeed)));
				break;
			case Weapon.NORTHWEST:
				setX(getX()-(distanceX/(60*projectileSpeed)));
				setY(getY()-(distanceY/(60*projectileSpeed)));
				break;
			case Weapon.SOUTH:
				setX(getX());
				setY(getY()+(distanceY/(60*projectileSpeed)));
				break;
			case Weapon.SOUTHEAST:
				setX(getX()+(distanceX/(60*projectileSpeed)));
				setY(getY()+(distanceY/(60*projectileSpeed)));
				break;
			case Weapon.SOUTHWEST:
				setX(getX()-(distanceX/(60*projectileSpeed)));
				setY(getY()+(distanceY/(60*projectileSpeed)));
				break;
			case Weapon.EAST:
				setX(getX()+(distanceX/(60*projectileSpeed)));
				setY(getY());
				break;
			case Weapon.WEST:
				setX(getX()-(distanceX/(60*projectileSpeed)));
				setY(getY());
				break;
		}

		if(CollisionChecker.isColliding(this,getController()))	collide();
	}

	private void collide(){
		Entity collidedEntity = CollisionChecker.collidedEntity;
		Entity.EntityType type = collidedEntity.getType();

		switch(type){
			case BLOCK:
				getController().removeEntity((Entity) this);
				getController().removeEntity((Entity) collidedEntity);
				break;
			case FOE:
				getController().removeEntity((Entity) this);
				collidedEntity.setHP(getHP()-1);
				break;
			default:
				getController().removeEntity((Entity) this);
				break; 
		}
	}

	public void render(Graphics g){
		g.setColor(Color.magenta);
		g.drawRect((int)getX(), (int)getY(), Weapon.UNIT_MEASURE, Weapon.UNIT_MEASURE);
	}
}