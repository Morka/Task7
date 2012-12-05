/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public abstract class Car implements Runnable {
	
	private Direction currentDir;
	private final MoveAlgorithm algorithm;
	private int x, y;
	private final Map map;
	private final int name;
	private final int waitingDuration;

	private int points;
	
	public Car(int name,Map map,Direction startDir, MoveAlgorithm algorithm, int x, int y, int waitingDuration){
		this.map = map;
		this.currentDir = startDir;
		this.algorithm = algorithm;
		this.x = x;
		this.y = y;
		this.name = name;
		this.waitingDuration = waitingDuration;
	}
	@Override
	public void run(){ 
			this.move();
	}
	
	public abstract void move(); //is it a good idea to make it public?
	
	public void setDirection(Direction dir) {
		
		this.currentDir = dir;
		
	}
	
	public void increasePoints() throws GameEndException{
		points++;
		if(points > 9){
			throw new GameEndException("The Winner is: ");
		}
	}
	protected MoveAlgorithm getAlgorithm(){
		return algorithm;
	}
	
	protected int getName(){
		return name;
	}
	
	protected Map getMap(){
		return map;
	}
	
	protected void moveCar(int[] nextCoordinates) throws GameEndException{
		if(nextCoordinates[0] != -1){ 
			this.x = nextCoordinates[0];
			this.y = nextCoordinates[1];

			Field newField = map.getField(x, y);

			try{
				newField.checkHit(this);
			}catch(GameEndException ex){
				throw new GameEndException(ex.toString() + this.name);
			}

			newField.parkCar(this);

			try {
				Thread.sleep(waitingDuration);
			} catch (InterruptedException e) {
				throw new GameEndException("Car " + name + " has " + getPoints() + " points");
			}
			newField.unParkCar(this);
		}else{ //nexCoordinates[0] == -1 -> the next field would be illegal
			try {
				Thread.sleep(waitingDuration);
			} catch (InterruptedException e) {
				throw new GameEndException("Car " + name + " has " + getPoints() + " points");
			}			

			//unless algorithm is random, the car is stuck forever
		}
	}
	
	protected int getX(){
		return this.x;
	}
	
	protected int getY(){
		return this.y;
	}
	
	protected Direction getDirection(){
		return this.currentDir;
	}
	
	public void decreasePoints(){
		points--;
	}
	
	public int getPoints(){
		return points;
	}
}