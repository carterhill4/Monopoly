import java.util.ArrayList;
import java.util.Scanner;

public class Actions
	{
		static int playerLocation = 0;
		static boolean inJail = false;
		static int playerMoney = 1500;
		//static boolean stillPlaying = true;
		static String playerName;
		static int menuInput;
		static int statInput;
		static int inventoryCounter;
		static int freeParkingMoney;
		static int timesRolledDoubles = 0;
		static Scanner userInput = new Scanner(System.in);
		static ArrayList<BoardSpace> inventory = new ArrayList<BoardSpace>();
		static int direction = 1;
		static int doublesTriedCounter = 0;
			
		
		public static void greetPlayer()
			{
				System.out.println("What is your name?");
				playerName = userInput.nextLine();
				//getName(Player1).setName(playerName);
				System.out.println("Welcome, " + playerName + "!");
				System.out.println();	
				
				
				
			}
		public static void turnMenu()
			{
				System.out.println(playerName + ", it's your turn!\nWould you like to...\n1) Roll the dice \n2) View your stats");
				menuInput = userInput.nextInt();
				
				if (menuInput == 1)
					{
						movePlayer();
					} 
				else if (menuInput == 2)
						{
							displayPlayerStats();
						} 
//				else if(menuInput == 3)
//					{
//						purchaseHouses();
//					}
				else
						{
							System.out.println("That's not an option.");
							turnMenu();
						}
			}
		public static void reverseMenu()
			{
				System.out.println(playerName + ", it's your turn!\nWould you like to...\n1) Roll the dice \n2) View your stats");
				menuInput = userInput.nextInt();
				
				if (menuInput == 1)
					{
						reverseMovePlayer();
					} 
				else if (menuInput == 2)
						{
							reverseDisplayPlayerStats();
						} 
//				else if(menuInput == 3)
//					{
//						purchaseHouses();
//					}
				else
						{
							System.out.println("That's not an option.\nPlease try again.");
							reverseMenu();
						}
			}
		public static void displayPlayerStats()
			{
				System.out.println("Your name is: " + playerName);
				System.out.println("Current balance: $" + playerMoney);
				
				
				for(BoardSpace k : inventory)
					{
						System.out.println("You own the " + k.getType() + ": " + k.getName());		
						System.out.println();
					}
				
				turnMenu();
			
			}
		public static void reverseDisplayPlayerStats()
			{
				System.out.println("Your name is: " + playerName);
				System.out.println("Current balance: $" + playerMoney);
				
				
				for(BoardSpace k : inventory)
					{
						System.out.print("You own the " + k.getType() + " " + k.getName() );		
						System.out.println();
					}
				
				reverseMenu();
				System.out.println();
			}
		public static void movePlayer()
			{
			int playerRoll = DiceRoller.diceRoll();
				
				if ((playerLocation + playerRoll) < 39)
					{
						playerLocation += playerRoll;
					}
				else
					{
						playerLocation += playerRoll;
								playerLocation -= 40;
								playerMoney += 200;
								System.out.println("You passsed GO and collected $200");
								System.out.println();
					}
					
				
					

				System.out.println("Your total is: " + playerRoll + ".\nYou landed on " + MonopDriver.board[playerLocation].getName() 
				+ ", the " + playerLocation + " spot on the board.");
				landOnSquare();

				if (DiceRoller.doubles == true)
					{

						if (timesRolledDoubles == 3)
							{
								goToJail();
								
							} 
						else
							{
								System.out.println("You rolled doubles, roll again!");
								movePlayer();
							}
					} 
				else
					{
						
					}
		}
		public static void reverseMovePlayer()
			{
				int playerRoll = DiceRoller.diceRoll();
				
				if ((playerLocation + playerRoll) < 0)
					{
						playerLocation += playerRoll;
						playerLocation += 40;
						playerMoney += 200;
						System.out.println("You passsed GO and collected $200");
						System.out.println();
					}
				else
					{
						playerLocation += playerRoll;	
					}
					

				System.out.println("Your total is: " + playerRoll + ".\nYou landed on " + MonopDriver.board[playerLocation].getName() 
				+ ", the " + playerLocation + " spot on the board.");
				reverseLandOnSquare();

				if (DiceRoller.doubles == true)
					{

						if (timesRolledDoubles == 3)
							{
								goToJail();
							} 
						else
							{
								System.out.println("You rolled doubles, roll again!");
								reverseMovePlayer();
							}
					} 
				else
					{
						
					}
						
			} 
		public static void checkForBankruptcy()
			{
				
				if(playerMoney <= 0)
					{
						System.out.println("You've gone bankrupt! You lose!");
						System.exit(0);
						//stillPlaying = false;
						
					}
			}
		public static void testJail()
{
	playerLocation = 29;
	int playerRoll = DiceRoller.oneRoll();
	playerLocation += playerRoll;
	System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou are on " + 
	MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");
	
	inJail = true;
	inJailTurn();
}
		public static void goToJail()
			{
				playerLocation = 10;
				inJail = true;
				inJailTurn();
			}
		public static void reverseGoToJail()
			{
				playerLocation = 10;
				System.out.println("You are now in jail");
				inJail = true;
				reverseJailTurn();
			}
		public static void landOnSquare()
			{
				if (MonopDriver.board[playerLocation].getType().equals("Property"))
					{
						if (MonopDriver.board[playerLocation].getOwner().equals("none"))
							{
								System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
								menuInput = userInput.nextInt();

								if (menuInput == 1)
									{
										MonopDriver.board[playerLocation].setOwner(playerName);
										playerMoney -= MonopDriver.board[playerLocation].getCost();
										checkForBankruptcy();
										inventory.add(MonopDriver.board[playerLocation]);
										System.out.println();
										System.out.println("You now own " + MonopDriver.board[playerLocation].getName());
										System.out.println();
										turnMenu();
									}
								else
									{
										turnMenu();
									}
								// need to implement the 'developing' feature (where you can only buy houses if
								// you own all of that color)
							} 
						else if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
								{
									System.out.println("You already own this property.");
								}
								 
							else
								{
									System.out.println("This property is already owned by" + MonopDriver.board[playerLocation].getOwner() + ", you now must pay rent.");
									if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 0)
										{
											playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getBasicRent();
										} 
									else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1)
											{
												playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getOneHouseRent();
											} 
										else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2)
												{
													playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getTwoHouseRent();
												} 
											else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3)
													{
														playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getThreeHouseRent();
													} 
												else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4)
														{
															playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getHotelRent();
														}
									checkForBankruptcy();
								}
					} 
				
				
				
				
				
				
				else if (MonopDriver.board[playerLocation].getType().equals("Utility"))
						{
							if (MonopDriver.board[playerLocation].getOwner().equals("none"))
								{
									System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
									menuInput = userInput.nextInt();

									if (menuInput == 1)
										{
											MonopDriver.board[playerLocation].setOwner(playerName);
											playerMoney -= MonopDriver.board[playerLocation].getCost();
											checkForBankruptcy();
											inventory.add(MonopDriver.board[playerLocation]);
											turnMenu();
										}
									else 
										{
											turnMenu();
										}
								} 
							else
								if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
									{
										System.out.println("You already own this utility");
									} 
								else
									{
										System.out.println("This utility is already owned by "
												+ MonopDriver.board[playerLocation].getOwner()
												+ ", you now must pay for the service.");
										// need to figure out how to search the array for everything that has one
										// specific field
									}
						} 
					
					
				
				else if (MonopDriver.board[playerLocation].getType().equals("Railroad"))
							{
								if (MonopDriver.board[playerLocation].getOwner().equals("none"))
									{
										System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
										menuInput = userInput.nextInt();

										if (menuInput == 1)
											{
												MonopDriver.board[playerLocation].setOwner(playerName);
												playerMoney -= MonopDriver.board[playerLocation].getCost();
												checkForBankruptcy();
												inventory.add(MonopDriver.board[playerLocation]);
												turnMenu();
											}
										else 
											{
												turnMenu();
											}
									} 
								else
									if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
										{
											System.out.println("You already own this railroad");
										} 
									else
										{
											// once again need to figure the comment from above out

											/*
											 * System.out.println("This property is already owned by" +
											 * MonopDriver.board[playerLocation].getOwner() +
											 * ", you now must pay rent."); if(((Railroads)
											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1) {
											 * playerMoney -= ((Railroads)
											 * MonopDriver.board[playerLocation]).getOneOwnedRent(); } else
											 * if(((Railroads)
											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2) {
											 * playerMoney -= ((Railroads)
											 * MonopDriver.board[playerLocation]).getTwoOwnedRent(); } else
											 * if(((Railroads)
											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3) {
											 * playerMoney -= ((Railroads)
											 * MonopDriver.board[playerLocation]).getThreeOwnedRent(); } else
											 * if(((Railroads)
											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4) {
											 * playerMoney -= ((Railroads)
											 * MonopDriver.board[playerLocation]).getFourOwnedRent(); }
											 */

											checkForBankruptcy();
										}
							} 
						
					
					else
							{
								if (MonopDriver.board[playerLocation].getName().equals("GO"))
									{
										playerMoney += MonopDriver.board[playerLocation].getCost();
										System.out.println(
												"You collected $" + MonopDriver.board[playerLocation].getCost());
									} 
								else if (MonopDriver.board[playerLocation].getName().equals("Go_To_Jail"))
										{
											goToJail();
										} 
								else if (MonopDriver.board[playerLocation].getName().equals("Jail") && inJail == false)
									{
										System.out.println("You are just visiting jail.");
										turnMenu();
									}
								else if (MonopDriver.board[playerLocation].getName().equals("Free_Parking"))
									{
										System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou landed on " + 
												MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");

												System.out.println("You won " + freeParkingMoney + "!");
												playerMoney += freeParkingMoney;
												freeParkingMoney = 100;
												
												System.out.println();
												System.out.println("You are now moving counter clockwise!");
												reverseMovePlayer();
									} 
										else if (MonopDriver.board[playerLocation].getName().equals("Income_Tax") || MonopDriver.board[playerLocation].getName().equals("Luxury_Tax"))
												{
													System.out.println("You have been taxed $" + MonopDriver.board[playerLocation].getCost());
													freeParkingMoney += MonopDriver.board[playerLocation].getCost();
													playerMoney -= MonopDriver.board[playerLocation].getCost();
													checkForBankruptcy();
													turnMenu();
												}

								
											// chance cards
											else if (MonopDriver.board[playerLocation].getName().equals("Chance"))
													{
														int chanceNumber = (int) (Math.random() * 3) + 1;
														if (chanceNumber == 1)
															{
																System.out.println("You're wife left you. Give 50% of your money to her.");
																System.out.println();
																playerMoney = playerMoney / 2;
																turnMenu();
															}

														else
															if (chanceNumber == 2)
																{
																	System.out.println("You got your secretary pregnant. Pay $50.");
																	System.out.println();
																	playerMoney = playerMoney - 50;
																	checkForBankruptcy();
																	turnMenu();
																} 
															else
																{
																	System.out.println("You found $100 on the street.");
																	System.out.println();
																	playerMoney = playerMoney + 100;
																	turnMenu();
																}
													}
												
												
												// community chest
												else if(MonopDriver.board[playerLocation].getName().equals("Community_Chest"))
														{
															int chestNumber = (int) (Math.random() * 3) + 1;
															if (chestNumber == 1)
																{
																	System.out.println("Your dog needs a surgery. Pay the vet $100.");
																	System.out.println();
																	playerMoney -= 100;
																	checkForBankruptcy();
																	turnMenu();
																}

															else if (chestNumber == 2)
																	{
																		System.out.println("You have turned to a life of crime. You mugged a teenage girl for $35.");
																		System.out.println();
																		playerMoney += 35;
																		turnMenu();
																	} 
																else
																	{
																		System.out.println("You bought the Fortnite battle pass for $10.");
																		System.out.println();
																		playerMoney -= 10;
																		checkForBankruptcy();
																		turnMenu();
																	}
														}
							}
			}
		public static void reverseLandOnSquare()
			{
				if (MonopDriver.board[playerLocation].getType().equals("Property"))
					{
						if (MonopDriver.board[playerLocation].getOwner().equals("none"))
							{
								System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
								menuInput = userInput.nextInt();

								if (menuInput == 1)
									{
										MonopDriver.board[playerLocation].setOwner(playerName);
										playerMoney -= MonopDriver.board[playerLocation].getCost();
										checkForBankruptcy();
										inventory.add(MonopDriver.board[playerLocation]);
										System.out.println();
										System.out.println("You now own " + MonopDriver.board[playerLocation].getName());
										System.out.println();
										reverseMenu();
									}
								else
									{
										reverseMenu();
									}
								// need to implement the 'developing' feature (where you can only buy houses if
								// you own all of that color)
							} 
						else if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
								{
									System.out.println("You already own this property.");		
								} 
							else
								{
									System.out.println("This property is already owned by" + MonopDriver.board[playerLocation].getOwner() + ", you now must pay rent.");
									if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 0)
										{
											playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getBasicRent();
										} 
									else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1)
											{
												playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getOneHouseRent();
											} 
										else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2)
												{
													playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getTwoHouseRent();
												} 
											else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3)
													{
														playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getThreeHouseRent();
													} 
												else if (((Properties) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4)
														{
															playerMoney -= ((Properties) MonopDriver.board[playerLocation]).getHotelRent();
														}
									checkForBankruptcy();
								}
					} 
				
				
				
				
				
				
				else if (MonopDriver.board[playerLocation].getType().equals("Utility"))
						{
							if (MonopDriver.board[playerLocation].getOwner().equals("none"))
								{
									System.out.println("This utility is not owned, would you like to buy it?\n1) Yes\n2) No");
									menuInput = userInput.nextInt();

									if (menuInput == 1)
										{
											MonopDriver.board[playerLocation].setOwner(playerName);
											playerMoney -= MonopDriver.board[playerLocation].getCost();
											checkForBankruptcy();
											inventory.add(MonopDriver.board[playerLocation]);
											reverseMenu();
										}
								} 
							else
								if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
									{
										System.out.println("You already own this utility");
									} 
								else
									{
										System.out.println("This utility is already owned by "
												+ MonopDriver.board[playerLocation].getOwner()
												+ ", you now must pay for the service.");
										// need to figure out how to search the array for everything that has one
										// specific field
									}
						} 
					
					
				
				else if (MonopDriver.board[playerLocation].getType().equals("Railroad"))
							{
								if (MonopDriver.board[playerLocation].getOwner().equals("none"))
									{
										System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
										menuInput = userInput.nextInt();

										if (menuInput == 1)
											{
												MonopDriver.board[playerLocation].setOwner(playerName);
												playerMoney -= MonopDriver.board[playerLocation].getCost();
												checkForBankruptcy();
												inventory.add(MonopDriver.board[playerLocation]);
												reverseMenu();
											}
									} 
								else
									if (MonopDriver.board[playerLocation].getOwner().equals(playerName))
										{
											System.out.println("You already own this railroad");
											reverseMenu();
										} 
									else
										{
											// once again need to figure the comment from above out

											/*
											 * System.out.println("This property is already owned by" +
											 * MonopDriver.board[playerLocation].getOwner() +
											 * ", you now must pay rent."); if(((Railroads)
											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1) {
											 * playerMoney -= ((Railroads)
											 * MonopDriver.board[playerLocation]).getOneOwnedRent(); } else
											 * if(((Railroads)
											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2) {
											 * playerMoney -= ((Railroads)
											 * MonopDriver.board[playerLocation]).getTwoOwnedRent(); } else
											 * if(((Railroads)
											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3) {
											 * playerMoney -= ((Railroads)
											 * MonopDriver.board[playerLocation]).getThreeOwnedRent(); } else
											 * if(((Railroads)
											 * MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4) {
											 * playerMoney -= ((Railroads)
											 * MonopDriver.board[playerLocation]).getFourOwnedRent(); }
											 */

											checkForBankruptcy();
										}
							} 
						
					
					else
							{
								if (MonopDriver.board[playerLocation].getName().equals("GO"))
									{
										playerMoney += MonopDriver.board[playerLocation].getCost();
										System.out.println(
												"You collected $" + MonopDriver.board[playerLocation].getCost());
									} 
								else if (MonopDriver.board[playerLocation].getName().equals("Go_To_Jail"))
										{
											reverseGoToJail();
										} 
								//comment
								else if (MonopDriver.board[playerLocation].getName().equals("Jail") && inJail == false)
									{
										System.out.println("You are just visiting jail.");
										turnMenu();
									}
								
									else if (MonopDriver.board[playerLocation].getName().equals("Free_Parking"))
											{
												System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou landed on " + 
														MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");

														System.out.println("You won " + freeParkingMoney + "!");
														playerMoney += freeParkingMoney;
														freeParkingMoney = 100;
														
														System.out.println();
														System.out.println("You are now moving counter clockwise!");
														reverseMovePlayer();
											} 
										else if (MonopDriver.board[playerLocation].getName().equals("Income_Tax") || MonopDriver.board[playerLocation].getName().equals("Luxury_Tax"))
												{
													System.out.println("You have been taxed $" + MonopDriver.board[playerLocation].getCost());
													freeParkingMoney += MonopDriver.board[playerLocation].getCost();
													playerMoney -= MonopDriver.board[playerLocation].getCost();
													checkForBankruptcy();
													reverseMenu();
												}

								
											// chance cards
											else if (MonopDriver.board[playerLocation].getName().equals("Chance"))
													{
														int chanceNumber = (int) (Math.random() * 3) + 1;
														if (chanceNumber == 1)
															{
																System.out.println("You're wife left you. Give 50% of your money to her.");
																playerMoney = playerMoney / 2;
																reverseMenu();
															}

														else
															if (chanceNumber == 2)
																{
																	System.out.println("You got your secretary pregnant. Pay $50.");
																	playerMoney = playerMoney - 50;
																	checkForBankruptcy();
																	reverseMenu();
																} 
															else
																{
																	System.out.println("You found $100 on the street.");
																	playerMoney = playerMoney + 100;
																	reverseMenu();
																}
													}
												
												
												// community chest
												else
													if (MonopDriver.board[playerLocation].getName().equals("Community_Chest"))
														{
															int chestNumber = (int) (Math.random() * 3) + 1;
															if (chestNumber == 1)
																{
																	System.out.println("Your dog needs a surgery. Pay the vet $100.");
																	playerMoney -= 100;
																	checkForBankruptcy();
																	reverseMenu();
																}

															else if (chestNumber == 2)
																	{
																		System.out.println("You have turned to a life of crime. You mugged a teenage girl for $35.");
																		playerMoney += 35;
																		reverseMenu();
																	} 
																else
																	{
																		System.out.println("You bought the Fortnite battle pass ofr $10.");
																		playerMoney -= 10;
																		checkForBankruptcy();
																		reverseMenu();
																	}
														}
							}
			}
		public static void inJailTurn()
			{
				// need to implement cards soon
				System.out.println("You are in jail\nWould you like to...\n1) Pay the $50 fee\n2) Roll for doubles");
				menuInput = userInput.nextInt();

				if (menuInput == 1)
					{
						freeParkingMoney += 50;
						playerMoney -= 50;
						System.out.println("You have now payed the fee and are free to go.");
						inJail = false;
						turnMenu();
					} 
				else
					{
						
						DiceRoller.diceRoll();
						if (DiceRoller.doubles == true)
							{
								
								System.out.println("You rolled doubles and are free to go.");
								inJail = false;
								turnMenu();
							} else
							{
								doublesTriedCounter++;
								System.out.println("You failed to roll doubles " + doublesTriedCounter + " times.");
								inJailTurn();
							}
					}
			}
		public static void reverseJailTurn()
			{
				// need to implement cards soon
				System.out.println("You are in jail\nWould you like to...\n1) Pay the $50 fee\n2) Roll for doubles");
				menuInput = userInput.nextInt();

				if (menuInput == 1)
					{
						freeParkingMoney += 50;
						playerMoney -= 50;
						System.out.println("You have now payed the fee and are free to go.");
						inJail = false;
						reverseMenu();
					} 
				
				else
					{
						DiceRoller.diceRoll();
						if (DiceRoller.doubles == true)
							{
								
								System.out.println("You rolled doubles and are free to go.");
								inJail = false;
								reverseMenu();
							} else
							{
								doublesTriedCounter++;
								System.out.println("You failed to roll doubles " + doublesTriedCounter + " times.");
								reverseJailTurn();
							}
					}
			}
		public static void testFreeParking()
		{			
			playerLocation = 19;
			
			int playerRoll = DiceRoller.oneRoll();
			
			playerLocation += playerRoll;
			System.out.println("Your total: " + DiceRoller.oneRoll + "\nYou landed on " + 
			MonopDriver.board[playerLocation].getName() + " the " + playerLocation + " spot on the board");

			System.out.println("You won " + freeParkingMoney + "!");
			playerMoney += freeParkingMoney;
			freeParkingMoney = 100;
			
			System.out.println();
			System.out.println("You are now moving counter clockwise!");
			reverseMovePlayer();
		} 
		
	}

//if (playerLocation == 22)	
//	{
//		DiceRoller.direction*=-1;
//		if ((playerLocation + playerRoll) < 39)
//			{
//				playerLocation += playerRoll;
//			} 
//		else if((MonopDriver.board[playerLocation].getName().equals("GO")))
//			{
//				playerLocation = (playerLocation + playerRoll) - 40;
//				playerMoney += 200;
//				System.out.println("You passed GO and collected $200");
//			}
//		else
//			{
//				if ((playerLocation + playerRoll) < 39)
//					{
//						playerLocation += playerRoll;
//					} 
//				else if((MonopDriver.board[playerLocation].getName().equals("GO")))
//					{
//						playerLocation = (playerLocation + playerRoll) - 40;
//						playerMoney += 200;
//						System.out.println("You passsed GO and collected $200");
//					}
//			}
//
//		System.out.println("Your total: " + playerRoll + "\nYou landed on " + MonopDriver.board[playerLocation].getName());
//		
//		if (DiceRoller.doubles == true)
//			{
//				timesRolledDoubles++;
//				if (timesRolledDoubles == 3)
//					{
//						goToJail();
//						inJailTurn();
//					} 
//				else
//					{
//						System.out.println("You rolled doubles, so you get to roll again!");
//						movePlayer();
//					}
//			} 
//		else
//			{
//				
//			}
//	}
//	
//	System.out.println("You won " + freeParkingMoney + "!");
//	playerMoney += freeParkingMoney;
//	freeParkingMoney = 100;
