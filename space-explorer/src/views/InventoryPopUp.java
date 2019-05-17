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

public class InventoryPopUp {

	private JFrame frmSpaceExplorers;
	private GameEnvironment game;
	

	/**
	 * Create the application.
	 */
	public InventoryPopUp(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorers.setVisible(true);
	}
	
	public void closeWindow() {
		frmSpaceExplorers.dispose();
	}
	
	public void finishedWindow() {
		game.closeInventoryPopUp(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorers = new JFrame();
		frmSpaceExplorers.setTitle("SPACE EXPLORERS");
		frmSpaceExplorers.setBounds(100, 100, 325, 400);
		frmSpaceExplorers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorers.getContentPane().setLayout(null);
		
		JLabel lblYourInventory = new JLabel("Your Inventory");
		lblYourInventory.setFont(new Font("Dialog", Font.BOLD, 16));
		lblYourInventory.setBounds(96, 24, 120, 21);
		frmSpaceExplorers.getContentPane().add(lblYourInventory);
		
		ArrayList<Item> inventoryItems = new ArrayList<Item>();
		inventoryItems.addAll(game.getCrew().getFoodItems());
		inventoryItems.addAll(game.getCrew().getMedicalItems());
		ArrayList<Item> uniqueInventoryItems = new ArrayList<Item>(new TreeSet<Item>(inventoryItems));
		Map<Item, Integer> itemFrequency = new HashMap<Item, Integer>();
		for (Item item: uniqueInventoryItems) {
			itemFrequency.put(item, Collections.frequency(inventoryItems, item));
		}
		
		JList list = new JList(uniqueInventoryItems.toArray());
		list.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		list.setBounds(10, 76, 105, 254);
		frmSpaceExplorers.getContentPane().add(list);
		
		JPanel panel = new JPanel();
		panel.setBounds(125, 76, 176, 174);
		frmSpaceExplorers.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(10, 50, 49, 16);
		panel.add(lblAmount);
		lblAmount.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblItemName = new JLabel();
		if (uniqueInventoryItems.size() != 0) {
			lblItemName.setText(((Item) list.getModel().getElementAt(0)).getName());
		}
		lblItemName.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblItemName.setBounds(50, 27, 112, 14);
		panel.add(lblItemName);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblName.setBounds(10, 26, 37, 16);
		panel.add(lblName);
		
		JLabel lblItemAmount = new JLabel();
		if (uniqueInventoryItems.size() != 0) {
			lblItemAmount.setText(Integer.toString(itemFrequency.get((Item) list.getModel().getElementAt(0))));
		}
		lblItemAmount.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblItemAmount.setBounds(71, 51, 91, 14);
		panel.add(lblItemAmount);
		
		JTextArea textArea = new JTextArea();
		if (uniqueInventoryItems.size() != 0) {
			textArea.setText(((Item) list.getModel().getElementAt(0)).getDescription());
		}
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 10));
		textArea.setBounds(10, 97, 152, 66);
		panel.add(textArea);
		
		JButton btnBackToOutpost = new JButton("Back to Outpost");
		btnBackToOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBackToOutpost.setFont(new Font("Dialog", Font.BOLD, 10));
		btnBackToOutpost.setBounds(181, 329, 120, 23);
		frmSpaceExplorers.getContentPane().add(btnBackToOutpost);
		
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
