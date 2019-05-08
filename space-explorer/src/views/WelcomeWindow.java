package views;

import java.awt.EventQueue;
import main.GameEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class WelcomeWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public WelcomeWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeSetupScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 40));
		lblWelcome.setBounds(213, 12, 358, 56);
		frame.getContentPane().add(lblWelcome);
		
		JButton btnHowToPlay = new JButton("How to play");
		btnHowToPlay.setFont(new Font("Dialog", Font.BOLD, 20));
		btnHowToPlay.setBounds(211, 123, 360, 56);
		frame.getContentPane().add(btnHowToPlay);
		
		JSlider slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(3);
		slider.setMaximum(10);
		slider.setBounds(41, 312, 702, 35);
		frame.getContentPane().add(slider);
		
		JLabel lblPieces = new JLabel("Pieces missing from the ship:");
		lblPieces.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblPieces.setBounds(273, 402, 239, 39);
		frame.getContentPane().add(lblPieces);
		
		JLabel lblPiecesNum = new JLabel("6\n");
		lblPiecesNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiecesNum.setFont(new Font("Dialog", Font.BOLD, 30));
		lblPiecesNum.setBounds(359, 453, 66, 56);
		frame.getContentPane().add(lblPiecesNum);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(672, 536, 114, 25);
		frame.getContentPane().add(btnAccept);
		
		JLabel lblSelectTheNumber = new JLabel("Select the number of days the game will last:");
		lblSelectTheNumber.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSelectTheNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTheNumber.setBounds(143, 237, 499, 39);
		frame.getContentPane().add(lblSelectTheNumber);
	}
}
