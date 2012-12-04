/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("PEWPEW - ich bin eine testmaschine");
		MoveAlgorithm circleAlgorithm = new CircleMove(10,10);
		Map circleMoveMap = new Map(10, 10, circleAlgorithm);
		circleMoveMap.startGame(10, 10);
		
	}
}