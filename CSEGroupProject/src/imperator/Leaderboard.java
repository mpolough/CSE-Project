package imperator;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Leaderboard {
	public void writer() throws IOException{
		
		
		//try reading file "leaderboard.txt"
//		FileInputStream in = null;
//	    FileOutputStream out = null;
		
		int counter = 0;
		ArrayList<PlayerProfile> profileArray = new ArrayList<PlayerProfile>();
	
	    try {
	    	FileReader in = new FileReader("leaderboard.txt");	       
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("leaderboard.txt"))));
	    	String s;

	    	while ((s = reader.readLine()) != null){
	    		PlayerProfile tempProfile = new PlayerProfile();
	    		StringTokenizer tk = new StringTokenizer(s);
	    		tempProfile.setPlayerName(tk.nextToken("\t"));
//	    		String playerClass = tk.nextToken("\t");
	    		tempProfile.setPlayerClass(tk.nextToken("\t"));
//	    		int numKills = Integer.parseInt(tk.nextToken("\t"));
	    		tempProfile.setNumKills(Integer.parseInt(tk.nextToken("\t")));
//	    		int numDeaths = Integer.parseInt(tk.nextToken("\t"));
	    		tempProfile.setNumDeaths(Integer.parseInt(tk.nextToken("\t")));
//	    		int numMoves = Integer.parseInt(tk.nextToken("\t"));
	    		tempProfile.setNumMoves(Integer.parseInt(tk.nextToken("\t")));
//	    		double movesPerGame = Double.parseDouble(tk.nextToken("\t"));
	    		tempProfile.setMovesPerGame(Double.parseDouble(tk.nextToken("\t")));
//	    		double damageDone = Double.parseDouble(tk.nextToken("\t"));
	    		tempProfile.setDamageDone(Double.parseDouble(tk.nextToken("\t")));
//	    		double damagePerGame = Double.parseDouble(tk.nextToken("\t"));
	    		tempProfile.setDamageDonePerGame(Double.parseDouble(tk.nextToken("\t")));
//	    		int gamesPlayed = Integer.parseInt(tk.nextToken("\t"));
	    		tempProfile.setGamesPlayed(Integer.parseInt(tk.nextToken("\t")));
	    		System.out.println(s);

	    		profileArray.add(counter, tempProfile);
	    		counter++;
	    		
	    		System.out.println(counter + " profiles counted. Name: "+ tempProfile.getGamesPlayed());
				
			}
	    }
	    
	    catch(IOException e){
	    	PrintWriter writer = new PrintWriter("leaderboard.txt", "UTF-8");
			writer.println("Fresh leaderboard");
			writer.close();
	    }
//	    finally {
//	       if (in != null) {
//	          in.close();
//	       }
//	       if (out != null) {
//	          out.close();
//	       }
//	    }
	}
	//if file found, read in all lines, loading one line of data into a profile object, and 
	//create an array of these profile objects
	
	//if the file is not found, create empty file "leaderboard.txt"
	
	//write method update() that will update the profile object fields for profiles that require
	//updates. 
	
	//write a print() method to display the leaderboard. 
	
	//write sort() methods to sort the profile array on one of the stats, print that sorted array (leaderboard)
	
	/* Overall should work as follows: read in the leaderboard text file and create the 
	profile object array. When a game is played the player enters the name of the profile to use, 
	or creates a new profile. If a new profile is created, add a new profile object to array.
	If the player selects an existing profile, keep track of the array position of that profile 
	object for updating at game end.  
	While the game is played, the game will keep track of stats to update. At the end of the game, 
	update() will automatically change the stat fields, and update the text file for later use. 
	*/
}
