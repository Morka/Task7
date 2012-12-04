/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public interface MoveAlgorithm {
	
	public int[] fastCarMove(int x, int y, Direction direction, Car movingCar);
	public int[] agileCarMove(int x, int y, Direction direction, Car movingCar);
	
	
}