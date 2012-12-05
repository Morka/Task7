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

	public synchronized void parkCar(Car newCar){
		currentCars.add(newCar);
	}

	public synchronized void unParkCar(Car deleteCar){
		currentCars.remove(deleteCar);
	}

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
						incommingCar.increasePoints();
						c.decreasePoints();
					}
				}
			}
		}
	}

}