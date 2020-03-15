import Controller.GameController;
import Controller.MainMenuController;
import Controller.NewGameController;
import View.BoardView;
import View.MainMenuView;
import View.NewGameView;

import java.io.IOException;

// Driver class
public class KakuroDriver {

    // Instantiating the views, controllers and model in order to connect them to each other
    public static void main(String[] args) throws IOException {
        NewGameView n_view = new NewGameView();
        BoardView b_view = new BoardView(false);
        MainMenuView m_view = new MainMenuView(n_view, b_view);
        GameController g_Controller = new GameController();

        MainMenuController m_controller = new MainMenuController(m_view, b_view, g_Controller);
        NewGameController n_controller = new NewGameController(n_view, m_view, b_view);
    }
}
