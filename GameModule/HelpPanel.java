import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HelpPanel extends JPanel{
	public BufferedImage background;
	public HelpPanel(BufferedImage image){
		this.background = image;
	}
	public void paintComponent(Graphics g){
		g.drawImage(this.background,0,0,getWidth(),getHeight(),null);
	}
}