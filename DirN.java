/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class DirN implements Direction {

	public void DirN(){
		
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
	
	
}