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

@SuppressWarnings("serial")
public class ClueCell extends JPanel {

	private static final int SIZE = 600;
	private ClueCellModel model;
	private JLabel rightLabel;
	private JLabel downLabel;

	public ClueCell(ClueCellModel model) {
		super(new GridLayout(2, 2));
		this.model = model;
		addUIComponentsToPanel();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		Line2D.Double line = new Line2D.Double(0, 0, SIZE, SIZE);
		g2d.setColor(Color.GRAY);
		g2d.draw(line);
	}

	/**
	 * This methods add components to the J-panel components are being aligned
	 */
	public void addUIComponentsToPanel() {

		super.setBackground(Color.BLACK);
		/*
		 * This label is kept invisible on purpose to keep other labels aligned but not
		 * show this label
		 */
		JLabel invisible = new JLabel("", JLabel.CENTER);
		invisible.setVisible(false);
		this.add(invisible);

		rightLabel = new JLabel(model.getRightLabelValue());
		downLabel = new JLabel(model.getDownLabelValue());
		this.setVisualConfiguration();
		this.add(rightLabel);
		this.add(downLabel);

	}
	
	/**
	 * This method sets the visual layout of J-panel and other UI components within J-panel 
	 */
	public void setVisualConfiguration() {
		rightLabel.setHorizontalAlignment(JLabel.CENTER);
		rightLabel.setForeground(Color.white);
		downLabel.setHorizontalAlignment(JLabel.CENTER);
		downLabel.setForeground(Color.white);
		Border border = BorderFactory.createLineBorder(Color.gray, 2);
		super.setBorder(border);
	}
}
