import java.awt.*;
import  javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ChatPanel extends JPanel implements Runnable{

    private static Socket socket = null;
    private static DataOutputStream out = null;
    private static DataInputStream in = null;

    //private static BufferedReader inputLine = null;
    private static boolean isClosed = false;

	private final mytextArea textArea=new mytextArea();
    private final JScrollPane TextAreaScroll=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	public ChatPanel(){
		setSize(200,700);
    	setLocation(900,0);

    	TextAreaScroll.setSize(190,550);
        TextAreaScroll.setLocation(0,10);
        
        setLayout(null);
        
        TextAreaScroll.setEnabled(false);
        
        add(TextAreaScroll);
        
        JTextField TextFiled = new JTextField();
        TextFiled.setSize(170,20);
        TextFiled.setLocation(10,575);
        TextFiled.setToolTipText("Write Text Here");
        add(TextFiled);

        JButton Sendbutton = new JButton();
       	Sendbutton.setSize(80,30);
       	Sendbutton.setLocation(60,600);
       	Sendbutton.setText("Send");
        Sendbutton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                sendMessage(TextFiled.getText());
                addText(TextFiled.getText());
            }
        });

        add(Sendbutton);
        
        
	}

    public void run(){
        String serverReply;
        try{
          while((serverReply = in.readUTF()) != null) {
          System.out.println(serverReply);
          addText(serverReply);
            if (!Game.isRunning()){
                try{
                    System.out.print("stopped running");
                  out.close();
                  in.close();
                  socket.close();
                }catch(IOException e){
                  e.printStackTrace();
                  }
                break;
            }    
          }
          
          // isClosed = true;
        }catch(IOException e){
          e.printStackTrace();
        }
    }

	public void addText(String text){
		//textArea.append("\n" + text);
        System.out.println("here");
        textArea.setText(textArea.getText() +"\n"+text);
	}

    public void sendMessage(String msg){
        try{
            out.writeUTF(msg);
        }catch(IOException e){
          e.printStackTrace();
        }
    }

    public static void init(){
        try{
            socket = new Socket(MainPanel.getIPAddress(), 8888);
            //inputLine = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        }catch(SocketTimeoutException s){
          System.out.println("Socket timed out!");
        }catch(IOException e){
          e.printStackTrace();
          System.out.println("Input/Output Error!");
        }

        new Thread(new ChatPanel()).start();
    }
}

class mytextArea extends JTextArea{
    mytextArea() {    
        setEditable(false);
        setBorder(TextBorder);        
    }      
    private final TitledBorder TextBorder=new TitledBorder("Chat History");
}