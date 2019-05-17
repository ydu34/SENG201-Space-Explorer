package views;

import main.CrewMember;
import main.GameEnvironment;
import main.Planet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PilotWindow {

	private JFrame frame;
	private GameEnvironment game;
	private CrewMember mainPilot;
	private CrewMember coPilot;

	/**
	 * Create the application.
	 */
	public PilotWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closePilotWindow(this);
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
		panel.setLayout(null);
		panel.setBounds(205, 13, 400, 350);
		frame.getContentPane().add(panel);
		
		JLabel lblPictureOfPlanet = new JLabel("Picture of Planet");
		lblPictureOfPlanet.setBounds(0, 12, 205, 30);
		panel.add(lblPictureOfPlanet);
		
		JButton btnPilot = new JButton("PILOT");
		
		btnPilot.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnPilot.setEnabled(false);
		btnPilot.setBounds(41, 503, 122, 25);
		frame.getContentPane().add(btnPilot);
		
		JButton button_1 = new JButton("Let's do something else!");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		button_1.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 11));
		button_1.setBounds(535, 504, 200, 25);
		frame.getContentPane().add(button_1);
		
		JComboBox cBoxPlanet = new JComboBox(game.getPlanets().toArray());
		cBoxPlanet.setSelectedItem(game.getCrew().getCurrentLocation());
		cBoxPlanet.setBounds(194, 437, 200, 25);
		frame.getContentPane().add(cBoxPlanet);
		
		JComboBox cBoxPilot = new JComboBox(game.getCrew().getCrewMembers().toArray());
		cBoxPilot.setBounds(427, 437, 200, 25);
		frame.getContentPane().add(cBoxPilot);
		
		// Main Pilot
		mainPilot = game.getChosenCrewMember();
		// The other pilot 
		coPilot = (CrewMember) cBoxPilot.getSelectedItem();
		
		// Action listener to check if the conditions meet for piloting to another planet
		ActionListener pilotConditions = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cBoxPlanet.getSelectedItem() == game.getCrew().getCurrentLocation() || cBoxPilot.getSelectedItem() == game.getChosenCrewMember() || !(((CrewMember) cBoxPilot.getSelectedItem()).isAvailable())) {
					btnPilot.setEnabled(false);
					btnPilot.setToolTipText("The co-pilot must be different to main pilot, and the planet must be different to current pilot.");
				} else {
					coPilot = (CrewMember) cBoxPilot.getSelectedItem();
					btnPilot.setEnabled(true);
					btnPilot.setToolTipText(null);
				}
			}
		};
		cBoxPlanet.addActionListener(pilotConditions);
		cBoxPilot.addActionListener(pilotConditions);
		
		// Action listener when player clicks the pilot button
		btnPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = mainPilot.pilot((Planet) cBoxPlanet.getSelectedItem(), coPilot, game.getCrew());
				finishedWindow();
				game.launchMainWindow();
				if (!(message==null)) {
					JOptionPane.showMessageDialog(frame, message);
				}
				
			}
		});
		
		
		
		JLabel lblSelectPlanet = new JLabel("Select New Planet:");
		lblSelectPlanet.setBounds(194, 409, 197, 15);
		frame.getContentPane().add(lblSelectPlanet);
		
		JLabel lblSelectCopilol = new JLabel("Select co-pilot:");
		lblSelectCopilol.setBounds(438, 409, 197, 15);
		frame.getContentPane().add(lblSelectCopilol);
		
		JLabel lblMainPilot = new JLabel("Main Pilot");
		lblMainPilot.setBounds(215, 376, 56, 16);
		frame.getContentPane().add(lblMainPilot);
		
		JLabel lblNewLabel = new JLabel(game.getChosenCrewMember().getName());
		lblNewLabel.setBounds(294, 376, 311, 15);
		frame.getContentPane().add(lblNewLabel);
	}
}
