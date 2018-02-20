import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class userTable extends MyPanel{
	
	Backgraund backgraund = new Backgraund("C:/Users/User/Desktop/UserT.jpg");
	JButton ship1 = new JButton("Однопалубный");
	int Nship1=0;
	int Nship2=0;
	int Nship3=0;
	int Nship4=0;
	JButton ship2 = new JButton("2-х палубный");
	JButton ship3 = new JButton("3-х палубный");
	JButton ship4 = new JButton("4-х палубный");
	JButton rev2 = new JButton();
	JButton rev3 = new JButton();
	JButton rev4 = new JButton();
	JButton next = new JButton("В БОЙ");
	JButton autoPosition = new JButton("Авторазмещение");
	JLabel shipImage;
	JLabel ImageShipGor = new JLabel(new ImageIcon());
	JLabel ImageShipVer = new JLabel(new ImageIcon());
	JLabel mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/mainText.png"));
	Boolean answer = true;
	int x=0, y=0;
	Component button;															
	Component revButton;
	Ship ship = new Ship();
	int col=0;
	
	userTable(){
		MyPanel.setBackgraund(backgraund);
		mainText.setBounds(318, 10, 264, 50);
		backgraund.add(mainText);
		
		backgraund.add(autoPosition);
		autoPosition.setBounds(700, 100, 150, 30);
		autoPosition.addMouseListener(AutoPositionClik);
		autoPosition.setBackground(Color.YELLOW);
		
		
		backgraund.add(ship1);
		ship1.setBounds(500, 100, 150, 30);
		ship1.setName("ship1");
		ship1.addMouseListener(CreadGorClik);
		ship1.setBackground(Color.GREEN);
		
		
		backgraund.add(ship2);
		backgraund.add(rev2);
		ship2.setBounds(500, 140, 150, 30);
		rev2.setBounds(660, 140, 30, 30);
		ship2.setName("ship2");
		rev2.setName("rev2");
		ship2.addMouseListener(CreadGorClik);
		rev2.addMouseListener(CreadVerClik);
		ship2.setBackground(Color.GREEN);
		rev2.setBackground(Color.GREEN);
		
		backgraund.add(ship3);
		backgraund.add(rev3);
		ship3.setBounds(500, 180, 150, 30);
		rev3.setBounds(660, 180, 30, 30);
		ship3.setName("ship3");
		rev3.setName("rev3");
		ship3.addMouseListener(CreadGorClik);
		rev3.addMouseListener(CreadVerClik);
		ship3.setBackground(Color.GREEN);
		rev3.setBackground(Color.GREEN);
		
		backgraund.add(ship4);
		backgraund.add(rev4);
		ship4.setBounds(500, 220, 150, 30);
		rev4.setBounds(660, 220, 30, 30);
		ship4.setName("ship4");
		rev4.setName("rev4");
		ship4.addMouseListener(CreadGorClik);
		rev4.addMouseListener(CreadVerClik);
		ship4.setBackground(Color.GREEN);
		rev4.setBackground(Color.GREEN);
		
		next.setBounds(700, 500, 150, 30);
		backgraund.add(next);
		
		next.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		      if (e.getButton() == MouseEvent.BUTTON1){ 
		    	  if (col==20){
		    		  new Table();
		    	  }
		    	  else if (col!=20) {
		    		  backgraund.remove(mainText);
		    		  mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/secondText.png"));
		    		  mainText.setBounds(318, 10, 264, 50);
		    		  backgraund.add(mainText);
		    		  backgraund.repaint();
		    	  }
		      }
		    }
		});
		
	}
	
	
		MouseListener CreadGorClik = new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				button = e.getComponent();
				backgraund.removeMouseListener(clik);
				backgraund.removeMouseListener(revClik);
				ship1.removeMouseListener(CreadGorClik);
				ship2.removeMouseListener(CreadGorClik);
				ship3.removeMouseListener(CreadGorClik);
				ship4.removeMouseListener(CreadGorClik);
				rev2.removeMouseListener(CreadVerClik);
				rev3.removeMouseListener(CreadVerClik);
				rev4.removeMouseListener(CreadVerClik);
			      if (e.getButton() == MouseEvent.BUTTON1){
			    	backgraund.addMouseListener(clik);
			    	answer = true;
			    	button.setBackground(Color.RED);
			      }
			}
		};
	
	
		MouseListener CreadVerClik = new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				 revButton = e.getComponent();
				 backgraund.removeMouseListener(clik);
				 backgraund.removeMouseListener(revClik);
				 ship1.removeMouseListener(CreadGorClik);
				 ship2.removeMouseListener(CreadGorClik);
				 ship3.removeMouseListener(CreadGorClik);
				 ship4.removeMouseListener(CreadGorClik);
				 rev2.removeMouseListener(CreadVerClik);
				 rev3.removeMouseListener(CreadVerClik);
				 rev4.removeMouseListener(CreadVerClik);
			      if (e.getButton() == MouseEvent.BUTTON1){
			    	  backgraund.addMouseListener(revClik);
			    	  answer = true;
			    	  revButton.setBackground(Color.RED);
			      }
			}
		};
		
		MouseListener AutoPositionClik = new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				if (col==0){
					for (int i=0; i<4; i++){
						ship.CreadShip(1, User.user);
					}
					
					for (int i=0; i<3; i++){
						ship.CreadShip(2, User.user);
					}
					
					for (int i=0; i<2; i++){
						ship.CreadShip(3, User.user);
					}
					
					ship.CreadShip(4, User.user);
					
					for (int i=1; i<User.user.length-1; i++){
						for (int j=1; j<User.user.length-1; j++){
							if (User.user[i][j]==1){
								shipImage = new JLabel(new ImageIcon("C:/Users/User/Desktop/1.jpg"));
								shipImage.setBounds((j-1)*30+100, (i-1)*30+100, 30, 30);
								backgraund.add(shipImage);
							}
						}
					}
					
					col=20;
					autoPosition.setBackground(null);
					backgraund.remove(mainText);
		    		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/autoPositionText.png"));
		    		mainText.setBounds(228, 10, 444, 50);
		    		backgraund.add(mainText);
		    		backgraund.repaint();
				}
				else{
					autoPosition.setBackground(null);
					backgraund.remove(mainText);
					mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/secondAutoPositionText.png"));
		    		mainText.setBounds(197, 10, 505, 50);
		    		backgraund.add(mainText);
		    		backgraund.repaint();
				}
			}
		};
	
		public void ChekShip(){
			if (Nship1!=4){
				ship1.addMouseListener(CreadGorClik);
				ship1.setBackground(Color.GREEN);
			}
			if (Nship1==4){
				ship1.setBackground(null);
			}
			if (Nship2!=3){
				ship2.addMouseListener(CreadGorClik);
				rev2.addMouseListener(CreadVerClik);
				ship2.setBackground(Color.GREEN);
				rev2.setBackground(Color.GREEN);
			}
			if (Nship2==3){
				ship2.setBackground(null);
				rev2.setBackground(null);
			}
			if (Nship3!=2){
				ship3.addMouseListener(CreadGorClik);
				rev3.addMouseListener(CreadVerClik);
				ship3.setBackground(Color.GREEN);
				rev3.setBackground(Color.GREEN);
			}
			if (Nship3==2){
				ship3.setBackground(null);
				rev3.setBackground(null);
			}
			if (Nship4!=1){
				ship4.addMouseListener(CreadGorClik);
				rev4.addMouseListener(CreadVerClik);
			}
			if (Nship4==1){
				ship4.setBackground(null);
				rev4.setBackground(null);
			}
		}
		
		public void PaintGorShip(int x, int y){
			if (button.getName().equals("ship1")){
				if (ship.checkOne(y+1, x+1, User.user)){
						ImageShipGor=new JLabel(new ImageIcon("C:/Users/User/Desktop/1.jpg"));
						ImageShipGor.setBounds(100+(x*30), 100+(y*30), 30, 30);
						User.UpdateUserArr(y+1, x+1, button.getName());
						Nship1++;
						col+=1;
						ChekShip();
				}
				else {
					backgraund.remove(mainText);
		    		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/AnotherShipText.png"));
		    		mainText.setBounds(273, 10, 354, 50);
		    		backgraund.add(mainText);
		    		backgraund.repaint();
					ChekShip();
				}
			}
			else if (button.getName().equals("ship2")){
				if (ship.checkOther(y+1, x+1, 0, 2, User.user)){
					if (x<=8){
						ImageShipGor=new JLabel(new ImageIcon("C:/Users/User/Desktop/2g.jpg"));
						ImageShipGor.setBounds(100+(x*30), 100+(y*30), 60, 30);
						User.UpdateUserArr(y+1, x+1, button.getName());
						Nship2++;
						col+=2;
						ChekShip();
					}
				}
				else {
					backgraund.remove(mainText);
		    		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/AnotherShipText.png"));
		    		mainText.setBounds(273, 10, 354, 50);
		    		backgraund.add(mainText);
		    		backgraund.repaint();
					ChekShip();
				}
			}
			else if (button.getName().equals("ship3")){
				if (ship.checkOther(y+1, x+1, 0, 3, User.user)){
					if (x<=7){
						ImageShipGor=new JLabel(new ImageIcon("C:/Users/User/Desktop/3g.jpg"));
						ImageShipGor.setBounds(100+(x*30), 100+(y*30), 90, 30);
						User.UpdateUserArr(y+1, x+1, button.getName());
						Nship3++;
						col+=3;
						ChekShip();
					}
				}
				else {
					backgraund.remove(mainText);
		    		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/AnotherShipText.png"));
		    		mainText.setBounds(273, 10, 354, 50);
		    		backgraund.add(mainText);
		    		backgraund.repaint();
					ChekShip();
				}
			}
			else if (button.getName().equals("ship4")){
				if (ship.checkOther(y+1, x+1, 0, 4, User.user)){
					if (x<=6){
						ImageShipGor=new JLabel(new ImageIcon("C:/Users/User/Desktop/4g.jpg"));
						ImageShipGor.setBounds(100+(x*30), 100+(y*30), 120, 30);
						User.UpdateUserArr(y+1, x+1, button.getName());
						Nship4++;
						col+=4;
						ChekShip();
					}
				}
				else {
					backgraund.remove(mainText);
		    		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/AnotherShipText.png"));
		    		mainText.setBounds(273, 10, 354, 50);
		    		backgraund.add(mainText);
		    		backgraund.repaint();
					ChekShip();
				}
			}
	    	backgraund.add(ImageShipGor);
	    	backgraund.repaint();
			answer=false;
		}
	
		
		public void PaintVerShip(int x, int y){
			if (revButton.getName().equals("rev2")){
				if (ship.checkOther(y+1, x+1, 1, 2, User.user)){
					if (y<=8){
						ImageShipVer=new JLabel(new ImageIcon("C:/Users/User/Desktop/2v.jpg"));
						ImageShipVer.setBounds(100+(x*30), 100+(y*30), 30, 60);
						User.UpdateUserArr(y+1, x+1, revButton.getName());
						Nship2++;
						col+=2;
						ChekShip();
					}
				}
				else {
					backgraund.remove(mainText);
		    		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/AnotherShipText.png"));
		    		mainText.setBounds(273, 10, 354, 50);
		    		backgraund.add(mainText);
		    		backgraund.repaint();
					ChekShip();
				}
			}
			else if (revButton.getName().equals("rev3")){
				if (ship.checkOther(y+1, x+1, 1, 3, User.user)){
					if (y<=7){
						ImageShipVer=new JLabel(new ImageIcon("C:/Users/User/Desktop/3v.jpg"));
						ImageShipVer.setBounds(100+(x*30), 100+(y*30), 30, 90);
						User.UpdateUserArr(y+1, x+1, revButton.getName());
						Nship3++;
						col+=3;
						ChekShip();
					}
				}
				else {
					backgraund.remove(mainText);
		    		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/AnotherShipText.png"));
		    		mainText.setBounds(273, 10, 354, 50);
		    		backgraund.add(mainText);
		    		backgraund.repaint();
					ChekShip();
				}
			}
			else if (revButton.getName().equals("rev4")){
				if (ship.checkOther(y+1, x+1, 1, 4, User.user)){
					if (y<=6){
						ImageShipVer=new JLabel(new ImageIcon("C:/Users/User/Desktop/4v.jpg"));
						ImageShipVer.setBounds(100+(x*30), 100+(y*30), 30, 120);
						User.UpdateUserArr(y+1, x+1, revButton.getName());
						Nship4++;
						col+=4;
						ChekShip();
					}
				}
				else {
					backgraund.remove(mainText);
		    		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/AnotherShipText.png"));
		    		mainText.setBounds(273, 10, 354, 50);
		    		backgraund.add(mainText);
		    		backgraund.repaint();
					ChekShip();
				}
			}
			
	    	backgraund.add(ImageShipVer);
	    	backgraund.repaint();
			answer=false;
		}
		
		
		

		MouseListener clik = new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
			      if (e.getButton() == MouseEvent.BUTTON1)
			      {  
			    	  if(answer)
				    	  { 
				    		int x = (e.getX()-100)/30;
							int y = (e.getY()-100)/30;
							if ((e.getX()>100 && e.getX()<=400) && (e.getY()>100 && e.getY()<=400)){
								PaintGorShip(x,y);
								if (col==20){
									backgraund.remove(mainText);
						    		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/autoPositionText.png"));
						    		mainText.setBounds(228, 10, 444, 50);
						    		backgraund.add(mainText);
						    		backgraund.repaint();
								}
							}
				    	  }
			      }
			}
		};
		
		
		MouseListener revClik = new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
			      if (e.getButton() == MouseEvent.BUTTON1)
			      {  
			    	  if(answer)
				    	  { 
			    		  	int x = (e.getX()-100)/30;
							int y = (e.getY()-100)/30;
							if ((e.getX()>100 && e.getX()<=400) && (e.getY()>100 && e.getY()<=400)){
								PaintVerShip(x,y);
								if (col==20){
									backgraund.remove(mainText);
						    		mainText = new JLabel(new ImageIcon("C:/Users/User/Desktop/autoPositionText.png"));
						    		mainText.setBounds(228, 10, 444, 50);
						    		backgraund.add(mainText);
						    		backgraund.repaint();
								}
							}
						}
			      }
			}
		};		
}	


