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

  public String getTextField(){
    return textField.getText();
  }
  
	private void addFields(){

		textField = new JTextField(12);
		textField.setFont(textField.getFont().deriveFont(40f));
        textField.setBounds(5, 5, 280, 50);


		enter = new JButton(new ImageIcon("assets/img/enterButton.png"));
		enter.setRolloverIcon(new ImageIcon("assets/img/enterButtonHover.png"));
		enter.setPressedIcon(new ImageIcon("assets/img/enterButtonClicked.png"));
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String name = textField.getText();
				MainPanel.setPlayerName(name);
				MainPanel.switchPanels("Game");
			}
		});

		enter.setContentAreaFilled(false);
		enter.setBorderPainted(false);
		enter.setMargin(new Insets(0,0,0,0));


		back = new JButton(new ImageIcon("assets/img/backButton.png"));
		back.setRolloverIcon(new ImageIcon("assets/img/backButtonHover.png"));
		back.setPressedIcon(new ImageIcon("assets/img/backButtonClicked.png"));
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainPanel.switchPanels("Main Menu");
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

		upGrid.add(new JLabel(new ImageIcon("assets/img/enterPlayerName.png")));

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
