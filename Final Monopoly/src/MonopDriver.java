import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MonopDriver
	{
		
		//static ArrayList<Player> playerInfo = new ArrayList<Player>();
		
		static BoardSpace[] board = new BoardSpace[40];
		static Scanner userInput = new Scanner(System.in);
		//static int monopType;
		
		public static void main(String[] args) throws IOException
			{
//				System.out.println("What is player one's name?");
//				String player1Name = userInput.nextLine();
//				//playerInfo.add(new Player (player1Name, 0, false, 1500, new ArrayList<BoardSpace>(), 1));
//				Player p1 = new Player(player1Name, 0, false, 1500, new ArrayList<BoardSpace>(), 1);
//				System.out.println("What is player two's name?");
//				String player2Name = userInput.nextLine();
//				Player p2 = new Player (player2Name, 0, false, 1500, new ArrayList<BoardSpace>(), 1);
				
				Action.greetPlayer();
				System.out.println("What monopoly theme would you like to play: "
						+ "\n1) American/Original Monopoly "
						+ "\n2) Fortnite Monopoly"
						+ "\n3) Sponge Bob Monopoly");
				int choice = userInput.nextInt();
				if(choice == 1)
					{
						fillBoardWithAmerican();
					}
				else if(choice == 2)
					{
						fillBoardWithFortnite();
					}
				else
					{
						fillBoardWithSpongeBob();
					}


				
						
						
						//Action.turnMenu();
					//Action.testFreeParking();
				Action.testJail();
				
				
				
				
				
//				System.out.println(Player.playerLocation);
//				Player.landOnSquare();
//				Player.testFreeParking();
//				Player.turnMenu();
//				System.out.println(Player.playerLocation);
				
//				for(BoardSpace b : board)
//					{
//						System.out.println(b.getType());
//					}
				
//				while(Actions.stillPlaying)
//					{
//						Actions.turnMenu();
//						System.out.println(Actions.playerLocation);
//						Actions.landOnSquare();
//					}
				 
				
				 
			}


		public static void fillBoardWithAmerican() throws IOException
			{
				
				Scanner file = new Scanner(new File("AmericanMonopoly.txt"));
				
				int numberOfLines = file.nextInt();

				for (int i = 0; i < numberOfLines; i++)
					{

						String type = file.next();

						if (type.equals("Property"))
							{

								String n = file.next();
								String o = file.next();
								int c = file.nextInt();
								int l = file.nextInt();
								boolean d = file.nextBoolean();
								int br = file.nextInt();
								int hh = file.nextInt();
								int r1 = file.nextInt();
								int r2 = file.nextInt();
								int r3 = file.nextInt();
								int hr = file.nextInt();
								int hn = file.nextInt();
								String co = file.next();

								board[i] = new Properties("Property", n, o, c, l, d, br, hh, r1, r2, r3, hr, hn, co);

							}

						else
							if (type.equals("Railroad"))
								{

									String n = file.next();
									String o = file.next();
									int c = file.nextInt();
									int l = file.nextInt();
									int r1 = file.nextInt();
									int r2 = file.nextInt();
									int r3 = file.nextInt();
									int r4 = file.nextInt();
									board[i] = new Railroads("Railroad", n, o, c, l, r1, r2, r3, r4);
								}

							else
								if (type.equals("Utility"))
									{

										String n = file.next();
										String o = file.next();
										int c = file.nextInt();
										int l = file.nextInt();
										//int dr1 = DiceRoller.rollDice(2, 6) * 4;
										//int dr2 = DiceRoller.rollDice(2, 6) * 10;

										board[i] = new Utilities("Utility", n, o, c, l, 0, 0);

									} else
									if (type.equals("Other"))
										{
											String n = file.next();
											String o = file.next();
											int c = file.nextInt();
											int l = file.nextInt();

											board[i] = new BoardSpace("Other", n, o, c, l);
										}
					}

				//for (BoardSpace b : board)
					//{
						//System.out.println(b);

					//}

				//Player.greetPlayer();
			//	while (Player.stillPlaying == true)
					//{
						//if (Player.inJail == false)
						//{
								//Player.turnMenu();
							//} else
							//{
							//	Player.inJailTurn();
							//}
				//	}
			}
		
		
		public static void fillBoardWithSpongeBob() throws IOException
		{
			Scanner file = new Scanner(new File("SpongeBobMonopoly.txt"));
			
			int numberOfLines = file.nextInt();

			for (int i = 0; i < numberOfLines; i++)
				{

					String type = file.next();

					if (type.equals("Property"))
						{

							String n = file.next();
							String o = file.next();
							int c = file.nextInt();
							int l = file.nextInt();
							boolean d = file.nextBoolean();
							int br = file.nextInt();
							int hh = file.nextInt();
							int r1 = file.nextInt();
							int r2 = file.nextInt();
							int r3 = file.nextInt();
							int hr = file.nextInt();
							int hn = file.nextInt();
							String co = file.next();

							board[i] = new Properties("Property", n, o, c, l, d, br, hh, r1, r2, r3, hr, hn, co);

						}

					else
						if (type.equals("Railroad"))
							{

								String n = file.next();
								String o = file.next();
								int c = file.nextInt();
								int l = file.nextInt();
								int r1 = file.nextInt();
								int r2 = file.nextInt();
								int r3 = file.nextInt();
								int r4 = file.nextInt();
								board[i] = new Railroads("Railroad", n, o, c, l, r1, r2, r3, r4);
							}

						else
							if (type.equals("Utility"))
								{

									String n = file.next();
									String o = file.next();
									int c = file.nextInt();
									int l = file.nextInt();
									//int dr1 = DiceRoller.rollDice(2, 6) * 4;
									//int dr2 = DiceRoller.rollDice(2, 6) * 10;

									board[i] = new Utilities("Utility", n, o, c, l, 0, 0);

								} else
								if (type.equals("Other"))
									{
										String n = file.next();
										String o = file.next();
										int c = file.nextInt();
										int l = file.nextInt();

										board[i] = new BoardSpace("Other", n, o, c, l);
									}
				}
			
		}
		
		
		public static void fillBoardWithFortnite() throws IOException
			{
				Scanner file = new Scanner(new File("FortniteMonopoly.txt"));
				
				int numberOfLines = file.nextInt();

				for (int i = 0; i < numberOfLines; i++)
					{

						String type = file.next();

						if (type.equals("Property"))
							{

								String n = file.next();
								String o = file.next();
								int c = file.nextInt();
								int l = file.nextInt();
								boolean d = file.nextBoolean();
								int br = file.nextInt();
								int hh = file.nextInt();
								int r1 = file.nextInt();
								int r2 = file.nextInt();
								int r3 = file.nextInt();
								int hr = file.nextInt();
								int hn = file.nextInt();
								String co = file.next();

								board[i] = new Properties("Property", n, o, c, l, d, br, hh, r1, r2, r3, hr, hn, co);

							}

						else
							if (type.equals("Railroad"))
								{

									String n = file.next();
									String o = file.next();
									int c = file.nextInt();
									int l = file.nextInt();
									int r1 = file.nextInt();
									int r2 = file.nextInt();
									int r3 = file.nextInt();
									int r4 = file.nextInt();
									board[i] = new Railroads("Railroad", n, o, c, l, r1, r2, r3, r4);
								}

							else
								if (type.equals("Utility"))
									{

										String n = file.next();
										String o = file.next();
										int c = file.nextInt();
										int l = file.nextInt();
										//int dr1 = DiceRoller.rollDice(2, 6) * 4;
										//int dr2 = DiceRoller.rollDice(2, 6) * 10;

										board[i] = new Utilities("Utility", n, o, c, l, 0, 0);

									} else
									if (type.equals("Other"))
										{
											String n = file.next();
											String o = file.next();
											int c = file.nextInt();
											int l = file.nextInt();

											board[i] = new BoardSpace("Other", n, o, c, l);
										}
					}
				
				
				
				
			}
}



