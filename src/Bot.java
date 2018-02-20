import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bot {
	
	static int bot [][] = new int [12][12];
	static ArrayList<Integer> firstList = new ArrayList<Integer>();
	static ArrayList<Integer> secondList = new ArrayList<Integer>();
	static int IdShot = 0;
	static Random random = new Random();
	static Boolean KillShip4 = false;
	static int x = 0; 
	static int y = 0;

	Ship ship = new Ship();

	Bot(){
		
		Collections.addAll(firstList, 3, 12, 21, 30, 7, 16, 25, 34, 43, 52, 61, 70, 29, 38, 47, 56, 65, 74, 83, 92, 69, 78, 87, 96);
		Collections.addAll(secondList, 14, 23, 32, 41, 18, 27, 36, 45, 54, 63, 72, 81, 49, 58, 67, 76, 85, 94, 89, 98);
		
		for (int i=0; i<bot.length; i++){
			for (int j=0; j<bot.length; j++){
				bot[i][j]=0;
			}
		}
		
		for (int i=0; i<4; i++){
			ship.CreadShip(1, bot);
		}
		
		for (int i=0; i<3; i++){
			ship.CreadShip(2, bot);
		}
		
		for (int i=0; i<2; i++){
			ship.CreadShip(3, bot);
		}
		
		ship.CreadShip(4, bot);
		
		/*for(int i=0; i<bot.length; i++){
			for(int j=0; j<bot.length; j++){
				System.out.print(bot[i][j]+" ");
			}
			System.out.println();
		}*/
		
	}
	
	public static Boolean FireBot(){
		boolean shot = false;
		
		
		if (KillShip4 != true){
			IdShot = random.nextInt(firstList.size());
			x = firstList.get(IdShot)/10;
			y = firstList.get(IdShot)%10;
			
			if (User.user [y+1][x+1] == 1){
				//User.user [y+1][x+1] = 2;
				//Shot.setShot();
				shot = true;
				// поиск соседних границ
			}
			
			else if (User.user [y+1][x+1] == 2){
				//firstList.remove(IdShot);
			}
			
			else if (User.user [y+1][x+1] == 0){
				//User.user [y+1][x+1] = 2;
				
			}
			
			firstList.remove(IdShot);
			//User.Showwww();
			//System.out.println(x +" "+y);
			
			
			
		}
		
		//IdShot = random.nextInt(secondList.size());
		
		
		//System.out.println(secondList.get(IdShot));
		//int x = secondList.get(IdShot)/10;
		//int y = secondList.get(IdShot)%10;
		
		Shot.setCoordinats(x, y);
		//secondList.remove(IdShot);
		return shot;
	}
	
	public static void ChekFire(){
		x++; y++;
		System.out.println(x+" "+y);
		//System.out.println("Проверка "+(x+1)+" "+(y));
		System.out.println(User.user[y][x]);
		if (User.user[y][x+1]==1){
			
			System.out.println("Нашел");
			/*while (User.user[x+2][y+1]==1){
				System.out.println("Нашел");
				x++;
				//System.out.println("Нашел");
			}*/
		}
	}
	
	
}
