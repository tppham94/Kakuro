package View;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import Controller.GameController;

@SuppressWarnings("serial")
public class TextCell extends JTextField {

	private String expectedValue;

	//Constructor
	public TextCell(GameController gameController, String expectedValue) {
		this.expectedValue = expectedValue;
		this.addFocusListener(gameController);
		setVisualConfiguration();
	}

	/**
	 * This method sets the visual Layout of the TextCell
	 */
	public void setVisualConfiguration() {
		super.setOpaque(true);
		super.setBackground(Color.WHITE);
		super.setForeground(Color.BLACK);
		super.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		this.setHorizontalAlignment(JTextField.CENTER);
	}

	/**
	 * This method Validates if the value entered by user matches the expected value
	 * @param userInputValue
	 * @return
	 */
	public boolean validateText(String userInputValue) {
		return expectedValue.equals(userInputValue);
	}
	
	// Getters and Setters
	
	public String getExpectedValue() {
		return expectedValue;
	}

}
