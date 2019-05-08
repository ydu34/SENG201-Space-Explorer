package views;

import java.awt.EventQueue;
import main.GameEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;

public class ShieldRepairPopUp {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public ShieldRepairPopUp(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeShieldRepairPopUp(this);
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
		panel.setBounds(66, 31, 192, 143);
		frame.getContentPane().add(panel);
		
		JLabel lblShipShieldInfo = new JLabel("Ship shield info");
		panel.add(lblShipShieldInfo);
		
		JButton btnRepair = new JButton("REPAIR");
		btnRepair.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnRepair.setBounds(102, 223, 120, 25);
		frame.getContentPane().add(btnRepair);
		
		JButton btnBackToShip = new JButton("Back to ship");
		btnBackToShip.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 12));
		btnBackToShip.setBounds(182, 329, 110, 20);
		frame.getContentPane().add(btnBackToShip);
	}
}
