
import java.util.Scanner;

class Ship2{
	
		
	//initializing Scanner class
	Scanner scan = new Scanner(System.in);
		
	//every ship properties
	
	private int numberOfShips;
	int numberOfPositions;
		
			
	//setter of number of ships
	public void setNumberOfShips(int gridSize){
		
		byte correctNumber = 0;
				
		while(correctNumber == 0){
		
			System.out.println("The maximum number of ships should be " + (gridSize/2)); 
		
			System.out.print("please enter the number of ships: ");
		
			numberOfShips = scan.nextInt();
		
			if((gridSize/2) >= numberOfShips){
			
				correctNumber = 1;
				this.numberOfShips = numberOfShips;
			}
			else{
			
				System.out.println("Try another size"); 
				
			}
		}
		
	}
	
	//getter of number of ships
	public int getNumberOfShips(){
		
		return this.numberOfShips;
	
	}
	
	public int getNumberOfPositions(){
		
		return this.numberOfPositions;
		
	}
	
	
	//setter and getter of ship sizes that are in the ship list
	
	char[][] createShipList(int numberOfShips){
		
		char[][] shipList = new char[numberOfShips][]; 
		
		int minShipSize = 2;
		
		for(int i = 0; i < numberOfShips; i++){
				
			shipList[i] = new char[minShipSize];
			
			for(int j = 0; j < shipList[i].length; j++){
				if(i == 0){
					
					shipList[i][j] = 'a';
					numberOfPositions++;
				
				}else if(i == 1){
					
					shipList[i][j] = 'b';
					numberOfPositions++;
					
				}else if(i == 2){
					
					shipList[i][j] = 'c';
					numberOfPositions++;
					
				}else if(i == 3){
					shipList[i][j] = 'd';
					numberOfPositions++;
					
				}else if(i == 4){
					shipList[i][j] = 'e';
					numberOfPositions++;
					
				}
			}
			
			minShipSize++;	
		}
		
		return shipList;
		
	}
	
		
	//method to print the ships to be used in a certain grid
	public void printShips(char[][] shipList){
		
		System.out.println();
		
		for(int i = 0; i < shipList.length; i++){
			for(int k = 0; k < shipList[i].length; k++){
			
				
				System.out.print(shipList[i][k]);
				System.out.print(" ");
			
			}
			
			System.out.println();			
		}
		
		System.out.println("\n");
		
	}
	
	
	public static void main(String[] args){
		
		/*Grid2 g = new Grid2();
		Ship2 s = new Ship2();
		
		g.setGridSize();
		int gridSize = g.getGridSize();
		char[][] grid1 = g.createVirtualGrid();
		g.printGrid(grid1);
		
		s.setNumberOfShips(gridSize);
		int numberOfShips = s.getNumberOfShips();
		char[][] shipList = s.createShipList(numberOfShips);
		s.printShips(shipList);
		*/	
	}
	
	
}