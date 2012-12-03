/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public abstract class Car implements Runnable {
	
	protected Direction currentDir;
	private int points;

	@Override
	public void run() {
		
		this.move();
		
	}
	
	public abstract void move();
	
	public synchronized void increasePoints(){
		points++;
	}
	
	public synchronized void decreasePoints(){
		points--;
	}
}