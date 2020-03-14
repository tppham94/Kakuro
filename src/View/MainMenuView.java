package View;

import Controller.LoginController;
import Controller.MainMenuController;
import Model.MainMenuModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenuView extends JFrame{

    //Components
    private JLabel menuName;
    private JButton newGameBtn;
    private JButton loadBtn;
    private JButton tutorialBtn;
    private JButton exitBtn;
    private JPanel mainPanel;
    private JPanel cardPanels;
    private GridBagConstraints c;
    private JLabel background;
    private CardLayout cards;

    // Use to get access to the other class
    LoginView l_view;
    NewGameView n_view;
    BoardView b_view;

    // constructor
    public MainMenuView(LoginView l_view, NewGameView n_view, BoardView b_view) throws IOException {
        this.l_view = l_view;
        this.n_view = n_view;
        this.b_view = b_view;

        initComponent();
        initFrameConfiguration();
    }

    // Initializing the frame configuration
    private void initFrameConfiguration(){
        setTitle("Main Menu");
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800,750));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    // Initializing the content of the frame
    private void initComponent() throws IOException {
        mainPanel = new JPanel(new GridBagLayout());

        c = new GridBagConstraints();
        cards = new CardLayout();
        cardPanels = new JPanel();
        cardPanels.setLayout(cards);

        menuName = new JLabel("K a k u r o");
        menuName.setFont(new Font("Dialog", Font.BOLD, 50));
        menuName.setForeground(Color.white);
        mainPanel.add(menuName, c);

        newGameBtn = new JButton("New Game");
        newGameBtn.setPreferredSize(new Dimension(90,25));

        loadBtn = new JButton("Load Game");
        loadBtn.setPreferredSize(new Dimension(90,25));

        tutorialBtn = new JButton("Tutorial");
        tutorialBtn.setPreferredSize(new Dimension(90,25));

        exitBtn = new JButton("Exit");
        exitBtn.setPreferredSize(new Dimension(90,25));

        background = new JLabel(new ImageIcon(ImageIO.read(new File(".\\src\\View\\darkbg.jpg"))));
        setContentPane(background);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 10;
        c.ipady = 5;
        c.insets = new Insets(20,0,20,0);
        mainPanel.add(newGameBtn, c);


        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 10;
        c.ipady = 5;
        mainPanel.add(loadBtn, c);

        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 10;
        c.ipady = 5;
        mainPanel.add(tutorialBtn, c);

        c.gridx = 0;
        c.gridy = 4;
        c.ipadx = 10;
        c.ipady = 5;
        mainPanel.add(exitBtn, c);


        mainPanel.setBackground(new Color(0,0,0,0));
        cardPanels.add(mainPanel,"MainMenu");
        cardPanels.add(l_view.getLoginPanel(),"Login");
        cardPanels.add(n_view.getNewGamePanel(),"NewGame");
        cardPanels.add(b_view.getBoardPanel(),"EasyGameKakuro");
        add(cardPanels);
        revalidate();
        repaint();
    }

    // Method for accessing the buttons in the controller
    public void addNewGameListener(ActionListener newGameListener){
        newGameBtn.addActionListener(newGameListener);
    }

    public void addLoadListener(ActionListener loadListener){
        loadBtn.addActionListener(loadListener);
    }

    public void addExitListener(ActionListener exitListener){
        exitBtn.addActionListener(exitListener);
    }

    // Created to be able to access the switch between panels
    public CardLayout getCardLayout(){
        return this.cards;
    }

    public JPanel getCardPanels(){
        return this.cardPanels;
    }
}