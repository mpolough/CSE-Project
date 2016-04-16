package imperator;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LeaderboardTest {

	@Test
	public void testReader() {
		Leaderboard obj = new Leaderboard();
		try {
			obj.reader();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fail("Not yet implemented");
	}

	@Test
	public void testMonitor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProfile() throws IOException {
		PlayerProfile profile = new PlayerProfile("Bob", "Mage");
		Leaderboard board = new Leaderboard();
		board.addNewProfile(profile);
		board.writer();
		System.out.println("name = ");
		assertEquals(profile, board.getProfile(profile.getPlayerName()));
		
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
	public void testAddNewProfile() {
		fail("Not yet implemented");
	}

}
