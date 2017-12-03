import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class Spray extends Weapon{
	public Spray(double x, double y, Controller controller, Player player){
		super(x,y,controller,player);
		setWeaponType(WeaponType.SPRAY);
		setSpeed(0.5);
		setCooldown(1.7);
		setRange(Weapon.UNIT_MEASURE);
		setProjectileSpeed(5);
	}

	public void render(Graphics g){
		if(getPlayer().isBottom){
			setImage(SpriteSheet.grabImage(getController().getImage(),6,2));
		}else if(getPlayer().isRight){
			setImage(SpriteSheet.grabImage(getController().getImage(),6,3));
		}else if(getPlayer().isLeft){
			setImage(SpriteSheet.grabImage(getController().getImage(),6,4));
		}else if(getPlayer().isTop){
			setImage(SpriteSheet.grabImage(getController().getImage(),6,5));
		} 

		g.drawImage(getImage(), (int)getX(), (int)getY(), Weapon.UNIT_MEASURE, Weapon.UNIT_MEASURE, null);
	}
}