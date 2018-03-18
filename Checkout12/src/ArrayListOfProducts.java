

import java.util.ArrayList;

/**
 * 
 * This class contains ArrayLists of all the products that are available for sale.
 * If stock control is to be needed, it can be done using this class.
 * @author Ismaila Khan
 */


public class ArrayListOfProducts {

	private ArrayList<Products> kiwi; //ArrayList of kiwi
	private ArrayList<Products> coconut; //ArrayList of coconut
	private ArrayList<Products> beer;  //ArrayList of beer
	private ArrayList<Products> champange;  //ArrayList of champange
	private ArrayList<Products> tomato;  //ArrayList of  tomato
	private ArrayList<Products> pumpkin; //ArrayList of pumpkin
	private ArrayList<Products> pork; //ArrayList of pork
	private ArrayList<Products> lamb;  //ArrayList of lamb
	
	
	
	/**
	 * Initializes the Product ArrayLists and puts one product on each ArrayList
	 * This is all that is needed as there is no stock control
	 */
	public ArrayListOfProducts() {
		
		// Initialize all the ArrayLists
		kiwi = new ArrayList<>();
		coconut = new ArrayList<>();
		beer = new ArrayList<>();
		champange = new ArrayList<>();
		tomato = new ArrayList<>();
		pumpkin = new ArrayList<>();
		pork = new ArrayList<>();
		lamb = new ArrayList<>();
		
		// The remaining lines of the constructor makes new Products and add them to their respective ArrayLists
		
		Products kiwi1 = new Products("Kiwi", "Juicy kiwi fruit", 0.99);
		kiwi.add(kiwi1);
		
		
		Products coconut1 = new Products ("Coconut", "Watery coconut fruit", 1.99);
		coconut.add(coconut1);
		
		
		Products beer1 = new Products ("Beer ", "UK brewed beer ", 2.99);
		beer.add(beer1);
		
		
		Products champange1 = new Products ("Champange ", "Tasty American champange ", 6.99);
		champange.add(champange1);
		
		Products tomato1 = new Products ("Tomato ", "Red and Juicy Tomato straight from the farms ", 0.99);
		tomato.add(tomato1);
		
		
		Products pumpkin1 = new Products ("Pumpkin ", "Perfect pumpkin for halloween  ", 2.25);
		pumpkin.add(pumpkin1);
		
		
		Products pork1 = new Products ("Pork ", "Red and fresh prork straight from the farm  ", 2.56);
		pork.add(pork1);
		
		
		Products lamb1 = new Products ("Lamb ", "Perfect lamb for barbeque  ", 2.56);
		lamb.add(lamb1);
		
		
	}
	
	
	/**
	 * Returns Kiwi ArrayList
	 * @return  ArrayList<Products>
	 */
	public ArrayList<Products> getKiwi(){
		return kiwi;
	}
	
	/**
	 * Returns Kiwi ArrayList
	 * @return  ArrayList<Products>
	 */
	public ArrayList<Products> getCoconut(){
		return coconut;
	}
	
	/**
	 * Returns Beer ArrayList
	 * @returnReturns ArrayList<Products>
	 */
	
	public ArrayList<Products> getBeer(){
		return beer;
	}
	
	/**
	 * Returns Champagne ArrayList
	 * @return Returns ArrayList<Products>
	 */
	
	public ArrayList<Products> getChampange(){
		return champange;
	}
	
	/**
	 * Returns Tomato ArrayList
	 * @return Returns ArrayList<Products>
	 */
	
	public ArrayList<Products> getTomato(){
		return tomato;
	}
	
	/**
	 * Returns Pumpkin ArrayList
	 * @return Returns ArrayList<Products>
	 */
	public ArrayList<Products> getPumpkin(){
		return pumpkin;
	}
	/**
	 * Returns Returns Pork ArrayList
	 * @return ArrayList<Products>
	 */
	public ArrayList<Products> getPork(){
		return pork;
	}
	
	/**
	 * Returns Returns Lamb ArrayList
	 * @return ArrayList<Products>
	 */
	public ArrayList<Products> getLamb(){
		return lamb;
	}
	

}
