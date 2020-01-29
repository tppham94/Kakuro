import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class ClueCell extends JLabel implements Square{



	public ClueCell(String s) {
		super.setText(s);
		draw();
	}
	

	@Override
	public void draw() {
		
		super.setOpaque(true);
		super.setBackground(Color.BLACK);
		super.setForeground(Color.WHITE);
		Border border = BorderFactory.createLineBorder(Color.gray, 2);
		super.setBorder(border);
		
	}
	
	
	

}
