package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

//import javafx.scene.control.Cell;


import Controller.GameController;
import Controller.TrainingController;
import Model.WordModel;
import Model.CellModel;
import Model.GameBoardModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BoardView extends JPanel {

    JComponent[] gameComponents;
    private JPanel boardPanel;
    private JButton saveButton;

    GameController controller;

    ValidateView vView;
    ValidateButtonView vBtnView;

    // Constructor called by Game Driver
    public BoardView(boolean trainingMode) {
        GameBoardModel gbm = new GameBoardModel();
        if (trainingMode) {
            controller = new TrainingController(gbm);
        } else {
            controller = new GameController(gbm);
        }
    }

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


    public void initComponents(JSONObject jsonObject) {
    	saveButton = new JButton("Save");
    	saveButton.setMargin(new Insets(5,5,5,5));

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
        vBtnView = new ValidateButtonView("Vals", controller);


        boardPanel = new JPanel(new GridLayout(size + 1, size));
        boardPanel.setPreferredSize(new Dimension(600, 600));
        for (int i = 0; i < gameComponents.length; i++) {
            boardPanel.add(gameComponents[i]);
        }

        controller.saveButton(this);
        boardPanel.add(vBtnView);
		boardPanel.add(saveButton);
        boardPanel.add(vView);
        add(boardPanel);
    }

    public void addSaveListener(ActionListener saveListener) {
        saveButton.addActionListener(saveListener);
    }

    //uses the cellsArray to initialize the game components with the corect cluecellView or Cellview.
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

    // uses wordArray to pass the correct values to ClueCell View and Cell and Word models
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

    public JComponent getComponentAt(int i) {
        return this.gameComponents[i];
    }

    public GameController getController() {
        return controller;
    }

}