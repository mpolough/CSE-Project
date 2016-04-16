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

}
