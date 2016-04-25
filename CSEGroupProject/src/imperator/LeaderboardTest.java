package imperator;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LeaderboardTest {

	@Test
	public void testReader() throws IOException {
		PlayerProfile profile = new PlayerProfile("Joe", "Mage");
		Leaderboard board = new Leaderboard();
		board.addNewProfile(profile);
		board.writer();
		board.reader();
		assertEquals(profile, board.getProfile(profile.getPlayerName()));
	}

	@Test
	public void testMonitor() {
		PlayerProfile profile1 = new PlayerProfile();
		PlayerProfile profile2 = new PlayerProfile();
		Leaderboard board = new Leaderboard();
		board.addNewProfile(profile1);
		board.addNewProfile(profile2);
		board.monitor(profile1, profile2);
		assertEquals(board.getIndexP1(), 0);
		assertEquals(board.getIndexP2(), 1);
	}

	@Test
	public void testGetProfile() throws IOException {
		PlayerProfile profile = new PlayerProfile("Bob", "Mage");

		PlayerProfile profile2 = new PlayerProfile("Smith", "Warrior");
		
		Leaderboard board = new Leaderboard();
		board.addNewProfile(profile);
		board.addNewProfile(profile2);
		board.writer();
		assertEquals(profile, board.getProfile(profile.getPlayerName()));
		assertEquals(profile2, board.getProfile(profile2.getPlayerName()));
		
	}

	@Test
	public void testUpdate() throws IOException {
		PlayerProfile player1 = new PlayerProfile("Joe", "Mage");
		PlayerProfile player2 = new PlayerProfile("John", "Rogue");
		Leaderboard board = new Leaderboard();
		board.addNewProfile(player1);
		board.addNewProfile(player2);
		board.monitor(player1, player2);
		player1.setGamesPlayed(1);
		player2.setGamesPlayed(1);
		board.update(player1, player2);
		player1 = board.getProfile("Joe");
		player2 = board.getProfile("John");
		assertEquals(player1.getGamesPlayed(), 1);
		assertEquals(player2.getGamesPlayed(), 1);
	}

	@Test
	public void testToString() {
		PlayerProfile player1 = new PlayerProfile("Jack", "Warrior");
		Leaderboard board = new Leaderboard();
		board.addNewProfile(player1);
		assertEquals("Jack	Warrior	0	0	0.0	0.0	0\n", board.toString());
	}

	@Test
	public void testWriter() throws IOException {
		PlayerProfile profile = new PlayerProfile("Joe", "Mage");
		Leaderboard board = new Leaderboard();
		board.addNewProfile(profile);
		board.writer();
		board.reader();
		assertEquals(profile, board.getProfile(profile.getPlayerName()));
	}

	@Test
	public void testAddNewProfile() throws IOException {
		//Writer works but writer isn't working with this specific test.
		PlayerProfile profile = new PlayerProfile("Joe", "Rogue");
		Leaderboard board = new Leaderboard();
		board.addNewProfile(profile);
		board.writer();
		assertEquals(profile, board.getProfile(profile.getPlayerName()));
	}
	
	@Test
	public void testSortName() throws IOException {
		PlayerProfile player1 = new PlayerProfile("Jim", "Mage", 1, 1, 1.0, 1.0, 1);
		PlayerProfile player2 = new PlayerProfile("Xander", "Rogue", 2 , 2, 2.5, 2.5, 2);
		PlayerProfile player3 = new PlayerProfile("Allison", "Warrior", 3, 3, 2.6, 2.6, 3);
		
		Leaderboard board = new Leaderboard();
		board.addNewProfile(player1);
		board.addNewProfile(player2);
		board.addNewProfile(player3);
		
		board.sort("name");
		String testString = "Xander	Rogue	2	2	2.5	2.5	2"
				+ "\nJim	Mage	1	1	1.0	1.0	1"
				+ "\nAllison	Warrior	3	3	2.6	2.6	3\n";
		assertEquals(testString,board.toString());
	}
	
	@Test
	public void testSortClass() throws IOException {
		PlayerProfile player1 = new PlayerProfile("Jim", "Mage", 1, 1, 1.0, 1.0, 1);
		PlayerProfile player2 = new PlayerProfile("Xander", "Rogue", 2 , 2, 2.5, 2.5, 2);
		PlayerProfile player3 = new PlayerProfile("Allison", "Warrior", 3, 3, 2.6, 2.6, 3);
		
		Leaderboard board = new Leaderboard();
		board.addNewProfile(player1);
		board.addNewProfile(player2);
		board.addNewProfile(player3);
		
		board.sort("class");
		String testString = "Allison	Warrior	3	3	2.6	2.6	3"
				+ "\nXander	Rogue	2	2	2.5	2.5	2"
				+ "\nJim	Mage	1	1	1.0	1.0	1\n";
		assertEquals(testString,board.toString());
	}
	
	@Test
	public void testSortKills() throws IOException {
		PlayerProfile player2 = new PlayerProfile("Xander", "Rogue", 2 , 2, 2.5, 2.5, 2);
		PlayerProfile player3 = new PlayerProfile("Allison", "Warrior", 3, 3, 2.6, 2.6, 3);
		PlayerProfile player1 = new PlayerProfile("Jim", "Mage", 1, 1, 1.0, 1.0, 1);
		
		Leaderboard board = new Leaderboard();
		board.addNewProfile(player1);
		board.addNewProfile(player2);
		board.addNewProfile(player3);
		
		board.sort("numKills");
		String testString = "Allison	Warrior	3	3	2.6	2.6	3"
				+ "\nXander	Rogue	2	2	2.5	2.5	2"
				+ "\nJim	Mage	1	1	1.0	1.0	1\n";
		assertEquals(testString,board.toString());
	}
	
	@Test
	public void testSortDeaths() throws IOException {
		PlayerProfile player2 = new PlayerProfile("Xander", "Rogue", 2 , 2, 2.5, 2.5, 2);
		PlayerProfile player3 = new PlayerProfile("Allison", "Warrior", 3, 3, 2.6, 2.6, 3);
		PlayerProfile player1 = new PlayerProfile("Jim", "Mage", 1, 1, 1.0, 1.0, 1);
		
		Leaderboard board = new Leaderboard();
		board.addNewProfile(player1);
		board.addNewProfile(player2);
		board.addNewProfile(player3);
		
		board.sort("numDeaths");
		String testString = "Allison	Warrior	3	3	2.6	2.6	3"
				+ "\nXander	Rogue	2	2	2.5	2.5	2"
				+ "\nJim	Mage	1	1	1.0	1.0	1\n";
		assertEquals(testString,board.toString());
	}
	
	@Test
	public void testSortMoves() throws IOException {
		PlayerProfile player2 = new PlayerProfile("Xander", "Rogue", 2 , 2, 2.5, 2.5, 2);
		PlayerProfile player3 = new PlayerProfile("Allison", "Warrior", 3, 3, 2.6, 2.6, 3);
		PlayerProfile player1 = new PlayerProfile("Jim", "Mage", 1, 1, 1.0, 1.0, 1);
		
		Leaderboard board = new Leaderboard();
		board.addNewProfile(player1);
		board.addNewProfile(player2);
		board.addNewProfile(player3);
		
		board.sort("movesPerGame");
		String testString = "Allison	Warrior	3	3	2.6	2.6	3"
				+ "\nXander	Rogue	2	2	2.5	2.5	2"
				+ "\nJim	Mage	1	1	1.0	1.0	1\n";
		assertEquals(testString,board.toString());
	}
	
	@Test
	public void testSortDamage() throws IOException {
		PlayerProfile player2 = new PlayerProfile("Xander", "Rogue", 2 , 2, 2.5, 2.5, 2);
		PlayerProfile player3 = new PlayerProfile("Allison", "Warrior", 3, 3, 2.6, 2.6, 3);
		PlayerProfile player1 = new PlayerProfile("Jim", "Mage", 1, 1, 1.0, 1.0, 1);
		
		Leaderboard board = new Leaderboard();
		board.addNewProfile(player1);
		board.addNewProfile(player2);
		board.addNewProfile(player3);
		
		board.sort("damagePerGame");
		String testString = "Allison	Warrior	3	3	2.6	2.6	3"
				+ "\nXander	Rogue	2	2	2.5	2.5	2"
				+ "\nJim	Mage	1	1	1.0	1.0	1\n";
		assertEquals(testString,board.toString());
	}
	
	@Test
	public void testSortGamesPlayed() throws IOException {
		PlayerProfile player2 = new PlayerProfile("Xander", "Rogue", 2 , 2, 2.5, 2.5, 2);
		PlayerProfile player3 = new PlayerProfile("Allison", "Warrior", 3, 3, 2.6, 2.6, 3);
		PlayerProfile player1 = new PlayerProfile("Jim", "Mage", 1, 1, 1.0, 1.0, 1);
		
		Leaderboard board = new Leaderboard();
		board.addNewProfile(player1);
		board.addNewProfile(player2);
		board.addNewProfile(player3);
		
		board.sort("gamesPlayed");
		String testString = "Allison	Warrior	3	3	2.6	2.6	3"
				+ "\nXander	Rogue	2	2	2.5	2.5	2"
				+ "\nJim	Mage	1	1	1.0	1.0	1\n";
		assertEquals(testString,board.toString());
	}
	
	@Test
	public void testSortBadFieldError() throws IOException {
		PlayerProfile player2 = new PlayerProfile("Xander", "Rogue", 2 , 2, 2.5, 2.5, 2);
		PlayerProfile player3 = new PlayerProfile("Allison", "Warrior", 3, 3, 2.6, 2.6, 3);
		PlayerProfile player1 = new PlayerProfile("Jim", "Mage", 1, 1, 1.0, 1.0, 1);
		
		Leaderboard board = new Leaderboard();
		board.addNewProfile(player1);
		board.addNewProfile(player2);
		board.addNewProfile(player3);
		
		board.sort("invalidField");
		String testString = "Jim	Mage	1	1	1.0	1.0	1"
				+ "\nXander	Rogue	2	2	2.5	2.5	2"
				+ "\nAllison	Warrior	3	3	2.6	2.6	3\n";
		assertEquals(testString,board.toString()); //test passes because the field is unsorted w/
												   //error message passed to console.
	}

}
