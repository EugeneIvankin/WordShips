import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Enter extends MyPanel {
	Backgraund backgraund = new Backgraund("C:/Users/User/Desktop/Enter.jpg");
	JButton next = new JButton("Далее");
	JLabel logo = new JLabel(new ImageIcon("C:/Users/User/Desktop/logo.png"));
	JLabel text = new JLabel(new ImageIcon("C:/Users/User/Desktop/enterText.png"));
	
	Enter(){
		MyPanel.setBackgraund(backgraund);
		next.setBounds(700, 500, 150, 30);
		backgraund.add(next);
		logo.setBounds(262, 10, 365, 356);
		backgraund.add(logo);
		
       
        
		text.setBounds(256, 350, 388, 50);
		backgraund.add(text);
		
		next.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		      if (e.getButton() == MouseEvent.BUTTON1){  
		    	  new userTable();   
		      }
		    }
		});
			
	}
	
	
	
}
	

