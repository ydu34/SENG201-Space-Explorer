package views;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import main.GameEnvironment;

/**
 * The main window that displays the information regarding the situation of the
 * game. There are buttons that lead to the outpost, the crew members, moving on
 * to the next day, and exit the game.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class MainWindow {

	private JFrame frame;
	private GameEnvironment game;
	private JLabel lblDayValue;

	/**
	 * Creates the window application.
	 * 
	 * @param incomingGame A GameEnvironment containing all the contents of the
	 *                     game.
	 */
	public MainWindow(GameEnvironment incomingGame) {
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
		game.closeMainWindow(this);
	}

	/**
	 * Initialize the contents of the frame. This includes a photo of the current
	 * planet, a panel displaying the current game details, and buttons to visit
	 * outpost, view crew, move on to the next day, and exit game.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("SPACE EXPLORERS");
		frame.getContentPane().setFont(new Font("L M Mono Prop Lt10", Font.PLAIN, 12));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnOutpost = new JButton("Visit Outpost");
		btnOutpost.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
				game.launchOutpostWindow();
			}
		});
		btnOutpost.setBounds(23, 495, 170, 35);
		frame.getContentPane().add(btnOutpost);

		JButton btnCrew = new JButton("View Crew");
		btnCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		btnCrew.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCrew.setBounds(216, 495, 170, 35);
		frame.getContentPane().add(btnCrew);

		JLabel lblPlanetImage = new JLabel();
		lblPlanetImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanetImage.setBounds(28, 76, 400, 350);
		frame.getContentPane().add(lblPlanetImage);
		ImageIcon imageIcon = new ImageIcon(
				StartingPlanetWindow.class.getResource(game.getCrew().getCurrentLocation().getImage()));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(-1, 400, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		lblPlanetImage.setIcon(imageIcon);

		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (game.gameOver()) {
					finishedWindow();
					game.launchGameOverWindow();
				} else {
					String message = game.nextDay();
					if (!(message.isEmpty())) {
						JOptionPane.showMessageDialog(frame, message);
					}
					updateScreen();
				}

			}
		});
		btnNextDay.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnNextDay.setBounds(409, 495, 170, 35);
		frame.getContentPane().add(btnNextDay);

		JPanel panelSituation = new JPanel();
		panelSituation.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSituation.setBounds(440, 76, 330, 350);
		frame.getContentPane().add(panelSituation);
		panelSituation.setLayout(null);

		JLabel lblDayText = new JLabel("Day:");
		lblDayText.setBounds(12, 23, 138, 31);
		panelSituation.add(lblDayText);
		lblDayText.setFont(new Font("Dialog", Font.BOLD, 16));

		lblDayValue = new JLabel(game.getCurrentDay() + "/" + game.getGameDuration());
		lblDayValue.setBounds(164, 23, 154, 31);
		panelSituation.add(lblDayValue);
		lblDayValue.setText(game.getCurrentDay() + "/" + game.getGameDuration());
		lblDayValue.setFont(new Font("Dialog", Font.PLAIN, 17));

		JLabel lblShipText = new JLabel("Ship: ");
		lblShipText.setBounds(12, 239, 138, 31);
		panelSituation.add(lblShipText);
		lblShipText.setFont(new Font("Dialog", Font.BOLD, 16));

		JLabel lblShipValue = new JLabel(game.getShip().getName());
		lblShipValue.setBounds(164, 239, 154, 31);
		panelSituation.add(lblShipValue);
		lblShipValue.setFont(new Font("Dialog", Font.PLAIN, 17));

		JLabel lblPartsFoundText = new JLabel("Parts found:");
		lblPartsFoundText.setBounds(12, 77, 138, 31);
		panelSituation.add(lblPartsFoundText);
		lblPartsFoundText.setFont(new Font("Dialog", Font.BOLD, 16));

		JLabel lblPiecesFoundValue = new JLabel(
				game.getShip().getPartsFound() + "/" + game.getShip().getPartsNeeded());
		lblPiecesFoundValue.setBounds(164, 77, 154, 31);
		panelSituation.add(lblPiecesFoundValue);
		lblPiecesFoundValue.setFont(new Font("Dialog", Font.PLAIN, 17));

		JLabel lblShieldLevelText = new JLabel("Shield Level:");
		lblShieldLevelText.setBounds(12, 293, 138, 31);
		panelSituation.add(lblShieldLevelText);
		lblShieldLevelText.setFont(new Font("Dialog", Font.BOLD, 16));

		JLabel lblShipLevelValue = new JLabel(
				game.getShip().getShieldLevel() + "/" + game.getShip().getMaxShieldLevel());
		lblShipLevelValue.setBounds(164, 293, 154, 31);
		panelSituation.add(lblShipLevelValue);
		lblShipLevelValue.setFont(new Font("Dialog", Font.PLAIN, 17));

		JLabel lblPlanetText = new JLabel("Planet:");
		lblPlanetText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPlanetText.setBounds(12, 131, 138, 31);
		panelSituation.add(lblPlanetText);

		JLabel lblPlanetName = new JLabel(game.getCrew().getCurrentLocation().getName());
		lblPlanetName.setBounds(164, 131, 154, 31);
		panelSituation.add(lblPlanetName);
		lblPlanetName.setFont(new Font("Dialog", Font.PLAIN, 17));

		JLabel lblPartDetectedText = new JLabel("Part detected:");
		lblPartDetectedText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPartDetectedText.setBounds(12, 185, 138, 31);
		panelSituation.add(lblPartDetectedText);

		JLabel lblPartDetectedValue = new JLabel(game.getCrew().getCurrentLocation().planetPartDetected());
		lblPartDetectedValue.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblPartDetectedValue.setBounds(164, 185, 154, 31);
		panelSituation.add(lblPartDetectedValue);

		JSeparator separatorPanelSituationTop = new JSeparator();
		separatorPanelSituationTop.setBounds(12, 115, 288, 2);
		panelSituation.add(separatorPanelSituationTop);

		JSeparator separatorPanelSituationBottom = new JSeparator();
		separatorPanelSituationBottom.setBounds(12, 232, 288, 2);
		panelSituation.add(separatorPanelSituationBottom);

		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Game",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					System.exit(0);
				}
			}
		});
		btnExitGame.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnExitGame.setBounds(602, 495, 170, 35);
		frame.getContentPane().add(btnExitGame);

		JSeparator separatorBottom = new JSeparator();
		separatorBottom.setBounds(20, 466, 750, 16);
		frame.getContentPane().add(separatorBottom);

		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(20, 34, 750, 16);
		frame.getContentPane().add(separatorTop);
	}

	/**
	 * Updates the current day number on the main window.
	 */
	public void updateScreen() {
		lblDayValue.setText(game.getCurrentDay() + "/" + game.getGameDuration());
		if (game.gameOver()) {
			finishedWindow();
			game.launchGameOverWindow();
		}
	}
}
