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
        NewGameView nView = new NewGameView();
        BoardView bView = new BoardView(false);
        MainMenuView mView = new MainMenuView(nView, bView);
        GameController gController = new GameController();

        MainMenuController m_controller = new MainMenuController(mView, bView, gController);
        NewGameController n_controller = new NewGameController(nView, mView, bView);
    }
}