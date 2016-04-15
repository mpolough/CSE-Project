package imperator;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Leaderboard works by reading in the text file "leaderboard.txt", with tab delimited fields,  
 * to create a profile object array to store the leaderboard data to be manipulated by the game.
 * At the game end, the game will call update() to update any changes to the leaderboard, and update
 * the text file to store these changes persistently. There is also a print() method that displays the 
 * leaderboard.
 * @author Chris and Fabian
 *
 */
public class Leaderboard {
	
	private ArrayList<PlayerProfile> profileArray = new ArrayList<PlayerProfile>();
	private int indexP1;	//keeps track of the current games player1 array index 
	private int indexP2;	//keeps track of the current games player1 array index 
	
	public void reader() throws IOException{

		int counter = 0;
	
		//if file found, read in all lines, loading one line of data into a profile object, and 
		//create an array of these profile objects
	    try {
	    	FileReader in = new FileReader("leaderboard.txt");	       
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("leaderboard.txt"))));
	    	String s;

	    	while ((s = reader.readLine()) != null){
	    		PlayerProfile tempProfile = new PlayerProfile();
	    		StringTokenizer tk = new StringTokenizer(s);
	    		tempProfile.setPlayerName(tk.nextToken("\t"));
	    		tempProfile.setPlayerClass(tk.nextToken("\t"));
	    		tempProfile.setNumKills(Integer.parseInt(tk.nextToken("\t")));
	    		tempProfile.setNumDeaths(Integer.parseInt(tk.nextToken("\t")));
	    		tempProfile.setMovesPerGame(Double.parseDouble(tk.nextToken("\t")));
	    		tempProfile.setDamageDonePerGame(Double.parseDouble(tk.nextToken("\t")));
	    		tempProfile.setGamesPlayed(Integer.parseInt(tk.nextToken("\t")));
	    		System.out.println(s);

	    		profileArray.add(counter, tempProfile);	//Copies the profile object to the arrayList
	    		counter++;
	    	
			}
	    	in.close();
	    	reader.close();
	    }
	    
		//if the file is not found, create empty file "leaderboard.txt"
	    catch(IOException e){
	    	PrintWriter writer = new PrintWriter("leaderboard.txt", "UTF-8");
			writer.println("Fresh leaderboard");
			writer.close();
	    }
	}
	
//	public PlayerProfile getProfile(){//fetch using player name as string or make and index variable in player 
//		
//	}
	
	/**
	 * Monitor should be called at the game begin, to call an store the index positions of 
	 * the desired player profiles for updating in update().
	 * @param player1 player1's profile object
	 * @param player2 player2's profile object
	 */
	public void monitor(PlayerProfile player1, PlayerProfile player2){
		indexP1 = profileArray.indexOf(player1);
		indexP2 = profileArray.indexOf(player2);
	}
	
	public PlayerProfile getProfile(String playerName){
		int profileIndex = 0;
		for(int index = 0; index <= profileArray.size(); index++){
			PlayerProfile tempProfile = new PlayerProfile();
			tempProfile = profileArray.get(index);
			if(tempProfile.getPlayerName().equals(playerName)){
				profileIndex = index;
			}
		}
		return(profileArray.get(profileIndex));
	}
	
	
	//update the profile object fields for profiles that require updating.
	public void update(PlayerProfile player1, PlayerProfile player2){
		
		if(indexP1 != -1 && indexP2 != -1){
			profileArray.set(indexP1, player1);
			profileArray.set(indexP2, player2);
		}
		else
			System.out.println("Update failed. A player profile was not found.");
	}
	
	//print() method to display the leaderboard. 
	public void print(){
		System.out.println(profileArray.toString());
	}
	
	//write array to leaderboard.txt file
	public void writer() throws IOException{
		File file = new File("leaderboard.txt");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		String leaderboard = "";
		
		for(int index = 0; index < profileArray.size(); index++){
			PlayerProfile tempProfile = profileArray.get(index);
			String name = tempProfile.getPlayerName();
			String playerClass = tempProfile.getPlayerClass();
			int numKills = tempProfile.getNumKills();
			int numDeaths = tempProfile.getNumDeaths();
			double movesPerGame = tempProfile.getMovesPerGame();
			double damageDonePerGame = tempProfile.getDamageDonePerGame();
			int gamesPlayed = tempProfile.getGamesPlayed();
			
			leaderboard += name + "\t" + playerClass + "\t" + numKills + "\t" + numDeaths + "\t" +
					movesPerGame + "\t" + damageDonePerGame + "\t" + gamesPlayed + "\n";
		}
		

		bw.write(leaderboard);
		bw.close();

		System.out.println("Done");
		
	}
	
	public void addNewProfile(PlayerProfile newPlayer){
		profileArray.add(newPlayer);
	}
	
	
	//write sort() methods to sort the profile array on one of the stats, print that sorted array (leaderboard)
	
}
