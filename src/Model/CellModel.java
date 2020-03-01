package Model;

import Controller.GameController;
import View.CellView;

public class CellModel {
	int correctNumber;
	int userNumber;
	boolean isCorrect;
	CellView view = new CellView();
	
	public CellModel() {
		isCorrect = false;
	}
	
	public CellModel(int correct) {
		correctNumber = correct;
		isCorrect = false;
	}
	
	public boolean update(String str) { //method to update model which will be used by controller
		if (isDigit(str)) {
			userNumber = Integer.parseInt(str);
			setViewsText();
			if(isSignleDigit(str)) {
				if(isCorrectNumber(userNumber,correctNumber)) {
					setCorrect(true);
				}
				else {
					setCorrect(false);
				}
			} 
			return true;
		}
		else {
			isCorrect=false;
			setViewsValidity();
			return false;
		}
	}
	
	public boolean isDigit (String str) { //method to check if  the string is a digit
		if (str.matches("\\d+")) return true;
		else return false;
	}
	
	public boolean isSignleDigit (String str) { //method to check if string is a single digit
		if (str.matches("[1-9]")) return true;
		else return false;
	}
	
	public boolean isCorrectNumber (int userValue, int correctValue) { //method to check if it is a correct number
		if (userValue==correctValue) {
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
	
	public CellView getCellView () { //method to return the view, this will be used by the controller to have the same reference
		return view;
	}
	
	public void setViewsText () { //used to update the view on the new number
		view.setTextField(userNumber);
		setViewsValidity();
	}
	
	public void setViewsValidity () { //method to update the views background coller
		view.setValid(isCorrect);
	}
	
}
