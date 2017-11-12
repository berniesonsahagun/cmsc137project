import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class HelpScreen extends JPanel{
	static CardLayout cardLayout = new CardLayout();
	static JPanel centerPanel = new JPanel(cardLayout);
	final static String PAGE_1 = "page1";
	final static String PAGE_2 = "page2";
	final static String PAGE_3 = "page3";
	final static String PAGE_4 = "page4";


	private static String next;
	private static String previous;

	public HelpScreen(){
		super(new BorderLayout());
	
		HelpPanel page1 = new HelpPanel(Misc.loadImage("help1"));
		HelpPanel page2 = new HelpPanel(Misc.loadImage("help2"));
		HelpPanel page3 = new HelpPanel(Misc.loadImage("help3"));
		HelpPanel page4 = new HelpPanel(Misc.loadImage("help4"));

		HelpPanel southPanel = new HelpPanel(Misc.loadImage("sheet"));
		southPanel.setLayout(new BorderLayout());
		JPanel southWestPanel = new JPanel();
		JButton previousButton = new JButton(new ImageIcon("../images/prevButton.png"));
		previousButton.setRolloverIcon(new ImageIcon("../images/prevButtonHover.png"));
		previousButton.setPressedIcon(new ImageIcon("../images/prevButtonClicked.png"));
		previousButton.setContentAreaFilled(false);
		previousButton.setBorderPainted(false);
		southWestPanel.add(previousButton);

		JPanel southEastPanel = new JPanel();
		
		JButton nextButton = new JButton(new ImageIcon("../images/nextButton.png"));
		nextButton.setRolloverIcon(new ImageIcon("../images/nextButtonHover.png"));
		nextButton.setPressedIcon(new ImageIcon("../images/nextButtonClicked.png"));
		nextButton.setContentAreaFilled(false);
		nextButton.setBorderPainted(false);
		southEastPanel.add(nextButton);

		JPanel southCenterPanel = new JPanel();

		JButton backToMenuButton = new JButton(new ImageIcon("../images/backMainMenuButton.png"));
		backToMenuButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c = (CardLayout)Game.getCardsPanel().getLayout();
				c.show(Game.getCardsPanel(), "Main Menu");
			}
		});
		backToMenuButton.setRolloverIcon(new ImageIcon("../images/backMainMenuButtonHover.png"));
		backToMenuButton.setPressedIcon(new ImageIcon("../images/backMainMenuButtonClicked.png"));
		backToMenuButton.setContentAreaFilled(false);
		backToMenuButton.setBorderPainted(false);
		backToMenuButton.setMargin(new Insets(0,0,0,0));
		southCenterPanel.add(backToMenuButton);

		southPanel.setBackground(Color.YELLOW);
		southCenterPanel.setOpaque(false);
		southWestPanel.setOpaque(false);
		southEastPanel.setOpaque(false);

		southPanel.add(southWestPanel, BorderLayout.WEST);
		southPanel.add(southCenterPanel, BorderLayout.CENTER);
		southPanel.add(southEastPanel, BorderLayout.EAST);

		nextButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				CardLayout layout = (CardLayout) centerPanel.getLayout();
				
				if (page1.isVisible()) next = PAGE_2;
				else if (page2.isVisible()) next = PAGE_3;
				else if (page3.isVisible())	next = PAGE_4;
				else if (page4.isVisible())	next = PAGE_1;

				layout.show (centerPanel, next);
			}
		});
		previousButton.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				CardLayout layout = (CardLayout) centerPanel.getLayout();
				
				if (page1.isVisible()) next = PAGE_4;
				else if (page2.isVisible()) next = PAGE_1;
				else if (page3.isVisible())	next = PAGE_2;
				else if (page4.isVisible())	next = PAGE_3;

				layout.show (centerPanel, next);
			}
		});

		centerPanel.add(page1, HelpScreen.PAGE_1);
		centerPanel.add(page2, HelpScreen.PAGE_2);
		centerPanel.add(page3, HelpScreen.PAGE_3);
		centerPanel.add(page4, HelpScreen.PAGE_4);

		this.add(centerPanel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);
	}

}
