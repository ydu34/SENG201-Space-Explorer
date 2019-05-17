package views;

import java.awt.EventQueue;
import main.GameEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ApplyMedicinePopUp {

	private JFrame frmSpaceExplorers;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public ApplyMedicinePopUp(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorers.setVisible(true);
	}
	
	public void closeWindow() {
		frmSpaceExplorers.dispose();
	}
	
	public void finishedWindow() {
		game.ApplyMedicinePopUp(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorers = new JFrame();
		frmSpaceExplorers.setTitle("SPACE EXPLORERS");
		frmSpaceExplorers.setBounds(100, 100, 325, 400);
		frmSpaceExplorers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorers.getContentPane().setLayout(null);
		
		JLabel lblImproveYourHealth = new JLabel("Improve your health!");
		lblImproveYourHealth.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 20));
		lblImproveYourHealth.setBounds(57, 37, 211, 28);
		frmSpaceExplorers.getContentPane().add(lblImproveYourHealth);
		
		JLabel lblCheckWhatMedicine = new JLabel("Check what you have:");
		lblCheckWhatMedicine.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 13));
		lblCheckWhatMedicine.setBounds(12, 86, 144, 15);
		frmSpaceExplorers.getContentPane().add(lblCheckWhatMedicine);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 113, 89, 24);
		frmSpaceExplorers.getContentPane().add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(115, 112, 179, 170);
		frmSpaceExplorers.getContentPane().add(panel);
		
		JLabel lblAboutThisMedicine = new JLabel("About this medicine");
		lblAboutThisMedicine.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 12));
		panel.add(lblAboutThisMedicine);
		
		JButton btnApply = new JButton("APPLY");
		btnApply.setBounds(12, 333, 90, 25);
		frmSpaceExplorers.getContentPane().add(btnApply);
		
		JButton button = new JButton("Let's do something else!");
		button.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 11));
		button.setBounds(134, 334, 160, 25);
		frmSpaceExplorers.getContentPane().add(button);
	}
}
