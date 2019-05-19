package views;

import java.awt.EventQueue;
import main.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupWindow{

	private JFrame frmSpaceExplorers;
	private GameEnvironment game;


	/**
	 * Create the application.
	 */
	public SetupWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorers.setVisible(true);
	}
	
	public void closeWindow() {
		frmSpaceExplorers.dispose();
	}
	
	public void finishedWindow() {
		game.closeSetupWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorers = new JFrame();
		frmSpaceExplorers.setResizable(false);
		frmSpaceExplorers.setTitle("SPACE EXPLORERS");
		frmSpaceExplorers.setBounds(100, 100, 800, 600);
		frmSpaceExplorers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorers.getContentPane().setLayout(null);
		
		JLabel lblPiecesNum = new JLabel();
		JLabel lblDays = new JLabel();
		
		JSlider daysSlider = new JSlider();
		daysSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblPiecesNum.setText("" + daysSlider.getValue() * 2 / 3);
				lblDays.setText("" + daysSlider.getValue());
			}
		});
		daysSlider.setSnapToTicks(true);
		daysSlider.setPaintTicks(true);
		daysSlider.setPaintLabels(true);
		daysSlider.setMajorTickSpacing(1);
		daysSlider.setMinimum(3);
		daysSlider.setMaximum(10);
		daysSlider.setBounds(41, 104, 702, 56);
		frmSpaceExplorers.getContentPane().add(daysSlider);
		
		JLabel lblPieces = new JLabel("Missing Pieces");
		lblPieces.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblPieces.setBounds(41, 344, 702, 56);
		frmSpaceExplorers.getContentPane().add(lblPieces);
		
		lblPiecesNum.setText("" + daysSlider.getValue() * 2 / 3);
		lblPiecesNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiecesNum.setFont(new Font("Dialog", Font.BOLD, 30));
		lblPiecesNum.setBounds(41, 424, 702, 56);
		frmSpaceExplorers.getContentPane().add(lblPiecesNum);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setGameDuration(daysSlider.getValue());
				game.getShip().setPiecesNeeded(daysSlider.getValue() * 2 / 3);
				finishedWindow();
				game.launchCreateCrewWindow();
			}
		});
		btnNext.setBounds(650, 504, 126, 33);
		frmSpaceExplorers.getContentPane().add(btnNext);
		
		JLabel lblSelectTheNumber = new JLabel("Select the number of days the game will last");
		lblSelectTheNumber.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSelectTheNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTheNumber.setBounds(41, 24, 702, 56);
		frmSpaceExplorers.getContentPane().add(lblSelectTheNumber);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchInstructionsWindow();
			}
		});
		btnBack.setBounds(10, 504, 126, 33);
		frmSpaceExplorers.getContentPane().add(btnBack);
		
		JLabel lblDaysText = new JLabel("Game Duration (days)");
		lblDaysText.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaysText.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDaysText.setBounds(41, 184, 702, 56);
		frmSpaceExplorers.getContentPane().add(lblDaysText);
		
		
		lblDays.setText("" + daysSlider.getValue());
		lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDays.setFont(new Font("Dialog", Font.BOLD, 30));
		lblDays.setBounds(41, 264, 702, 56);
		frmSpaceExplorers.getContentPane().add(lblDays);
		
	}
}
