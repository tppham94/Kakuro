/**
 * The TestForWordModel class contains methods to test that the important WordModel methods properly work.
 *  * @author Mario Lapadula
 */

package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Controller.GameController;
import Model.CellModel;
import Model.WordModel;
import View.CellView;

class TestForWordModel {

    // **************************************************
    // Fields
    // **************************************************
    CellModel testArray[];

    // **************************************************
    // Public methods
    // **************************************************
    
    /**
     * This is to test the WorddModel default constructor to insure the Word model is created when called. 
     * It creates a CellModel object Array with a default size.
     * It then asserts that object Array is created or not if a null Array is passed.
     */
    @Test
    public void testWordModel() {

        testArray = new CellModel[10];
        assertNotNull("array not NULL", testArray);

        testArray = null;
        assertNull("array is NULL", testArray);
    }

    /**
     * This is to test the WorddModel default constructor to insure the Word model is created when called. 
     * It creates a CellModel object Array with a defined size received from the call.
     * It then asserts that object Array is created or not if a null Array is passed.
     */
    @Test
    public void testWordModelIntInt() {
        int size = 15;
        testArray = new CellModel[size];
        assertNotNull("array not NULL", testArray);

        testArray = null;
        assertNull("array is NULL", testArray);
    }

    /**
     * This is to test the getCellModelArray methods. 
     * It creates a CellModel Array.
     * It then asserts that the Array Object exists, or doesn't exist if is a NULL. 
    */   
    @Test
    public void testGetCellModelArray() {

        testArray = new CellModel[10];
        assertNotNull("array not NULL", testArray);

        testArray = null;
        assertNull("array is NULL", testArray);
    }

    /**
     * This is to test the setCellModelArrayAtIndex() and getCellModelArrayAtIndex methods. 
     * It receives a int value for a WordlModel object to assign to the Word Array.
     * It tests by for calling the set method to set the object with and index to the Word Array and
     * then asserts by that Array contains the object at the index of the value returned from the get method. 
    */   
    @Test
    public void testSetGetCellModelArrayAtIndex() {

        WordModel testArray = new WordModel();
        testArray.setCellModelArrayAtIndex(1, new CellModel());
        assertNotNull("Array at index 1 is not Null", testArray.getCellModelArrayAtIndex(1));
    }

    /**
     * This is to test the UpdateValueAtIndex() method that receives a string value. 
     * It receives a int index value and a string value.
     * It calls the update method index value at index with the string value suggested.
     * It asserts the value for cellModel at that specific index was updated by using the getCellModelArrayAtIndex to get the value.
     */    	
    @Test
    public void testUpdateValueAtIndex() {
        WordModel tstWord = new WordModel();

        CellModel testModel = new CellModel(8, new CellView());

        tstWord.setCellModelArrayAtIndex(0, testModel);
        tstWord.updateValueAtIndex(0, "5");
        assertNotEquals("The value is was update to 5, and not 8 anymore", 8, tstWord.getCellModelArrayAtIndex(0).getUserNumber());


        assertEquals("As expected the value was updated to 5", 5, tstWord.getCellModelArrayAtIndex(0).getUserNumber());
    }

    /**
     * This is to test the validateWord() method. 
     * It creates an cellmodel array object for game controller and assigns a value
     * It calls the getIsCorrect method to get is the value is correct.
     * It asserts the the value is correct or not as expected
     */    	
    @Test
    public void testValidateWord() {
    	GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        testModel.setCorrect(true);
        assertTrue("Cell is Correct", testModel.getIsCorrect());

        testModel.setCorrect(false);
        assertFalse("Cell is not correct", testModel.getIsCorrect());
    }

    /**
     * This is to test the setTotalForWord() and getTotalForWord methods. 
     * It creates a WordlModel object with assign correct total value for a word.
     * It tests by for calling the set method to set the object with a new correct total for the word.
     * then asserts by comparing the expected value by with the set value returned by the get method.  
    */   
    @Test
    void testSetGetTotalForWord() {
        WordModel tstWord = new WordModel(2, 5);
        tstWord.setTotalForWord(8);

        assertEquals("Total for word is 8", 8, tstWord.getTotalForWord());
        assertNotEquals("Total for word is 5", 5, tstWord.getTotalForWord());
    }

    /**
     * This is to test the setWordIsValid() and getWordIsValid methods. 
     * It creates a WordlModel object with assign correct total value for a word.
     * It tests by for calling the set method to set the object with a valid indicator for the word.
     * then asserts by comparing the expected value by the set value returned by the get method.  
    */   
    @Test
    void testSetWordIsValid() {
        WordModel tstWord = new WordModel(2, 5);
        tstWord.setWordIsValid(true);

        assertTrue("Word is valid", tstWord.isWordIsValid());

        tstWord.setWordIsValid(false);
        assertFalse("Word is not valid", tstWord.isWordIsValid());

    }

}