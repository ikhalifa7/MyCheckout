import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import com.jgoodies.forms.factories.Borders.EmptyBorder;

/**
 * This class is a JDialog that is set "modal" lets the user log in to the
 * system. The user cannot access the system unless they enter the right login
 * details.
 * 
 * @author Ismaila Khan.
 */

public class CheckoutLoginScreen extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new NoBorderPanels();
	private JPasswordField passwordField;
	private JTextField userfield = new TextField();
	private JLabel statusLabel = new Labels("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CheckoutLoginScreen dialog = new CheckoutLoginScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setUndecorated(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog. No Parameters needed.
	 */
	public CheckoutLoginScreen() {
		setUndecorated(true);

		setModal(true);
		setBounds(100, 100, 341, 233);
		getContentPane().setLayout(new BorderLayout());
		// contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		BigButtons nbuttons = new BigButtons();
		nbuttons.setIcon(new ImageIcon(CheckoutLoginScreen.class
				.getResource("/browseIcons/ok.png")));
		nbuttons.setText("");
		nbuttons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// get username from textfield and remove all the spaces from it
				String user = userfield.getText().trim();
				@SuppressWarnings("deprecation")
				// get password from textfield and remove all the spaces from it
				String pass = passwordField.getText().trim();

				// makes a control class
				ControlClass control = new ControlClass();

				// verifies the login details
				String password = control.verify(user);

				// if login details are correct, let the user use the system by
				// disposing the login screen
				if (pass.equals(password)) {

					dispose();

				}

				else { // Else tell user the login details are incorrect
					statusLabel.setText("INVALID USERNAME OR PASSWORD");

				}

			}
		});
		nbuttons.setBounds(84, 137, 193, 90);
		contentPanel.add(nbuttons);

		passwordField = new PasswordField(105, 65);
		passwordField.setBounds(105, 65, 165, 29);
		passwordField.setBackground(Color.YELLOW);
		contentPanel.add(passwordField);

		JLabel label = new Labels("PASSWORD");
		label.setForeground(Color.YELLOW);
		label.setBounds(6, 58, 70, 42);
		contentPanel.add(label);

		userfield.setColumns(10);
		userfield.setBounds(105, 13, 165, 29);
		contentPanel.add(userfield);

		JLabel label_1 = new Labels("USERNAME");
		label_1.setForeground(Color.YELLOW);
		label_1.setBounds(6, 6, 70, 42);
		contentPanel.add(label_1);

		statusLabel.setBounds(26, 106, 329, 29);
		contentPanel.add(statusLabel);
	}

	/**
	 * This method lets allows the username text field to be assigned a value by
	 * store manager and this cannot be edited. Hence the cashier only needs to
	 * enter the password.
	 * 
	 * @param username
	 *            String
	 */
	public void setUser(String username) {

		userfield.setText(username);
		userfield.setEditable(false);

	}
}
