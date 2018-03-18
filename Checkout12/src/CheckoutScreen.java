import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.border.MatteBorder;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;

import java.awt.Cursor;
import java.io.File;

import javax.swing.JTextArea;

import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;

/**
 * This class is a JFrame that lets the cashier "scan" items using barcode or
 * "browse" It also lets the cashier to perform refunds and voids, send messages
 * and log in/out
 * 
 * @author Ismaila Khan
 *
 */
public class CheckoutScreen extends JFrame {

	private JPanel contentPane;
	private double price; // price of scanned item
	private JList list = new JList();
	private DefaultListModel DML = new DefaultListModel();
	private JTextField totalField;
	private double total = 0; // total charged after scan
	private double total1 = 0; // money given to cashier
	private JTextField totalLabel;
	private JTextField changeTF;
	private String cashier; // name of cahier
	private double totalMoney = 0; // total sum of money earned by cashier
	// label that shows "tip of the day"
	private Labels tipLabel = new Labels("");
	// stores the message that is sent by cashier
	private String message;
	private JTextArea textArea = new JTextArea();
	// a list of all the products scanned
	private ArrayList<Products> scannedItems = new ArrayList<Products>();
	private ControlClass control = new ControlClass();
	private int ID = 100; // reciept ID
	private JLabel time = new Labels("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					CheckoutScreen frame = new CheckoutScreen("ISMAILA");
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

	/**
	 * Create the frame. No parameters required
	 */
	public CheckoutScreen(String name) {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		//
		cashier = name;
		clock();
		

		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		setFont(new Font("Goudy Old Style", Font.PLAIN, 12));
		setResizable(false);
		setBackground(new Color(255, 182, 193));

		setBounds(100, 100, 1236, 694);
		contentPane = new NoBorderPanels();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Seperators seperators = new Seperators();
		seperators.setOrientation(SwingConstants.VERTICAL);
		seperators.setBounds(797, 67, 12, 557);
		contentPane.add(seperators);

		final NoBorderPanels panel = new NoBorderPanels();
		panel.setBounds(325, 89, 455, 416);
		contentPane.add(panel);
		panel.setLayout(null);

		final TabbedPane tabbedPane_1 = new TabbedPane();
		tabbedPane_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tabbedPane_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0,
				0, 0)));
		tabbedPane_1.setBounds(6, 6, 439, 410);
		panel.add(tabbedPane_1);

		final NoBorderPanels panel3 = new NoBorderPanels();
		panel3.setToolTipText("Browse Items By Category");
		tabbedPane_1.addTab(
				"BROWSE",
				new ImageIcon(CheckoutScreen.class
						.getResource("/browseIcons/browse_1.png")), panel3,
				null);
		panel3.setLayout(null);

		TabbedPane tabbedPane2 = new TabbedPane();
		tabbedPane2.setBounds(6, 6, 425, 343);
		panel3.add(tabbedPane2);

		final BorderPanels panel_9 = new BorderPanels();
		panel_9.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.YELLOW));
		tabbedPane2.addTab(
				"FRUITS",
				new ImageIcon(CheckoutScreen.class
						.getResource("/browseIcons/bananas-icon.png")),
				panel_9, null);
		panel_9.setLayout(null);

		Toggle kiwiBTN = new Toggle(93, 21);
		kiwiBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/1Kiwi-icon.png")));
		kiwiBTN.setLocation(93, 22);

		kiwiBTN.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				putOnList("111");

			}
		});
		panel_9.add(kiwiBTN);

		Toggle coconutBTN = new Toggle(93, 143);
		coconutBTN.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				putOnList("222"); // put item on list

			}
		});
		coconutBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/1coconut-icon.png")));
		panel_9.add(coconutBTN);

		final BorderPanels panel_5 = new BorderPanels();
		tabbedPane2.addTab(
				"MEAT",
				new ImageIcon(CheckoutScreen.class
						.getResource("/browseIcons/cow-head-icon.png")),
				panel_5, null);
		panel_5.setLayout(null);

		Toggle porkBTN = new Toggle(93, 21);
		porkBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putOnList("666");
				double total1 = Double.parseDouble(totalField.getText());
				total = total1 + price;
				DecimalFormat df = new DecimalFormat("0.00");
				String formate = df.format(total);

				totalField.setText(String.valueOf(formate));
			}
		});
		porkBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/1ham-icon (1).png")));
		panel_5.add(porkBTN);

		Toggle lambBTN = new Toggle(93, 143);
		lambBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putOnList("777");
				double total1 = Double.parseDouble(totalField.getText());
				total = total1 + price;
				DecimalFormat df = new DecimalFormat("0.00");
				String formate = df.format(total);

				totalField.setText(String.valueOf(formate));
			}
		});
		lambBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/1cutlet-icon.png")));

		panel_5.add(lambBTN);

		final BorderPanels panel_6 = new BorderPanels();
		tabbedPane2.addTab(
				"VEGETABLE",
				new ImageIcon(CheckoutScreen.class
						.getResource("/browseIcons/Pumpkin-icon.png")),
				panel_6, null);
		panel_6.setLayout(null);

		Toggle tomatoBTN = new Toggle(93, 21);
		tomatoBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putOnList("555");
				double total1 = Double.parseDouble(totalField.getText());
				total = total1 + price;
				DecimalFormat df = new DecimalFormat("0.00");
				String formate = df.format(total);

				totalField.setText(String.valueOf(formate));
			}
		});
		tomatoBTN.setLocation(93, 21);
		tomatoBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/1Tomato-icon.png")));
		panel_6.add(tomatoBTN);

		Toggle pumpkinBTN = new Toggle(93, 143);
		pumpkinBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putOnList("888");
				double total1 = Double.parseDouble(totalField.getText());
				total = total1 + price;
				DecimalFormat df = new DecimalFormat("0.00");
				String formate = df.format(total);

				totalField.setText(String.valueOf(formate));
			}
		});
		pumpkinBTN.setLocation(93, 143);
		pumpkinBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/Pumpkin-icon (1).png")));
		panel_6.add(pumpkinBTN);

		final BorderPanels panel_7 = new BorderPanels();
		tabbedPane2.addTab(
				"ALCOHOL",
				new ImageIcon(CheckoutScreen.class
						.getResource("/browseIcons/Alcohol-Brandy-icon.png")),
				panel_7, null);
		panel_7.setLayout(null);

		Toggle beerBTN = new Toggle(93, 21);
		beerBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				putOnList("333");
				double total1 = Double.parseDouble(totalField.getText());
				total = total1 + price;
				DecimalFormat df = new DecimalFormat("0.00");
				String formate = df.format(total);

				totalField.setText(String.valueOf(formate));
			}
		});
		beerBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/Beer-icon.png")));
		panel_7.add(beerBTN);

		Toggle champangeBTN = new Toggle(93, 143);
		champangeBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putOnList("444");
				double total1 = Double.parseDouble(totalField.getText());
				total = total1 + price;
				DecimalFormat df = new DecimalFormat("0.00");
				String formate = df.format(total);

				totalField.setText(String.valueOf(formate));
			}
		});
		champangeBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/1Basket-icon.png")));
		panel_7.add(champangeBTN);

		final JPanel panel_3 = new NoBorderPanels();
		tabbedPane_1.addTab(
				"MESSAGE",
				new ImageIcon(CheckoutScreen.class
						.getResource("/icons4/group-add-icon.png")), panel_3,
				null);

		final BorderPanels smallPanels = new BorderPanels();
		smallPanels
				.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.YELLOW));
		smallPanels.setBounds(23, 5, 383, 282);
		panel_3.add(smallPanels);
		smallPanels.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 6, 371, 270);
		smallPanels.add(scrollPane_1);
		scrollPane_1.setViewportView(textArea);
		textArea.setBackground(Color.YELLOW);
		textArea.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		textArea.setForeground(Color.BLACK);
		textArea.setWrapStyleWord(true);
		textArea.setTabSize(5);
		textArea.setLineWrap(true);

		SmallButtons cashButtons_5 = new SmallButtons();
		cashButtons_5.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/browseIcons/ok.png")));
		cashButtons_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message = textArea.getText();
				textArea.setText("");
			}

		});
		cashButtons_5.setBounds(139, 292, 129, 70);
		panel_3.add(cashButtons_5);

		tipLabel.setBounds(210, 9, 727, 39);
		tipLabel.setFont(new Font("Adobe Fan Heiti Std", Font.PLAIN, 22));
		tipLabel.setForeground(Color.YELLOW);
		contentPane.add(tipLabel);
		String tipOfTheDay = control.getTip();
		tipLabel.setText("HELLO   " + cashier + " , " + "  please"
				+ tipOfTheDay);

		Seperators separator = new Seperators();
		separator.setBounds(-16, 67, 1247, 12);
		contentPane.add(separator);

		Seperators separator_2 = new Seperators();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(6, 48, 12, 634);
		contentPane.add(separator_2);

		final Seperators separator_4 = new Seperators();
		separator_4.setBounds(-16, 612, 1253, 12);
		contentPane.add(separator_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 89, 297, 322);
		contentPane.add(scrollPane);
		list.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED,
				null, null, null, null), "SCANNED ITEMS", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));

		list.setBackground(Color.YELLOW);
		list.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		list.setForeground(Color.BLACK);
		scrollPane.setViewportView(list);
		list.setVisibleRowCount(3);

		totalField = new TextField();
		totalField.setEditable(false);
		totalField.setText("0");
		totalField.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		totalField.setBounds(111, 423, 206, 63);
		contentPane.add(totalField);
		totalField.setColumns(10);

		totalLabel = new TextField();
		totalLabel.setEditable(false);
		totalLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		totalLabel.setText("  TOTAL");
		totalLabel.setBounds(16, 423, 106, 63);
		contentPane.add(totalLabel);
		totalLabel.setColumns(10);

		final JPanel panel_2 = new NoBorderPanels();
		panel_2.setBounds(811, 193, 397, 293);
		contentPane.add(panel_2);
		panel_2.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.YELLOW));

		SmallButtons quid5 = new SmallButtons();
		quid5.setBounds(5, 6, 129, 70);
		quid5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		quid5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction(5);
			}
		});
		panel_2.setLayout(null);
		quid5.setText("\u00A35");
		quid5.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/money-icon.png")));
		panel_2.add(quid5);

		SmallButtons quid20p = new SmallButtons();
		quid20p.setBounds(134, 6, 129, 70);
		quid20p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				transaction(0.20);
			}
		});
		quid20p.setText("20p");
		quid20p.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/browseIcons/coin-icon1.png")));
		panel_2.add(quid20p);

		SmallButtons quid1p = new SmallButtons();
		quid1p.setBounds(263, 6, 129, 70);
		quid1p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction(0.01);
			}
		});
		quid1p.setText("1p");
		quid1p.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/browseIcons/coin-icon1.png")));
		panel_2.add(quid1p);

		SmallButtons quid2p = new SmallButtons();
		quid2p.setBounds(263, 76, 129, 70);
		quid2p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction(0.02);

			}
		});

		SmallButtons quid50p = new SmallButtons();
		quid50p.setBounds(134, 76, 129, 70);
		quid50p.setText("50p");
		quid50p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction(0.50);
			}
		});

		SmallButtons quid10 = new SmallButtons();
		quid10.setBounds(5, 76, 129, 70);

		quid10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction(10);

			}
		});
		quid10.setText("\u00A310");
		quid10.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/money-icon.png")));
		panel_2.add(quid10);
		quid50p.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/browseIcons/coin-icon1.png")));
		panel_2.add(quid50p);
		quid2p.setText("2p");
		quid2p.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/browseIcons/coin-icon1.png")));
		panel_2.add(quid2p);

		SmallButtons quid5p = new SmallButtons();
		quid5p.setBounds(263, 216, 129, 70);
		quid5p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction(0.05);
			}
		});

		SmallButtons quid2 = new SmallButtons();
		quid2.setBounds(134, 216, 129, 70);
		quid2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction(2);
			}
		});

		SmallButtons quid50_1 = new SmallButtons();
		quid50_1.setBounds(5, 216, 129, 70);

		quid50_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction(50);

			}
		});

		SmallButtons quid1 = new SmallButtons();
		quid1.setBounds(134, 146, 129, 70);
		quid1.setText("\u00A31");
		quid1.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/browseIcons/coin-icon1.png")));
		quid1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction(1);
			}
		});

		SmallButtons quid20 = new SmallButtons();
		quid20.setBounds(5, 146, 129, 70);

		quid20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction(20);
			}
		});
		quid20.setText("\u00A320");
		quid20.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/money-icon.png")));
		panel_2.add(quid20);
		panel_2.add(quid1);

		SmallButtons quid10p = new SmallButtons();
		quid10p.setBounds(263, 146, 129, 70);

		quid10p.setText("10p");
		quid10p.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/browseIcons/coin-icon1.png")));
		panel_2.add(quid10p);
		quid50_1.setText("\u00A350");
		quid50_1.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/money-icon.png")));
		panel_2.add(quid50_1);

		quid2.setText(" \u00A32");
		quid2.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/browseIcons/coin-icon1.png")));
		panel_2.add(quid2);
		quid5p.setText("5p");
		quid5p.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/browseIcons/coin-icon1.png")));
		panel_2.add(quid5p);

		Seperators seperators_1 = new Seperators();
		seperators_1.setOrientation(SwingConstants.VERTICAL);
		seperators_1.setBounds(1218, 48, 12, 611);
		contentPane.add(seperators_1);

		changeTF = new TextField();
		changeTF.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		changeTF.setEditable(false);
		changeTF.setBounds(821, 91, 397, 75);
		contentPane.add(changeTF);
		changeTF.setColumns(10);

		final JPanel panel_1 = new NoBorderPanels();
		panel_1.setBounds(10, 516, 1206, 93);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		BigButtons scanBTN = new BigButtons();
		scanBTN.setBounds(-6, 0, 193, 90);
		panel_1.add(scanBTN);
		scanBTN.setToolTipText("SCAN ITEM BARCODE");
		scanBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// make new barcode window
				BarcodeWindow scaner = new BarcodeWindow();
				scaner.setVisible(true);
				scaner.setAlwaysOnTop(true);

				// get the barcode that was typed into the window
				String barcode = scaner.getBarcode();
				
				
				if (barcode.contains("[a-z,A-Z]")){
					
					scaner.setStatusLabel("Barcode must only be characters from 0-9");
				}
				// put the item on the list
				putOnList(barcode);
				
			}
		});
		scanBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/browseIcons/print-scan-icon.png")));

		BigButtons voidBTN = new BigButtons();

		voidBTN.setBounds(191, 0, 193, 90);
		panel_1.add(voidBTN);
		voidBTN.setToolTipText("REMOVE AN ITEM");
		voidBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/browseIcons/eraser.png")));
		voidBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get selected index
				int[] index = list.getSelectedIndices();

				// get selected value from JLIST
				String selectedItem = list.getSelectedValue().toString();

				// remove all other characters from the selected value and keep
				// the number (price)
				double itemPrice = Double.parseDouble(selectedItem.replaceAll(
						"[a-z,A-Z]", "").trim());

				// subtract the price from the total price of scanned items
				total = total - itemPrice;

				DecimalFormat df = new DecimalFormat("0.00");

				// format the total to 2dp
				String formate = df.format(total);

				// set the total field to the formated value
				totalField.setText(formate);

				// remove the selected element from the list
				for (int i = index.length - 1; i >= 0; i--) {
					DML.removeElementAt(index[i]);

				}

				boolean removed = false;

				// index of item to be retrieved
				int index1 = 0;

				// The item needs to be removed form the "scannedItems" so it
				// doesn't show on the
				while (removed == false) {
					// get the next item
					Products item = scannedItems.get(index1);

					// if the item contains the name of the removed item from
					// the list, remove the item from the "scannedItems" list
					if (selectedItem.contains(item.getName())) {
						scannedItems.remove(item);
						removed = true; // end the loop
					} else {
						index1++;
					}
				}

			}
		});

		BigButtons logoutBTN = new BigButtons();
		logoutBTN.setBounds(587, 0, 193, 90);
		panel_1.add(logoutBTN);
		logoutBTN.setToolTipText("LOGOUT OF SYSTEM");
		logoutBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons4/door-in-icon.png")));

		BigButtons refundBTN = new BigButtons();
		refundBTN.setIcon(new ImageIcon(CheckoutScreen.class
				.getResource("/icons3/receipt.png")));
		refundBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// get the receipt ID that was entered
				String ID = JOptionPane.showInputDialog(null,
						"ENTER RECIEPT ID");

				// get the transactions object from control class
				ArrayList<Products> items = control.getTransactions(ID);

				double refundTotal = 0;

				for (Products product : items) {

					// get the name and price of the items on the list
					String details = product.getName() + "   "
							+ product.getPrice();

					// add them to the default list model
					DML.addElement(details);

					// add the item price to the refund total
					refundTotal = refundTotal + product.getPrice();

					// subtract the refund money from checkout total
					totalMoney = totalMoney - product.getPrice();
				}

				list.setModel(DML);
				
				DecimalFormat df1 = new DecimalFormat("0.00");

				// tell cashier to give money back to customer
				JOptionPane.showMessageDialog(null, "GIVE CUSTOMER £"
						+ df1.format(refundTotal));
				refundTotal = 0;
				DML.removeAllElements();
			}
		});
		refundBTN.setToolTipText("REFUND A TRANSACTION");
		refundBTN.setBounds(389, 0, 193, 90);
		panel_1.add(refundBTN);

		JButton btnNewButton_2 = new BigButtons();
		btnNewButton_2.setToolTipText("CHANGE THE THEME OF THE TILL TO PINK");
		btnNewButton_2.setIcon(new ImageIcon(CheckoutScreen.class.getResource("/icons4/user-suit-icon(2).png")));
		btnNewButton_2.setBounds(899, 0, 193, 90);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel = new Labels("New label");
		lblNewLabel.setBounds(335, 635, 811, 24);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText("KIWI:1111      COCONUT: 2222      BEER: 333       CHAMPANGE: 444      TOMATO: 555      PORK: 666       LAMB: 777      PUMPKIN: 888");
		time.setFont(new Font("Dialog", Font.BOLD, 15));
		
		
		time.setBounds(994, 12, 226, 39);
		contentPane.add(time);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// this changes the theme of the checkout
				// by changing the color of all its components
				panel.setBackground(Color.PINK);
				panel3.setBackground(Color.PINK);
				panel_1.setBackground(Color.PINK);
				panel_2.setBackground(Color.PINK);
				textArea.setBackground(Color.pink);
				tabbedPane_1.setBackground(Color.PINK);
				list.setBackground(Color.PINK);
				list.setForeground(Color.BLACK);
				panel_1.setBackground(Color.PINK);
				textArea.setBackground(Color.PINK);
				separator_4.setForeground(Color.YELLOW);
				list.setBackground(Color.PINK);
				changeTF.setBackground(SystemColor.PINK);
				panel_2.setBackground(SystemColor.PINK);
				totalField.setBackground(SystemColor.PINK);
				totalLabel.setBackground(SystemColor.PINK);
				panel_9.setBackground(SystemColor.PINK);
				panel_5.setBackground(SystemColor.PINK);
				panel_6.setBackground(SystemColor.PINK);
				panel_7.setBackground(SystemColor.PINK);
				textArea.setBackground(Color.PINK);
				contentPane.setBackground(SystemColor.PINK);
				smallPanels.setBackground(Color.PINK);
				panel_3.setBackground(Color.PINK);

			}
		});
		logoutBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ask the cashier if the want to logout
				// get the response from the cashier

				final int response = JOptionPane.showConfirmDialog(null,
						"ARE YOU SURE YOU WANT TO LOG OUT OF SYSTEM?", "",
						JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);

				// the response was "OK", dispose the checkout
				if (response == JOptionPane.OK_OPTION) {
					dispose();
				} else {
					// else do nothing
				}

			}
		});
		
		CheckoutLoginScreen login = new CheckoutLoginScreen();
		login.setUser(name);
		login.setVisible(true);
		login.setAlwaysOnTop(true);

	}

	/**
	 * Thgis method takes in a barcode and displays the details of the product
	 * that matches that barcode. If any.
	 * 
	 * @param barcode
	 *            double
	 * 
	 */

	public void putOnList(String barcode) {

		// get the item and add it to the "scannedItems" list
		scannedItems.add(control.getItemObject(barcode));
		// gets the name and price of the item and this is displayed on the
		// JLIST further on
		String fullDetails = control.getFullDetails(barcode);
		// adds details to default list mode\
		
		
			
		DML.addElement(fullDetails);
		list.setModel(DML);
		total = Double.parseDouble(totalField.getText()) + control.getPrice();

		DecimalFormat df = new DecimalFormat("0.00");
		String formate = df.format(total);

		// update the total field to the new total
		totalField.setText(String.valueOf(formate));

		// reset the change text field as soon as an item is scanned.
		changeTF.setText("");
		
		
		

	}

	/**
	 * This method handles the payment process by passing in how much money is
	 * given to the customer Calculates how much more money the customer has to
	 * pay and how much change needs to be given to the customer
	 * 
	 * @param money
	 *            double
	 */

	public void transaction(double money) {

		DecimalFormat df = new DecimalFormat("0.00");
		// format the total to 2dp
		double formate = Double.parseDouble(df.format(total));

		// create a copy of the total charged for all items
		double totalCopy = total;

		// total1 is the money given by customer. add money give to cashier to
		// this total
		total1 = total1 + money;

		// if customer hasn't given enough money
		if (total > total1) {
			// calculate how much more money customer has to pay
			double moneyNeeded = totalCopy - total1;
			// format it to 2dp
			String deficit = df.format(moneyNeeded);
			// update the change text field
			changeTF.setText(deficit + "  MORE");
		}

		// if customer has given same amount as the bill or more
		if (total1 >= total) {

			// increase ID by one. This can be used to know how many customers
			// every cashier has served
			ID = ID + 1;

			// add the transaction to the list of transactions
			control.addTransaction(String.valueOf(ID), scannedItems);

			// make a new receipt
			Reciept reciept = new Reciept();
			DefaultListModel dlm = new DefaultListModel();

			// add the details of every item on the "scannedItems" list to the
			// JList
			for (Products item : scannedItems) {

				String details = item.getName() + "   " + item.getPrice();
				dlm.addElement(details);
			}

			DecimalFormat df1 = new DecimalFormat("0.00");

			// the total that is to be displayed on the receipt
			String totalForReciept = df.format(total);

			// set the total label on the receipt
			reciept.updateLabels("£" + String.valueOf(totalForReciept),
					String.valueOf(ID), cashier);

			// update the JList to add the scannedItems
			reciept.addToList(dlm);

			reciept.setVisible(true);

			// calculate change to be given to customer
			double change = total1 - totalCopy;

			// format the change to 2dp
			String stringChange = df.format(change);

			// set the change text field to display the change
			changeTF.setText(stringChange + "  CHANGE");
			
			// update the total money of the checkout
			totalMoney = total + totalMoney;

			// reset everything and ready to serve new customer
			DML.removeAllElements();
			totalField.setText("0");
			total = 0;
			total1 = 0;

			// add transaction money to safe
			control.addToSafe(total);

			

		}

	}

	/**
	 * This sets the message that is to be sent to the store manager
	 * 
	 * @param String
	 * 
	 */
	public void setMessage(String message1) {
		message = message1;
	}

	/**
	 * This method gets the value stored in the message variable
	 * 
	 * @return String
	 */

	public String getMessage() {
		return message;
	}

	/**
	 * This method returns the cashier name of the checkout
	 * 
	 * @return String
	 */

	public String getCashier() {
		return cashier;
	}

	/**
	 * This sets the name of the cashier that is to use the checkout
	 * 
	 * @param String
	 * 
	 */

	public void setCashier(String cashier) {
		this.cashier = cashier;
	}

	/**
	 * The total money for all transactions done by customer
	 * 
	 * @return double
	 */

	public double getTotalMoney() {

		totalMoney = totalMoney + total;
		return totalMoney;
	}
	
	
	/**
	 * This method shows time on the Checkout screen
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
