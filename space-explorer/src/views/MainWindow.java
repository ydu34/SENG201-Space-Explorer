package views;

import java.awt.EventQueue;
import main.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class MainWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public MainWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeMainWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("L M Mono Prop Lt10", Font.PLAIN, 12));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlanetName = new JLabel(game.getCrew().getCurrentLocation().getName());
		lblPlanetName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanetName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPlanetName.setBounds(282, 431, 220, 50);
		frame.getContentPane().add(lblPlanetName);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDay.setBounds(616, 106, 170, 35);
		frame.getContentPane().add(lblDay);
		
		JLabel lblPiecesFound = new JLabel("Pieces found:");
		lblPiecesFound.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPiecesFound.setBounds(616, 206, 170, 35);
		frame.getContentPane().add(lblPiecesFound);
		
		JButton btnOutpost = new JButton("Visit outpost");
		btnOutpost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
				game.launchOutpostWindow();
			}
		});
		btnOutpost.setBounds(31, 518, 220, 35);
		frame.getContentPane().add(btnOutpost);
		
		JButton btnCrew = new JButton("View Crew");
		btnCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		btnCrew.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnCrew.setBounds(282, 518, 220, 35);
		frame.getContentPane().add(btnCrew);
		
		JLabel lblShip = new JLabel("Ship: \r\n");
		lblShip.setFont(new Font("Dialog", Font.BOLD, 20));
		lblShip.setBounds(12, 106, 170, 35);
		frame.getContentPane().add(lblShip);
		
		JLabel lblShieldLevel = new JLabel("Shield Level:");
		lblShieldLevel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblShieldLevel.setBounds(12, 204, 170, 35);
		frame.getContentPane().add(lblShieldLevel);
		
		JLabel lblDayValue = new JLabel(game.getCurrentDay() + "/" + game.getGameDuration());
		lblDayValue.setText(game.getCurrentDay() + "/" + game.getGameDuration());
		lblDayValue.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDayValue.setBounds(616, 145, 170, 35);
		frame.getContentPane().add(lblDayValue);
		
		JLabel lblPiecesFoundValue = new JLabel(game.getShip().getPiecesFound() + "/" + game.getShip().getPiecesNeeded());
		lblPiecesFoundValue.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPiecesFoundValue.setBounds(616, 240, 170, 35);
		frame.getContentPane().add(lblPiecesFoundValue);
		
		JLabel lblPlanetImage = new JLabel();
		lblPlanetImage.setBounds(192, 75, 400, 350);
		frame.getContentPane().add(lblPlanetImage);
		ImageIcon imageIcon = new ImageIcon(StartingPlanetWindow.class.getResource("/resources/planet-2398343_1920.jpg"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(-1, 400, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		lblPlanetImage.setIcon(imageIcon);
		
		JLabel lblShipName = new JLabel(game.getCrew().getName());
		lblShipName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblShipName.setBounds(12, 143, 170, 35);
		frame.getContentPane().add(lblShipName);
		
		JLabel lblShipLevelValue = new JLabel(game.getShip().getShieldLevel() + "/" + game.getShip().getMaxShieldLevel());
		lblShipLevelValue.setFont(new Font("Dialog", Font.BOLD, 20));
		lblShipLevelValue.setBounds(12, 240, 170, 35);
		frame.getContentPane().add(lblShipLevelValue);
		
		JButton btnNextDay = new JButton("Next day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.nextDay();
				frame.revalidate();
				frame.repaint();
			}
		});
		btnNextDay.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnNextDay.setBounds(533, 518, 220, 35);
		frame.getContentPane().add(btnNextDay);
	}
}
