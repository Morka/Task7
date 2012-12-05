/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * Game 1
		 * chance to find a winner is high because different move algorithms are used
		 * game will finish very fast, because a lot of cars are on the map
		 */
		System.out.println("Game 1");
		MoveAlgorithm[] algorithm1= new MoveAlgorithm[]{new CircleMove(30,10),  new RandomMove(30,10)};
		Map map1 = new Map(30, 10, algorithm1);
		map1.startGame(20, 20);
		
		try {
			Thread.sleep(11000); //wait 11 seconds to end first Game
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * Game 2
		 * chance to find a no winner is higher because only the Circle-Move algorithm is used
		 * 2 cases: game will finish fast if two cars hit 
		 *          or game will not finish if no cars hit
		 * map is too big for only 6 cars
		 */
		System.out.println("\n Game 2");
		MoveAlgorithm[] algorithm2= new MoveAlgorithm[]{new CircleMove(20,20)};
		Map map2 = new Map(20, 20, algorithm2);
		map2.startGame(3, 3);
		
		try {
			Thread.sleep(11000); //wait 11 seconds to end second Game
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * Game 3
		 * chance to find a winner is low because the map is very big for 10 cars
		 * game will finish slow
		 */
		System.out.println("\n Game 3");
		MoveAlgorithm[] algorithm3= new MoveAlgorithm[]{new RandomMove(30,30)};
		Map map3 = new Map(30, 30, algorithm3);
		map3.startGame(5, 5);
	}
}