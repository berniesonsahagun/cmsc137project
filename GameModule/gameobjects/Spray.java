package cmsc137project.game.gameobjects;

public class Spray implements Weapon{
	public WeaponType getType(){
		return this.type;
	}
	public Bullet getBullet(){
		return this.bullet;
	}
	public int getDamage(){
		return this.damage;
	}
	public double getRange(){
		return this.range;
	}
	public double getSpeed(){
		return this.speed;
	}
	public double getRechargeTime(){
		return this.rechargeTime;
	}
	public void setType(WeaponType type){
		this.type = type;
	}
	public void setBullet(Bullet bullet){
		this.bullet = bullet;
	}
	public void setDamage(int damage){
		this.damage = damage;
	}
	public void setRange(double range){
		this.range = range;
	}
	public void setSpeed(double speed){
		this.speed = speed;
	}
	public void setRechargeTime(double rechargeTime){
		this.rechargeTime = rechargeTime;
	}
}