package views;

import java.awt.EventQueue;
import main.GameEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
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
		game.closeMainWindow(this);
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
		lblDay.setBounds(533, 141, 126, 29);
		frame.getContentPane().add(lblDay);
		
		JLabel lblPiecesFound = new JLabel("Pieces found:");
		lblPiecesFound.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblPiecesFound.setBounds(533, 200, 140, 24);
		frame.getContentPane().add(lblPiecesFound);
		
		JButton btnOutpost = new JButton("Visit outpost");
		btnOutpost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
				game.launchOutpostWindow();
			}
		});
		btnOutpost.setBounds(35, 432, 220, 35);
		frame.getContentPane().add(btnOutpost);
		
		JButton btnCrew = new JButton("View Crew");
		btnCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		btnCrew.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnCrew.setBounds(279, 432, 220, 35);
		frame.getContentPane().add(btnCrew);
		
		JButton btnNextDay = new JButton("Next day");
		btnNextDay.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnNextDay.setBounds(527, 432, 220, 35);
		frame.getContentPane().add(btnNextDay);
		
		JLabel lblShip = new JLabel("Ship: \r\n");
		lblShip.setFont(new Font("Dialog", Font.BOLD, 18));
		lblShip.setBounds(79, 146, 109, 24);
		frame.getContentPane().add(lblShip);
		
		JLabel lblShieldLevel = new JLabel("Shield Level:");
		lblShieldLevel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblShieldLevel.setBounds(79, 204, 140, 33);
		frame.getContentPane().add(lblShieldLevel);
	}
}
