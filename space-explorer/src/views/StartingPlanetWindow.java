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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECT STARTING PLANET\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(-4, 0, 776, 91);
		frame.getContentPane().add(lblNewLabel);		
		JComboBox comboBox = new JComboBox(game.getPlanets().toArray());
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setBounds(192, 441, 400, 41);
		frame.getContentPane().add(comboBox);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.getCrew().setCurrentLocation((Planet) comboBox.getSelectedItem());
				finishedWindow();
			}
		});
		btnStartGame.setBounds(635, 520, 126, 33);
		frame.getContentPane().add(btnStartGame);
		
		JButton button_1 = new JButton("Back");
		button_1.setBounds(21, 520, 126, 33);
		frame.getContentPane().add(button_1);
		
		ImageIcon imageIcon = new ImageIcon(StartingPlanetWindow.class.getResource("/resources/planet-2398343_1920.jpg"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(-1, 400, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(192, 75, 400, 350);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(imageIcon);
	}
}
