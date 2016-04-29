package imperator;

/** combatWeaponTest
 * 
 * @author jaafar
 *
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class combatWeaponTest {

	@Test
	public void combatWeaponTest() {
		CombatWeapon obj1 = new CombatWeapon(1, "knife", 1, 3);
		assertNotNull(obj1);
	}
	

	
	@Test
	public void getNameTest() {
		CombatWeapon obj1 = new CombatWeapon(2, "knife", 1, 3);
		assertEquals("knife", obj1.getName() );
	}
	
	@Test
	public void setNameTest() {
		CombatWeapon obj1 = new CombatWeapon(2, "knife", 1, 3);
		obj1.setName("steel");
		assertEquals("steel", obj1.getName() );
	}
	
	@Test
	public void getDamageTest() {
		CombatWeapon obj1 = new CombatWeapon(2, "knife", 1, 3);
		assertEquals(2, obj1.getDamage(),0.1 );
	}
	
	@Test
	public void setDamageTest() {
		CombatWeapon obj1 = new CombatWeapon(2, "knife", 1, 3);
		obj1.setDamage(1.0);
		assertEquals(1, obj1.getDamage(),0.1 );
	}
	
	@Test
	public void getMinRangeTest() {
		CombatWeapon obj1 = new CombatWeapon(2, "knife", 1, 3);
		assertEquals(1, obj1.getMinRange(),0.1 );
	}
	
	@Test
	public void setMinRangeTest() {
		CombatWeapon obj1 = new CombatWeapon(2, "knife", 1, 3);
		obj1.setMinRange(2);
		assertEquals(2, obj1.getMinRange(),0.1 );
	}
	
	
	@Test
	public void getMaxRangeTest() {
		CombatWeapon obj1 = new CombatWeapon(1, "knife", 1, 3);
		assertEquals(3, obj1.getMaxRange(), 0.1 );
	}
	
	@Test
	public void setMaxRangeTest() {
		CombatWeapon obj1 = new CombatWeapon(1, "knife", 1, 3);
		obj1.setMaxRange(4);
		assertEquals(4, obj1.getMaxRange(), 0.1 );
	}
	
	@Test
	public void inRangeTest() {
		CombatWeapon obj1 = new CombatWeapon(2, "knife", 1, 3);
		obj1.setMaxRange(4);
		assertEquals(true,	obj1.inRange(2));
	}
	


}