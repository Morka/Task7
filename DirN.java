/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class DirN implements Direction {

	public DirN(){
		
		//Construct0r
		
	}

	public int[] moveStraight() {
		
		return new int[]{0, 1};
		
	}
	
	public int[] moveLeft() {
		
		return new int[]{-1, 0};
		
	}
	
	public int[] moveRight() {
		
		return new int[]{1, 0};
		
	}

	public Direction turnLeft() {

		return new DirW();
	}

	public Direction turnRight() {

		return new DirE();
		
	}
	
	
}