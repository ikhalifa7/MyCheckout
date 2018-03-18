
import javax.swing.JToggleButton;
import java.awt.SystemColor;



/**
 * Instances of this class are used to make all the ToggleButtons of the system. 
 * This class is important because it makes maintenance easy.
 * E.g if the programmer wants to edit all the ToggleButtons, it can be done here and all the buttons will be edited.
 * Instead of doing one button at a time.
 * @author Ismaila Khan
 */
public class Toggle extends JToggleButton{
	/**
	 * 
	 * @param x This is the x axis location of the button
	 * @param y This is the y axis location of the button
	 */
	public Toggle(int x, int y){
		super("");
		setBounds(x, y, 205, 120);
		
	}

}
