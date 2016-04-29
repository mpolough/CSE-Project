package GameProject;

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
		playerBase = new String [baseSize + 2];
	}
	public void initializeFloor ()
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
	public void initializePlayerFloor(int position1,int position2)
	{
		//Sets player start position where specified
		player1Position = position1;
		player2Position = position2;
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
	public void moveLeftTwo(int position)
	{
		moveLeft(position);
		if(collisionLeft(position - 1))
		{
			moveLeft(position- 1);
		}
	}
	public void moveRightTwo(int position)
	{
		moveRight(position);
		if(collisionRight(position + 1))
		{
			moveRight(position + 1);
		}
	}	
	public void moveFront(int movingPlayer, int player)
	{
		if((movingPlayer - player) < 0)
		{
			playerBase[movingPlayer] = " ";
			player1Position  = player2Position - 1;
		}
		else if((movingPlayer - player) > 0)
		{
			playerBase[movingPlayer] = " ";
			player2Position = player1Position + 1;
		}
		updatePlayerField(player1Position,player2Position);
		
	}
	public void pushBack(int player)
	{
		if(playerBase[player] == "1")
		{
			if(collisionLeft(player))
			{
				moveLeft(player);
				moveLeftTwo(player - 1);
			}
		}
		if(playerBase[player] == "2")
		{
			if(collisionRight(player))
			{
				moveRight(player);
				moveRightTwo(player + 1);
			}
		}
	}
	public boolean collisionLeft(int position)
	{
		if(playerBase[position - 1] == " ")
		{
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
	public void printFloor()
	{
		System.out.println();
		for(int index = 0; index < base.length; index ++)
		{
			System.out.print(base[index]);	
		}
		System.out.println();
	}
	public void printPlayerFloor()
	{
		for(int index = 0; index < playerBase.length; index ++)
		{
			System.out.print(playerBase[index]);	
		}
	}
	public void printBoth()
	{
		printPlayerFloor();
		printFloor();
	}

	public static void main(String[] args) { 
//Creating battlefield
		Battlefield field = new Battlefield(10);
//initializing battlefield
		field.initializeFloor();
		field.initializePlayerFloor();
//print initial battlefield
		field.printBoth();
//using moveLeftTwo function
		if(field.collisionLeft(field.player2Position))
			field.moveLeftTwo(field.player2Position);
		field.printBoth();
//using moveRightTwo function
		if(field.collisionRight(field.player1Position))
			field.moveRightTwo(field.player1Position);
		field.printBoth();
//player2 moving in front of player1		
		field.moveFront(field.player2Position, field.player1Position);
		field.printBoth();
//player2 moving two spaces to the left		
		if(field.collisionLeft(field.player2Position))
			field.moveLeftTwo(field.player2Position);
		field.printBoth();
//player2 pushed back		
		field.pushBack(field.player2Position);
		field.printBoth();
//Player1 moving front of player2		
		field.moveFront(field.player1Position, field.player2Position);
		field.printBoth();
//Player1 being pushed back		
		field.pushBack(field.player1Position);
		field.printBoth();
//Player2 moving rightTwo		
		field.moveRightTwo(field.player2Position);
		field.printBoth();
//Player2 moving rightTwo		
		field.moveRightTwo(field.player2Position);
		field.printBoth();
		
		}
	}

