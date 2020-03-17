package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.CellModel;
import Model.GameBoardModel;
import Model.WordModel;
//import Model.WordWrapper;

public class ModelTesting {
//	@Test
//	public void testBoardUpdate() {
//		
//		GameBoardModel gbm = new GameBoardModel(2);
//		
//		WordModel wm = new WordModel(2, 5);
//		wm.setCellModelArrayAtIndex(0, 2);
//		wm.setCellModelArrayAtIndex(1, 3);
//		wm.updateValueAtIndex(0, "2");
//		wm.updateValueAtIndex(1, "3");
//		
//		
//		WordModel wmf = new WordModel(2, 5);
//		wmf.setCellModelArrayAtIndex(0, 2);
//		wmf.setCellModelArrayAtIndex(1, 3);
//		wm.updateValueAtIndex(0, "1");
//		wm.updateValueAtIndex(1, "2");
//
//		WordWrapper ww1 = new WordWrapper(wm);
//		WordWrapper ww2 = new WordWrapper(wm);
//		
//		gbm.setWordModelAtIndex(0, wm);
//		gbm.setWordModelAtIndex(1, wm);
//		
//		wm.validateWord();
//		wmf.validateWord();
//		
//		assertTrue("Game board is valid", gbm.update()); 
//		
//		wmf.validateWord();
//		gbm.setWordModelAtIndex(1, wmf);
//		assertFalse("Game board is Invalid", gbm.update()); 
//		
//	}
//	
//	@Test
//	public void testWordValidation() {
//		WordModel wm = new WordModel(2, 5);
//		wm.setCellModelArrayAtIndex(0, 2);
//		wm.setCellModelArrayAtIndex(1, 3);
//		wm.updateValueAtIndex(0, "2");
//		wm.updateValueAtIndex(1, "3");
//		
//		
//		WordModel wmf = new WordModel(2, 5);
//		wmf.setCellModelArrayAtIndex(0, 2);
//		wmf.setCellModelArrayAtIndex(1, 3);
//		wm.updateValueAtIndex(0, "1");
//		wm.updateValueAtIndex(1, "2");
//
//		assertEquals("Word is valid", "That word is valid", wm.validateWord()); 
//		assertEquals("Word is Invalid", "That word is not valid. Make sure all numbers are correct and nothing is repeated", wmf.validateWord()); 
//
//	}
//	
//	@Test
//	public void testUpdateValidation() {
//		CellModel cm = new CellModel(5);
//		assertEquals("Training is valid", "Success at updating number and that number is Correct", cm.update("5")); 
//		assertEquals("Training is valid but that number is InCorrect", "Success at updating number but that number is InCorrect", cm.update("4")); 
//		assertEquals("Invalid number", "Sorry not a number in between 1-9", cm.update("a")); 
//	}
//
//	@Test
//	public void testIsDigit() {
//		fail("Not yet implemented");
//		CellModel cm = new CellModel();
//		assertTrue("Is Single digit true", cm.isDigit("9")); 
//		assertFalse("Is Single digit false", cm.isDigit("a"));
//		
//	}
//
//	@Test
//	public void testIsSignleDigit() {
//		CellModel cm = new CellModel();
//		assertTrue("Is Single digit true", cm.isSignleDigit("9")); 
//		assertFalse("Is Single digit false", cm.isSignleDigit("11"));
//	}
//
//	@Test
//	public void testIsCorrectNumber() {
//		CellModel cm = new CellModel(5);
//		assertTrue("Is correct number true", cm.isCorrectNumber(5)); 
//		assertFalse("Is correct number false", cm.isCorrectNumber(4)); 
//
//	}

}
