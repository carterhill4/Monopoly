
public class DiceRoller
	{
		public static int diceSum;
		public static int negDiceSum;
		public static boolean doubles;
		public static int oneRoll;
		
		//static boolean doubles;
		//public static int diceRoll;
//		public static int rollDice(int i, int j)
//		    {
//	    	int dieOne = 0;
//	    	int dieTwo = 0;
//	    	doubles = false;
//			 int sumOfDice = 0;
//			 for(int k = 0 ; k < i ; k++)
//			    {
//			      //roll the dice
//				  int diceRollNumber = (int) (Math.random()*j)+1;
//				  sumOfDice = diceRollNumber+sumOfDice;
//				  //System.out.println("You rolled a "+diceRollNumber);
//				  
//			      if(k == 0)
//			    	  {
//			    		  dieOne = diceRollNumber;
//			    	  }
//			      else if(k == 1)
//			    	  {
//			    		  dieTwo = diceRollNumber;
//			    	  }
//			    }
//			 if(dieOne == dieTwo)
//				 {
//					doubles = true;
//					Actions.timesRolledDoubles++;
//					
//					System.out.println("You rolled doubles!");
//				 }
//			 return sumOfDice;
//		
//		    }
		//comment
		public static int diceRoll()
		{
			int dice1 = (int) (Math.random()*6+1);
			int dice2 = (int) (Math.random()*6+1);
			diceSum = dice1 + dice2;
			
			
			if(dice1 == dice2)
				{
					doubles = true;
					System.out.println("You rolled doubles");
					Actions.timesRolledDoubles++;
				}
			else
				{
					System.out.println();
				}
			
			return diceSum;
		}
		public static int reverseRoll()
			{
				int dice1 = (int) (Math.random()*6+1);
				int dice2 = (int) (Math.random()*6+1);
				dice1 = dice1 * -1;
				dice2 = dice2 * -1;
				negDiceSum = dice1 + dice2;
				
				
				if(dice1 == dice2)
					{
						doubles = true;
						System.out.println("You rolled doubles.");
						Actions.timesRolledDoubles++;
					}
				else
					{
						
						System.out.println();
					}
				
				return negDiceSum;
			}
		public static int oneRoll() //for tests
			{
				int dice1 = (int) (Math.random()*1 + 1);
				oneRoll = dice1;
				
				return dice1;
			}
	}
