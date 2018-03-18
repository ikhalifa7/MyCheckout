import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class LogInDetailsTest {
	
	private LoginDetails login;

	@Before
	public void setUp() throws Exception {
		
		login = new LoginDetails();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPassword() {
		/*
		 * We are going to test that the right password is returned after a username is entered
		 * and that no password is returned if the user does not exist
		 */
	
		assertEquals("2222",login.getPassword("ISMAILA") );
		assertEquals("4444",login.getPassword("PETER") );
		
		// test that nothing is returned if a user does not exist
		assertEquals(null,login.getPassword("INVALIDUSER") );
				
	}

}
