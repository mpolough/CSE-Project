package imperator;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LeaderboardTest {

	@Test
	public void testReader() {
		Leaderboard obj = new Leaderboard();
//		try {
//			//obj.reader();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		fail("Not yet implemented");
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
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrint() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriter() {
		fail("Not yet implemented");
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
