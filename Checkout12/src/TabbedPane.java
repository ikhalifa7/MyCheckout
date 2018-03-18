import java.awt.SystemColor;

import javax.swing.*;


/**
 * Instances of this class are used to make all the TabbedPanes of the system. 
 * This class is important because it makes maintenance easy.
 * E.g if the programmer wants to edit the background of all the TabbedPanes, it can be done here and all the buttons will be edited.
 * Instead of doing one button at a time.
 * @author Ismaila Khan
 */


public class TabbedPane extends JTabbedPane{
	private JTabbedPane T;
	
	/**
	 * No parameters needed
	 */
	public TabbedPane()
	{
		// pass in value to super class
		super(JTabbedPane.TOP);
		// set background
		setBackground(SystemColor.WHITE);
		// set foreground
		setForeground(SystemColor.BLACK);
	}

}
