/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class AgileCar extends Car {

	private Direction direction;
	private final MoveAlgorithm algorithm;
	private int x, y;
	private int countMoves;

	public AgileCar(Direction startDir, MoveAlgorithm algorithm, int x, int y){

		this.direction = startDir;
		this.algorithm = algorithm;
		this.x = x;
		this.y = y;
	}

	public void move(){
		if(countMoves > 200){ //when countMoves > 200 about 10 seconds are over!
			return;
		}

		int[] nextCoordinates = algorithm.agileCarMove(this.x, this.y, direction);
		if(nextCoordinates[0] < 0 || nextCoordinates[1] < 0){
			this.x = nextCoordinates[0];
			this.y = nextCoordinates[1];

			System.out.println("x: " + this.x + "\ny: " + this.y);
			Field newField = Map.getField(x, y);

			try{
				newField.checkHit(this);
			}catch(GameEndException ex){
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
		}else{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
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