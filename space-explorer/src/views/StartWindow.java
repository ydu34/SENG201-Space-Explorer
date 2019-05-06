package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class StartWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow window = new StartWindow();
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
	public StartWindow() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 774, 325);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO \nSPACE EXPLORER!");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel.setBounds(12, 12, 750, 301);
		panel.add(lblNewLabel);
		
		JButton StartButton = new JButton("Start");
		StartButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		StartButton.setBounds(280, 391, 220, 41);
		frame.getContentPane().add(StartButton);
		
		JButton QuitButton = new JButton("Quit");
		QuitButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		QuitButton.setBounds(280, 458, 220, 41);
		frame.getContentPane().add(QuitButton);
	}
}
