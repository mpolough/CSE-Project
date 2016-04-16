package imperator;
/**
 * PlayerProfile class to manage the stats, name, and class of created character profile.
 * @author Chris Ward and Fabian Hanojosa
 *
 */
public class PlayerProfile {

	private String playerName;	//Name of that player character
	private String playerClass;	//Class of the player; warrior, wizard, ranger etc.
	private int numKills;		//Variable to keep track of kills (games won).
	private int numDeaths; 		//Variable to keep track of number of deaths (games lost).
	private double movesPerGame;//Variable to keep track of average num of moves performed for all games.
	private double damageDonePerGame; //Variable to keep track of average damage done over all games. 
	private int gamesPlayed;	//Variable to keep track of total number of games played.


	public PlayerProfile() {
		this.playerName = "NULL";
		this.playerClass = "NULL";
		this.numKills = 0;
		this.numDeaths = 0;
		this.movesPerGame = 0.0;
		this.damageDonePerGame = 0.0;
		this.gamesPlayed = 0;
	}
	
	/**
	 * Game constructor. Initializes name and class to that selected
	 * by the player during the game initialization.
	 * @param playerName name of the player character/profile
	 * @param playerClass class selected by the player for the profile.
	 */
	public PlayerProfile(String playerName, String playerClass) {
		this.playerName = playerName;
		this.playerClass = playerClass;
		this.numKills = 0;
		this.numDeaths = 0;
		this.movesPerGame = 0;
		this.damageDonePerGame = 0;
		this.gamesPlayed = 0;
	}
	
	/**
	 * Getter for variable playerName
	 * @return string playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * Setter for playerName
	 * @param playerName string of new name to be passed
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * Getter for variable playerClass
	 * @return string playerClass
	 */
	public String getPlayerClass() {
		return playerClass;
	}
	
	/**
	 * Setter for variable playerClass
	 * @param playerClass string name of the character class
	 */
	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}
	
	/**
	 * Getter for variable numKills
	 * @return int variable numKills
	 */
	public int getNumKills() {
		return numKills;
	}
	
	/**
	 * Setter for variable numKills
	 * @param numKills int to set numKills to
	 */
	public void setNumKills(int numKills) {
		this.numKills = numKills;
	}
	
	/**
	 * Getter for variable numDeaths
	 * @return int variable numDeaths
	 */
	public int getNumDeaths() {
		return numDeaths;
	}
	
	/**
	 * Setter for numDeaths
	 * @param numDeaths int value to set numDeaths to
	 */
	public void setNumDeaths(int numDeaths) {
		this.numDeaths = numDeaths;
	}
	
	/**
	 * Getter for variable movesPerGame
	 * @return double variable movesPerGame
	 */
	public double getMovesPerGame() {
		return movesPerGame;
	}
	
	/**
	 * Setter for variable movesPerGame;
	 * @param movesPerGame double value to set movesPerGame to
	 */
	public void setMovesPerGame(double movesPerGame) {
		this.movesPerGame = movesPerGame;
	}

	/**
	 * Getter for variable damageDonePerGame
	 * @return double variable damageDonePerGame.
	 */
	public double getDamageDonePerGame() {
		return damageDonePerGame;
	}
	
	/**
	 * Setter for variable damageDonePerGame
	 * @param damageDonePerGame double value to set damageDonePerGame to
	 */
	public void setDamageDonePerGame(double damageDonePerGame) {
		this.damageDonePerGame = damageDonePerGame;
	}
	
	/**
	 * Getter for variable gamesPlayed
	 * @return int variable gamesPlayed
	 */
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	/**
	 * Setter for variable gamesPlayed
	 * @param gamesPlayed int value to set gamesPlayed to
	 */
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	
}
