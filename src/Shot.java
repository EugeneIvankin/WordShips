
public class Shot {
	
	static int x=0;
	static int y=0;
	//static boolean shot = false; 

	Shot(){
		
	}
	
	public static void setCoordinats(int x, int y){	
		Shot.x=x;
		Shot.y=y;
		
	}
	
	public static int getX(){
		return x;
	}
	
	
	
	public static int getY(){
		return y;
	}
	
	/*public static void setShot(){
		shot = true;
		System.out.println(shot);
	}
	
	public static boolean getShot(){
		return shot;
	}*/

}
