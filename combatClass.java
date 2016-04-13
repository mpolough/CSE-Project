/** combatClass
 * 
 * @author jaafar
 *
 */
public class combatClass {
	
	private double healthPoints; // hp
	private String type; // type of character
	private double armor;
	
	/** constructor that will set all class variables 
	 * 
	 * @param totalHealthPoints, className, resistance
	 */
	public combatClass(double totalHealthPoints, String className, double resistance){
		healthPoints = totalHealthPoints; // totalHP was changed to totalHealthPoints
		type = className;
		armor = resistance;
	}
	
	
	/**  getHealthPoints shows the health point of the character
	 * 
	 * @return healthPoints
	 */
	public double getHealthPoints(){
		return healthPoints;
	}
	
	
	/**  setHealthPoints sets the health point of the character to the desierd health points
	 * 
	 * @param newHealthPoint
	 */
	public void setHealthPoints(double newHealthPoint){
		healthPoints = newHealthPoint;
	}
	
	
	/**	getType returns the type of the character
	 * 
	 * @return type  the type of the weapon
	 */
	public String getType(){
		return type;
	}
	
	
	/** setType sets the type of the character to the desired type
	 * 
	 * @param newType
	 */
	public void setType(String newType){
		type = newType;
	}
	
	
	/** getArmor returns the amount of armor left for the character
	 * 
	 * @return armor 
	 */
	public double getArmor(){
		return armor;
	}
	
	
	/**	setArmor sets the armor level to the desired armor
	 * 
	 * @param newArmor
	 */
	public void setArmor(double newArmor){
		armor = newArmor;
	}
	
	/** damage will take the amount of damage and will update the characters
	 * 	health points by multiplying the armor by the amount of damage and subtracting 
	 *  that form the health points
	 * 
	 * @param amountOfDamage
	 * @return healthPoints 			new health points
	 */
	public double damage(int amountOfDamage){
		double reducedHealthPoint;
		double armorAmount = getArmor();
		reducedHealthPoint = armorAmount * amountOfDamage;
		
		healthPoints = healthPoints - reducedHealthPoint;
		
		
		return healthPoints;
	}
}
