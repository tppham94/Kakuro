package View;

import Controller.GameController;
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
public class ClueCellView extends JPanel {

	private static final int SIZE = 600;
	private WordModel rightWord;  //it2 change
	private WordModel bottomWord; //it2 change
	private JLabel rightLabel;
	private JLabel downLabel;

	public ClueCellView(WordModel rightWord, WorldModel bottomWord) {
		super(new GridLayout(2, 2));
		this.rightWord = rightWord; //it2 change
		this.bottomWord = bottomWord; //it2 change
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

		//it2 changes, rightWord and bottomWord
		rightLabel = new JLabel(rightWord.getRightLabelValue());
		//it2 changes, rightWord and bottomWord
		downLabel = new JLabel(bottomWord.getDownLabelValue());
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