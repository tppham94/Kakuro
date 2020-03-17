package Controller;

import View.BoardView;
import View.MainMenuView;
import View.NewGameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameController extends JPanel {

    MainMenuView mView;
    NewGameView nView;
    BoardView bView;

    public NewGameController(NewGameView nView, BoardView bView) {
        this.mView = MainMenuView.getInstance();
        this.nView = nView;
        this.bView = bView;

        nView.addEasyListener(new easyListener());
        nView.addMediumListener(new mediumListener());
        nView.addHardListener(new hardListener());
        nView.addBackListener(new backListener());
        nView.addTutorialListener(new tutorialListener());
    }

    private class easyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mView.setTitle("Easy");
            bView.getController().loadGame(bView, "src/easy.json");
            mView.getCardLayout().show(mView.getCardPanels(), "KakuroGames");
            mView.revalidate();
            mView.repaint();
        }
    }

    private class mediumListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mView.setTitle("Medium");
            bView.getController().loadGame(bView, "src/medium.json");
            mView.getCardLayout().show(mView.getCardPanels(), "KakuroGames");
            mView.revalidate();
            mView.repaint();
        }
    }

    private class hardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mView.setTitle("Hard");
            bView.getController().loadGame(bView, "src/hard.json");
            mView.getCardLayout().show(mView.getCardPanels(), "KakuroGames");
            mView.revalidate();
            mView.repaint();
        }
    }

    private class backListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mView.setTitle("Main Menu");
            mView.getCardLayout().show(mView.getCardPanels(), "MainMenu");
            mView.revalidate();
            mView.repaint();
        }
    }

    private class tutorialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mView.setTitle("Tutorial");
            bView.setTrainingMode(true);
            bView.getController().loadGame(bView, "src/easy.json");
            mView.getCardLayout().show(mView.getCardPanels(), "KakuroGames");
            mView.revalidate();
            mView.repaint();

        }
    }
}
