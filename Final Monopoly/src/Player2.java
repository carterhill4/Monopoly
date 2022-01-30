
public class Player2
	{
		private String name;
		private int location;
		private boolean inJail;
		private int doublesCounter;
		private int money;
		private String inventory;
		private boolean cwDirection;
		
		
		
		public Player2(String n, int l, boolean j, int m, String i, boolean cw)
		{
			name = n;
			location = l;
			inJail = j;
			money = m;
			inventory = i;
			cwDirection = cw;
			
		}



		public String getName()
			{
				return name;
			}



		public void setName(String name)
			{
				this.name = name;
			}



		public int getLocation()
			{
				return location;
			}



		public void setLocation(int location)
			{
				this.location = location;
			}



		public boolean isInJail()
			{
				return inJail;
			}



		public void setInJail(boolean inJail)
			{
				this.inJail = inJail;
			}



		public int getMoney()
			{
				return money;
			}



		public void setMoney(int money)
			{
				this.money = money;
			}



		public String getInventory()
			{
				return inventory;
			}



		public void setInventory(String inventory)
			{
				this.inventory = inventory;
			}



		public boolean isCwDirection()
			{
				return cwDirection;
			}



		public void setCwDirection(boolean cwDirection)
			{
				this.cwDirection = cwDirection;
			}
	}
