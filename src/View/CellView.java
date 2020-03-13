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
import Controller.TrainingController;
import Model.CellModel;
import Model.WordModel;

public class CellView extends JTextField {
	int number;
	boolean valid;
	GameController gameController;
	CellModel observerList;

	public CellView () {
		
		setVisualConfiguration();

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
	
	public CellView (GameController gbc) { //cellView with controller constructor
		this.gameController = gbc;
		setVisualConfiguration();

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
	
	public CellView (TrainingController tc) { //cellView with training controller
		this.gameController = tc;
		setVisualConfiguration();

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
	
	
	//send the number as a string to the controller which will 
	//send the updated number to its observers
	
	public void sendToController() { 
		gameController.sendToCellModel(this.getText(), this);
	}
	
	public void setVisualConfiguration() {
		super.setOpaque(true);
		super.setBackground(Color.WHITE);
		super.setForeground(Color.BLACK);
		super.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		this.setHorizontalAlignment(JTextField.CENTER);
	}
	
	
	/*
	 * Mutator for the views text field number
	 */
	public void setTextField (int number) {
		this.number = number;
		//parse the int that is sent from the model to a string 
		this.setText(Integer.toString(number)); 
	}
	
	
	/*
	 * Mutator for the views validity data member
	 */
	public void setValid (boolean valid) {
		this.valid = valid;
	}
	
	/*
	 * Mutator for the views validity data member when training mode is on
	 */
	public void setValidTraining (boolean valid) {
		this.valid = valid;
		setBackgroundColor(); //change color to green if valid red if invalid
	}
	
	public void setController (GameController gameController) {
		this.gameController = gameController;
	}
	
	public void setController (TrainingController tc) {
		this.gameController = tc;
	}
	
	
	/*
	 * Mutator for the views background color for the training mode based on its validity
	 */
	public void setBackgroundColor () {
		if (valid) {
			this.setBackground(Color.GREEN);
		}
		else this.setBackground(Color.RED);
	}
	
	/*
	 * To add a cell model object to the cell view 
	 */
	public void addModelToObserverList (CellModel cellModel) {
		observerList = cellModel;
	}
	
	
	/*
	 * Accessor method for the cell view's observerList object
	 */
	public CellModel getObserverList() {
		return observerList;
	}
	
}
