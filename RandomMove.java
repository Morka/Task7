import java.util.Random;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class RandomMove implements MoveAlgorithm {

	//Invariant: -1 < width < 2147483647; -1 < height < 2147483647
	private int width, height;

	/**
	 * Constructor which sets the width and height of the map for the algorithm
	 * 
	 * @param width	width of the map
	 * @param height	height of the map
	 */
	public RandomMove(int width, int height){
		//Precondition: -1 < width < 2147483647; -1 < height < 2147483647
		//Postcondition: width and height of the map are set for the object
		
		this.width = width;
		this.height = height;
		
	}

	/**
	 * Calculates the coordinates of the next Field of the map for fast moving cars. Cars will move in a random path.
	 * 
	 * @param x	current x position on the map
	 * @param y	current y position on the map
	 * @param direction	the direction in which the car is pointing
	 * @param movingCar	the car that wants to move
	 * @return	int array with x and y coordinates of the next field
	 */
	public int[] fastCarMove(int x, int y, Direction direction, Car movingCar) {
		//Precondition: direction != null; movingCar != null; x & y are coordinates on the map
		//Postcondition: returns int[] with 2 elements which has coordinates on the map
		
		Random numberGenerator = new Random();
		
		int caseInt = numberGenerator.nextInt(3) + 1;
		
		int returnX, returnY;
		int[] tmpInt;
		
		switch(caseInt) {
		
		case 1: //diagonal left
			tmpInt = direction.moveStraight();
			returnX = x + tmpInt[0];
			returnY = y + tmpInt[1];
			tmpInt = direction.moveLeft();
			returnX = returnX + tmpInt[0];
			returnY = returnY + tmpInt[1];
			movingCar.setDirection(direction.turnLeft());
			
			if(-1 < returnX && returnX < width && -1 < returnY &&  returnY < height){

				return new int[]{returnX, returnY};

			}

			return new int[]{-1, -1};
			
		case 2: //diagonal right
			tmpInt = direction.moveStraight();
			returnX = x + tmpInt[0];
			returnY = y + tmpInt[1];
			tmpInt = direction.moveRight();
			returnX = returnX + tmpInt[0];
			returnY = returnY + tmpInt[1];
			movingCar.setDirection(direction.turnRight());
			
			if(-1 < returnX && returnX < width && -1 < returnY &&  returnY < height){

				return new int[]{returnX, returnY};

			}

			return new int[]{-1, -1};
			
		default: //straight
			tmpInt = direction.moveStraight();
			returnX = x + tmpInt[0];
			returnY = y + tmpInt[1];
			
			if(-1 < returnX && returnX < width && -1 < returnY &&  returnY < height){

				return new int[]{returnX, returnY};

			}

			return new int[]{-1, -1};
		
		
		}
	}

	/**
	 * Calculates the coordinates of the next Field of the map for agile cars. Cars will move in a random path.
	 * 
	 * @param x	current x position on the map
	 * @param y	current y position on the map
	 * @param direction	the direction in which the car is pointing
	 * @param movingCar	the car that wants to move
	 * @return	int array with x and y coordinates of the next field
	 */
	public int[] agileCarMove(int x, int y, Direction direction, Car movingCar) {
		//Precondition: direction != null; movingCar != null; x & y are coordinates on the map
		//Postcondition: returns int[] with 2 elements which has coordinates on the map

		Random numberGenerator = new Random();

		int caseInt = numberGenerator.nextInt(4) + 1;

		int returnX, returnY;
		int[] tmpInt;

		switch(caseInt) {

		case 1: //diagonal left
			tmpInt = direction.moveStraight();
			returnX = x + tmpInt[0];
			returnY = y + tmpInt[1];
			tmpInt = direction.moveLeft();
			returnX = returnX + tmpInt[0];
			returnY = returnY + tmpInt[1];
			movingCar.setDirection(direction.turnLeft());
			
			if(-1 < returnX && returnX < width && -1 < returnY &&  returnY < height){

				return new int[]{returnX, returnY};

			}

			return new int[]{-1, -1};

		case 2: //diagonal right
			tmpInt = direction.moveStraight();
			returnX = x + tmpInt[0];
			returnY = y + tmpInt[1];
			tmpInt = direction.moveRight();
			returnX = returnX + tmpInt[0];
			returnY = returnY + tmpInt[1];
			movingCar.setDirection(direction.turnRight());
			
			if(-1 < returnX && returnX < width && -1 < returnY &&  returnY < height){

				return new int[]{returnX, returnY};

			}

			return new int[]{-1, -1};
			
		case 3: //left
			tmpInt = direction.moveLeft();
			returnX = x + tmpInt[0];
			returnY = y + tmpInt[1];
			movingCar.setDirection(direction.turnLeft());
			
			if(-1 < returnX && returnX < width && -1 < returnY &&  returnY < height){

				return new int[]{returnX, returnY};

			}

			return new int[]{-1, -1};
			
		case 4: //right
			tmpInt = direction.moveRight();
			returnX = x + tmpInt[0];
			returnY = y + tmpInt[1];
			movingCar.setDirection(direction.turnRight());
			
			if(-1 < returnX && returnX < width && -1 < returnY &&  returnY < height){

				return new int[]{returnX, returnY};

			}

			return new int[]{-1, -1};

		default: //straight
			tmpInt = direction.moveStraight();
			returnX = x + tmpInt[0];
			returnY = y + tmpInt[1];
			
			if(-1 < returnX && returnX < width && -1 < returnY &&  returnY < height){

				return new int[]{returnX, returnY};

			}

			return new int[]{-1, -1};


		}
	}

}