package Model;

public class BlankWordModel {

	ClueCellModel clueCellModelArray[];
	
	public BlankWordModel () { //def constructor
		clueCellModelArray = new ClueCellModel [10];
	}

	public BlankWordModel (int size) { //constructor with a set for of text elements for that word
		clueCellModelArray = new ClueCellModel [size];
	}
	
	public ClueCellModel[] getclueCellModelArray () { //access method for the clueCellModelArray
		return clueCellModelArray;
	}
	
	public ClueCellModel getclueCellModelArrayAtIndex (int index) { //accessor method for an index of the clueCellModel array
		return clueCellModelArray[index];
	}
	
	public void setclueCellModelArrayAtIndex(int index, String downNumber, String rightNumber) { //mutator to create a new clueCellModel object
		clueCellModelArray [index] = new ClueCellModel (downNumber, rightNumber);
	}
	
}
