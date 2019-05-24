package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.GameEnvironment;
import main.Item;

/**
 * The window that allows the player to view their inventory. The player can
 * view the details of the items.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class InventoryWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Creates the window application.
	 * 
	 * @param incomingGame A GameEnvironment containing all the contents of the
	 *                     game.
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
	 * Initializes the contents of the frame. This includes a list of inventory, a
	 * panel displaying the details of the selected item, a display of the coins
	 * available, and a button to return to the outpost.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("SPACE EXPLORERS");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("Ship Inventory");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 30));
		lblTitle.setBounds(0, 0, 795, 60);
		frame.getContentPane().add(lblTitle);

		ArrayList<Item> inventoryItems = new ArrayList<Item>();
		inventoryItems.addAll(game.getCrew().getFoodItems());
		inventoryItems.addAll(game.getCrew().getMedicalItems());
		ArrayList<Item> uniqueInventoryItems = new ArrayList<Item>(new TreeSet<Item>(inventoryItems));
		Map<Item, Integer> itemFrequency = new HashMap<Item, Integer>();
		for (Item item : uniqueInventoryItems) {
			itemFrequency.put(item, Collections.frequency(inventoryItems, item));
		}

		JList listInventory = new JList(uniqueInventoryItems.toArray());
		listInventory.setSelectedIndex(0);
		listInventory.setBackground(UIManager.getColor("Menu.background"));
		listInventory.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(10, 10, 10, 10)));
		listInventory.setFont(new Font("Tahoma", Font.PLAIN, 16));

		listInventory.setBounds(50, 127, 314, 348);
		frame.getContentPane().add(listInventory);

		JPanel panelItemInfo = new JPanel();
		panelItemInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelItemInfo.setBounds(396, 127, 344, 280);
		frame.getContentPane().add(panelItemInfo);
		panelItemInfo.setLayout(null);

		JLabel lblAmountText = new JLabel("Amount:");
		lblAmountText.setBounds(12, 89, 112, 22);
		panelItemInfo.add(lblAmountText);
		lblAmountText.setFont(new Font("Dialog", Font.BOLD, 16));

		JLabel lblItemValue = new JLabel();
		if (uniqueInventoryItems.size() != 0) {
			lblItemValue.setText(((Item) listInventory.getModel().getElementAt(0)).getName());
		}
		lblItemValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblItemValue.setBounds(155, 54, 189, 22);
		panelItemInfo.add(lblItemValue);

		JLabel lblNameText = new JLabel("Name:");
		lblNameText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNameText.setBounds(12, 54, 112, 22);
		panelItemInfo.add(lblNameText);

		JLabel lblAmoutValue = new JLabel();
		if (uniqueInventoryItems.size() != 0) {
			lblAmoutValue.setText(Integer.toString(itemFrequency.get((Item) listInventory.getModel().getElementAt(0))));
		}
		lblAmoutValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblAmoutValue.setBounds(155, 89, 189, 22);
		panelItemInfo.add(lblAmoutValue);

		JTextArea textAreaDescription = new JTextArea();
		textAreaDescription.setBackground(UIManager.getColor("Menu.background"));
		textAreaDescription.setEditable(false);
		textAreaDescription.setWrapStyleWord(true);
		textAreaDescription.setLineWrap(true);
		if (uniqueInventoryItems.size() != 0) {
			textAreaDescription.setText(((Item) listInventory.getModel().getElementAt(0)).getDescription());
		}
		textAreaDescription.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaDescription.setBounds(12, 149, 309, 118);
		panelItemInfo.add(textAreaDescription);

		JLabel lblPanelItemInfoTitle = new JLabel("About this item");
		lblPanelItemInfoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelItemInfoTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPanelItemInfoTitle.setBounds(0, 0, 344, 50);
		panelItemInfo.add(lblPanelItemInfoTitle);

		JLabel lblDescriptionText = new JLabel("Description:");
		lblDescriptionText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDescriptionText.setBounds(12, 123, 112, 22);
		panelItemInfo.add(lblDescriptionText);

		JButton btnBackToOutpost = new JButton("Back to Outpost");
		btnBackToOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchOutpostWindow();
			}
		});
		btnBackToOutpost.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnBackToOutpost.setBounds(542, 525, 203, 27);
		frame.getContentPane().add(btnBackToOutpost);

		JLabel lblCoinsAvailable = new JLabel("Coins Available:");
		lblCoinsAvailable.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCoinsAvailable.setBounds(396, 427, 176, 27);
		frame.getContentPane().add(lblCoinsAvailable);

		JLabel lblCoinsValue = new JLabel(Integer.toString(game.getCrew().getMoney()));
		lblCoinsValue.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCoinsValue.setBounds(576, 427, 148, 27);
		frame.getContentPane().add(lblCoinsValue);

		JLabel lblItemsText = new JLabel("Items:");
		lblItemsText.setFont(new Font("Dialog", Font.BOLD, 18));
		lblItemsText.setBounds(50, 91, 286, 27);
		frame.getContentPane().add(lblItemsText);

		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(50, 62, 695, 2);
		frame.getContentPane().add(separatorTop);

		JSeparator separatorBottom = new JSeparator();
		separatorBottom.setBounds(50, 503, 695, 2);
		frame.getContentPane().add(separatorBottom);

		listInventory.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Item currentItem = (Item) listInventory.getSelectedValue();
				lblItemValue.setText(currentItem.getName());
				lblAmoutValue.setText(Integer.toString(itemFrequency.get(currentItem)));
				textAreaDescription.setText(currentItem.getDescription());
			}
		});
	}

}
