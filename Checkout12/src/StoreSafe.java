

/**
 * This is the store safe that stores all the money from all the cashiers in the store
 * @author Ismaila Khan
 *
 */
public class StoreSafe {
	
	private double account;
	
	/**
	 * No parameters needed
	 */
	
	public StoreSafe(){
		
	}
	
	/**
	 * This method puts money into the store safe
	 * @param money double
	 */
	public void putMoney(double money){
		account = money + account;
		
	}
	
	/**
	 * This money takes money from the store safe
	 * @param money double
	 */
	public void takeMoney(double money){
		account = account - money;
	}
	
	/**
	 * This method checks how much money is in the store safe
	 * @return double
	 */
	public double checkSafe(){
		return account;
	}
	
	/**
	 * This method sets the safe back to "0"
	 */
	public void clear(){
		account = 0;
	}
}
