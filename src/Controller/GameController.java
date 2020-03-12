package Controller;

import java.util.ArrayList;

import Model.CellModel;
import Model.GameBoardModel;
import Model.WordModel;
import View.CellView;

public class GameController {
	

	GameBoardModel gbModel;	
	ArrayList <WordModel> wordObserverlist;
	
	public GameController () {
		gbModel = new GameBoardModel ();
	}
	
	public GameController (GameBoardModel gbm) {
		gbModel = gbm;
	}
	
	public void sendToCellModel(String number, CellView cv) { //to update the model based on the views event method triggered in view class
		cv.getObserverList().update(number);
		sendToWordModel(cv.getObserverList());
	}
	
	public void sendToWordModel(CellModel cm) { //updates all wordModels that have the CellModel
		cm.getWordObserverlist().forEach(wordObj -> wordObj.validateWord());
	}
	
	public void sendToGameModel() { //updates all wordModels that have the CellModel
		gbModel.update();
	}
}
