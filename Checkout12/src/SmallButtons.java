

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Ismaila Khan
 * Instances of this class are used to make all the smaller buttons of the system. E.g Cash buttons, Refresh buttons
 * This class is important because it makes maintenance easy.
 * E.g if the programmer wants to edit all the small buttons, it can be done here and all the buttons will be edited.
 * Instead of doing one button at a time.
 *
 */


	public class SmallButtons extends JButton{
		
		
		/**
		 * No parameters required
		 */
		public SmallButtons()
		{
			super(); 
			
			setFont(new Font("Myriad Pro", Font.BOLD, 15)); // Set the font for the button labels
			
			addMouseListener(new MouseAdapter() { // Add action listener to the button
				@Override
				public void mouseEntered(MouseEvent e) { // make the button bigger when mouse is entered
					setSize(133, 73);
				}

				@Override
				public void mouseExited(MouseEvent e) { // make button smaller when mouse is exited
					setSize(129, 70);
				}
			});
			
		}

	}



