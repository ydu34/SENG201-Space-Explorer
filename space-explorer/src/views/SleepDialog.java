package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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

/**
 * The dialog that allows the player to allow the crew member to sleep.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class SleepDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Creates the dialog. This includes a panel displaying the details of sleep
	 * action, and buttons to sleep or return to the actions window.
	 * 
	 * @param parent       A JFrame that launches this dialog.
	 * @param game         A GameEnvironment object containing all the contents of
	 *                     the game.
	 * @param parentWindow A CrewMemberWindow that launched this dialog.
	 */
	public SleepDialog(JFrame parent, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 375, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panelSleepInfo = new JPanel();
		panelSleepInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSleepInfo.setLayout(null);
		panelSleepInfo.setBounds(30, 63, 314, 277);
		contentPanel.add(panelSleepInfo);

		JTextArea textArea = new JTextArea();
		textArea.setText("Allow the crew member to take a quick nap and recover from fatigue.\n\n"
				+ "The crew member's fatigue would be reduced by 30. \n\n" + "Fatigue can not go below 0.\n\n"
				+ "Sleeping uses up 1 action.");
		textArea.setBackground(UIManager.getColor("Menu.background"));
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(12, 13, 290, 251);
		panelSleepInfo.add(textArea);

		JButton buttonSleep = new JButton("SLEEP");
		buttonSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				String message = game.getChosenCrewMember().sleep();
				JOptionPane.showMessageDialog(parent, message);
				parentWindow.updateProfile(game.getChosenCrewMember());
			}
		});
		buttonSleep.setFont(new Font("Dialog", Font.BOLD, 16));
		buttonSleep.setBounds(30, 353, 110, 25);
		contentPanel.add(buttonSleep);

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

		JLabel lblTakeANap = new JLabel("Take a Nap!");
		lblTakeANap.setHorizontalAlignment(SwingConstants.CENTER);
		lblTakeANap.setFont(new Font("Dialog", Font.BOLD, 30));
		lblTakeANap.setBounds(0, 0, 369, 50);
		contentPanel.add(lblTakeANap);

		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(30, 52, 314, 2);
		contentPanel.add(separatorTop);
	}
}
