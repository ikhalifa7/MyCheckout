import java.awt.Color;

import javax.swing.JTextField;

/**
 * Instances of this class are used to make all the text fields of the system. 
 * This class is important because it makes maintenance easy.
 * E.g if the programmer wants to change the background color of all the text fields, it can be done here and all the buttons will be edited.
 * Instead of doing one button at a time.
 * @author Ismaila Khan
 */
public class TextField extends JTextField{
	
	public TextField()
	{
		super();
		
		// set background to yellow
		setBackground(Color.YELLOW);
		
		
	}

}
