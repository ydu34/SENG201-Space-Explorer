package views;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.CrewMember;
import main.GameEnvironment;
import main.Planet;

/**
 * The window that allows the player to select a new planet to pilot to.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class SelectPlanetWindow {

	private JFrame frame;
	private GameEnvironment game;
	private CrewMember pilot1;
	private CrewMember pilot2;

	/**
	 * Creates the window application.
	 * 
	 * @param incomingGame A GameEnvironment containing all the contents of the
	 *                     game.
	 */
	public SelectPlanetWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Calls the close window method in game environment.
	 */
	public void finishedWindow() {
		game.closeSelectPlanetWindow(this);
	}

	/**
	 * Initializes the contents of the frame. This includes a list of planets available to choose from, and a panel that displays if any engine pieces are detected on the selected planet, and buttons to pilot or return to the actions window.
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
		
		JLabel lblPartDetectedText = new JLabel("Part detected:");
		lblPartDetectedText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPartDetectedText.setBounds(12, 13, 186, 22);
		panelEnginePiece.add(lblPartDetectedText);
		
		JLabel lblPartAvailableValue = new JLabel(game.getCrew().getCurrentLocation().planetPartDetected());
		lblPartAvailableValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		lblPartAvailableValue.setBounds(210, 13, 103, 22);
		panelEnginePiece.add(lblPartAvailableValue);
		
		JLabel lblPlanetImage = new JLabel();
		lblPlanetImage.setHorizontalAlignment(SwingConstants.CENTER);
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
				lblPartAvailableValue.setText(((Planet) listPlanets.getSelectedValue()).planetPartDetected());
				ImageIcon imageIcon = new ImageIcon(
						StartingPlanetWindow.class.getResource(((Planet)listPlanets.getSelectedValue()).getImage()));
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
		
		JSeparator separatorPanelSelectPlanetTop = new JSeparator();
		separatorPanelSelectPlanetTop.setBounds(12, 53, 301, 2);
		panelSelectPlanet.add(separatorPanelSelectPlanetTop);

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
		
		JLabel lblWindowTitle = new JLabel("Explore a New World!");
		lblWindowTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindowTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWindowTitle.setBounds(0, 0, 795, 60);
		frame.getContentPane().add(lblWindowTitle);
		
		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(50, 62, 695, 2);
		frame.getContentPane().add(separatorTop);
		
		
		
		frame.getContentPane().add(lblPlanetImage);
		ImageIcon imageIcon = new ImageIcon(
				StartingPlanetWindow.class.getResource(((Planet)listPlanets.getSelectedValue()).getImage()));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(-1, 325, java.awt.Image.SCALE_FAST);
		imageIcon = new ImageIcon(newimg);
		lblPlanetImage.setIcon(imageIcon);
		
		JSeparator separatorBottom = new JSeparator();
		separatorBottom.setBounds(50, 503, 695, 2);
		frame.getContentPane().add(separatorBottom);

	}
}
