package View;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import Controller.GameController;

@SuppressWarnings("serial")
public class TextCell extends JTextField {

	private String expectedValue;

	public TextCell(GameController gameController, String expectedValue) {
		this.expectedValue = expectedValue;
		this.addFocusListener(gameController);
		setVisualConfiguration();
	}

	public String getExpectedValue() {
		return expectedValue;
	}

	public void setVisualConfiguration() {
		super.setOpaque(true);
		super.setBackground(Color.WHITE);
		super.setForeground(Color.BLACK);
		super.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		this.setHorizontalAlignment(JTextField.CENTER);
	}

	public char[] getvalue() {
		return null;
	}
}
