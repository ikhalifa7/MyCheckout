import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CheckoutManagerTest {
	
	private CheckoutManager manager;

	@Before
	public void setUp() throws Exception {
		
		manager = new CheckoutManager();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewCheckoutAndGetListMethods() {
		/*
		*This method creates a new checkout and adds it to the list of checkouts
		*/
		
		 manager.newCheckout("ISMAILA"); // pass in cashier name
		 manager.newCheckout("MANAGER"); // pass in cashier name
		
		
		// get the list
		ArrayList<CheckoutScreen> list = manager.getList();
		
		// retrieve the checkouts
		CheckoutScreen check1Returned = list.get(0);
		CheckoutScreen check2Returned = list.get(1);
		
		// check that they are the same checkouts by confirming the cashier names entered above
		assertEquals("ISMAILA", check1Returned.getCashier()); 
		assertEquals("MANAGER", check2Returned.getCashier());
		assertEquals(2, list.size()); 
		
	}
	

	

}
