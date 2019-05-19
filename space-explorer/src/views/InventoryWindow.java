package views;

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
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;

public class InventoryWindow {

	private JFrame frame;
	private GameEnvironment game;
	

	/**
	 * Create the application.
	 */
	public InventoryWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeInventoryWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
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
		
		JList list = new JList(uniqueInventoryItems.toArray());
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		list.setBounds(50, 127, 286, 348);
		frame.getContentPane().add(list);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(400, 97, 340, 310);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(31, 101, 112, 35);
		panel.add(lblAmount);
		lblAmount.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblItemName = new JLabel();
		if (uniqueInventoryItems.size() != 0) {
			lblItemName.setText(((Item) list.getModel().getElementAt(0)).getName());
		}
		lblItemName.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblItemName.setBounds(155, 50, 151, 38);
		panel.add(lblItemName);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(31, 50, 112, 38);
		panel.add(lblName);
		
		JLabel lblItemAmount = new JLabel();
		if (uniqueInventoryItems.size() != 0) {
			lblItemAmount.setText(Integer.toString(itemFrequency.get((Item) list.getModel().getElementAt(0))));
		}
		lblItemAmount.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblItemAmount.setBounds(155, 101, 151, 35);
		panel.add(lblItemAmount);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		if (uniqueInventoryItems.size() != 0) {
			textArea.setText(((Item) list.getModel().getElementAt(0)).getDescription());
		}
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(31, 149, 275, 135);
		panel.add(textArea);
		
		JLabel label_2 = new JLabel("About this item");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBounds(0, 0, 340, 50);
		panel.add(label_2);
		
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
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Item currentItem = (Item) list.getSelectedValue();
				lblItemName.setText(currentItem.getName());
				lblItemAmount.setText(Integer.toString(itemFrequency.get(currentItem)));
				textArea.setText(currentItem.getDescription());
			}
		});
	}
	
}
