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
import java.awt.GridLayout;
import java.awt.Component;	
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Choice;

@SuppressWarnings("unchecked")
public class LargeRoom extends JPanel{
	private JButton large;
	private JButton small;
	private JLabel players[];
	private JButton back;
	private JPanel upGrid;
	private JPanel centerGrid;
	private JPanel buttonGrid;

	public LargeRoom(){
		super(new BorderLayout());
		this.addFields();
	}

	public void paintComponent(Graphics g){
		g.drawImage(Misc.loadImage("tempBackgroundDim"),0,0,getWidth(),getHeight(),null);
	}
	private void addFields(){
		players = new JLabel[8];
		for(int i =0;i<8;i++){
			players[i] = new JLabel("Player "+(i+1));
		}
		
		back = new JButton(new ImageIcon("../images/backButton.png"));
		back.setRolloverIcon(new ImageIcon("../images/backButtonHover.png"));
		back.setPressedIcon(new ImageIcon("../images/backButtonClicked.png"));
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout)Game.getCardsPanel().getLayout();
				c.show(Game.getCardsPanel(), "Game Room List");
			}
		});

		upGrid = new JPanel(new FlowLayout());
		centerGrid = new JPanel(new GridLayout(2,4));
		buttonGrid = new JPanel(new FlowLayout());
		upGrid.add(new JLabel(new ImageIcon("../images/largeRoom.png")));
		JPanel southEastPanel = new JPanel();

		southEastPanel.setOpaque(false);
		southEastPanel.add(back);
    
    	for(int i=0;i<8;i++){
    		centerGrid.add(players[i]);
    	}
		buttonGrid.add(southEastPanel, BorderLayout.EAST);

		upGrid.setOpaque(false);
		centerGrid.setOpaque(false);
		buttonGrid.setOpaque(false);
		
		this.add(upGrid, BorderLayout.NORTH);
		this.add(centerGrid, BorderLayout.CENTER);
		this.add(buttonGrid, BorderLayout.SOUTH);

		

	}

}
