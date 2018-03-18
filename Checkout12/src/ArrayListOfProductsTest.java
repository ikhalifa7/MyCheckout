

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class ArrayListOfProductsTest.
 * The products class was tested before this class.
 * This class uses objects of the products class.
 * Therefore it has been decided to use the objects of the Products class to do the testing on this one.
 * @author  Ismaila Khan
 */
public class ArrayListOfProductsTest
{
    /**
     * Default constructor for test class ArrayListOfProductsTest
     */
    public ArrayListOfProductsTest()
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
    public void testGetKiwi()
    {
        // make new instance of the class that is to be tested
        ArrayListOfProducts arrayLis2 = new ArrayListOfProducts();
        
        // make a kiwi object to be used for comparism
        Products kiwi1 = new Products("Kiwi", "Juicy kiwi fruit", 0.99);
		
        // get the arrayList from the class using the method that is being tested
        ArrayList<Products>  products = arrayLis2.getKiwi();
        
        // get the kiwi object from the ArrayList
        Products kiwi2 = products.get(0);
        
        // get the name of the test object
        String nameOfTestObject = kiwi1.getName();
        
        // compare it to the name of the actual object
        assertEquals(nameOfTestObject, kiwi2.getName()); 
    }
    
    @Test
    public void testGetCoconut()
    {
        // make new instance of the class that is to be tested
        ArrayListOfProducts arrayLis2 = new ArrayListOfProducts();
        
        // make a coconut object to be used for comparism
        Products coconut1 = new Products ("Coconut", "Watery coconut fruit", 1.99);
		
        // get the  arrayList from the class using the method that is being tested
        ArrayList<Products>  products = arrayLis2.getCoconut();
        
        // get the kiwi object from the ArrayList
        Products coconut2 = products.get(0);
        
        // get the name of the test object
        String nameOfTestObject = coconut1.getName();
        
        // compare it to the name of the actual object
        assertEquals(nameOfTestObject, coconut2.getName()); 
       
    }
    
    @Test
    public void testGetBeer()
    {
        // make new instance of the class that is to be tested
        ArrayListOfProducts arrayLis2 = new ArrayListOfProducts();
        
        // make a beer object to be used for comparism
        Products beer1 = new Products ("Beer ", "UK brewed beer ", 2.99);
        
        // get the arrayList from the class using the method that is being tested
        ArrayList<Products>  products = arrayLis2.getBeer();
        
        // get the beer object from the ArrayList
        Products beer2 = products.get(0);
        
        // get the name of the test object
        String nameOfTestObject = beer1.getName();
        
        // compare it to the name of the actual object
        assertEquals(nameOfTestObject, beer2.getName()); 
       
    }
    
    
    @Test
    public void testGetChampange()
    {
        // make new instance of the class that is to be tested
        ArrayListOfProducts arrayLis2 = new ArrayListOfProducts();
        
        // make a champange object to be used for comparism
        Products champange1 = new Products ("Champange ", "Tasty American champange ", 6.99);
        
        // get the arrayList from the class using the method that is being tested
        ArrayList<Products>  products = arrayLis2.getChampange();
        
        // get the beer object from the ArrayList
        Products champange2 = products.get(0);
        
        // get the name of the test object
        String nameOfTestObject = champange1.getName();
        
        // compare it to the name of the actual object
        assertEquals(nameOfTestObject, champange2.getName()); 
       
    }
    
    @Test
    public void testGetTomato()
    {
        // make new instance of the class that is to be tested
        ArrayListOfProducts arrayLis2 = new ArrayListOfProducts();
        
        // make a tomato object to be used for comparism
        Products tomato1 = new Products ("Tomato ", "Red and Juicy Tomato straight from the farms ", 0.99);
        
        // get the arrayList from the class using the method that is being tested
        ArrayList<Products>  products = arrayLis2.getTomato();
        
        // get the beer object from the ArrayList
        Products tomato2 = products.get(0);
        
        // get the name of the test object
        String nameOfTestObject = tomato1.getName();
        
        // compare it to the name of the actual object
        assertEquals(nameOfTestObject, tomato2.getName()); 
       
    }
    
    @Test
    public void testGetPumpkin()
    {
        // make new instance of the class that is to be tested
        ArrayListOfProducts arrayLis2 = new ArrayListOfProducts();
        
        // make a pumpkin object to be used for comparism
        Products pumpkin1 = new Products ("Pumpkin ", "Perfect pumpkin for halloween  ", 2.25);
        
        // get the arrayList from the class using the method that is being tested
        ArrayList<Products>  products = arrayLis2.getPumpkin();
        
        // get the beer object from the ArrayList
        Products pumpkin2 = products.get(0);
        
        // get the name of the test object
        String nameOfTestObject = pumpkin1.getName();
        
        // compare it to the name of the actual object
        assertEquals(nameOfTestObject, pumpkin2.getName()); 
       
    }
    
    @Test
    public void testGetPork()
    {
        // make new instance of the class that is to be tested
        ArrayListOfProducts arrayLis2 = new ArrayListOfProducts();
        
        // make a pork object to be used for comparism
        Products pork1 = new Products ("Pork ", "Red and fresh prork straight from the farm  ", 2.56);
        
        // get the arrayList from the class using the method that is being tested
        ArrayList<Products>  products = arrayLis2.getPork();
        
        // get the beer object from the ArrayList
        Products pork2 = products.get(0);
        
        // get the name of the test object
        String nameOfTestObject = pork1.getName();
        
        // compare it to the name of the actual object
        assertEquals(nameOfTestObject, pork2.getName()); 
       
    }
    
     @Test
    public void testGetLamb()
    {
        // make new instance of the class that is to be tested
        ArrayListOfProducts arrayLis2 = new ArrayListOfProducts();
        
        // make a pork object to be used for comparism
        Products lamb1 = new Products ("Lamb ", "Perfect lamb for barbeque  ", 2.56);
        
        // get the arrayList from the class using the method that is being tested
        ArrayList<Products>  products = arrayLis2.getLamb();
        
        // get the beer object from the ArrayList
        Products lamb2 = products.get(0);
        
        // get the name of the test object
        String nameOfTestObject = lamb1.getName();
        
        // compare it to the name of the actual object
        assertEquals(nameOfTestObject, lamb2.getName()); 
       
    }
}

