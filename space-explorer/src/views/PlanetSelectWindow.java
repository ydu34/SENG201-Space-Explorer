package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class PlanetSelectWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanetSelectWindow window = new PlanetSelectWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlanetSelectWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlanets = new JLabel("Planets");
		lblPlanets.setFont(new Font("L M Mono Prop Lt10", Font.PLAIN, 50));
		lblPlanets.setBounds(291, 60, 189, 94);
		frame.getContentPane().add(lblPlanets);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(280, 429, 200, 30);
		frame.getContentPane().add(comboBox);
		
		JLabel lblPlanetPhotos = new JLabel("planet photos");
		lblPlanetPhotos.setBounds(331, 241, 105, 15);
		frame.getContentPane().add(lblPlanetPhotos);
	}
}
