package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import Model.CellModel;
import Model.GameBoardModel;
import View.CellView;
import View.TextCell;

public class GameController implements ActionListener, FocusListener {
	
	CellModel model1 = new CellModel ();
	CellView view1 = model1.getCellView();
	GameBoardModel gbModel = new GameBoardModel ();
	
	
	JComponent[] gameComponents;
	
	
	
	public GameController () {
		view1.setController(this);
	}
	

	// This action is performed when validation button is clicked
	@Override
	public void actionPerformed(ActionEvent e) {

		if (validateGame()) {

			((JButton) e.getSource()).setBackground(Color.GREEN);
			JOptionPane.showMessageDialog(null, "Well Played!");

		} else {

			((JButton) e.getSource()).setBackground(Color.RED);
			JOptionPane.showMessageDialog(null, "Try Again!");
			((JButton) e.getSource()).setBackground(new JButton().getBackground());
		}
	}

	/**
	 * This method binds all game components to controller, so the controller can
	 * access cell values upon any action
	 * 
	 * @param gameComponent
	 */
	public void bindTextCells(JComponent[] gameComponent) {
		this.gameComponents = gameComponent;
	}

	/*
	 * this method is called when the text area gets active
	 */
	@Override
	public void focusGained(FocusEvent e) {
	}

	/*
	 * this method is called when the text area becomes inactive
	 */
	@Override
	public void focusLost(FocusEvent e) {

		String userInputValue = ((TextCell) e.getSource()).getText();

		// Validate if the cell is empty
		if(!validateNullInput(userInputValue)) {
			return;
		}

		// Validate if the text is a number
		if (!validateInputFormat(userInputValue)) {
			promptValidationError(e, "Value should be a digit.");
			return;
		}

		// Validate if the number is between 1 and 9
		if (!validateNumberRange(userInputValue)) {
			promptValidationError(e, "Value should be between 1 and 9.");
			return;
		}
	}

	/**
	 * This method checks if no value was entered in the cell
	 * 
	 * @param cellValue
	 * @return true if a value was entered. False is it is not
	 */
	public boolean validateNullInput(String cellValue) {

		if (cellValue == null || "".equalsIgnoreCase(cellValue)) {
			return false;
		}
		return true;
	}
	
	/**
	 * This method checks if the value entered in the cell is a digit
	 * 
	 * @param cellValue
	 * @return true if the value is a digit. False is it is not
	 */
	public boolean validateInputFormat(String cellValue) {
		try {
			Integer.parseInt(cellValue);
		} catch (java.lang.Exception ex) {
			return false;
		}
		return true;
	}

	/**
	 * This method checks if the value entered in the cell is between 1 and 9
	 * 
	 * @param cellValue
	 * @return true if the value lies with specified range. False if it is not
	 */
	public boolean validateNumberRange(String cellValue) {

		int value = Integer.parseInt(cellValue);
		if (value < 1 || value > 9) {
			return false;
		}
		return true;
	}

	/**
	 * This method validates the game by making sure all cells value matches the
	 * expected value
	 * 
	 * @param 
	 * @return true if the game is validated. False when game is not validated.
	 */
	public boolean validateGame() {

		boolean cellValidation = true;

		for (int i = 0; i < gameComponents.length; i++) {

			if (gameComponents[i] instanceof TextCell) {

				TextCell textCell = (TextCell) gameComponents[i];

				if (textCell.validateText(textCell.getText())) {
					textCell.setBackground(Color.GREEN);
					continue;
				} else {
					cellValidation = false;
					textCell.setBackground(Color.red);
				}
			}
		}
		return cellValidation;
	}

	// Displays/Pop the error message
	private void promptValidationError(FocusEvent e, String errorMessage) {

		TextCell cell = ((TextCell) e.getSource());
		cell.setBackground(Color.red);

		JOptionPane.showMessageDialog(null, errorMessage);

		cell.setBackground(Color.white);
		cell.setText("");
	}
	
	
	public void sendToCellModel(String number, CellView cv) { //to update the model based on the views event method triggered in view class
		cv.getObserverList().forEach(object -> { //upddates all cellModels that are references to the cell view
			object.update(number);
			object.getWordObserverlist().forEach(wordObj -> wordObj.validateWord()); //updates all wordModels that have the CellModel
			});
		gbModel.update();
	}
}
