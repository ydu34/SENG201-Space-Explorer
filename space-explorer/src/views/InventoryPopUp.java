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
		frmSpaceExplorers.setBounds(100, 100, 800, 600);
		frmSpaceExplorers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorers.getContentPane().setLayout(null);
		
		JLabel lblYourInventory = new JLabel("Ship Inventory");
		lblYourInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourInventory.setFont(new Font("Dialog", Font.BOLD, 25));
		lblYourInventory.setBounds(10, 24, 760, 39);
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
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		list.setBounds(44, 127, 286, 348);
		frmSpaceExplorers.getContentPane().add(list);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(384, 91, 340, 310);
		frmSpaceExplorers.getContentPane().add(panel);
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
		
		JButton btnBackToOutpost = new JButton("Back to Outpost");
		btnBackToOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchOutpostWindow();
			}
		});
		btnBackToOutpost.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBackToOutpost.setBounds(563, 494, 160, 27);
		frmSpaceExplorers.getContentPane().add(btnBackToOutpost);
		
		JLabel label = new JLabel("Coins Available:");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(384, 427, 148, 27);
		frmSpaceExplorers.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(Integer.toString(game.getCrew().getMoney()));
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		label_1.setBounds(542, 427, 182, 27);
		frmSpaceExplorers.getContentPane().add(label_1);
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setFont(new Font("Dialog", Font.BOLD, 18));
		lblItems.setBounds(44, 91, 286, 27);
		frmSpaceExplorers.getContentPane().add(lblItems);
		
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
