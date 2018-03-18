

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class HashMapOfProductArrayListsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HashMapOfProductArrayListsTest
{
    /**
     * Default constructor for test class HashMapOfProductArrayListsTest
     */
    public HashMapOfProductArrayListsTest()
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
    public void testGetPtoductList()
    {
        // create a new object of the class that is to be tested
        HashMapOfProductArrayLists hashMap = new HashMapOfProductArrayLists();
        
        // call the get method with 111 as key. This should return an arraylist with one kiwi product in it
        ArrayList<Products> productList = hashMap.getProductList("111");
        // call the get method with 111 as key. This should return an arraylist with one kiwi product in it
        ArrayList<Products> productList1 = hashMap.getProductList("222");
        
        // get the kiwi object from the list
        Products kiwi = productList.get(0);
        // get the coconut object from the list
        Products coconut = productList1.get(0);
        
        // make a new kiwi object that is going to be used for comparism
        Products kiwi1 = new Products("Kiwi", "Juicy kiwi fruit", 0.99);
        // make a new coconut object that is going to be used for comparism
        Products coconut1 = new Products ("Coconut", "Watery coconut fruit", 1.99);
        
        // get the name of the test kiwi
        String name = kiwi1.getName();
        // get the name of the test coconut
        String name2 = coconut.getName();
        
        assertEquals(name, kiwi.getName());
        assertEquals(name2, coconut.getName());
    }
}

