/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.util.ArrayList;

public class Map {
	
	private Field[][] fieldArray;
	private ArrayList<Car> listOfCars; //used to interrupt all threads when game ends in order to free resources
	
	//hat liste mit autos
	public Map(int xSize, int ySize) {
		
		fieldArray = new Field[xSize][ySize];
		
	}
	
	public Field getField(int x, int y) {
		
		return this.fieldArray[x][y];
		
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
		listOfCars = new ArrayList<Car>();
		for(int i = 0; i < numberOfAgileCars; i++){
			Car tmp = new AgileCar(new DirE());
			listOfCars.add(tmp);
			tmp.move();
		}
		
		for(int i = 0; i < numberOfFastCars; i++){
			Car tmp = new FastCar(new DirE());
			listOfCars.add(tmp);
			tmp.move();
		}
	}
	
}