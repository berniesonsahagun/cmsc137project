import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Laptop extends Weapon{
	public Laptop(double x, double y, Controller controller, Player player){
		super(x,y,controller,player);
		setWeaponType(WeaponType.LAPTOP);
		setSpeed(1);
		setCooldown(2);
		setRange(Weapon.UNIT_MEASURE);
		setProjectileSpeed(5);
		//image = transform the person into a laptop-man
	}

	public void render(Graphics g){
		if(getPlayer().isBottom){
			setImage(SpriteSheet.grabImage(getController().getImage(),2,2));
		}else if(getPlayer().isRight){
			setImage(SpriteSheet.grabImage(getController().getImage(),2,3));
		}else if(getPlayer().isLeft){
			setImage(SpriteSheet.grabImage(getController().getImage(),2,4));
		}else if(getPlayer().isTop){
			setImage(SpriteSheet.grabImage(getController().getImage(),2,5));
		} 

		g.drawImage(getImage(), (int)getX(), (int)getY(), Weapon.UNIT_MEASURE, Weapon.UNIT_MEASURE, null);
	}
}