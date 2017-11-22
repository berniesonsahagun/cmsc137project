import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class Selpon extends Weapon{
	public Selpon(double x, double y, Controller controller, Player player){
		super(x,y,controller,player);

		setWeaponType(WeaponType.SELPON);
		setSpeed(0.7);
		setCooldown(0.5);
		setRange(3*Weapon.UNIT_MEASURE);
		setProjectileSpeed(1.5);
		//image = transform the person into a Selpon-man
	}
	public void render(Graphics g){
		g.setColor(Color.cyan);
		g.drawRect((int)getX(), (int)getY(), Weapon.UNIT_MEASURE, Weapon.UNIT_MEASURE);
	}
}