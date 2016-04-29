package imperator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;




public class BattlefieldTest {

	@Test
	public void testBattlefield() {
		Battlefield field = new Battlefield();
		assertNotNull(field);
	}
	@Test
	public void testeBattlefieldSetSize()
	{
		Battlefield field = new Battlefield(15);
		assertNotNull(field);
	}
	@Test
	public void testInitializeFloor() 
	{
		String [] expectedOut = {"-","-","-","-","-","-","-","-","-","-","-","-"};
		Battlefield field = new Battlefield();
		field.initializeFloor();
		Assert.assertArrayEquals(expectedOut,field.base);
	}
	@Test
	public void testInitializeFloorSetSize() 
	{
		String [] expectedOut = {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"};
		Battlefield field = new Battlefield(15);
		field.initializeFloor();
		Assert.assertArrayEquals(expectedOut,field.base);
	}
	@Test
	public void testInitializePlayerFloor() 
	{
		String [] expectedOut = {"|","1"," "," "," "," "," "," "," "," ","2","|"};
		Battlefield field = new Battlefield();
		field.initializePlayerFloor();
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testInitializePlayerFloorSetSize() 
	{
		String [] expectedOut = {"|","1"," "," "," "," "," "," "," "," "," "," "," "," "," ","2","|"};
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor();
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testMoveLeft() 
	{
		String [] expectedOut = {"|","1"," "," "," "," "," "," "," ","2"," ","|",};
		Battlefield field = new Battlefield();
		field.initializePlayerFloor();
		field.moveLeft(10);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testMoveLeftSetSize() 
	{
		String [] expectedOut = {"|","1"," "," "," "," "," "," "," "," "," "," "," "," ","2"," ","|"};
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor();
		field.moveLeft(15);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testmoveRight()
	{
		String [] expectedOut = {"|"," ","1"," "," "," "," "," "," "," ","2","|",};
		Battlefield field = new Battlefield();
		field.initializePlayerFloor();
		field.moveRight(1);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testMoveRightSetSize() 
	{
		String [] expectedOut = {"|"," ","1"," "," "," "," "," "," "," "," "," "," "," "," ","2","|"};
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor();
		field.moveRight(1);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testCollisionLeft()
	{
		Battlefield field = new Battlefield();
		field.initializePlayerFloor();
		assertFalse("Collision detected",field.collisionLeft(1));
	}
	@Test
	public void testcollisionLeftSetSize()
	{
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor();
		assertTrue("No Collision detected",field.collisionLeft(15));
	}
	@Test
	public void testCollisionRight()
	{
		Battlefield field = new Battlefield();
		field.initializePlayerFloor();
		assertTrue("No Collision detected",field.collisionRight(1));	
	}
	@Test
	public void testCollisionRightSetSize()
	{
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor();
		assertFalse("Collision detected",field.collisionRight(15));	
	}
	@Test
	public void testRangeCheck()
	{
		Battlefield field = new Battlefield();
		field.initializePlayerFloor();
		assertEquals(9,field.rangeCheck());
	}
	@Test
	public void testRangeCheckSetSize(){
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor();
		field.moveLeft(15);
		field.moveLeft(14);
		assertEquals(12,field.rangeCheck());
	}
}