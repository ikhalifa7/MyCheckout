
import java.util.ArrayList;


/**
 * This class generates random tips for the cashier after a new checkout is created.
 * @author Ismaila Khan
 */
import java.util.Random;

public class TipOfTheDay {
	
	// an ArrayList of Tips for the staff
	private ArrayList<String> tips;
    
	/**
	 * No parameters needed
	 */
	public TipOfTheDay() {
		
		tips = new ArrayList<>();
		
		// add few tips to the list
		tips.add("Be kind and courteous to all your customers");
		tips.add("Smile and Greet Every Customer");
		tips.add("Pay Attention To Identify Fake Bills");
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Generates a random tip and returns it
	 * @return String
	 */
	
	public String generateTip()
	{
		// the size of the generated indices
		int size = tips.size();
	
		Random N = new Random();
		
		// a random number within the range of the size of the arrayList
		int Number = N.nextInt(size);
	
		String generatedTip = tips.get(Number);
		// return the tip
		return generatedTip;
		
	}
	
}



