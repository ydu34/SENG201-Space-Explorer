package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.GameEnvironment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

public class RepairShipDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public RepairShipDialog(JFrame parent, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, true);
		setBounds(100, 100, 375, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(46, 46, 270, 240);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblShipNameValue = new JLabel(game.getCrew().getName());
				lblShipNameValue.setHorizontalAlignment(SwingConstants.CENTER);
				lblShipNameValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
				lblShipNameValue.setBounds(12, 26, 246, 47);
				panel.add(lblShipNameValue);
			}
			{
				JLabel lblShields = new JLabel("SHIP SHIELDS");
				lblShields.setHorizontalAlignment(SwingConstants.CENTER);
				lblShields.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblShields.setBounds(12, 99, 246, 47);
				panel.add(lblShields);
			}
			{
				JLabel lblShieldsValue = new JLabel(game.getCrew().getShip().getShieldLevel() + "/" + game.getCrew().getShip().getMaxShieldLevel());
				lblShieldsValue.setHorizontalAlignment(SwingConstants.CENTER);
				lblShieldsValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblShieldsValue.setBounds(12, 172, 246, 54);
				panel.add(lblShieldsValue);
			}
		}
		{
			JButton button = new JButton("REPAIR");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					String message = game.getChosenCrewMember().repair(game.getShip());
					JOptionPane.showMessageDialog(parent, message);
					parentWindow.finishedWindow();
					game.launchCrewMemberWindow();
				}
			});
			button.setFont(new Font("Dialog", Font.BOLD, 15));
			button.setBounds(41, 332, 117, 29);
			contentPanel.add(button);
		}
		{
			JButton btnReturn = new JButton("Return");
			btnReturn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					JDialog actions = new ActionsDialog(parent, "Space Explorers", game, parentWindow);
					actions.setVisible(true);
				}
			});
			btnReturn.setFont(new Font("Dialog", Font.BOLD, 15));
			btnReturn.setBounds(199, 332, 117, 29);
			contentPanel.add(btnReturn);
		}
	}

}
