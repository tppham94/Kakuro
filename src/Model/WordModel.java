package Model;

public class WordModel {

	CellModel CellModelArray[];
	GameBoardModel gbm;
	int correctTotalForWord;
	boolean wordIsValid;

	public WordModel () { //def constructor
		gbm = new GameBoardModel();
		CellModelArray = new CellModel [10];
	}

	public WordModel (int size) { //constructor with a set for of text elements for that word
		CellModelArray = new CellModel [size];
	}
	
	public WordModel (int size, int totalForWord) { //constructor which sets the correct total for the word
		CellModelArray = new CellModel [size];
		this.correctTotalForWord = totalForWord;
	}
	
	public CellModel[] getCellModelArray () { //access method for the cellModelArray
		return CellModelArray;
	}
	
	public CellModel getCellModelArrayAtIndex (int index) { //accessor method for an index of the cellModel array
		return CellModelArray[index];
	}
	
	public void setCellModelArrayAtIndex(int index, int correctNumber) { //mutator to create a new cellModel object
		CellModelArray [index] = new CellModel (correctNumber);
	}
	
	public void updateValueAtIndex(int index, String number) {  //mutator to set the value entered by user in the cellModel
		CellModelArray [index].update(number);
	}
	
	public boolean validateWord () { //method to validate the whole word
		wordIsValid= true;
		for (int i=0;i<CellModelArray.length;i++) {
			if (!CellModelArray[i].getIsCorrect()) {
				wordIsValid = false;
				break;
			}
		}
		return wordIsValid;
	}
	
	public int getTotalForWord() { //accessor for word correctness
		return correctTotalForWord;
	}

	public void setTotalForWord(int totalForWord) { // mutator for word correctness
		this.correctTotalForWord = totalForWord;
	}
	
	public boolean isWordIsValid() {
		return wordIsValid;
	}

	public void setWordIsValid(boolean wordIsValid) {
		this.wordIsValid = wordIsValid;
	}
	
}
