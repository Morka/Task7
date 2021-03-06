
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class DirS implements Direction {

	public DirS(){
		
		//Construct0r
		
	}

	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field straight ahead
	 * 
	 * @return	values to add to the current position to get the coordinates of the field ahead
	 */
	public int[] moveStraight() {
		//Postcondition: returns int array with values either 0 or 1
		
		return new int[]{0, -1};
		
	}
	
	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field to the left
	 * 
	 * @return	values to add to the current position to get the coordinates of the field to the left
	 */
	public int[] moveLeft() {
		//Postcondition: returns int array with values either 0 or 1
		
		return new int[]{1, 0};
		
	}
	
	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field to the right
	 * 
	 * @return	values to add to the current position to get the coordinates of the field to the right
	 */
	public int[] moveRight() {
		//Postcondition: returns int array with values either 0 or 1
		
		return new int[]{-1, 0};
		
	}
	
	/**
	 * Turns the Car to the left and returns the east direction
	 * 
	 * @return	DirE() - the east direction
	 */
	public Direction turnLeft() {
		//Postcondition: returns DirE() != null;

		return new DirE();
		
	}
	
	/**
	 * Turns the Car to the right and returns the west direction
	 * 
	 * @return	DirW() - the west direction
	 */
	public Direction turnRight() {
		//Postcondition: returns DirW() != null;
		
		return new DirW();
		
	}
	
	/**
	 * Calls opposedToDirS() in direction to check whether the parameter direction is opposed to the current direction
	 * 
	 * @param direction	the direction that should be checked if it is opposing
	 * @return	true if this is opposing to direction else false
	 */
	public boolean opposedTo(Direction direction){
		//Precondition: direction != null;
		//Postcondition: if direction is opposed to N = true, else false

		return direction.opposedToDirS();
	}
	
	/**
	 * Returns false because it is not opposed to east
	 * 
	 * @return	false 
	 */
	public boolean opposedToDirE(){
		return false;
	}
	
	/**
	 * Returns false because it is not opposed to south
	 * 
	 * @return	false 
	 */
	public boolean opposedToDirS(){
		return false;
	}
	
	/**
	 * Returns true because it is opposed to north
	 * 
	 * @return	true 
	 */
	public boolean opposedToDirN(){
		return true;
	}
	
	/**
	 * Returns false because it is not opposed to west
	 * 
	 * @return	false 
	 */
	public boolean opposedToDirW(){
		return false;
	}
}
	
	
