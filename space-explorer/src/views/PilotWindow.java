package views;

import main.CrewMember;
import main.GameEnvironment;
import main.Planet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

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

		// Create a DefaultListModel and add all the planets to it.
		DefaultListModel<Planet> planets = new DefaultListModel();
		for (Planet planet : game.getPlanets()) {
			planets.addElement(planet);
		}

		JButton btnPilot = new JButton("PILOT");

		btnPilot.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnPilot.setEnabled(false);
		btnPilot.setBounds(41, 503, 122, 25);
		frame.getContentPane().add(btnPilot);

		JComboBox cBoxPilot = new JComboBox(game.getCrew().getCrewMembers().toArray());
		cBoxPilot.setBounds(400, 437, 200, 25);
		frame.getContentPane().add(cBoxPilot);

		JPanel panel = new JPanel();
		panel.setBounds(41, 44, 325, 446);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JList listPlanets = new JList(planets);
		listPlanets.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if ((Planet) listPlanets.getSelectedValue() == game.getCrew().getCurrentLocation()
						|| cBoxPilot.getSelectedItem() == game.getChosenCrewMember()
						|| !(((CrewMember) cBoxPilot.getSelectedItem()).isAvailable())) {
					btnPilot.setEnabled(false);
					btnPilot.setToolTipText(
							"The co-pilot must be different to main pilot, and the planet must be different to current pilot.");
				} else {
					coPilot = (CrewMember) cBoxPilot.getSelectedItem();
					btnPilot.setEnabled(true);
					btnPilot.setToolTipText(null);
				}
			}
		});
		// Action listener to check if the conditions meet for piloting to another
		// planet
		ActionListener pilotConditions = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((Planet) listPlanets.getSelectedValue() == game.getCrew().getCurrentLocation()
						|| cBoxPilot.getSelectedItem() == game.getChosenCrewMember()
						|| !(((CrewMember) cBoxPilot.getSelectedItem()).isAvailable())) {
					btnPilot.setEnabled(false);
					btnPilot.setToolTipText(
							"The co-pilot must be different to main pilot, and the planet must be different to current pilot.");
				} else {
					coPilot = (CrewMember) cBoxPilot.getSelectedItem();
					btnPilot.setEnabled(true);
					btnPilot.setToolTipText(null);
				}
			}
		};
		// The other pilot
		coPilot = (CrewMember) cBoxPilot.getSelectedItem();
		cBoxPilot.addActionListener(pilotConditions);
		// Action listener when player clicks the pilot button
		btnPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = mainPilot.pilot((Planet) listPlanets.getSelectedValue(), coPilot, game.getCrew());
				finishedWindow();
				game.launchMainWindow();
				if (!(message == null)) {
					JOptionPane.showMessageDialog(frame, message);
				}

			}
		});
		listPlanets.setBackground(SystemColor.menu);
		listPlanets.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listPlanets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listPlanets.setBounds(35, 43, 256, 367);
		panel.add(listPlanets);

		JLabel lblSelectPlanet = new JLabel("Select New Planet:");
		lblSelectPlanet.setBounds(35, 13, 197, 15);
		panel.add(lblSelectPlanet);

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

		// Main Pilot
		mainPilot = game.getChosenCrewMember();

		JLabel lblSelectCopilol = new JLabel("Select co-pilot:");
		lblSelectCopilol.setBounds(400, 409, 197, 15);
		frame.getContentPane().add(lblSelectCopilol);

		JLabel lblMainPilot = new JLabel("Main Pilot");
		lblMainPilot.setBounds(400, 380, 56, 16);
		frame.getContentPane().add(lblMainPilot);

		JLabel lblNewLabel = new JLabel(game.getChosenCrewMember().getName());
		lblNewLabel.setBounds(483, 381, 160, 15);
		frame.getContentPane().add(lblNewLabel);

	}
}
