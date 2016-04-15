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
	
	private ArrayList<PlayerProfile> profileArray = new ArrayList<PlayerProfile>(); //arraylist of profile objects
	private int indexP1;	//keeps track of the current games player1 array index 
	private int indexP2;	//keeps track of the current games player1 array index 
	
	/**
	 * Reads in the text file  "leaderboard.txt" data to store into the profileArray PlayerProfile objects.
	 * Creates a new text file named "leaderboard.txt" if one isn't found.
	 * @throws IOException exception handler for improper text file format.
	 * 
	 */
	public void reader() throws IOException{

		int counter = 0;
	
		//if file found, read in all lines, loading one line of data into a profile object, and 
		//create an array of these profile objects
	    try {
	    	FileReader in = new FileReader("leaderboard.txt");	//file reader object creation	       
	    	BufferedReader reader = new BufferedReader
	    			(new InputStreamReader(new FileInputStream(new File("leaderboard.txt")))); //buffered reader object
	    	String tempString; //to initialize the string tokenizer for data reading.

	    	//read the tab separated data line by line and store in profileArry
	    	while ((tempString = reader.readLine()) != null){
	    		PlayerProfile tempProfile = new PlayerProfile();
	    		StringTokenizer tk = new StringTokenizer(tempString);
	    		tempProfile.setPlayerName(tk.nextToken("\t"));
	    		tempProfile.setPlayerClass(tk.nextToken("\t"));
	    		tempProfile.setNumKills(Integer.parseInt(tk.nextToken("\t")));
	    		tempProfile.setNumDeaths(Integer.parseInt(tk.nextToken("\t")));
	    		tempProfile.setMovesPerGame(Double.parseDouble(tk.nextToken("\t")));
	    		tempProfile.setDamageDonePerGame(Double.parseDouble(tk.nextToken("\t")));
	    		tempProfile.setGamesPlayed(Integer.parseInt(tk.nextToken("\t")));
	    		System.out.println(tempString);

	    		profileArray.add(counter, tempProfile);	//Copies the profile object to the arrayList
	    		counter++;
	    	
			}
	    	//close the reader object files.
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
	
	/**
	 * Monitor should be called at the start of the game before any fields of the PlayerProfile
	 * objects are changed, otherwise when update() attempts to find the profile objects in the
	 * profileArray, it will not find them because the fields of the updated PlayerProfile objects will not
	 * match the fields of the PlayerProfile objects stored in the PlayerProfile array. 
	 * @param player1 player1's profile object
	 * @param player2 player2's profile object
	 */
	public void monitor(PlayerProfile player1, PlayerProfile player2){
		indexP1 = profileArray.indexOf(player1);
		indexP2 = profileArray.indexOf(player2);
	}
	
	/**
	 * Returns the player profile specified by the game using the profile's player name.
	 * @param playerName string containing the name of the player profile to be retrieved.
	 * @return returns the playerProfile object to be edited during gameplay.
	 */
	public PlayerProfile getProfile(String playerName){
		int profileIndex = 0;	//variable to store the index in the profileArray of the player profile.
		boolean found = false;  //if found is false at method end, profile not found
		
		//search for the playerProfile, store the index.
		for(int index = 0; index <= profileArray.size(); index++){
			PlayerProfile tempProfile = new PlayerProfile();
			tempProfile = profileArray.get(index);
			if(tempProfile.getPlayerName().equals(playerName)){
				profileIndex = index;
				found = true;
			}
		}
		
		//If profile wasn't found, return null and output error message.
		if(!found){
			System.out.println("Error (getProfile): Profile for " + playerName + " not found.");
			return null;
		}
		
		//If found, return the PlayerProfile object.
		else
			return(profileArray.get(profileIndex));
	}
	
	
	/**
	 * Update the profileArray with the modified PlayerProfile objects.
	 * @param player1 PlayerProfile object for player one being passed by the game.
	 * @param player2 PlayerProfile object for player two being passed by the game.
	 * @throws IOException throws exception for writer() call if write has an IOException
	 */
	public void update(PlayerProfile player1, PlayerProfile player2) throws IOException{
		
		//Check to ensure that the indexes exist and update the profiles.
		if(indexP1 != -1 && indexP2 != -1){
			profileArray.set(indexP1, player1);
			profileArray.set(indexP2, player2);
			writer();
		}
		else
			System.out.println("Update failed. A player profile was not found.");
	}
	
	/**
	 * Print method to display the leaderboard.
	 */
	public void print(){
		System.out.println(profileArray.toString());
	}
	
	/**
	 * Write the array to the text file. Should be called by update().
	 * @throws IOException if the text file is not found.
	 */
	public void writer() throws IOException{
		File file = new File("leaderboard.txt");	//Open the leaderboard.txt file
		FileWriter fw = new FileWriter(file.getAbsoluteFile()); //Create FileWriter object.
		BufferedWriter bw = new BufferedWriter(fw);	//Create BufferedWrtier object.
		String leaderboard = ""; //String to write the profileArray data to. 
		
		//Store the data in the profileArray line by line, fields separated by tabs. 
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
		
		//Write the leaderboard string to the file.
		bw.write(leaderboard);
		bw.close();

		System.out.println("Done");
		
	}
	
	/**
	 * When the game creates a new profile, it should call this method to add the new PlayerProfile object
	 * to the profileArray.
	 * @param newPlayer the PlayerProfile object to be added to the profileArray.
	 */
	public void addNewProfile(PlayerProfile newPlayer){
		profileArray.add(newPlayer);
	}
	
	
	//write sort() methods to sort the profile array on one of the stats, print that sorted array (leaderboard)
	
}
