package imperator;

public class Leaderboard {

	//try reading file "leaderboard.txt"
	
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
