package Model;

import java.util.ArrayList;

import Controller.GameController;
import View.CellView;

public class CellModel {
	int correctNumber; //the correct number associated to that cell
	int userNumber; //the user's number being entered by the user
	boolean isCorrect; //that cell's validity status
	CellView view = new CellView(); //the cell view which the model has to update
	
	//the word model array of maximum size 2,
	//will be updated every time there is a change done to the cell model
	//need a reference to both words that it belongs to s that they can be updated
	ArrayList <WordModel> wordObserverlist = new ArrayList <WordModel> (1);
	
	//def constructor which sets isCorrect to false
	public CellModel() {
		isCorrect = false;
	}
	
	//constructor which take correct number and sets the default correct value to false
	public CellModel(int correct) {
		correctNumber = correct;
		isCorrect = false;
	}
	
	
	public CellModel(int correct, CellView cv) {
		correctNumber = correct;
		isCorrect = false;
		view =cv;
	}
	
	public CellModel(int correct, WordModel wordModel1) {
		correctNumber = correct;
		isCorrect = false;
		
		wordObserverlist.add(wordModel1);
	}
	
	public CellModel(int correct, WordModel wordModel1,WordModel wordModel2 ) {
		correctNumber = correct;
		isCorrect = false;
		
		wordObserverlist.add(wordModel1);
		wordObserverlist.add(wordModel2);
	}
	
	
	public CellModel(int correct, WordModel wordModel1,WordModel wordModel2, CellView  cv) {
		correctNumber = correct;
		isCorrect = false;
		view= cv;
		
		wordObserverlist.add(wordModel1);
		wordObserverlist.add(wordModel2);
	}
	
	//method to update the word model which will be used by controller
	public boolean update(String str) { 
		System.out.println("str:"+str);
		if (isDigit(str)) {
			userNumber = Integer.parseInt(str);
			setViewsText();
			if(isSignleDigit(str)) {
				if(isCorrectNumber(userNumber)) {
					setCorrect(true);
				}
				else {
					setCorrect(false);
				}
				return true;
			}
			else {
				isCorrect=false;
				userNumber = Integer.parseInt(str);
				return false;
			}
		}
		else {
			isCorrect=false;
			userNumber = 0;
			return false;
		}

	}
	
	//method to update model which will be used by controller it returns a string which will be used by the training controller
	//and will show why the precise reason is that the number is wrong
	public String updateTraining(String str) { 
		String validationSentnce= "";
		if (isDigit(str)) {
			userNumber = Integer.parseInt(str);
			if(isSignleDigit(str)) {
				if(isCorrectNumber(userNumber)) {
					setCorrect(true);
					setViewsTextValidate();
					validationSentnce = "Success at updating number and that number is Correct";
					return validationSentnce;
				}
				else {
					setCorrect(false);
					setViewsTextValidate();
					validationSentnce = "Success at updating number but that number is InCorrect";
					return validationSentnce;
				}
			} 
			else {
				setCorrect(false);
				setViewsTextValidate();
				validationSentnce = "Number must be single digit";
				return validationSentnce;
			}
		}
		else {
			userNumber = 0;
			isCorrect=false;
			setViewsTextValidate();
			return "Sorry not a number in between 1-9";
		}
	}
	
	//method to check if  the string is a digit
	public boolean isDigit (String str) { 
		if (str.matches("\\d+")) return true;
		else return false;
	}
	
	//method to check if string is a single digit
	public boolean isSignleDigit (String str) { 
		if (str.matches("[1-9]")) return true;
		else return false;
	}
	
	//method to check if it is a correct number
	public boolean isCorrectNumber (int userValue) { 
		if (userValue==correctNumber) {
			setCorrect(true);
			return true;
			}
		
		else {
			setCorrect(false);
			return false;
		}
	}
	
	public void setCorrect (boolean correct) { //setter for correct
		isCorrect = correct;
	}
	
	public boolean getIsCorrect () { //setter for correct
		return isCorrect;
	}
	
	//method to return the cell view,
	//this will be used by the controller to have the same reference
	public CellView getCellView () { 
		return view;
	}
	
	//Mutator for cellview
	public void setCellView (CellView cv) { 
		 view = cv;
	}
	
	//method to update the cell view on the new number
	public void setViewsText () { 
		if(view.getText()!=Integer.toString(userNumber)) {
			view.setTextField(userNumber);
			setViewsValidity();
		}
	}
	
	//method to update the view on the new number and color
	public void setViewsTextValidate () { 
		view.setTextField(userNumber);
		setViewsValidityTraining();
	}
	
	//method to update the cell view's background color
	public void setViewsValidityTraining () { 
		view.setValidTraining(isCorrect);
	}
	
	public void setViewsValidity () { //method to update the views background color
		view.setValid(isCorrect);
	}
	
	public void addToObserverList (WordModel wm) {
		this.wordObserverlist.add(wm);
	}
	
	
	public ArrayList<WordModel> getWordObserverlist() {
		return wordObserverlist;
	}
	
}
