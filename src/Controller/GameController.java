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

public class GameController {
	

	GameBoardModel gbModel;	
	ArrayList <WordModel> wordObserverlist;
	
	public GameController () {
		gbModel = new GameBoardModel ();
	}
	
	public GameController (GameBoardModel gbm) {
		gbModel = gbm;
	}
	
	//to update the cell model based on the views event method triggered in view class
	public void sendToCellModel(String number, CellView cv) { 
		cv.getObserverList().update(number); //updates the cell model associated to the cell view
		sendToWordModel(cv.getObserverList()); //updates all word models associated to the cell model
	}
	
	//updates all wordModels that have the CellModel
	public void sendToWordModel(CellModel cm) { 
		cm.getWordObserverlist().forEach(wordObj -> wordObj.validateWord());
	}
	
	//updates the validate text for the gameboard
	public void sendToGameModel() { 
		gbModel.update();
	}
}
