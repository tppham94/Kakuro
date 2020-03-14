package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.GameController;
import Controller.TrainingController;

public class ValidateButtonView extends JButton{

	//the controller that the button must send the message to
	private GameController gbc;
	
	//default constructor
	public ValidateButtonView() {
		
	}
	
	//constructor which takes game controller and a string for the default message 
	//on the button as parameters
	public ValidateButtonView(String str, GameController gbc) {
		super(str);
		this.gbc = gbc;
		addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				updateGameBoard();    
			}  	    
		});  	
	}
	
	//constructor which takes training controller and a string for the default message 
	//on the button as parameters
	public ValidateButtonView(String str, TrainingController tc) {
		super(str);
		this.gbc = tc;
		addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				updateGameBoard();    
			}  	    
		});  	
	}
	
	//send to the controller the notification to update the game model 
	public void updateGameBoard () {
		this.gbc.sendToGameModel();
	}
}
