package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Controller.GameController;
import Controller.TrainingController;
import View.CellView;

class TestForCellModel {
	

    @Test
    public void testCellModel() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(5, new CellView(tst));

        assertNotNull("CellModel not NULL", testModel);

        CellModel testModel2 = null;
        assertNull("CellModel attribute NULL", testModel2);
    }

    @Test
    public void testCellModelIntCellView() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(5, new CellView(tst));

        assertNotNull("CellModel not NULL", testModel);

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
    public void testIsDigit() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        assertTrue("Update CellModel Test", testModel.isDigit("9"));
        assertFalse("Update CellModel Test", testModel.isDigit("A"));
    }

    @Test
    public void testIsSignleDigit() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        assertTrue("Update CellModel Test", testModel.isSignleDigit("9"));
        assertFalse("Update CellModel Test", testModel.isSignleDigit("10"));
        assertFalse("Update CellModel Test", testModel.isSignleDigit("A"));
    }

    @Test
    public void testIsCorrectNumber() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        assertTrue("Update CellModel Test", testModel.isCorrectNumber(9));
        assertFalse("Update CellModel Test", testModel.isCorrectNumber(10));

    }

    @Test
    public void testGetIsCorrect() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        testModel.setCorrect(true);
        assertTrue("Cell is Correct", testModel.getIsCorrect());

        testModel.setCorrect(false);
        assertFalse("Cell is not correct", testModel.getIsCorrect());
    }

    @Test
    public void testGetCorrectNumber() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        assertEquals("This is the correct number", 9, testModel.getCorrectNumber());
        assertNotEquals("This is the incorrect number", 7, testModel.getCorrectNumber());
    }


    @Test
    public void testGetUserNumber() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));

        testModel.update("8");

        assertEquals("This is the correct User number", 8, testModel.getUserNumber());
        assertNotEquals("This is the incorrect User number", 9, testModel.getUserNumber());
    }

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

    @Test
    public void testSetViewsText() {
        GameController tst = new GameController();
        CellModel testModel = new CellModel(9, new CellView(tst));
        testModel.update("9");
        testModel.setViewsText();

        assertEquals("This is the correct User number", 9, testModel.getUserNumber());
        assertNotEquals("This is the incorrect User number", 8, testModel.getUserNumber());
    }


    @Test
    public void testAddToObserverList() {

        CellModel tstModel = new CellModel();

        assertTrue("CellModel is NULL", tstModel.getWordObserverlist().isEmpty());

        tstModel.addToObserverList(new WordModel());
        assertNotNull("CellModel not NULL", tstModel.getWordObserverlist());

    }


}
