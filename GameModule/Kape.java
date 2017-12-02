import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Kape extends Weapon{
	public Kape(double x, double y, Controller controller, Player player){
		super(x,y,controller,player);
		setWeaponType(WeaponType.KAPE);
		setSpeed(1.2);
		setCooldown(1.2);
		setRange(2*Weapon.UNIT_MEASURE);
		setProjectileSpeed(3);
	}

	public void render(Graphics g){
		if(getPlayer().isBottom){
			setImage(SpriteSheet.grabImage(getController().getImage(),5,2));
		}else if(getPlayer().isRight){
			setImage(SpriteSheet.grabImage(getController().getImage(),5,3));
		}else if(getPlayer().isLeft){
			setImage(SpriteSheet.grabImage(getController().getImage(),5,4));
		}else if(getPlayer().isTop){
			setImage(SpriteSheet.grabImage(getController().getImage(),5,5));
		} 

		g.drawImage(getImage(), (int)getX(), (int)getY(), Weapon.UNIT_MEASURE, Weapon.UNIT_MEASURE, null);
	}
}