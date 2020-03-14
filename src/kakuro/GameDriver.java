package kakuro;

import javax.swing.SwingUtilities;

import Controller.GameController;
import Model.GameBoardModel;
import View.BoardView;
import View.ValidateButtonView;
import View.ValidateView;

public class GameDriver {
	 
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            public void run() {
                try {
                    ValidateView vView = new ValidateView();
                    GameBoardModel gModel = new GameBoardModel();
                    GameController gController = new GameController();
                    ValidateButtonView vBView = new ValidateButtonView("hi", gController);
                	new BoardView(vView, gModel, vBView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        SwingUtilities.invokeLater(run);

    }
}
