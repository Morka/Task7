/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public interface Direction {
	
	public int[] moveStraight();
	public int[] moveLeft();
	public int[] moveRight();
	public Direction turnLeft();
	public Direction turnRight();
	
	public abstract boolean opposedTo(Direction direction);
	
	public abstract boolean opposedToDirE();
	public abstract boolean opposedToDirW();
	public abstract boolean opposedToDirS();
	public abstract boolean opposedToDirN();

}