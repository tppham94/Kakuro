package v1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Line2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ClueCell extends JPanel implements Square{

	private static final int SIZE = 300;
	public ClueCell(String rightLabelValue, String downLabelValue) {
		super(new GridLayout(2, 2));
		draw();
		
		JLabel invisible = new JLabel("",JLabel.CENTER);
		invisible.setVisible(false);
		this.add(invisible);
		
		JLabel rightLabel = new JLabel(rightLabelValue,JLabel.CENTER);
		rightLabel.setForeground(Color.white);
		this.add(rightLabel);
		
	
		JLabel downLabel = new JLabel(downLabelValue,JLabel.CENTER);
		downLabel.setForeground(Color.white);
		this.add(downLabel);
		
	}
	
    // Do not change this method name or parameters

    public void paintComponent(Graphics g)
    {
          super.paintComponent(g);
          Graphics2D g2d = (Graphics2D) g;

          // This is where your code should go
          Line2D.Double line = new Line2D.Double(0, 0, SIZE, SIZE);
          g2d.setColor(Color.GRAY);
          g2d.draw(line);
    }
	

	@Override
	public void draw() {
		
		super.setBackground(Color.BLACK);
		Border border = BorderFactory.createLineBorder(Color.gray, 2);
		super.setBorder(border);
		
	}
	
	
	

}
