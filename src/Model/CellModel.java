package Model;

import java.util.ArrayList;

import Controller.GameController;
import View.CellView;

public class CellModel {
	int correctNumber;
	int userNumber;
	boolean isCorrect;
	CellView view = new CellView();
	ArrayList <WordModel> wordObserverlist = new ArrayList <WordModel> (1);
	
	
	public CellModel() {
		isCorrect = false;
	}
	
	public CellModel(int correct) {
		correctNumber = correct;
		isCorrect = false;
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
	
	public boolean update(String str) { //method to update model which will be used by controller
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
			} 
			return true;
		}
		else {
			isCorrect=false;
			setViewsValidity();
			return false;
		}
	}
	
	public String updateTraining(String str) { //method to update model which will be used by controller
		String validationSentnce= "";
		if (isDigit(str)) {
			userNumber = Integer.parseInt(str);
			setViewsTextValidate();
			if(isSignleDigit(str)) {
				if(isCorrectNumber(userNumber)) {
					setCorrect(true);
					validationSentnce = "and that number is Correct";
				}
				else {
					validationSentnce = " but that number is InCorrect";

					setCorrect(false);
				}
			} 
			return "Success at updating number"+validationSentnce;
		}
		else {
			isCorrect=false;
			setViewsValidity();
			return "Sorry not a number in between 1-9";
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
	
	public boolean isCorrectNumber (int userValue) { //method to check if it is a correct number
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
	
	public CellView getCellView () { //method to return the view, this will be used by the controller to have the same reference
		return view;
	}
	
	public void setViewsText () { //used to update the view on the new number
		view.setTextField(userNumber);
		setViewsValidity();
	}
	
	public void setViewsTextValidate () { //used to update the view on the new number and color
		view.setTextField(userNumber);
		setViewsValidityTraining();
	}
	
	public void setViewsValidityTraining () { //method to update the views background coller
		view.setValidTraining(isCorrect);
	}
	
	public void setViewsValidity () { //method to update the views background coller
		view.setValid(isCorrect);
	}
	
	public ArrayList<WordModel> getWordObserverlist() {
		return wordObserverlist;
	}
	
}
