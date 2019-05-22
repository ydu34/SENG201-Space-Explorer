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
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JSeparator;

/**
 * Represents a dialog that allows crew members to repair the ship.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class RepairShipDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Creates the dialog. This includes a panel displaying the ship's shield level and the cost of repairing the ship to the crew member, and buttons to repair or return back to the actions window.
	 */
	public RepairShipDialog(JFrame parent, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, true);
		setResizable(false);
		setBounds(100, 100, 375, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(30, 63, 314, 277);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblShipNameValue = new JLabel(game.getShip().getName());
				lblShipNameValue.setHorizontalAlignment(SwingConstants.CENTER);
				lblShipNameValue.setFont(new Font("Dialog", Font.BOLD, 25));
				lblShipNameValue.setBounds(0, 0, 314, 47);
				panel.add(lblShipNameValue);
			}
			{
				JLabel lblShields = new JLabel("Shields:");
				lblShields.setHorizontalAlignment(SwingConstants.LEFT);
				lblShields.setFont(new Font("Dialog", Font.PLAIN, 16));
				lblShields.setBounds(12, 60, 100, 26);
				panel.add(lblShields);
			}
			{
				JLabel lblShieldsValue = new JLabel(game.getCrew().getShip().getShieldLevel() + "/" + game.getCrew().getShip().getMaxShieldLevel());
				lblShieldsValue.setHorizontalAlignment(SwingConstants.CENTER);
				lblShieldsValue.setFont(new Font("Dialog", Font.PLAIN, 16));
				lblShieldsValue.setBounds(123, 60, 184, 26);
				panel.add(lblShieldsValue);
			}
			{
				JTextArea txtrTheCrewMember = new JTextArea();
				txtrTheCrewMember.setWrapStyleWord(true);
				txtrTheCrewMember.setText("The crew member will repair the ship's shield. \r\n \r\nUses up 1 action. "
						+ "\nThe crew member's fatigue is increased by " + game.getChosenCrewMember().getRepairFatigueCost() +
						" and hunger is increased by " + game.getChosenCrewMember().getRepairHungerCost() + ".");
				txtrTheCrewMember.setLineWrap(true);
				txtrTheCrewMember.setFont(new Font("Monospaced", Font.PLAIN, 15));
				txtrTheCrewMember.setEditable(false);
				txtrTheCrewMember.setBackground(SystemColor.menu);
				txtrTheCrewMember.setBounds(12, 99, 290, 165);
				panel.add(txtrTheCrewMember);
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
					parentWindow.updateProfile(game.getChosenCrewMember());
				}
			});
			button.setFont(new Font("Dialog", Font.BOLD, 16));
			button.setBounds(30, 353, 110, 25);
			contentPanel.add(button);
		}
		{
			JButton btnReturn = new JButton("Do something else!");
			btnReturn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					JDialog actions = new ActionsDialog(parent, "Space Explorers", game, parentWindow);
					actions.setVisible(true);
				}
			});
			btnReturn.setFont(new Font("Dialog", Font.PLAIN, 16));
			btnReturn.setBounds(144, 353, 200, 25);
			contentPanel.add(btnReturn);
		}
		{
			JLabel lblRepairTheShip = new JLabel("Repair the ship!");
			lblRepairTheShip.setHorizontalAlignment(SwingConstants.CENTER);
			lblRepairTheShip.setFont(new Font("Dialog", Font.BOLD, 25));
			lblRepairTheShip.setBounds(0, 0, 369, 50);
			contentPanel.add(lblRepairTheShip);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(30, 52, 314, 2);
			contentPanel.add(separator);
		}
	}
}
