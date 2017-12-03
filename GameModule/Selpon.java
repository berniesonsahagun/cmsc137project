import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class Selpon extends Weapon{
	public Selpon(double x, double y, Controller controller, Player player){
		super(x,y,controller,player);
		setWeaponType(WeaponType.SELPON);
		setSpeed(0.7);
		setCooldown(1.5);
		setRange(3*Weapon.UNIT_MEASURE);
		setProjectileSpeed(2);
	}
	public void render(Graphics g){
		if(getPlayer().isBottom){
			setImage(SpriteSheet.grabImage(getController().getImage(),4,2));
		}else if(getPlayer().isRight){
			setImage(SpriteSheet.grabImage(getController().getImage(),4,3));
		}else if(getPlayer().isLeft){
			setImage(SpriteSheet.grabImage(getController().getImage(),4,4));
		}else if(getPlayer().isTop){
			setImage(SpriteSheet.grabImage(getController().getImage(),4,5));
		} 

		g.drawImage(getImage(), (int)getX(), (int)getY(), Weapon.UNIT_MEASURE, Weapon.UNIT_MEASURE, null);
	}
}