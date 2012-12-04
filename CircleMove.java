/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class CircleMove implements MoveAlgorithm {

	public CircleMove(){
		
		//Construct0r
		
	}

	@Override
	public int[] fastCarMove(int x, int y, Direction direction, Car movingCar) {

		int[] tmpInt = direction.moveStraight();
		x = x + tmpInt[0];
		y = y + tmpInt[1];
		tmpInt = direction.moveRight();
		x = x + tmpInt[0];
		y = y + tmpInt[1];
		movingCar.setDirection(direction.turnRight());
		return new int[]{x, y};
		
	}

	@Override
	public int[] agileCarMove(int x, int y, Direction direction, Car movingCar) {
		
		int[] tmpInt = direction.moveRight();
		x = x + tmpInt[0];
		y = y + tmpInt[1];
		movingCar.setDirection(direction.turnRight());
		return new int[]{x, y};
		
	}
	
	
}