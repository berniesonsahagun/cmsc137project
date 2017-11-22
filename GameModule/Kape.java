import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Kape extends Weapon{
	public Kape(double x, double y, Controller controller, Player player){
		super(x,y,controller,player);
		setWeaponType(WeaponType.KAPE);
		setSpeed(1.2);
		setCooldown(0.3);
		setRange(2*Weapon.UNIT_MEASURE);
		setProjectileSpeed(0.2);

		//image = transform the person into a kape-man
	}

	public void render(Graphics g){
		g.setColor(Color.cyan);
		g.drawRect((int)getX(), (int)getY(), Weapon.UNIT_MEASURE, Weapon.UNIT_MEASURE);
	}
}