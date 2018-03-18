import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.*;
import javax.swing.border.LineBorder;


/**
 * Instances of this class are used to make all the TabbedPanes of the system. 
 * This class is important because it makes maintenance easy.
 * E.g if the programmer wants to edit the background of all the TabbedPanes, it can be done here and all the buttons will be edited.
 * Instead of doing one button at a time.
 * @author Ismaila Khan
 */ 

public class NoBorderPanels extends JPanel {
	
	public NoBorderPanels()
	{
		setBackground(SystemColor.BLACK); // set background color to black
		setLayout(null);
	}

}
