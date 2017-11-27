import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;	
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Component;	
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Choice;

@SuppressWarnings("unchecked")
public class AddGameRoom extends JPanel{
	private JButton large;
	private JButton small;
	private JButton back;
	private JPanel upGrid;
	private JPanel centerGrid;
	private JPanel buttonGrid;

	public AddGameRoom(){
		super(new BorderLayout());
		this.addFields();
	}

	public void paintComponent(Graphics g){
		g.drawImage(Misc.loadImage("tempBackgroundDim"),0,0,getWidth(),getHeight(),null);
	}
	private void addFields(){
		
		back = new JButton(new ImageIcon("assets/img/backButton.png"));
		back.setRolloverIcon(new ImageIcon("assets/img/backButtonHover.png"));
		back.setPressedIcon(new ImageIcon("assets/img/backButtonClicked.png"));
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout)MainPanel.getCardsPanel().getLayout();
				c.show(MainPanel.getCardsPanel(), "Game Room List");
			}
		});
		small = new JButton(new ImageIcon("assets/img/smallButton.png"));
		small.setRolloverIcon(new ImageIcon("assets/img/smallButtonHover.png"));
		small.setPressedIcon(new ImageIcon("assets/img/smallButtonClicked.png"));
		 small.addActionListener(new ActionListener(){
		 	public void actionPerformed(ActionEvent e){
		 		CardLayout c = (CardLayout)MainPanel.getCardsPanel().getLayout();
		 		c.show(MainPanel.getCardsPanel(), "Small Room");
		 	}
		 });
		
		large = new JButton(new ImageIcon("assets/img/largeButton.png"));
		large.setRolloverIcon(new ImageIcon("assets/img/largeButtonHover.png"));
		large.setPressedIcon(new ImageIcon("assets/img/largeButtonClicked.png"));
		large.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout)MainPanel.getCardsPanel().getLayout();
				c.show(MainPanel.getCardsPanel(), "Large Room");
			}
		});

		upGrid = new JPanel(new FlowLayout());
		centerGrid = new JPanel(new FlowLayout());
		buttonGrid = new JPanel(new FlowLayout());
		upGrid.add(new JLabel(new ImageIcon("assets/img/selectRoomSize.png")));
		JPanel southEastPanel = new JPanel();

		southEastPanel.add(back);
	    centerGrid.add(small);
	    centerGrid.add(large);

		southEastPanel.setOpaque(false);    
		buttonGrid.add(southEastPanel, BorderLayout.EAST);

		upGrid.setOpaque(false);
		centerGrid.setOpaque(false);
		buttonGrid.setOpaque(false);
		
		this.add(upGrid, BorderLayout.NORTH);
		this.add(centerGrid, BorderLayout.CENTER);
		this.add(buttonGrid, BorderLayout.SOUTH);

		

	}

}
