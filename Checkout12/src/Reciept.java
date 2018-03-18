import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import java.awt.Window.Type;

import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JScrollPane;

/**
 * This class is a JDialogue that pops up after every transaction. It shows the
 * list of all items bought, the name of the cashier the total paid and the
 * transaction ID.
 * 
 * @author Ismaila Khan
 *
 */
public class Reciept extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3027043674347030957L;
	private JPanel contentPanel = new NoBorderPanels();
	private JList scannedItemsList = new JList();
	private JLabel IDLabel = new Labels("");
	private JLabel totalLabel = new Labels("");
	private JLabel lblTotal = new Labels("TOTAL");
	private JScrollPane scrollPane = new JScrollPane();
	private final Labels lblsCashier = new Labels("TOTAL");
	private final Labels cashierLabel = new Labels("");
	private final Labels time = new Labels("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reciept dialog = new Reciept();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reciept() {
		
		setResizable(false);
		setType(Type.POPUP);
		setBounds(100, 100, 239, 542);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		totalLabel.setBounds(135, 451, 99, 16);
		contentPanel.add(totalLabel);

		IDLabel.setBounds(135, 426, 99, 16);
		contentPanel.add(IDLabel);

		JPanel panel = new NoBorderPanels();
		panel.setBounds(6, 6, 227, 414);
		contentPanel.add(panel);

		JList list_1 = new JList();
		panel.add(list_1);
		scrollPane.setBounds(6, 6, 215, 402);

		panel.add(scrollPane);
		scrollPane.setViewportView(scannedItemsList);

		scannedItemsList.setBackground(Color.YELLOW);

		JLabel lblNewLabel = new Labels("Transaction ID");
		lblNewLabel.setText("TRANS ID");
		lblNewLabel.setBounds(6, 423, 99, 16);
		contentPanel.add(lblNewLabel);
		lblTotal.setText("TOTAL PAID");
		lblTotal.setBounds(6, 451, 99, 16);

		contentPanel.add(lblTotal);
		lblsCashier.setText("CASHIER");
		lblsCashier.setBounds(6, 473, 99, 16);

		contentPanel.add(lblsCashier);
		cashierLabel.setBounds(135, 473, 99, 16);

		contentPanel.add(cashierLabel);
		time.setText("");
		time.setBounds(6, 495, 217, 16);
		
		contentPanel.add(time);
	}

	/**
	 * This method sets the values of the list on the reciept
	 * 
	 * @param item
	 *            DefaultListModel
	 */
	public void addToList(DefaultListModel item) {
		scannedItemsList.setModel(item);
	}

	/**
	 * This method sets the values of the labels on the reciept i.e the total
	 * label, the cashier label and the ID label
	 * 
	 * @param total
	 *            String
	 * @param ID
	 *            String
	 * @param cashier
	 *            String
	 */
	public void updateLabels(String total, String ID, String cashier) {

		totalLabel.setText(total);
		IDLabel.setText(ID);
		cashierLabel.setText(cashier);
		clock();
	}
	
	/**
	 * This method shows the time at which the customer made the payment to the cashier
	 */
	public void clock(){
		
		
					Calendar cal = new GregorianCalendar();
					
					int day = cal.get(Calendar.DAY_OF_MONTH);
					int month = cal.get(Calendar.MONTH);
					int year = cal.get(Calendar.YEAR);
					
					int second = cal.get(Calendar.SECOND);
					int minute = cal.get(Calendar.MINUTE);
					int hour = cal.get(Calendar.HOUR);
					
					time.setText("Time "+ hour+": "+ minute+": "+second+ "  Date  "+month+"/"+day+"/"+year);
					
				
				
	}
}
