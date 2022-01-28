
public class DiceRoller
	{
		static boolean doubles;
		public static int diceRoll;
		public static int rollDice(int i, int j)
		    {
	    	int dieOne = 0;
	    	int dieTwo = 0;
	    	doubles = false;
			 int sumOfDice = 0;
			 for(int k = 0 ; k < i ; k++)
			    {
			      //roll the dice
				  int diceRollNumber = (int) (Math.random()*j)+1;
				  sumOfDice = diceRollNumber+sumOfDice;
				  //System.out.println("You rolled a "+diceRollNumber);
				  
			      if(k == 0)
			    	  {
			    		  dieOne = diceRollNumber;
			    	  }
			      else if(k == 1)
			    	  {
			    		  dieTwo = diceRollNumber;
			    	  }
			    }
			 if(dieOne == dieTwo)
				 {
					doubles = true;
					
					System.out.println("You rolled doubles!");
				 }
			 return sumOfDice;
		
		    }
		
		public static int diceRoll()
		{
			int dice1 = (int) (Math.random()*6+1);
			int dice2 = (int) (Math.random()*6+1);
			int diceSum = dice1 + dice2;
			
			return diceSum;
		}
	}
