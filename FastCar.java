/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class FastCar extends Car {
	
	public FastCar(int name, Map map, Direction startDir, MoveAlgorithm algorithm, int x, int y, int waitingDuration){
		super(name, map, startDir, algorithm, x, y, waitingDuration);
	}

	/**
	 * the car moves with the specified algorithm.
	 *  if an GameEndException is catched it prints the result and return
	 * 
	 * */
	//Postcondition: nextCoordinates were computed and executed
		//next move mtheod is invoked or gameEndException is catchen in which case
		//endGame is called which ends the game
	public void move(){
		int[] nextCoordinates = super.getAlgorithm().fastCarMove(super.getX(), super.getY(), super.getDirection(), this);
		try{
			super.moveCar(nextCoordinates);
		}catch(GameEndException ex){
			System.out.println(ex.toString());
			super.getMap().endGame();
			return;
		}
		this.move();
	}


}