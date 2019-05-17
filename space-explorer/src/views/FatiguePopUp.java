package views;

import main.GameEnvironment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class FatiguePopUp {

	private JFrame frmSpaceExplorers;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public FatiguePopUp(GameEnvironent incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorers.setVisible(true);
	}
	
	public void closeWindow() {
		frmSpaceExplorers.dispose();
	}
	
	public void finishedWindow() {
		game.closeFatiguePopUp(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorers = new JFrame();
		frmSpaceExplorers.setTitle("SPACE EXPLORERS");
		frmSpaceExplorers.setBounds(100, 100, 325, 400);
		frmSpaceExplorers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorers.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 58, 229, 207);
		frmSpaceExplorers.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFatigueRestoreInfo = new JLabel("Fatigue restore info");
		lblFatigueRestoreInfo.setBounds(12, 12, 205, 30);
		panel.add(lblFatigueRestoreInfo);
		
		JButton btnSleep = new JButton("SLEEP");
		btnSleep.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnSleep.setBounds(12, 321, 90, 25);
		frmSpaceExplorers.getContentPane().add(btnSleep);
		
		JButton button_1 = new JButton("Let's do something else!");
		button_1.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 11));
		button_1.setBounds(137, 323, 160, 25);
		frmSpaceExplorers.getContentPane().add(button_1);
	}
}
