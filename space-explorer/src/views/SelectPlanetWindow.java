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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

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
import javax.swing.UIManager;

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

		btnPilot.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPilot.setEnabled(false);
		btnPilot.setBounds(622, 514, 122, 25);
		frame.getContentPane().add(btnPilot);
		
		JPanel panelEnginePiece = new JPanel();
		panelEnginePiece.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEnginePiece.setBounds(419, 433, 325, 53);
		frame.getContentPane().add(panelEnginePiece);
		panelEnginePiece.setLayout(null);
		
		JLabel lblEnginePieceAvailable = new JLabel("Part detected:");
		lblEnginePieceAvailable.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnginePieceAvailable.setBounds(12, 13, 186, 22);
		panelEnginePiece.add(lblEnginePieceAvailable);
		
		JLabel lblPieceAvailableValue = new JLabel(game.getCrew().getCurrentLocation().planetPieceDetected());
		lblPieceAvailableValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		lblPieceAvailableValue.setBounds(210, 13, 103, 22);
		panelEnginePiece.add(lblPieceAvailableValue);
		
		JLabel lblPlanetImage = new JLabel();
		lblPlanetImage.setBounds(419, 87, 325, 285);
		
		JPanel panelSelectPlanet = new JPanel();
		panelSelectPlanet.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSelectPlanet.setBounds(50, 87, 325, 398);
		frame.getContentPane().add(panelSelectPlanet);
		panelSelectPlanet.setLayout(null);
		JList listPlanets = new JList(planets);
		listPlanets.setSelectedValue(game.getCrew().getCurrentLocation(), true);
		listPlanets.setBorder(null);
		listPlanets.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				lblPieceAvailableValue.setText(((Planet) listPlanets.getSelectedValue()).planetPieceDetected());
				ImageIcon imageIcon = new ImageIcon(
						StartingPlanetWindow.class.getResource(((Planet)listPlanets.getSelectedValue()).getImageLink()));
				Image image = imageIcon.getImage();
				Image newimg = image.getScaledInstance(-1, 325, java.awt.Image.SCALE_FAST);
				imageIcon = new ImageIcon(newimg);
				lblPlanetImage.setIcon(imageIcon);
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
				if (game.gameOver()) {
					game.launchGameOverWindow();
				}  else {
					game.launchMainWindow();
				}
				if (!(message == null)) {
					JOptionPane.showMessageDialog(frame, message);
				}

			}
		});
		listPlanets.setBackground(UIManager.getColor("Menu.background"));
		listPlanets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listPlanets.setBounds(34, 58, 256, 327);
		panelSelectPlanet.add(listPlanets);

		JLabel lblSelectPlanet = new JLabel("Select Planet:");
		lblSelectPlanet.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelectPlanet.setBounds(34, 13, 279, 32);
		panelSelectPlanet.add(lblSelectPlanet);
		
		JSeparator separatorPanelTop = new JSeparator();
		separatorPanelTop.setBounds(12, 53, 301, 2);
		panelSelectPlanet.add(separatorPanelTop);

		JButton btnReturn = new JButton("Do something else!");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		btnReturn.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnReturn.setBounds(50, 515, 218, 25);
		frame.getContentPane().add(btnReturn);
		
		JLabel lblTitle = new JLabel("Explore a New World!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(0, 0, 795, 60);
		frame.getContentPane().add(lblTitle);
		
		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(50, 62, 695, 2);
		frame.getContentPane().add(separatorTop);
		
		
		
		frame.getContentPane().add(lblPlanetImage);
		ImageIcon imageIcon = new ImageIcon(
				StartingPlanetWindow.class.getResource(((Planet)listPlanets.getSelectedValue()).getImageLink()));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(-1, 325, java.awt.Image.SCALE_FAST);
		imageIcon = new ImageIcon(newimg);
		lblPlanetImage.setIcon(imageIcon);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 503, 695, 2);
		frame.getContentPane().add(separator);

	}
}
