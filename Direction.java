/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public interface Direction {
	
	public int[] moveStraight();
	public int[] moveLeft();
	public int[] moveRight();
	public Direction turnLeft();
	public Direction turnRight();
	
	
}