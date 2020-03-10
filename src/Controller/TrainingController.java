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
	
	public void sendToCellModel(String number, CellView cv) { //to update the model based on the views event method triggered in view class
		cv.getObserverList().forEach(object -> { //upddates all cellModels that are references to the cell view
			sendGameModelText(object, number);
			sendToWordModel(object);
			});
		gbModel.updateTraining();
	}
	
	public void sendToWordModel(CellModel cm) { //updates The word models 
		cm.getWordObserverlist().forEach(wordObj -> gbModel.setWhatNeedsToBeFixed(gbModel.getWhatNeedsToBeFixed()+" "+wordObj.validateWord())); 
	}
	
	public void sendGameModelText(CellModel cm, String number) { //updates gameModel to fix text
		gbModel.setWhatNeedsToBeFixed(cm.updateTraining(number)); // will set the string of what needs to be fixed
	}
	
	public void sendToGameModel() { //updates all wordModels that have the CellModel
		gbModel.updateTraining();
	}
}


