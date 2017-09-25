

class Battle{
	

	//-------------------------------------INSTANCE VARIABLES-------------------------------
	
	//VARIABLES HOLDING THE RANDOM COORDINATES
	private int rand1 = 0;
	private int rand2 = 0;
	
	//VARIABLES HOLDING THE INITIAL RANDOM COORDINATES
	private int initialRand1 = 0;
	private int initialRand2 = 0;
	
	
	//THIS VARIABLE HOLDS THE INITIAL NUMBER OF POSITIONS, USED AS A KEY TO ENTER THE 
	//RANDOM CORDINATE ASSIGNMENT BLOCK
	//private int initialNumberOfPositions = 0;
	
	//THIS VARIABLE WHEN BEING ZERO, INDICATES THAT ALL DIRECTIONS OF THE SECTOR HAVENT BEEN CHECKED,
	//WHEN BEING 1 INDICATES THAT NEW RANDOM COORDINATE IS REQUIRED (BOUNDARY REACHED, A SYMBOL FOUND, A SHIP DESTROYED).
	private int needNewCoordinates = 1;	
	
	//VARIABLE THAT INDICATES WHETHER A SECTOR OF THEGIVEN COORDINATE HAS BEEN SELECTED (0 -> NO, 1 -> YES)
	private int needSectorSelection = 1;
	
	//VARIABLE THAT WILL HOLD THE SECTOR ASSIGN, BASED ON THE COORDINATE AND gridSize GIVEN TO METHOD checkSectors().
	private int sectorSelected = 0;
	
	//VARIABLE THAT ALLOWS THE USER TO TAKE A DIRECTION IN THE SECTOR GIVEN.
	private int directionToCheck = 0;
	
	//THESE VARIABLES WILL DETERMAIN THE AMOUNT OF TIMES A SHIP IS HIT, SO THE USER CAN KNOW WHEN IT IS DESTROYED.
	private int hitA, hitB, hitC, hitD, hitE;
	
	//THIS VARIABLE IS MADE GLOBAL SO THAT IT DOESNT RESET ITSELF EVERYTIME THE METHOOD IS CALLED
	private int numberOfPositions = 0;
	
	//THIS VARIABLE IS USED TO AVOID THE PROGRAM TO GO DIRECTLY TO ELSE-IF(POSITION == 0), WHEN CHECKING FOR DIRECTIONS
	private int checkingDirections = 0;
	
	//---------------------------------------INSTANCE METHODS---------------------------------------------
	
	
	public int hitTry(char[][] grid, int gridSize, int numberOfShips, char userHitSign, char userMiss){
	
		System.out.println("needNewCoordinates at beginning: " + needNewCoordinates);
						
		//BLOCK TO GET THE NUMBER OF POSITIONS
		
		if(numberOfPositions == 0){
			
			if(numberOfShips == 2){
				
				numberOfPositions = 5;
				
			}else if(numberOfShips == 3){
				
				numberOfPositions = 9;
				
			}else if(numberOfShips == 4){
				
				numberOfPositions = 14;
				
			}else if(numberOfShips == 5){
				
				numberOfPositions = 20;
				
			}
			
		}
	
			
		//-----------------BLOCK OF RANDOM COORDINATES ASSIGNMENT----------------
		
		if(needNewCoordinates == 1){
			
				rand1 = (int)(Math.random() * gridSize);
				rand2 = (int)(Math.random() * gridSize);
				
				if(rand1 == gridSize){
					
					rand1 = (gridSize - 1);
					
				}
				
				if(rand2 == gridSize){
					
					rand2 = (gridSize - 1);
					
				}
				
				
				initialRand1 = rand1;
				initialRand2 = rand2;
				
				
				needNewCoordinates = 0;
			
			System.out.println("Random Coordinates: grid[" + rand1 + "]" + "[" + rand2 + "]");
				
		}
		
		//---------------------BLOCK THAT CHECKS THE VALUE IN THE RANDOM COORDINATE------------------
		
		
		
		//-------------------BLOCK THAT CHECKS IF VALUE IN RANDOM COORDINATE IS A LETTER-------------
		if(grid[rand1][rand2] == 'a' || grid[rand1][rand2] == 'b' || grid[rand1][rand2] == 'c' || 
		grid[rand1][rand2] == 'd' || grid[rand1][rand2] == 'e' || checkingDirections == 1){
			
			
			System.out.println("Into block that checked value in position");
			System.out.println("grid[" + rand1 + "]" + "[" + rand2 + "] : " + grid[rand1][rand2]);
			
			//-------------------BLOCK THAT CHECKS THE SECTOR OF THE COORDINATE GIVEN----------------
			if(needSectorSelection == 1){
				
				sectorSelected = checkSectors(rand1, rand2, gridSize);
				needSectorSelection = 0;
				
				System.out.println("Into block that assigns a sector");
				System.out.println("Sector selected: " + sectorSelected);
			}
			
			//-------------------BLOCK THAT CHECKS ALL DIRECTIONS ON EVERY SECTOR-------------------
			
			if(sectorSelected == 1){
				
				System.out.println("Into sector: " + sectorSelected);
				
				//CHECKING RIGHT DIRECTION				
				if(directionToCheck == 0){
					
					System.out.println("Into Direction: " + directionToCheck);
					
					int gapOfMovement = gridSize - rand2;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement > 0){
					
					System.out.println("Into WHILE of direction: " + directionToCheck);
					System.out.println("gapOfMovement:" + gapOfMovement + "hitCheck:" + hitCheck);
					System.out.println("Position to check: " + "grid[" + rand1 + "]" + "[" + rand2 + "]");
					
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}		
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
								
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
								
							if(hitC == 4){
									
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;		
								directionToCheck = 0;	
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							System.out.println("Entered block where coordinate == 0");
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 1;
							rand2 = initialRand2;
							rand1 = initialRand1 - 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							System.out.println("Entered block where coordinate == * #");
							
							directionToCheck = 1;
							rand2 = initialRand2;
							rand1 = initialRand1 - 1;
							checkingDirections = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						System.out.println("Entered block where initialGapOfMovement == hitCheck");
						
						directionToCheck = 1;
						rand2 = initialRand2;
						rand1 = initialRand1 - 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				
				//CHECKING TOP DIRECTION
				if(directionToCheck == 1){
					
					int gapOfMovement = rand1 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement > 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
							
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
									
							if(gapOfMovement > 1){
								
								rand1--;
							
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
							
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;								
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement > 1){
								
								rand1--;
							
							}
							
							if(hitC == 4){
									
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement > 1){
								
								rand1--;
							
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement > 1){
								
								rand1--;
							
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 2;
							rand1 = initialRand1 + 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 2;
							rand1 = initialRand1 + 1;
							checkingDirections = 1;
							return 2;
						}	
					}
					
					if(initialGapOfMovement == hitCheck){
						
						directionToCheck = 2;
						rand1 = initialRand1 + 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				//CHECKING BOTTOM DIRECTION
				if(directionToCheck == 2){
					
					int gapOfMovement = gridSize - rand1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement > 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
							
							System.out.println("hitB: " + hitB);
							
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
								
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
								
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;														
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
								
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;			
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
								
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;			
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 0;
							checkingDirections = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						checkingDirections = 0;
						directionToCheck = 0;
						needNewCoordinates = 1;
						needSectorSelection = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
								
			}else if(sectorSelected == 2){
				
				System.out.println("Into sector: " + sectorSelected);
				
				//CHECKING BOTTOM DIRECTION
				if(directionToCheck == 0){
					
					int gapOfMovement = gridSize - rand1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement > 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											

							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitE == 6){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 + 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 + 1;
							checkingDirections = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						directionToCheck = 1;
						rand1 = initialRand1;
						rand2 = initialRand2 + 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
										
				}
				
				//CHECKING RIGHT DIRECTION				
				if(directionToCheck == 1){
					
					int gapOfMovement = gridSize - rand2;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement > 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitB == 3){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitE == 6){
							
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						checkingDirections = 0;
						directionToCheck = 0;
						needNewCoordinates = 1;
						needSectorSelection = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				
			}else if(sectorSelected == 3){
				
				System.out.println("Into sector: " + sectorSelected);
				
				//CHECKING TOP DIRECTION
				if(directionToCheck == 0){
					
					int gapOfMovement = rand1 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement >= 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
						
									return 1;
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitC == 4){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitD == 5){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											

							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitE == 6){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 + 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 + 1;
							checkingDirections = 1;
							return 2;
						}	
					}
					
					if(initialGapOfMovement == hitCheck){
						
						directionToCheck = 1;
						rand1 = initialRand1;
						rand2 = initialRand2 + 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
					
				}
				//CHECKING RIGHT DIRECTION				
				if(directionToCheck == 1){
					
					int gapOfMovement = gridSize - rand2;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement > 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitC == 4){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitD == 5){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
						
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						checkingDirections = 0;
						directionToCheck = 0;
						needNewCoordinates = 1;
						needSectorSelection = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				
			}else if(sectorSelected == 4){
				
				System.out.println("Into sector: " + sectorSelected);
				
				//CHECKING TOP DIRECTION				
				if(directionToCheck == 0){
					
					int gapOfMovement = rand1 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement >= 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitC == 4){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											

							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 1;
							rand1 = initialRand1 + 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 1;
							rand1 = initialRand1 + 1;
							checkingDirections = 1;
							return 2;
						}	
					}
					
					if(initialGapOfMovement == hitCheck){
						
						directionToCheck = 1;
						rand1 = initialRand1 + 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				
				//CHECKING BOTTOM DIRECTION
				if(directionToCheck == 1){
					
					int gapOfMovement = gridSize - rand1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement > 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
						
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitB == 3){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitE == 6){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 2;
							rand1 = initialRand1;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 2;
							rand1 = initialRand1;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						directionToCheck = 2;
						rand1 = initialRand1;
						rand2 = initialRand2 - 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				//CHECKING LEFT DIRECTION
				if(directionToCheck == 2){
					
					int gapOfMovement = rand2 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement >= 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitD == 5){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						checkingDirections = 0;
						directionToCheck = 0;
						needNewCoordinates = 1;
						needSectorSelection = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				
			}else if(sectorSelected == 5){
				
				System.out.println("Into sector: " + sectorSelected);
				
				//CHECKING BOTTOM DIRECTION
				if(directionToCheck == 0){
					
					int gapOfMovement = gridSize - rand1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement > 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											

							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						directionToCheck = 1;
						rand1 = initialRand1;
						rand2 = initialRand2 - 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				//CHECKING LEFT DIRECTION
				if(directionToCheck == 1){
					
					int gapOfMovement = rand2 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement >= 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitD == 5){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						checkingDirections = 0;
						directionToCheck = 0;
						needNewCoordinates = 1;
						needSectorSelection = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				
			}else if(sectorSelected == 6){
				
				System.out.println("Into sector: " + sectorSelected);
				
				//CHECKING TOP DIRECTION
				if(directionToCheck == 0){
					
					int gapOfMovement = rand1 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement >= 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							return 2;
						}	
					}
					
					if(initialGapOfMovement == hitCheck){
						
						directionToCheck = 1;
						rand1 = initialRand1;
						rand2 = initialRand2 - 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				//CHECKING LEFT DIRECTION
				if(directionToCheck == 1){
					
					int gapOfMovement = rand2 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement >= 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						checkingDirections = 0;
						directionToCheck = 0;
						needNewCoordinates = 1;
						needSectorSelection = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				
			}else if(sectorSelected == 7){
				
				System.out.println("Into sector: " + sectorSelected);
				
				//CHECKING BOTTOM DIRECTION				
				if(directionToCheck == 0){
					
					int gapOfMovement = gridSize - rand1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement > 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitD == 5){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitE == 6){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 + 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 + 1;
							checkingDirections = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						directionToCheck = 1;
						rand1 = initialRand1;
						rand2 = initialRand2 + 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				
				//CHECKING RIGHT DIRECTION
				if(directionToCheck == 1){
					
					int gapOfMovement = gridSize - rand2;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement > 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitD == 5){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitE == 6){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 2;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 2;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						directionToCheck = 2;
						rand2 = initialRand2 - 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				//CHECKING LEFT DIRECTION
				if(directionToCheck == 2){
					
					int gapOfMovement = rand2 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement >= 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						checkingDirections = 0;
						directionToCheck = 0;
						needNewCoordinates = 1;
						needSectorSelection = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				
				
			}else if(sectorSelected == 8){
				
				System.out.println("Into sector: " + sectorSelected);
				
				//CHECKING TOP DIRECTION				
				if(directionToCheck == 0){
					
					int gapOfMovement = rand1 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement >= 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitB == 3){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 + 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 1;
							rand1 = initialRand1;
							rand2 = initialRand2 + 1;
							checkingDirections = 1;
							return 2;
						}	
					}
					
					if(initialGapOfMovement == hitCheck){
						
						directionToCheck = 1;
						rand1 = initialRand1;
						rand2 = initialRand2 + 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				
				//CHECKING RIGHT DIRECTION
				if(directionToCheck == 1){
					
					int gapOfMovement = gridSize - rand2;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement > 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitC == 4){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											

							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitE == 6){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 2;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							directionToCheck = 2;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						directionToCheck = 2;
						rand2 = initialRand2 - 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
										
				}
				//CHECKING LEFT DIRECTION
				if(directionToCheck == 2){
					
					int gapOfMovement = rand2 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					while(gapOfMovement >= 0){
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							grid[rand1][rand2] = userMiss;
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							checkingDirections = 0;
							directionToCheck = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						checkingDirections = 0;
						directionToCheck = 0;
						needNewCoordinates = 1;
						needSectorSelection = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						return 1;
					}
					
				}
				
			}else if(sectorSelected == 9){
				
				System.out.println("Into sector: " + sectorSelected);
				
				//CHECKING TOP DIRECTION				
				if(directionToCheck == 0){
					
					System.out.println("Enetered direction: " + directionToCheck);
					
					int gapOfMovement = rand1 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					System.out.println("gapOfMovement: " + gapOfMovement + " hitCheck: " + hitCheck);
					
					while(gapOfMovement >= 0){
						
						System.out.println("Entered WHILE in direction: " + directionToCheck);
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitB == 3){
										
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;		
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitC == 4){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement >= 1){
								
								rand1--;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							System.out.println("Entered condition, coord == 0");
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 1;
							rand1 = initialRand1 + 1;
							checkingDirections = 1;
							System.out.println("needNewCoordinates: " + needNewCoordinates);
										
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							System.out.println("Entered condition, coord == * #");
							
							directionToCheck = 1;
							rand1 = initialRand1 + 1;
							checkingDirections = 1;
							
							return 2;
						}
					}
					
					if(initialGapOfMovement == hitCheck){
											
						System.out.println("Entered condition, initialGapOfMovement == hitCheck");
						
						directionToCheck = 1;
						rand1 = initialRand1 + 1;
						checkingDirections = 1;
						return 2;
					}
					if(numberOfPositions == 0){
						
						System.out.println("Entered condition, numberOfPositions == 0");
						
						return 1;
					}
					
				}
				
				//CHECKING BOTTOM DIRECTION				
				else if(directionToCheck == 1){
					
					System.out.println("Entered direction 1");
					
					int gapOfMovement = gridSize - rand1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					System.out.println("gapOfMovement: " + gapOfMovement + " hitCheck: " + hitCheck);
					
					while(gapOfMovement > 0){
						
						System.out.println("Entered WHILE in direction 1");
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitB == 3){
									
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
													
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitD == 5){

								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement >= 1){
								
								rand1++;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							System.out.println("Entered condition, coord == 0");
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 2;
							rand1 = initialRand1;
							rand2 = initialRand2 + 1;
							checkingDirections = 1;
							System.out.println("needNewCoordinates: " + needNewCoordinates);
							
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							System.out.println("Entered condition, coord == * #");
							
							directionToCheck = 2;
							rand1 = initialRand1;
							rand2 = initialRand2 + 1;
							checkingDirections = 1;
							
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						System.out.println("Entered condition, initialGapOfMovement == hitCheck");
						
						directionToCheck = 2;
						rand1 = initialRand1;
						rand2 = initialRand2 + 1;
						checkingDirections = 1;
						
						return 2;
					}
					if(numberOfPositions == 0){
						
						System.out.println("Entered condition, numberOfPositions == 0");
						
						return 1;
					}
					
				}
				
				//CHECKING RIGHT DIRECTION
				else if(directionToCheck == 2){
					
					System.out.println("Enetered direction 2");
					
					int gapOfMovement = gridSize - rand2;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					System.out.println("gapOfMovement: " + gapOfMovement + " hitCheck: " + hitCheck);
					
					while(gapOfMovement > 0){
						
						System.out.println("Entered WHILE in direction 2");
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitB == 3){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement >= 1){
								
								rand2++;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							System.out.println("Entered condition, coord == 0");
							
							grid[rand1][rand2] = userMiss;
							directionToCheck = 3;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							System.out.println("Entered condition, coord == * #");
							
							directionToCheck = 3;
							rand2 = initialRand2 - 1;
							checkingDirections = 1;
							
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						System.out.println("Entered condition, initialGapOfMovement == hitCheck");
						
						directionToCheck = 3;
						rand2 = initialRand2 - 1;
						checkingDirections = 1;
						
						return 2;
					}
					if(numberOfPositions == 0){
						
						System.out.println("Entered condition, numberOfPositions == 0");
						
						return 1;
					}
					
				}
				//CHECKING LEFT DIRECTION
				else if(directionToCheck == 3){
					
					System.out.println("Enetered direction 3");
					
					int gapOfMovement = rand2 + 1;
					int initialGapOfMovement = gapOfMovement;
					int hitCheck = 0;
					
					System.out.println("gapOfMovement: " + gapOfMovement + " hitCheck: " + hitCheck);
					
					while(gapOfMovement >= 0){
						
						System.out.println("Entered WHILE in direction 3");
						
						//BLOCK TO IDENTIFY THE SHIP THE USER IS HITTING
						if(grid[rand1][rand2] == 'a'){
							
							grid[rand1][rand2] = userHitSign;
							hitA++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitA == 2){
								
								if(numberOfPositions == 0){
									
									return 1;
									
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'b'){
										
							grid[rand1][rand2] = userHitSign;
							hitB++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitB == 3){
									
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;	
								needNewCoordinates = 1;
								needSectorSelection = 1;
								
								return 2;
							}
						}else if(grid[rand1][rand2] == 'c'){
										
							grid[rand1][rand2] = userHitSign;
							hitC++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitC == 4){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						}else if(grid[rand1][rand2] == 'd'){
										
							grid[rand1][rand2] = userHitSign;
							hitD++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;

							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitD == 5){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
										
							}
						}else if(grid[rand1][rand2] == 'e'){
										
							grid[rand1][rand2] = userHitSign;
							hitE++;
							hitCheck++;
							numberOfPositions--;
							gapOfMovement--;											
							
							if(gapOfMovement >= 1){
								
								rand2--;
								
							}
							
							if(hitE == 6){
								
								if(numberOfPositions == 0){
									
									return 1;
								
								}
								checkingDirections = 0;
								directionToCheck = 0;
								needNewCoordinates = 1;
								needSectorSelection = 1;
								return 2;
											
							}
						
						}else if(grid[rand1][rand2] == '0'){
							
							System.out.println("Entered condition, coord == 0");
							
							grid[rand1][rand2] = userMiss;
							checkingDirections = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 0;
							
						}else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
							
							System.out.println("Entered condition, coord == * #");
							
							checkingDirections = 0;
							needNewCoordinates = 1;
							needSectorSelection = 1;
							return 2;
						}
					}
					if(initialGapOfMovement == hitCheck){
						
						System.out.println("Entered condition, initialGapOfMovement == hitCheck");
						
						checkingDirections = 0;
						needNewCoordinates = 1;
						needSectorSelection = 1;
						
						return 2;
					}
					if(numberOfPositions == 0){
						
						System.out.println("Entered condition, numberOfPositions == 0");
						
						return 1;
					}
					
				}
			}
			
		}
		//-----------------BLOCK THAT CHECKS IF VALUE IN RANDOM COORDINATE IS A ZERO.----------------
		else if(grid[rand1][rand2] == '0'){
			
			grid[rand1][rand2] = userMiss;
			needNewCoordinates = 1;
			needSectorSelection = 1;
			
			return 0;
			
		}
		//------------------BLOCK THAT CHECKS IF VALUE IN RANDOM COORDINATE IS A SYMBOL.--------------------
		else if(grid[rand1][rand2] == '*' || grid[rand1][rand2] == '#'){
			
			needNewCoordinates = 1;
			needSectorSelection = 1;
			
			return 2;
			
		}
		
		return -1;
		
	}
	
	public int checkSectors(int rand1, int rand2, int gridSize){
		
		int gridSize2 = gridSize - 1; 
		
		if(rand2 == 0 && rand1 !=0 && rand1 != gridSize2){
			return 1;
		}else if(rand2 == 0 && rand1 == 0){
			return 2;
		}else if(rand2 == 0 && rand1 == (gridSize2)){
			return 3;
		}else if(rand2 == gridSize2 && rand1 != gridSize2 && rand1 != 0){
			return 4;
		}else if(rand2 == gridSize2 && rand1 == 0){
			return 5;
		}else if(rand2 == gridSize2 && rand1 == gridSize2){
			return 6;
		}else if(rand1 == 0 && rand2 != 0 && rand2 != gridSize2){
			return 7;
		}else if(rand1 == gridSize2 && rand2 != 0 && rand2 != gridSize2){
			return 8;
		}else{
			return 9;
		}
	}
	
	public static void main(String[] args){
		
	}
	
	
}