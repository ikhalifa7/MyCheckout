import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StoreSafeTest {
	
	private StoreSafe safe;

	@Before
	public void setUp() throws Exception {
		
		safe = new StoreSafe();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void testPutMoney() {
		/**
		 * This method simply adds money to the safe
		 */
		
		safe.putMoney(50); // we will now check that the money inside the safe is 50
		assertEquals(50,safe.checkSafe(),0.0 );
		
		// This method also confirms the "checksafeMethod" works
	}
	

	@Test
	public void testTakeMoney() {
		
		/*
		 * This method deducts money from the store safe
		 * Having put 50 into the safe, we will now take out 20
		 * And there should be 30 left
		 */
		
		
		safe.putMoney(20);
		safe.takeMoney(10);
		assertEquals(10,safe.checkSafe(),0.0);
	}

	

	@Test
	public void testClear() {
		/*
		 * This method removes all the money from the safe 
		 */
		
		safe.clear();
		assertEquals(0,safe.checkSafe(),0.0 );
	}

}
