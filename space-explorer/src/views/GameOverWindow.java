package views;

import java.awt.EventQueue;
import main.GameEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameOverWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public GameOverWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeGameOverWindow(this);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnExit.setBounds(647, 486, 114, 25);
		frame.getContentPane().add(btnExit);
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnPlayAgain.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnPlayAgain.setBounds(647, 523, 114, 25);
		frame.getContentPane().add(btnPlayAgain);
		
		JLabel lblGameOverMessage = new JLabel();
		lblGameOverMessage.setHorizontalAlignment(SwingConstants.CENTER);
		if (game.getShip().getPiecesFound() == game.getShip().getPiecesNeeded()) {
			lblGameOverMessage.setText("YOUR CREW HAVE FOUND ALL THE PIECES AND CAN RETURN HOME!");
		} else {
			lblGameOverMessage.setText("YOUR CREW HAVE FAILED TO FIND ALL THE PIECES.");
		}
		lblGameOverMessage.setFont(new Font("Dialog", Font.BOLD, 30));
		lblGameOverMessage.setBounds(12, 13, 749, 49);
		frame.getContentPane().add(lblGameOverMessage);
		
		JLabel lblScore = new JLabel();
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblScore.setText("SCORE:   " + game.calculateFinalScore());
		lblScore.setBounds(155, 235, 467, 49);
		frame.getContentPane().add(lblScore);
	}
}
