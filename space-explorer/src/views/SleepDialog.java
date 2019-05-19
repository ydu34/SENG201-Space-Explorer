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

public class SleepDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
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
		panel.setBounds(35, 64, 290, 247);
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
		textArea.setBounds(12, 13, 261, 212);
		panel.add(textArea);
		
		JButton button = new JButton("SLEEP");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				String message = game.getChosenCrewMember().sleep();
				JOptionPane.showMessageDialog(parent, message);
				parentWindow.finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 15));
		button.setBounds(35, 345, 90, 25);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("Let's do something else!");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JDialog actions = new ActionsDialog(parent, "Space Explorers", game, parentWindow);
				actions.setVisible(true);
			}
		});
		button_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		button_1.setBounds(133, 346, 192, 25);
		contentPanel.add(button_1);
		
		JLabel lblTakeANap = new JLabel("Take a Nap!");
		lblTakeANap.setHorizontalAlignment(SwingConstants.CENTER);
		lblTakeANap.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTakeANap.setBounds(35, 23, 290, 28);
		contentPanel.add(lblTakeANap);
	}
}
