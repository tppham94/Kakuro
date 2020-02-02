package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import View.TextCell;

public class GameController implements ActionListener, FocusListener {

	JComponent[] gameComponent;
	
	//This action is performed when validation button is clicked 
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean flag = false;
		for (int i = 0; i < gameComponent.length; i++) {
			if (gameComponent[i] instanceof TextCell) {
				TextCell textCell = (TextCell) gameComponent[i];
				if (textCell.getText().equals(textCell.getExpectedValue())) {
					textCell.setBackground(Color.GREEN);
					continue;
				} else {
					flag = true;
					textCell.setBackground(Color.red);
				}
			}
		}
		if (flag == true) {
			((JButton) e.getSource()).setBackground(Color.RED);
			JOptionPane.showMessageDialog(null, "Try Again!");
			((JButton) e.getSource()).setBackground(new JButton().getBackground());
		} else {
			((JButton) e.getSource()).setBackground(Color.GREEN);
			JOptionPane.showMessageDialog(null, "Well Played!");
		}
	}

	public void bindTextCells(JComponent[] gameComponent) {
		this.gameComponent = gameComponent;
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

		String cellValue = ((TextCell) e.getSource()).getText();

		if (cellValue == null || "".equalsIgnoreCase(cellValue)) {
			return;
		}

		int value = 0;

		try {
			value = Integer.parseInt(((TextCell) e.getSource()).getText());
		} catch (java.lang.Exception ex) {
			promptValidationError(e, "Value should be a digit.");
			return;
		}
		//Validation between 1-9
		if (value < 1 || value > 9) {
			promptValidationError(e, "Value should be between 1 and 9.");
			return;
		}
	}

	// Displays/Pop the error message
	private void promptValidationError(FocusEvent e, String errorMessage) {
		TextCell cell = ((TextCell) e.getSource());
		cell.setBackground(Color.red);
		JOptionPane.showMessageDialog(null, errorMessage);
		cell.setBackground(Color.white);
		cell.setText("");
	}
}
