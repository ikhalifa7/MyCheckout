import java.awt.Color;

import javax.swing.JSeparator;


/**
 * Instances of this class are used to make all the separators of the system. 
 * This class is important because it makes maintenance easy.
 * E.g if the programmer wants to edit all the separators, it can be done here and all the buttons will be edited.
 * Instead of doing one button at a time.
 * @author Ismaila Khan
 */

public class Seperators extends JSeparator{
	
	/**
	 * No parameters needed
	 */
	public Seperators(){
	
		// set the color of the separators to yellow
	setForeground(Color.YELLOW);
	
	
	}

}
