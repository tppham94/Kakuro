package View;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.GameController;
import Model.CellModel;

public class CellView extends JTextField{
	CellModel model;
	int number;
	boolean valid;
	
	public CellView (GameController gameController) {
		this.addFocusListener(gameController);
		setVisualConfiguration();
	}
	
	public void setVisualConfiguration() {
		super.setOpaque(true);
		super.setBackground(Color.WHITE);
		super.setForeground(Color.BLACK);
		super.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		this.setHorizontalAlignment(JTextField.CENTER);
	}
}
