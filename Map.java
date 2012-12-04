/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.util.ArrayList;
import java.util.Random;

public class Map {
	
	private static Field[][] fieldArray;
	private ArrayList<Thread> listOfCars; //used to interrupt all threads when game ends in order to free resources
	private final int xSize;
	private final int ySize;
	
	//hat liste mit autos
	public Map(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		fieldArray = new Field[xSize][ySize];
		
	}
	
	public static Field getField(int x, int y) {
		
		return fieldArray[x][y];
		
	}
	
	private void initializeField(){
		for(int i = 0; i < xSize; i++){
			for(int j = 0; j < ySize; j++){
				fieldArray[i][j] = new Field();
			}
		}
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
		this.initializeField();
		Random rand = new Random();
		listOfCars = new ArrayList<Thread>();
		for(int i = 0; i < numberOfAgileCars; i++){
			//poor randomisation
			Car tmp = new AgileCar(this, new DirE(), new CircleMove(xSize, ySize), rand.nextInt(10), rand.nextInt(10)); //they are starting at random BUT only numbers between 0 and 10
			Thread t = new Thread(tmp);
			listOfCars.add(t); //make a list of Threads, for easier interrupts
			t.start();
		}
		
		for(int i = 0; i < numberOfFastCars; i++){
			Car tmp = new FastCar(this, new DirE(), new CircleMove(xSize, ySize), rand.nextInt(10), rand.nextInt(10)); //they are starting at random BUT only numbers between 0 and 10
			Thread t = new Thread(tmp);
			listOfCars.add(t);
			t.start();
		}
	}	
	
	public void endGame(){
		for(Thread t : listOfCars){
			t.interrupt();
		}
	}
}