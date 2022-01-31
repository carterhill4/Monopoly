//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Actions
//	{
//		static int playerLocation = 0;
//		static boolean inJail = false;
//		static int playerMoney = 1500;
//		static boolean stillPlaying = true;
//		static String playerName;
//		static int menuInput;
//		static int statInput;
//		static int inventoryCounter;
//		static int freeParkingMoney;
//		static int timesRolledDoubles = 0;
//		static Scanner userInput = new Scanner(System.in);
//		static ArrayList<BoardSpace> inventory = new ArrayList<BoardSpace>();
//		static int direction = 1;
//		static int doublesTriedCounter = 0;
//			
//	
//		public static void greetPlayer()
//			{
//				System.out.println("What is your name?");
//				playerName = userInput.nextLine();
//				//getName(Player1).setName(playerName);
//				System.out.println("Welcome, " + playerName + "!");
//				System.out.println();	
//				
//				
//				
//			}
//		public static void turnMenu(Player p1)
//			{
//				System.out.println(p1.getName() + ", it's your turn!\nWould you like to...\n1) Roll the dice \n2) View your stats");
//				menuInput = userInput.nextInt();
//				
//				if (menuInput == 1)
//					{
//						movePlayer(p1, p2);
//					} 
//				else if (menuInput == 2)
//						{
//							displayPlayerStats(p1, p2);
//						} 
////				else if(menuInput == 3)
////					{
////						purchaseHouses();
////					}
//				else
//						{
//							System.out.println("That's not an option.");
//							turnMenu(p1, p2);
//						}
//			}
//		public static void reverseMenu(Player p1)
//			{
//				System.out.println(playerName + ", it's your turn!\nWould you like to...\n1) Roll the dice \n2) View your stats");
//				menuInput = userInput.nextInt();
//				
//				if (menuInput == 1)
//					{
//						reverseMovePlayer(p1, p2);
//					} 
//				else if (menuInput == 2)
//						{
//							reverseDisplayPlayerStats(p1, p2);
//						} 
////				else if(menuInput == 3)
////					{
////						purchaseHouses();
////					}
//				else
//						{
//							System.out.println("That's not an option.\nPlease try again.");
//							reverseMenu(p1, p2);
//						}
//			}
//		public static void displayPlayerStats(Player p1)
//			{
//				System.out.println("Your name is: " + playerName);
//				System.out.println("Current balance: $" + playerMoney);
//				
//				
//				for(BoardSpace k : inventory)
//					{
//						System.out.println("You own the " + k.getType() + ": " + k.getName());		
//						System.out.println();
//					}
//				
//				turnMenu(p1);
//			
//			}
//		public static void reverseDisplayPlayerStats(Player p1)
//			{
//				System.out.println("Your name is: " + playerName);
//				System.out.println("Current balance: $" + playerMoney);
//				
//				
//				for(BoardSpace k : inventory)
//					{
//						System.out.print("You own the " + k.getType() + " " + k.getName() );		
//						System.out.println();
//					}
//				
//				reverseMenu(p1, p2);
//				System.out.println();
//			}
//		public static void movePlayer(Player p1)
//			{
//			int playerRoll = DiceRoller.diceRoll();
//				
//				if ((playerLocation + playerRoll) < 39)
//					{
//						playerLocation += playerRoll;
//					}
//				else
//					{
//						playerLocation += playerRoll;
//								playerLocation -= 40;
//								playerMoney += 200;
//								System.out.println("You passsed GO and collected $200");
//								System.out.println();
//					}
//					
//				
//					
//
//				System.out.println("Your total is: " + playerRoll + ".\nYou landed on " + MonopDriver.board[playerLocation].getName() 
//				+ ", the " + playerLocation + " spot on the board.");
//				landOnSquare(p1, p2);
//
//				if (DiceRoller.doubles == true)
//					{
//
//						if (timesRolledDoubles == 3)
//							{
//								goToJail(p1, p2);
//								
//							} 
//						else
//							{
//								System.out.println("You rolled doubles, roll again!");
//								movePlayer(p1, p2);
//							}
//					} 
//				else
//					{
//						
//					}
//		}
//		public static void reverseMovePlayer(Player p1)
//			{
//				int playerRoll = DiceRoller.reverseRoll();
//				
//				if ((playerLocation + playerRoll) < 0)
//					{
//						playerLocation += playerRoll;
//						playerLocation += 40;
//						playerMoney += 200;
//						System.out.println("You passsed GO and collected $200");
//						System.out.println();
//					}
//				else
//					{
//						playerLocation += playerRoll;	
//					}
//					
//
//				System.out.println("Your total is: " + playerRoll + ".\nYou landed on " + MonopDriver.board[playerLocation].getName() 
//				+ ", the " + playerLocation + " spot on the board.");
//				reverseLandOnSquare(p1, p2);
//
//				if (DiceRoller.doubles == true)
//					{
//
//						if (timesRolledDoubles == 3)
//							{
//								goToJail(p1, p2);
//							} 
//						else
//							{
//								System.out.println("You rolled doubles, roll again!");
//								reverseMovePlayer(p1, p2);
//							}
//					} 
//				else
//					{
//						
//					}
//						
//			} 
//		public static void checkForBankruptcy(Player p1)
//			{
//				
//				if(playerMoney <= 0)
//					{
//						System.out.println("You've gone bankrupt! You lose!");
//						System.exit(0);
//						//stillPlaying = false;
//						
//					}
//			}
//		public static void testJail(Player p1)
//{
//	playerLocation = 29;
//	int playerRoll = DiceRoller.oneRoll();
//	playerLocation += playerRoll;
//	System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou are on " + 
//	MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");
//	
//	inJail = true;
//	inJailTurn(p1, p2);
//}
//		public static void goToJail(Player p1)
//			{
//				playerLocation = 10;
//				inJail = true;
//				inJailTurn(p1, p2);
//			}
//		public static void reverseGoToJail(Player p1)
//			{
//				playerLocation = 10;
//				System.out.println("You are now in jail");
//				inJail = true;
//				reverseJailTurn(p1, p2);
//			}
//		public static void landOnSquare(Player p1)
//			{
//				if (MonopDriver.board[playerLocation].getType().equals("Property"))
//					{
//						if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//							{
//								System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
//								menuInput = userInput.nextInt();
//
//								if (menuInput == 1)
//									{
//										MonopDriver.board[playerLocation].setOwner(playerName);
//										playerMoney -= MonopDriver.board[playerLocation].getCost();
//										checkForBankruptcy(p1, p2);
//										inventory.add(MonopDriver.board[playerLocation]);
//										System.out.println();
//										System.out.println("You now own " + MonopDriver.board[playerLocation].getName());
//										System.out.println();
//										turnMenu(p1, p2);
//									}
//								else
//									{
//										turnMenu(p1, p2);
//									}
//								// need to implement the 'developing' feature (where you can only buy houses if
//								// you own all of that color)
//							} 
//						else if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//								{
//									System.out.println("You already own this property.");
//								}
//								 
//							else
//								{
////									System.out.println("This property is already owned by" + MonopDriver.board[playerLocation].getOwner() + ", you now must pay rent.");
////									if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 0)
////										{
////											playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getBasicRent();
////										} 
////									else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1)
////											{
////												playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getOneHouseRent();
////											} 
////										else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2)
////												{
////													playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getTwoHouseRent();
////												} 
////											else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3)
////													{
////														playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getThreeHouseRent();
////													} 
////												else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4)
////														{
////															playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getHotelRent();
////														}
//									checkForBankruptcy(p1, p2);
//								}
//					} 
//				
//				
//				
//				
//				
//				
//				else if (MonopDriver.board[playerLocation].getType().equals("Utility"))
//						{
//							if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//								{
//									System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
//									menuInput = userInput.nextInt();
//
//									if (menuInput == 1)
//										{
//											MonopDriver.board[playerLocation].setOwner(playerName);
//											playerMoney -= MonopDriver.board[playerLocation].getCost();
//											checkForBankruptcy(p1, p2);
//											inventory.add(MonopDriver.board[playerLocation]);
//											turnMenu(p1, p2);
//										}
//									else 
//										{
//											turnMenu(p1, p2);
//										}
//								} 
//							else
//								if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//									{
//										System.out.println("You already own this utility");
//									} 
//								else
//									{
//										System.out.println("This utility is already owned by "
//												+ MonopDriver.board[playerLocation].getOwner()
//												+ ", you now must pay for the service.");
//										// need to figure out how to search the array for everything that has one
//										// specific field
//									}
//						} 
//					
//					
//				
//				else if (MonopDriver.board[playerLocation].getType().equals("Railroad"))
//							{
//								if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//									{
//										System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
//										menuInput = userInput.nextInt();
//
//										if (menuInput == 1)
//											{
//												MonopDriver.board[playerLocation].setOwner(playerName);
//												playerMoney -= MonopDriver.board[playerLocation].getCost();
//												checkForBankruptcy(p1, p2);
//												inventory.add(MonopDriver.board[playerLocation]);
//												turnMenu(p1, p2);
//											}
//										else 
//											{
//												turnMenu(p1, p2);
//											}
//									} 
//								else
//									if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//										{
//											System.out.println("You already own this railroad");
//										} 
//									else
//										{
//											// once again need to figure the comment from above out
//
//											/*
//											 * System.out.println("This property is already owned by" +
//											 * MonopDriver.board[playerLocation].getOwner() +
//											 * ", you now must pay rent."); if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getOneOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getTwoOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getThreeOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getFourOwnedRent(); }
//											 */
//
//											checkForBankruptcy(p1, p2);
//										}
//							} 
//						
//					
//					else
//							{
//								if (MonopDriver.board[playerLocation].getName().equals("GO"))
//									{
//										playerMoney += MonopDriver.board[playerLocation].getCost();
//										System.out.println(
//												"You collected $" + MonopDriver.board[playerLocation].getCost());
//									} 
//								else if (MonopDriver.board[playerLocation].getName().equals("Go_To_Jail"))
//										{
//											goToJail(p1, p2);
//										} 
//								else if (MonopDriver.board[playerLocation].getName().equals("Jail") && inJail == false)
//									{
//										System.out.println("You are just visiting jail.");
//										turnMenu(p1, p2);
//									}
//								else if (MonopDriver.board[playerLocation].getName().equals("Free_Parking"))
//									{
//										System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou landed on " + 
//												MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");
//
//												System.out.println("You won " + freeParkingMoney + "!");
//												playerMoney += freeParkingMoney;
//												freeParkingMoney = 100;
//												
//												System.out.println();
//												System.out.println("You are now moving counter clockwise!");
//												reverseMovePlayer(p1, p2);
//									} 
//										else if (MonopDriver.board[playerLocation].getName().equals("Income_Tax") || MonopDriver.board[playerLocation].getName().equals("Luxury_Tax"))
//												{
//													System.out.println("You have been taxed $" + MonopDriver.board[playerLocation].getCost());
//													freeParkingMoney += MonopDriver.board[playerLocation].getCost();
//													playerMoney -= MonopDriver.board[playerLocation].getCost();
//													checkForBankruptcy(p1, p2);
//													turnMenu(p1, p2);
//												}
//
//								
//											// chance cards
//											else if (MonopDriver.board[playerLocation].getName().equals("Chance"))
//													{
//														int chanceNumber = (int) (Math.random() * 3) + 1;
//														if (chanceNumber == 1)
//															{
//																System.out.println("You're wife left you. Give 50% of your money to her.");
//																System.out.println();
//																playerMoney = playerMoney / 2;
//																turnMenu(p1, p2);
//															}
//
//														else
//															if (chanceNumber == 2)
//																{
//																	System.out.println("You got your secretary pregnant. Pay $50.");
//																	System.out.println();
//																	playerMoney = playerMoney - 50;
//																	checkForBankruptcy(p1, p2);
//																	turnMenu(p1, p2);
//																} 
//															else
//																{
//																	System.out.println("You found $100 on the street.");
//																	System.out.println();
//																	playerMoney = playerMoney + 100;
//																	turnMenu(p1, p2);
//																}
//													}
//												
//												
//												// community chest
//												else if(MonopDriver.board[playerLocation].getName().equals("Community_Chest"))
//														{
//															int chestNumber = (int) (Math.random() * 3) + 1;
//															if (chestNumber == 1)
//																{
//																	System.out.println("Your dog needs a surgery. Pay the vet $100.");
//																	System.out.println();
//																	playerMoney -= 100;
//																	checkForBankruptcy(p1, p2);
//																	turnMenu(p1, p2);
//																}
//
//															else if (chestNumber == 2)
//																	{
//																		System.out.println("You have turned to a life of crime. You mugged a teenage girl for $35.");
//																		System.out.println();
//																		playerMoney += 35;
//																		turnMenu(p1, p2);
//																	} 
//																else
//																	{
//																		System.out.println("You bought the Fortnite battle pass for $10.");
//																		System.out.println();
//																		playerMoney -= 10;
//																		checkForBankruptcy(p1, p2);
//																		turnMenu(p1, p2);
//																	}
//														}
//							}
//			}
//		public static void reverseLandOnSquare(Player p1)
//			{
//				if (MonopDriver.board[playerLocation].getType().equals("Property"))
//					{
//						if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//							{
//								System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
//								menuInput = userInput.nextInt();
//
//								if (menuInput == 1)
//									{
//										MonopDriver.board[playerLocation].setOwner(playerName);
//										playerMoney -= MonopDriver.board[playerLocation].getCost();
//										checkForBankruptcy(p1, p2);
//										inventory.add(MonopDriver.board[playerLocation]);
//										System.out.println();
//										System.out.println("You now own " + MonopDriver.board[playerLocation].getName());
//										System.out.println();
//										reverseMenu(p1, p2);
//									}
//								else
//									{
//										reverseMenu(p1, p2);
//									}
//								// need to implement the 'developing' feature (where you can only buy houses if
//								// you own all of that color)
//							} 
//						else if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//								{
//									System.out.println("You already own this property.");		
//								} 
//							else
//								{
////									System.out.println("This property is already owned by" + MonopDriver.board[playerLocation].getOwner() + ", you now must pay rent.");
////									if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 0)
////										{
////											playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getBasicRent();
////										} 
////									else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1)
////											{
////												playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getOneHouseRent();
////											} 
////										else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2)
////												{
////													playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getTwoHouseRent();
////												} 
////											else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3)
////													{
////														playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getThreeHouseRent();
////													} 
////												else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4)
////														{
////															playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getHotelRent();
////														}
//									checkForBankruptcy(p1, p2);
//								}
//					} 
//				
//				
//				
//				
//				
//				
//				else if (MonopDriver.board[playerLocation].getType().equals("Utility"))
//						{
//							if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//								{
//									System.out.println("This utility is not owned, would you like to buy it?\n1) Yes\n2) No");
//									menuInput = userInput.nextInt();
//
//									if (menuInput == 1)
//										{
//											MonopDriver.board[playerLocation].setOwner(playerName);
//											playerMoney -= MonopDriver.board[playerLocation].getCost();
//											checkForBankruptcy(p1, p2);
//											inventory.add(MonopDriver.board[playerLocation]);
//											reverseMenu(p1, p2);
//										}
//								} 
//							else
//								if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//									{
//										System.out.println("You already own this utility");
//									} 
//								else
//									{
//										System.out.println("This utility is already owned by "
//												+ MonopDriver.board[playerLocation].getOwner()
//												+ ", you now must pay for the service.");
//										// need to figure out how to search the array for everything that has one
//										// specific field
//									}
//						} 
//					
//					
//				
//				else if (MonopDriver.board[playerLocation].getType().equals("Railroad"))
//							{
//								if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//									{
//										System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
//										menuInput = userInput.nextInt();
//
//										if (menuInput == 1)
//											{
//												MonopDriver.board[playerLocation].setOwner(playerName);
//												playerMoney -= MonopDriver.board[playerLocation].getCost();
//												checkForBankruptcy(p1, p2);
//												inventory.add(MonopDriver.board[playerLocation]);
//												reverseMenu(p1, p2);
//											}
//									} 
//								else
//									if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//										{
//											System.out.println("You already own this railroad");
//											reverseMenu(p1, p2);
//										} 
//									else
//										{
//											// once again need to figure the comment from above out
//
//											/*
//											 * System.out.println("This property is already owned by" +
//											 * MonopDriver.board[playerLocation].getOwner() +
//											 * ", you now must pay rent."); if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getOneOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getTwoOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getThreeOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getFourOwnedRent(); }
//											 */
//
//											checkForBankruptcy(p1, p2);
//										}
//							} 
//						
//					
//					else
//							{
//								if (MonopDriver.board[playerLocation].getName().equals("GO"))
//									{
//										playerMoney += MonopDriver.board[playerLocation].getCost();
//										System.out.println(
//												"You collected $" + MonopDriver.board[playerLocation].getCost());
//									} 
//								else if (MonopDriver.board[playerLocation].getName().equals("Go_To_Jail"))
//										{
//											reverseGoToJail(p1, p2);
//										} 
//								//comment
//								else if (MonopDriver.board[playerLocation].getName().equals("Jail") && inJail == false)
//									{
//										System.out.println("You are just visiting jail.");
//										turnMenu(p1, p2);
//									}
//								
//									else if (MonopDriver.board[playerLocation].getName().equals("Free_Parking"))
//											{
//												System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou landed on " + 
//														MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");
//
//														System.out.println("You won " + freeParkingMoney + "!");
//														playerMoney += freeParkingMoney;
//														freeParkingMoney = 100;
//														
//														System.out.println();
//														System.out.println("You are now moving clockwise again!");
//														movePlayer(p1, p2);
//											} 
//										else if (MonopDriver.board[playerLocation].getName().equals("Income_Tax") || MonopDriver.board[playerLocation].getName().equals("Luxury_Tax"))
//												{
//													System.out.println("You have been taxed $" + MonopDriver.board[playerLocation].getCost());
//													freeParkingMoney += MonopDriver.board[playerLocation].getCost();
//													playerMoney -= MonopDriver.board[playerLocation].getCost();
//													checkForBankruptcy(p1, p2);
//													reverseMenu(p1, p2);
//												}
//
//								
//											// chance cards
//											else if (MonopDriver.board[playerLocation].getName().equals("Chance"))
//													{
//														int chanceNumber = (int) (Math.random() * 3) + 1;
//														if (chanceNumber == 1)
//															{
//																System.out.println("You're wife left you. Give 50% of your money to her.");
//																playerMoney = playerMoney / 2;
//																reverseMenu(p1, p2);
//															}
//
//														else
//															if (chanceNumber == 2)
//																{
//																	System.out.println("You got your secretary pregnant. Pay $50.");
//																	playerMoney = playerMoney - 50;
//																	checkForBankruptcy(p1, p2);
//																	reverseMenu(p1, p2);
//																} 
//															else
//																{
//																	System.out.println("You found $100 on the street.");
//																	playerMoney = playerMoney + 100;
//																	reverseMenu(p1, p2);
//																}
//													}
//												
//												
//												// community chest
//												else
//													if (MonopDriver.board[playerLocation].getName().equals("Community_Chest"))
//														{
//															int chestNumber = (int) (Math.random() * 3) + 1;
//															if (chestNumber == 1)
//																{
//																	System.out.println("Your dog needs a surgery. Pay the vet $100.");
//																	playerMoney -= 100;
//																	checkForBankruptcy(p1, p2);
//																	reverseMenu(p1, p2);
//																}
//
//															else if (chestNumber == 2)
//																	{
//																		System.out.println("You have turned to a life of crime. You mugged a teenage girl for $35.");
//																		playerMoney += 35;
//																		reverseMenu(p1, p2);
//																	} 
//																else
//																	{
//																		System.out.println("You bought the Fortnite battle pass ofr $10.");
//																		playerMoney -= 10;
//																		checkForBankruptcy(p1, p2);
//																		reverseMenu(p1, p2);
//																	}
//														}
//							}
//			}
//		public static void inJailTurn(Player p1)
//			{
//				// need to implement cards soon
//				System.out.println("You are in jail\nWould you like to...\n1) Pay the $50 fee\n2) Roll for doubles");
//				menuInput = userInput.nextInt();
//
//				if (menuInput == 1)
//					{
//						freeParkingMoney += 50;
//						playerMoney -= 50;
//						System.out.println("You have now payed the fee and are free to go.");
//						inJail = false;
//						turnMenu(p1, p2);
//					} 
//				else
//					{
//						
//						DiceRoller.diceRoll();
//						if (DiceRoller.doubles == true)
//							{
//								
//								System.out.println("You rolled doubles and are free to go.");
//								inJail = false;
//								turnMenu(p1, p2);
//							} else
//							{
//								doublesTriedCounter++;
//								System.out.println("You failed to roll doubles " + doublesTriedCounter + " times.");
//								inJailTurn(p1, p2);
//							}
//					}
//			}
//		public static void reverseJailTurn(Player p1)
//			{
//				// need to implement cards soon
//				System.out.println("You are in jail\nWould you like to...\n1) Pay the $50 fee\n2) Roll for doubles");
//				menuInput = userInput.nextInt();
//
//				if (menuInput == 1)
//					{
//						freeParkingMoney += 50;
//						playerMoney -= 50;
//						System.out.println("You have now payed the fee and are free to go.");
//						inJail = false;
//						reverseMenu(p1, p2);
//					} 
//				
//				else
//					{
//						DiceRoller.diceRoll();
//						if (DiceRoller.doubles == true)
//							{
//								
//								System.out.println("You rolled doubles and are free to go.");
//								inJail = false;
//								reverseMenu(p1, p2);
//							} else
//							{
//								doublesTriedCounter++;
//								System.out.println("You failed to roll doubles " + doublesTriedCounter + " times.");
//								reverseJailTurn(p1, p2);
//							}
//					}
//			}
//		public static void testFreeParking(Player p1)
//		{
//			playerLocation = 19;
//			
//			int playerRoll = DiceRoller.oneRoll();
//			
//			playerLocation += playerRoll;
//			System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou landed on " + 
//			MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");
//
//			System.out.println("You won " + freeParkingMoney + "!");
//			playerMoney += freeParkingMoney;
//			freeParkingMoney = 100;
//			
//			System.out.println();
//			System.out.println("You are now moving counter clockwise!");
//			reverseMovePlayer(p1);
//		}
//		
//		public static void turnMenu2(Player p2)
//			{
//				System.out.println(p2.getName() + ", it's your turn!\nWould you like to...\n1) Roll the dice \n2) View your stats");
//				menuInput = userInput.nextInt();
//				
//				if (menuInput == 1)
//					{
//						movePlayer2(p2);
//					} 
//				else if (menuInput == 2)
//						{
//							displayPlayerStats2(p2);
//						} 
////				else if(menuInput == 3)
////					{
////						purchaseHouses();
////					}
//				else
//						{
//							System.out.println("That's not an option.");
//							turnMenu2(p2);
//						}
//			}
//		public static void reverseMenu2(Player p2)
//			{
//				System.out.println(p2.getName() + ", it's your turn!\nWould you like to...\n1) Roll the dice \n2) View your stats");
//				menuInput = userInput.nextInt();
//				
//				if (menuInput == 1)
//					{
//						reverseMovePlayer2(p2);
//					} 
//				else if (menuInput == 2)
//						{
//							reverseDisplayPlayerStats2(p2);
//						} 
////				else if(menuInput == 3)
////					{
////						purchaseHouses();
////					}
//				else
//						{
//							System.out.println("That's not an option.\nPlease try again.");
//							reverseMenu2(p2);
//						}
//			}
//		public static void displayPlayerStats2(Player p2)
//			{
//				System.out.println("Your name is: " + p2.getName());
//				System.out.println("Current balance: $" + p2.getMoney());
//				
//				
//				for(BoardSpace k : p2.getInventory())
//					{
//						System.out.println("You own the " + k.getType() + ": " + k.getName());		
//						System.out.println();
//					}
//				
//				turnMenu(p2);
//			
//			}
//		public static void reverseDisplayPlayerStats2(Player p2)
//			{
//				System.out.println("Your name is: " + p2.getName());
//				System.out.println("Current balance: $" + p2.getMoney());
//				
//				
//				for(BoardSpace k : p2.getInventory())
//					{
//						System.out.print("You own the " + k.getType() + " " + k.getName() );		
//						System.out.println();
//					}
//				
//				reverseMenu2(p2);
//				System.out.println();
//			}
//		public static void movePlayer2(Player p2)
//			{
//				int playerLocation;
//			int playerRoll = DiceRoller.diceRoll();
//			p2.getLocation() = playerLocation;
//				if ((p2.getLocation() + playerRoll) < 39)
//					{
//						p2.getLocation() += playerRoll;
//					}
//				else
//					{
//						p2.getLocation() += playerRoll;
//						p2.getLocation() -= 40;
//								playerMoney += 200;
//								System.out.println("You passsed GO and collected $200");
//								System.out.println();
//					}
//					
//				
//					
//
//				System.out.println("Your total is: " + playerRoll + ".\nYou landed on " + MonopDriver.board[playerLocation].getName() 
//				+ ", the " + p2.getLocation() + " spot on the board.");
//				landOnSquare2(p2);
//
//				if (DiceRoller.doubles == true)
//					{
//
//						if (timesRolledDoubles == 3)
//							{
//								goToJail2(p2);
//								
//							} 
//						else
//							{
//								System.out.println("You rolled doubles, roll again!");
//								movePlayer2(p2);
//							}
//					} 
//				else
//					{
//						
//					}
//		}
//		public static void reverseMovePlayer2(Player p2)
//			{
//				int playerRoll = DiceRoller.reverseRoll();
//				
//				if ((p2.getLocation() + playerRoll) < 0)
//					{
//						playerLocation += playerRoll;
//						playerLocation += 40;
//						playerMoney += 200;
//						System.out.println("You passsed GO and collected $200");
//						System.out.println();
//					}
//				else
//					{
//						playerLocation += playerRoll;	
//					}
//					
//
//				System.out.println("Your total is: " + playerRoll + ".\nYou landed on " + MonopDriver.board[playerLocation].getName() 
//				+ ", the " + playerLocation + " spot on the board.");
//				reverseLandOnSquare(p2);
//
//				if (DiceRoller.doubles == true)
//					{
//
//						if (timesRolledDoubles == 3)
//							{
//								goToJail2(p2);
//							} 
//						else
//							{
//								System.out.println("You rolled doubles, roll again!");
//								reverseMovePlayer2(p2);
//							}
//					} 
//				else
//					{
//						
//					}
//						
//			} 
//		public static void checkForBankruptcy2(Player p2)
//			{
//				
//				if(playerMoney <= 0)
//					{
//						System.out.println("You've gone bankrupt! You lose!");
//						System.exit(0);
//						//stillPlaying = false;
//						
//					}
//			}
//		public static void testJail2(Player p2)
//{
//	playerLocation = 29;
//	int playerRoll = DiceRoller.oneRoll();
//	playerLocation += playerRoll;
//	System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou are on " + 
//	MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");
//	
//	inJail = true;
//	inJailTurn(p2);
//}
//		public static void goToJail2(Player p2)
//			{
//				playerLocation = 10;
//				inJail = true;
//				inJailTurn(p2);
//			}
//		public static void reverseGoToJail2(Player p2)
//			{
//				playerLocation = 10;
//				System.out.println("You are now in jail");
//				inJail = true;
//				reverseJailTurn(p2);
//			}
//		public static void landOnSquare2(Player p2)
//			{
//				if (MonopDriver.board[playerLocation].getType().equals("Property"))
//					{
//						if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//							{
//								System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
//								menuInput = userInput.nextInt();
//
//								if (menuInput == 1)
//									{
//										MonopDriver.board[playerLocation].setOwner(playerName);
//										playerMoney -= MonopDriver.board[playerLocation].getCost();
//										checkForBankruptcy(p1, p2);
//										inventory.add(MonopDriver.board[playerLocation]);
//										System.out.println();
//										System.out.println("You now own " + MonopDriver.board[playerLocation].getName());
//										System.out.println();
//										turnMenu(p2);
//									}
//								else
//									{
//										turnMenu(p2);
//									}
//								// need to implement the 'developing' feature (where you can only buy houses if
//								// you own all of that color)
//							} 
//						else if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//								{
//									System.out.println("You already own this property.");
//								}
//								 
//							else
//								{
////									System.out.println("This property is already owned by" + MonopDriver.board[playerLocation].getOwner() + ", you now must pay rent.");
////									if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 0)
////										{
////											playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getBasicRent();
////										} 
////									else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1)
////											{
////												playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getOneHouseRent();
////											} 
////										else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2)
////												{
////													playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getTwoHouseRent();
////												} 
////											else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3)
////													{
////														playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getThreeHouseRent();
////													} 
////												else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4)
////														{
////															playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getHotelRent();
////														}
//									checkForBankruptcy(p2);
//								}
//					} 
//				
//				
//				
//				
//				
//				
//				else if (MonopDriver.board[playerLocation].getType().equals("Utility"))
//						{
//							if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//								{
//									System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
//									menuInput = userInput.nextInt();
//
//									if (menuInput == 1)
//										{
//											MonopDriver.board[playerLocation].setOwner(playerName);
//											playerMoney -= MonopDriver.board[playerLocation].getCost();
//											checkForBankruptcy(p2);
//											inventory.add(MonopDriver.board[playerLocation]);
//											turnMenu(p2);
//										}
//									else 
//										{
//											turnMenu(p2);
//										}
//								} 
//							else
//								if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//									{
//										System.out.println("You already own this utility");
//									} 
//								else
//									{
//										System.out.println("This utility is already owned by "
//												+ MonopDriver.board[playerLocation].getOwner()
//												+ ", you now must pay for the service.");
//										// need to figure out how to search the array for everything that has one
//										// specific field
//									}
//						} 
//					
//					
//				
//				else if (MonopDriver.board[playerLocation].getType().equals("Railroad"))
//							{
//								if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//									{
//										System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
//										menuInput = userInput.nextInt();
//
//										if (menuInput == 1)
//											{
//												MonopDriver.board[playerLocation].setOwner(playerName);
//												playerMoney -= MonopDriver.board[playerLocation].getCost();
//												checkForBankruptcy(p1, p2);
//												inventory.add(MonopDriver.board[playerLocation]);
//												turnMenu(p2);
//											}
//										else 
//											{
//												turnMenu(p2);
//											}
//									} 
//								else
//									if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//										{
//											System.out.println("You already own this railroad");
//										} 
//									else
//										{
//											// once again need to figure the comment from above out
//
//											/*
//											 * System.out.println("This property is already owned by" +
//											 * MonopDriver.board[playerLocation].getOwner() +
//											 * ", you now must pay rent."); if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getOneOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getTwoOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getThreeOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getFourOwnedRent(); }
//											 */
//
//											checkForBankruptcy(p2);
//										}
//							} 
//						
//					
//					else
//							{
//								if (MonopDriver.board[playerLocation].getName().equals("GO"))
//									{
//										playerMoney += MonopDriver.board[playerLocation].getCost();
//										System.out.println(
//												"You collected $" + MonopDriver.board[playerLocation].getCost());
//									} 
//								else if (MonopDriver.board[playerLocation].getName().equals("Go_To_Jail"))
//										{
//											goToJail(p2);
//										} 
//								else if (MonopDriver.board[playerLocation].getName().equals("Jail") && inJail == false)
//									{
//										System.out.println("You are just visiting jail.");
//										turnMenu(p2);
//									}
//								else if (MonopDriver.board[playerLocation].getName().equals("Free_Parking"))
//									{
//										System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou landed on " + 
//												MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");
//
//												System.out.println("You won " + freeParkingMoney + "!");
//												playerMoney += freeParkingMoney;
//												freeParkingMoney = 100;
//												
//												System.out.println();
//												System.out.println("You are now moving counter clockwise!");
//												reverseMovePlayer(p2);
//									} 
//										else if (MonopDriver.board[playerLocation].getName().equals("Income_Tax") || MonopDriver.board[playerLocation].getName().equals("Luxury_Tax"))
//												{
//													System.out.println("You have been taxed $" + MonopDriver.board[playerLocation].getCost());
//													freeParkingMoney += MonopDriver.board[playerLocation].getCost();
//													playerMoney -= MonopDriver.board[playerLocation].getCost();
//													checkForBankruptcy(p2);
//													turnMenu(p2);
//												}
//
//								
//											// chance cards
//											else if (MonopDriver.board[playerLocation].getName().equals("Chance"))
//													{
//														int chanceNumber = (int) (Math.random() * 3) + 1;
//														if (chanceNumber == 1)
//															{
//																System.out.println("You're wife left you. Give 50% of your money to her.");
//																System.out.println();
//																playerMoney = playerMoney / 2;
//																turnMenu(p2);
//															}
//
//														else
//															if (chanceNumber == 2)
//																{
//																	System.out.println("You got your secretary pregnant. Pay $50.");
//																	System.out.println();
//																	playerMoney = playerMoney - 50;
//																	checkForBankruptcy(p2);
//																	turnMenu(p2);
//																} 
//															else
//																{
//																	System.out.println("You found $100 on the street.");
//																	System.out.println();
//																	playerMoney = playerMoney + 100;
//																	turnMenu(p2);
//																}
//													}
//												
//												
//												// community chest
//												else if(MonopDriver.board[playerLocation].getName().equals("Community_Chest"))
//														{
//															int chestNumber = (int) (Math.random() * 3) + 1;
//															if (chestNumber == 1)
//																{
//																	System.out.println("Your dog needs a surgery. Pay the vet $100.");
//																	System.out.println();
//																	playerMoney -= 100;
//																	checkForBankruptcy(p2);
//																	turnMenu(p2);
//																}
//
//															else if (chestNumber == 2)
//																	{
//																		System.out.println("You have turned to a life of crime. You mugged a teenage girl for $35.");
//																		System.out.println();
//																		playerMoney += 35;
//																		turnMenu(p2);
//																	} 
//																else
//																	{
//																		System.out.println("You bought the Fortnite battle pass for $10.");
//																		System.out.println();
//																		playerMoney -= 10;
//																		checkForBankruptcy(p2);
//																		turnMenu(p2);
//																	}
//														}
//							}
//			}
//		public static void reverseLandOnSquare2(Player p2)
//			{
//				if (MonopDriver.board[playerLocation].getType().equals("Property"))
//					{
//						if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//							{
//								System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
//								menuInput = userInput.nextInt();
//
//								if (menuInput == 1)
//									{
//										MonopDriver.board[playerLocation].setOwner(playerName);
//										playerMoney -= MonopDriver.board[playerLocation].getCost();
//										checkForBankruptcy(p1, p2);
//										inventory.add(MonopDriver.board[playerLocation]);
//										System.out.println();
//										System.out.println("You now own " + MonopDriver.board[playerLocation].getName());
//										System.out.println();
//										reverseMenu(p1, p2);
//									}
//								else
//									{
//										reverseMenu(p1, p2);
//									}
//								// need to implement the 'developing' feature (where you can only buy houses if
//								// you own all of that color)
//							} 
//						else if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//								{
//									System.out.println("You already own this property.");		
//								} 
//							else
//								{
////									System.out.println("This property is already owned by" + MonopDriver.board[playerLocation].getOwner() + ", you now must pay rent.");
////									if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 0)
////										{
////											playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getBasicRent();
////										} 
////									else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1)
////											{
////												playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getOneHouseRent();
////											} 
////										else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2)
////												{
////													playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getTwoHouseRent();
////												} 
////											else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3)
////													{
////														playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getThreeHouseRent();
////													} 
////												else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4)
////														{
////															playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getHotelRent();
////														}
//									checkForBankruptcy(p1, p2);
//								}
//					} 
//				
//				
//				
//				
//				
//				
//				else if (MonopDriver.board[playerLocation].getType().equals("Utility"))
//						{
//							if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//								{
//									System.out.println("This utility is not owned, would you like to buy it?\n1) Yes\n2) No");
//									menuInput = userInput.nextInt();
//
//									if (menuInput == 1)
//										{
//											MonopDriver.board[playerLocation].setOwner(playerName);
//											playerMoney -= MonopDriver.board[playerLocation].getCost();
//											checkForBankruptcy(p1, p2);
//											inventory.add(MonopDriver.board[playerLocation]);
//											reverseMenu(p1, p2);
//										}
//								} 
//							else
//								if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//									{
//										System.out.println("You already own this utility");
//									} 
//								else
//									{
//										System.out.println("This utility is already owned by "
//												+ MonopDriver.board[playerLocation].getOwner()
//												+ ", you now must pay for the service.");
//										// need to figure out how to search the array for everything that has one
//										// specific field
//									}
//						} 
//					
//					
//				
//				else if (MonopDriver.board[playerLocation].getType().equals("Railroad"))
//							{
//								if (MonopDriver.board[playerLocation].getOwner().equals("none"))
//									{
//										System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
//										menuInput = userInput.nextInt();
//
//										if (menuInput == 1)
//											{
//												MonopDriver.board[playerLocation].setOwner(playerName);
//												playerMoney -= MonopDriver.board[playerLocation].getCost();
//												checkForBankruptcy(p1, p2);
//												inventory.add(MonopDriver.board[playerLocation]);
//												reverseMenu(p1, p2);
//											}
//									} 
//								else
//									if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
//										{
//											System.out.println("You already own this railroad");
//											reverseMenu(p1, p2);
//										} 
//									else
//										{
//											// once again need to figure the comment from above out
//
//											/*
//											 * System.out.println("This property is already owned by" +
//											 * MonopDriver.board[playerLocation].getOwner() +
//											 * ", you now must pay rent."); if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getOneOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getTwoOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getThreeOwnedRent(); } else
//											 * if(((Railroads)
//											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4) {
//											 * playerMoney -= ((Railroads)
//											 * MonopDriver.board[playerLocation]).getFourOwnedRent(); }
//											 */
//
//											checkForBankruptcy(p1, p2);
//										}
//							} 
//						
//					
//					else
//							{
//								if (MonopDriver.board[playerLocation].getName().equals("GO"))
//									{
//										playerMoney += MonopDriver.board[playerLocation].getCost();
//										System.out.println(
//												"You collected $" + MonopDriver.board[playerLocation].getCost());
//									} 
//								else if (MonopDriver.board[playerLocation].getName().equals("Go_To_Jail"))
//										{
//											reverseGoToJail(p1, p2);
//										} 
//								//comment
//								else if (MonopDriver.board[playerLocation].getName().equals("Jail") && inJail == false)
//									{
//										System.out.println("You are just visiting jail.");
//										turnMenu(p1, p2);
//									}
//								
//									else if (MonopDriver.board[playerLocation].getName().equals("Free_Parking"))
//											{
//												System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou landed on " + 
//														MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");
//
//														System.out.println("You won " + freeParkingMoney + "!");
//														playerMoney += freeParkingMoney;
//														freeParkingMoney = 100;
//														
//														System.out.println();
//														System.out.println("You are now moving clockwise again!");
//														movePlayer(p1, p2);
//											} 
//										else if (MonopDriver.board[playerLocation].getName().equals("Income_Tax") || MonopDriver.board[playerLocation].getName().equals("Luxury_Tax"))
//												{
//													System.out.println("You have been taxed $" + MonopDriver.board[playerLocation].getCost());
//													freeParkingMoney += MonopDriver.board[playerLocation].getCost();
//													playerMoney -= MonopDriver.board[playerLocation].getCost();
//													checkForBankruptcy(p1, p2);
//													reverseMenu(p1, p2);
//												}
//
//								
//											// chance cards
//											else if (MonopDriver.board[playerLocation].getName().equals("Chance"))
//													{
//														int chanceNumber = (int) (Math.random() * 3) + 1;
//														if (chanceNumber == 1)
//															{
//																System.out.println("You're wife left you. Give 50% of your money to her.");
//																playerMoney = playerMoney / 2;
//																reverseMenu(p1, p2);
//															}
//
//														else
//															if (chanceNumber == 2)
//																{
//																	System.out.println("You got your secretary pregnant. Pay $50.");
//																	playerMoney = playerMoney - 50;
//																	checkForBankruptcy(p1, p2);
//																	reverseMenu(p1, p2);
//																} 
//															else
//																{
//																	System.out.println("You found $100 on the street.");
//																	playerMoney = playerMoney + 100;
//																	reverseMenu(p1, p2);
//																}
//													}
//												
//												
//												// community chest
//												else
//													if (MonopDriver.board[playerLocation].getName().equals("Community_Chest"))
//														{
//															int chestNumber = (int) (Math.random() * 3) + 1;
//															if (chestNumber == 1)
//																{
//																	System.out.println("Your dog needs a surgery. Pay the vet $100.");
//																	playerMoney -= 100;
//																	checkForBankruptcy(p1, p2);
//																	reverseMenu(p1, p2);
//																}
//
//															else if (chestNumber == 2)
//																	{
//																		System.out.println("You have turned to a life of crime. You mugged a teenage girl for $35.");
//																		playerMoney += 35;
//																		reverseMenu(p1, p2);
//																	} 
//																else
//																	{
//																		System.out.println("You bought the Fortnite battle pass ofr $10.");
//																		playerMoney -= 10;
//																		checkForBankruptcy(p1, p2);
//																		reverseMenu(p1, p2);
//																	}
//														}
//							}
//			}
//		public static void inJailTurn2(Player p2)
//			{
//				// need to implement cards soon
//				System.out.println("You are in jail\nWould you like to...\n1) Pay the $50 fee\n2) Roll for doubles");
//				menuInput = userInput.nextInt();
//
//				if (menuInput == 1)
//					{
//						freeParkingMoney += 50;
//						playerMoney -= 50;
//						System.out.println("You have now payed the fee and are free to go.");
//						inJail = false;
//						turnMenu(p1, p2);
//					} 
//				else
//					{
//						
//						DiceRoller.diceRoll();
//						if (DiceRoller.doubles == true)
//							{
//								
//								System.out.println("You rolled doubles and are free to go.");
//								inJail = false;
//								turnMenu(p1, p2);
//							} else
//							{
//								doublesTriedCounter++;
//								System.out.println("You failed to roll doubles " + doublesTriedCounter + " times.");
//								inJailTurn(p1, p2);
//							}
//					}
//			}
//		public static void reverseJailTurn2(Player p2)
//			{
//				// need to implement cards soon
//				System.out.println("You are in jail\nWould you like to...\n1) Pay the $50 fee\n2) Roll for doubles");
//				menuInput = userInput.nextInt();
//
//				if (menuInput == 1)
//					{
//						freeParkingMoney += 50;
//						playerMoney -= 50;
//						System.out.println("You have now payed the fee and are free to go.");
//						inJail = false;
//						reverseMenu(p1, p2);
//					} 
//				
//				else
//					{
//						DiceRoller.diceRoll();
//						if (DiceRoller.doubles == true)
//							{
//								
//								System.out.println("You rolled doubles and are free to go.");
//								inJail = false;
//								reverseMenu(p1, p2);
//							} else
//							{
//								doublesTriedCounter++;
//								System.out.println("You failed to roll doubles " + doublesTriedCounter + " times.");
//								reverseJailTurn(p1, p2);
//							}
//					}
//			}
//		public static void testFreeParking2(Player p2)
//		{			
//			playerLocation = 19;
//			
//			int playerRoll = DiceRoller.oneRoll();
//			
//			playerLocation += playerRoll;
//			System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou landed on " + 
//			MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");
//
//			System.out.println("You won " + freeParkingMoney + "!");
//			playerMoney += freeParkingMoney;
//			freeParkingMoney = 100;
//			
//			System.out.println();
//			System.out.println("You are now moving counter clockwise!");
//			reverseMovePlayer(p2);
//		} 
//		
//	}
//
////if (playerLocation == 22)	
////	{
////		DiceRoller.direction*=-1;
////		if ((playerLocation + playerRoll) < 39)
////			{
////				playerLocation += playerRoll;
////			} 
////		else if((MonopDriver.board[playerLocation].getName().equals("GO")))
////			{
////				playerLocation = (playerLocation + playerRoll) - 40;
////				playerMoney += 200;
////				System.out.println("You passed GO and collected $200");
////			}
////		else
////			{
////				if ((playerLocation + playerRoll) < 39)
////					{
////						playerLocation += playerRoll;
////					} 
////				else if((MonopDriver.board[playerLocation].getName().equals("GO")))
////					{
////						playerLocation = (playerLocation + playerRoll) - 40;
////						playerMoney += 200;
////						System.out.println("You passsed GO and collected $200");
////					}
////			}
////
////		System.out.println("Your total: " + playerRoll + "\nYou landed on " + MonopDriver.board[playerLocation].getName());
////		
////		if (DiceRoller.doubles == true)
////			{
////				timesRolledDoubles++;
////				if (timesRolledDoubles == 3)
////					{
////						goToJail();
////						inJailTurn();
////					} 
////				else
////					{
////						System.out.println("You rolled doubles, so you get to roll again!");
////						movePlayer();
////					}
////			} 
////		else
////			{
////				
////			}
////	}
////	
////	System.out.println("You won " + freeParkingMoney + "!");
////	playerMoney += freeParkingMoney;
////	freeParkingMoney = 100;
