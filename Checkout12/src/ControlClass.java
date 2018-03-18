

import java.awt.Component;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultListModel;

/**
 * This is the control class that links the GUI to the other classes
 * It gets the values from the other classes and makes them available to the GUI
 * @author Ismaila Khan
 */

public class ControlClass {


	private CheckoutScreen checkout ;
	private HashMapOfProductArrayLists product ;
	private DefaultListModel DML ;
	private double productPrice;
	private String details;
	private String fullDetails;
	private ArrayList<Products> productList;
	private String barcode1;
	private LoginDetails logindetails; 
	private String message;
	private Transaction transactions;
	private StoreSafe safe;
	private CheckoutManager manager;
	private TipOfTheDay tip;



	/**
	 * No parameters passed in
	 */
	public ControlClass() {

		DML = new DefaultListModel<String>();
		product = new HashMapOfProductArrayLists();
		logindetails = new LoginDetails();
		transactions = new Transaction();
		safe = new StoreSafe();
		manager = new CheckoutManager();
		tip = new TipOfTheDay();
	}



	// PRODUCTS 


	/**
	 * Returns the concatenated name and price of the product that matches the given barcode. eg Apple 2.99
	 * @param barcode String
	 * @return	String
	 */
	public String getFullDetails(String barcode) {

		barcode1 = barcode;
		productList = product.getProductList(barcode);
		Products product = productList.get(0);	
		productPrice = product.getPrice();
		//productTemp = product;
		return product.getName() + "  " + product.getPrice();

	}

	/**
	 * This method returns the Products object that matches the barcode
	 * @param barcode String
	 * @return Products
	 */
	public Products getItemObject(String barcode){

		productList = product.getProductList(barcode);
		return productList.get(0);
	}


	/**
	 * This method returns the product price of item recently scanned item
	 * @return	double
	 */
	public double getPrice() {

		return productPrice;

	}



	//STORE SAFE 

	/**
	 * This method adds money to the store safe
	 * @param double
	 */

	public void addToSafe(double money){
		safe.putMoney(money);
	}

	/**
	 * This method checks how much money is in the safe and returns its value
	 * @return double
	 */
	public double checkSafe(){
		return safe.checkSafe();
	}
	
	public void resetSafe(){
		safe.clear();
	}
	
	// CHECKOUT CREATION
	
	/**
	 * Creates a new "CheckoutScreen" object which is a new checkout GUI
	 * @return CheckoutScreen
	 */
	public CheckoutScreen  openTill(String cashier) {
		
		return manager.newCheckout(cashier);
	}
	
	public ArrayList<CheckoutScreen> getCheckoutList(){
		return manager.getList();
	}


	// USER AND LOGIN
	
	/**
	 * This method returns the password that matches the username. If any.
	 * @param user String
	 * @return String
	 */
	public String verify(String user){
		
		return logindetails.getPassword(user);
		
	}

	
	// Transaction
	/**
	 * This method returns the transaction object that has a list of all transactions
	 * @param ID String
	 * @return ArrayList<Products>
	 */
	public ArrayList<Products> getTransactions(String ID) {
		return transactions.getTransaction(ID);
	}


	/**
	 * This method adds a transaction to the list of transactions
	 * @param String
	 * @param ArrayList<Products> items
	 */
	public void addTransaction(String ID, ArrayList<Products> items){
		transactions.addTransaction(ID, items);
	}
	
	// TIP OF THE DAY 
	
	/**
	 * This method returns the generated tip of the day
	 * @return String
	 */
	public String getTip(){
		return tip.generateTip();
	}
	
	public Set<String> getStaffKeySet(){
		
		return logindetails.getKeys();
	}



}
