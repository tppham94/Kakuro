package Controller;

import Model.WordContainerModel;
import Model.WordModel;

public class TrainingController {

	WordContainerModel wordContainer[];
	
	public TrainingController (int size) { //we will need a predefined amount of word containers
	wordContainer = new WordContainerModel [size];
		for(int i=0;i<wordContainer.length;i++) {
			
		}
	}
	
	public void notifyAll(int index, String userNumber) {
		wordContainer [index].updateValueDownAtIndex(index, userNumber);
	}
	
	public void setContainer(int index, WordModel wordModel, String direction) {
		if(direction.equals("down")) wordContainer[index].setWordModelDown(wordModel);
		else wordContainer[index].setWordModelRight(wordModel);
	}
}
