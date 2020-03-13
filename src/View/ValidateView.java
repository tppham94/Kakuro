package View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.GameController;

public class ValidateView  extends JPanel{
    JLabel validateString = new JLabel ("");

    public ValidateView () {
        setSize(300,300);
        add(validateString);
        show();
    }


    public void updateString (String str) {
        validateString.setText(str);
    }
}