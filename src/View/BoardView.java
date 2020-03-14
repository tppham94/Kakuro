package View;

import java.awt.GridLayout;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import Controller.GameController;
import Controller.TrainingController;
import Model.WordModel;
import Model.CellModel;
import Model.GameBoardModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BoardView {

	GameController controller;
	JButton validateButton;
	JComponent[] gameComponents;
	JFrame jf;

	// Constructor called by Game Driver
	public BoardView() {
		
		GameBoardModel gbm = new GameBoardModel(34);
		controller = new TrainingController(gbm);
		jf = new JFrame("Kakuro");

		JSONObject kakuro = null;  //create JSON object to parse input JSON file
		kakuro = (JSONObject) readJSONFile();
		
		//getting game size element to create the metrics that will created the correct board size for the game.
		int size = (int) (long) kakuro.get("size");
		
	    // array for the cells to be added to our game board   
		gameComponents = new JComponent[size*size];
	 		
		//create the array for the cells to populate the correct cell values
		JSONArray cellsArray = (JSONArray) kakuro.get("cells");
		handleCellsCalls(cellsArray);
		
		JSONArray wordsArray = (JSONArray) kakuro.get("words"); // create JSON array for the words
		handleWordssCalls(wordsArray, size);
		 
		
		addComponentsToJFrame();
		setVisualLayout(size+1, size);
		addValidateButton();
//		validateButton.addActionListener(controller);

		//added it2
		notifyChange();
	}

	// imports the JSON file for the game
	private JSONObject readJSONFile() {
		JSONObject inputFile = null;
		try {
			inputFile = (JSONObject) new JSONParser().parse(new FileReader("C:\\Users\\mario.lapadula\\eclipse-workspace\\Stefano_branch\\src\\game1.json"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return inputFile;
	}

	//uses the cellsArray to initialize the game components with the corect cluecellView or Cellview.
	private void handleCellsCalls(JSONArray cellsArray) {
		for (int i=0; i < cellsArray.size(); i++) {
			int value = (int) (long) cellsArray.get(i);
			if (value == 0) {
				gameComponents[i] = new ClueCellView();
			} else {
				CellView cellView = new CellView(controller);
				CellModel cellModel = new CellModel(value, cellView);
				cellView.addModelToObserverList(cellModel);
				gameComponents[i] = cellView;
			}
		}
		
	}

	// uses wordArray to pass the correct values to ClueCell View and Cell and Word models
	private void handleWordssCalls(JSONArray wordsArray, int size) {
		int counter =0;
		for (int i=0; i < wordsArray.size(); i++) {
        	JSONObject jsonWordObj = (JSONObject) wordsArray.get(i);
        	int row = (int) (long) jsonWordObj.get("row");
        	int col = (int) (long) jsonWordObj.get("col");
			boolean vertical = (boolean) jsonWordObj.get("vertical");
			int sum = (int) (long) jsonWordObj.get("sum");
			JSONArray cell_indices = (JSONArray) jsonWordObj.get("cell_indices");

        	int word_size = cell_indices.size();
        		
        	ClueCellView clue_cell = (ClueCellView) gameComponents[row * size + col];
        	WordModel new_word = new WordModel(word_size, sum);
        	controller.addToGameBoardModelArray(counter++,new_word);
        	System.out.println(jsonWordObj.toString());
        	for (int j = 0; j < cell_indices.size(); j++) {
				System.out.println("\t" + cell_indices.get(j));
				CellModel cell_model = ((CellView)gameComponents[(int)(long)cell_indices.get(j)]).getObserverList();
        		new_word.setCellModelArrayAtIndex(j, cell_model);
			}

        	if (vertical) {
        		clue_cell.setBottomWord(new_word);
			} else {
        		clue_cell.setRightWord(new_word);
			}
		}
		
	}
	
	// Adding validate button
	private void addValidateButton() {
		validateButton = new JButton("validate");
		validateButton.setToolTipText("Validate");
		jf.add(validateButton);
	}

	// Adding visual layout to jframe
	private void setVisualLayout(int actualRows, int actualCols) {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(600, 600);
		jf.setLayout(new GridLayout(actualRows, actualCols));
		jf.setVisible(true);

	}

	// Adding J-components to the grid
	private void addComponentsToJFrame() {
		for (int i = 0; i < gameComponents.length; i++) {
			jf.add(gameComponents[i]);
		}
	}

	//added it2
	private void notifyChange(){

	}
}