package Controller;

import Model.MainMenuModel;
import View.LoginView;
import View.MainMenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController extends JPanel {

    private MainMenuModel m_model;
    private MainMenuView m_view;
    private LoginView l_view;

    public MainMenuController(MainMenuModel model, MainMenuView view) {
        this.m_view = view;
        this.m_model = model;

        //this.add(exit);
        //exit.addActionListener(new exitHandler());
        m_view.addNewGameListener(new newGameListener());
        m_view.addLoadListener(new loadListener());
        m_view.addExitListener(new exitListener());
    }

    private class exitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            m_view.dispose();
        }
    }

    private class loadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            m_view.setTitle("Login");
            m_view.getCardLayout().show(m_view.getCardPanels(),"Login");
            m_view.revalidate();
            m_view.repaint();
        }
    }

    private class newGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            m_view.setTitle("Difficulty");
            m_view.getCardLayout().show(m_view.getCardPanels(),"NewGame");
            m_view.revalidate();
            m_view.repaint();
        }
    }
}
