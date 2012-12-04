/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

import java.util.ArrayList;

public class Field {

	private ArrayList<Car> currentCars;

	public Field() {		
		currentCars = new ArrayList<Car>();
	}

	public void parkCar(Car newCar){
		currentCars.add(newCar);
	}

	public void unParkCar(Car deleteCar){
		currentCars.remove(deleteCar);
	}

	public void checkHit(Car incommingCar) throws GameEndException{//untersucht ob an den angegebenen korrdinaten bereits ein auto steht und ob es ein hit ist	
		if(currentCars.size() > 0){
			synchronized(this){
				for(Car c : currentCars){
					if(incommingCar.getDirection().opposedTo(c.getDirection())){
						try{
							incommingCar.increasePoints();
							incommingCar.increasePoints();
						}catch(GameEndException ex){
							//is it a good style to "cascade" throw exceptions? because we'd need to throw it ones more in Car in order to get it through to Map...
							throw new GameEndException(ex.toString() + incommingCar); //incommingCar lacks a toString() method! 
						}
					}else{
						incommingCar.increasePoints();
						c.decreasePoints();
					}
				}
			}
		}
	}

}