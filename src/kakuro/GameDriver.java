package kakuro;

import javax.swing.SwingUtilities;

import View.BoardView;

public class GameDriver {
	 
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            public void run() {
                try {
                	new BoardView();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        SwingUtilities.invokeLater(run);

    }
}
