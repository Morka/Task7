/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public abstract class Car implements Runnable {
	
	private Direction currentDir;
	private final MoveAlgorithm algorithm;
	//Precondition: x >= 0 , y >= 0
	private int x, y;
	private final Map map;
	private final int name;
	//Precondition:waitingDuration >= 0
	private final int waitingDuration;
	private int countMoves;

	private int points;
	
	/**
	 * Constructor which sets a start Direction for the car, a algorithm to move, a int name for description
	 * a start point and a waiting duration for the car
	 * 
	 * */
	
	public Car(int name,Map map,Direction startDir, MoveAlgorithm algorithm, int x, int y, int waitingDuration){
		this.map = map;
		this.currentDir = startDir;
		this.algorithm = algorithm;
		this.x = x;
		this.y = y;
		this.name = name;
		this.waitingDuration = waitingDuration;
	}
	/**
	 * starts moving the car by calling move()
	 * */
	@Override
	public void run(){ 
			this.move();
	}
	
	protected abstract void move(); //is it a good idea to make it public?
	
	/**
	 * sets a new Direction for the car (e.g. after moving)
	 * 
	 * @param dir new Direction to be set
	 * 
	 * */
	//Precondition: dir != null
	//Postcondition: currentDir is set to dir
	public void setDirection(Direction dir) {
		
		this.currentDir = dir;
		
	}
	/**
	 * increases Points and checks if car has more than 9 points.
	 * if this happens a GameEndException is thrown
	 * 
	 * */
	//Postcondition: points of car increased by one. if more than 9
				   //GameEndException
	public void increasePoints() throws GameEndException{
		points++;
		if(points > 9){
			throw new GameEndException("The Winner is: " + name);
		}
	}
	
	/**
	 * gives back moveAlgorithm
	 * 
	 * @return the algorithm the car uses
	 * */
	protected MoveAlgorithm getAlgorithm(){
		return algorithm;
	}
	/**
	 * gives back the name of the car
	 * */
	protected int getName(){
		return name;
	}
	/**
	 * gives back the map at which the car is driving
	 * 
	 * @return map the car uses
	 * */
	protected Map getMap(){
		return map;
	}
	/**
	 * this method moves the car by the coordinates it gets
	 * after it checks wheter or not it hits a car at the next field,
	 * it parks at the next field and waits for a given waitingDuration
	 * If it gets interupted or catches and GameEndException it throws a 
	 * GameEndException itself
	 * 
	 * @param nextCoordinates[] the next to Coordinates of the car -1 if car can't move
	 * 
	 * 
	 * */
	//Precondition: x and y >= 0 and < map.width/height
	//Postcondition: Car checked if it hit something an if it has one and throwed
	//	an Exception if so. it is unparked and ready to move again.
	protected void moveCar(int[] nextCoordinates) throws GameEndException{
		if(countMoves > 10000/waitingDuration){
			throw new GameEndException("Car " + name + " has " + getPoints() + " points");
		}
		
		if(nextCoordinates[0] != -1){ 
			this.x = nextCoordinates[0];
			this.y = nextCoordinates[1];

			Field newField = map.getField(x, y);

			try{
				newField.checkHit(this);
			}catch(GameEndException ex){
				throw ex;
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
		countMoves++;
	}
	/**
	 * gives back x
	 * 
	 * @return x coordinate where the car can be found
	 * */
	protected int getX(){
		return this.x;
	}
	/**
	 * gives back y
	 * 
	 * @return y coordinate where the car can be found
	 * */
	protected int getY(){
		return this.y;
	}
	
	/**
	 * gives back currentDir
	 * 
	 * @return direction the car is standing 
	 * */
	protected Direction getDirection(){
		return this.currentDir;
	}
	
	/**
	 * Decreases points of a car
	 * 
	 * */
	//Postcondition: points are decreased by 1
	public void decreasePoints(){
		points--;
	}
	
	/**
	 * gives back points
	 * 
	 * @return points the car has achieved
	 * */
	public int getPoints(){
		return points;
	}
	
	public String toString(){
		return ""+  name;
	}
	
}