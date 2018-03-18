

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ProductsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProductsTest
{
    /**
     * Default constructor for test class ProductsTest
     */
    public ProductsTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetName()
    {
        Products products1 = new Products("Lamb", "Very Yummy", 0.99);
        assertEquals("Lamb", products1.getName());
    }

    @Test
    public void testGetPrice()
    {
        Products products1 = new Products("Lamb", "Very Yummy", 0.99);
        assertEquals(0.99, products1.getPrice(), 0.0);
    }

    @Test
    public void testGetDetails()
    {
        Products products1 = new Products("Lamb", "Very Yummy", 0.99);
        assertEquals("Very Yummy", products1.getDetails());
    }
}




