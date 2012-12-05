/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("PEWPEW - ich bin eine testmaschine");
		MoveAlgorithm[] algorithm1= new MoveAlgorithm[]{new CircleMove(30,10),  new RandomMove(30,10)};
		Map circleMoveMap = new Map(30, 10, algorithm1);
		circleMoveMap.startGame(20, 20);
		
	}
}