package View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.GameController;

public class ValidateView  extends JPanel{
	
	//the string that will be seen by the use
	JLabel validateString = new JLabel ("Let's Play Kakuro"); 
	
	//default constructor which sets the size of the jpanel and sets its Jlabel's text.
	public ValidateView () {
		setSize(300,300);
		add(validateString);
	}
	
	//method to update the text of the Jpanel
	//this will be called from the game board model
	public void updateString (String str) {
        Runnable doAssist = new Runnable() {
            @Override
            public void run() {
        		validateString.setText(str);
            }
        };
	}
}