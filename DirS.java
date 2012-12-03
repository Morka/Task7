
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class DirS implements Direction {

	public DirS(){
		
		//Construct0r
		
	}

	public int[] moveStraight() {
		
		return new int[]{0, -1};
		
	}
	
	public int[] moveLeft() {
		
		return new int[]{1, 0};
		
	}
	
	public int[] moveRight() {
		
		return new int[]{-1, 0};
		
	}

	public Direction turnLeft() {

		return new DirE();
		
	}

	public Direction turnRight() {

		return new DirW();
		
	}
	
	public boolean opposedTo(Direction direction){
		return direction.opposedToDirS();
	}
	
	public boolean opposedToDirE(){
		return false;
	}
	
	public boolean opposedToDirS(){
		return false;
	}
	
	public boolean opposedToDirN(){
		return true;
	}
	
	public boolean opposedToDirW(){
		return false;
	}
}
	
	
