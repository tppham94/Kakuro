/**
 * The TestForGameBoardModel class contains methods to test the important GameBoardModel methods properly work.
 * @author Mario Lapadula

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
	
	/**
     * This is to test the GameBoardModel default constructor to insure the GameBoard model is created when called. 
     * It creates a WorldModel object Array with a default size.
     * It then asserts that object Array is created or not if a null Array is passed.
     */
    @Test
    public void testGameBoardModel() {
        WordModel[] wordModelArray = new WordModel[34];
        assertNotNull("array not NULL", wordModelArray);

        wordModelArray = null;
        assertNull("array is NULL", wordModelArray);
    }

	/**
     * This is to test the GameBoardModel default constructor to insure the GameBoard model is created when called. 
     * It creates a WorldModel object Array with a defined size received from the call.
     * It then asserts that object Array is created or not if a null Array is passed.
     */
    @Test
    public void testGameBoardModelInt() {
        int size = 10;
        WordModel[] wordModelArray = new WordModel[size];
        assertNotNull("Word array exists", wordModelArray);

        wordModelArray = null;
        assertNull("Word array not exist", wordModelArray);
    }

    /**
     * This is to test the GameBoardModel default constructor to insure the GameBoard model is created when called. 
     * It creates a WorldModel object Array with a defined size received from the call.
     * It then asserts that object Array is created or not if a null Array is passed.
     */
    @Test
    public void testGameBoardModelIntInt() {
        int size = 10;
        WordModel[] wordModelArray = new WordModel[size];
        assertNotNull("Word array exists", wordModelArray);

        wordModelArray = null;
        assertNull("Word array not exist", wordModelArray);
    }

    /**
     * This is to test the update(String str) method that receives a string value. 
     * It receives a string value for  a CellView object for a game controller object.
     * It verifies that this CellModel for that CellView is updated correctly by asserting the expected value.
     */    	
    @Test
    public void testUpdate() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(5, new CellView(tst));

        assertTrue("Update CellModel Test", testModel.update("5"));
        assertFalse("Update CellModel Test", testModel.update("A"));
    }

    /**
     * This is to test the updateTraining(String str) method that receives a string value. 
     * It receives a string value for a  CellView object for a training controller object.
     * It verifies that this CellModel for that CellView is updated correctly by asserting the expected value.
     * 
    */    
    @Test
    public void testUpdateTraining() {
        TrainingController tst = new TrainingController();
        CellModel testModel = new CellModel(5, new CellView(tst));

        assertTrue("Update CellModel Test", testModel.update("5"));
        assertFalse("Update CellModel Test", testModel.update("A"));
    }

    /**
     * This is to test the setWordModelAtIndex() and getWordModelAtIndex methods. 
     * It receives a int value for a WordlModel object to assign to the Word Array.
     * It tests by for calling the set method to set the object with and index to the Word Array and
     * then asserts by that Array contains the object at the index of the value returned from the get method. 
    */   
    @Test
    public void testSetGetWordModelAtIndex() {
        GameBoardModel testModelArray = new GameBoardModel();
        testModelArray.setWordModelAtIndex(1, new WordModel());
        assertNotNull("Array at index 1 is not Null", testModelArray.getWordModelAtIndex(1));
    }

    /**
     * This is to test the setWhatNeedsToBeFixed() and getWhatNeedsToBeFixed methods. 
     * It creates a GameBoardModel object, and with the set method it assigns the string value to be fixed.
     * It tests by for calling the get method on the obj Array to get the value and then asserts by if matches the expected value. 
    */   
    @Test
    public void testSetGetWhatNeedsToBeFixed() {
        GameBoardModel testModelArray = new GameBoardModel();
        testModelArray.setWhatNeedsToBeFixed("5");
        assertSame("The word to be fixed is 5", "5", testModelArray.getWhatNeedsToBeFixed());

        testModelArray.setWhatNeedsToBeFixed("6");
        assertNotSame("The word to be fixed is not 5", "5", testModelArray.getWhatNeedsToBeFixed());
    }

    /**
     * This is to test the getWhatNeedsToBeFixed method. 
     * It creates a GameBoardModel object by calling default constructor.
     * It tests by for calling the get method on the obj Array to get the value for the size. 
     * It then asserts to see that size returned is equal to the expected default size, and if a specific size is assigned its not equal to default size.
    */   
    @Test
    public void testGetWordModelCount() {
        GameBoardModel testModelArray = new GameBoardModel();

        assertEquals("The default Array size  is 34", 34, testModelArray.getWordModelCount());

        int size = 15;
        GameBoardModel testModelArray2 = new GameBoardModel(size);
        assertNotEquals("The new array is not the of default size of 34 ", 34, testModelArray2.getWordModelCount());

    }

    /**
     * This is to test the setLength and getLength methods. 
     * It creates a GameBoardModel object by calling default constructor.
     * It tests by for calling the set method on the obj Array to set a specific length. 
     * It then asserts to see that get method returned is equal to the expected set length, and if the length assigned its not equal to expected length.
    */   
    @Test
    public void testSetGetLength() {
        GameBoardModel testModelArray = new GameBoardModel();
        testModelArray.setLength(5);
        assertEquals("The length is 5", 5, testModelArray.getLength());

        testModelArray.setLength(6);
        assertNotEquals("The length is 5", 5, testModelArray.getLength());
    }

    /**
     * This is to test the initializeWordModelArray method. 
     * It creates a WorldModel object Array with a defined size received from the call.
     * It then asserts that object Array is created or not if a null Array is passed.
     */
    @Test
    public void testInitializeWordModelArray() {
        int size = 10;
        WordModel[] wordModelArray = new WordModel[size];
        assertNotNull("Word array exists", wordModelArray);

        wordModelArray = null;
        assertNull("Word array not exist", wordModelArray);
    }
}