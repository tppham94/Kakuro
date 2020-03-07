package Model;

public class GameBoardModel {
	WordContainerModel [] wordContainerModelArray;
	boolean [] boolArray;
	boolean valid;
	
	public GameBoardModel () { //def constructor with 100 word containers
		wordContainerModelArray = new WordContainerModel [100];
		boolArray = new boolean [100];
		valid=false;
	}
	
	public GameBoardModel (int size) { //boardgamewith size initialized by user
		wordContainerModelArray = new WordContainerModel[size];
		boolArray = new boolean [size];
		valid=false;
	}
	
	public boolean update () { // update method that updates the board based on boolean's for speed
		for(int i=0;i<boolArray.length;i++) {
			if(boolArray[i]==false) {
				valid = false;
				break;
			}
			valid = true; // will only reach at end if doesn't break for loop meaning it is good
		}
		return valid;
	}
	
	public boolean updateAtIndex (int index) { // method to update a single word container
		boolArray[index] = (wordContainerModelArray[index].getWordModelDown().validateWord()&&wordContainerModelArray[index].getWordModelRight().validateWord());
		return boolArray[index];
	}
}
