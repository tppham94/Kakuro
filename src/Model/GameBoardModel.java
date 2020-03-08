package Model;

public class GameBoardModel {
	wordWrapper [] wordModelArray;
	boolean valid;
	
	public GameBoardModel () { //def constructor with 100 word containers
		wordModelArray = new wordWrapper [100];
		valid=false;
	}
	
	public GameBoardModel (int size) { //boardgamewith size initialized by user
		wordModelArray = new wordWrapper[size];
		valid=false;
	}
	
	public boolean update () { // update method that updates the board based on boolean's for speed
		for(int i=0;i<wordModelArray.length;i++) {
			if(wordModelArray[i].getClass().equals("WordModel")) { //only wordModels can be checked for validation
				if(wordModelArray[i].getWordModel().isWordIsValid()==false) {
					valid = false;
					break;
				}
				valid = true; // will only reach at end if doesn't break for loop meaning it is good
			}
		}
		return valid;
	}
	
//	public boolean updateValidAtBoolArrayAtIndex (int index) { // method to update a single word container
//		boolArray[index] = (wordModelArray[index].getWordModel().validateWord());
//		return boolArray[index];
//	}
	
//	public void changeCellNumberAtIndex (int word, int index, String number) {
//		wordModelArray[word].getWordModel().updateValueAtIndex(index, number);
//	}
}
