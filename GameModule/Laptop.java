import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Laptop extends Weapon{
	public Laptop(double x, double y, Controller controller, Player player){
		super(x,y,controller,player);
		setWeaponType(WeaponType.LAPTOP);
		setSpeed(1);
		setCooldown(0.5);
		setRange(Weapon.UNIT_MEASURE);
		setProjectileSpeed(5);
		//image = transform the person into a laptop-man
	}

	public void render(Graphics g){
		g.setColor(Color.cyan);
		g.drawRect((int)getX(), (int)getY(), Weapon.UNIT_MEASURE, Weapon.UNIT_MEASURE);
	}
}