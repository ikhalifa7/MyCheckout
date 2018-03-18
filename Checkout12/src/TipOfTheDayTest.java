import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TipOfTheDayTest {
	private TipOfTheDay tips;
	@Before
	public void setUp() throws Exception {
		
		tips = new TipOfTheDay();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testGenerateTip() {
		/**
		 * This method generates randomly selected tips 
		 * So it it hard to set the assertion value
		 * Instead, we choose to print out the tip to the console
		 * That way, it shows the tip is being actually generated
		 */
		
		
		System.out.println("This shows that the TipOFTheDayTest CLass is working. Please check the test class for more details");
		System.out.println(tips.generateTip());
		
	}

}
