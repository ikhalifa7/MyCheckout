import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ScannedItemsTest {
	
	ScannedItems items;

	@Before
	public void setUp() throws Exception {
		items = new ScannedItems();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddScannedItem() {
		/*
		 * This adds all scanned products of a particular transaction to a list
		 */
		
		// add two products to the list
		items.addScannedItem(new Products("Banana", "Ripe", 0.49));
		items.addScannedItem(new Products("Apple", "Red", 0.50));
		
		
		//get the list of scanned items
		ArrayList<Products> scanned = items.getList();
		
		// check that the size of the list is now two
		assertEquals(2, scanned.size()); 
		
		// get the first product of the list and confirm its name and description
		Products product = scanned.get(0);
		

		assertEquals("Banana", product.getName()); 
		assertEquals("Ripe", product.getDetails()); 
	}

}
