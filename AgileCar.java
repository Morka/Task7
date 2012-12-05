/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class AgileCar extends Car {
	
	public AgileCar(int name,Map map,Direction startDir, MoveAlgorithm algorithm, int x, int y, int waitingDuration){
		super(name, map, startDir, algorithm, x, y, waitingDuration);
	}

	public void move(){
		int[] nextCoordinates = super.getAlgorithm().agileCarMove(super.getX(), super.getY(), super.getDirection(), this);
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