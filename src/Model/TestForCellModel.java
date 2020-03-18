/**
 * The TestForCellModel class contains methods to test that the important CellModel methods properly work.
 *  * @author Mario Lapadula
 */

package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Controller.GameController;
import Controller.TrainingController;
import View.CellView;

class TestForCellModel {

    // **************************************************
    // Public methods
    // **************************************************
	
	/**
     * This is to test the CellModel default constructor to insure the Cell model is created when called. 
     * It passes and Integer value and a CellView object for a game controller object.
     * It then asserts that CellModel object is created or not if a null CellModel is passed.
     */
    @Test
    public void testCellModel() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(5, new CellView(tst));

        assertNotNull("CellModel not NULL", testModel);

        CellModel testModel2 = null;
        assertNull("CellModel attribute NULL", testModel2);
    }

    /**
     * This is to test the CellModel constructor, expecting parameters,  to insure the Cell model is created when called. 
     * It passes and Integer value and a CellView object for a game controller object.
     * It then asserts that CellModel object is created or not if a null CellModel is passed.
     */
    @Test
    public void testCellModelIntCellView() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(5, new CellView(tst));

        assertNotNull("CellModel not NULL", testModel);
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
     * This is to test the isDigit(String str) method that receives a string value. 
     * It verifies is the string is an actual digit.
     * It verifies that this CellModel for that CellView is updated correctly by asserting the expected value.
     */    
    @Test
    public void testIsDigit() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        assertTrue("Update CellModel Test", testModel.isDigit("9"));
        assertFalse("Update CellModel Test", testModel.isDigit("A"));
    }

    /**
     * This is to test the isSingleDigit(String str) method that receives a string value. 
     * It verifies is the string is an actual single digit.
     * It verifies that this CellModel for that CellView is updated correctly by asserting the expected value.
     */ 
    @Test
    public void testIsSignleDigit() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        assertTrue("Update CellModel Test", testModel.isSignleDigit("9"));
        assertFalse("Update CellModel Test", testModel.isSignleDigit("10"));
        assertFalse("Update CellModel Test", testModel.isSignleDigit("A"));
    }

    /**
     * This is to test the isCorrectNumber(int userValue) method that receives a int userValue. 
     * It receives a integer value entered by user.
     * It verifies that the user value matches the value of the associated CellModel by asserting the expected value.
     * 
    */    
    @Test
    public void testIsCorrectNumber() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        assertTrue("Update CellModel Test", testModel.isCorrectNumber(9));
        assertFalse("Update CellModel Test", testModel.isCorrectNumber(10));
    }

    /**
     * This is to test the getIsCorrect() and setCorrect()methods. 
     * It creates an object and then calls the setCorrect() to assign a value.
     * It verifies by asserting the expected value to the object value by using the getCorrect() method for that object.
     * 
    */    
    @Test
    public void testGetIsCorrect() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        testModel.setCorrect(true);
        assertTrue("Cell is Correct", testModel.getIsCorrect());

        testModel.setCorrect(false);
        assertFalse("Cell is not correct", testModel.getIsCorrect());
    }

    /**
     * This is to test the getCorrectNumber() method. 
     * It creates an object and then with an integer number assigned to it.
     * It verifies by asserting the expected value to the object value by using the getIsCorrect() method for that object.
     * 
    */    
    @Test
    public void testGetCorrectNumber() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        assertEquals("This is the correct number", 9, testModel.getCorrectNumber());
        assertNotEquals("This is the incorrect number", 7, testModel.getCorrectNumber());
    }

    /**
     * This is to test the getUserNumber() method. 
     * It creates an object and then with an integer number assigned to it.
     * It then calls the update() method to update that initial value.
     * It verifies by asserting the expected value to the object value by using the getUserNumber() method for that object
     * and see that the value was updated as expected.
     * 
    */    
    @Test
    public void testGetUserNumber() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        testModel.update("8");

        assertEquals("This is the correct User number", 8, testModel.getUserNumber());
        assertNotEquals("This is the incorrect User number", 9, testModel.getUserNumber());
    }

    /**
     * This is to test the getCellView() and getCellView()methods. 
     * It creates an CellModel object
     * It verifies by asserting that the CellModel was created and exits. And if not exits is the CellModel is null.
     * 
    */    
    @Test
    public void testSetGetCellView() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));
        CellView testView = new CellView();
        testModel.setCellView(testView);

        assertNotNull("CellView exists", testModel.getCellView());

        testModel.setCellView(null);
        assertNull("CellView not exist", testModel.getCellView());
    }

    /**
     * This is to test the setViewsText() method. 
     * It creates an object and then with an integer number assigned to it.
     * It then calls the update() method to update that initial value and the SetViewsText to update the with the value entered by the user.
     * It verifies by asserting the expected value to the object value by using the getUserNumber() method for that object
     * and see that the value was updated as expected.
     * 
    */    
    @Test
    public void testSetViewsText() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));
        testModel.update("9");
        testModel.setViewsText();

        assertEquals("This is the correct User number", 9, testModel.getUserNumber());
        assertNotEquals("This is the incorrect User number", 8, testModel.getUserNumber());
    }

    /**
     * This is to test the testAddToObserverList(). 
     * It creates an CellModel object
     * It verifies by asserting that the CellModel was added the the Word observer list and the list is not empty. And if empty if nothing was added to it..
     * 
    */    
    @Test
    public void testAddToObserverList() {
        CellModel tstModel = new CellModel();

        assertTrue("CellModel is NULL", tstModel.getWordObserverlist().isEmpty());

        tstModel.addToObserverList(new WordModel());
        assertNotNull("CellModel not NULL", tstModel.getWordObserverlist());

    }


}