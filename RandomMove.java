import java.util.Random;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class RandomMove implements MoveAlgorithm {

	public RandomMove(){
		
		//Construct0r
		
	}

	@Override
	public int[] fastCarMove(int x, int y, Direction direction, Car movingCar) {
		
		Random numberGenerator = new Random();
		
		int caseInt = numberGenerator.nextInt(3) + 1;
		
		int[] tmpInt;
		
		switch(caseInt) {
		
		case 1: //diagonal left
			tmpInt = direction.moveStraight();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			tmpInt = direction.moveLeft();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			movingCar.setDirection(direction.turnLeft());
			return new int[]{x, y};
			
		case 2: //diagonal right
			tmpInt = direction.moveStraight();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			tmpInt = direction.moveRight();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			movingCar.setDirection(direction.turnRight());
			return new int[]{x, y};
			
		default: //straight
			tmpInt = direction.moveStraight();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			return new int[]{x, y};
		
		
		}
	}

	@Override
	public int[] agileCarMove(int x, int y, Direction direction, Car movingCar) {

		Random numberGenerator = new Random();

		int caseInt = numberGenerator.nextInt(3) + 1;

		int[] tmpInt;

		switch(caseInt) {

		case 1: //diagonal left
			tmpInt = direction.moveStraight();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			tmpInt = direction.moveLeft();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			movingCar.setDirection(direction.turnLeft());
			return new int[]{x, y};

		case 2: //diagonal right
			tmpInt = direction.moveStraight();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			tmpInt = direction.moveRight();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			movingCar.setDirection(direction.turnRight());
			return new int[]{x, y};
			
		case 3: //left
			tmpInt = direction.moveLeft();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			movingCar.setDirection(direction.turnLeft());
			return new int[]{x, y};
			
		case 4: //right
			tmpInt = direction.moveRight();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			movingCar.setDirection(direction.turnRight());
			return new int[]{x, y};

		default: //straight
			tmpInt = direction.moveStraight();
			x = x + tmpInt[0];
			y = y + tmpInt[1];
			return new int[]{x, y};


		}
	}

}