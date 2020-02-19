package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import View.TextCell;
import Controller.GameController;

public class ValidationTest {
	@Test
	//test ValidateText Method from TextCell class
	public void testForValidateText() {
		
		GameController controller = new GameController();
		
		//initialize value for TextCell object, TextCell (gameController, ExpectedValue)
		TextCell tester = new TextCell(controller, "3");
		
		//inputValue match expectedValue
		assertTrue(tester.validateText("3"));
		
		//input does not match expectedValue
		tester = new TextCell(controller, "5");
		assertFalse(tester.validateText("3"));
		
	
}
}
