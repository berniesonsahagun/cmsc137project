import java.awt.*;
import  javax.swing.*;

public class PlayScreen extends JPanel{

	public PlayScreen(){
		// contentPane.setLayout(null);
  //       contentPane.add(Chatpanel);
  //       contentPane.add(Satuspanel);

        this.setLayout(null);
        this.add(Chatpanel);
       // getContentPane().add(Statuspanel);


        this.start();
	}

	public void start(){
		ChatClient client = new ChatClient();
	}

	private final ChatPanel Chatpanel = new ChatPanel();
}