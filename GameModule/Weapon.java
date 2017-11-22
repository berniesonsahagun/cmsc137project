import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Weapon extends GameObject{
	public enum WeaponType{
		KAPE,SELPON,LAPTOP,SPRAY;
	}
	private Player player;
	private WeaponType weaponType;
	private Bullet bullet;
	private double projectileSpeed;
	private double range;
	private double cooldown;
	private double speed;
	public static final int NORTH = 1;
	public static final int NORTHEAST = 2;
	public static final int EAST = 3;
	public static final int SOUTHEAST = 4;
	public static final int SOUTH = 5;
	public static final int SOUTHWEST = 6;
	public static final int WEST = 7;
	public static final int NORTHWEST = 8;
	public static final int UNIT_MEASURE = 32;

	public Weapon(double x, double y, Controller controller, Player player){
		super(x,y,controller);
		this.player = player;
		setType(EntityType.WEAPON);
	}

	public void tick(){
		setX(player.getX());
		setY(player.getY());
		
		if(player.isTop && player.isRight)	getController().addEntity((Entity) new Bullet(getX(),getY(),getController(),getWeaponType(),NORTHEAST,getRange(),getProjectileSpeed()));
		else if(player.isTop && player.isLeft) getController().addEntity((Entity) new Bullet(getX(),getY(),getController(),getWeaponType(),NORTHWEST,getRange(),getProjectileSpeed()));
		else if(player.isBottom && player.isRight) getController().addEntity((Entity) new Bullet(getX(),getY(),getController(),getWeaponType(),SOUTHEAST,getRange(),getProjectileSpeed()));
		else if(player.isBottom && player.isLeft) getController().addEntity((Entity) new Bullet(getX(),getY(),getController(),getWeaponType(),SOUTHWEST,getRange(),getProjectileSpeed()));
		else if(player.isTop)	getController().addEntity((Entity) new Bullet(getX(),getY(),getController(),getWeaponType(),NORTH,getRange(),getProjectileSpeed()));
		else if(player.isRight)	getController().addEntity((Entity) new Bullet(getX(),getY(),getController(),getWeaponType(),EAST,getRange(),getProjectileSpeed()));
		else if(player.isBottom)	getController().addEntity((Entity) new Bullet(getX(),getY(),getController(),getWeaponType(),SOUTH,getRange(),getProjectileSpeed()));
		else if(player.isLeft)	getController().addEntity((Entity) new Bullet(getX(),getY(),getController(),getWeaponType(),WEST,getRange(),getProjectileSpeed()));

	}

	public WeaponType getWeaponType(){
		return this.weaponType;
	}
	public Bullet getBullet(){
		return this.bullet;
	}
	public double getCooldown(){
		return this.cooldown;
	}
	public double getRange(){
		return this.range;
	}
	public double getSpeed(){
		return this.speed;
	}
	public double getProjectileSpeed(){
		return this.projectileSpeed;
	}
	public void setWeaponType(WeaponType weaponType){
		this.weaponType = weaponType;
	}
	public void setBullet(Bullet bullet){
		this.bullet = bullet;
	}
	public void setCooldown(double cooldown){
		this.cooldown = cooldown;
	}
	public void setRange(double range){
		this.range = range;
	}
	public void setSpeed(double speed){
		this.speed = speed;
	}
	public void setProjectileSpeed(double projectileSpeed){
		this.projectileSpeed = projectileSpeed;
	}
}