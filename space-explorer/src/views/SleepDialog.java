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
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

/**
 * Represents a dialog object that allows crew members to sleep.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class SleepDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Creates the dialog. This includes a panel displaying the details of sleep action, and buttons to sleep or return to the actions window.
	 */
	public SleepDialog(JFrame parent, String title, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 375, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		panel.setBounds(30, 63, 314, 277);
		contentPanel.add(panel);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Allow the crew member to take a quick nap and recover from fatigue.\n\n"
				+ "The crew member's fatigue would be reduced by 10. \n\n"
				+ "Fatigue can not go below 0.\n\n"
				+ "Sleeping uses up 1 action.");
		textArea.setBackground(SystemColor.menu);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(12, 13, 290, 251);
		panel.add(textArea);
		
		JButton button = new JButton("SLEEP");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				String message = game.getChosenCrewMember().sleep();
				JOptionPane.showMessageDialog(parent, message);
				parentWindow.updateProfile(game.getChosenCrewMember());
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		button.setBounds(30, 353, 110, 25);
		contentPanel.add(button);
		
		JButton btnDoSomethingElse = new JButton("Do something else!");
		btnDoSomethingElse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JDialog actions = new ActionsDialog(parent, "Space Explorers", game, parentWindow);
				actions.setVisible(true);
			}
		});
		btnDoSomethingElse.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnDoSomethingElse.setBounds(144, 353, 200, 25);
		contentPanel.add(btnDoSomethingElse);
		
		JLabel lblTakeANap = new JLabel("Take a Nap!");
		lblTakeANap.setHorizontalAlignment(SwingConstants.CENTER);
		lblTakeANap.setFont(new Font("Dialog", Font.BOLD, 30));
		lblTakeANap.setBounds(0, 0, 369, 50);
		contentPanel.add(lblTakeANap);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 52, 314, 2);
		contentPanel.add(separator);
	}
}
