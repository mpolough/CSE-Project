package imperator;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;



public class ImperatorMain 
{

	public static void main(String[] args) 
	{
		boolean end = false;
		Leaderboard board = new Leaderboard();
		PlayerProfile[] player = new PlayerProfile[10];
		int i = 0;
		Scanner reader = new Scanner(System.in);
		System.out.println("_________ _______  _______  _______  _______  _______ _________ _______  _______ ");
		System.out.println("\\__   __/(       )(  ____ )(  ____ \\(  ____ )(  ___  )\\__   __/(  ___  )(  ____ )");
		System.out.println("   ) (   | () () || (    )|| (    \\/| (    )|| (   ) |   ) (   | (   ) || (    )|");
		System.out.println("   | |   | || || || (____)|| (__    | (____)|| (___) |   | |   | |   | || (____)|");
		System.out.println("   | |   | |(_)| ||  _____)|  __)   |     __)|  ___  |   | |   | |   | ||     __)");
		System.out.println("   | |   | |   | || (      | (      | (\\ (   | (   ) |   | |   | |   | || (\\ (   ");
		System.out.println("___) (___| )   ( || )      | (____/\\| ) \\ \\__| )   ( |   | |   | (___) || ) \\ \\__");
		System.out.println("\\_______/|/     \\||/       (_______/|/   \\__/|/     \\|   )_(   (_______)|/   \\__/");
		
		System.out.println();
		System.out.println();
		System.out.println();
		int n;
		
		while(end == false)
		{
			
        System.out.println("Enter an option: ");
        System.out.println("1. Start game");
        System.out.println("2. Leaderboard");
        System.out.println("3. Exit");
        System.out.println("4. Add Profile");
        
        n = reader.nextInt();
        
        	switch (n) 
        	{
        	case 1:  
        		System.out.println("p1 please type in your name: ");
        		String dr = reader.next();
        		if(board.getProfile(dr) != null)
        		{
        			System.out.println("p2 please type in your name: ");
        			String da = reader.next();
        			if(board.getProfile(da) != null);
        			{
        				end = game();
        			}
        			
        		}
        		
        			break;
        	case 2:  
        		for(int d = 0; d < i; d++)
        		{
        			System.out.println(player[d].getPlayerName() + " Kills: " + player[d].getNumKills() + " Deaths: " + player[d].getNumDeaths());
        		}
        		System.out.println();
        			break;
        	case 3:  
        		System.out.println("Leaving");
        		end = true;
        			break;
        	case 4:
        		System.out.println("enter your name:");
        		String dn = reader.next();
        		player[i] = new PlayerProfile(dn, "mage");
        		board.addNewProfile(player[i]);
        		i++;
        		try {
					board.writer();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		break;
        		
        	}
		}
	}
	
	static boolean game()
	{
		NumberFormat formatter = new DecimalFormat("#0.00");
		CombatClass p1 = new CombatClass();
		CombatWeapon p1Weapon = new CombatWeapon();
		CombatClass p2 = new CombatClass();
		CombatWeapon p2Weapon = new CombatWeapon();
		Battlefield positions = new Battlefield();
		positions.initializeFloor();
		positions.initializePlayerFloor();
		System.out.println("player 1 choose class and weapon:");
		System.out.println("1. Mage:");
		System.out.println("hp: 4");
		System.out.println("armor:20%");
		System.out.println("weapon: staff");
		System.out.println("does 6 damage");
		System.out.println("min range: 1 Max range: 6");

		System.out.println("2. rouge:");
		System.out.println("hp: 6");
		System.out.println("armor:31");
		System.out.println("weapon: daggers");
		System.out.println("does 4 damage");
		System.out.println("min range: 1 Max range: 3");

		System.out.println("3. knight:");
		System.out.println("hp: 6");
		System.out.println("armor:50%");
		System.out.println("weapon: longsword");
		System.out.println("does 3 damage");
		System.out.println("min range: 1 Max range: 2");
		
		
		
		int p1Action = 0;
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		if (n == 1)
		{
			p1.setHealthPoints(4);
			p1.setType("Mage");
			p1.setArmor(.2);
    		p1Weapon.setDamage(6);
    		p1Weapon.setName("staff");
    		p1Weapon.setMinRange(1);
    		p1Weapon.setMaxRange(6);
		}
		else if (n == 2)
		{
			p1.setHealthPoints(6);
			p1.setType("Rouge");
			p1.setArmor(.3);
			p1Weapon.setDamage(4);
    		p1Weapon.setName("daggers");
    		p1Weapon.setMinRange(1);
    		p1Weapon.setMaxRange(3);
		}
		else
		{
			p1.setHealthPoints(6);
			p1.setType("Knight");
			p1.setArmor(.5);
			p1Weapon.setDamage(3);
    		p1Weapon.setName("longsword");
    		p1Weapon.setMinRange(1);
    		p1Weapon.setMaxRange(2);
		}
		
		System.out.println("player 2 choose class and weapon:");
		System.out.println("1. Mage:");
		System.out.println("hp: 4");
		System.out.println("armor:20%");
		System.out.println("weapon: staff");
		System.out.println("does 6 damage");
		System.out.println("min range: 1 Max range: 6");

		System.out.println("2. rouge:");
		System.out.println("hp: 6");
		System.out.println("armor:30%");
		System.out.println("weapon: daggers");
		System.out.println("does 4 damage");
		System.out.println("min range: 1 Max range: 3");

		System.out.println("3. knight:");
		System.out.println("hp: 6");
		System.out.println("armor:50%");
		System.out.println("weapon: longsword");
		System.out.println("does 3 damage");
		System.out.println("min range: 1 Max range: 2");
		
		int p2Action = 0;
		n = reader.nextInt();
		if (n == 1)
		{
			p2.setHealthPoints(4);
			p2.setType("Mage");
			p2.setArmor(.2);
    		p2Weapon.setDamage(6);
    		p2Weapon.setName("staff");
    		p2Weapon.setMinRange(1);
    		p2Weapon.setMaxRange(6);
		}
		else if (n == 2)
		{
			p2.setHealthPoints(6);
			p2.setType("Rouge");
			p2.setArmor(.3);
			p2Weapon.setDamage(4);
    		p2Weapon.setName("daggers");
    		p2Weapon.setMinRange(1);
    		p2Weapon.setMaxRange(3);
		}
		else
		{
			p2.setHealthPoints(6);
			p2.setType("Knight");
			p2.setArmor(.5);
			p2Weapon.setDamage(3);
    		p2Weapon.setName("longsword");
    		p2Weapon.setMinRange(1);
    		p2Weapon.setMaxRange(2);
		}
		boolean P1Turn = true;
		boolean P2Turn = true;
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		String info = null;
		boolean displayinfo = false;
		
		gameloop: while (p1.healthPoints != 0 && p2.healthPoints != 0)
		{
			
			System.out.print("player 1 ");
			p1Action += roll3();
			while (P1Turn == true)
			{
				for (int i = 0; i < positions.playerBase.length; i++)
				{
					System.out.print(positions.playerBase[i]);
				}
				System.out.println();
				for (int i = 0; i < positions.base.length; i++)
				{
					System.out.print(positions.base[i]);
				}
				
				System.out.println("player 1 you have " + p1Action + " action(s) left");
				System.out.println("select an option:");
				System.out.println("1. move");
				System.out.println("2. attack");
				System.out.println("3. abstain");
				n = reader.nextInt();
				switch(n)
				{
				case 1:
					System.out.println("Move left or move right");
					
					
					System.out.println("1. left");
					System.out.println("2. right");
					n = reader.nextInt();
					
					switch(n)
					{
					case 1:
						if (positions.collisionLeft(positions.player1Position) == true)
						{
							positions.moveLeft(positions.player1Position);
							p1Action -= 1;
						}
						else
						{
							
						}
						break;
						
					case 2:
						if (positions.collisionRight(positions.player1Position) == true)
						{
							positions.moveRight(positions.player1Position);
							p1Action -= 1;
						}
						else
						{
							
						}
						break;
					}
					break;
				
				case 2:
					if(p2Weapon.inRange(positions.rangeCheck()) == true)
					{
						if (roll20() >= 10)
						{
							double dam = p2.damage(p1Weapon.damage);
							p1Action -= 1;
							
							info = "Hit!!! player 1 does " + formatter.format(dam) + " damage. player 2 has " + formatter.format(p2.healthPoints) + " left";
							displayinfo = true;
						}
						
						else
						{
							info = "Miss!!!";
							displayinfo = true;
						}
					}
					else
					{
						
					}
					break;
					
				case 3:
					P1Turn = false;
					break;
				}
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				if(displayinfo == true)
				{
					System.out.println(info);
					displayinfo = false;
				}
				if (p1Action == 0)
				{
					P1Turn = false;
				}
				if (p1.healthPoints <= 0 || p2.healthPoints <= 0)
				{
					break gameloop;
				}
			}
			
			if (p1.healthPoints <= 0 || p2.healthPoints <= 0)
			{
				break gameloop;
			}
			
			System.out.println();
			System.out.print("player 2 ");
			p2Action += roll3();
			while (P2Turn == true)
			{
				for (int i = 0; i < positions.playerBase.length; i++)
				{
					System.out.print(positions.playerBase[i]);
				}
				System.out.println();
				for (int i = 0; i < positions.base.length; i++)
				{
					System.out.print(positions.base[i]);
				}
				
				System.out.println("player 2 you have " + p2Action + " action(s) left");
				System.out.println("select an option:");
				System.out.println("1. move");
				System.out.println("2. attack");
				System.out.println("3. abstain");
				n = reader.nextInt();
				switch(n)
				{
				case 1:
					System.out.println("Move left or move right");
					
					
					System.out.println("1. left");
					System.out.println("2. right");
					n = reader.nextInt();
					
					switch(n)
					{
					case 1:
						if (positions.collisionLeft(positions.player2Position) == true)
						{
							positions.moveLeft(positions.player2Position);
							p2Action -= 1;
						}
						else
						{
							
						}
						break;
						
					case 2:
						if (positions.collisionRight(positions.player2Position) == true)
						{
							positions.moveRight(positions.player2Position);
							p2Action -= 1;
						}
						else
						{
							
						}
						break;
					}
					
					break;
				
				case 2:
					if(p2Weapon.inRange(positions.rangeCheck()) == true)
					{
						if (roll20() >= 10)
						{
							double dam = p1.damage(p2Weapon.damage);
							p2Action -= 1;
							info = " Hit!!! player 2 does " + formatter.format(dam) + " damage. player 1 has " + formatter.format(p1.healthPoints) + " left";
							displayinfo = true;
						}
						
						else	
						{
							info = "Miss!!!";
							displayinfo = true;
						}
						
					}
					else
					{
						
					}
					break;
					
				case 3:
					P2Turn = false;
					break;
				}
				
				if (p2Action == 0)
				{
					P2Turn = false;
				}
				
				if (p1.healthPoints <= 0 || p2.healthPoints <= 0)
				{
					break gameloop;
				}
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				if(displayinfo == true)
				{
					System.out.println(info);
					displayinfo = false;
				}
			}
			
			P1Turn = true;
			P2Turn = true;
			if (p1.healthPoints <= 0 || p2.healthPoints <= 0)
			{
				break gameloop;
			}
		}
		
		if (p1.healthPoints <= 0)
		{
			System.out.println("player 2 wins!!!");
		}
		
		else
			System.out.println("player 1 wins!!!");
		
		
		return true;
		
		
	}
	
	static int roll20()
	{
		System.out.println("Press 1 and enter to roll a d20 for a chance to hit");
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int random = (int )(Math.random() * 20 + 1);
		System.out.println("You rolled a " + random);
		return random;
	}
	
	static int roll4()
	{
		int random = (int )(Math.random() * 4 + 1);
		
		return random;
	}
	
	static int roll3()
	{
		System.out.println("Press 1 and enter to roll a d3 for Action Points");
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int random = (int )(Math.random() * 3 + 1);
		System.out.println("You rolled a " + random);
		return random;
	}
	
	
}


