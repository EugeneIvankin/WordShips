
public class User {
	
	static int user [][] = new int [12][12];
	static int k=0;
	static boolean shot = false;
	
	
	User(){
		CreadeUserArr();
	}
	
	public static void setShot(){
		shot = true;
	}
	
	public static boolean getShot(){
		return shot;
	}
	
	public static void CreadeUserArr(){
		for (int i=1; i<10; i++){
			for(int j=1; j<10; j++){
				user[i][j]=0;
			}
		}
	}
	
	public static void UpdateUserArr(int i, int j, String l){
		if (l.equals("ship1")){
			user[i][j]=1;
		}
		else if (l.equals("ship2")){
			k=j+2;
			for (;j<k; j++){
				user[i][j]=1;
			}
			k=0;
		}
		else if (l.equals("ship3")){
			k=j+3;
			for (;j<k; j++){
				user[i][j]=1;
			}
			k=0;
		}
		else if (l.equals("ship4")){
			k=j+4;
			for (;j<k; j++){
				user[i][j]=1;
			}
		}
		
		else if (l.equals("rev2")){
			k=i+2;
			for (;i<k; i++){
				user[i][j]=1;
			}
		}
		
		else if (l.equals("rev3")){
			k=i+3;
			for (;i<k; i++){
				user[i][j]=1;
			}
		}
		
		else if (l.equals("rev4")){
			k=i+4;
			for (;i<k; i++){
				user[i][j]=1;
			}
		}
		
	
	}
	
	public static void Showwww(){
		for (int i=0; i<12; i++){
			for(int j=0; j<12; j++){
				System.out.print(user[i][j]+" ");
			}
			System.out.println();
		}
	}

}
