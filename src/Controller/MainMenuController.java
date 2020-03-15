package Controller;

import Model.MainMenuModel;
import View.BoardView;
import View.LoginView;
import View.MainMenuView;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainMenuController extends JPanel {

    private MainMenuModel mModel;
    private MainMenuView mView;
    private LoginView lView;
    private GameController gController;
    private BoardView bView;

    public MainMenuController(MainMenuModel model, MainMenuView view, BoardView bView, GameController gController) {
        this.mView = view;
        this.mModel = model;
        this.bView = bView;
        this.gController = gController;

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
            JFileChooser file = new JFileChooser(new File("../Kakuro"));
            file.showOpenDialog(null);
            gController.loadGame(bView, file.getSelectedFile().toString());
            mView.getCardLayout().show(mView.getCardPanels(), "EasyGameKakuro");
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
