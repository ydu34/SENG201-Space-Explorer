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

	private JFrame frmSpaceExplorers;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public StartingPlanetWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorers.setVisible(true);
	}
	
	public void closeWindow() {
		frmSpaceExplorers.dispose();
	}
	
	public void finishedWindow() {
		game.closeStartingPlanetWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorers = new JFrame();
		frmSpaceExplorers.setTitle("SPACE EXPLORERS");
		frmSpaceExplorers.setBounds(100, 100, 800, 600);
		frmSpaceExplorers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorers.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECT STARTING PLANET\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(-4, 0, 776, 91);
		frmSpaceExplorers.getContentPane().add(lblNewLabel);		
		JComboBox comboBox = new JComboBox(game.getPlanets().toArray());
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setBounds(192, 441, 400, 41);
		frmSpaceExplorers.getContentPane().add(comboBox);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.getCrew().setCurrentLocation((Planet) comboBox.getSelectedItem());
				finishedWindow();
				game.launchMainWindow();
			}
		});
		btnStartGame.setBounds(635, 520, 126, 33);
		frmSpaceExplorers.getContentPane().add(btnStartGame);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchCreateCrewWindow();
			}
		});
		button_1.setBounds(21, 520, 126, 33);
		frmSpaceExplorers.getContentPane().add(button_1);
		
		ImageIcon imageIcon = new ImageIcon(StartingPlanetWindow.class.getResource("/resources/planet-2398343_1920.jpg"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(-1, 400, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		JLabel lblPlanetImage = new JLabel();
		lblPlanetImage.setBounds(192, 75, 400, 350);
		frmSpaceExplorers.getContentPane().add(lblPlanetImage);
		lblPlanetImage.setIcon(imageIcon);
	}
}
