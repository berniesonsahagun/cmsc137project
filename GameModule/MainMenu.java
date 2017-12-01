import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;	
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;	
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class MainMenu extends JPanel{
	private JPanel buttonGrid;
	private JPanel upGrid;
	private JButton start;
	private JButton exit;
	private JButton help;

	public MainMenu(){
		super(new BorderLayout());
		this.addButtons();
	}

	public void paintComponent(Graphics g){
		g.drawImage(Misc.loadImage("tempBackground"),0,0,getWidth(),getHeight(),null);
	}

	private void addButtons(){
		start = new JButton(new ImageIcon("../assets/img/newGameButton.png"));
		start.setRolloverIcon(new ImageIcon("../assets/img/newGameButtonHover.png"));
		start.setPressedIcon(new ImageIcon("../assets/img/newGameButtonClicked.png"));
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout)MainPanel.getCardsPanel().getLayout();
				c.show(MainPanel.getCardsPanel(), "Enter Name");
			}
		});
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		start.setMargin(new Insets(0,0,0,0));


		help = new JButton(new ImageIcon("../assets/img/helpButton.png"));
		help.setRolloverIcon(new ImageIcon("../assets/img/helpButtonHover.png"));
		help.setPressedIcon(new ImageIcon("../assets/img/helpButtonClicked.png"));
		help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout)MainPanel.getCardsPanel().getLayout();
				c.show(MainPanel.getCardsPanel(), "Help Screen");
			}
		});
		help.setContentAreaFilled(false);
		help.setBorderPainted(false);
		help.setMargin(new Insets(0,0,0,0));

		buttonGrid = new JPanel(new FlowLayout());
		upGrid = new JPanel(new FlowLayout());

		upGrid.add(start);
		buttonGrid.add(help);
		
		this.add(buttonGrid, BorderLayout.SOUTH);
		this.add(upGrid, BorderLayout.CENTER);
		this.add(new JLabel(new ImageIcon("../assets/img/gameName.png")), BorderLayout.NORTH);
		buttonGrid.setOpaque(false);
		upGrid.setOpaque(false);
		upGrid.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		start.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	}
}