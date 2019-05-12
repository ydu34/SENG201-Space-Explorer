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

public class SetupWindow implements ChangeListener {

	private static JLabel lblPiecesNum;
	private JFrame frame;
	private GameEnvironment game;
	private static JSlider daysSlider;


	/**
	 * Create the application.
	 */
	public SetupWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeSetupWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSlider daysSlider = new JSlider();
		daysSlider.setSnapToTicks(true);
		daysSlider.setPaintTicks(true);
		daysSlider.setPaintLabels(true);
		daysSlider.setMajorTickSpacing(1);
		daysSlider.setMinimum(3);
		daysSlider.setMaximum(10);
		daysSlider.setBounds(41, 175, 702, 87);
		daysSlider.addChangeListener(this);
		frame.getContentPane().add(daysSlider);
		
		
		JLabel lblPieces = new JLabel("Pieces missing from the ship:");
		lblPieces.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblPieces.setBounds(41, 330, 702, 39);
		frame.getContentPane().add(lblPieces);
		
		JLabel lblPiecesNum = new JLabel();
		
		lblPiecesNum.setText("" + daysSlider.getValue() * 2 / 3);
		lblPiecesNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiecesNum.setFont(new Font("Dialog", Font.BOLD, 30));
		lblPiecesNum.setBounds(41, 437, 702, 56);
		frame.getContentPane().add(lblPiecesNum);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setGameDuration(daysSlider.getValue());
				finishedWindow();
			}
		});
		btnNext.setBounds(650, 520, 126, 33);
		frame.getContentPane().add(btnNext);
		
		JLabel lblSelectTheNumber = new JLabel("Select the number of days the game will last:");
		lblSelectTheNumber.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSelectTheNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTheNumber.setBounds(41, 68, 702, 39);
		frame.getContentPane().add(lblSelectTheNumber);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 520, 126, 33);
		frame.getContentPane().add(btnBack);
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		lblPiecesNum.setText("" +daysSlider.getValue());
	}


}
