class GameStarter{
	
	private int isTurnSelected = 0;
	private int isTurn = 0;
	private int isGameFinished = 0;
	private int user1ReturnValue = 0;
	private int user2ReturnValue = 0;
	private double initialTurnSelector = 0.0;
	
		
	Battle user1 = new Battle();
	Battle user2 = new Battle();
	Grid2 grid = new Grid2();
	
	public void gameManager(char[][] grid1, char[][] grid2, int gridSize, int numberOfShips){
		
	
		while(isGameFinished == 0){		
				
			if(isTurnSelected == 0){
			
				initialTurnSelector = Math.random();
			
				if(initialTurnSelector <= 0.5){
					
					isTurn = 1;
					isTurnSelected = 1;
					
				}else{
					
					isTurn = 2;	
					isTurnSelected = 2;
					
				}
			
			}
		
			while(isTurn == 1){
			
				//USER 1 RECEIVES THE USER 2 GRID
				user1ReturnValue = user1.hitTry(grid2, gridSize, numberOfShips, '*', '#');
				System.out.println("user1 ReturnValue: " + user1ReturnValue);
				
				grid.printGrid(grid2);
				
				
				
				if(user1ReturnValue == 0){
					isTurn = 2;
					
				}
				else if(user1ReturnValue == 1){
					isGameFinished = 1;
					isTurn = 0;
					System.out.println("EL JUGADOR 1 HA GANADO!!!!!!");
					
				}
				else if(user1ReturnValue == 2){
					isTurn = 1;
					
				}else if(user1ReturnValue == -1){
					isGameFinished = -1;
					isTurn = 0;
				}
			
			}
		
			while(isTurn == 2){
			
				//USER 2 RECEIVES THE USER 1 GRID
				user2ReturnValue = user2.hitTry(grid1, gridSize, numberOfShips, '*', '#');
				System.out.println("user2 ReturnValue: " + user2ReturnValue);
				
				grid.printGrid(grid1);			
				
				
				
				if(user2ReturnValue == 0){
					isTurn = 1;
					
				}
				else if(user2ReturnValue == 1){
					isGameFinished = 2;
					isTurn = 0;
					System.out.println("EL JUGADOR 2 HA GANADO!!!!!!");
					
				}
				else if(user2ReturnValue == 2){
					isTurn = 2;
					
				}else if(user2ReturnValue == -1){
					isGameFinished = -1;
					isTurn = 0;
				}
			
			}
		}
		
	}
	
	public static void main(String[] args){
	
	//INSTANTIATING GRID CLASS
	Grid2 g = new Grid2();
	
	//SETTING SIZE OF VIRTUAL GRID
	g.setGridSize();
	int gridSize = g.getGridSize();
	
	//CREATING THE VIRTUAL GRIDS
	char[][] player1Grid = g.createVirtualGrid();
	char[][] player2Grid = g.createVirtualGrid();
	
	//PRINTING THE UNPOPULATED VIRTUAL GRIDS
	g.printGrid(player1Grid);
	g.printGrid(player2Grid);
	
	//INSTANTIATING SHIP CLASS
	Ship2 s = new Ship2();
	
	//SET NUMBER OF SHIPS WITH SHIP CLASS
	s.setNumberOfShips(gridSize);
	int numberOfShips = s.getNumberOfShips();
			
	//CREATE SHIP LIST WITH SHIP CLASS
	char[][] shipList1 = s.createShipList(numberOfShips);
	char[][] shipList2 = s.createShipList(numberOfShips);
	
	//PRINTING SHIP LISTS
	s.printShips(shipList1);
	s.printShips(shipList2);
	
	
	//INSTANTIATING THE USER CLASS
	User2 u1 = new User2(); 
	User2 u2 = new User2();

	//POPULATE THE VIRTUAL GRIDS WITH THE SHIP LISTS
	u1.positionManager(player1Grid, shipList1);
	u2.positionManager(player2Grid, shipList2);
	
	//PRINTING POPULATED GRIDS
	g.printGrid(player1Grid);
	g.printGrid(player2Grid);
	
	
	//INSTANTIATE THE GAME STARTER CLASS
	GameStarter gs = new GameStarter();
	
	//STARTING THE GAME
	gs.gameManager(player1Grid, player2Grid, gridSize, numberOfShips);
	
	}
}