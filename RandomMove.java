import java.util.Random;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class RandomMove implements MoveAlgorithm {

	private int width, height;

	public RandomMove(int width, int height){
		
		this.width = width;
		this.height = height;
		
	}

	@Override
	public int[] fastCarMove(int x, int y, Direction direction, Car movingCar) {
		
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

	@Override
	public int[] agileCarMove(int x, int y, Direction direction, Car movingCar) {

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