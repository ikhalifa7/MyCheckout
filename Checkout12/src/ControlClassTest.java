import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ControlClassTest {
	
	private ControlClass control;

	@Before
	public void setUp() throws Exception {
		control = new ControlClass();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFullDetails() {
		
		/*
		 *  the barcode 111 is going to be passed in as a parameter
		 *  this should return the name and price of  kiwi product
		 * 
		 */
		
		assertEquals("Kiwi  0.99", control.getFullDetails("111"));
		
		/*
		 *  the barcode 222 is going to be passed in as a parameter
		 *  this should return the name and price of  coconut product
		 * 
		 */
		
		assertEquals("Coconut  1.99", control.getFullDetails("222"));
		
		// we now know it is working properly
		
		
	}
	
	
/*
	@Test
	public void testGetItemObject() {
		
		
	}*/

	@Test
	public void testGetPrice() {
		/**
		 * Once the barcode is passed to the control object, it gets the full details that is to appear on the gui
		 * It the stores the price of the most recent object 
		 * That is what we are testing
		 * We will scan kiwi and coconut which will make them most recent items respectively
		 * And we know its price is 0.99 from the above test
		 */
		
		control.getFullDetails("111");
		assertEquals(0.99, control.getPrice(),0.0);
		
		control.getFullDetails("222");
		assertEquals(1.99, control.getPrice(),0.0);
	}

	@Test
	public void testSafeMethods() {
		/*
		 * We are going to test that this method adds money to the store safe
		 * This will be done by adding a certain amount to the safe and the checking the value of the safe
		 */
		
		control.addToSafe(50); // money added
		assertEquals(50, control.checkSafe(),0.0); // safe checked
		
		/*
		 *  this also tells us that the "checkSafe" method works. Hence we wont do a seperate test for it
		 *  we will also use this method to test the "resetSafe" method
		 *  This sets the safe to "0"
		 *  And we already know the safe is "50"
		 */
		
		control.resetSafe();
		assertEquals(0.0, control.checkSafe(),0.0);
		
	}
	
	
	

	
	
	

	@Test
	public void testOpenTill() {
		/*
		 * This method checks that a till is opened
		 * This will be tested by creating two new checkouts
		 * Which will be added to a list of checkouts 
		 * We will the check the size of the list
		 * Which should be two
		 */
		
		control.openTill("ISMAILA"); // password = 2222
		control.openTill("MANAGER"); // password = 1965
		
		// we will now get the checkout list and check its size. It should be two
		ArrayList<CheckoutScreen> checkoutList = control.getCheckoutList();
		
		assertEquals(2, checkoutList.size());
		
		// This also confirms that the "getCheckoutList" method works. No need to test it else where
	}
	
	
	

	@Test
	public void testVerify() {
		
		/*
		 * When a username and password is entered into the login screen
		 * This method gets the actual password and compares it to the entered password
		 * It the lets the user log i or asks them to reenter password
		 * 
		 */
		
		assertEquals("2222",  control.verify("ISMAILA" ));
		assertEquals("1965",  control.verify("MANAGER" ));
		
	}
	

	@Test
	public void testAddTransaction() {
		/*
		 * This method adds an ArrayList of products (transaction) after the cashier serves every customer
		 * 
		 */
		
		
		// this customer only buys one mango
		ArrayList<Products> transaction = new ArrayList<Products>();
		transaction.add(new Products("Mango", "Ripe and juicy", 1.99));
		
		ArrayList<Products> transaction1 = new ArrayList<Products>();
		transaction.add(new Products("Orange", "From canada", 0.99));
		transaction.add(new Products("Candle", "Nice smell", 2.99));
		
		// add the transactions to the list
		control.addTransaction("101", transaction);
		
		/*
		 *  we will now use the "getTransactions" method to retrieve the transactions 
		 *  And then see if the hold the objects above
		 */
		
		ArrayList<Products> retrivedTransaction = control.getTransactions("101");
		Products mango = retrivedTransaction.get(0);
		assertEquals("Ripe and juicy",  mango.getDetails());		
		
		
	}
	

}
