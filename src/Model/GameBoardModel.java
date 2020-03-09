package Model;

import View.ValidateView;

public class GameBoardModel {
	wordWrapper [] wordModelArray;
	boolean valid;
	String whatNeedsToBeFixed; 

	ValidateView validateView; // the text that says valid invalid or what errors it has
	
	public GameBoardModel () { //def constructor with 100 word containers
		wordModelArray = new wordWrapper [100];
		valid=false;
		validateView = new ValidateView();
	}
	
	public GameBoardModel (int size) { //boardgamewith size initialized by user
		wordModelArray = new wordWrapper[size];
		valid=false;
		validateView = new ValidateView();
	}
	
	public boolean update () { // update method that updates the board based on boolean's for speed
		for(int i=0;i<wordModelArray.length;i++) {
			if(wordModelArray[i].getClass().equals("WordModel")) { //only wordModels can be checked for validation
				if(wordModelArray[i].getWordModel().isWordIsValid()==false) {
					valid = false;
					validateView.updateString ("Sorry that isn't right. Please try again");
					break;
				}
				validateView.updateString ("Congradulations! You won");
				valid = true; // will only reach at end if doesn't break for loop meaning it is good
			}
		}
		return valid;
	}
	
	public boolean updateTraining () { // update method that updates the board based on boolean's for speed
		for(int i=0;i<wordModelArray.length;i++) {
			if(wordModelArray[i].getClass().equals("WordModel")) { //only wordModels can be checked for validation
				if(wordModelArray[i].getWordModel().isWordIsValid()==false) {
					valid = false;
					validateView.updateString (whatNeedsToBeFixed);
					break;
				}
				validateView.updateString (whatNeedsToBeFixed);
				valid = true; // will only reach at end if doesn't break for loop meaning it is good
			}
		}
		return valid;
	}
	
	public String getWhatNeedsToBeFixed() { //accessor for the message "printed" to the user in the validateView
		return whatNeedsToBeFixed;
	}

	public void setWhatNeedsToBeFixed(String whatNeedsToBeFixed) { //this will be the message "printed" to the user in the validateView
		this.whatNeedsToBeFixed = whatNeedsToBeFixed;
	}	
}
