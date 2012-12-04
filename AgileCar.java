/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class AgileCar extends Car {

	private Direction direction;
	private final MoveAlgorithm algorithm;
	private int x, y;
	private int countMoves;
	private final Map map;
	private int name;

	public AgileCar(Map map,Direction startDir, MoveAlgorithm algorithm, int x, int y){

		this.map = map;
		this.direction = startDir;
		this.algorithm = algorithm;
		this.x = x;
		this.y = y;
		super.count++;
		synchronized(this){
			this.name = count;
		}
	}

	public void move(){
		if(countMoves > 200){ //when countMoves > 200 about 10 seconds are over!
			System.out.println("Car " + name + " has " + getPoints() + " points");
			map.endGame();
			return;
		}

		int[] nextCoordinates = algorithm.agileCarMove(this.x, this.y, direction, this);
		if(nextCoordinates[0] != -1){ 
			this.x = nextCoordinates[0];
			this.y = nextCoordinates[1];

			//System.out.println("x: " + this.x);
			//System.out.println("y: " + this.y);
			Field newField = Map.getField(x, y);

			try{
				newField.checkHit(this);
			}catch(GameEndException ex){
				System.out.println(ex.toString());
				map.endGame();
				return;
			}

			newField.parkCar(this);

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("Car " + name + " has " + getPoints() + " points");
				return;
			}
			newField.unParkCar(this);
		}else{ //nexCoordinates[0] == -1 -> the next field would be illegal
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("Car " + name + " has " + getPoints() + " points");
				return;
			}			

			//unless algorithm is random, the car is stuck forever
		}
		countMoves++;
		this.move();

	}

	public Direction getDirection(){
		return direction;
	}

}