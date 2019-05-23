package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import main.FoodItem;
import main.GameEnvironment;

/**
 * The dialog that allows the player to select a food item to feed to the
 * selected crew member.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class EatFoodDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Creates the dialog. This includes a combo box to select a food item to
	 * consume, a panel displaying the details of selected food item, and a button
	 * to consume the selected food item.
	 * 
	 * @param parent       A JFrame that launches this dialog.
	 * @param game         A GameEnvironment object containing all the contents of
	 *                     the game.
	 * @param parentWindow A CrewMemberWindow that launched this dialog.
	 */
	public EatFoodDialog(JFrame parent, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, true);
		setResizable(false);
		setBounds(100, 100, 375, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel labelTitle = new JLabel("Have a Snack!");
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		labelTitle.setBounds(0, 0, 369, 50);
		contentPanel.add(labelTitle);

		JLabel lblAvailableInInventory = new JLabel("Food available in Inventory:");
		lblAvailableInInventory.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAvailableInInventory.setBounds(30, 63, 314, 24);
		contentPanel.add(lblAvailableInInventory);

		// Create an array list and get the unique food items, so each item only appears
		// once in the list.
		ArrayList<FoodItem> uniqueFoodItems = new ArrayList<FoodItem>(
				new TreeSet<FoodItem>(game.getCrew().getFoodItems()));

		// Use a hash map to store the item and the frequency of the item.
		Map<FoodItem, Integer> itemFrequency = new HashMap<FoodItem, Integer>();
		for (FoodItem item : uniqueFoodItems) {
			itemFrequency.put(item, Collections.frequency(game.getCrew().getFoodItems(), item));
		}
		JComboBox comboBoxItem = new JComboBox(uniqueFoodItems.toArray());
		comboBoxItem.setFont(new Font("Dialog", Font.PLAIN, 16));

		// The current food item that is selected by the player in the combo box
		FoodItem currentItem = (FoodItem) comboBoxItem.getSelectedItem();

		comboBoxItem.setBounds(30, 95, 314, 24);
		contentPanel.add(comboBoxItem);

		JButton btnReturn = new JButton("Do something else!");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JDialog actions = new ActionsDialog(parent, game, parentWindow);
				actions.setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnReturn.setBounds(144, 353, 200, 25);
		contentPanel.add(btnReturn);

		JButton btnEat = new JButton("EAT");
		if (game.getCrew().getFoodItems().size() == 0) {
			btnEat.setEnabled(false);
		}
		btnEat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = game.getChosenCrewMember().eat((FoodItem) comboBoxItem.getSelectedItem(), game.getCrew());
				setVisible(false);
				dispose();
				JOptionPane.showMessageDialog(parent, message);
				parentWindow.updateProfile(game.getChosenCrewMember());
			}
		});
		btnEat.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEat.setBounds(30, 353, 110, 25);
		contentPanel.add(btnEat);

		JPanel panelItem = new JPanel();
		panelItem.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelItem.setLayout(null);
		panelItem.setBounds(30, 132, 314, 208);
		contentPanel.add(panelItem);

		JTextArea textArea = new JTextArea((String) null);
		textArea.setBackground(UIManager.getColor("Menu.background"));

		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBounds(12, 120, 294, 58);
		panelItem.add(textArea);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblStock.setBounds(12, 68, 68, 23);
		panelItem.add(lblStock);

		JLabel label_3 = new JLabel("About this item");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Dialog", Font.BOLD, 17));
		label_3.setBounds(0, 0, 314, 35);
		panelItem.add(label_3);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblName.setBounds(12, 40, 68, 22);
		panelItem.add(lblName);

		JLabel lblStockValue = new JLabel();

		lblStockValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblStockValue.setBounds(79, 68, 227, 23);
		panelItem.add(lblStockValue);

		JLabel lblNameValue = new JLabel();

		lblNameValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNameValue.setBounds(79, 40, 227, 22);
		panelItem.add(lblNameValue);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblDescription.setBounds(12, 95, 136, 23);
		panelItem.add(lblDescription);

		JLabel label_1 = new JLabel("This uses up 1 action.");
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		label_1.setBounds(12, 180, 290, 22);
		panelItem.add(label_1);

		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(30, 52, 314, 2);
		contentPanel.add(separatorTop);
		// Listener for the combo box when the player changes item
		comboBoxItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FoodItem currentItem = (FoodItem) comboBoxItem.getSelectedItem();
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
