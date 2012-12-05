/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public interface MoveAlgorithm {
	
	
	/**
	 * Calculates the coordinates of the next Field of the map for fast moving cars.
	 * 
	 * @param x	current x position on the map
	 * @param y	current y position on the map
	 * @param direction	the direction in which the car is pointing
	 * @param movingCar	the car that wants to move
	 * @return	int array with x and y coordinates of the next field
	 */
	public int[] fastCarMove(int x, int y, Direction direction, Car movingCar);
	//Precondition: direction != null; movingCar != null; x & y are coordinates on the map
	//Postcondition: returns int[] with 2 elements which has coordinates on the map
	/**
	 * Calculates the coordinates of the next Field of the map for agile cars.
	 * 
	 * @param x	current x position on the map
	 * @param y	current y position on the map
	 * @param direction	the direction in which the car is pointing
	 * @param movingCar	the car that wants to move
	 * @return	int array with x and y coordinates of the next field
	 */
	public int[] agileCarMove(int x, int y, Direction direction, Car movingCar);
	//Precondition: direction != null; movingCar != null; x & y are coordinates on the map
	//Postcondition: returns int[] with 2 elements which has coordinates on the map
	
	
}