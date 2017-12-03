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
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Dimension;

// import java.lang.Object;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 

import java.util.Iterator;
import java.util.List;



public class GameRoom extends JPanel{
	private JButton add;
	private JPanel upGrid;
	private JPanel centerGrid;
	private JPanel buttonGrid;
	private JTextField roomName;
	private JTextField roomSize;
	private Room.RoomType r;
	private ArrayList<Room> rooms = new ArrayList<Room>();

	public GameRoom(){
		super(new BorderLayout());
		this.addFields();
	}

	public void paintComponent(Graphics g){
		g.drawImage(Misc.loadImage("tempBackgroundDim"),0,0,getWidth(),getHeight(),null);
	}
  
	private void addFields(){

		upGrid = new JPanel(new FlowLayout());
		buttonGrid = new JPanel(new FlowLayout());
		centerGrid = new JPanel(new FlowLayout());

		add = new JButton(new ImageIcon("assets/img/add.png"));
		add.setRolloverIcon(new ImageIcon("assets/img/addHover.png"));
		add.setPressedIcon(new ImageIcon("assets/img/addClicked.png"));
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				roomName = new JTextField();
				roomSize = new JTextField();
				Object[] roomInfo = {
					"Room Name: ", roomName,
					"Room Size(SMALL/BIG): ", roomSize
				};

				int choice = JOptionPane.showConfirmDialog(null,roomInfo,"Provide room details", JOptionPane.OK_CANCEL_OPTION);
				if (choice == JOptionPane.OK_OPTION) { 
					if(roomSize.getText() == "SMALL" || roomSize.getText() == "small"){
						r = Room.RoomType.SMALL;
					}else if(roomSize.getText() == "BIG" || roomSize.getText() == "big"){
						r = Room.RoomType.BIG;
					}

					Room room = new Room(roomName.getText(), r);
					rooms.add(room);

					JButton newButton = new JButton(roomName.getText());
					newButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							MainPanel.switchPanels("Game");
						}
					});
					newButton.setPreferredSize(new Dimension(500, 60));


					centerGrid.add(newButton);
					centerGrid.validate();

				}	

				
			}
		});

		add.setContentAreaFilled(false);
		add.setBorderPainted(false);
		add.setMargin(new Insets(0,0,0,0));


		upGrid.add(new JLabel(new ImageIcon("assets/img/gameRoom.png")));
		buttonGrid.add(add);

		upGrid.setOpaque(false);
		buttonGrid.setOpaque(false);
		centerGrid.setOpaque(false);

		this.add(upGrid, BorderLayout.NORTH);
		this.add(buttonGrid, BorderLayout.SOUTH);
		this.add(centerGrid, BorderLayout.CENTER);
	}

}
