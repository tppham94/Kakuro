package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.GameController;
import Controller.TrainingController;

public class ValidateButtonView extends JButton{

	private GameController gbc;//the controller that the button must send the action to

	/**
	 * default constructor in case called
	 */
	public ValidateButtonView() {
		
	}
	
	/**
	 * constructor which takes game controller and a string for the default message 
	 * on the button as parameters
	 * @param str
	 * @param gbc
	 */
	
	public ValidateButtonView(String str, GameController gbc) {
		super(str);
		this.gbc = gbc;
		addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				updateGameBoard();
			}  	    
		});  	
	}
	
	/**
	 * constructor which takes training controller and a string for the default message s
	 * on the button as parameters
	 * @param str
	 * @param tc
	 */
	
	public ValidateButtonView(String str, TrainingController tc) {
		super(str);
		this.gbc = tc;
		addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				updateGameBoard();
			}  	    
		});  	
	}
	
	/**
	 * send to the controller the notification to update the game model 
	 */
	public void updateGameBoard () {
		this.gbc.sendToGameModel();
	}
}
