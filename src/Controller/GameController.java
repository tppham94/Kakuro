package Controller;

import Model.CellModel;
import Model.GameBoardModel;
import Model.WordModel;
import View.CellView;
import View.ClueCellView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GameController {
	

	GameBoardModel gbModel;	
	ArrayList <WordModel> wordObserverlist;

	/**
	 * Default constructor which assigns a new gameboard
	 * @param gbm
	 */
	public GameController () {
		gbModel = new GameBoardModel ();
	}
	
	/**
	 * Constructor which has a gameBoardModelSet
	 * @param gbm
	 */
	public GameController (GameBoardModel gbm) {
		gbModel = gbm;
	}
	
	/**
	 * to update the cell model based on the views event method triggered in view class
	 * @param number
	 * @param cv
	 */
	public void sendToCellModel(String number, CellView cv) { 
		cv.getObserverList().update(number); //updates the cell model associated to the cell view
		sendToWordModel(cv.getObserverList()); //updates all word models associated to the cell model
	}
	
	/**
	 * updates all wordModels that have the CellModel
	 * @param cm
	 */
	public void sendToWordModel(CellModel cm) { 
		cm.getWordObserverlist().forEach(wordObj -> wordObj.validateWord());
	}
	
	/**
	 * updates the validate text for the gameboard
	 */
	public void sendToGameModel() { 
		gbModel.update();
	}
	
	/**
	 * Setting a specific word model at a specific index of the game board model
	 */
	public void addToGameBoardModelArray(int index, WordModel wm) {
		gbModel.setWordModelAtIndex(index,wm);
	}

	public void saveGame(View.BoardView boardView, String filename) throws IOException {
		JSONObject json_output = new JSONObject();

		int size = gbModel.getLength();
		json_output.put("size", size);

		JSONArray cell_array = new JSONArray();
		JSONArray word_array = new JSONArray();
		for (int i=0; i < cell_values.length; i++) {
			JComponent component = boardView.getComponentAt(i);
			int correctValue = 0;
			int currentValue = 0;
			if (component instanceof CellView) {
				CellView cellView = (CellView) component;
				correctValue = cellView.getObserverList().getCorrectNumber();
				currentValue = cellView.getObserverList().getUserNumber();
			} else if (component instanceof ClueCellView) {
				ClueCellView clueCellView = (ClueCellView) component;
				WordModel rightWord = clueCellView.getRightWord();
				WordModel bottomWord = clueCellView.getBottomWord();
				if (rightWord != null) {
					JSONObject right_obj = new JSONObject();
					right_obj.put("vertical", false);
					right_obj.put("sum", rightWord.getTotalForWord());
					right_obj.put("index", i);
					JSONArray cell_indices = new JSONArray();

					CellModel[] cellModels = rightWord.getCellModelArray();
					for (int j=0; j < cellModels.length; j++) {
						CellView cm_cellView = cellModels[j].getCellView();
						cell_indices.add(cm_cellView.getIndex());
					}

					right_obj.put("cell_indices", cell_indices);
				}
				if (bottomWord != null) {
					JSONObject bottom_obj = new JSONObject();
					bottom_obj.put("vertical", true);
					bottom_obj.put("sum", bottomWord.getTotalForWord());
					bottom_obj.put("index", i);
					JSONArray cell_indices = new JSONArray();

					CellModel[] cellModels = bottomWord.getCellModelArray();
					for (int j=0; j < cellModels.length; j++) {
						CellView cm_cellView = cellModels[j].getCellView();
						cell_indices.add(cm_cellView.getIndex());
					}

					bottom_obj.put("cell_indices", cell_indices);
				}
			}
			JSONObject cell_object = new JSONObject();
			cell_object.put("correct", correctValue);
			cell_object.put("current", currentValue);
			cell_array.add(cell_array);
		}
		json_output.put("cells", cell_array);
		json_output.put("words", word_array);

		FileWriter writer = new FileWriter(filename);
		writer.write(json_output.toJSONString());
		writer.flush();
	}
}