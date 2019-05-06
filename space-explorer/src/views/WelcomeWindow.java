package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSlider;

public class WelcomeWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeWindow window = new WelcomeWindow();
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
	public WelcomeWindow() {
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
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 40));
		lblWelcome.setBounds(217, 12, 358, 56);
		frame.getContentPane().add(lblWelcome);
		
		JButton btnHowToPlay = new JButton("How to play");
		btnHowToPlay.setBounds(215, 80, 360, 56);
		frame.getContentPane().add(btnHowToPlay);
		
		JSlider slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(3);
		slider.setMaximum(10);
		slider.setBounds(174, 300, 445, 35);
		frame.getContentPane().add(slider);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setBounds(23, 288, 120, 47);
		frame.getContentPane().add(lblDays);
		
		JLabel lblPieces = new JLabel("Pieces");
		lblPieces.setBounds(23, 405, 66, 15);
		frame.getContentPane().add(lblPieces);
		
		JLabel label = new JLabel(".");
		label.setBounds(365, 405, 66, 15);
		frame.getContentPane().add(label);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(651, 536, 114, 25);
		frame.getContentPane().add(btnAccept);
	}
}
