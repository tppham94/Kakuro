/**
 * author: Stefano scalzo
 * The GameController class awaits notification from either CellView, validButtonView or the saveButtonView, 
 * and then delegates the tasks to the corresponding  model. It assigns a new game board,
 *  updates all wordModels that have the CellModel, it updates the validated text for the gameBoard.
 */
package Controller;

import Model.CellModel;
import Model.GameBoardModel;
import Model.WordModel;
import View.BoardView;
import View.CellView;
import View.ClueCellView;
import View.MainMenuView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GameController {


    GameBoardModel gbModel;
    ArrayList<WordModel> wordObserverlist;
    BoardView bView;

    /**
     * Default constructor which assigns a new gameboard
     *
     * @param gbm
     */
    public GameController() {
        gbModel = new GameBoardModel();
    }

    /**
     * Constructor which has a gameBoardModelSet
     *
     * @param gbm
     */
    public GameController(GameBoardModel gbm) {
        gbModel = gbm;
    }

    /**
     * to update the cell model based on the views event method triggered in view class
     *
     * @param number
     * @param cv
     */

    public void sendToCellModel(String number, CellView cv) {
    	if(!number.isEmpty()) {
        	if(number.contains("0")) number = number.substring(1);
        	if(!number.isEmpty()) {
        		if(number.matches("\\d{0}")) { //if there are no number
                    cv.getObserverList().update(number); //updates the cell model associated to the cell view
                    sendToWordModel(cv.getObserverList()); //updates all word models associated to the cell model
        		}
        	
    		else if(!(number.equals(Integer.toString(cv.getObserverList().getUserNumber())))) {
                cv.getObserverList().update(number); //updates the cell model associated to the cell view
                sendToWordModel(cv.getObserverList()); //updates all word models associated to the cell model
        	}	
    	}
    	}
    }

    /**
     * updates all wordModels that have the CellModel
     *
     * @param cm
     */
    public void sendToWordModel(CellModel cm) {
        cm.getWordObserverlist().forEach(wordObj -> wordObj.validateWord());
    }

    /**
     * updates the validate text for the gameboard
     */
    public void sendToGameModel() {
        gbModel.update();
    }

    /**
     * Setting a specific word model at a specific index of the game board model
     */

    public void addToGameBoardModelArray(int index, WordModel wm) {
        gbModel.setWordModelAtIndex(index, wm);
    }

    public void saveButton(View.BoardView bView) {
        bView.addSaveListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                file.setCurrentDirectory(new File(System.getProperty("user.dir")));
                file.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON", "json", "json");
                file.setFileFilter(filter);
                int choice = file.showSaveDialog(null);
                if(choice == JFileChooser.APPROVE_OPTION) {
                    try {
                        saveGame(bView, file.getSelectedFile().getName() + ".json");
                        JOptionPane.showMessageDialog(null, "You have saved!");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else if(choice == JFileChooser.CANCEL_OPTION){

                }
            }
        });
    }

    public void backButton(View.BoardView bView) {
        bView.addBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenuView mView = MainMenuView.getInstance();
                bView.removeAll();
                mView.setTitle("Main Menu");
                mView.getCardLayout().show(mView.getCardPanels(), "MainMenu");
                mView.revalidate();
                mView.repaint();
            }
        });
    }

    public void saveGame(View.BoardView boardView, String filename) throws IOException {
        System.out.println("Saving game to: " + filename);
        JSONObject json_output = new JSONObject();

        int size = gbModel.getLength();

        json_output.put("size", size);

        JSONArray cell_array = new JSONArray();
        JSONArray word_array = new JSONArray();
        for (int i = 0; i < size * size; i++) {
            JComponent component = boardView.getComponentAt(i);
            int correctValue = 0;
            int currentValue = 0;
            if (component instanceof CellView) {
                CellView cellView = (CellView) component;
                correctValue = cellView.getObserverList().getCorrectNumber();
                currentValue = cellView.getObserverList().getUserNumber();
            } else if (component instanceof ClueCellView) {
                ClueCellView clueCellView = (ClueCellView) component;
                WordModel rightWord = clueCellView.getRightWord();
                WordModel bottomWord = clueCellView.getBottomWord();
                if (rightWord != null) {
                    JSONObject right_obj = new JSONObject();
                    right_obj.put("vertical", false);
                    right_obj.put("sum", rightWord.getTotalForWord());
                    right_obj.put("index", i);
                    JSONArray cell_indices = new JSONArray();

                    CellModel[] cellModels = rightWord.getCellModelArray();
                    for (int j = 0; j < cellModels.length; j++) {
                        CellView cm_cellView = cellModels[j].getCellView();
                        cell_indices.add(cm_cellView.getIndex());
                    }

                    right_obj.put("cell_indices", cell_indices);
                    word_array.add(right_obj);
                }
                if (bottomWord != null) {
                    JSONObject bottom_obj = new JSONObject();
                    bottom_obj.put("vertical", true);
                    bottom_obj.put("sum", bottomWord.getTotalForWord());
                    bottom_obj.put("index", i);
                    JSONArray cell_indices = new JSONArray();

                    CellModel[] cellModels = bottomWord.getCellModelArray();
                    for (int j = 0; j < cellModels.length; j++) {
                        CellView cm_cellView = cellModels[j].getCellView();
                        cell_indices.add(cm_cellView.getIndex());
                    }

                    bottom_obj.put("cell_indices", cell_indices);
                    word_array.add(bottom_obj);
                }
            }
            JSONObject cell_object = new JSONObject();
            cell_object.put("correct", correctValue);
            cell_object.put("current", currentValue);
            cell_array.add(cell_object);
        }
        json_output.put("cells", cell_array);
        json_output.put("words", word_array);

        FileWriter writer = new FileWriter(filename);
        writer.write(json_output.toJSONString());
        writer.flush();
        writer.close();
    }

    public void loadGame(View.BoardView boardView, String filepath) {
        JSONObject jsonObject;
        try {
            jsonObject = readJSONFile(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        boardView.initComponents(jsonObject);
    }

    // imports the JSON file for the game
    private JSONObject readJSONFile(String filepath) throws IOException, ParseException {
        JSONObject input_json = null;
        input_json = (JSONObject) new JSONParser().parse(new FileReader(filepath));

        return input_json;
    }

    public void initializeWordModelArray(int size) {
        gbModel.initializeWordModelArray(size);
    }

    public Model.GameBoardModel getGameBoardModel() {
        return gbModel;
    }
}