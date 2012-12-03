/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Map {
	
	private Field[][] fieldArray;
	
	//hat liste mit autos
	public Map(int xSize, int ySize) {
		
		fieldArray = new Field[xSize][ySize];
		
	}
	
	public Field getField(int x, int y) {
		
		return this.fieldArray[x][y];
		
	}
	
}