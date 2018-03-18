
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;

/**
 * This class is a HashMap containing ArrayLists of Products with the product barcode used as key
 * * @author Ismaila Khan
 */


public class HashMapOfProductArrayLists {

	private HashMap<String, ArrayList<Products>> hashMapOfProductArrayList; // HashMap of ProductArrayLists with barcode used as key
	private ArrayListOfProducts productList; // ArrayList containing products

	/**
	 * Initializes the HashMap and ArrayList
	 * Adds products to the  HashMap and allocates a barcode to each product
	 * 
	 */
	public HashMapOfProductArrayLists() {

		hashMapOfProductArrayList = new HashMap();
		productList = new ArrayListOfProducts();


		hashMapOfProductArrayList.put("111", productList.getKiwi());
		hashMapOfProductArrayList.put("222", productList.getCoconut());
		hashMapOfProductArrayList.put("333", productList.getBeer());
		hashMapOfProductArrayList.put("444", productList.getChampange());
		hashMapOfProductArrayList.put("555", productList.getTomato());
		hashMapOfProductArrayList.put("666", productList.getPork());
		hashMapOfProductArrayList.put("777", productList.getLamb());
		hashMapOfProductArrayList.put("888", productList.getPumpkin());

	}

	/**
	 * This method returns the product list containing the product that matches the barcode
	 * @param barcode String
	 * @returnThe ArrayListOfProducts
	 */
	public ArrayList<Products> getProductList(String barcode){
		return hashMapOfProductArrayList.get(barcode);

	}



}




