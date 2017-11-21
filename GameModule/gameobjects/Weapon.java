package cmsc137project.game.gameobjects;

public interface Weapon extends GameObject{
	private WeaponType type;
	private Bullet bullet;
	private int damage;
	private double range;
	private double speed;
	private double rechargeTime;

	public WeaponType getType();
	public Bullet getBullet();
	public int getDamage();
	public double getRange();
	public double getSpeed();
	public double getRechargeTime();
	public void setType(WeaponType type);
	public void setBullet(Bullet bullet);
	public void setDamage(int damage);
	public void setRange(double range);
	public void setSpeed(double speed);
	public void setRechargeTime(double rechargeTime);
}