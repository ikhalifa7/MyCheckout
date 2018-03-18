import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TransactionTest {
	
	private Transaction trans;

	@Before
	public void setUp() throws Exception {
		
		trans = new Transaction();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	

	@Test
	public void testAddtransactionAndGetTransaction() {
		/*
		 * This method adds an ArrayList of products (transaction) after the cashier serves every customer
		 * 
		 */
		
		
		// this customer only buys one mango
		ArrayList<Products> transaction = new ArrayList<Products>();
		transaction.add(new Products("Mango", "Ripe and juicy", 1.99));
		
		ArrayList<Products> transaction1 = new ArrayList<Products>();
		transaction1.add(new Products("Orange", "From canada", 0.99));
		transaction1.add(new Products("Candle", "Nice smell", 2.99));
		
		// add the transactions to the list
		trans.addTransaction("101", transaction);
		
		/*
		 *  we will now use the "getTransactions" method to retrieve the transactions 
		 *  And then see if the hold the objects above
		 */
		
		ArrayList<Products> retrivedTransaction = trans.getTransaction("101");
		Products mango = retrivedTransaction.get(0);
		assertEquals("Ripe and juicy",  mango.getDetails());	
	}

}
