package imperator;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerProfileTest {

	@Test
	public void testPlayerProfile() {
		PlayerProfile profile = new PlayerProfile();
		assertEquals("NULL", profile.getPlayerName());
		assertEquals(0, profile.getNumKills());
		assertEquals(0, profile.getNumDeaths());
		assertEquals(0.0, profile.getMovesPerGame(), 0);
		assertEquals(0.0, profile.getDamageDonePerGame(), 0);
		assertEquals(0, profile.getGamesPlayed());	
	}

	@Test
	public void testPlayerProfileStringString() {
		PlayerProfile profile = new PlayerProfile("Name");
		assertEquals("Name", profile.getPlayerName());
		assertEquals(0, profile.getNumKills());
		assertEquals(0, profile.getNumDeaths());
		assertEquals(0.0, profile.getMovesPerGame(), 0);
		assertEquals(0.0, profile.getDamageDonePerGame(), 0);
		assertEquals(0, profile.getGamesPlayed());	
	}

	@Test
	public void testGetPlayerName() {
		PlayerProfile profile = new PlayerProfile("Name");
		assertEquals("Name", profile.getPlayerName());	
	}

	@Test
	public void testSetPlayerName() {
		PlayerProfile profile = new PlayerProfile("Name");
		profile.setPlayerName("Test");
		assertEquals("Test", profile.getPlayerName());	
	}

	@Test
	public void testGetNumKills() {
		PlayerProfile profile = new PlayerProfile("Name");
		assertEquals(0, profile.getNumKills());
	}

	@Test
	public void testSetNumKills() {
		PlayerProfile profile = new PlayerProfile("Name");
		profile.setNumKills(1);
		assertEquals(1, profile.getNumKills());
	}

	@Test
	public void testGetNumDeaths() {
		PlayerProfile profile = new PlayerProfile("Name");
		assertEquals(0, profile.getNumDeaths());
	}

	@Test
	public void testSetNumDeaths() {
		PlayerProfile profile = new PlayerProfile("Name");
		profile.setNumDeaths(1);
		assertEquals(1, profile.getNumDeaths());	}

	@Test
	public void testGetMovesPerGame() {
		PlayerProfile profile = new PlayerProfile("Name");
		assertEquals(0.0, profile.getMovesPerGame(), 0);
	}

	@Test
	public void testSetMovesPerGame() {
		PlayerProfile profile = new PlayerProfile("Name");
		profile.setMovesPerGame(1.0);
		assertEquals(1.0, profile.getMovesPerGame(), 0);
	}

	@Test
	public void testGetDamageDonePerGame() {
		PlayerProfile profile = new PlayerProfile("Name");
		assertEquals(0.0, profile.getDamageDonePerGame(),0);
	}

	@Test
	public void testSetDamageDonePerGame() {
		PlayerProfile profile = new PlayerProfile("Name");
		profile.setDamageDonePerGame(1.0);
		assertEquals(1.0, profile.getDamageDonePerGame(), 0);
	}

	@Test
	public void testGetGamesPlayed() {
		PlayerProfile profile = new PlayerProfile("Name");
		assertEquals(0, profile.getGamesPlayed());
	}

	@Test
	public void testSetGamesPlayed() {
		PlayerProfile profile = new PlayerProfile("Name");
		profile.setGamesPlayed(1);
		assertEquals(1, profile.getGamesPlayed());
	}

}
