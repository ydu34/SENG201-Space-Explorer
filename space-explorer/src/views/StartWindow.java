package views;
import main.GameEnvironment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 774, 325);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO \nSPACE EXPLORER!");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel.setBounds(12, 12, 750, 301);
		panel.add(lblNewLabel);
		
		JButton StartButton = new JButton("Start");
		StartButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		StartButton.setBounds(289, 391, 220, 41);
		frame.getContentPane().add(StartButton);
		
		JButton QuitButton = new JButton("Quit");
		QuitButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		QuitButton.setBounds(289, 458, 220, 41);
		frame.getContentPane().add(QuitButton);
	}
}
