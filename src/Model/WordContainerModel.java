package Model;

public class WordContainerModel {

	WordModel wordModelRight;


	WordModel wordModelDown;

	public WordContainerModel(int sizeOfWordModelOne, int sizeOfWordModelTwo) {
		wordModelRight = new WordModel (sizeOfWordModelOne);
		wordModelDown = new WordModel (sizeOfWordModelTwo);
	}
	
	public WordModel getWordModelRight() {
		return wordModelRight;
	}

	public void setWordModelRight(WordModel wordModelRight) {
		this.wordModelRight = wordModelRight;
	}
	
	public WordModel getWordModelDown() {
		return wordModelDown;
	}

	public void setWordModelDown(WordModel wordModelDown) {
		this.wordModelDown = wordModelDown;
	}
	
	public void setWordModelDownAtIndex (int index, int correctNumber) {
		wordModelDown.setCellObjectArrayAtIndex(index, correctNumber);
	}
	
	public void setWordModelRightAtIndex (int index, int correctNumber) {
		wordModelRight.setCellObjectArrayAtIndex(index, correctNumber);
	}
	
}
