/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.util.ArrayList;

public class Map {
	
	private static Field[][] fieldArray;
	private ArrayList<Thread> listOfCars; //used to interrupt all threads when game ends in order to free resources
	
	//hat liste mit autos
	public Map(int xSize, int ySize) {
		
		fieldArray = new Field[xSize][ySize];
		
	}
	
	public static Field getField(int x, int y) {
		
		return fieldArray[x][y];
		
	}
	
	
	/**
	 * This method starts the game with a given number of fast/agile cars
	 * 
	 * @param numberOfAgileCars, numberOfFastCars
	 * 
	 * */
	//Precondition: numberOfAgileCars >= 0, numberOfFastCars >=0 but the sum should be > 1
	//Postcondition: game ended
	public void startGame(int numberOfAgileCars, int numberOfFastCars){
		listOfCars = new ArrayList<Thread>();
		for(int i = 0; i < numberOfAgileCars; i++){
			Car tmp = new AgileCar(new DirE(), new CircleMove(), 1, 1); //they are starting at [1][1]. we could make it random :)
			Thread t = new Thread(tmp);
			listOfCars.add(t); //make a list of Threads, for easier interrupts
			t.start();
		}
		
		for(int i = 0; i < numberOfFastCars; i++){
			Car tmp = new FastCar(new DirE(), new CircleMove(), 1, 1); //they are starting at [1][1]. we could make it random :)
			Thread t = new Thread(tmp);
			listOfCars.add(t);
			t.start();
		}
	}	
}