package View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.GameController;

public class ValidateView  extends JPanel{
	
	JLabel validateString; //the string that will be seen by the use 
	
	/**
	 * default constructor which sets the size of the jpanel and sets its Jlabel's text.
	 */
	public ValidateView () {
		validateString = new JLabel ("Let's Play Kakuro");
		setSize(300,300);
		add(validateString);
	}
	
	/**
	 * method to update the text of the Jpanel
	 * this will be called from the game board model
	 * @param str
	 */
	
	public void updateString (String str) {

        		validateString.setText(str);
        		validateString.repaint();

	}
}
