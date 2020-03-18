/**
 * The MainMenuController allows the user to
 * navigate between scenes of the game
 * with the buttons
 *
 * @author: Tan-Phat Pham
 */

package Controller;

import View.BoardView;
import View.MainMenuView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class MainMenuController{

    // **************************************************
    // Fields
    // **************************************************
    private MainMenuView mView;
    private GameController gController;
    private BoardView bView;

    // **************************************************
    // Constructors
    // **************************************************

    /**
     * Parameterized constructor
     *
     * @param bView
     * @param gController
     */
    public MainMenuController(BoardView bView, GameController gController) {
        this.mView = MainMenuView.getInstance();
        this.bView = bView;
        this.gController = gController;

        mView.addNewGameListener(new newGameListener());
        mView.addLoadListener(new loadListener());
        mView.addExitListener(new exitListener());
    }

    // **************************************************
    // Private methods
    // *************************************************

    /**
     * Method that contains listener for each functionality of the buttons
     */
    private class exitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mView.dispose();
        }
    }

    private class loadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mView.setTitle("Load Game");
            JFileChooser file = new JFileChooser(new File("../Kakuro"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON", "json", "json");
            file.setFileFilter(filter);
            int choice = file.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION) {
                gController.loadGame(bView, file.getSelectedFile().toString());
                mView.getCardLayout().show(mView.getCardPanels(), "KakuroGames");
                mView.revalidate();
                mView.repaint();
            } else if (choice == JFileChooser.CANCEL_OPTION) {
            }

        }
    }

    private class newGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mView.setTitle("Difficulty");
            mView.getCardLayout().show(mView.getCardPanels(), "NewGame");
            mView.revalidate();
            mView.repaint();
        }
    }
}
