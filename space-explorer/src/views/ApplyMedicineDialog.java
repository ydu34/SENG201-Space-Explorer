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

import main.GameEnvironment;
import main.MedicalItem;

/**
 * The dialog that allows the player to select a medical item to apply on the
 * selected crew member.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class ApplyMedicineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Creates the apply medicine dialog. This dialog includes a combo box for
	 * players to select a medical item, and a text area to show the selected
	 * medical item details.
	 * 
	 * @param parent       A JFrame that launches this dialog.
	 * @param game         A GameEnvironment object containing all the contents of
	 *                     the game.
	 * @param parentWindow A CrewMemberWindow that launched this dialog.
	 */
	public ApplyMedicineDialog(JFrame parent, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, true);
		setResizable(false);
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
		JComboBox comboBoxItems = new JComboBox(uniqueMedicalItems.toArray());
		comboBoxItems.setFont(new Font("Dialog", Font.PLAIN, 16));

		comboBoxItems.setBounds(30, 95, 314, 24);
		contentPanel.add(comboBoxItems);
		JButton btnDoSomethingElse = new JButton("Do something else!");
		btnDoSomethingElse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JDialog actions = new ActionsDialog(parent, game, parentWindow);
				actions.setVisible(true);
			}
		});
		btnDoSomethingElse.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnDoSomethingElse.setBounds(144, 353, 200, 25);
		contentPanel.add(btnDoSomethingElse);

		// The current medical item that is selected by the player in the combo box
		MedicalItem currentItem = (MedicalItem) comboBoxItems.getSelectedItem();

		JLabel lblTitle = new JLabel("Improve your Health!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		lblTitle.setBounds(0, 0, 369, 50);
		contentPanel.add(lblTitle);

		JLabel lblMedicineAvailable = new JLabel("Medicine available in Inventory:");
		lblMedicineAvailable.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMedicineAvailable.setBounds(30, 63, 314, 24);
		contentPanel.add(lblMedicineAvailable);

		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String message = game.getChosenCrewMember()
						.useMedicalItem((MedicalItem) comboBoxItems.getSelectedItem(), game.getCrew());
				setVisible(false);
				dispose();
				JOptionPane.showMessageDialog(parent, message);
				parentWindow.updateProfile(game.getChosenCrewMember());
			}
		});
		btnApply.setFont(new Font("Dialog", Font.BOLD, 16));
		btnApply.setBounds(30, 353, 110, 25);
		contentPanel.add(btnApply);
		if (game.getCrew().getMedicalItems().size() == 0) {
			btnApply.setEnabled(false);
		}

		JPanel panelItemDescription = new JPanel();
		panelItemDescription.setLayout(null);
		panelItemDescription.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelItemDescription.setBounds(30, 132, 314, 208);
		contentPanel.add(panelItemDescription);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblStock.setBounds(12, 68, 68, 23);
		panelItemDescription.add(lblStock);

		JLabel label = new JLabel("About this item");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 17));
		label.setBounds(0, 0, 314, 35);
		panelItemDescription.add(label);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblName.setBounds(12, 40, 68, 22);
		panelItemDescription.add(lblName);

		JLabel lblStockValue = new JLabel();
		lblStockValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblStockValue.setBounds(79, 68, 227, 23);
		panelItemDescription.add(lblStockValue);

		JLabel lblNameValue = new JLabel();
		lblNameValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNameValue.setBounds(79, 40, 227, 22);
		panelItemDescription.add(lblNameValue);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblDescription.setBounds(12, 95, 136, 23);
		panelItemDescription.add(lblDescription);

		JTextArea textAreaDescription = new JTextArea((String) null);
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setBackground(UIManager.getColor("Menu.background"));
		textAreaDescription.setWrapStyleWord(true);
		textAreaDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textAreaDescription.setEditable(false);
		textAreaDescription.setBounds(12, 120, 294, 60);
		panelItemDescription.add(textAreaDescription);

		JLabel lblWarning = new JLabel("This uses up 1 action.");
		lblWarning.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWarning.setBounds(12, 180, 290, 22);
		panelItemDescription.add(lblWarning);

		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(30, 52, 314, 2);
		contentPanel.add(separatorTop);
		// Listener for the combo box when the player changes item

		comboBoxItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MedicalItem currentItem = (MedicalItem) comboBoxItems.getSelectedItem();
				lblNameValue.setText(currentItem.getName());
				lblStockValue.setText(Integer.toString(itemFrequency.get(currentItem)));
				textAreaDescription.setText(currentItem.getDescription());
			}
		});
		// Get the name and stock of the item only if there are items.
		if (uniqueMedicalItems.size() > 0) {
			lblNameValue.setText(currentItem.getName());
			lblStockValue.setText(Integer.toString(itemFrequency.get(currentItem)));
			textAreaDescription.setText(currentItem.getDescription());
		}
	}
}
