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

	public void checkHit(Car incommingCar) {//untersucht ob an den angegebenen korrdinaten bereits ein auto steht und ob es ein hit ist	
		if(currentCars.size() > 0){
			synchronized(this){
				for(Car c : currentCars){
					incommingCar.increasePoints();
					c.decreasePoints();
				}
			}
		}
	}

}