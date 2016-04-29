package GameProject;

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
	public void testInitializePlayerFloorSetPosition()
	{
		String [] expectedOut = {"|"," "," "," "," ","1","2"," "," "," "," ","|"};
		Battlefield field = new Battlefield();
		field.initializePlayerFloor(5,6);
		Assert.assertArrayEquals(expectedOut,field.playerBase);		
	}
	@Test
	public void testInitializePlayerFloorSetPositionSetSize()
	{
		String [] expectedOut = {"|"," "," "," "," ","1"," "," "," "," ","2"," "," "," "," "," ","|"};
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor(5,10);
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
	public void testMoveLeftSetSizeSetPosition() 
	{
		String [] expectedOut = {"|"," "," "," "," "," "," "," "," "," ","1","2"," "," "," "," "," "," "," "," "," ","|"};
		Battlefield field = new Battlefield(20);
		field.initializePlayerFloor(10,11);
		if(field.collisionLeft(11))
			field.moveLeft(11);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testMoveLeftTwo()
	{
		String [] expectedOut = {"|","1"," "," "," "," "," "," ","2"," "," ","|",};
		Battlefield field = new Battlefield();
		field.initializePlayerFloor();
		if(field.collisionLeft(10))
			field.moveLeftTwo(10);
		Assert.assertArrayEquals(expectedOut,field.playerBase);		
	}
	@Test
	public void testMoveLeftTwoSetSize()
	{
		String [] expectedOut = {"|","1"," "," "," "," "," "," "," "," "," ","2"," "," "," "," ","|"};
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor();
		if(field.collisionLeft(15))
			field.moveLeftTwo(15);
		if(field.collisionLeft(13))
			field.moveLeftTwo(13);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testMoveLeftTwoSetSizeSetPosition()
	{
		String [] expectedOut = {"|","1"," "," ","2"," "," "," "," "," "," "," "," "," "," "," "," "," ","|"};
		Battlefield field = new Battlefield(17);
		field.initializePlayerFloor(3,4);
		if(field.collisionLeft(3))
			field.moveLeftTwo(3);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testMoveRight()
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
	public void testMoveRightSetSizeSetPosition() 
	{
		String [] expectedOut = {"|"," "," "," "," "," "," "," "," "," "," "," ","1"," ","2"," ","|"};
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor(12,13);
		field.moveRight(13);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testMoveRightTwo()
	{
		String [] expectedOut = {"|"," "," ","1"," "," "," "," "," "," ","2","|",};
		Battlefield field = new Battlefield();
		field.initializePlayerFloor();
		if(field.collisionRight(1))
			field.moveRightTwo(1);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testMoveRightTwoSetSize() 
	{
		String [] expectedOut = {"|"," "," ","1"," "," "," "," "," "," "," "," "," "," "," ","2","|"};
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor();
		if(field.collisionRight(1))
			field.moveRightTwo(1);
		if(field.collisionRight(15))
			field.moveRight(15);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testMoveRightTwoSetSizeSetPosition() 
	{
		String [] expectedOut = {"|"," ","1"," "," ","2"," "," "," ","|"};
		Battlefield field = new Battlefield(8);
		field.initializePlayerFloor(2,3);
		if(field.collisionRight(3))
			field.moveRightTwo(3);
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
	public void testcollisionLeftSetSizeSetPosition()
	{
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor(12,13);
		assertTrue("No Collision detected",field.collisionLeft(12));
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
	public void testCollisionRightSetSizeSetPosition()
	{
		Battlefield field = new Battlefield(30);
		field.initializePlayerFloor(25,26);
		assertFalse("Collision detected",field.collisionRight(25));	
	}
	@Test
	public void testMoveFront()
	{
		String [] expectedOut = {"|"," "," "," "," "," "," "," "," ","1","2","|",};
		Battlefield field = new Battlefield();
		field.initializePlayerFloor();
		field.moveFront(1,10);
		Assert.assertArrayEquals(expectedOut,field.playerBase);	
	}
	@Test
	public void testMoveFrontSetSize()
	{
		String [] expectedOut = {"|","1","2"," "," "," "," "," "," "," "," "," "," "," "," "," ","|"};
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor();
		field.moveFront(15,1);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testMoveFrontSetSizeSetPosition()
	{
		String [] expectedOut = {"|"," ","1","2"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"};
		Battlefield field = new Battlefield(20);
		field.initializePlayerFloor(2,19);
		field.moveFront(19,2);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testPushBack()
	{
		String [] expectedOut = {"|"," "," "," "," ","1"," "," "," ","2"," ","|",};
		Battlefield field = new Battlefield();
		field.initializePlayerFloor(5,6);
		field.pushBack(6);
		Assert.assertArrayEquals(expectedOut,field.playerBase);	
	}
	@Test
	public void testPushBackSetSize()
	{
		String [] expectedOut = {"|","1","2"," "," "," "," "," "," "," "," "," "," "," "," "," ","|"};
		Battlefield field = new Battlefield(15);
		field.initializePlayerFloor(1,2);
		field.pushBack(1);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
	}
	@Test
	public void testPushBackSetSizeSetPosition()
	{
		String [] expectedOut = {"|"," "," "," "," "," "," "," "," "," "," "," "," ","1"," "," "," ","2"," "," "," "," "," "," "," "," ","|"};
		Battlefield field = new Battlefield(25);
		field.initializePlayerFloor(16,17);
		field.pushBack(16);
		Assert.assertArrayEquals(expectedOut,field.playerBase);
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


