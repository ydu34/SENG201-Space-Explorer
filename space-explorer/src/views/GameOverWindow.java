package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import main.GameEnvironment;

/**
 * The window that displays the final outcome of the game and the final score.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class GameOverWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 * 
	 * @param incomingGame A GameEnvironment containing all the contents of the
	 *                     game.
	 */
	public GameOverWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Calls the close window method in game environment.
	 */
	public void finishedWindow() {
		game.closeGameOverWindow(this);
	}

	/**
	 * Initialize the contents of the frame. This includes a message of the game
	 * situation, a score display, an exit button and a play again button.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("SPACE EXPLORERS");
		frame.setResizable(false);
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
			lblGameOverMessage.setText("VICTORY");
		} else {
			lblGameOverMessage.setText("GAME OVER");
		}
		lblGameOverMessage.setFont(new Font("Dialog", Font.BOLD, 40));
		lblGameOverMessage.setBounds(12, 30, 749, 104);
		frame.getContentPane().add(lblGameOverMessage);

		JLabel lblScore = new JLabel();
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblScore.setText("SCORE:   " + game.calculateFinalScore());
		lblScore.setBounds(156, 338, 467, 49);
		frame.getContentPane().add(lblScore);

		JTextArea textAreaGameOverReason = new JTextArea();
		textAreaGameOverReason.setEditable(false);
		textAreaGameOverReason.setBackground(UIManager.getColor("Menu.background"));
		textAreaGameOverReason.setFont(new Font("Monospaced", Font.PLAIN, 30));
		textAreaGameOverReason.setWrapStyleWord(true);
		textAreaGameOverReason.setLineWrap(true);
		textAreaGameOverReason.setText(game.gameOverMessage());
		textAreaGameOverReason.setBounds(145, 147, 493, 180);
		frame.getContentPane().add(textAreaGameOverReason);
	}
}
