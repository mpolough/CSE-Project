package imperator;
import java.util.Comparator;
/**
 * PlayerProfile class to manage the stats, name, and class of created character profile.
 * @author Chris Ward
 * @author Fabian Hanojosa
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
	 * Test/debugging constructor for setting all fields upon creation of object.
	 * @param playerName	Name of test profile.
	 * @param playerClass	Class of test profile.
	 * @param numKills	Some value to set kills to.
	 * @param numDeaths	Some value to set deaths to.
	 * @param moves	Some value to set moves to.
	 * @param damage	Some value to set damage to.
	 * @param gamesPlayed	Some value to set games played to.
	 */
	public PlayerProfile(String playerName, String playerClass, int numKills, int numDeaths, 
			double moves, double damage, int gamesPlayed) {
		this.playerName = playerName;
		this.playerClass = playerClass;
		this.numKills = numKills;
		this.numDeaths = numDeaths;
		this.movesPerGame = moves;
		this.damageDonePerGame = damage;
		this.gamesPlayed = gamesPlayed;
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
	
	//Comparator for sorting player profile objects in ArrayList alphabetically by player name.
    public static Comparator<PlayerProfile> nameComparator = new Comparator<PlayerProfile>(){

	public int compare(PlayerProfile player1, PlayerProfile player2){
	   String playerName1 = player1.getPlayerName().toUpperCase();	//Strings to hold playerNames
	   String playerName2 = player2.getPlayerName().toUpperCase();	

	   return playerName2.compareTo(playerName1);
    }};
    
    //Comparator for sorting player profile objects in ArrayList alphabetically by player class.
    public static Comparator<PlayerProfile> classComparator = new Comparator<PlayerProfile>(){

	public int compare(PlayerProfile player1, PlayerProfile player2){
	   String playerClass1 = player1.getPlayerClass().toUpperCase();//Strings to hold player class
	   String playerClass2 = player2.getPlayerClass().toUpperCase();	

	   return playerClass2.compareTo(playerClass1);
    }};
    
    //Comparator for sorting player profile objects in ArrayList numerically by number of kills.
    public static Comparator<PlayerProfile> killsComparator = new Comparator<PlayerProfile>(){

	public int compare(PlayerProfile player1, PlayerProfile player2){
	   int playerKills1 = player1.getNumKills();//Integers to hold player kills
	   int playerKills2 = player2.getNumKills();	

	   return playerKills2 - playerKills1;
    }};
    
    //Comparator for sorting player profile objects in ArrayList numerically by number of deaths.
    public static Comparator<PlayerProfile> deathsComparator = new Comparator<PlayerProfile>(){

	public int compare(PlayerProfile player1, PlayerProfile player2){
	   int playerDeaths1 = player1.getNumDeaths();//Integers to hold player deaths
	   int playerDeaths2 = player2.getNumDeaths();	

	   return playerDeaths2 - playerDeaths1;
    }};
    
    //Comparator for sorting player profile objects in ArrayList numerically by number of moves per game.
    public static Comparator<PlayerProfile> movesPerGameComparator = new Comparator<PlayerProfile>(){

	public int compare(PlayerProfile player1, PlayerProfile player2){
	   double playerMoves1 = player1.getMovesPerGame();//Doubles to hold player moves.
	   double playerMoves2 = player2.getMovesPerGame();	
	   playerMoves1 *= 10000;//change sigfigs to reduce int cast error in return statement.
	   playerMoves2 *= 10000;

	   return (int) (playerMoves2 - playerMoves1);
    }};

    //Comparator for sorting player profile objects in ArrayList numerically by damage done per game.
    public static Comparator<PlayerProfile> damagePerGameComparator = new Comparator<PlayerProfile>(){

	public int compare(PlayerProfile player1, PlayerProfile player2){
	   double playerDamage1 = player1.getDamageDonePerGame();//Doubles to hold damage done.
	   double playerDamage2 = player2.getDamageDonePerGame();	
	   playerDamage1 *= 10000;//change sigfigs to reduce int cast error in return statement.
	   playerDamage2 *= 10000;

	   return (int) (playerDamage2 - playerDamage1);
    }};
    
    //Comparator for sorting player profile objects in ArrayList numerically by games played.
    public static Comparator<PlayerProfile> numGamesComparator = new Comparator<PlayerProfile>(){

	public int compare(PlayerProfile player1, PlayerProfile player2){
	   int playerGamesPlayed1 = player1.getGamesPlayed();//Integers to hold damage done.
	   int playerGamesPlayed2 = player2.getGamesPlayed();	

	   return playerGamesPlayed2 - playerGamesPlayed1;
    }};
	
}
