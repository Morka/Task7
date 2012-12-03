/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public interface MoveAlgorithm {
	
	public int[] fastCarMove(int x, int y, int direction);
	public int[] agileCarMove(int x, int y, int direction);
	
	
}