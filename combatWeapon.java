package projectTeam;
/** combatWeapon
 * 
 * @author jaafar
 *
 */
public class combatWeapon {
	private double damage;
	private String name;
	private double minRange;
	private double maxRange;
	
	/** combatWeapon is the constructor of the combatWeapon class
	 * 
	 * @param newDamage
	 * @param weaponName
	 * @param min
	 * @param max
	 */
	public combatWeapon(double newDamage, String weaponName, double min, double max){
		damage = newDamage; // dam was changed to newDamage
		name = weaponName;
		minRange = min;
		maxRange = max;
	}
	
	
	/** getDamage returns the damage of the character
	 * 
	 * @return damage
	 */
	public double getDamage(){
		return damage;
	}
	
	
	/**	setDamage sets the damage of the weapon
	 * 
	 * @param newDamage
	 */
	public void setDamage(double newDamage){
		damage = newDamage;
	}
	
	
	/** getName returns the name of the weapon
	 * 
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/** setName sets the name of the weapon
	 * 
	 * @param newName
	 */
	public void setName(String newName){
		name = newName;
	}
	
	/** getMinRange returns the minimum range of the weapon
	 * 
	 * @return minRange
	 */
	public double getMinRange(){
		return minRange;
	}
	
	/** setMinRange sets the minimum range of the weapon
	 * 
	 * @param newMinRange
	 */
	public void setMinRange(double newMinRange){
		minRange = newMinRange;
	}
	
	
	/** getMaxRange returns the max range of the weapon
	 * 
	 * @return maxRange
	 */
	public double getMaxRange(){
		return maxRange;
	}
	
	
	/** setMaxRange sets the minimum range of the weapon
	 * 
	 * @param newMaxRange
	 */
	public void setMaxRange(double newMaxRange){
		maxRange = newMaxRange;
	}
	
	/**	inRange checks if the distance of the weapon is in range 
	 * 
	 * @param distance
	 * @return result
	 */
	public boolean inRange(double distance){
		boolean result;
		if ( (maxRange >= distance) && (distance >= minRange) ){
			result = true; 
		}
		else {
			System.out.println("Target is not in range!");
			result = false;
		}
		return result;
	}
	
	public static void main (String[]args){
		combatWeapon obj1 = new combatWeapon(2, "knife", 1, 3);
		System.out.println(obj1.getDamage());
	}

}
