package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.GameEnvironment;
import main.MedicalItem;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplyMedicineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public ApplyMedicineDialog(JFrame parent, String title, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, title, true);
		setBounds(100, 100, 350, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JComboBox comboBox = new JComboBox(game.getCrew().getMedicalItems().toArray());
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			comboBox.setBounds(22, 106, 89, 24);
			contentPanel.add(comboBox);

			JButton button = new JButton("APPLY");
			if (game.getMedItems().size() == 0) {
				button.setEnabled(false);
			}
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					game.getChosenCrewMember().useMedicalItem((MedicalItem) comboBox.getSelectedItem(), game.getCrew());
					setVisible(false);
					dispose();
					parentWindow.finishedWindow();
					game.launchCrewMemberWindow();
				}
			});
			button.setBounds(22, 326, 90, 25);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("Let's do something else!");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});
			button.setFont(new Font("Dialog", Font.BOLD, 11));
			button.setBounds(144, 327, 160, 25);
			contentPanel.add(button);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(125, 105, 179, 170);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("About this medicine");
				label.setFont(new Font("Dialog", Font.BOLD, 12));
				panel.add(label);
			}
		}
		{
			JLabel label = new JLabel("Check what you have:");
			label.setFont(new Font("Dialog", Font.BOLD, 13));
			label.setBounds(22, 79, 144, 15);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Improve your health!");
			label.setFont(new Font("Dialog", Font.BOLD, 20));
			label.setBounds(67, 30, 211, 28);
			contentPanel.add(label);
		}
	}

}
