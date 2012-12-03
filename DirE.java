/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class DirE implements Direction {

	public DirE(){
		
		//Construct0r
		
	}

	public int[] moveStraight() {
		
		return new int[]{1, 0};
		
	}
	
	public int[] moveLeft() {
		
		return new int[]{0, 1};
		
	}
	
	public int[] moveRight() {
		
		return new int[]{0, -1};
		
	}

	public Direction turnLeft() {

		return new DirN();
		
	}

	public Direction turnRight() {

		return new DirS();
		
	}
	
	
}