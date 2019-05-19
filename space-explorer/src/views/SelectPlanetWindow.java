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
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class SelectPlanetWindow {

	private JFrame frame;
	private GameEnvironment game;
	private CrewMember pilot1;
	private CrewMember pilot2;

	/**
	 * Create the application.
	 */
	public SelectPlanetWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		game.closeSelectPlanetWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Getting the chosen pilots 
		pilot1 = game.getChosenCrewMember();
		pilot2 = game.getOtherChosenCrewMember();

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

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(41, 92, 325, 398);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JList listPlanets = new JList(planets);
		listPlanets.setBorder(null);
		listPlanets.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if ((Planet) listPlanets.getSelectedValue() == game.getCrew().getCurrentLocation()) {
					btnPilot.setEnabled(false);
					btnPilot.setToolTipText(
							"The planet must be different to current planet.");
				} else {
					btnPilot.setEnabled(true);
					btnPilot.setToolTipText(null);
				}
			}
		});
		// Action listener to check if the conditions meet for piloting to another
		// planet
		// Action listener when player clicks the pilot button
		btnPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = pilot1.pilot((Planet) listPlanets.getSelectedValue(), pilot2, game.getCrew());
				finishedWindow();
				game.launchMainWindow();
				if (!(message == null)) {
					JOptionPane.showMessageDialog(frame, message);
				}

			}
		});
		listPlanets.setBackground(SystemColor.menu);
		listPlanets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listPlanets.setBounds(34, 58, 256, 327);
		panel.add(listPlanets);

		JLabel lblSelectPlanet = new JLabel("Select Planet:");
		lblSelectPlanet.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelectPlanet.setBounds(34, 13, 279, 32);
		panel.add(lblSelectPlanet);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 53, 301, 2);
		panel.add(separator);

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(410, 311, 325, 180);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Planet Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 301, 37);
		panel_1.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(12, 53, 83, 27);
		panel_1.add(lblName);
		
		JLabel lblEnginePieceAvailable = new JLabel("Engine piece detected:");
		lblEnginePieceAvailable.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnginePieceAvailable.setBounds(12, 93, 186, 27);
		panel_1.add(lblEnginePieceAvailable);
		
		JLabel lblNameValue = new JLabel();
		lblNameValue.setBounds(107, 53, 206, 27);
		panel_1.add(lblNameValue);
		
		JLabel lblNewLabel_1 = new JLabel("Explore a New World!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(41, 13, 702, 64);
		frame.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(38, 77, 697, 2);
		frame.getContentPane().add(separator_1);

	}
}
