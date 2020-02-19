package kakuro;

import javax.swing.SwingUtilities;

import View.Board;

public class GameDriver {
	 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                	new Board();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
