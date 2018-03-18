import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * This class is responsible for the creation of new checkouts and its
 * management
 * 
 * @author Ismaila Khan
 * 
 */
class CheckoutManager {

	private ArrayList<CheckoutScreen> checkoutList;
	private ArrayList<String> cashierList;
	private TipOfTheDay tips;
	private String cashier;
	private JList list = new JList();

	/**
	 * No parameters needed
	 */
	public CheckoutManager() {

		// Initialize the fields
		tips = new TipOfTheDay();
		checkoutList = new ArrayList<>();
		cashierList = new ArrayList<>();

	}

	/**
	 * Returns the list of all checkouts that were created
	 * 
	 * @return CheckoutScreen
	 */
	public ArrayList<CheckoutScreen> getList() {
		return checkoutList;
	}

	/**
	 * This method creates a new checkout and sets it visible
	 * 
	 * @param cashier
	 *            String
	 * @return CheckoutScreen
	 */
	public CheckoutScreen newCheckout(String cashier) {

		CheckoutScreen checkout = new CheckoutScreen(cashier); // make new
																// checkout
		checkout.setVisible(true); // make it visible
		cashierList.add(checkout.getCashier()); // add the cashier to cashier
												// list
		checkoutList.add(checkout); // add the checkout to the list of checkouts
		return checkout; // return the checkout
	}

}
