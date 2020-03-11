package View;

import java.awt.GridLayout;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Controller.GameController;
import Model.ClueCellModel;
import Model.WorldModel;
import Model.BlankModel;

public class BoardView {

	GameController controller;
	JButton validateButton;
	JComponent[] gameComponents;
	JFrame jf;

	// Constructor called by Game Driver
	public BoardView() {
		controller = new GameController();
		jf = new JFrame("Kakuro");
		
		 Object obj = new JSONParser().parse(new FileReader("game1.json"));  //create JSON object to parse input JSON file
         
	     // typecasting obj to JSONObject 
	     JSONObject kakuro = (JSONObject) obj; 
	          
	    //getting game size element to create the variables that will created the correct board size for the game. 
	    long gameSize = (long) kakuro.get("size");
	    int realSize = (int) (gameSize*gameSize);
	    int actualRows = (int) (gameSize+1);
	    int actualCols = (int) (gameSize);
		
	    // array for the cells to be added to our game board    
		gameComponents = new JComponent[realSize];
		
		//create the array for the cells to populate the correct cell values
		JSONArray cellsArray = (JSONArray) kakuro.get("cells");
        Iterator<String> iterator = cellsArray.iterator();
        int indexVal = 0;
        while(iterator.hasNext()) {
            if (!iterator.next().contentEquals("0")) // check to only populate the Cellviews containing the correct answer
            {	gameComponents[indexValue] = new CellView(new CellModel(iterator.next(), CellView()));   
            }	
            indexVal++;
        }
		
        
        JSONArray wordsArray = (JSONArray) jo.get("words"); // create JSON array for the words 
        
        Iterator itr2 = wordsArray.iterator();
       
        while(itr2.hasNext()) { // loop through the JSON words array to get the value of the elements
        	JSONObject innerObj = (JSONObject) itr2.next();
        	long lrow = (long) innerObj.get("row");
        	long lcol = (long) innerObj.get("col");
        	JSONArray wordArray = (JSONArray) innerObj.get("cell_indices"); 
        	int wSize = wordArray.size();
        	long totalForWord = (long) innerObj.get("sum");
        	
        	if (gameComponents[(int) lrow * realSize] == null) //check if component already has clueView assigned.
        	{
        		if ((boolean) innerObj.get("vertical").equals("false")) //check if right or down direction of clue
        		{
        			gameComponents[(int) lrow * realSize] = new ClueView(new ClueCellModel(Long.toString(totalForWord), ""));
        		}
        		else
        		{
        			gameComponents[(int) lrow * realSize] = new ClueView(new ClueCellModel("",Long.toString(totalForWord)));
        		}
        	}
        	new WorldModel((int) wSize, (int) totalForWord, ((int) lrow * realSize) + (int) lcol);
        }

        for (int i = 0; i < gameComponents.length; i++) // go get the null components and assign a blank cell to it
        {	
			if(gameComponents[i] == null)
			{
				gameComponents[i] = new BlankView=(new BlankModel());
			}
		}
        
		//initializeGameComponents(); not needed anymore
		// Binding components with the controller
		controller.bindTextCells(gameComponents);
		
		addComponentsToJFrame();
		setVisualLayout(actualRows, actualCols);
		addValidateButton();
		validateButton.addActionListener(controller);

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