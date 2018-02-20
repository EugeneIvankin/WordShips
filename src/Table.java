import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class Table extends MyPanel {
	Backgraund backgraund = new Backgraund("C:/Users/User/Desktop/Backgraund.jpg");
	JLabel label, Botlabel, ship;
	JPanel panel = new JPanel();
	JLabel mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/UserShot.png"));
	int i;
	JPanel glasspane = new JPanel( new GridBagLayout() );
	Boolean shot = false;
	int m=0;
	
	Table(){
		new Bot();
	    User.Showwww();
		paintUserArr();
		MyPanel.setBackgraund(backgraund);
		backgraund.addMouseListener(clik);
		
		mainText.setBounds(376, 10, 148, 50);
		backgraund.add(mainText);
		
        glasspane.setSize(50, 50);
        glasspane.setOpaque( false );  
        glasspane.setBackground(Color.GRAY);
       
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add( backgraund, JLayeredPane.DEFAULT_LAYER, -1 );
        layeredPane.add( glasspane, JLayeredPane.DEFAULT_LAYER + 50, -1 );
        layeredPane.addComponentListener( new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                backgraund.setSize( e.getComponent().getSize() );
                glasspane.setSize( e.getComponent().getSize() );
            }
        });
		
        JPanel contentPane = new JPanel( new BorderLayout() );
        contentPane.add( layeredPane, BorderLayout.CENTER );
        frame.setContentPane( contentPane );
        frame.setVisible( true );
   
	}
	
	
	public void paintUserArr(){
		
		for (int i=1; i<User.user.length-1; i++){
			for (int j=1; j<User.user.length-1; j++){
				if (User.user[i][j]==1){
					ship = new JLabel(new ImageIcon("C:/Users/User/Desktop/1.jpg"));
					ship.setBounds((j-1)*30+100, (i-1)*30+100, 30, 30);
					ship.setName("11");;
					backgraund.add(ship);
					backgraund.repaint();
				}
			}
		}
		
	}
	
	
	MouseListener clik = new MouseAdapter(){
		public void mouseClicked(MouseEvent e) {
		      if (e.getButton() == MouseEvent.BUTTON1)
		      {  
		    	  chekCliked(e);
		      }
		}
	};
	
	public void chekCliked(MouseEvent e){
		
		if (m==0){
		 double x = e.getX();
		 double y = e.getY();
		 
			if ((x>=500 && x<=800) && (y>=100 && y<=400))
			{
				backgraund.removeMouseListener(clik);
				int x1=(int)(x-500)/30;
				int y1=(int)(y-100)/30;
				int mx1=(int)(x-500)/30+1;
				int my1=(int)(y-100)/30+1;
				if (Bot.bot[my1][mx1]==1){
					label = new JLabel(new ImageIcon("C:/Users/User/Desktop/1.jpg"));
				}
				else {
					label = new JLabel(new ImageIcon("C:/Users/User/Desktop/2.jpg"));
				}
				label.setBounds(500+(x1*30), 100+(y1*30), 30, 30);
				backgraund.add(label);
				backgraund.repaint();
				
			}
			
			if (Bot.FireBot()){
				m=1;
				backgraund.remove(mainText);
		  		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/UserKill.png"));
		  		mainText.setBounds(10, 10, 880, 50);
		  		backgraund.add(mainText);
		  		backgraund.repaint();
			}
			else {
				backgraund.remove(mainText);
		  		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/UserShot.png"));
		  		mainText.setBounds(376, 10, 148, 50);
		  		backgraund.add(mainText);
		  		backgraund.repaint();
				m=0;
			}
			PaintBotFire();
		}
		
		else if (m==1){
		
		backgraund.removeMouseListener(clik);
		Bot.ChekFire();
			if (Bot.FireBot()){
				m=1;
				backgraund.remove(mainText);
		  		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/UserKill.png"));
		  		mainText.setBounds(10, 10, 880, 50);
		  		backgraund.add(mainText);
		  		backgraund.repaint();
			}
			else {
				m=0;
				backgraund.remove(mainText);
		  		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/UserShot.png"));
		  		mainText.setBounds(376, 10, 148, 50);
		  		backgraund.add(mainText);
		  		backgraund.repaint();
			}
			PaintBotFire();
			
		}
		
	
			
	}
	
	
	
	
	
	public void PaintBotFire(){
		Timer time = new Timer();
		time.schedule(new TimerTask() {
			int i = 0;
	        @Override
	        public void run() { //ÏÅĞÅÇÀÃĞÓÆÀÅÌ ÌÅÒÎÄ RUN Â ÊÎÒÎĞÎÌ ÄÅËÀÅÒÅ ÒÎ ×ÒÎ ÂÀÌ ÍÀÄÎ
	            if(i>=1){
	                    //System.out.println("Òàéìåğ çàâåğøèë ñâîş ğàáîòó");
	                    time.cancel();
	                    return;
	            }
	            
	            Botlabel = new JLabel(new ImageIcon("C:/Users/User/Desktop/2.jpg"));
			    Botlabel.setBounds(100+(Shot.getX()*30), 100+(Shot.getY()*30), 30, 30);
	            //Botlabel.setBounds(100+(i*30), 100+(i*30), 30, 30);
			    glasspane.add(Botlabel);
			    glasspane.repaint();
	           // System.out.println("Ïğîøëî 2 ñåêóíäû");
	            i++;
	            backgraund.addMouseListener(clik);
	            }
	        }, 500, 100); //(4000 - ÏÎÄÎÆÄÀÒÜ ÏÅĞÅÄ ÍÀ×ÀËÎÌ Â ÌÈËÈÑÅÊ, ÏÎÂÒÎĞßÒÑß 4 ÑÅÊÓÍÄÛ (1 ÑÅÊ = 1000 ÌÈËÈÑÅÊ))
	    }
	}
	

