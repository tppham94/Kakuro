package Controller;

import javax.swing.JComponent;

import Model.CellModel;
import Model.GameBoardModel;
import Model.WordModel;
import View.CellView;

public class TrainingController {

	CellModel model1 = new CellModel ();
	CellView view1 = model1.getCellView();
	GameBoardModel gbModel = new GameBoardModel ();
	
	
	JComponent[] gameComponents;
	
	
	
	public TrainingController () {
		view1.setController(this);
	}
	
	public void sendToCellModel(String number, CellView cv) { //to update the model based on the views event method triggered in view class
		
		cv.getObserverList().forEach(object -> { //upddates all cellModels that are references to the cell view
			gbModel.setWhatNeedsToBeFixed(object.updateTraining(number)); // will set the string of what needs to be fixed
			object.getWordObserverlist().forEach(wordObj -> gbModel.setWhatNeedsToBeFixed(gbModel.getWhatNeedsToBeFixed()+" "+wordObj.validateWord())); //updates word validity and return why its not invalid
			});
		gbModel.updateTraining();
	}
}


