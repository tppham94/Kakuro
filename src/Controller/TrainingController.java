package Controller;

import javax.swing.JComponent;

import Model.CellModel;
import Model.GameBoardModel;
import Model.WordModel;
import View.CellView;

public class TrainingController extends GameController{
	
	public TrainingController () {
		super();
	}
	
	/*
	 * to update all of the models based on the views event method triggered in view class
	Needs to update at time of click so that the user can know what is wrong with that specific cell
	*/
	public void sendToCellModel(String number, CellView cv) { 
		sendGameModelText(cv.getObserverList(),number);
		sendToWordModel(cv.getObserverList());
		gbModel.updateTraining();
	}
	
	//updates all of the word models associated to that cellModel and will update the text for the game board
	public void sendToWordModel(CellModel cm) {  
		cm.getWordObserverlist().forEach(wordObj -> 
		gbModel.setWhatNeedsToBeFixed(gbModel.getWhatNeedsToBeFixed()+
		" "+wordObj.validateWord())); 
	}
	
	//updates gameModel text which tells user what noeeds to be fixed
	public void sendGameModelText(CellModel cm, String number) { 
		gbModel.setWhatNeedsToBeFixed(cm.updateTraining(number)); // will set the string of what needs to be fixed
	}
	
	public void sendToGameModel() { //updates gameBoard validity
		gbModel.updateTraining(); //updates the validate text for the gameboard
	}
}


