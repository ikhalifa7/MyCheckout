import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CheckoutScreenTest {
	
	CheckoutScreen checkout;

	@Before
	public void setUp() throws Exception {
		checkout = new CheckoutScreen("ISMAILA");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	

	@Test
	public void testPutOnList() {
		/*
		 * This method displays products details on the window when the right barcode is entered
		 * 
		 */
		
		checkout.putOnList("111");
		
		/*
		 * 111 is kiwi and its price is 0.99
		 *  display details of kiwi on the window
		 */
		
	}

	@Test
	public void testTransaction() {
		/*
		 * This method allows customer to make payment to the cashier
		 * 
		 */
		
		checkout.putOnList("111"); // scan a kiwi which is 0.99
		
		checkout.transaction(2); // give cashier 2
		
		// This should calculate chaange and adds the money paid to the till total
		assertEquals(0.99, checkout.getTotalMoney(), 0.0); 
		
		
	}

	@Test
	public void testSetMessageAndGetMessage() {
		
		/*
		 * This method takes in a string message and stores it, this is then accessed by store manager
		 */
		checkout.setMessage("Hello");
		
		// get the message and confirm that it is the same
		assertEquals("Hello", checkout.getMessage()); 
		// this means the getMessage method works
	}

	

	@Test
	public void testGetCashier() {
		/*
		 * This returns the name of the cashier that is using the till
		 */
		
		assertEquals("ISMAILA", checkout.getCashier()); 
	}


}
