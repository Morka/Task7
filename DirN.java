/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class DirN implements Direction {

	public DirN(){
		
		//Construct0r
		
	}

	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field straight ahead
	 * 
	 * @return	values to add to the current position to get the coordinates of the field ahead
	 */
	public int[] moveStraight() {
		//Postcondition: returns int array with values either 0 or 1
		
		return new int[]{0, 1};
		
	}
	
	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field to the left
	 * 
	 * @return	values to add to the current position to get the coordinates of the field to the left
	 */
	public int[] moveLeft() {
		//Postcondition: returns int array with values either 0 or 1
		
		return new int[]{-1, 0};
		
	}
	
	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field to the right
	 * 
	 * @return	values to add to the current position to get the coordinates of the field to the right
	 */
	public int[] moveRight() {
		//Postcondition: returns int array with values either 0 or 1
		
		return new int[]{1, 0};
		
	}
	
	/**
	 * Turns the Car to the left and returns the west direction
	 * 
	 * @return	DirW() - the west direction
	 */
	public Direction turnLeft() {
		//Postcondition: returns DirW() != null;

		return new DirW();
	}
	
	/**
	 * Turns the Car to the right and returns the east direction
	 * 
	 * @return	DirE() - the east direction
	 */
	public Direction turnRight() {
		//Postcondition: returns DirE() != null;

		return new DirE();
		
	}
	
	/**
	 * Calls opposedToDirN() in direction to check whether the parameter direction is opposed to the current direction
	 * 
	 * @param direction	the direction that should be checked if it is opposing
	 * @return	true if this is opposing to direction else false
	 */
	public boolean opposedTo(Direction direction){
		//Precondition: direction != null
		
		return direction.opposedToDirN();
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
	 * Returns true because it is opposed to south
	 * 
	 * @return	true 
	 */
	public boolean opposedToDirS(){
		return true;
	}
	
	/**
	 * Returns false because it is not opposed to north
	 * 
	 * @return	false 
	 */
	public boolean opposedToDirN(){
		return false;
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
	