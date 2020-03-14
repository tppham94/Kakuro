package View;

import Controller.MainMenuController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LoginView extends JPanel {

    private JButton backBtn;
    private JPanel buttonPanel;
    private JPanel loginPanel;
    private GridBagConstraints c;

    private JLabel background;

    public LoginView() throws IOException {
        initLogin();
    }

    public void initLogin() throws IOException {
        loginPanel = new JPanel();
        buttonPanel = new JPanel(new GridBagLayout());
        setLayout(new GridBagLayout());
        backBtn = new JButton("Back");

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 10;
        c.ipady = 1;
        c.insets = new Insets(20,0,20,0);
        buttonPanel.add(backBtn, c);

        loginPanel.add(buttonPanel);
        buttonPanel.setBackground(new Color(0,0,0,0));
        loginPanel.setBackground(new Color(0,0,0,0));
        add(loginPanel);
    }

    public void addBackListener(ActionListener backListener){
        backBtn.addActionListener(backListener);
    }

    public JPanel getLoginPanel(){
        return this.loginPanel;
    }
}
