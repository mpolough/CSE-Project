package imperator;

public class PlayerProfile {

	private String playerName;	//Name of that player character
	private String playerClass;	//Class of the player; warrior, wizard, ranger etc.
	private int numKills;		//Variable to keep track of kills (games won).
	private int numDeaths; 		//Variable to keep track of number of deaths (games lost).
	private int numMoves;		//Variable to keep track of number of actions performed in a game by player.
	private double movesPerGame;//Variable to keep track of average num of moves performed for all games.
	private double damageDone; //Variable to keep track of the damge done in ONE game.
	private double damageDonePerGame; //Variable to keep track of average damage done over all games. 
	private int gamesPlayed;	//Variable to keep track of total number of games played.
	
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
