import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * Instances of this class are used to make all the labels of the system. 
 * This class is important because it makes maintenance easy.
 * E.g if the programmer wants to edit the background of all the labels, it can be done here and all the buttons will be edited.
 * Instead of doing one button at a time.
 * @author Ismaila Khan
 */
public class Labels extends JLabel {
	
	public Labels(String text){
		
		// pass in the text to the super class
		super(text);
		
		// set alignment
		setAlignmentX(Component.CENTER_ALIGNMENT);
		// set font
		setFont(new Font("Lucida Grande", Font.BOLD, 10));
		// set yellow background
		setForeground(Color.YELLOW);
	}

}
