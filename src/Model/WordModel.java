package Model;

public class WordModel {

	CellModel CellModelArray[];
	int correctTotalForWord;
	int startingIndex;

	boolean wordIsValid;

	public WordModel () { //def constructor
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
	
//	public void setCellModelArrayAtIndex(int index, int correctNumber) { //mutator to create a new cellModel object
//		CellModelArray [index] = new CellModel (correctNumber);
//	}
	
	public void setCellModelArrayAtIndex(int index, CellModel cm) { //mutator to create a new cellModel object
		CellModelArray [index] = cm;
	}
	
	public void updateValueAtIndex(int index, String number) {  //mutator to set the value entered by user in the cellModel
		CellModelArray [index].update(number);
	}
	
	public String validateWord () { //method to validate the whole word. It will return the reason why it is incorrect if incorrect.
		wordIsValid= true;
		for (int i=0;i<CellModelArray.length;i++) {
			if (!CellModelArray[i].getIsCorrect()) {
				wordIsValid = false;
				break;
			}
			for(int j=0; j< CellModelArray.length; j++) {
				if(CellModelArray[i]== CellModelArray[j])
					wordIsValid = false;
					break;
			}
		}
		if(wordIsValid) return "That word is valid";
		else return "That word is not valid. Make sure all numbers are correct and nothing is repeated";
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
	
	public int getStartingIndex() {
		return startingIndex;
	}

	public void setStartingIndex(int startingIndex) {
		this.startingIndex = startingIndex;
	}
	
}
