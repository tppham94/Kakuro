package View;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Line2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Model.ClueCellModel;

public class ClueCell extends JPanel implements Square{

	private static final int SIZE = 600;
	private ClueCellModel model;
	
	public ClueCell(ClueCellModel model) {
		super(new GridLayout(2, 2));
		this.model = model;
		draw();	
	}
	
	@Override
    public void paintComponent(Graphics g)
    {
          super.paintComponent(g);
          Graphics2D g2d = (Graphics2D) g;

          Line2D.Double line = new Line2D.Double(0, 0, SIZE, SIZE);
          g2d.setColor(Color.GRAY);
          g2d.draw(line);
    }
	
	@Override
	public void draw() {
		
		super.setBackground(Color.BLACK);
		
		JLabel invisible = new JLabel("",JLabel.CENTER);
		invisible.setVisible(false);
		this.add(invisible);
		
		JLabel rightLabel = new JLabel(model.getRightLabelValue(),JLabel.CENTER);
		rightLabel.setForeground(Color.white);
		this.add(rightLabel);
		
	
		JLabel downLabel = new JLabel(model.getDownLabelValue(),JLabel.CENTER);
		downLabel.setForeground(Color.white);
		this.add(downLabel);
		
		Border border = BorderFactory.createLineBorder(Color.gray, 2);
		super.setBorder(border);
		
	}
}
