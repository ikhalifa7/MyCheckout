import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

/**
 * This Class is a JDialog that pops up and lets the cashier enter the barcode
 * into it. It then uses that barcode to retrieve the matching product.
 * 
 * @author Ismaila Khan
 *
 */

public class BarcodeWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField txtCodeHere;
	private JLabel statusLabel = new Labels("");
	private String barcode;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BarcodeWindow dialog = new BarcodeWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog. No parameters required.
	 */
	public BarcodeWindow() {

		setAlwaysOnTop(true);
		setModal(true);
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		setTitle("BARCODE SCANNER");
		setBounds(100, 100, 425, 289);
		getContentPane().setLayout(null);

		txtCodeHere = new TextField();
		txtCodeHere.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		txtCodeHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodeHere.setText("");

			}
		});
		txtCodeHere.setText(" ENTER ITEM BARCODE HERE");
		txtCodeHere.setBounds(16, 21, 389, 76);
		getContentPane().add(txtCodeHere);
		txtCodeHere.setColumns(10);

		JButton btnBack = new BigButtons();
		btnBack.setIcon(new ImageIcon(BarcodeWindow.class
				.getResource("/browseIcons/ok.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				barcode = txtCodeHere.getText();
				txtCodeHere.setText("");
				dispose();
			}
		});
		btnBack.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		btnBack.setBounds(115, 160, 193, 90);
		getContentPane().add(btnBack);
		statusLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		
		
		statusLabel.setBounds(16, 108, 389, 40);
		getContentPane().add(statusLabel);
	}

	/**
	 * Returns the barcode that is entered by the user. This can then be used to
	 * retrieve the matching product.
	 * 
	 * @return String
	 */
	public String getBarcode() {
		return barcode;
	}
	
	/**
	 * This method lets sets the value of the status label in case the user inputs an invalid barcode
	 * @param invalid
	 */
	public void setStatusLabel(String invalid){
		statusLabel.setText(invalid);
	}
}
