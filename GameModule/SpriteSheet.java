import java.awt.image.BufferedImage;

public class SpriteSheet{
	public static BufferedImage grabImage(BufferedImage image, int col, int row){
		BufferedImage img = image.getSubimage((col * 32) - 32, (row * 32) - 32, 32, 32);
		return img;
	}
}