package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.GameEnvironment;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class MessageDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private GameEnvironment game;

	/**
	 * Create the dialog.
	 */
	public MessageDialog(JFrame parent, GameEnvironment game, String message, CrewMemberWindow parentWindow) {
		super(parent, true);
		setResizable(false);
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("menu"));
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane.setEditable(false);
		textPane.setText(message);
		textPane.setBounds(12, 13, 358, 92);
		contentPanel.add(textPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnContinue = new JButton("Continue");
				btnContinue.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
						parentWindow.finishedWindow();
						game.launchCrewMemberWindow();
					}
				});
				buttonPane.add(btnContinue);
			}
		}
	}
}
