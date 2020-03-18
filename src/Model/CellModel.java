/**
 * Author: Stefano Scalzo
 * The Cellmodel class contains methods to update the data stored for the corresponding cellView. 
 * It is notified by the controller when there is a new input by the user and does the correct validation. 
 * It will also notify a list of WordModel of observers to check their validation.
 */
package Model;

import java.util.ArrayList;

import Controller.GameController;
import View.CellView;

public class CellModel {
    int correctNumber; //the correct number associated to that cell
    int userNumber; //the user's number being entered by the user
    boolean isCorrect; //that cell's validity status
    CellView view = new CellView(); //the cell view which the model has to update

    /**
     * the word model array of maximum size 2,
     * will be updated every time there is a change done to the cell model
     * need a reference to both words that it belongs to s that they can be updated
     */

    ArrayList<WordModel> wordObserverlist = new ArrayList<WordModel>(1);

    /**
     * def constructor which sets isCorrect to false
     */
    public CellModel() {
        isCorrect = false;
    }

    /**
     * constructor which take correct number and sets the default correct value to false
     * it also takes a cellview so that it can update it
     */
    public CellModel(int correct, CellView cv) {
        correctNumber = correct;
        isCorrect = false;
        view = cv;
    }


    /**
     * method to update the word model which will be used by controller
     *
     * @param str
     * @return
     */
    public boolean update(String str) {
        System.out.println("str:" + str);
        if (isDigit(str)) {
            userNumber = Integer.parseInt(str);
            setViewsText();
            if (isSignleDigit(str)) {
                if (isCorrectNumber(userNumber)) {
                    setCorrect(true);
                } else {
                    setCorrect(false);
                }
                return true;
            } else {
                isCorrect = false;
                userNumber = Integer.parseInt(str);
                return false;
            }
        } else {
            isCorrect = false;
            userNumber = 0;
            return false;
        }

    }

    /**
     * method to update model which will be used by controller .
     * It returns a string which will be used by the training controller
     * and will show why the precise reason is that the number is wrong
     *
     * @param str
     * @return
     */

    public String updateTraining(String str) {
        String validationSentence = "";
        if (isDigit(str)) {
            userNumber = Integer.parseInt(str);
            if (isSignleDigit(str)) {
                if (isCorrectNumber(userNumber)) {
                    setCorrect(true);
                    setViewsTextValidate();
                    validationSentence = "Success at updating number and that number is correct !";
                    return validationSentence;
                } else {
                    setCorrect(false);
                    setViewsTextValidate();
                    validationSentence = "Success at updating number but that number is Incorrect !";
                    return validationSentence;
                }
            } else {
                setCorrect(false);
                setViewsTextValidate();
                validationSentence = "Number must be single digit !";
                return validationSentence;
            }
        } else {
            userNumber = 0;
            isCorrect = false;
            setViewsTextValidate();
            return "Sorry not a number in between 1-9 !";
        }
    }

    /**
     * method to check if  the string is a digit
     *
     * @param str
     * @return
     */
    public boolean isDigit(String str) {
        if (str.matches("\\d+")) return true;
        else return false;
    }

    /**
     * method to check if string is a single digit
     *
     * @param str
     * @return
     */
    public boolean isSignleDigit(String str) {
        if (str.matches("[1-9]")) return true;
        else return false;
    }

    /**
     * method to check if it is a correct number
     *
     * @param userValue
     * @return
     */
    public boolean isCorrectNumber(int userValue) {
        if (userValue == correctNumber) {
            setCorrect(true);
            return true;
        } else {
            setCorrect(false);
            return false;
        }
    }

    /**
     * setter for correct
     *
     * @param correct
     */
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    /**
     * setter for correct
     *
     * @return
     */
    public boolean getIsCorrect() {
        return isCorrect;
    }

    /**
     * Returns the correct value for the cell.
     * <p>
     * Used for saving the game.
     *
     * @return
     */
    public int getCorrectNumber() {
        return correctNumber;
    }

    /**
     * Returns the current value of the cell.
     * <p>
     * Used for saving the game.
     *
     * @return
     */
    public int getUserNumber() {
        return userNumber;
    }

    /**
     * method to return the cell view,
     * this will be used by the controller to have the same reference
     *
     * @return
     */

    public CellView getCellView() {
        return view;
    }

    /**
     * Mutator for cellview
     *
     * @param cv
     */
    public void setCellView(CellView cv) {
        view = cv;
    }

    /**
     * method to update the cell view on the new number
     */
    public void setViewsText() {
        if (view.getText() != Integer.toString(userNumber)) {
            view.setTextField(userNumber);
        }
    }

    /**
     * method to update the view on the new number and color
     */
    public void setViewsTextValidate() {
        view.setTextField(userNumber);
        setViewsValidityTraining();
    }

    /**
     * method to update the cell view's background color
     */
    public void setViewsValidityTraining() {
        view.setValidTraining(isCorrect);
    }

    /**
     * @param Adding a word model to the cell models observer list.
     */
    public void addToObserverList(WordModel wm) {
        this.wordObserverlist.add(wm);
    }

    /**
     * @param getting the cell model's list of words that it is subscribed to
     */
    public ArrayList<WordModel> getWordObserverlist() {
        return wordObserverlist;
    }

}
