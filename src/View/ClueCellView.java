/**
 * author: Khadija Subtain, Ivan Ivachenko
 * The ClueCell class consists of the layout of the clue cells,including background color,
 * size of the cell border, text size and alignment of text in clue cells
 */

package View;

import Model.WordModel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.border.Border;
import java.awt.geom.Line2D;

@SuppressWarnings("serial")
public class ClueCellView extends JPanel {

    // **************************************************
    // Fields
    // **************************************************
    private static final int SIZE = 600;
    private WordModel rightWord;  //it2 change
    private WordModel bottomWord; //it2 change
    private JLabel rightLabel;// label which will display to the user the total needed for the word on the right
    private JLabel downLabel; //label which will display to the user the total needed for the word bellow

    // **************************************************
    // Constructors
    // **************************************************

    /**
     * Default constructor which creates a 2x2 grid for the 2 numbers
     */
    public ClueCellView() {
        super(new GridLayout(2, 2));
        addUIComponentsToPanel();
    }


    // **************************************************
    // Private methods
    // **************************************************

    /**
     * Mutator to get the total of the word on the right
     */
    private void setRightLabelText() {
        if (rightWord != null)
            rightLabel.setText("" + rightWord.getTotalForWord());
    }

    /**
     * Mutator to get the total of the bottom word
     */
    private void setDownLabelText() {
        if (bottomWord != null)
            downLabel.setText("" + bottomWord.getTotalForWord());
    }

    // **************************************************
    // Public methods
    // **************************************************

    /**
     * Mutator to set the right word model
     *
     * @param rightWord
     */
    public void setRightWord(WordModel rightWord) {
        this.rightWord = rightWord;
        setRightLabelText();
    }

    public WordModel getRightWord() {
        return rightWord;
    }

    public WordModel getBottomWord() {
        return bottomWord;
    }

    /**
     * Mutator to set the bottom word model
     *
     * @param bottomWord
     */
    public void setBottomWord(WordModel bottomWord) {
        this.bottomWord = bottomWord;
        setDownLabelText();
    }

    @Override
    /**
     * setting visuals of the clue cell
     */
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
        rightLabel = new JLabel("", JLabel.CENTER);
        downLabel = new JLabel("", JLabel.CENTER);
        invisible.setVisible(false);
        this.add(invisible);

        setRightLabelText();
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