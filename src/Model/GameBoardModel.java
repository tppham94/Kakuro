/**
 * Author: Stefano Scalzo
 * Game board model at any given time maintains the current state of the game. 
 * The GameBoardModel class is notified any time the user enters a new text or 
 * the user clicks the validateButtonView button. 
 * It will take the value entered by the user and send it to it's corresponding cellModel. 
 * It will then notify all the proper wordModel's associated to that cellModel that they must validate themselves. 
 * Lastly it will tell the gameBoardModel to validate it's rowModel array. 
 */

package Model;

import View.ValidateView;

public class GameBoardModel {
    WordModel[] wordModelArray; //the array of words that the GameBoardContains
    boolean valid; //the boolean if the whole game is valid. Meaning all words are valid
    String whatNeedsToBeFixed; //the string which will be sent to the validateView
    int length; //the total length of the view
    ValidateView validateView; // the text that says valid invalid or what errors it has

    /**
     * def constructor with 100 word containers
     */
    public GameBoardModel() {
        wordModelArray = new WordModel[34];
        valid = false;
    }

    /**
     * boardgamewith size initialized by user
     *
     * @param size
     */
    public GameBoardModel(int size) {
        wordModelArray = new WordModel[size];
        valid = false;
    }

    /**
     * boardgamewith size initialized by user
     *
     * @param size
     * @param length
     */
    public GameBoardModel(int size, int length) {
        wordModelArray = new WordModel[size];
        valid = false;
        this.length = length;
    }

    /**
     * update method that updates the board based on boolean's for speed
     *
     * @return
     */
    public boolean update() {
        for (int i = 0; i < wordModelArray.length; i++) {
            if (wordModelArray[i].isWordIsValid() == false) {
                valid = false;
                validateView.updateString("Sorry that isn't right. Please try again");
                break;
            }
            validateView.updateString("Congratulations! You won");
            valid = true; // will only reach at end if doesn't break for loop meaning it is good
        }
        return valid;
    }

    /**
     * update method that updates the board based on boolean's for speed
     *
     * @return
     */
    public boolean updateTraining() {
        for (int i = 0; i < wordModelArray.length; i++) {
            if (wordModelArray[i].isWordIsValid() == false) {
                valid = false;
                validateView.updateString(whatNeedsToBeFixed);
                break;
            }
            validateView.updateString(whatNeedsToBeFixed);
            valid = true; // will only reach at end if doesn't break for loop meaning it is good
        }

        return valid;
    }


    /**
     * Mutator to set a specific word at an index
     *
     * @param index
     * @return
     */
    public void setWordModelAtIndex(int index, WordModel wm) {
        wordModelArray[index] = wm;
    }

    /**
     * Accessor to get a specific word at an index
     *
     * @param index
     * @return
     */
    public WordModel getWordModelAtIndex(int index) {
        return wordModelArray[index];
    }

    /**
     * accessor for the message "printed" to the user in the validateView
     *
     * @return
     */
    public String getWhatNeedsToBeFixed() {
        return whatNeedsToBeFixed;
    }

    /**
     * this will be the message "printed" to the user in the validateView
     *
     * @param whatNeedsToBeFixed
     */
    public void setWhatNeedsToBeFixed(String whatNeedsToBeFixed) {
        this.whatNeedsToBeFixed = whatNeedsToBeFixed;
    }

    public int getWordModelCount() {
        return wordModelArray.length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void initializeWordModelArray(int size) {
        wordModelArray = new WordModel[size];
    }
    
    public void setValidateView(ValidateView vView) {
    	validateView = vView;
    }
}
