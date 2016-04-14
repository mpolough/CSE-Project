package imperator;
import java.io.IOException;
import java.util.Scanner;

public class ImperatorMain 
{

	public static void main(String[] args) throws IOException 
	{
		Leaderboard obj = new Leaderboard();
		obj.writer();
		
		
		
		
		boolean end = false;
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
        System.out.println();
        System.out.println();
        n = reader.nextInt();
        
        	switch (n) 
        	{
        	case 1:  
        		end = game();
        			break;
        	case 2:  
        		System.out.println("Not Implemented yet");
        		System.out.println();
        			break;
        	case 3:  
        		System.out.println("Leaving");
        		end = true;
        			break;
        	}
		}
	}
	
	static boolean game()
	{
		int P1Health = 10;
		int P2Health = 10;
		boolean P1Turn = true;
		boolean P2Turn = true;
		Scanner reader = new Scanner(System.in);
		
		while (P1Health != 0 && P2Health != 0)
		{
			while (P1Turn == true)
			{
				int AC = roll3();
				int x;
				while(AC > 0)
				{
					System.out.println("P1 You have " + AC + " Action Points. Enter an option: ");
					System.out.println("1. Attack (2 damage)");
					System.out.println("2. Move");
					System.out.println("3. Pass");
					System.out.println();
					System.out.println();
					x = reader.nextInt();
						switch (x) 
						{
						case 1:  
							P2Health = P2Health - 2;
							AC -= 1;
							if (P2Health == 0)
			        		{
			        			AC = 0;
			        			break;
			        		}
							System.out.println("P2 health is at: " + P2Health);
							break;
						case 2:  
							System.out.println("Not Implemented yet");
							AC -= 1;
							System.out.println();
							break;
						case 3:  
							System.out.println("Ending turn");
							P1Turn = false;
							AC = 0;
							break;
						}
				}
				P1Turn = false;
			}
			
			while (P2Turn == true && P2Health != 0)
			{

				int AC = roll3();
				int x;
		        while(AC > 0)
		        {
		        	 System.out.println("P2 You have " + AC + " Action Points. Enter an option: ");
				     System.out.println("1. Attack  (2 damage)");
				     System.out.println("2. Move");
				     System.out.println("3. Pass");
			         System.out.println();
			         System.out.println();
				     x = reader.nextInt();
		        	switch (x) 
		        	{
		        	case 1:  
		        		P1Health = P1Health - 2;
		        		AC -= 1;
		        		if (P1Health == 0)
		        		{
		        			AC = 0;
		        			break;
		        		}
		        		System.out.println("P1 health is at: " + P1Health);
		        			break;
		        	case 2:  
		        		System.out.println("Not Implemented yet");
		        		AC -= 1;
		        		System.out.println();
		        			break;
		        	case 3:  
		        		System.out.println("Ending turn");
		        		AC = 0;
		        		P2Turn = false;
		        			break;
		        	}
		        }
		        P2Turn = false;
			}
		P1Turn = true;
		P2Turn = true;
		}
		
		if (P1Health == 0)
			System.out.println("P2 Wins");
		else
			System.out.println("P1 Wins");
		
		return true;
	}
	
	int roll6()
	{
		int random = (int )(Math.random() * 6 + 1);
		
		return random;
	}
	
	int roll4()
	{
		int random = (int )(Math.random() * 4 + 1);
		
		return random;
	}
	
	static int roll3()
	{
		int random = (int )(Math.random() * 3 + 1);
		
		return random;
	}
	
	
}


