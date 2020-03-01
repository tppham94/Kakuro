package View;

import java.awt.Color;


import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import Controller.GameController;
import Model.CellModel;

public class CellView extends JTextField {
	int number;
	boolean valid;
	GameController gameController;
	
	public CellView () {
		
		
		
		this.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				sendToController();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				sendToController();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				sendToController();
			}
			
		});
	}
	
	public void sendToController() {
		gameController.sendToCellModel(this.getText());
	}

	
	public void setVisualConfiguration() {
		super.setOpaque(true);
		super.setBackground(Color.WHITE);
		super.setForeground(Color.BLACK);
		super.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		this.setHorizontalAlignment(JTextField.CENTER);
	}
	
	public void setTextField (int number) {
		this.number = number;
		this.setText(Integer.toString(number));
	}
	
	public void setValid (boolean valid) {
		this.valid = valid;
		setBackgroundColor();
	}
	
	public void setController (GameController gameController) {
		this.gameController = gameController;
	}
	
	public void setBackgroundColor () {
		if (valid) {
			this.setBackground(Color.GREEN);
		}
		else this.setBackground(Color.RED);
	}
}
