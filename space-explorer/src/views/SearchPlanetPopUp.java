package views;

import main.GameEnvironment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class SearchPlanetPopUp {

	private JFrame frmSpaceExplorers;
	private GameEnvironment game;


	/**
	 * Create the application.
	 */
	public SearchPlanetPopUp(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorers.setVisible(true);
	}
	
	public void closeWindow() {
		frmSpaceExplorers.dispose();
	}
	
	public void finishedWindow() {
		game.closeSearchPlanetPopUp(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorers = new JFrame();
		frmSpaceExplorers.setTitle("SPACE EXPLORERS");
		frmSpaceExplorers.setBounds(100, 100, 325, 400);
		frmSpaceExplorers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorers.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(63, 26, 200, 200);
		frmSpaceExplorers.getContentPane().add(panel);
		
		JLabel lblPlanetHasTransporter = new JLabel("Planet has transporter info\n");
		lblPlanetHasTransporter.setBounds(0, 12, 205, 30);
		panel.add(lblPlanetHasTransporter);
		
		JButton btnSearch = new JButton("SEARCH PLANET");
		btnSearch.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnSearch.setBounds(63, 256, 209, 25);
		frmSpaceExplorers.getContentPane().add(btnSearch);
		
		JButton button_1 = new JButton("Let's do something else!");
		button_1.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 11));
		button_1.setBounds(151, 336, 160, 25);
		frmSpaceExplorers.getContentPane().add(button_1);
	}
}
