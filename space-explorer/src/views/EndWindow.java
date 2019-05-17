package views;

import java.awt.EventQueue;
import main.GameEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class EndWindow {

	private JFrame frmSpaceExplorers;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public EndWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorers.setVisible(true);
	}
	
	public void closeWindow() {
		frmSpaceExplorers.dispose();
	}
	
	public void finishedWindow() {
		game.closeEndWindow(this);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorers = new JFrame();
		frmSpaceExplorers.setTitle("SPACE EXPLORERS");
		frmSpaceExplorers.setBounds(100, 100, 800, 600);
		frmSpaceExplorers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorers.getContentPane().setLayout(null);
		
		JLabel lblScore = new JLabel("SCORE: ");
		lblScore.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 26));
		lblScore.setBounds(324, 171, 151, 49);
		frmSpaceExplorers.getContentPane().add(lblScore);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(367, 302, 66, 15);
		frmSpaceExplorers.getContentPane().add(lblMessage);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnExit.setBounds(647, 486, 114, 25);
		frmSpaceExplorers.getContentPane().add(btnExit);
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnPlayAgain.setBounds(647, 523, 114, 25);
		frmSpaceExplorers.getContentPane().add(btnPlayAgain);
	}
}
