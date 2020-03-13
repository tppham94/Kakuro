package View;

import java.awt.GridLayout;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

//import javafx.scene.control.Cell;


import Controller.GameController;
import Model.WordModel;
import Model.CellModel;

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
		controller = new GameController();
		jf = new JFrame("Kakuro");

		JSONObject kakuro = null;  //create JSON object to parse input JSON file
		try {
			kakuro = (JSONObject) new JSONParser().parse(new FileReader("/Users/stefanoscalzo/Documents/GitHub/Kakuro/src/game1.json"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//getting game size element to create the metrics that will created the correct board size for the game.
		int size = (int) (long) kakuro.get("size");
		int gameSize = (int) size;
	    // array for the cells to be added to our game board    
		gameComponents = new JComponent[gameSize*gameSize];
	 		
		//create the array for the cells to populate the correct cell values
		JSONArray cellsArray = (JSONArray) kakuro.get("cells");
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
//        Iterator<String> iterator = cellsArray.iterator();
//        int indexVal = 0;
//        while(iterator.hasNext()) {
//            if (!iterator.next().contentEquals("0")) // check to only populate the Cellviews containing the correct answer
//            {	CellView cellView = new CellView();
//                CellModel cellModel = new CellModel(indexVal, cellView);
//                CellView.addModelToObserverList(cellModel); // Check these with Stefano
//                CellModel.registerObserver(cellView); // Check these with Stefano
//                gameComponents[indexVal] = cellView;
//            }
//            indexVal++;
//        }
		
        
		JSONArray wordsArray = (JSONArray) kakuro.get("words"); // create JSON array for the words
        for (int i=0; i < wordsArray.size(); i++) {
        	JSONObject jsonWordObj = (JSONObject) wordsArray.get(i);
        	int row = (int) (long) jsonWordObj.get("row");
        	int col = (int) (long) jsonWordObj.get("col");
			boolean vertical = (boolean) jsonWordObj.get("vertical");
			int sum = (int) (long) jsonWordObj.get("sum");
			JSONArray cell_indices = (JSONArray) jsonWordObj.get("cell_indices");

        	int word_size = cell_indices.size();

        	ClueCellView clue_cell = (ClueCellView) gameComponents[row * size + col];
        	WordModel new_word = new WordModel(size, sum);
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


//        Iterator itr2 = wordsArray.iterator();
//
//        while(itr2.hasNext()) { // loop through the JSON words array to get the value of the elements
//        	JSONObject innerObj = (JSONObject) itr2.next();
//        	long lrow = (long) innerObj.get("row");
//        	long lcol = (long) innerObj.get("col");
//        	JSONArray wordArray = (JSONArray) innerObj.get("cell_indices");
//        	int wSize = wordArray.size();
//        	long totalForWord = (long) innerObj.get("sum");
//
//        	if (gameComponents[((int) lrow * gameSize) + (int)lcol] == null) //check if component already has clueView assigned.
//        	{
//        		if ((boolean) innerObj.get("vertical").equals("false")) //check if right or down direction of clue
//        		{
//        			ClueCellView newClueCellVie
//        			gameComponents[((int) lrow * gameSize) + (int)lcol] = new ClueCellView();
//        		}
//        		else
//        		{gameComponents[((int) lrow * gameSize) + (int)lcol] = new ClueCell(new ClueCellModel("", Long.toString(totalForWord)));}
//        	}
//        	WordModel WorldModel = new  WordModel((int) wSize, (int) totalForWord, ((int) lrow * gameSize) + (int) lcol);
//        }
//
//        for (int i = 0; i < gameComponents.length; i++) // go get the null components and assign a blank cell to it
//        {
//			if(gameComponents[i] == null)
//			{
//				gameComponents[i] = new ClueCell(new ClueCellModel("", ""));
//			}
//		}
        
		// Binding components with the controller
//		controller.bindTextCells(gameComponents);
		
		addComponentsToJFrame();
		setVisualLayout(gameSize+1, gameSize);
		addValidateButton();
//		validateButton.addActionListener(controller);

		//added it2
		notifyChange();
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