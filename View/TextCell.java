package View;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.GameController;

public class TextCell extends JTextField implements Square {

	private String cellValue;

	public TextCell(GameController gameController) {

		this.addFocusListener(gameController);
		draw();
	}

	@Override
	public void draw() {
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
