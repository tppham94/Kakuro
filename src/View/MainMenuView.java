package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainMenuView extends JFrame {

    //Components
    private JLabel menuName;
    private JButton newGameButton;
    private JButton loadButton;
    private JButton exitButton;
    private JPanel mainPanel;
    private JPanel cardPanels;
    private GridBagConstraints c;
    private JLabel background;
    private CardLayout cards;

    // Use to get access to the other class
    NewGameView nView;
    BoardView bView;

    // Singleton
    private static MainMenuView single_instance = null;

    private MainMenuView() {
    }

    public static MainMenuView getInstance() {
        if (single_instance == null) {
            single_instance = new MainMenuView();
        }
        return single_instance;
    }

    // constructor
    public MainMenuView(NewGameView nView, BoardView bView) throws IOException {
        MainMenuView mView = MainMenuView.getInstance();
        mView.nView = nView;
        mView.bView = bView;

        mView.initComponent();
        mView.initFrameConfiguration();
    }

    // Initializing the frame configuration
    private void initFrameConfiguration() {
        setTitle("Main Menu");
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800, 750));
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

        newGameButton = new JButton("New Game");
        newGameButton.setPreferredSize(new Dimension(90, 25));

        loadButton = new JButton("Load Game");
        loadButton.setPreferredSize(new Dimension(90, 25));

        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(90, 25));

        background = new JLabel(new ImageIcon(ImageIO.read(new File(".\\src\\View\\darkbg.jpg"))));
        setContentPane(background);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 10;
        c.ipady = 5;
        c.insets = new Insets(20, 0, 20, 0);
        mainPanel.add(newGameButton, c);


        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 10;
        c.ipady = 5;
        mainPanel.add(loadButton, c);

        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 10;
        c.ipady = 5;
        mainPanel.add(exitButton, c);


        mainPanel.setBackground(new Color(0, 0, 0, 0));
        cardPanels.add(mainPanel, "MainMenu");
        cardPanels.add(nView.getNewGamePanel(), "NewGame");
        cardPanels.add(bView, "KakuroGames");
        add(cardPanels);
        revalidate();
        repaint();
    }

    // Method for accessing the buttons in the controller
    public void addNewGameListener(ActionListener newGameListener) {
        newGameButton.addActionListener(newGameListener);
    }

    public void addLoadListener(ActionListener loadListener) {
        loadButton.addActionListener(loadListener);
    }

    public void addExitListener(ActionListener exitListener) {
        exitButton.addActionListener(exitListener);
    }

    // Created to be able to access the switch between panels
    public CardLayout getCardLayout() {
        return this.cards;
    }

    public JPanel getCardPanels() {
        return this.cardPanels;
    }
}