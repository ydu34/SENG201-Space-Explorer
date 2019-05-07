package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

public class CreateCrewWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCrewWindow window = new CreateCrewWindow();
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
	public CreateCrewWindow() {
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
		
		JLabel lblNameYourShip = new JLabel("Name your ship:");
		lblNameYourShip.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNameYourShip.setBounds(46, 26, 337, 48);
		frame.getContentPane().add(lblNameYourShip);
		
		textField = new JTextField();
		textField.setBounds(393, 37, 292, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Crew Member 1\n");
		btnNewButton.setBounds(46, 158, 175, 150);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblSelectNumberOf = new JLabel("Select Number of Crew Members:");
		lblSelectNumberOf.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSelectNumberOf.setBounds(46, 88, 337, 48);
		frame.getContentPane().add(lblSelectNumberOf);
		
		JSlider slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(2);
		slider.setMaximum(4);
		slider.setBounds(385, 88, 300, 48);
		frame.getContentPane().add(slider);
		
		JButton btnCrewMember = new JButton("Crew Member2");
		btnCrewMember.setBounds(262, 158, 175, 150);
		frame.getContentPane().add(btnCrewMember);
		
		JButton btnCrewMember_1 = new JButton("Crew Member 3");
		btnCrewMember_1.setBounds(46, 337, 175, 150);
		frame.getContentPane().add(btnCrewMember_1);
		
		JButton btnCrewMember_2 = new JButton("Crew Member 4");
		btnCrewMember_2.setBounds(262, 337, 175, 150);
		frame.getContentPane().add(btnCrewMember_2);
		
		JPanel panelCrewMember = new JPanel();
		panelCrewMember.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCrewMember.setBounds(481, 158, 257, 329);
		frame.getContentPane().add(panelCrewMember);
		panelCrewMember.setLayout(null);
		
		JLabel label = new JLabel("Select a Crew Member");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		label.setBounds(12, 12, 233, 305);
		panelCrewMember.add(label);
		
		JButton button_3 = new JButton("Accept");
		button_3.setBounds(624, 506, 114, 25);
		frame.getContentPane().add(button_3);
	}
}
