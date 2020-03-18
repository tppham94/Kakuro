package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;

import Model.CellModel;
import Model.GameBoardModel;
import Model.WordModel;
import View.CellView;

public class TrainingController extends GameController {


    //default constructor
    public TrainingController() {
        super();
    }

    /**
     * Constructor which has a gameBoardModelSet
     *
     * @param gbm
     */
    public TrainingController(GameBoardModel gbm) {
        super();
        super.gbModel = gbm;
    }

    /**
     * to update all of the models based on the views event method triggered in view class
     * Needs to update at time of click so that the user can know what is wrong with that specific cell
     */
    public void sendToCellModel(String number, CellView cv) {
    	
    	if(number.contains("0")) number = number.substring(1);
    	if(!number.isEmpty()) {
    		if(number.matches("\\d{0}")) { //if there are no number
    				if(cv.getObserverList().getUserNumber()!=0) { //to stop infinite loop
    				sendGameModelText(cv.getObserverList(), number); // will change what is wrong text in the game model
        	        sendToWordModel(cv.getObserverList()); //updates the what needs to be fixed text and validates the word's associated to the model
    				}
    		}
    		else if(!(number.equals(Integer.toString(cv.getObserverList().getUserNumber())))) {
        sendGameModelText(cv.getObserverList(), number); // will change what is wrong text in the game model
        sendToWordModel(cv.getObserverList()); //updates the what needs to be fixed text and validates the word's associated to the model
        gbModel.updateTraining(); //will update the game board model with appropriate instructions for what's wrong which will update the JPanel
        	}
        }
    }

    /**
     * updates all of the word models associated to that cellModel and will update the text for the game board
     */
    public void sendToWordModel(CellModel cm) {
    	for(int i=0; i<cm.getWordObserverlist().size();i++) {
    		gbModel.setWhatNeedsToBeFixed(gbModel.getWhatNeedsToBeFixed() +
                    " " + cm.getWordObserverlist().get(i).validateWord());
    	}

    }

    /**
     * updates gameModel text which tells user what needs to be fixed
     *
     * @param cm
     * @param number
     */
    public void sendGameModelText(CellModel cm, String number) {
        gbModel.setWhatNeedsToBeFixed(cm.updateTraining(number)); // will set the string of what needs to be fixed
    }

    /**
     * updates gameBoard validity and updates Jpanel text
     */
    public void sendToGameModel() {
        gbModel.updateTraining(); //updates the validate text for the gameboard
    }
}


