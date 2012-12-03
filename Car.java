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
	
	public synchronized void increasePoints() throws SuccessException{
		points++;
		if(points > 9){
			throw new SuccessException("The Winner is: ");
		}
	}
	
	public synchronized void decreasePoints(){
		points--;
	}
}