package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull; 
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import Controller.GameController;
import View.CellView;

class TestForWordModel {

	CellModel testArray[];
	@Test
	public void testWordModel() {
		
		testArray = new CellModel[10];
		assertNotNull("array not NULL",testArray);
		
		testArray = null;
		assertNull("array is NULL",testArray);
	}

	@Test
	public void testWordModelIntInt() {
		int size = 15;
		testArray = new CellModel[size];
		assertNotNull("array not NULL",testArray);
		
		testArray = null;
		assertNull("array is NULL",testArray);
	}

	@Test
	public void testGetCellModelArray() {
		
		testArray = new CellModel[10];
		assertNotNull("array not NULL",testArray);
		
		testArray = null;
		assertNull("array is NULL",testArray);
	}

	@Test
	public void testSetGetCellModelArrayAtIndex() {
		
		WordModel testArray = new WordModel();
		testArray.setCellModelArrayAtIndex(1, new CellModel());
		assertNotNull("Array at index 1 is not Null",testArray.getCellModelArrayAtIndex(1));
	}

	@Test
	public void testUpdateValueAtIndex() {
		WordModel tstWord = new WordModel();
		
		CellModel testModel = new CellModel(8,new CellView());
		
		tstWord.setCellModelArrayAtIndex(0, testModel);	
		tstWord.updateValueAtIndex(0, "5");
		assertNotEquals("The value is was update to 5, and not 8 anymore",8, tstWord.getCellModelArrayAtIndex(0).getUserNumber());
				

        assertEquals("As expected the value was updated to 5",5 , tstWord.getCellModelArrayAtIndex(0).getUserNumber());
	}

	@Test
	public void testValidateWord() {
		GameController tst = new GameController();
		CellModel testModel = new CellModel(9,new CellView(tst));
		
		assertTrue("Update CellModel Test", testModel.isDigit("9"));
		assertFalse("Update CellModel Test", testModel.isDigit("A"));
	}

   	@Test
	void testSetGetTotalForWord() {
		WordModel tstWord = new WordModel(2, 5);
		tstWord.setTotalForWord(8);
				
		assertEquals("Total for word is 8", 8, tstWord.getTotalForWord());
		assertNotEquals("Total for word is 5", 5, tstWord.getTotalForWord());
	}

	
	@Test
	void testSetWordIsValid() {
		WordModel tstWord = new WordModel(2, 5);
		tstWord.setWordIsValid(true);
		
		assertTrue("Word is valid", tstWord.isWordIsValid());
		
		tstWord.setWordIsValid(false);
		assertFalse("Word is not valid", tstWord.isWordIsValid());
		
	}

}
