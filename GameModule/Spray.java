import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class Spray extends Weapon{
	public Spray(double x, double y, Controller controller, Player player){
		super(x,y,controller,player);
		setWeaponType(WeaponType.SPRAY);
		setSpeed(0.5);
		setCooldown(0.7);
		setRange(Weapon.UNIT_MEASURE);
		setProjectileSpeed(0);
		//image = transform the person into a spray-man
	}
	public void render(Graphics g){
		g.setColor(Color.cyan);
		g.drawRect((int)getX(), (int)getY(), Weapon.UNIT_MEASURE, Weapon.UNIT_MEASURE);
	}
}