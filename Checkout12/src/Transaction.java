/**
 * @author Ismaila Khan
 * This is a transaction class that adds to an ArrayList, all the items scanned for a customer 
 * This class is then used to create a receipt for each customer
 */

import java.util.ArrayList;
import java.util.HashMap;


public class Transaction {
	
	private HashMap<String, ArrayList<Products>> transactions; //An HashMap that contains all transactions made by cashier

	
	
	/**
	 * Takes in no parameter.
	 */
	public Transaction(){
		
		transactions = new HashMap<String, ArrayList<Products>>();
	}
	
	/**
	 * This method adds a transaction to the list of transactions
	 * @param ID String
	 * @param items ArrayList<Products>
	 */
	public void addTransaction(String ID, ArrayList<Products> items){
		transactions.put(ID, items);
	}
	
	/**
	 * This returns the transaction who's key matches the ID
	 * @param transID String
	 * @return ArrayList<Products>
	 */
	public ArrayList<Products> getTransaction(String transID){
		
		ArrayList<Products> transaction =  transactions.get(transID);
		transactions.remove(transID); 
		return transaction;
		
	}
}