/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class AgileCar extends Car {
	private int countMoves;

	public AgileCar(int name,Map map,Direction startDir, MoveAlgorithm algorithm, int x, int y, int waitingDuration){
		super(name, map, startDir, algorithm, x, y, waitingDuration);
	}

	public void move(){
		if(countMoves > 200){ //when countMoves > 200 about 10 seconds are over!
			System.out.println("Car " + super.getName() + " has " + getPoints() + " points");
			super.getMap().endGame();
			return;
		}

		int[] nextCoordinates = super.getAlgorithm().agileCarMove(super.getX(), super.getY(), super.getDirection(), this);
		try{
			super.moveCar(nextCoordinates);
		}catch(GameEndException ex){
			System.out.println(ex.toString());
			super.getMap().endGame();
			return;
		}
		countMoves++;
		this.move();

	}


}