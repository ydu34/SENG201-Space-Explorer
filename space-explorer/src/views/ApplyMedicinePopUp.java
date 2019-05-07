package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ApplyMedicinePopUp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyMedicinePopUp window = new ApplyMedicinePopUp();
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
	public ApplyMedicinePopUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 325, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImproveYourHealth = new JLabel("Improve your health!");
		lblImproveYourHealth.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 20));
		lblImproveYourHealth.setBounds(57, 12, 211, 28);
		frame.getContentPane().add(lblImproveYourHealth);
		
		JLabel lblCheckWhatMedicine = new JLabel("Check what you have:");
		lblCheckWhatMedicine.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 13));
		lblCheckWhatMedicine.setBounds(32, 77, 144, 15);
		frame.getContentPane().add(lblCheckWhatMedicine);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(32, 114, 89, 24);
		frame.getContentPane().add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(150, 113, 144, 199);
		frame.getContentPane().add(panel);
	}

}
