class User2{
	
	
	public static void positionManager(char[][] table, char[][] shipList){
		
		double decision;
		int numberOfShips = shipList.length;
		int ship = 0;
		
		while(numberOfShips > 0){
			
			decision = Math.random();
			
			if(decision >= 0.5){
				
				populateTableHorizontal(table, shipList, ship);
				ship++;
				
			}else{
				
				populateTableVertical(table, shipList, ship);
				ship++;
				
			}
			
			numberOfShips--;
			
		}
		
		
	}
	
	public static void populateTableVertical(char[][] table, char[][] shipList, int ship){
		
		
		//Declaring local variables.	
		int gridSize = table.length;
				
		int shipSettled = 0;
				
		int rand1;
		
		int rand2;
		
		int settlements;
		
		//GRABING EACH SHIP, KNOWING THAT THERE ARE NO SHIPS SETTLED YET. 
		for(int i = ship; i <= ship; i++){
			
			//THIS VARIABLE RE-STARTS THE NUMBER OF SHIP PARTS SETTLED.
			settlements = 0;
			
			//SELECTING THE INITIAL POSITION TO PLACE THE FIRST PART OF THE SHIP.
			rand1 = (int)(Math.random()*(gridSize - (shipList[i].length)));
			
			rand2 = (int)(Math.random()*(gridSize));
			
			//AFTER ALL PARTS OF SHIP X HAVE BEEN SETTLED, A NEW SHIP SETTLEMENT START.
			if(shipSettled == 1){
				
				shipSettled = 0;
				
			}
			
			//THIS BLOCK OF CODE IS EXECUTED WHILE PARTS OF A SHIP ARE BEING PLACED.
			//ONCE ALL PARTS OF ONE SHIP ARE PLACED, THE LOOP STOPS AND THE NEXT SHIP IS GRAB
			//BY EXECUTING THE PREVIOUS FOR LOOP (IN CHARGE OF GRABING A NEW SHIP).
			while(shipSettled == 0){
				
				//THIS BLOCK IS INTENDED TO REPRESENT THE SETTLEMENT OF EACH PART OF ONE SHIP.
				//SHIPS ARE PLACED PART BY PART.
				//SHIPLIST: AN ARRAY THAT INCLUDES ALL SHIPS
				//PART = ONE SLOT OF THE ARRAY.
				for(int j = 0; j < shipList[i].length; j++){
					
					//THIS BLOCK OF CODE CHECKS FOR AVAILABILITY OF THE POSITION SELECTED
					//TO PLACE THE FIRST PART OF THE SHIP.
					//AVAILABILITY = THE POSITION IN THE GRID IS EQUAL TO ZERO
					//IN CASE THE POSITION SELECTED IS NOT AVAILABLE, THE ELSE BLOCK IS EXECUTED
					if(table[rand1][rand2] == '0'){
						
						table[rand1][rand2] = shipList[i][j];
						
						settlements++;
						
						rand1++;
						
							//THIS BLOCK IS CHECKING IF ALL PARTS OF THE SHIP HAVE BEEN SETTLED
							if(settlements == shipList[i].length){
								
								shipSettled = 1;
																				
							}		
					//IN CASE THE POSITION SELECTED BY THE VIRTUAL PLAYER IS NOT AVAILABLE (!= 0)
					//THIS BLOCK OF CODE IS EXECUTED	
					}else{
									
						//THIS BLOCK IS INTENDED TO CHECK IF THE UNAVAILABLE POSITION IS FOUND 
						//WHEN THE FIRST PART OF THE SHIP WAS GOING TO BE SETTLED.
						//IF IT WASN'T THE FIRST PART, THE ELSE BLOCK IS EXECUTED	
						if(j == 0){
							
							//THIS BLOCK IS USED TO LOOK FOR AN AVAILABLE POSITION.
							//THE SEARCH WILL STOP ONCE THE POSITION SELECTED IS EQUAL TO ZERO
							while(table[rand1][rand2] != '0'){
								
								int initialRand1;
								int initialRand2;
																
								initialRand1 = (int)(Math.random()*(gridSize - (shipList[i].length))); 
								initialRand2 = (int)(Math.random()*(gridSize));
								
								rand1 = initialRand1;
								rand2 = initialRand2;
								
								//NECESSARY TO AVOID INDEXOUTOFBOUNDS ERROR.
								//HAS TO DO WITH THE INCREMENTAL SECTION OF THE FOR LOOP.
								//THE COUNT OF J IS ZERO WHEN CONTROL ENTERS THIS BLOCK,
								//SO BY THE TIME THE NEW AVAILABLE POSITION ID FOUND AND CONTROL IS BACK
								//TO THE FOR LOOP, THE VALUE OF J WILL BE 1, AND THE SHIP INITIAL PART WILL
								//BE SKIP.
								j = -1;
								
							}
						//THIS BLOCK RECEIVES CONTROL WHEN THE UNAVAILABLE POSITION FOUND IS NOT THE INITIAL POSITION	
						}else{
						
							int z;
							
							//THIS BLOCK IS USE TO SET BACK TO ZERO ALL THE POSITIONS USED WHEN TRYING TO SET THE SHIP
							//BEFORE FINDING THE UNAVAILABLE POSITION IN THE WAY
							//THE Z VARIABLE WILL BE EQUAL TO THE NUMBER OF SHIP PARTS PLACED, SO THEY CAN BE ERASED
							for(z = settlements; z > 0; z--){
						
								rand1--;
							
								table[rand1][rand2] = '0';
														
							}
							
							//ONCE THE USED PLACES HAVE BEEN REMOVED (Z == 0), A NEW RANDOM POSITION IS SELECTED BY VIRTUAL PLAYER 
							if(z == 0){
								
									int tempRand1 = (int)(Math.random()*(gridSize - (shipList[i].length))); 
									int tempRand2 = (int)(Math.random()*(gridSize));
									rand1 = tempRand1;
									rand2 = tempRand2;
									
								//NECESSARY TO AVOID INDEXOUTOFBOUNDS ERROR.
								//HAS TO DO WITH THE INCREMENTAL SECTION OF THE FOR LOOP.
								//THE COUNT OF J IS ZERO WHEN CONTROL ENTERS THIS BLOCK,
								//SO BY THE TIME THE NEW AVAILABLE POSITION ID FOUND AND CONTROL IS BACK
								//TO THE FOR LOOP, THE VALUE OF J WILL BE 1, AND THE SHIP INITIAL PART WILL
								//BE SKIP.
									j = -1;
									
									//AS A NEW POSITION IS SELECTED, ALL PREVIOUS SETTLEMENTS ARE INVALID,
									//FOR THAT REASON THE SETTLEMENT COUNT IS SET BACK TO ZERO
									settlements = 0;	
							}
						}
					
					}
				
				}
								
			}
						
		}		
		//return table;
	}
	
	public static void populateTableHorizontal(char[][] table, char[][] shipList, int ship){
		
		
		//Declaring local variables.	
		int gridSize = table.length;
				
		int shipSettled = 0;
				
		int rand1;
		
		int rand2;
		
		int settlements;
		
		//GRABING EACH SHIP, KNOWING THAT THERE ARE NO SHIPS SETTLED YET. 
		for(int i = ship; i <= ship; i++){
			
			//THIS VARIABLE RE-STARTS THE NUMBER OF SHIP PARTS SETTLED.
			settlements = 0;
			
			//SELECTING THE INITIAL POSITION TO PLACE THE FIRST PART OF THE SHIP.
			rand1 = (int)(Math.random()*(gridSize));
			
			rand2 = (int)(Math.random()*(gridSize - (shipList[i].length)));
			
			//AFTER ALL PARTS OF SHIP X HAVE BEEN SETTLED, A NEW SHIP SETTLEMENT START.
			if(shipSettled == 1){
				
				shipSettled = 0;
				
			}
			
			//THIS BLOCK OF CODE IS EXECUTED WHILE PARTS OF A SHIP ARE BEING PLACED.
			//ONCE ALL PARTS OF ONE SHIP ARE PLACED, THE LOOP STOPS AND THE NEXT SHIP IS GRAB
			//BY EXECUTING THE PREVIOUS FOR LOOP (IN CHARGE OF GRABING A NEW SHIP).
			while(shipSettled == 0){
				
				//THIS BLOCK IS INTENDED TO REPRESENT THE SETTLEMENT OF EACH PART OF ONE SHIP.
				//SHIPS ARE PLACED PART BY PART.
				//SHIPLIST: AN ARRAY THAT INCLUDES ALL SHIPS
				//PART = ONE SLOT OF THE ARRAY.
				for(int j = 0; j < shipList[i].length; j++){
					
					//THIS BLOCK OF CODE CHECKS FOR AVAILABILITY OF THE POSITION SELECTED
					//TO PLACE THE FIRST PART OF THE SHIP.
					//AVAILABILITY = THE POSITION IN THE GRID IS EQUAL TO ZERO
					//IN CASE THE POSITION SELECTED IS NOT AVAILABLE, THE ELSE BLOCK IS EXECUTED
					if(table[rand1][rand2] == '0'){
						
						table[rand1][rand2] = shipList[i][j];
						
						settlements++;
						
						rand2++;
						
							//THIS BLOCK IS CHECKING IF ALL PARTS OF THE SHIP HAVE BEEN SETTLED
							if(settlements == shipList[i].length){
								
								shipSettled = 1;
																				
							}		
					//IN CASE THE POSITION SELECTED BY THE VIRTUAL PLAYER IS NOT AVAILABLE (!= 0)
					//THIS BLOCK OF CODE IS EXECUTED	
					}else{
									
						//THIS BLOCK IS INTENDED TO CHECK IF THE UNAVAILABLE POSITION IS FOUND 
						//WHEN THE FIRST PART OF THE SHIP WAS GOING TO BE SETTLED.
						//IF IT WASN'T THE FIRST PART, THE ELSE BLOCK IS EXECUTED	
						if(j == 0){
							
							//THIS BLOCK IS USED TO LOOK FOR AN AVAILABLE POSITION.
							//THE SEARCH WILL STOP ONCE THE POSITION SELECTED IS EQUAL TO ZERO
							while(table[rand1][rand2] != '0'){
								
								int initialRand1;
								int initialRand2;
																
								initialRand1 = (int)(Math.random()*(gridSize)); 
								initialRand2 = (int)(Math.random()*(gridSize - (shipList[i].length)));
								
								rand1 = initialRand1;
								rand2 = initialRand2;
								
								//NECESSARY TO AVOID INDEXOUTOFBOUNDS ERROR.
								//HAS TO DO WITH THE INCREMENTAL SECTION OF THE FOR LOOP.
								//THE COUNT OF J IS ZERO WHEN CONTROL ENTERS THIS BLOCK,
								//SO BY THE TIME THE NEW AVAILABLE POSITION ID FOUND AND CONTROL IS BACK
								//TO THE FOR LOOP, THE VALUE OF J WILL BE 1, AND THE SHIP INITIAL PART WILL
								//BE SKIP.
								j = -1;
								
							}
						//THIS BLOCK RECEIVES CONTROL WHEN THE UNAVAILABLE POSITION FOUND IS NOT THE INITIAL POSITION	
						}else{
						
							int z;
							
							//THIS BLOCK IS USE TO SET BACK TO ZERO ALL THE POSITIONS USED WHEN TRYING TO SET THE SHIP
							//BEFORE FINDING THE UNAVAILABLE POSITION IN THE WAY
							//THE Z VARIABLE WILL BE EQUAL TO THE NUMBER OF SHIP PARTS PLACED, SO THEY CAN BE ERASED
							for(z = settlements; z > 0; z--){
						
								rand2--;
							
								table[rand1][rand2] = '0';
														
							}
							
							//ONCE THE USED PLACES HAVE BEEN REMOVED (Z == 0), A NEW RANDOM POSITION IS SELECTED BY VIRTUAL PLAYER 
							if(z == 0){
								
									int tempRand1 = (int)(Math.random()*(gridSize));
									int tempRand2 = (int)(Math.random()*(gridSize - (shipList[i].length)));
									
									rand1 = tempRand1;
									rand2 = tempRand2;
									
								//NECESSARY TO AVOID INDEXOUTOFBOUNDS ERROR.
								//HAS TO DO WITH THE INCREMENTAL SECTION OF THE FOR LOOP.
								//THE COUNT OF J IS ZERO WHEN CONTROL ENTERS THIS BLOCK,
								//SO BY THE TIME THE NEW AVAILABLE POSITION ID FOUND AND CONTROL IS BACK
								//TO THE FOR LOOP, THE VALUE OF J WILL BE 1, AND THE SHIP INITIAL PART WILL
								//BE SKIP.
									j = -1;
									
									//AS A NEW POSITION IS SELECTED, ALL PREVIOUS SETTLEMENTS ARE INVALID,
									//FOR THAT REASON THE SETTLEMENT COUNT IS SET BACK TO ZERO
									settlements = 0;	
							}
						}
					
					}
				
				}
								
			}
						
		}		
		//return table;
	}
	
	
	public static void main(String[] args){
	
		/*Grid2 g = new Grid2();
		Ship2 s = new Ship2();
		User2 u = new User2();
		
		g.setGridSize();
		int gridSize = g.getGridSize();
		char[][] grid1 = g.createVirtualGrid();
		g.printGrid(grid1);
		
		s.setNumberOfShips(gridSize);
		int numberOfShips = s.getNumberOfShips();
		char[][] shipList = s.setAndGetShipList(numberOfShips);
		s.printShips(shipList);
		
		u.positionManager(grid1,shipList);
		g.printGrid(grid1);
			*/	
	}
	
}