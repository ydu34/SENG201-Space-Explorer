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

public class StartingPlanetWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public StartingPlanetWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeStartingPlanetWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
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
		lblWindowTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWindowTitle.setBounds(-4, 0, 776, 68);
		frame.getContentPane().add(lblWindowTitle);		
		JComboBox comboBoxPlanets = new JComboBox(game.getPlanets().toArray());
		comboBoxPlanets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxPlanets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxPlanets.setBounds(192, 441, 400, 41);
		frame.getContentPane().add(comboBoxPlanets);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.getCrew().setCurrentLocation((Planet) comboBoxPlanets.getSelectedItem());
				finishedWindow();
				game.launchMainWindow();
			}
		});
		btnStartGame.setBounds(635, 520, 126, 33);
		frame.getContentPane().add(btnStartGame);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchCreateCrewWindow();
			}
		});
		btnBack.setBounds(21, 520, 126, 33);
		frame.getContentPane().add(btnBack);
		
		ImageIcon imageIcon = new ImageIcon(StartingPlanetWindow.class.getResource("/resources/planet1.png"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(-1, 400, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		JLabel lblPlanetImage = new JLabel();
		lblPlanetImage.setBounds(192, 75, 400, 350);
		frame.getContentPane().add(lblPlanetImage);
		lblPlanetImage.setIcon(imageIcon);
	}
}
