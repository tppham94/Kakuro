import Controller.LoginController;
import Controller.MainMenuController;
import Controller.NewGameController;
import Model.MainMenuModel;
import View.BoardView;
import View.LoginView;
import View.MainMenuView;
import View.NewGameView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

// Driver class
public class KakuroDriver {

    // Instantiating the views, controllers and model in order to connect them to each other
    public static void main(String[]args) throws IOException {
        MainMenuModel m_model = new MainMenuModel();
        LoginView l_view = new LoginView();
        NewGameView n_view = new NewGameView();
        BoardView b_view = new BoardView(false);
        MainMenuView m_view = new MainMenuView(l_view, n_view, b_view);

        MainMenuController m_controller = new MainMenuController(m_model, m_view);
        LoginController l_controller = new LoginController(l_view, m_view);
        NewGameController n_controller = new NewGameController(n_view, m_view, b_view);
    }
}
