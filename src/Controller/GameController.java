package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import Model.CellModel;
import Model.GameBoardModel;
import Model.WordModel;
import View.CellView;
import View.TextCell;

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
		
		cv.getObserverList().forEach(object -> { //upddates all cellModels that are references to the cell view
			object.update(number);
			sendToWordModel (object);
			});
	}
	
	public void sendToWordModel(CellModel cm) { //updates all wordModels that have the CellModel
		cm.getWordObserverlist().forEach(wordObj -> wordObj.validateWord());
	}
	
	public void sendToGameModel() { //updates all wordModels that have the CellModel
		gbModel.update();
	}
}
