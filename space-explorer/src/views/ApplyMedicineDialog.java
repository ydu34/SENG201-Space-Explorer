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
import main.MedicalItem;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class ApplyMedicineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ApplyMedicineDialog(JFrame parent, String title, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, title, true);
		setBounds(100, 100, 375, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// Create an array list and get the unique food items, so each item only appears
		// once in the list.
		ArrayList<MedicalItem> uniqueMedicalItems = new ArrayList<MedicalItem>(
				new TreeSet<MedicalItem>(game.getCrew().getMedicalItems()));

		// Use a hash map to store the item and the frequency of the item.
		Map<MedicalItem, Integer> itemFrequency = new HashMap<MedicalItem, Integer>();
		for (MedicalItem item : uniqueMedicalItems) {
			itemFrequency.put(item, Collections.frequency(game.getCrew().getMedicalItems(), item));
		}

		// Combo box for the medical items in the crew inventory
		JComboBox comboBox = new JComboBox(uniqueMedicalItems.toArray());
		comboBox.setBounds(26, 85, 298, 24);
		contentPanel.add(comboBox);
		JButton button = new JButton("Let's do something else!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JDialog actions = new ActionsDialog(parent, "Space Explorers", game, parentWindow);
				actions.setVisible(true);
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 11));
		button.setBounds(128, 344, 192, 25);
		contentPanel.add(button);

		// The current medical item that is selected by the player in the combo box
		MedicalItem currentItem = (MedicalItem) comboBox.getSelectedItem();

		JLabel lblImproveYourHealth = new JLabel("Improve your Health!");
		lblImproveYourHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblImproveYourHealth.setFont(new Font("Dialog", Font.BOLD, 20));
		lblImproveYourHealth.setBounds(26, 13, 298, 31);
		contentPanel.add(lblImproveYourHealth);

		JLabel lblMedicineAvailable = new JLabel("Medicine available in Inventory:");
		lblMedicineAvailable.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMedicineAvailable.setBounds(26, 57, 294, 24);
		contentPanel.add(lblMedicineAvailable);

		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = game.getChosenCrewMember().useMedicalItem((MedicalItem) comboBox.getSelectedItem(), game.getCrew());
				setVisible(false);
				dispose();
				JOptionPane.showMessageDialog(parent, message);
				parentWindow.finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		btnApply.setFont(new Font("Dialog", Font.BOLD, 15));
		btnApply.setBounds(26, 343, 90, 25);
		contentPanel.add(btnApply);
		if (game.getCrew().getMedicalItems().size() == 0) {
			btnApply.setEnabled(false);
		}

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(26, 122, 298, 208);
		contentPanel.add(panel);

		JTextArea textArea = new JTextArea((String) null);
		textArea.setBackground(SystemColor.menu);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBounds(12, 107, 273, 88);
		panel.add(textArea);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStock.setBounds(12, 55, 68, 23);
		panel.add(lblStock);

		JLabel label = new JLabel("About this item");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 17));
		label.setBounds(12, 0, 273, 22);
		panel.add(label);

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

		// Get the name and stock of the item only if there are items.
		if (uniqueMedicalItems.size() > 0) {
			lblNameValue.setText(currentItem.getName());
			lblStockValue.setText(Integer.toString(itemFrequency.get(currentItem)));
			textArea.setText(currentItem.getDescription());
		}
	}
}
