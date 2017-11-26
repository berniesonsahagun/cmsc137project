import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;	
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;	
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.Graphics;


public class EnterName extends JPanel{
	private JTextField textField;
	private JButton enter;
	private JButton back;
	private JPanel upGrid;
	private JPanel centerGrid;
	private JPanel buttonGrid;

	public EnterName(){
		super(new BorderLayout());
		this.addFields();
	}

	public void paintComponent(Graphics g){
		g.drawImage(Misc.loadImage("tempBackgroundDim"),0,0,getWidth(),getHeight(),null);
	}

	private void addFields(){

		textField = new JTextField(12);
		textField.setFont(textField.getFont().deriveFont(40f));
        textField.setBounds(5, 5, 280, 50);


		enter = new JButton(new ImageIcon("../images/enterButton.png"));
		enter.setRolloverIcon(new ImageIcon("../images/enterButtonHover.png"));
		enter.setPressedIcon(new ImageIcon("../images/enterButtonClicked.png"));
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String name = textField.getText();
				PlayerInfo player = new PlayerInfo(name);
				CardLayout c = (CardLayout)Game.getCardsPanel().getLayout();
				c.show(Game.getCardsPanel(), "PlayScreen");
			}
		});
		enter.setContentAreaFilled(false);
		enter.setBorderPainted(false);
		enter.setMargin(new Insets(0,0,0,0));


		back = new JButton(new ImageIcon("../images/backButton.png"));
		back.setRolloverIcon(new ImageIcon("../images/backButtonHover.png"));
		back.setPressedIcon(new ImageIcon("../images/backButtonClicked.png"));
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout)Game.getCardsPanel().getLayout();
				c.show(Game.getCardsPanel(), "Main Menu");
			}
		});
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setMargin(new Insets(0,0,0,0));

		

		upGrid = new JPanel(new FlowLayout());
		centerGrid = new JPanel(new FlowLayout());
		buttonGrid = new JPanel(new FlowLayout());

		JPanel southWestPanel = new JPanel();
		JPanel southEastPanel = new JPanel();

		upGrid.add(new JLabel(new ImageIcon("../images/enterPlayerName.png")));

		southWestPanel.setOpaque(false);
		southEastPanel.setOpaque(false);

		southEastPanel.add(back);
		southWestPanel.add(enter);

		buttonGrid.add(southEastPanel, BorderLayout.EAST);
		buttonGrid.add(southWestPanel, BorderLayout.WEST);

		centerGrid.add(textField);

		upGrid.setOpaque(false);
		centerGrid.setOpaque(false);
		buttonGrid.setOpaque(false);

		this.add(upGrid, BorderLayout.NORTH);
		this.add(centerGrid, BorderLayout.CENTER);
		this.add(buttonGrid, BorderLayout.SOUTH);

	}

}
