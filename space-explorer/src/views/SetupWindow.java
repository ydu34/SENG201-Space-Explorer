package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.GameEnvironment;

/**
 * The window that allows the player to choose the game duration and view the number of parts needed to be found. 
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class SetupWindow {

	private JFrame frmSpaceExplorers;
	private GameEnvironment game;

	/**
	 * Creates the window application.
	 * 
	 * @param incomingGame A GameEnvironment containing all the contents of the
	 *                     game.
	 */
	public SetupWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorers.setVisible(true);
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frmSpaceExplorers.dispose();
	}

	/**
	 * Calls the close window method in game environment.
	 */
	public void finishedWindow() {
		game.closeSetupWindow(this);
	}

	/**
	 * Initializes the contents of the frame. This includes a slider to choose the
	 * number of days, and a display of the days chosen with the corresponding
	 * number of missing engine pieces to be found, and buttons to go back to the
	 * instructions window or proceed to the create crew window.
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
		daysSlider.setBounds(45, 100, 707, 56);
		frmSpaceExplorers.getContentPane().add(daysSlider);

		JLabel lblPieces = new JLabel("Missing Pieces");
		lblPieces.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblPieces.setBounds(48, 344, 702, 56);
		frmSpaceExplorers.getContentPane().add(lblPieces);

		lblPiecesNum.setText("" + daysSlider.getValue() * 2 / 3);
		lblPiecesNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiecesNum.setFont(new Font("Dialog", Font.BOLD, 30));
		lblPiecesNum.setBounds(48, 424, 702, 56);
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
		btnNext.setBounds(619, 514, 126, 33);
		frmSpaceExplorers.getContentPane().add(btnNext);

		JLabel lblSelectTheNumber = new JLabel("Select Game Duration\n");
		lblSelectTheNumber.setFont(new Font("Dialog", Font.BOLD, 30));
		lblSelectTheNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTheNumber.setBounds(0, 0, 795, 60);
		frmSpaceExplorers.getContentPane().add(lblSelectTheNumber);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchInstructionsWindow();
			}
		});
		btnBack.setBounds(50, 514, 126, 33);
		frmSpaceExplorers.getContentPane().add(btnBack);

		JLabel lblDaysText = new JLabel("Game Duration (days)");
		lblDaysText.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaysText.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDaysText.setBounds(48, 184, 702, 56);
		frmSpaceExplorers.getContentPane().add(lblDaysText);

		lblDays.setText("" + daysSlider.getValue());
		lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDays.setFont(new Font("Dialog", Font.BOLD, 30));
		lblDays.setBounds(48, 264, 702, 56);
		frmSpaceExplorers.getContentPane().add(lblDays);

		JSeparator separatorBottom = new JSeparator();
		separatorBottom.setBounds(50, 503, 695, 2);
		frmSpaceExplorers.getContentPane().add(separatorBottom);

		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(50, 62, 695, 2);
		frmSpaceExplorers.getContentPane().add(separatorTop);

	}
}
