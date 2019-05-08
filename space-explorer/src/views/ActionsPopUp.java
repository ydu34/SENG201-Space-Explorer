package views;

import main.GameEnvironment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ActionsPopUp {

	private JFrame frame;
	private GameEnvironment game;
	/**
	 * Create the application.
	 */
	public ActionsPopUp(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeActionsPopUp(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 325, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Actions");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(52, 31, 221, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Eat Food");
		btnNewButton.setBounds(49, 87, 221, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnApplyMedicalItem = new JButton("Apply Medical Item");
		btnApplyMedicalItem.setBounds(49, 143, 221, 25);
		frame.getContentPane().add(btnApplyMedicalItem);
		
		JButton btnRepairShipShields = new JButton("Repair ship shields");
		btnRepairShipShields.setBounds(49, 199, 221, 25);
		frame.getContentPane().add(btnRepairShipShields);
		
		JButton btnSearchPlanet = new JButton("Search planet ");
		btnSearchPlanet.setBounds(49, 255, 221, 25);
		frame.getContentPane().add(btnSearchPlanet);
		
		JButton btnPilotTheShip = new JButton("Pilot the ship");
		btnPilotTheShip.setBounds(49, 311, 221, 25);
		frame.getContentPane().add(btnPilotTheShip);
	}

}
