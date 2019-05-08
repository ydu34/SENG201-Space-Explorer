package views;

import java.awt.EventQueue;
import main.GameEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class MainWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public MainWindow(GameEnvironment incomingGame) {
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
		frame.getContentPane().setFont(new Font("L M Mono Prop Lt10", Font.PLAIN, 12));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCurrentPlanetPhoto = new JLabel("planet photo");
		lblCurrentPlanetPhoto.setBounds(308, 113, 109, 15);
		frame.getContentPane().add(lblCurrentPlanetPhoto);
		
		JLabel lblPlanetName = new JLabel("planet name");
		lblPlanetName.setBounds(308, 222, 109, 15);
		frame.getContentPane().add(lblPlanetName);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblDay.setBounds(533, 146, 66, 15);
		frame.getContentPane().add(lblDay);
		
		JLabel lblPiecesFound = new JLabel("Pieces found:");
		lblPiecesFound.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblPiecesFound.setBounds(533, 200, 132, 15);
		frame.getContentPane().add(lblPiecesFound);
		
		JButton btnShipStatus = new JButton("View ship status");
		btnShipStatus.setForeground(new Color(160, 82, 45));
		btnShipStatus.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnShipStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnShipStatus.setBounds(416, 367, 220, 35);
		frame.getContentPane().add(btnShipStatus);
		
		JButton btnOutpost = new JButton("Visit outpost");
		btnOutpost.setForeground(new Color(0, 100, 0));
		btnOutpost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOutpost.setBounds(137, 367, 220, 35);
		frame.getContentPane().add(btnOutpost);
		
		JButton btnActions = new JButton("Perform actions");
		btnActions.setForeground(new Color(178, 34, 34));
		btnActions.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnActions.setBounds(137, 432, 220, 35);
		frame.getContentPane().add(btnActions);
		
		JButton btnNextDay = new JButton("Next day");
		btnNextDay.setForeground(new Color(240, 128, 128));
		btnNextDay.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnNextDay.setBounds(416, 432, 220, 35);
		frame.getContentPane().add(btnNextDay);
	}
}
