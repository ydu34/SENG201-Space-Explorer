package views;
import main.GameEnvironment;
import main.Planet;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

/**
 * Represents a window that allows players to select a starting planet.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class StartingPlanetWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Creates the window application.
	 * @param incomingGame	A GameEnvironment containing all the contents of the game.
	 */
	public StartingPlanetWindow(GameEnvironment incomingGame) {
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
		game.closeStartingPlanetWindow(this);
	}

	/**
	 * Initializes the contents of the frame. This includes a combo box of planets available to choose, an image of the planet, and buttons to go back to the crew creating window or start the game.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("SPACE EXPLORERS");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWindowTitle = new JLabel("SELECT STARTING PLANET\r\n");
		lblWindowTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindowTitle.setFont(new Font("Dialog", Font.BOLD, 30));
		lblWindowTitle.setBounds(0, 0, 795, 60);
		frame.getContentPane().add(lblWindowTitle);	
		
		JComboBox comboBoxPlanets = new JComboBox(game.getPlanets().toArray());
		ImageIcon imageIcon = new ImageIcon(StartingPlanetWindow.class.getResource(((Planet) comboBoxPlanets.getSelectedItem()).getImageLink()));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(-1, 400, java.awt.Image.SCALE_FAST);
		imageIcon = new ImageIcon(newimg);
		
		JLabel lblPlanetImage = new JLabel();
		lblPlanetImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanetImage.setBounds(197, 86, 400, 350);
		frame.getContentPane().add(lblPlanetImage);
		lblPlanetImage.setIcon(imageIcon);
		
		
		comboBoxPlanets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxPlanets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon imageIcon = new ImageIcon(StartingPlanetWindow.class.getResource(((Planet) comboBoxPlanets.getSelectedItem()).getImageLink()));
				Image image = imageIcon.getImage();
				Image newimg = image.getScaledInstance(-1, 400, java.awt.Image.SCALE_FAST);
				imageIcon = new ImageIcon(newimg);
				lblPlanetImage.setIcon(imageIcon);
			}
		});
		comboBoxPlanets.setBounds(197, 449, 400, 41);
		frame.getContentPane().add(comboBoxPlanets);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.getCrew().setCurrentLocation((Planet) comboBoxPlanets.getSelectedItem());
				finishedWindow();
				game.launchMainWindow();
			}
		});
		btnStartGame.setBounds(619, 520, 126, 33);
		frame.getContentPane().add(btnStartGame);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchCreateCrewWindow();
			}
		});
		btnBack.setBounds(50, 520, 126, 33);
		frame.getContentPane().add(btnBack);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 62, 695, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 503, 695, 2);
		frame.getContentPane().add(separator_1);
		
		
	}
}
