package projectTeam;
/** combatClassTest
 * 
 * @author jaafar
 *
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class combatClassTest {

	@Test
	public void combatClassTest() {
		combatClass obj1 = new combatClass(10, "player", 5);
		assertNotNull(obj1);
	}
	
	@Test
	public void getHealthPointsTest() {
		combatClass obj1 = new combatClass(10, "player", 5);
		assertEquals(10, obj1.getHealthPoints(), 0.1);
	}
	
	@Test
	public void setHealthPointsTest() {
		combatClass obj1 = new combatClass(10, "player", 5);
		obj1.setHealthPoints(1);
		assertEquals(1, obj1.getHealthPoints(), 0.1);
	}
	
	@Test
	public void getTypeTest() {
		combatClass obj1 = new combatClass(10, "player", 5);
	
		assertEquals("player", obj1.getType());
	}
	
	@Test
	public void setTypeTest() {
		combatClass obj1 = new combatClass(10, "player", 5);
		obj1.setType("jack");
		assertEquals("jack", obj1.getType());
	}
	
	@Test
	public void getArmorTest() {
		combatClass obj1 = new combatClass(10, "player", 5);
		
		assertEquals(5, obj1.getArmor(),0.1);
	}
	
	@Test
	public void setArmorTest() {
		combatClass obj1 = new combatClass(10, "player", 5);
		obj1.setArmor(9);
		assertEquals(9, obj1.getArmor(),0.1);
	}
	
	@Test
	public void damageTest() {
		combatClass obj1 = new combatClass(15, "player", 5);
		obj1.damage(3);
		assertEquals(0, obj1.getHealthPoints(),0.1);
	}
	
	

	
	
}
