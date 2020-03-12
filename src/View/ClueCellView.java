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
import Model.WordModel;

@SuppressWarnings("serial")
public class ClueCellView extends JPanel {

	private static final int SIZE = 600;
	private WordModel rightWord;  //it2 change
	private WordModel bottomWord; //it2 change
	private JLabel rightLabel;
	private JLabel downLabel;

	public ClueCellView() {
		super(new GridLayout(2, 2));
		addUIComponentsToPanel();
	}

	public void setRightWord(WordModel rightWord) {
		this.rightWord = rightWord;
		setRightLabelText();
	}

	public void setBottomWord(WordModel bottomWord) {
		this.bottomWord = bottomWord;
		setDownLabelText();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		Line2D.Double line = new Line2D.Double(0, 0, SIZE, SIZE);
		g2d.setColor(Color.GRAY);
		g2d.draw(line);
	}

	private void setRightLabelText() {
		if (rightWord != null)
			rightLabel.setText("" + rightWord.getTotalForWord());
	}

	private void setDownLabelText() {
		if (bottomWord != null)
			downLabel.setText("" + bottomWord.getTotalForWord());
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
		rightLabel = new JLabel("", JLabel.CENTER);
		downLabel = new JLabel("", JLabel.CENTER);
		invisible.setVisible(false);
		this.add(invisible);


		//it2 changes, rightWord and bottomWord
		setRightLabelText();
		//it2 changes, rightWord and bottomWord
		setDownLabelText();
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