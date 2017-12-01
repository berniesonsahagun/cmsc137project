import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class OpeningScreen extends JPanel{
	private JButton goToMenu;
	private BufferedImage background;
	//just set the background and put a button in the south
	public OpeningScreen(){
		super(new BorderLayout());
		goToMenu = new JButton(new ImageIcon("../assets/img/clickButton.png"));
		goToMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout)MainPanel.getCardsPanel().getLayout();
				c.show(MainPanel.getCardsPanel(), "Main Menu");
			}
		});
		goToMenu.setRolloverIcon(new ImageIcon("../assets/img/clickButtonHover.png"));
		goToMenu.setPressedIcon(new ImageIcon("../assets/img/clickButtonClicked.png"));
		goToMenu.setContentAreaFilled(false);
		goToMenu.setBorderPainted(false);
		goToMenu.setMargin(new Insets(0,0,0,0));
		this.add(goToMenu, BorderLayout.SOUTH);
	}

	public void paintComponent(Graphics g){
		g.drawImage(Misc.loadImage("background"),0,0, getWidth(), getHeight(), null);
	}
}