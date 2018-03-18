import java.awt.Color;

import javax.swing.JPasswordField;


/**
 * Instances of this class are used to make all the password fields of the system. 
 * This class is important because it makes maintenance easy.
 * E.g if the programmer wants to edit the background of all the password fields, it can be done here and all the buttons will be edited.
 * Instead of doing one button at a time.
 * @author Ismaila Khan
 */

public class PasswordField extends JPasswordField{
	/**
	 * 
	 * @param x The x axis of the password field
	 * @param y The y axis of the password field
	 */
	public PasswordField(int x, int y){
		super();
		// set background color
		setBackground(Color.YELLOW);
		// set bounds
		setBounds(x, y, 250, 29);
	}

}
