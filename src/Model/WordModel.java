package Model;

public class WordModel {

	CellModel CellModelArray[]; //variable which will hold the array of cell model referemces associated to that word
	int correctTotalForWord; //the total all the cell models must add up to for the word to be correct
	boolean wordIsValid; //the boolean which will be used when all cell models either add up or don't add up to the correctTotalForWord

	/**
	 * def constructor
	 */
	public WordModel () { 
		CellModelArray = new CellModel [10];
	}
	
	/**
	 * constructor which sets the correct total for the word
	 * @param size
	 * @param totalForWord
	 */
	public WordModel (int size, int totalForWord) {
		CellModelArray = new CellModel [size];
		this.correctTotalForWord = totalForWord;
		//this.wordIsValid = false;
	}
	
	/**
	 * access method for the cellModelArray
	 * @return
	 */
	public CellModel[] getCellModelArray () { 
		return CellModelArray;
	}
	
	
	/**
	 * accessor method for an index of the cellModel array
	 * @param index
	 * @return
	 */
	public CellModel getCellModelArrayAtIndex (int index) {
		return CellModelArray[index];
	}
	
	
	/**
	 * mutator to create a new cellModel object
	 * @param index
	 * @param cm
	 */
	public void setCellModelArrayAtIndex(int index, CellModel cm) { 
		CellModelArray [index] = cm;
	}
	
	/**
	 * mutator to set the value entered by user in the cellModel
	 * @param index
	 * @param number
	 */
	public void updateValueAtIndex(int index, String number) { 
		CellModelArray [index].update(number);
	}
	
	/**
	 * method to validate the whole word. It will return the reason why it is incorrect if incorrect.
	 * @return
	 */
	public String validateWord () {
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
	
	/**
	 * accessor for correct word total
	 * @return
	 */
	public int getTotalForWord() { 
		return correctTotalForWord;
	}

	/**
	 *  mutator for correct word total
	 * @param totalForWord
	 */
	public void setTotalForWord(int totalForWord) { 
		this.correctTotalForWord = totalForWord;
	}
	
	/**
	 * accessor for word correctness
	 * @return
	 */
	public boolean isWordIsValid() {
		return wordIsValid;
	}

	/**
	 * mutator for word correctness
	 * @param wordIsValid
	 */
	public void setWordIsValid(boolean wordIsValid) {
		this.wordIsValid = wordIsValid;
	}
	
}
