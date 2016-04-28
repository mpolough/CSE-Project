package projectTeam;
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
		combatWeapon obj1 = new combatWeapon(1, "knife", 1, 3);
		assertNotNull(obj1);
	}
	

	
	@Test
	public void getNameTest() {
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		assertEquals("knife", obj1.getName() );
	}
	
	@Test
	public void setNameTest() {
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		obj1.setName("steel");
		assertEquals("steel", obj1.getName() );
	}
	
	@Test
	public void getDamageTest() {
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		assertEquals(2, obj1.getDamage(),0.1 );
	}
	
	@Test
	public void setDamageTest() {
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		obj1.setDamage(1.0);
		assertEquals(1, obj1.getDamage(),0.1 );
	}
	
	@Test
	public void getMinRangeTest() {
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		assertEquals(1, obj1.getMinRange(),0.1 );
	}
	
	@Test
	public void setMinRangeTest() {
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		obj1.setMinRange(2);
		assertEquals(2, obj1.getMinRange(),0.1 );
	}
	
	
	@Test
	public void getMaxRangeTest() {
		combatWeapon obj1 = new combatWeapon(1, "knife", 1, 3);
		assertEquals(3, obj1.getMaxRange(), 0.1 );
	}
	
	@Test
	public void setMaxRangeTest() {
		combatWeapon obj1 = new combatWeapon(1, "knife", 1, 3);
		obj1.setMaxRange(4);
		assertEquals(4, obj1.getMaxRange(), 0.1 );
	}
	
	@Test
	public void inRangeTest() {
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		obj1.setMaxRange(4);
		assertEquals(true,	obj1.inRange(2));
	}
	
	@Test
	public void setEffectTest(){
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		obj1.setEffect("min");
		assertEquals("min",	obj1.getEffect());
	}
	
	@Test
	public void getEffectTest(){
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		obj1.setEffect("max");
		assertEquals("max",	obj1.getEffect());
	}
	
	@Test
	public void setEffectChanceTest(){
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		obj1.setEffectChance(10);
		assertEquals(10, obj1.getEffectChance(),0.1);
	}
	
	@Test
	public void getEffectChanceTest(){
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		obj1.setEffectChance(13);
		assertEquals(13, obj1.getEffectChance(),0.1);
	}
	
	
	@Test
	public void checkChanceTest(){
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		assertEquals(true, obj1.checkChance(1));
	}


}
