
import javax.swing.*;

/**
 * 
 * @author Ismaila Khan
 * Instances of this class are used to make all the smaller buttons of the system. E.g Cash buttons, Refresh buttons
 * This class is important because it makes maintenance easy.
 * E.g if the programmer wants to edit all the big buttons, it can be done here and all the buttons will be edited.
 * Instead of doing one button at a time.
 *
 */

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Ismaila Khan
 * Instances of this class are used to make all the bigger buttons of the system. E.g Cash buttons, Refresh buttons
 * This class is important because it makes maintenance easy.
 * E.g if the programmer wants to edit all the bigger buttons, it can be done here and all the buttons will be edited.
 * Instead of doing one button at a time.
 *
 */


public class BigButtons extends JButton{

	public BigButtons()
	{
		super();

		setFont(new Font("Myriad Pro", Font.BOLD, 20));// Set the font for the button labels
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {// make the button bigger when mouse is entered

				setSize(195, 93);
			}

			@Override
			public void mouseExited(MouseEvent e) {// make button smaller when mouse is exited
				setSize(193, 90);
			}
		});

	}

}



