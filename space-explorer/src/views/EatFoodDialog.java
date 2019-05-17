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

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class EatFoodDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public EatFoodDialog(JFrame parent, String title, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, title, true);
		setBounds(100, 100, 350, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Have a Snack!");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(82, 13, 136, 18);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("Check what you have:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(35, 58, 256, 15);
		contentPanel.add(label_1);
		
		JComboBox comboBox = new JComboBox(game.getCrew().getFoodItems().toArray());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox.setBounds(35, 86, 256, 24);
		contentPanel.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 129, 257, 206);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("About this food");
		label_2.setBounds(78, 7, 95, 18);
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(178, 16, 0, 0);
		label_3.setFont(new Font("Dialog", Font.BOLD, 13));
		panel.add(label_3);
		
		JButton button = new JButton("Let's do something else!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 11));
		button.setBounds(160, 365, 160, 25);
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
		button_1.setBounds(12, 364, 90, 25);
		contentPanel.add(button_1);
	}
}
