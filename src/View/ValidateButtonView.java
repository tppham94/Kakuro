package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.GameController;
import Controller.TrainingController;

public class ValidateButtonView extends JButton{

	private GameController gbc;
	public ValidateButtonView(GameController gbc) {
		super("Validate");
		this.gbc = gbc;
		addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				updateGameBoard();    
        
			}  	    
		});  
	}
	
	public ValidateButtonView(String str, GameController gbc) {
		super(str);
		this.gbc = gbc;
		addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				updateGameBoard();    
			}  	    
		});  	
	}
	
	public ValidateButtonView(String str, TrainingController tc) {
		super(str);
		this.gbc = tc;
		addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				updateGameBoard();    
			}  	    
		});  	
	}
	
	public void updateGameBoard () {
		this.gbc.sendToGameModel();
	}
}
