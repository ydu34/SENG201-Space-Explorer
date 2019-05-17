package views;

import main.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class StartWindow {

	private JFrame frmSpaceExplorers;
	private GameEnvironment game;
	

	/**
	 * Create the application.
	 */
	public StartWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorers.setVisible(true);
	}
	
	public void closeWindow() {
		frmSpaceExplorers.dispose();
	}
	
	public void finishedWindow() {
		game.closeStartWindow(this);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(7, 7, 772, 325);
		frmSpaceExplorers.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SPACE EXPLORERS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 10, 750, 301);
		panel.add(lblNewLabel);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(299, 381, 190, 41);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnStart.setFont(new Font("SansSerif", Font.BOLD, 16));
		frmSpaceExplorers.getContentPane().add(btnStart);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(299, 453, 188, 41);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setFont(new Font("SansSerif", Font.BOLD, 16));
		frmSpaceExplorers.getContentPane().add(btnQuit);
	}
}
