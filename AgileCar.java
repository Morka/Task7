/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class AgileCar extends Car {

	private Direction direction;
	private final MoveAlgorithm algorithm;
	private int x, y;

	public AgileCar(Direction startDir, MoveAlgorithm algorithm, int x, int y){

		this.direction = startDir;
		this.algorithm = algorithm;
		this.x = x;
		this.y = y;
	}

	public void move(){

		int[] nextCoordinates = algorithm.agileCarMove(this.x, this.y, direction);
		this.x = nextCoordinates[0];
		this.y = nextCoordinates[1];

		Field newField = Map.getField(x, y);

		try{
			newField.checkHit(this);
		}catch(SuccessException ex){
			//Winner found, do something...
		}
		
		newField.parkCar(this);

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newField.unParkCar(this);
		this.move();

	}

	public Direction getDirection(){
		return direction;
	}

}