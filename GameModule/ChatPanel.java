import java.awt.*;
import  javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;


public class ChatPanel extends JPanel{

	private final mytextArea textArea=new mytextArea();
    private final JScrollPane TextAreaScroll=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	public ChatPanel(){
		setSize(200,700);
    	setLocation(700,0);

    	TextAreaScroll.setSize(190,550);
        TextAreaScroll.setLocation(0,10);
        
        setLayout(null);
        
        TextAreaScroll.setEnabled(false);
        
        add(TextAreaScroll);
        
        JButton Sendbutton = new JButton();
       	Sendbutton.setSize(80,30);
       	Sendbutton.setLocation(60,600);
       	Sendbutton.setText("Send");
        Sendbutton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                
            }
        });

        add(Sendbutton);
        
        JTextField TextFiled = new JTextField();
        TextFiled.setSize(170,20);
        TextFiled.setLocation(10,575);
        TextFiled.setToolTipText("Write Text Here");
        TextFiled.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                //System.out.println("okdddd  "+e.KEY_PRESSED+"  "+e.VK_PAGE_DOWN);
                
                
                if( e.getKeyChar()=='\n') {
                    textArea.append("\n"+TextFiled.getText());
                    
                    
                }
            }
            public void keyReleased(KeyEvent e) {
            }
            public void keyTyped(KeyEvent e) {
            }
        });
        add(TextFiled);
        
	}

	public void addText(String text){
		textArea.append("\n" + text);
	}
}

class mytextArea extends JTextArea{
    mytextArea() {    
        setEditable(false);
        setBorder(TextBorder);        
    }      
    private final TitledBorder TextBorder=new TitledBorder("Chat History");
}