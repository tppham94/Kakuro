/**
 * author: Drew wagner, Tan-Phat Pham, Mario Lapadula
 * The BoardView class is the View which groups all of the CellViews together in a grid layout.
 * It will also add the ValidateButtonView object to the bottom.
 * Lastly, it will add a ValidateView at the top.
 * It is the main container which will group everything into one window.
 */
package View;

import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JButton;


import Controller.GameController;
import Controller.TrainingController;
import Model.WordModel;
import Model.CellModel;
import Model.GameBoardModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BoardView extends JPanel {

    // **************************************************
    // Fields
    // **************************************************
    JComponent[] gameComponents;
    private JPanel boardPanel;
    private JPanel buttonPanel;
    private JButton saveButton;
    private JButton backButton;
    GameController controller;
    GameBoardModel gbm;
    ValidateView vView;
    ValidateButtonView vBtnView;

    // **************************************************
    // Constructors
    // **************************************************

    /**
     * Parameterized constructor
     *
     * @param trainingMode
     */
    public BoardView(boolean trainingMode) {
        gbm = new GameBoardModel();
        if (trainingMode) {
            controller = new TrainingController(gbm);
        } else {
            controller = new GameController(gbm);
        }
    }

    // **************************************************
    // Private methods
    // **************************************************

    /**
     * Method that uses cellsArray to initialize the game
     * components with the correct clueCellView or CellView
     *
     * @param cellsArray
     */
    private void handleCellsCalls(JSONArray cellsArray) {
        for (int i = 0; i < cellsArray.size(); i++) {
            int value = 0;
            int currentValue = 0;
            try {
                value = (int) (long) cellsArray.get(i);
            } catch (Exception e) {
                JSONObject cell = (JSONObject) cellsArray.get(i);
                value = (int) (long) cell.get("correct");
                currentValue = (int) (long) cell.get("current");
            }
            if (value == 0) {
                gameComponents[i] = new View.ClueCellView();
            } else {
                View.CellView cellView = new View.CellView(controller);
                cellView.setIndex(i);
                CellModel cellModel = new CellModel(value, cellView);
                if (currentValue > 0) {
                    cellModel.update("" + currentValue);
                }
                cellView.addModelToObserverList(cellModel);
                gameComponents[i] = cellView;
            }
        }

    }

    /**
     * Method that uses wordArray to pass the correct values
     * to the ClueCell View and Cell and Word models
     *
     * @param wordsArray
     */
    private void handleWordCalls(JSONArray wordsArray) {
        int counter = 0;
        for (int i = 0; i < wordsArray.size(); i++) {
            JSONObject jsonWordObj = (JSONObject) wordsArray.get(i);
            int index = (int) (long) jsonWordObj.get("index");
            boolean vertical = (boolean) jsonWordObj.get("vertical");
            int sum = (int) (long) jsonWordObj.get("sum");
            JSONArray cell_indices = (JSONArray) jsonWordObj.get("cell_indices");

            int word_size = cell_indices.size();

            View.ClueCellView clue_cell = (View.ClueCellView) gameComponents[index];
            WordModel new_word = new WordModel(word_size, sum);
            controller.addToGameBoardModelArray(counter++, new_word);
            for (int j = 0; j < cell_indices.size(); j++) {
                CellModel cell_model = ((View.CellView) gameComponents[(int) (long) cell_indices.get(j)]).getObserverList();
                new_word.setCellModelArrayAtIndex(j, cell_model);
            }

            if (vertical) {
                clue_cell.setBottomWord(new_word);
            } else {
                clue_cell.setRightWord(new_word);
            }
        }

    }

    // **************************************************
    // Public methods
    // **************************************************

    /**
     * Method to check if the settings have been set to
     * training mode or regular game
     * @param trainingMode
     */
    public void setTrainingMode(boolean trainingMode) {
        GameBoardModel gbm = controller.getGameBoardModel();
        if (trainingMode) {
            controller = new TrainingController(gbm);
        } else {
            controller = new GameController(gbm);
        }
        boardPanel = new JPanel(new GridLayout(1, 1));
        boardPanel.setPreferredSize(new Dimension(600, 600));
    }

    /**
     * Method that initialize the board using JSON
     * and layouts to display it on the frame
     * @param jsonObject
     */
    public void initComponents(JSONObject jsonObject) {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        saveButton = new JButton("Save");
        saveButton.setMargin(new Insets(5, 5, 5, 5));
        saveButton.setPreferredSize(new Dimension(200, 100));

        backButton = new JButton("Back");
        backButton.setMargin(new Insets(5, 5, 5, 5));
        backButton.setPreferredSize(new Dimension(200, 100));

        //getting game size element to create the metrics that will created the correct board size for the game.
        int size = (int) (long) jsonObject.get("size");
        // array for the cells to be added to our game board
        gameComponents = new JComponent[size * size];
        controller.getGameBoardModel().setLength(size);

        //create the array for the cells to populate the correct cell values
        JSONArray cellsArray = (JSONArray) jsonObject.get("cells");
        handleCellsCalls(cellsArray);


        JSONArray wordsArray = (JSONArray) jsonObject.get("words"); // create JSON array for the words
        controller.initializeWordModelArray(wordsArray.size());
        handleWordCalls(wordsArray);

        vView = new ValidateView();
        vView.setPreferredSize(new Dimension(50, 50));
        vBtnView = new ValidateButtonView("Validate", controller);
        vBtnView.setPreferredSize(new Dimension(200, 100));
        gbm.setValidateView(vView);

        boardPanel = new JPanel(new GridLayout(size + 1, size));
        boardPanel.setPreferredSize(new Dimension(500, 500));
        for (int i = 0; i < gameComponents.length; i++) {
            boardPanel.add(gameComponents[i]);
        }

        buttonPanel = new JPanel(new GridBagLayout());
        controller.saveButton(this);
        controller.backButton(this);
        buttonPanel.add(vBtnView);
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);

        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.ipadx = 10;
        gc.ipady = 5;
        add(vView, gc);

        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.ipadx = 10;
        gc.ipady = 5;
        add(boardPanel, gc);

        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.ipadx = 10;
        gc.ipady = 5;
        add(buttonPanel, gc);
    }

    /**
     * Methods that gets the content of the
     * components and the GameController
     */
    public JComponent getComponentAt(int i) {
        return this.gameComponents[i];
    }

    public GameController getController() {
        return controller;
    }

    /**
     *  Methods to add listener to the buttons
     */
    public void addBackListener(ActionListener backListener) {
        backButton.addActionListener(backListener);
    }

    public void addSaveListener(ActionListener saveListener) {
        saveButton.addActionListener(saveListener);
    }
}