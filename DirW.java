/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class DirW implements Direction {

	public DirW(){
		
		//Construct0r
		
	}

	public int[] moveStraight() {
		
		return new int[]{-1, 0};
		
	}
	
	public int[] moveLeft() {
		
		return new int[]{0, -1};
		
	}
	
	public int[] moveRight() {
		
		return new int[]{0, 1};
		
	}

	public Direction turnLeft() {

		return new DirS();
	}

	public Direction turnRight() {

		return new DirN();
		
	}
	
	
	public boolean opposedTo(Direction direction){
		return direction.opposedToDirW();
	}
	
	public boolean opposedToDirE(){
		return true;
	}
	
	public boolean opposedToDirS(){
		return false;
	}
	
	public boolean opposedToDirN(){
		return false;
	}
	
	public boolean opposedToDirW(){
		return false;
	}
}