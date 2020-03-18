/**
 *
 *
 * author: Mario Lapadula
 */

package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controller.GameController;
import Controller.TrainingController;
import View.CellView;

class TestForGameBoardModel {

    // **************************************************
    // Public methods
    // **************************************************
    @Test
    public void testGameBoardModel() {
        WordModel[] wordModelArray = new WordModel[34];
        assertNotNull("array not NULL", wordModelArray);

        wordModelArray = null;
        assertNull("array is NULL", wordModelArray);
    }

    @Test
    public void testGameBoardModelInt() {
        int size = 10;
        WordModel[] wordModelArray = new WordModel[size];
        assertNotNull("Word array exists", wordModelArray);

        wordModelArray = null;
        assertNull("Word array not exist", wordModelArray);
    }

    @Test
    public void testGameBoardModelIntInt() {
        int size = 10;
        WordModel[] wordModelArray = new WordModel[size];
        assertNotNull("Word array exists", wordModelArray);

        wordModelArray = null;
        assertNull("Word array not exist", wordModelArray);
    }

    @Test
    public void testUpdate() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(5, new CellView(tst));

        assertTrue("Update CellModel Test", testModel.update("5"));
        assertFalse("Update CellModel Test", testModel.update("A"));
    }

    @Test
    public void testUpdateTraining() {
        TrainingController tst = new TrainingController();
        CellModel testModel = new CellModel(5, new CellView(tst));

        assertTrue("Update CellModel Test", testModel.update("5"));
        assertFalse("Update CellModel Test", testModel.update("A"));
    }

    @Test
    public void testSetGetWordModelAtIndex() {
        GameBoardModel testModelArray = new GameBoardModel();
        testModelArray.setWordModelAtIndex(1, new WordModel());
        assertNotNull("Array at index 1 is not Null", testModelArray.getWordModelAtIndex(1));
    }


    @Test
    public void testSetGetWhatNeedsToBeFixed() {
        GameBoardModel testModelArray = new GameBoardModel();
        testModelArray.setWhatNeedsToBeFixed("5");
        assertSame("The word to be fixed is 5", "5", testModelArray.getWhatNeedsToBeFixed());

        testModelArray.setWhatNeedsToBeFixed("6");
        assertNotSame("The word to be fixed is not 5", "5", testModelArray.getWhatNeedsToBeFixed());
    }

    @Test
    public void testGetWordModelCount() {
        GameBoardModel testModelArray = new GameBoardModel();

        assertEquals("The default Array size  is 34", 34, testModelArray.getWordModelCount());

        int size = 15;
        GameBoardModel testModelArray2 = new GameBoardModel(size);
        assertNotEquals("The new array is not the of default size of 34 ", 34, testModelArray2.getWordModelCount());

    }

    @Test
    public void testSetGetLength() {
        GameBoardModel testModelArray = new GameBoardModel();
        testModelArray.setLength(5);
        assertEquals("The length is 5", 5, testModelArray.getLength());

        testModelArray.setLength(6);
        assertNotEquals("The length is 5", 5, testModelArray.getLength());
    }

    @Test
    public void testInitializeWordModelArray() {
        int size = 10;
        WordModel[] wordModelArray = new WordModel[size];
        assertNotNull("Word array exists", wordModelArray);

        wordModelArray = null;
        assertNull("Word array not exist", wordModelArray);
    }
}
