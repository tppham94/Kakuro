package View;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import Controller.GameController;
//import Controller.TrainingController;
import Model.CellModel;
import Model.WordModel;

public class CellView extends JTextField {
	int number;
	boolean valid;
	GameController gameController;
	CellModel observerList;

	public CellView () {
		
		
		this.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) { //sends text to controller on  inuput
				// TODO Auto-generated method stub
				sendToController();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {//sends text to controller on  inuput
				// TODO Auto-generated method stub
				sendToController();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {//sends text to controller on  inuput
				// TODO Auto-generated method stub
				sendToController();
			}
			
		});
	}
	
	public CellView (GameController gbc) { //cellView with controller
		this.gameController = gbc;
		
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
	
//	public CellView (TrainingController tc) { //cellView with controller
//		this.gameController = tc;
//
//		this.getDocument().addDocumentListener(new DocumentListener() {
//
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				sendToController();
//
//			}
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				sendToController();
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				sendToController();
//			}
//
//		});
//	}
	
	
	public void sendToController() { // send the number as a string to the controller which will send the updated number to its observer
		gameController.sendToCellModel(this.getText(), this);
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
	}
	
	public void setValidTraining (boolean valid) {
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
	
	public void addModelToObserverList (CellModel cellModel) {
		observerList = cellModel;
	}
	
	
	public CellModel getObserverList() {
		return observerList;
	}
	
}
