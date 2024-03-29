package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.GameEnvironment;

/**
 * The start window that allows the player to start or quit the game.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class StartWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Creates the window application.
	 * 
	 * @param incomingGame A GameEnvironment containing all the contents of the
	 *                     game.
	 */
	public StartWindow(GameEnvironment incomingGame) {
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
		game.closeStartWindow(this);
	}

	/**
	 * Initializes the contents of the frame. This includes a button to start the
	 * game and a button to quit the game.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("SPACE EXPLORERS");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnStart = new JButton("Start");
		btnStart.setBounds(302, 439, 190, 41);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnStart.setFont(new Font("SansSerif", Font.BOLD, 20));
		frame.getContentPane().add(btnStart);

		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(303, 493, 188, 41);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setFont(new Font("SansSerif", Font.BOLD, 20));
		frame.getContentPane().add(btnQuit);

		JLabel lblWindowTitle = new JLabel("SPACE EXPLORERS");
		lblWindowTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindowTitle.setFont(new Font("Dialog", Font.BOLD, 60));
		lblWindowTitle.setBounds(0, 0, 795, 408);
		frame.getContentPane().add(lblWindowTitle);
	}
}
