/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public abstract class Car implements Runnable {

	@Override
	public void run() {
		
		this.move();
		
	}
	
	public abstract void move();
	
	
}