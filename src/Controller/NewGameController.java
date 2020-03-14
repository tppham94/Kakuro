package Controller;

import View.BoardView;
import View.MainMenuView;
import View.NewGameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameController extends JPanel {

    MainMenuView m_view;
    NewGameView n_view;
    BoardView b_view;

    public NewGameController(NewGameView n_view, MainMenuView m_view, BoardView b_view) {
        this.n_view = n_view;
        this.m_view = m_view;
        this.b_view = b_view;

        n_view.addEasyListener(new easyListener());
        n_view.addBackListener(new backListener());
    }

    private class easyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            m_view.setTitle("Easy");
            m_view.getCardLayout().show(m_view.getCardPanels(),"EasyGameKakuro");
            m_view.revalidate();
            m_view.repaint();
        }
    }

    private class backListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            m_view.setTitle("Main Menu");
            m_view.getCardLayout().show(m_view.getCardPanels(), "MainMenu");
            m_view.revalidate();
            m_view.repaint();
        }
    }
}
