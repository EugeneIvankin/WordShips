public class Ship {
	
	Ship(){
		
	}
	
	
	public void CreadShip(int l, int [][] arr){

		if (l==1){
			
			int x = 2 + (int)(Math.random() * ((9 - 2) + 1)); //случайная координата по х на [2;9]
			int y = 2 + (int)(Math.random() * ((9 - 2) + 1)); //случайная координата по у на [2;9]
			
			checkOne(x,y,arr);
			
			while(checkOne(x,y,arr)==false){
				x = 2 + (int)(Math.random() * ((9 - 2) + 1));
				y = 2 + (int)(Math.random() * ((9 - 2) + 1)); 
				checkOne(x,y,arr);
			}
			
			placeOne(x,y,arr);	
		}
		
		else if (l==2){
			
			int x = 2 + (int)(Math.random() * ((8 - 2) + 1)); //случайная координата по х на [2;8]
			int y = 2 + (int)(Math.random() * ((8 - 2) + 1)); //случайная координата по у на [2;8]
			int v = (int)(Math.random() * 2); //направление коробля, 0 - горизонталь, 1 - вертикаль
			
			checkOther(x,y,v,l,arr);
			
			while(checkOther(x,y,v,l,arr)==false){
				x = 2 + (int)(Math.random() * ((8 - 2) + 1));
				y = 2 + (int)(Math.random() * ((8 - 2) + 1));
				v = (int)(Math.random() * 2);
				checkOther(x,y,v,l,arr);
			}
			
			placeOther(x,y,v,l,arr);		
		}
		
		else if (l==3 || l==4){
			int v = (int)(Math.random() * 2); //направление коробля, 0 - горизонталь, 1 - вертикаль
			int x = 0;
			int y = 0;
			
			if (v==0){
				x = (int)(Math.random() * 2);
				if (x==0) x=10;
				y = 1 + (int)(Math.random() * ((7 - 1) + 1)); //случайная координата по у на [1;7]
			}
			
			if (v==1){
				y = (int)(Math.random() * 2);
				if (y==0) y=10;
				x = 1 + (int)(Math.random() * ((7 - 1) + 1)); //случайная координата по x на [1;7]
			}
			
			while(checkOther(x,y,v,l,arr)==false){
				v = (int)(Math.random() * 2);
				if (v==0){
					x = (int)(Math.random() * 2);
					if (x==0) x=10;
					y = 1 + (int)(Math.random() * ((7 - 1) + 1)); //случайная координата по у на [1;7]
				}
				
				if (v==1){
					y = (int)(Math.random() * 2);
					if (y==0) y=10;
					x = 1 + (int)(Math.random() * ((7 - 1) + 1)); //случайная координата по x на [1;7]
				}
				
				checkOther(x,y,v,l,arr);
			}
			
			placeOther(x,y,v,l,arr);
		}
	}
	
	//проверка области для однопалубного корабля
	
	public Boolean checkOne(int x, int y, int [][] arr){
		boolean anser=true;
		for(int i=x-1; i<x+2; i++){
			for (int j=y-1; j<y+2; j++){
				if (arr[i][j]==1){
					anser=false;	
				}
			}
			
		}
		return anser;
	}
	
	//проверка области для двух-, трех-, четырехпалубного корабля
	
	public Boolean checkOther(int x, int y, int v, int l, int [][] arr){
		boolean anser=true;
		
		if (v==0){
			for(int i=x-1; i<x+2; i++){
				for (int j=y-1; j<y+l+1; j++){
					if (arr[i][j]==1){
						anser=false;
					}
				}
			}
		}
		
		else if (v==1){
			for(int i=x-1; i<x+l+1; i++){
				for (int j=y-1; j<y+2; j++){
					if (arr[i][j]==1){
						anser=false;
					}
				}
			}
		}
		
		return anser;
	}
	
	//размещение однопалубного корабля
	
		public void placeOne(int x, int y, int [][] arr){
			for(int i=x-1; i<x+2; i++){
				for (int j=y-1; j<y+2; j++){
					arr[i][j]=2;
				}
				arr[x][y]=1;
			}
		}
	
	//размещение двух-, трех-, четырехпалубного корабля
	
	public void placeOther(int x, int y, int v, int l, int [][] arr){
		if (v==0){
			for(int i=x-1; i<x+2; i++){
				for (int j=y-1; j<y+l+1; j++){
					arr[i][j]=2;
				}
			}
			for (int i=y; i<y+l;i++){
				arr[x][i]=1;
			}
		}
		
		else if (v==1){
			for(int i=x-1; i<x+l+1; i++){
				for (int j=y-1; j<y+2; j++){
					arr[i][j]=2;
				}
			}
			for(int i=x; i<x+l; i++){
				arr[i][y]=1;
			}
		}
	}
	
}
