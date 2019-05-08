package views;

import main.GameEnvironment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class SearchPlanetPopUp {

	private JFrame frame;
	private GameEnvironment game;


	/**
	 * Create the application.
	 */
	public SearchPlanetPopUp(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeSearchPlanetPopUp(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 325, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(63, 26, 200, 200);
		frame.getContentPane().add(panel);
		
		JLabel lblPlanetHasTransporter = new JLabel("Planet has transporter info\n");
		lblPlanetHasTransporter.setBounds(0, 12, 205, 30);
		panel.add(lblPlanetHasTransporter);
		
		JButton btnSearch = new JButton("SEARCH PLANET");
		btnSearch.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnSearch.setBounds(63, 256, 209, 25);
		frame.getContentPane().add(btnSearch);
		
		JButton button_1 = new JButton("Let's do something else!");
		button_1.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 11));
		button_1.setBounds(151, 336, 160, 25);
		frame.getContentPane().add(button_1);
	}
}
