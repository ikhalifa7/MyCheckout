import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;


/**
 * Instances of this class are used to make all the panels of the system that have yellow border. 
 * This class is important because it makes maintenance easy.
 * E.g if the programmer wants to edit the border of all the panels, it can be done here and all the buttons will be edited.
 * Instead of doing one button at a time.
 * @author Ismaila Khan
 */
public class BorderPanels extends JPanel {
	
	
	/**
	 * No parameters required
	 */
	public BorderPanels(){
		super();
		// set background color to black
		setBackground(Color.BLACK);
		// set border to yellow
		setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.YELLOW));
		setLayout(null);
		
	}

}
