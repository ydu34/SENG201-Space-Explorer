package views;

import java.awt.Color;
import java.awt.EventQueue;
import main.GameEnvironment;
import main.Item;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import java.awt.SystemColor;

/**
 * Represents a window that allows players to view the details of each item in the inventory.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class InventoryWindow {

	private JFrame frame;
	private GameEnvironment game;
	
	/**
	 * Creates the window application.
	 * @param incomingGame	A GameEnvironment containing all the contents of the game.
	 */
	public InventoryWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * Calls the close window method in game environment.
	 */
	public void finishedWindow() {
		game.closeInventoryWindow(this);
	}

	/**
	 * Initializes the contents of the frame. This includes a list of inventory, a panel displaying the details of the selected item, a display of the coins available, and a button to return to the outpost.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("SPACE EXPLORERS");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYourInventory = new JLabel("Ship Inventory");
		lblYourInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourInventory.setFont(new Font("Dialog", Font.BOLD, 30));
		lblYourInventory.setBounds(0, 0, 795, 60);
		frame.getContentPane().add(lblYourInventory);
		
		ArrayList<Item> inventoryItems = new ArrayList<Item>();
		inventoryItems.addAll(game.getCrew().getFoodItems());
		inventoryItems.addAll(game.getCrew().getMedicalItems());
		ArrayList<Item> uniqueInventoryItems = new ArrayList<Item>(new TreeSet<Item>(inventoryItems));
		Map<Item, Integer> itemFrequency = new HashMap<Item, Integer>();
		for (Item item: uniqueInventoryItems) {
			itemFrequency.put(item, Collections.frequency(inventoryItems, item));
		}
		
		JList listInventory = new JList(uniqueInventoryItems.toArray());
		listInventory.setBackground(SystemColor.menu);
		listInventory.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(10, 10, 10, 10)));
		listInventory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		listInventory.setBounds(50, 127, 314, 348);
		frame.getContentPane().add(listInventory);
		
		JPanel panelItemInfo = new JPanel();
		panelItemInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelItemInfo.setBounds(396, 127, 344, 280);
		frame.getContentPane().add(panelItemInfo);
		panelItemInfo.setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(12, 89, 112, 22);
		panelItemInfo.add(lblAmount);
		lblAmount.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblItemName = new JLabel();
		if (uniqueInventoryItems.size() != 0) {
			lblItemName.setText(((Item) listInventory.getModel().getElementAt(0)).getName());
		}
		lblItemName.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblItemName.setBounds(155, 50, 151, 38);
		panelItemInfo.add(lblItemName);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(12, 54, 112, 22);
		panelItemInfo.add(lblName);
		
		JLabel lblItemAmount = new JLabel();
		if (uniqueInventoryItems.size() != 0) {
			lblItemAmount.setText(Integer.toString(itemFrequency.get((Item) listInventory.getModel().getElementAt(0))));
		}
		lblItemAmount.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblItemAmount.setBounds(155, 101, 151, 35);
		panelItemInfo.add(lblItemAmount);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.menu);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		if (uniqueInventoryItems.size() != 0) {
			textArea.setText(((Item) listInventory.getModel().getElementAt(0)).getDescription());
		}
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(12, 149, 309, 118);
		panelItemInfo.add(textArea);
		
		JLabel label_2 = new JLabel("About this item");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBounds(0, 0, 344, 50);
		panelItemInfo.add(label_2);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDescription.setBounds(12, 123, 112, 22);
		panelItemInfo.add(lblDescription);
		
		JButton btnBackToOutpost = new JButton("Back to Outpost");
		btnBackToOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchOutpostWindow();
			}
		});
		btnBackToOutpost.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBackToOutpost.setBounds(585, 525, 160, 27);
		frame.getContentPane().add(btnBackToOutpost);
		
		JLabel label = new JLabel("Coins Available:");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(384, 427, 148, 27);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(Integer.toString(game.getCrew().getMoney()));
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		label_1.setBounds(542, 427, 182, 27);
		frame.getContentPane().add(label_1);
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setFont(new Font("Dialog", Font.BOLD, 18));
		lblItems.setBounds(50, 91, 286, 27);
		frame.getContentPane().add(lblItems);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 62, 695, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 503, 695, 2);
		frame.getContentPane().add(separator_1);
		
		listInventory.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Item currentItem = (Item) listInventory.getSelectedValue();
				lblItemName.setText(currentItem.getName());
				lblItemAmount.setText(Integer.toString(itemFrequency.get(currentItem)));
				textArea.setText(currentItem.getDescription());
			}
		});
	}
	
}
