package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import Controller.GameController;

public class RangeTest {
	@Test
	public void ifInputIsFromZeroToNine() {
		//GameController validateNumberRange method is tested
		GameController tester = new GameController();
		
		//input is less than 1
		assertFalse(tester.validateNumberRange("0"), "0 must be false for the specified range");
		
		//input is between 1 and 9
		assertTrue(tester.validateNumberRange("5"), "5 must be true for the specified range");
		
		
		//input is greater than 9
		assertFalse(tester.validateNumberRange("10"), "10 must be false for the specified range");
		

	}
	
}
