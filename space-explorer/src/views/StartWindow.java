package views;

import main.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class StartWindow {

	private JFrame frame;
	private GameEnvironment game;
	

	/**
	 * Create the application.
	 */
	public StartWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeStartWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
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
		
		JLabel label = new JLabel("SPACE EXPLORERS");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 60));
		label.setBounds(0, 0, 795, 408);
		frame.getContentPane().add(label);
	}
}
