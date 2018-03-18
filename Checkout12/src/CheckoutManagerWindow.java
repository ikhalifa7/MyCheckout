import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;

import java.awt.Dialog.ModalExclusionType;

/**
 * This class is a JDialog that lets the store manager to create new checkouts,
 * show how much money every cashier is making and receive messages from
 * cashiers
 * 
 * @author Ismaila Khan
 *
 */
public class CheckoutManagerWindow extends JDialog {

	private final JPanel contentPanel = new NoBorderPanels();
	private CheckoutManager manager = new CheckoutManager();
	private DefaultListModel<String> DLM = new DefaultListModel();
	private JList list = new JList();
	private JLabel storeTotalLabel = new JLabel();
	private ControlClass control = new ControlClass();
	private DefaultListModel<String> DLM1 = new DefaultListModel();
	private double total; // store total
	private JList messageList = new JList();
	DefaultListModel dlm = new DefaultListModel();
	private JLabel time = new Labels("New label");

	/**
	 * Launch the application. No parameter required
	 */
	public static void main(String[] args) {
		try {
	     	CheckoutLoginScreen loginScreen = new CheckoutLoginScreen();
	     	loginScreen.setUser("MANAGER");
			loginScreen.setAlwaysOnTop(true);
			loginScreen.setVisible(true);
			CheckoutManagerWindow dialog = new CheckoutManagerWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog. No parameters needed
	 */
	public CheckoutManagerWindow() {
		
		clock();
		setTitle("CHECKOUT MANAGER");
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);

		setBounds(100, 100, 705, 624);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			contentPanel.setLayout(null);
		}
		{

		}

		TabbedPane tabbedPane = new TabbedPane();
		tabbedPane.setBounds(58, 44, 597, 484);
		contentPanel.add(tabbedPane);
		{
			JPanel panel = new BorderPanels();
			tabbedPane.addTab(
					"TILL MANAGEMENT",
					new ImageIcon(CheckoutManagerWindow.class
							.getResource("/icons4/user-suit-icon(2).png")),
					panel, null);
			panel.setLayout(null);
			{
				NoBorderPanels panel_1 = new NoBorderPanels();
				panel_1.setBounds(89, 19, 398, 221);
				panel.add(panel_1);
				panel_1.setBackground(Color.YELLOW);
				panel_1.setBorder(new TitledBorder(new EtchedBorder(
						EtchedBorder.LOWERED, null, null), "Cashier Status",
						TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
				panel_1.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(6, 18, 384, 196);
				panel_1.add(scrollPane);
				scrollPane.setViewportView(list);
				list.setFont(new Font("Lucida Grande", Font.BOLD, 15));
				list.setBackground(Color.YELLOW);
			}
			{
				storeTotalLabel.setForeground(Color.YELLOW);
				storeTotalLabel.setText("TOTAL");
				storeTotalLabel.setBackground(Color.YELLOW);
				storeTotalLabel.setFont(new Font("Lucida Grande", Font.PLAIN,
						30));
				storeTotalLabel.setBounds(99, 259, 378, 68);
				panel.add(storeTotalLabel);

				JPanel panel_2 = new NoBorderPanels();
				panel_2.setBounds(163, 325, 255, 69);
				panel.add(panel_2);
				panel_2.setLayout(null);
				SmallButtons btnNewTill = new SmallButtons();
				btnNewTill.setIcon(new ImageIcon(CheckoutManagerWindow.class
						.getResource("/browseIcons/Cashier-2-icon (1).png")));
				btnNewTill.setBounds(0, 0, 125, 69);
				panel_2.add(btnNewTill);
				btnNewTill.setToolTipText("ADD NEW TILL");
				JButton btnListAllTills = new SmallButtons();
				btnListAllTills
						.setIcon(new ImageIcon(
								CheckoutManagerWindow.class
										.getResource("/browseIcons/Button-Refresh-icon.png")));
				btnListAllTills.setBounds(125, 0, 125, 69);
				panel_2.add(btnListAllTills);
				btnListAllTills.setToolTipText("REFRESH CASHIER TOTAL");
				btnListAllTills.setText("");

				btnListAllTills.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// format a value to 2 dp
						DecimalFormat df = new DecimalFormat("0.00");

						DLM.removeAllElements(); // clear default list model
						list.removeAll(); // clear list
						total = 0; // reset total

						// get checkout list from control class
						ArrayList<CheckoutScreen> list1 = control
								.getCheckoutList(); //

						// get the totals of all the checkouts
						for (CheckoutScreen checkout : list1) {

							
								// format the total to 2dp
								String checkoutTotal = df.format(checkout
										.getTotalMoney());
								String cashierDetails = "Cashier Name:   "
										+ checkout.getCashier()
										+ "  Total Money:   £" + checkoutTotal;

								DLM.addElement(cashierDetails);

								// add the checkout total to the store total
								total = total
										+ Double.parseDouble(checkoutTotal);

								list.setModel(DLM);

							
						}
						// add the total to the store safe
						control.addToSafe(total);

						// update total label and format to 2dp
						storeTotalLabel.setText("TOTAL:  "
								+ String.valueOf(df.format(control.checkSafe())));

						// reset store safe
						control.resetSafe();

					}
				});

				btnNewTill.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String cashier = JOptionPane.showInputDialog(list,
								"ENTER CASHIER NAME"); // Get cashier name
						
						// get the set of all staff names
						Set<String> staff =  control.getStaffKeySet();
						
						
						// if the name entered does exist in the set of staff names
						if (staff.contains(cashier)) {
							control.openTill(cashier);
							// make new login screen
						}

						else {
							// else tell the user the cashier name does not exist
							JOptionPane.showMessageDialog(list, "THERE IS NO EMPLOYEE IN THIS STORE WITH THAT NAME");
						}

					}
				});

				JPanel panel_1 = new BorderPanels();
				tabbedPane
						.addTab("MESSAGES",
								new ImageIcon(
										CheckoutManagerWindow.class
												.getResource("/browseIcons/messages-icon.png")),
								panel_1, null);
				panel_1.setLayout(null);

				NoBorderPanels panels = new NoBorderPanels();
				panels.setLayout(null);
				panels.setBounds(230, 315, 152, 69);
				panel_1.add(panels);

				SmallButtons btnShowMessages = new SmallButtons();
				btnShowMessages
						.setIcon(new ImageIcon(
								CheckoutManagerWindow.class
										.getResource("/browseIcons/Button-Refresh-icon.png")));
				btnShowMessages.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						dlm.removeAllElements();
						// get the checkout list from control class
						ArrayList<CheckoutScreen> list1 = control
								.getCheckoutList();

						// get messages from every single checkout on the list
						for (CheckoutScreen checkout : list1) {

							// message from checkout
							String message = checkout.getMessage();

							if (!message.equals("")) {
								// message to be displayed on the Jlist
								String messageDisplay = checkout.getCashier()
										+ ":  " + message;

								dlm.addElement(messageDisplay);
								messageList.setModel(dlm);
							}
						}

					}
				});

				btnShowMessages.setToolTipText("Show Messages");
				btnShowMessages.setBounds(0, 0, 125, 69);
				panels.add(btnShowMessages);

				NoBorderPanels panels_1 = new NoBorderPanels();
				panels_1.setLayout(null);
				panels_1.setBorder(new TitledBorder(new EtchedBorder(
						EtchedBorder.LOWERED, null, null), "MESSSAGES",
						TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
				panels_1.setBackground(Color.YELLOW);
				panels_1.setBounds(97, 65, 398, 221);
				panel_1.add(panels_1);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(6, 18, 384, 196);
				panels_1.add(scrollPane);

				messageList.setBackground(Color.YELLOW);
				scrollPane.setViewportView(messageList);
			}
		}
		time.setFont(new Font("Dialog", Font.BOLD, 25));
		
		
		time.setBounds(152, -4, 389, 37);
		contentPanel.add(time);
		
		Labels lblStaffNamesAnd = new Labels("STAFF NAMES AND PASSWORDS:  MANAGER: 1965,  ISMAILA: 2222,  ANDREW: 3333,   PETER: 4444  ");
		lblStaffNamesAnd.setBounds(81, 539, 550, 35);
		contentPanel.add(lblStaffNamesAnd);
	}
	

	/**
	 * This method shows time on the checkout manager screen
	 */
	public void clock(){
		
		Thread clock = new Thread(){
			
			public void run(){
				try {
					// make this method run indefinately
					for(;;){
						
					Calendar cal = new GregorianCalendar();
					
					int day = cal.get(Calendar.DAY_OF_MONTH);
					int month = cal.get(Calendar.MONTH);
					int year = cal.get(Calendar.YEAR);
					
					int second = cal.get(Calendar.SECOND);
					int minute = cal.get(Calendar.MINUTE);
					int hour = cal.get(Calendar.HOUR);
					
					time.setText("Time "+ hour+": "+ minute+": "+second+ "  Date  "+month+"/"+day+"/"+year);
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}; clock.start(); // start the thread
		
		
		
		
		
	}
}
