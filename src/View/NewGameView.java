package View;

import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewGameView extends JPanel {

    private JLabel difficulty;
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private JButton backButton;
    private JPanel newGamePanel;
    private JPanel buttonPanel;

    private GridBagConstraints c;

    public NewGameView(){
        initNewGameView();
    }

    // Initializing the content of the panel
    public void initNewGameView(){

        newGamePanel = new JPanel(new GridBagLayout());
        //buttonPanel = new JPanel(new GridBagLayout());

        c = new GridBagConstraints();

        setLayout(new GridBagLayout());

        difficulty = new JLabel("Difficulty");
        difficulty.setFont(new Font("Dialog", Font.BOLD, 50));
        difficulty.setForeground(Color.white);
        newGamePanel.add(difficulty, c);

        easyButton = new JButton("Easy");
        easyButton.setPreferredSize(new Dimension(90,25));

        mediumButton = new JButton("Medium");
        mediumButton.setPreferredSize(new Dimension(90,25));

        hardButton = new JButton("Hard");
        hardButton.setPreferredSize(new Dimension(90,25));

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(90, 25));


        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 10;
        c.ipady = 5;
        c.insets = new Insets(20,0,20,0);
        newGamePanel.add(easyButton, c);


        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 10;
        c.ipady = 5;
        newGamePanel.add(mediumButton, c);

        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 10;
        c.ipady = 5;
        newGamePanel.add(hardButton, c);

        c.gridx = 0;
        c.gridy = 4;
        c.ipadx = 10;
        c.ipady = 5;
        newGamePanel.add(backButton, c);

        //newGamePanel.add(buttonPanel);
        //buttonPanel.setBackground(new Color(0,0,0,0));
        newGamePanel.setBackground(new Color(0,0,0,0));
        add(newGamePanel);
    }

    // Method use to get access to the buttons
    public void addEasyListener(ActionListener easyListener){
        easyButton.addActionListener(easyListener);
    }

    public void addBackListener(ActionListener backListener){
        backButton.addActionListener(backListener);
    }

    public JPanel getNewGamePanel(){
        return this.newGamePanel;
    }
}