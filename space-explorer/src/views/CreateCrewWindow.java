package views;
import main.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class CreateCrewWindow {

	private JFrame frame;
	private JTextField textFieldShipName;
	private GameEnvironment game;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public CreateCrewWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeCreateCrewWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNext = new JButton("Accept");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.getCrew().setName(textFieldShipName.getText());
				finishedWindow();
			}
		});
		btnNext.setBounds(624, 506, 114, 25);
		frame.getContentPane().add(btnNext);
		
		JLabel lblNameYourShip = new JLabel("Ship name:");
		lblNameYourShip.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 20));
		lblNameYourShip.setBounds(46, 26, 337, 48);
		frame.getContentPane().add(lblNameYourShip);
		
		textFieldShipName = new JTextField();
		textFieldShipName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldShipName.setText("Gattaca");
		textFieldShipName.setBounds(393, 37, 292, 30);
		frame.getContentPane().add(textFieldShipName);
		textFieldShipName.setColumns(10);
		textFieldShipName.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
			    enableButton();
			}
			public void removeUpdate(DocumentEvent e) {
			    enableButton();
			}
			public void insertUpdate(DocumentEvent e) {
			   enableButton();
			}
			
			public void enableButton() {
				if (textFieldShipName.getText().equals(""))
				{
					btnNext.setEnabled(false);
				}
				else
				{
					btnNext.setEnabled(true);
				}
			}
		});
		
		JButton btnCM1 = new JButton("Crew Member 1\n");
		btnCM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCM1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCM1.setBounds(46, 158, 150, 150);
		frame.getContentPane().add(btnCM1);
		
		JButton btnCM2 = new JButton("Crew Member2");
		btnCM2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCM2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCM2.setBounds(225, 158, 150, 150);
		frame.getContentPane().add(btnCM2);
		
		JButton btnCM3 = new JButton("Crew Member 3");
		btnCM3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCM3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCM3.setBounds(46, 337, 150, 150);
		frame.getContentPane().add(btnCM3);
		
		JButton btnCM4 = new JButton("Crew Member 4");
		btnCM4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCM4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCM4.setBounds(225, 337, 150, 150);
		frame.getContentPane().add(btnCM4);
		
		JLabel lblSelectNumberOf = new JLabel("Number of Crew Members:");
		lblSelectNumberOf.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 20));
		lblSelectNumberOf.setBounds(46, 88, 337, 48);
		frame.getContentPane().add(lblSelectNumberOf);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				btnCM3.setEnabled(true);
				btnCM4.setEnabled(true);
				switch(slider.getValue()) {
				case 2: 
					btnCM3.setEnabled(false);
					btnCM4.setEnabled(false);		
					break;
				case 3: 
					btnCM4.setEnabled(false);
					break;
				}
			}
		});
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(2);
		slider.setMaximum(4);
		slider.setBounds(385, 79, 310, 67);
		frame.getContentPane().add(slider);
		
		JPanel panelCrewMember = new JPanel();
		panelCrewMember.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCrewMember.setBounds(410, 158, 328, 329);
		frame.getContentPane().add(panelCrewMember);
		panelCrewMember.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(23, 10, 78, 32);
		panelCrewMember.add(lblName);
		
		JLabel lblQuirk = new JLabel("Class:");
		lblQuirk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuirk.setBounds(23, 52, 78, 32);
		panelCrewMember.add(lblQuirk);
		
		textField = new JTextField();
		textField.setBounds(98, 10, 207, 32);
		panelCrewMember.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(98, 52, 207, 32);
		panelCrewMember.add(comboBox);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHealth.setBounds(23, 94, 78, 32);
		panelCrewMember.add(lblHealth);
		
		JLabel lblHunger = new JLabel("Hunger:\r\n");
		lblHunger.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHunger.setBounds(23, 136, 78, 32);
		panelCrewMember.add(lblHunger);
		
		JLabel lblFatigue = new JLabel("Fatigue:");
		lblFatigue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFatigue.setBounds(23, 178, 78, 32);
		panelCrewMember.add(lblFatigue);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 220, 281, 96);
		panelCrewMember.add(textArea);
	}
}
