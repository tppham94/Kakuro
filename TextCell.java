import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TextCell extends JTextField implements Square{
	
	private String value;
	public TextCell() {
		draw();
	}
	
	
	
	@Override
	public void draw() {
		super.setOpaque(true);
		super.setBackground(Color.WHITE);
		super.setForeground(Color.BLACK);
		Border border = BorderFactory.createLineBorder(Color.gray, 2);
		super.setBorder(border);
	}

	public char[] getvalue() {
		
		return null;
	}
	

}
