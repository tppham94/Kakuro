/**
 * author: Stefano Scalzo
 * The ValidateView class consists of the panel that will be displayed to the user to show them 
 * the errors in their current game and hints on what to fix in training mode. 
 * It will also tell them when the board is valid. 
 * In training mode it will tell them if their cell is correct.
 */
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
