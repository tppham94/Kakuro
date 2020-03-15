package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import Controller.GameController;
import Controller.TrainingController;
import Model.CellModel;
import Model.WordModel;

public class CellView extends JTextField {
    GameController gameController;
    CellModel observerList;
    int index;
    boolean updateWithoutNotification = false;

    /**
     * Default constructor
     */
    public CellView() {
        /**
         * Set the background color and size
         */
        setVisualConfiguration();

        setupListeners();
    }

    /**
     * @param cellView with regular game board controller constructor for regular games
     */
    public CellView(GameController gbc) {
        this.gameController = gbc;
        setVisualConfiguration();


        setupListeners();
    }


    /**
     * @param cellView with training game board controller constructor for training games
     */
    public CellView(TrainingController tc) {
        this.gameController = tc;
        setVisualConfiguration();

        setupListeners();
    }

    private void setupListeners() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!updateWithoutNotification) {
                    sendToController();
                }
                updateWithoutNotification = false;
            }
        });
//        this.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            /**
//             * sends text to controller on input
//             */
//            public void insertUpdate(DocumentEvent e) {
//                if (!updateWithoutNotification) {
//                    sendToController();
//                }
//                updateWithoutNotification = false;
//            }
//
//            @Override
//            /**
//             * sends text to controller on input
//             */
//            public void removeUpdate(DocumentEvent e) {
//                if (!updateWithoutNotification) {
//                    sendToController();
//                }
//                updateWithoutNotification = false;
//            }
//
//            @Override
//            /**
//             * sends text to controller on input
//             */
//            public void changedUpdate(DocumentEvent e) {
//                if (!updateWithoutNotification) {
//                    sendToController();
//                }
//                updateWithoutNotification = false;
//            }
//
//        });
    }

    /**
     * send the number as a string to the controller which will
     * send the updated number to its observers
     */

    public void sendToController() {
        gameController.sendToCellModel(this.getText(), this);
    }

    public void setVisualConfiguration() {
        super.setOpaque(true);
        super.setBackground(Color.WHITE);
        super.setForeground(Color.BLACK);
        super.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        this.setHorizontalAlignment(JTextField.CENTER);
    }


    /**
     * Mutator for the views text field number
     */
    public void setTextField(int number) {
        //parse the int that is sent from the model to a string
        if (this.getText() != Integer.toString(number)) {
            // Block notification to game controller in order to prevent infinite loop.
            updateWithoutNotification = true;
            setText(Integer.toString(number));
//            Runnable doAssist = new Runnable() {
//                @Override
//                public void run() {
//                    setText(Integer.toString(number));
//                }
//            };
        }


    }


    /*
     * Mutator for the views validity data member when training mode is on
     */
    public void setValidTraining(boolean valid) {
        setBackgroundColor(valid); //change color to green if valid red if invalid
    }

    public void setController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setController(TrainingController tc) {
        this.gameController = tc;
    }


    /*
     * Mutator for the views background color for the training mode based on its validity
     */
    public void setBackgroundColor(boolean valid) {
        if (valid) {
            this.setBackground(Color.GREEN);
        } else this.setBackground(Color.RED);
    }

    /*
     * To add a cell model object to the cell view
     */
    public void addModelToObserverList(CellModel cellModel) {
        observerList = cellModel;
    }


    /*
     * Accessor method for the cell view's observerList object
     */
    public CellModel getObserverList() {
        return observerList;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
