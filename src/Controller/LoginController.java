package Controller;

import View.LoginView;
import View.MainMenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController extends JPanel {

    MainMenuView m_view;
    LoginView l_view;

    // Constructor
    public LoginController(LoginView view, MainMenuView m_v){
        this.l_view = view;
        this.m_view = m_v;

        l_view.addBackListener(new backListener());
    }

    // Implementation of the button
    private class backListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            m_view.setTitle("Main Menu");
            m_view.getCardLayout().previous(m_view.getCardPanels());
            m_view.revalidate();
            m_view.repaint();
        }
    }

}
