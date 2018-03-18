import java.util.HashMap;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * This class contains the users and matches them with a password.
 * @author Ismaila Khan
 *
 */

public class LoginDetails{
	// HashMap of users and passwords 
	private HashMap<String,String> users = new HashMap<>();;
	
	
	/**
	 * No parameters needed
	 */
	public LoginDetails(){
		// add users and passwords
		users.put("MANAGER", "1965");
		users.put("ISMAILA", "2222");
		users.put("ANDREW", "3333");
		users.put("PETER", "4444");
	}
	
	/**
	 * This method gets a username and searches that the password entered matches the actual password
	 * @param user String
	 * @return String
	 */
	public String getPassword(String user){
		String password = users.get(user);
		return password;
	}
	
	public Set<String> getKeys(){
		return users.keySet();
	}
	
	
}
