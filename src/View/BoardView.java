package View;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

//import javafx.scene.control.Cell;


import Controller.GameController;
import Controller.TrainingController;
import Model.WordModel;
import Model.CellModel;
import Model.GameBoardModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BoardView extends JPanel {
	// REMOVE the JFrame Stuff and convert it to JPanel

	JButton validateButton;
	JComponent[] gameComponents;
	private JPanel boardPanel;

	GameController controller;

	ValidateView vView;
	ValidateButtonView vBtnView;

	// Constructor called by Game Driver
	public BoardView(boolean trainingMode) {
		GameBoardModel gbm = new GameBoardModel();
		if (trainingMode) {
			controller = new TrainingController(gbm);
		} else {
			controller = new GameController(gbm);
		}
	}

	public void setTrainingMode(boolean trainingMode) {
		GameBoardModel gbm = controller.getGameBoardModel();
		if (trainingMode) {
			controller = new TrainingController(gbm);
		} else {
			controller = new GameController(gbm);
		}
		boardPanel = new JPanel(new GridLayout(1 , 1));
		boardPanel.setPreferredSize(new Dimension(600,600));
	}


	public void initComponents(JSONObject jsonObject){
		//boardPanel = new JPanel(new GridLayout());

		int counter =0;
		//jf = new JFrame("Kakuro");

		JSONObject kakuro = null;  //create JSON object to parse input JSON file
		try {
			kakuro = (JSONObject) new JSONParser().parse(new FileReader(".\\src\\game1.json"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//getting game size element to create the metrics that will created the correct board size for the game.
		int size = (int) (long) kakuro.get("size");
		// array for the cells to be added to our game board
		gameComponents = new JComponent[size*size];

		//create the array for the cells to populate the correct cell values
		JSONArray cellsArray = (JSONArray) kakuro.get("cells");
		handleCellsCalls(cellsArray);


		JSONArray wordsArray = (JSONArray) kakuro.get("words"); // create JSON array for the words
		controller.initializeWordModelArray(wordsArray.size());
		handleWordCalls(wordsArray);

		vView = new ValidateView();
		vBtnView = new ValidateButtonView("Vals",controller);


		//boardPanel.add(addComponentsToJFrame());
		//addComponentsToJFrame();
		boardPanel = new JPanel(new GridLayout(size+1 , size));
		boardPanel.setPreferredSize(new Dimension(600,600));
		for (int i = 0; i < gameComponents.length; i++) {
			boardPanel.add(gameComponents[i]);
		}
		//boardPanel.setLayout(new GridLayout(gameSize+1, gameSize));
		// setVisualLayout(gameSize+1, gameSize);
		boardPanel.add(vBtnView);
		boardPanel.add(vView);
		add(boardPanel);
	}

	//uses the cellsArray to initialize the game components with the corect cluecellView or Cellview.
	private void handleCellsCalls(JSONArray cellsArray) {
		for (int i=0; i < cellsArray.size(); i++) {
			int value = (int) (long) cellsArray.get(i);
			if (value == 0) {
				gameComponents[i] = new View.ClueCellView();
			} else {
				View.CellView cellView = new View.CellView(controller);
				CellModel cellModel = new CellModel(value, cellView);
				cellView.addModelToObserverList(cellModel);
				gameComponents[i] = cellView;
			}
		}

	}

	// uses wordArray to pass the correct values to ClueCell View and Cell and Word models
	private void handleWordCalls(JSONArray wordsArray) {
		int counter =0;
		for (int i=0; i < wordsArray.size(); i++) {
			JSONObject jsonWordObj = (JSONObject) wordsArray.get(i);
			int index = (int) (long) jsonWordObj.get("index");
			boolean vertical = (boolean) jsonWordObj.get("vertical");
			int sum = (int) (long) jsonWordObj.get("sum");
			JSONArray cell_indices = (JSONArray) jsonWordObj.get("cell_indices");

			int word_size = cell_indices.size();

			View.ClueCellView clue_cell = (View.ClueCellView) gameComponents[index];
			WordModel new_word = new WordModel(word_size, sum);
			controller.addToGameBoardModelArray(counter++,new_word);
			System.out.println(jsonWordObj.toString());
			for (int j = 0; j < cell_indices.size(); j++) {
				System.out.println("\t" + cell_indices.get(j));
				CellModel cell_model = ((View.CellView)gameComponents[(int)(long)cell_indices.get(j)]).getObserverList();
				new_word.setCellModelArrayAtIndex(j, cell_model);
			}

			if (vertical) {
				clue_cell.setBottomWord(new_word);
			} else {
				clue_cell.setRightWord(new_word);
			}
		}

	}


	// Adding visual layout to jframe
	private void setVisualLayout(int actualRows, int actualCols) {

		setLayout(new GridLayout(actualRows, actualCols));
		System.out.println(this);
		//setVisible(true);
		//removed the jf in front of them
	}

	// Adding J-components to the grid
	private void addComponentsToJFrame() {
		for (int i = 0; i < gameComponents.length; i++) {
			add(gameComponents[i]);
		}
	}

	public JPanel getBoardPanel(){
		return this.boardPanel;
	}

	public JComponent getComponentAt(int i) {
		return this.gameComponents[i];
	}

	public GameController getController() {
		return controller;
	}

}