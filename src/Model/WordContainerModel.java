package Model;

public class WordContainerModel {

	WordModel wordModelRight;
	WordModel wordModelDown;


	public WordContainerModel() { //default constructor 
		wordModelRight = new WordModel ();
		wordModelDown = new WordModel ();
	}
	
	public WordContainerModel(int sizeOfWordModelOne, int sizeOfWordModelTwo) { //constructor with ints for the size of the word arrays
		wordModelRight = new WordModel (sizeOfWordModelOne);
		wordModelDown = new WordModel (sizeOfWordModelTwo);
	}
	
	public WordContainerModel(WordModel wordRight, WordModel wordDown) { //constructor with wordModels in case user wants to pass them directly
		wordModelRight = wordRight;
		wordModelDown = wordDown;
	}
	
	public WordModel getWordModelRight() { //get the right wordModel
		return wordModelRight;
	}

	public void setWordModelRight(WordModel wordModelRight) { //set the right wordModel
		this.wordModelRight = wordModelRight;
	}
	
	public WordModel getWordModelDown() {
		return wordModelDown;
	}

	public void setWordModelDown(WordModel wordModelDown) {
		this.wordModelDown = wordModelDown;
	}
	
	public void setWordModelDownAtIndex (int index, int correctNumber) { //set the down wordModelDown at specific index to a number
		wordModelDown.setCellModelArrayAtIndex(index, correctNumber);
	}
	
	public void setWordModelRightAtIndex (int index, int correctNumber) {//set the down wordModelRight at specific index to a number
		wordModelRight.setCellModelArrayAtIndex(index, correctNumber);
	}
	
	public boolean wordModelDownValidate () { // see if the down word model is valid
		return wordModelDown.validateWord();
	}
	
	public boolean getCellModelRightAtIndex () { // see if the down word model is valid
		return wordModelRight.validateWord();
	}

	
}
