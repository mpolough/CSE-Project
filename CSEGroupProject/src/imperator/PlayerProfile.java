package imperator;

public class PlayerProfile {

	private String playerName;	//Name of that player character
	private String playerClass;	//Class of the player; warrior, wizard, ranger etc.
	private int numKills;		//Variable to keep track of kills (games won).
	private int numDeaths; 		//Variable to keep track of number of deaths (games lost).
	private int numMoves;		//Variable to keep track of number of actions performed in all games by player.
	private double movesPerGame;//Variable to keep track of average num of moves performed for all games.
	private double damageDone; //Variable to keep track of the total damage done for all games.
	private double damageDonePerGame; //Variable to keep track of average damage done over all games. 
	private int gamesPlayed;	//Variable to keep track of total number of games played.



	//Default Constructor. Initializes name and class to NULL and stats to 0.	
	public PlayerProfile() {
		this.playerName = "NULL";
		this.playerClass = "NULL";
		this.numKills = 0;
		this.numDeaths = 0;
		this.numMoves = 0;
		this.movesPerGame = 0;
		this.damageDone = 0;
		this.damageDonePerGame = 0;
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
		this.numMoves = 0;
		this.movesPerGame = 0;
		this.damageDone = 0;
		this.damageDonePerGame = 0;
		this.gamesPlayed = 0;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerClass() {
		return playerClass;
	}
	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}
	public int getNumKills() {
		return numKills;
	}
	public void setNumKills(int numKills) {
		this.numKills = numKills;
	}
	public int getNumDeaths() {
		return numDeaths;
	}
	public void setNumDeaths(int numDeaths) {
		this.numDeaths = numDeaths;
	}
	public int getNumMoves() {
		return numMoves;
	}
	public void setNumMoves(int numMoves) {
		this.numMoves = numMoves;
	}
	public double getMovesPerGame() {
		return movesPerGame;
	}
	public void setMovesPerGame(double movesPerGame) {
		this.movesPerGame = movesPerGame;
	}
	public double getDamageDone() {
		return damageDone;
	}
	public void setDamageDone(double damageDone) {
		this.damageDone = damageDone;
	}
	public double getDamageDonePerGame() {
		return damageDonePerGame;
	}
	public void setDamageDonePerGame(double damageDonePerGame) {
		this.damageDonePerGame = damageDonePerGame;
	}
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	
}
