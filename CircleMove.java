/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class CircleMove implements MoveAlgorithm {
	
	private int width, height;

	public CircleMove(int width, int height){
		
		this.width = width;
		this.height = height;
		
	}

	@Override
	public int[] fastCarMove(int x, int y, Direction direction, Car movingCar) {
		
		int returnX, returnY;
		int[] tmpInt = direction.moveStraight();
		returnX = x + tmpInt[0];
		returnY = y + tmpInt[1];
		tmpInt = direction.moveRight();
		returnX = returnX + tmpInt[0];
		returnY = returnY + tmpInt[1];
		movingCar.setDirection(direction.turnRight());
		if(-1 < returnX && returnX < width && -1 < returnY &&returnY < height){
			
			return new int[]{returnX, returnY};
			
		}
		
		return new int[]{-1, -1};
		
	}

	@Override
	public int[] agileCarMove(int x, int y, Direction direction, Car movingCar) {
		
		int returnX, returnY;
		int[] tmpInt = direction.moveRight();
		returnX = x + tmpInt[0];
		returnY = y + tmpInt[1];
		movingCar.setDirection(direction.turnRight());

		if(-1 < returnX && returnX < width && -1 < returnY &&  returnY < height){

			return new int[]{returnX, returnY};

		}

		return new int[]{-1, -1};

	}


}