package Controller;

import Model.MainMenuModel;
import View.LoginView;
import View.MainMenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController extends JPanel {

    private MainMenuModel mModel;
    private MainMenuView mView;
    private LoginView lView;

    public MainMenuController(MainMenuModel model, MainMenuView view) {
        this.mView = view;
        this.mModel = model;

        //this.add(exit);
        //exit.addActionListener(new exitHandler());
        mView.addNewGameListener(new newGameListener());
        mView.addLoadListener(new loadListener());
        mView.addExitListener(new exitListener());
    }

    private class exitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mView.dispose();
        }
    }

    private class loadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mView.setTitle("Login");
            mView.getCardLayout().show(mView.getCardPanels(),"Login");
            mView.revalidate();
            mView.repaint();
        }
    }

    private class newGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mView.setTitle("Difficulty");
            mView.getCardLayout().show(mView.getCardPanels(),"NewGame");
            mView.revalidate();
            mView.repaint();
        }
    }
}
