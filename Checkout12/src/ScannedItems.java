import java.util.ArrayList;

/**
 * This is the class that stores all the scanned objects for a  particular transactions
 * @author Ismaila Khan
 *
 */

public class ScannedItems {
	
	
	
	private ArrayList<Products> scannedItems;
	
	/**
	 * No parameters needed.
	 */
	public ScannedItems(){
		scannedItems = new ArrayList<Products>();
	}
	
	/**
	 * This method adds a product object to the list of "scannedItems"
	 * @param item Products
	 */
	public void addScannedItem(Products item){
		
		scannedItems.add(item);
	}
	
	/**
	 * This method returns the list of scanned items
	 * This method is used for testing purposes only
	 * @return ArrayList<Products>
	 */
	
	public ArrayList<Products> getList(){
		return scannedItems;
	}
}
