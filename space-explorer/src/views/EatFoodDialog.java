package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.FoodItem;
import main.GameEnvironment;
import main.Item;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class EatFoodDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public EatFoodDialog(JFrame parent, String title, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, title, true);
		setBounds(100, 100, 375, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Have a Snack!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(26, 13, 294, 31);
		contentPanel.add(label);
		
		JLabel lblAvailableInInventory = new JLabel("Food available in Inventory:");
		lblAvailableInInventory.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAvailableInInventory.setBounds(26, 57, 294, 24);
		contentPanel.add(lblAvailableInInventory);
		
		// Create an array list and get the unique food items, so each item only appears once in the list.
		ArrayList<FoodItem> uniqueFoodItems = new ArrayList<FoodItem>(new TreeSet<FoodItem>(game.getCrew().getFoodItems()));
		
		// Use a hash map to store the item and the frequency of the item.
		Map<FoodItem, Integer> itemFrequency = new HashMap<FoodItem, Integer>();
		for (FoodItem item: uniqueFoodItems) {
			itemFrequency.put(item, Collections.frequency(game.getCrew().getFoodItems(), item));
		}
		JComboBox comboBox = new JComboBox(uniqueFoodItems.toArray());
		
		// The current food item that is selected by the player in the combo box
		FoodItem currentItem = (FoodItem) comboBox.getSelectedItem();
		
		comboBox.setBounds(26, 85, 298, 24);
		contentPanel.add(comboBox);
		
		JButton btnReturn = new JButton("Let's do something else!");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JDialog actions = new ActionsDialog(parent, "Space Explorers", game, parentWindow);
				actions.setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Dialog", Font.BOLD, 11));
		btnReturn.setBounds(128, 345, 192, 25);
		contentPanel.add(btnReturn);
		
		JButton btnEat = new JButton("EAT");
		if (game.getCrew().getFoodItems().size() == 0) {
			btnEat.setEnabled(false);
		}
		btnEat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = game.getChosenCrewMember().eat((FoodItem) comboBox.getSelectedItem(), game.getCrew());
				setVisible(false);
				dispose();
				JOptionPane.showMessageDialog(parent, message);
				parentWindow.finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		btnEat.setFont(new Font("Dialog", Font.BOLD, 15));
		btnEat.setBounds(26, 344, 90, 25);
		contentPanel.add(btnEat);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		panel.setBounds(26, 122, 298, 209);
		contentPanel.add(panel);
		
		JTextArea textArea = new JTextArea((String) null);
		textArea.setBackground(SystemColor.menu);
		
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBounds(12, 106, 273, 90);
		panel.add(textArea);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStock.setBounds(12, 55, 68, 23);
		panel.add(lblStock);
		
		JLabel label_3 = new JLabel("About this item");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Dialog", Font.BOLD, 17));
		label_3.setBounds(12, 0, 273, 22);
		panel.add(label_3);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(12, 27, 68, 22);
		panel.add(lblName);
		
		JLabel lblStockValue = new JLabel();
		
		lblStockValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStockValue.setBounds(79, 55, 206, 23);
		panel.add(lblStockValue);
		
		JLabel lblNameValue = new JLabel();
		
		lblNameValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNameValue.setBounds(79, 27, 206, 22);
		panel.add(lblNameValue);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescription.setBounds(12, 82, 136, 23);
		panel.add(lblDescription);
		// Listener for the combo box when the player changes item
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FoodItem currentItem = (FoodItem) comboBox.getSelectedItem();
				lblNameValue.setText(currentItem.getName());
				lblStockValue.setText(Integer.toString(itemFrequency.get(currentItem)));
				textArea.setText(currentItem.getDescription());
			}
		});
		// Get the name and stock of the item only if there are items. 
		if (uniqueFoodItems.size() > 0) {
			lblNameValue.setText(currentItem.getName());
			lblStockValue.setText(Integer.toString(itemFrequency.get(currentItem)));
			textArea.setText(currentItem.getDescription());
		}
	}
}
