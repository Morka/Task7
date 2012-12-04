/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public abstract class Car implements Runnable {
	
	protected Direction currentDir;
	protected static int count;
	
	private int points;
	@Override
	public void run(){ 
			this.move();
	}
	
	public abstract void move(); //is it a good idea to make it public?
	public abstract Direction getDirection();
	
	public void setDirection(Direction dir) {
		
		this.currentDir = dir;
		
	}
	
	public void increasePoints() throws GameEndException{
		points++;
		if(points > 9){
			throw new GameEndException("The Winner is: ");
		}
	}
	
	public void decreasePoints(){
		points--;
	}
	
	public int getPoints(){
		return points;
	}
}