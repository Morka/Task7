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
	
	public boolean opposedTo(Direction direction){
		return direction.opposedToDirN();
	}
	
	public boolean opposedToDirE(){
		return false;
	}
	
	public boolean opposedToDirS(){
		return true;
	}
	
	public boolean opposedToDirN(){
		return false;
	}
	
	public boolean opposedToDirW(){
		return false;
	}
}
	