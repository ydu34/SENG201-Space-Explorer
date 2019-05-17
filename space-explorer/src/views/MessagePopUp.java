package views;

import main.GameEnvironment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MessagePopUp {

	private JFrame frmSpaceExplorers;
	private GameEnvironment game;
	
	/**
	 * Create the application.
	 */
	public MessagePopUp(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorers.setVisible(true);
	}
	
	public void closeWindow() {
		frmSpaceExplorers.dispose();
	}
	
	public void finishedWindow() {
		game.closeMessagePopUp(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorers = new JFrame();
		frmSpaceExplorers.setTitle("SPACE EXPLORERS");
		frmSpaceExplorers.setBounds(100, 100, 325, 150);
		frmSpaceExplorers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorers.getContentPane().setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(197, 87, 114, 25);
		frmSpaceExplorers.getContentPane().add(btnClose);
		
		JLabel lblMessage = new JLabel("Message ");
		lblMessage.setBounds(12, 12, 299, 63);
		frmSpaceExplorers.getContentPane().add(lblMessage);
	}

}
