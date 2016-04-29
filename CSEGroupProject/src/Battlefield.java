package imperator;

public class Battlefield {
	int baseSize;
	int player1Position;
	int player2Position;
	String [] base;
	String [] playerBase;
	
	public Battlefield()
	{	baseSize = 10;
		player1Position = 1;
		player2Position = baseSize;
		base = new String [baseSize + 2];
		playerBase = new String [baseSize +2];
	}
	public Battlefield(int size)
	{	baseSize = size;
		player1Position = 1;
		player2Position = baseSize;
		base = new String [baseSize + 2];
		playerBase = new String [baseSize +2];
	}
	public void initializeFloor()
	{
		//Creates battle field floor
		for(int index = 0; index < base.length ; index ++)
		{
			base[index] = "-";
		}
	}
	public void initializePlayerFloor()
	{
		//Sets player start position
		playerBase[player1Position] = "1";
		playerBase[player2Position] = "2";
		//Sets wall boundaries for battle field
		playerBase[0] = "|";
		playerBase[base.length - 1] = "|";
		//Creating player field
		for(int index = 1; index < base.length -1 ; index ++)
		{
			if(playerBase[index] == "1" || playerBase[index] == "2")
				playerBase[index] = playerBase[index];
			else
				playerBase[index] = " ";
		}
	}
	private void updatePlayerField(int position1, int position2)
	{
		//Sets player start position
				playerBase[position1] = "1";
				playerBase[position2] = "2";
				//Sets wall boundaries for battle field
				playerBase[0] = "|";
				playerBase[base.length - 1] = "|";
				//Creating player field
				for(int index = 1; index < base.length -1 ; index ++)
				{
					if(playerBase[index] == "1" || playerBase[index] == "2")
						playerBase[index] = playerBase[index];
					else
						playerBase[index] = " ";
				}
	}
	public void moveLeft(int position)
	{
		if(playerBase[position] == "1")
		{	
			playerBase[position] = " ";
			player1Position --;
		}
		else if(playerBase[position] == "2")
		{
			playerBase[position] = " ";
			player2Position --;
		}
		updatePlayerField(player1Position,player2Position);
	}
	public void moveRight(int position)
	{
		if(playerBase[position] == "1")
		{	
			playerBase[position] = " ";
			player1Position ++;
		}
		else if(playerBase[position] == "2")
		{
			playerBase[position] = " ";
			player2Position ++;
		}
		updatePlayerField(player1Position,player2Position);
	}
	public boolean collisionLeft(int position)
	{
		if(playerBase[position - 1] == " ")
		{
			System.out.println("true");
			return true;
		}
		else
		{
			System.out.println("Space is already occupied.");
			return false;
		}
	}
	public boolean collisionRight(int position)
	{
		if(playerBase[position + 1] == " ")
		{
			System.out.println("true");
			return true;
		}
		else
		{
			System.out.println("Space is already occupied.");
			return false;
		}
	}
	public int rangeCheck()
	{
		return(Math.abs(player2Position - player1Position));
	}

}
