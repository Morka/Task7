/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.util.ArrayList;

public class Field {

	/**
	 * stores current cars on the field
	 * */
	private ArrayList<Car> currentCars;

	public Field() {		
		currentCars = new ArrayList<Car>();
	}

	/**
	 * parks a new car on the field
	 * 
	 * @param newCar which is now on the field in question
	 * */

	//Precondition newCar != null
	//Postcondition: currentCar now stores newCar
	public synchronized void parkCar(Car newCar){
		currentCars.add(newCar);
	}

	/**
	 * "unparks" a car from the field
	 * @param car that should be move away
	 * 
	 * */
	//Precondition: deleteCar != null
	//Postcondition: car isn't on the field anymore
	public synchronized void unParkCar(Car deleteCar){
		currentCars.remove(deleteCar);
	}

	/**
	 * method checks if an incommingCar hits another car and throws a GameEndException
	 * if it catches one
	 * 
	 * @param incommingCar the car which drives to the field
	 * 
	 * */
	//Precondition: incommingCar != null
	//postcondition: if incommingCar hit someone it got one point. if it hit something from 
	//	front it gets 2 points. if not the opposing car lost 1 point. if a car catches 
	//	GameEndException it has won the exception is thrown further
	public void checkHit(Car incommingCar) throws GameEndException{//untersucht ob an den angegebenen korrdinaten bereits ein auto steht und ob es ein hit ist	
		synchronized(this){
			if(currentCars.size() > 0){
				for(Car c : currentCars){
					if(incommingCar.getDirection().opposedTo(c.getDirection())){
						try{
							incommingCar.increasePoints();
							incommingCar.increasePoints();
						}catch(GameEndException ex){
							throw ex; 
						}
					}else{
						try{
							incommingCar.increasePoints();
						}catch(GameEndException ex){
							throw ex;
						}
						c.decreasePoints();
					}
				}
			}
		}
	}

}