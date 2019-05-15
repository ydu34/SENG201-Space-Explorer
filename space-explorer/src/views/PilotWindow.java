package views;

import main.GameEnvironment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;

public class PilotWindow {

	private JFrame frame;
	private GameEnvironment game;

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
		frame.setBounds(100, 100, 325, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(65, 12, 200, 172);
		frame.getContentPane().add(panel);
		
		JLabel lblPictureOfPlanet = new JLabel("Picture of Planet");
		lblPictureOfPlanet.setBounds(0, 12, 205, 30);
		panel.add(lblPictureOfPlanet);
		
		JButton btnPilot = new JButton("PILOT");
		btnPilot.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnPilot.setBounds(12, 320, 122, 25);
		frame.getContentPane().add(btnPilot);
		
		JButton button_1 = new JButton("Let's do something else!");
		button_1.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 11));
		button_1.setBounds(151, 320, 160, 25);
		frame.getContentPane().add(button_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(65, 211, 200, 25);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSelectPlanet = new JLabel("Select New Planet:");
		lblSelectPlanet.setBounds(65, 196, 197, 15);
		frame.getContentPane().add(lblSelectPlanet);
		
		JLabel lblSelectCopilol = new JLabel("Select co-pilot:");
		lblSelectCopilol.setBounds(68, 248, 197, 15);
		frame.getContentPane().add(lblSelectCopilol);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(65, 265, 200, 25);
		frame.getContentPane().add(comboBox_1);
	}
}
