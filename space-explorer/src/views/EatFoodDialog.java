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
		label.setBounds(26, 13, 319, 18);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("Check what you have:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(26, 71, 294, 24);
		contentPanel.add(label_1);
		
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
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox.setBounds(26, 99, 294, 24);
		contentPanel.add(comboBox);
		
		JButton button = new JButton("Let's do something else!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 11));
		button.setBounds(128, 365, 192, 25);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("EAT");
		if (game.getCrew().getFoodItems().size() == 0) {
			button_1.setEnabled(false);
		}
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.getChosenCrewMember().eat((FoodItem) comboBox.getSelectedItem(), game.getCrew());
				setVisible(false);
				dispose();
				parentWindow.finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 15));
		button_1.setBounds(26, 364, 90, 25);
		contentPanel.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		panel.setBounds(26, 136, 298, 216);
		contentPanel.add(panel);
		
		JTextArea textArea = new JTextArea((String) null);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBounds(12, 99, 273, 107);
		panel.add(textArea);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStock.setBounds(12, 63, 68, 23);
		panel.add(lblStock);
		
		JLabel label_3 = new JLabel("About this item");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Dialog", Font.BOLD, 17));
		label_3.setBounds(12, 0, 273, 22);
		panel.add(label_3);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(12, 35, 68, 22);
		panel.add(lblName);
		
		JLabel lblStockValue = new JLabel();
		
		lblStockValue.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStockValue.setBounds(79, 63, 206, 23);
		panel.add(lblStockValue);
		
		JLabel lblNameValue = new JLabel();
		
		lblNameValue.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNameValue.setBounds(79, 35, 206, 22);
		panel.add(lblNameValue);
		
		// Get the name and stock of the item only if there are items. 
		if (uniqueFoodItems.size() > 0) {
			lblNameValue.setText(currentItem.getName());
			lblStockValue.setText(Integer.toString(itemFrequency.get(currentItem)));
		}
	}
}
