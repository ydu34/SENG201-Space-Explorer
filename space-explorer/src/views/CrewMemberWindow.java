package views;

import java.awt.EventQueue;
import main.GameEnvironment;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrewMemberWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public CrewMemberWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeSetupScreen(this);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Crew Member 1\n");
		button.setBounds(52, 96, 175, 150);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Crew Member2");
		button_1.setBounds(268, 96, 175, 150);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Crew Member 4");
		button_2.setBounds(268, 275, 175, 150);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Crew Member 3");
		button_3.setBounds(52, 275, 175, 150);
		frame.getContentPane().add(button_3);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(487, 96, 257, 329);
		frame.getContentPane().add(panel);
		
		JLabel lblSelectACrew = new JLabel("Select a Crew Member to view status.");
		lblSelectACrew.setVerticalAlignment(SwingConstants.TOP);
		lblSelectACrew.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblSelectACrew.setBounds(12, 12, 233, 305);
		panel.add(lblSelectACrew);
		
		JButton btnPerformAction = new JButton("Perform Action");
		btnPerformAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPerformAction.setBounds(542, 504, 202, 25);
		frame.getContentPane().add(btnPerformAction);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(52, 504, 202, 25);
		frame.getContentPane().add(btnBack);
	}
}
