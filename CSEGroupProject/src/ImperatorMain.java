package imperator;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;



public class ImperatorMain 
{
	static Leaderboard board = new Leaderboard();
	static String d1;
	static String d2;
	static int p1moves = 0;
	static int p2moves = 0;
	static int p1damage = 0;
	static int p2damage = 0;
	public static void main(String[] args) throws IOException 
	{
		boolean end = false;
		board.reader();
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
        		d1 = reader.next();
        		if(board.getProfile(d1) != null)
        		{
        			System.out.println("p2 please type in your name: ");
        			d2 = reader.next();
        			if(board.getProfile(d2) != null);
        			{
        				board.monitor(board.getProfile(d1), board.getProfile(d2));
        				end = game();
        				if (end == false)
        				{
        					board.getProfile(d1).setNumDeaths((board.getProfile(d1).getNumDeaths()+1));
        					board.getProfile(d2).setNumKills((board.getProfile(d2).getNumKills()+1));
        					board.getProfile(d1).setGamesPlayed((board.getProfile(d1).getNumDeaths() + board.getProfile(d1).getNumKills()));
        					board.getProfile(d2).setGamesPlayed((board.getProfile(d2).getNumDeaths() + board.getProfile(d2).getNumKills()));
        					board.getProfile(d1).setDamageDonePerGame((board.getProfile(d1).getDamageDonePerGame()*(board.getProfile(d1).getGamesPlayed()-1) + p1damage)/ board.getProfile(d1).getGamesPlayed());
        					board.getProfile(d2).setDamageDonePerGame((board.getProfile(d2).getDamageDonePerGame()*(board.getProfile(d2).getGamesPlayed()-1) + p2damage)/ board.getProfile(d2).getGamesPlayed());
        					board.getProfile(d1).setMovesPerGame((board.getProfile(d1).getMovesPerGame()*(board.getProfile(d1).getGamesPlayed()-1) + p1moves)/board.getProfile(d1).getGamesPlayed());
        					board.getProfile(d2).setMovesPerGame((board.getProfile(d2).getMovesPerGame()*(board.getProfile(d2).getGamesPlayed()-1)  +p2moves)/board.getProfile(d2).getGamesPlayed());
        				}
        				board.update(board.getProfile(d1), board.getProfile(d2));
        				end = false;
        			}
        			
        		}
        		
        			break;
        	case 2:  
        		board.print();
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
		p1moves = 0;
		p2moves = 0;
		p1damage = 0;
		p2damage = 0;
		NumberFormat formatter = new DecimalFormat("#0.00");
		CombatClass p1 = new CombatClass();
		CombatWeapon p1Weapon = new CombatWeapon();
		CombatClass p2 = new CombatClass();
		CombatWeapon p2Weapon = new CombatWeapon();
		Battlefield positions = new Battlefield();
		positions.initializeFloor();
		positions.initializePlayerFloor();
		System.out.println("player 1 choose class and weapon:");
		System.out.println("Mage:");
		System.out.println("Ultimate: Heal 5 hp instantly.");
		System.out.println("hp: 4");
		System.out.println("armor:20%");
		System.out.println("weapons: ");
		System.out.println("1. staff: \t\t\t 2. pyromancy");
		System.out.println("does 6 damage \t\t\t does 8 damage");
		System.out.println("min range: 1 Max range: 6 \t min range: 1 Max range: 4");
		System.out.println();
		System.out.println("rouge:");
		System.out.println("Ultimate: Deal 3 damage to the enemy regardless of distance.");
		System.out.println("hp: 6");
		System.out.println("armor:30%");
		System.out.println("weapons: ");
		System.out.println("3. bow: \t\t\t 4. dagger");
		System.out.println("does 4 damage \t\t\t does 6 damage");
		System.out.println("min range: 1 Max range: 8 \t min range: 1 Max range: 4");
		System.out.println();
		System.out.println("knight:");
		System.out.println("Ultimate: Charge to the position in front of the enemy.");
		System.out.println("hp: 10");
		System.out.println("armor:50%");
		System.out.println("weapons: ");
		System.out.println("5. longsword: \t\t\t 6. Greatsword");
		System.out.println("does 6 damage \t\t\t does 8 damage");
		System.out.println("min range: 1 Max range: 3 \t min range: 1 Max range: 2");
		
		
		
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
    		p1Weapon.setEffect("Burning");
    		p1Weapon.setEffectChance(2.0);
		}
		else if (n == 2)
		{
			p1.setHealthPoints(4);
			p1.setType("Mage");
			p1.setArmor(.2);
    		p1Weapon.setDamage(8);
    		p1Weapon.setName("pyromacy");
    		p1Weapon.setMinRange(1);
    		p1Weapon.setMaxRange(8);
    		p1Weapon.setEffect("Burning");
    		p1Weapon.setEffectChance(4.0);
		}
		
		else if (n == 3)
		{
			p1.setHealthPoints(6);
			p1.setType("Rouge");
			p1.setArmor(.3);
			p1Weapon.setDamage(4);
    		p1Weapon.setName("bow");
    		p1Weapon.setMinRange(1);
    		p1Weapon.setMaxRange(8);
    		p1Weapon.setEffect("Bleeding");
    		p1Weapon.setEffectChance(3.0);
		}
		else if (n == 4)
		{
			p1.setHealthPoints(6);
			p1.setType("Rouge");
			p1.setArmor(.3);
			p1Weapon.setDamage(6);
    		p1Weapon.setName("dagger");
    		p1Weapon.setMinRange(1);
    		p1Weapon.setMaxRange(4);
    		p1Weapon.setEffect("Bleeding");
    		p1Weapon.setEffectChance(5.0);
		}
		else if (n == 5)
		{
			p1.setHealthPoints(10);
			p1.setType("Knight");
			p1.setArmor(.5);
			p1Weapon.setDamage(6);
    		p1Weapon.setName("longsword");
    		p1Weapon.setMinRange(1);
    		p1Weapon.setMaxRange(3);
    		p1Weapon.setEffect("NONE");
    		p1Weapon.setEffectChance(0);
		}
		else
		{
			p1.setHealthPoints(10);
			p1.setType("Knight");
			p1.setArmor(.5);
			p1Weapon.setDamage(8);
    		p1Weapon.setName("Greatsword");
    		p1Weapon.setMinRange(1);
    		p1Weapon.setMaxRange(2);
    		p1Weapon.setEffect("NONE");
    		p1Weapon.setEffectChance(0);
		}
		
		System.out.println("player 2 choose class and weapon:");
		System.out.println("Mage:");
		System.out.println("Ultimate: Heal 5 hp instantly.");
		System.out.println("hp: 4");
		System.out.println("armor:20%");
		System.out.println("weapons: ");
		System.out.println("1. staff: \t\t\t 2. pyromancy");
		System.out.println("does 6 damage \t\t\t does 8 damage");
		System.out.println("min range: 1 Max range: 6 \t min range: 1 Max range: 4");
		System.out.println();
		System.out.println("rouge:");
		System.out.println("Ultimate: Deal 3 damage to the enemy regardless of distance.");
		System.out.println("hp: 6");
		System.out.println("armor:30%");
		System.out.println("weapons: ");
		System.out.println("3. bow: \t\t\t 4. dagger");
		System.out.println("does 4 damage \t\t\t does 6 damage");
		System.out.println("min range: 1 Max range: 8 \t min range: 1 Max range: 4");
		System.out.println();
		System.out.println("knight:");
		System.out.println("Ultimate: Charge to the position in front of the enemy.");
		System.out.println("hp: 10");
		System.out.println("armor:50%");
		System.out.println("weapons: ");
		System.out.println("5. longsword: \t\t\t 6. Greatsword");
		System.out.println("does 6 damage \t\t\t does 8 damage");
		System.out.println("min range: 1 Max range: 3 \t min range: 1 Max range: 2");
		
		
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
    		p2Weapon.setEffect("Burning");
    		p2Weapon.setEffectChance(2.0);
		}
		else if (n == 2)
		{
			p2.setHealthPoints(4);
			p2.setType("Mage");
			p2.setArmor(.2);
    		p2Weapon.setDamage(8);
    		p2Weapon.setName("pyromacy");
    		p2Weapon.setMinRange(1);
    		p2Weapon.setMaxRange(8);
    		p2Weapon.setEffect("Burning");
    		p2Weapon.setEffectChance(4.0);
		}
		
		else if (n == 3)
		{
			p2.setHealthPoints(6);
			p2.setType("Rouge");
			p2.setArmor(.3);
			p2Weapon.setDamage(4);
    		p2Weapon.setName("bow");
    		p2Weapon.setMinRange(1);
    		p2Weapon.setMaxRange(8);
    		p2Weapon.setEffect("Bleeding");
    		p2Weapon.setEffectChance(3.0);
		}
		else if (n == 4)
		{
			p2.setHealthPoints(6);
			p2.setType("Rouge");
			p2.setArmor(.3);
			p2Weapon.setDamage(6);
    		p2Weapon.setName("dagger");
    		p2Weapon.setMinRange(1);
    		p2Weapon.setMaxRange(4);
    		p2Weapon.setEffect("Bleeding");
    		p2Weapon.setEffectChance(5.0);
		}
		else if (n == 5)
		{
			p2.setHealthPoints(10);
			p2.setType("Knight");
			p2.setArmor(.5);
			p2Weapon.setDamage(6);
    		p2Weapon.setName("longsword");
    		p2Weapon.setMinRange(1);
    		p2Weapon.setMaxRange(3);
    		p2Weapon.setEffect("NONE");
    		p2Weapon.setEffectChance(0);
		}
		else
		{
			p2.setHealthPoints(10);
			p2.setType("Knight");
			p2.setArmor(.5);
			p2Weapon.setDamage(8);
    		p2Weapon.setName("Greatsword");
    		p2Weapon.setMinRange(1);
    		p2Weapon.setMaxRange(2);
    		p2Weapon.setEffect("NONE");
    		p2Weapon.setEffectChance(0);
		}
		boolean P1Turn = true;
		boolean P2Turn = true;
		boolean p1Eff = false;
		boolean p2Eff = false;
		
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
				System.out.println();
				System.out.println("player 1 you have " + p1Action + " action(s) left");
				System.out.println("select an option:");
				System.out.println("1. move");
				System.out.println("2. attack");
				System.out.println("3. abstain");
				System.out.println("4. ultimate (10 action points)");
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
							p1moves+=1;
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
							p1moves+=1;
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
							double dam = p2.damage((int) p1Weapon.damage);
							p1Action -= 1;
							p1damage += dam;
							info = "Hit!!! player 1 does " + formatter.format(p1Weapon.damage * p2.getArmor()) + " damage. player 2 has " + formatter.format(p2.healthPoints) + " hp left";
							displayinfo = true;
							if(p1Weapon.checkChance(p1Weapon.getEffectChance())==true)
							{
								System.out.println("plyaer 2 is also now " + p1Weapon.getEffect());
								p2Eff = true;
							}
						}
						
						else
						{
							info = "Miss!!!";
							p1Action -= 1;
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
				case 4:
					if (p1Action > 9)
						{
							p1Action -= 10;
							if(p1.getType() == "Knight")
							{
								positions.moveFront(positions.player1Position, positions.player2Position);
								System.out.println("CHARGE!!! p1 rushes up to p2");
							}
							else if(p1.getType() == "Rouge")
							{
								System.out.println("BULLSEYE!!! p2 is delt 3 damage");
								p2.setHealthPoints(p2.getHealthPoints()-3);
								p1damage += 3;

							}
							else
							{
								System.out.println("Field Alchemy!!! p1 gains 5 health");
								p1.setHealthPoints(p1.getHealthPoints()+5);
							}
						}
					else
						System.out.println("not enough AP");
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
				System.out.println();
				System.out.println("player 2 you have " + p2Action + " action(s) left");
				System.out.println("select an option:");
				System.out.println("1. move");
				System.out.println("2. attack");
				System.out.println("3. abstain");
				System.out.println("4. ultimate (10 action points)");
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
							p2moves +=1;
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
							p2moves +=1;
						}
						else
						{
							System.out.println("Field Alchemy!!! p2 gains 5 health");
							p2.setHealthPoints(p2.getHealthPoints()+5);
						}
						break;
					}
					
					break;
				
				case 2:
					if(p2Weapon.inRange(positions.rangeCheck()) == true)
					{
						if (roll20() >= 10)
						{
							double dam = p1.damage((int) p2Weapon.damage);
							p2Action -= 1;
							p2damage +=dam;
							info = " Hit!!! player 2 does " + formatter.format(p2Weapon.damage * p1.getArmor()) + " damage. player 1 has " + formatter.format(p1.healthPoints) + " hp left";
							displayinfo = true;
						}
						
						else	
						{
							info = "Miss!!!";
							p2Action -= 1;
							displayinfo = true;
						}
						
					}
					else
					{
						info = "Out of Range!";
					}
					break;
					
				case 3:
					P2Turn = false;
					break;
				
				case 4:
					if (p2Action > 9)
						{
							p2Action -= 10;
							if(p2.getType() == "Knight")
							{
								positions.moveFront(positions.player2Position, positions.player1Position);
								System.out.println("CHARGE!!! p2 rushes up to p1");

							}
							else if(p2.getType() == "Rouge")
							{
								System.out.println("BULLSEYE!!! p1 is delt 3 damage");
								p1.setHealthPoints(p1.getHealthPoints()-3);
								p2damage+=3;
							}
							else
							{
								System.out.println("Field Alchemy!!! p2 gains 5 health");
								p2.setHealthPoints(p2.getHealthPoints()+5);
							}
						}
					else
						System.out.println("not enough AP");
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
			return false;
		}
		
		else
		{
			System.out.println("player 1 wins!!!");
			return true;
		}
		
		
		
		
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


