package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
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
		
		JLabel lblCurrentPlanetPhoto = new JLabel("planet photo");
		lblCurrentPlanetPhoto.setBounds(308, 113, 109, 15);
		frame.getContentPane().add(lblCurrentPlanetPhoto);
		
		JLabel lblPlanetName = new JLabel("planet name");
		lblPlanetName.setBounds(308, 222, 109, 15);
		frame.getContentPane().add(lblPlanetName);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblDay.setBounds(533, 146, 66, 15);
		frame.getContentPane().add(lblDay);
		
		JLabel lblPiecesFound = new JLabel("Pieces found:");
		lblPiecesFound.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblPiecesFound.setBounds(533, 200, 132, 15);
		frame.getContentPane().add(lblPiecesFound);
		
		JButton ShipStatusButton = new JButton("View ship status");
		ShipStatusButton.setForeground(new Color(160, 82, 45));
		ShipStatusButton.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		ShipStatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ShipStatusButton.setBounds(416, 367, 220, 35);
		frame.getContentPane().add(ShipStatusButton);
		
		JButton OutpostButton = new JButton("Visit outpost");
		OutpostButton.setForeground(new Color(0, 100, 0));
		OutpostButton.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		OutpostButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		OutpostButton.setBounds(137, 367, 220, 35);
		frame.getContentPane().add(OutpostButton);
		
		JButton ActionsButton = new JButton("Perform actions");
		ActionsButton.setForeground(new Color(178, 34, 34));
		ActionsButton.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		ActionsButton.setBounds(137, 432, 220, 35);
		frame.getContentPane().add(ActionsButton);
		
		JButton NextDayButton = new JButton("Next day");
		NextDayButton.setForeground(new Color(240, 128, 128));
		NextDayButton.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		NextDayButton.setBounds(416, 432, 220, 35);
		frame.getContentPane().add(NextDayButton);
	}
}
