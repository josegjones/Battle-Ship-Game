
import java.util.Scanner;

class Grid2{
	
		//initilizing Scanner class
	Scanner scan = new Scanner(System.in);
	
	
	private int gridSize;
	
	
	
	//setter and getter for grid size
	public void setGridSize(){
		
		int correctSize = 0;
		int gridSize;
		
		while(correctSize == 0){
		
			System.out.print("Please enter the size of the grid: ");
		
			gridSize = scan.nextInt();
		
			if(gridSize > 10 || gridSize < 3){
			
				System.out.println("\nGrid maximum size is 10 slots, and minimum is 3 slots, try again please!");
			
			}
			else{
				
				this.gridSize = gridSize;
				correctSize = 1;
			}
		}
	}
	
	public int getGridSize(){
		return this.gridSize;
	}
	
	//method to create the virtual grid
	
	public char[][] createVirtualGrid(){
		
		//declaring the 2d array and initilizing it
		char[][] virtualGrid = new char[getGridSize()][getGridSize()];
		
		for(int i = 0; i < virtualGrid.length; i++){
			
			for(int j = 0; j < virtualGrid[i].length; j++){
			
				virtualGrid[i][j] = '0';
			
			}
		}
		
		return virtualGrid;
	}
	
	
	//method to print the any grid
	
	public void printGrid(char[][] grid){
		
		for(int i = 0; i < grid.length; i++){
			for(int k = 0; k < grid[i].length; k++){
			
				System.out.print(grid[i][k]);
				System.out.print(" ");
			
			}
			
			System.out.println();
			
		}
		
		System.out.println("\n\n");
		
	}
	
	public static void main(String[] args){
		
		/*Grid2 x = new Grid2();
		
		x.setGridSize();
		char[][] grid1 = x.createVirtualGrid();
		x.printGrid(grid1);
		*/
		
	}
	
}