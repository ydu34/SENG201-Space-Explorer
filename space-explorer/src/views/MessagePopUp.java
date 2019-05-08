package views;

import main.GameEnvironment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MessagePopUp {

	private JFrame frame;
	private GameEnvironment game;
	
	/**
	 * Create the application.
	 */
	public MessagePopUp(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeMessagePopUp(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 325, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(197, 87, 114, 25);
		frame.getContentPane().add(btnClose);
		
		JLabel lblMessage = new JLabel("Message ");
		lblMessage.setBounds(12, 12, 299, 63);
		frame.getContentPane().add(lblMessage);
	}

}
