package Model;

public class WordModel {

	CellObject cellObjectArray[];
	
	public WordModel (int size) {
		cellObjectArray = new CellObject [size];
	}
	
	public CellObject[] getCellObjectArray () {
		return cellObjectArray;
	}
	
	public CellObject getCellObjectArrayAtIndex (int index) {
		return cellObjectArray[index];
	}
	
	public void setCellObjectArrayAtIndex(int index, int correctNumber) { 
		cellObjectArray [index] = new CellObject (correctNumber);
	}
	
	public void updateValueAtIndex(int index, String number) { 
		cellObjectArray [index].cellModel.update(number);
	}
	
}
