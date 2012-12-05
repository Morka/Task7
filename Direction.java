/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public interface Direction {
	
	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field straight ahead
	 * 
	 * @return	values to add to the current position to get the coordinates of the field ahead
	 */
	public int[] moveStraight();
	//Postcondition: returns int array with values either 0 or 1
	
	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field to the left
	 * 
	 * @return	values to add to the current position to get the coordinates of the field to the left
	 */
	public int[] moveLeft();
	//Postcondition: returns int array with values either 0 or 1
	
	/**
	 * Returns the appropriate array with suitable values to calculate the coordinates of the field to the right
	 * 
	 * @return	values to add to the current position to get the coordinates of the field to the right
	 */
	public int[] moveRight();
	//Postcondition: returns int array with values either 0 or 1
	
	/**
	 * Returns the Direction if the car turns to the left
	 * 
	 * @return	Direction of the car after a turn to left
	 */
	public Direction turnLeft();
	//Postcondition: returns Direction after turn to the left
	
	/**
	 * Returns the Direction if the car turns to the right
	 * 
	 * @return	Direction of the car after a turn to right
	 */
	public Direction turnRight();
	//Postcondition: returns Direction after turn to the right
	
	/**
	 * Calls the appropriate opposedToDirX() method the check wether the parameter direction is opposed to the current direction
	 * 
	 * @param direction	the direction that should be checked if it is opposing
	 * @return	true if this is opposing to direction
	 */
	public abstract boolean opposedTo(Direction direction);
	//Precondition: direction != null
	
	/**
	 * Returns true if this is opposed to Direction east
	 * 
	 * @return	true if this is opposing to east
	 */
	public abstract boolean opposedToDirE();
	
	/**
	 * Returns true if this is opposed to Direction west
	 * 
	 * @return	true if this is opposing to west
	 */
	public abstract boolean opposedToDirW();
	
	/**
	 * Returns true if this is opposed to Direction south
	 * 
	 * @return	true if this is opposing to south
	 */
	public abstract boolean opposedToDirS();
	
	/**
	 * Returns true if this is opposed to Direction north
	 * 
	 * @return	true if this is opposing to north
	 */
	public abstract boolean opposedToDirN();

}