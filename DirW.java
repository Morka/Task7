/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class DirW implements Direction {

	public DirW(){
		
		//Construct0r
		
	}

	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field straight ahead
	 * 
	 * @return	values to add to the current position to get the coordinates of the field ahead
	 */
	public int[] moveStraight() {
		//Postcondition: returns int array with values either 0 or 1
		
		return new int[]{-1, 0};
		
	}
	
	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field to the left
	 * 
	 * @return	values to add to the current position to get the coordinates of the field to the left
	 */
	public int[] moveLeft() {
		//Postcondition: returns int array with values either 0 or 1
		
		return new int[]{0, -1};
		
	}
	
	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field to the right
	 * 
	 * @return	values to add to the current position to get the coordinates of the field to the right
	 */
	public int[] moveRight() {
		//Postcondition: returns int array with values either 0 or 1
		
		return new int[]{0, 1};
		
	}
	
	/**
	 * Turns the Car to the left and returns the south direction
	 * 
	 * @return	DirS() - the south direction
	 */
	public Direction turnLeft() {
		//Postcondition: returns DirS() != null;
		
		return new DirS();
	}
	
	/**
	 * Turns the Car to the right and returns the north direction
	 * 
	 * @return	DirN() - the north direction
	 */
	public Direction turnRight() {
		//Postcondition: returns DirN() != null;

		return new DirN();
		
	}
	
	/**
	 * Calls opposedToDirW() in direction to check whether the parameter direction is opposed to the current direction
	 * 
	 * @param direction	the direction that should be checked if it is opposing
	 * @return	true if this is opposing to direction else false
	 */
	public boolean opposedTo(Direction direction){
		//Precondition: direction != null;
		
		return direction.opposedToDirW();
	}
	
	/**
	 * Returns true because it is opposed to east
	 * 
	 * @return	true 
	 */
	public boolean opposedToDirE(){
		return true;
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