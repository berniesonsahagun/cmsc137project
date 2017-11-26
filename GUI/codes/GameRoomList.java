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
public class GameRoomList extends JPanel{
	private JComboBox roomLists;
	private JButton add;
	private JButton enter;
	private JButton back;
	private JPanel upGrid;
	private JPanel centerGrid;
	private JPanel buttonGrid;

	public GameRoomList(){
		super(new BorderLayout());
		this.addFields();
	}

	public void paintComponent(Graphics g){
		g.drawImage(Misc.loadImage("tempBackgroundDim"),0,0,getWidth(),getHeight(),null);
	}
  public String getRoom(){
    return roomLists.getSelectedItem().toString();
  }
	private void addFields(){
	  enter = new JButton(new ImageIcon("../images/enterButton.png"));
		enter.setRolloverIcon(new ImageIcon("../images/enterButtonHover.png"));
		enter.setPressedIcon(new ImageIcon("../images/enterButtonClicked.png"));
		 enter.addActionListener(new ActionListener(){
		 	public void actionPerformed(ActionEvent e){
		 		CardLayout c = (CardLayout)Game.getCardsPanel().getLayout();
		 		if(getRoom().equals("Game Room 1"))
		 			c.show(Game.getCardsPanel(), "Small Room");
		 		else
		 			c.show(Game.getCardsPanel(), "Large Room");
		 	}
		 });
		enter.setContentAreaFilled(false);
		enter.setBorderPainted(false);
		enter.setMargin(new Insets(0,0,0,0));
		
		add = new JButton(new ImageIcon("../images/addButton.png"));
		add.setRolloverIcon(new ImageIcon("../images/addButtonHover.png"));
		add.setPressedIcon(new ImageIcon("../images/addButtonClicked.png"));
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout)Game.getCardsPanel().getLayout();
				c.show(Game.getCardsPanel(), "Add Room");
			}
		});
		add.setContentAreaFilled(false);
		add.setBorderPainted(false);
		add.setMargin(new Insets(0,0,0,0));
		
	  roomLists = new JComboBox();
	  roomLists.addItem("Game Room 1");
	  roomLists.addItem("Game Room 2");
	  roomLists.addItem("Game Room 3");
	  
    roomLists.setPreferredSize(new Dimension(400,50));
	  
		back = new JButton(new ImageIcon("../images/backButton.png"));
		back.setRolloverIcon(new ImageIcon("../images/backButtonHover.png"));
		back.setPressedIcon(new ImageIcon("../images/backButtonClicked.png"));
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout)Game.getCardsPanel().getLayout();
				c.show(Game.getCardsPanel(), "Enter Name");
			}
		});
		
		upGrid = new JPanel(new FlowLayout());
		centerGrid = new JPanel(new FlowLayout());
		buttonGrid = new JPanel(new FlowLayout());
		upGrid.add(new JLabel(new ImageIcon("../images/gameRoomList.png")));
		JPanel southWestPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JPanel southEastPanel = new JPanel();

		southEastPanel.add(back);
		southWestPanel.add(add);
	    southPanel.add(enter);
	    centerGrid.add(roomLists);
    
		southWestPanel.setOpaque(false);
		southPanel.setOpaque(false);
		southEastPanel.setOpaque(false);
		buttonGrid.add(southEastPanel, BorderLayout.EAST);
		buttonGrid.add(southPanel,BorderLayout.CENTER);
		buttonGrid.add(southWestPanel, BorderLayout.WEST);

		upGrid.setOpaque(false);
		centerGrid.setOpaque(false);
		buttonGrid.setOpaque(false);
		
		this.add(upGrid, BorderLayout.NORTH);
		this.add(centerGrid, BorderLayout.CENTER);
		this.add(buttonGrid, BorderLayout.SOUTH);

		

	}

}
