package kakuro;

import View.BoardView;

import javax.swing.SwingUtilities;

public class GameDriver {
	 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                	new BoardView();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
