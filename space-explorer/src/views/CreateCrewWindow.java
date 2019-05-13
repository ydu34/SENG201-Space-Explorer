package views;

import main.CrewMember;
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
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class CreateCrewWindow {

	private JFrame frame;
	private JTextField textFieldShipName;
	private GameEnvironment game;
	private JTextField tfCMName;
	private ArrayList<JToggleButton> CrewMemberToggleButtons = new ArrayList<JToggleButton>();
	private JTextField lblHealthValue;
	private JTextField lblFatigueValue;
	private JTextField lblHungerValue;
	private JComboBox comboBox;

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
		
		JPanel panelCrewMember = new JPanel();
		panelCrewMember.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCrewMember.setBounds(410, 158, 328, 329);
		frame.getContentPane().add(panelCrewMember);
		panelCrewMember.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(23, 10, 78, 32);
		panelCrewMember.add(lblName);
		
		JLabel lblQuirk = new JLabel("Class:");
		lblQuirk.setFont(new Font("Dialog", Font.BOLD, 16));
		lblQuirk.setBounds(23, 52, 78, 32);
		panelCrewMember.add(lblQuirk);
		
		tfCMName = new JTextField("Bill");
		tfCMName.setBounds(109, 10, 207, 32);
		panelCrewMember.add(tfCMName);
		tfCMName.setColumns(10);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHealth.setBounds(23, 94, 78, 32);
		panelCrewMember.add(lblHealth);
		
		JLabel lblHunger = new JLabel("Hunger:\r\n");
		lblHunger.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHunger.setBounds(23, 136, 78, 32);
		panelCrewMember.add(lblHunger);
		
		JLabel lblFatigue = new JLabel("Fatigue:");
		lblFatigue.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFatigue.setBounds(23, 178, 78, 32);
		panelCrewMember.add(lblFatigue);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 220, 293, 96);
		panelCrewMember.add(textArea);
		
		
		CrewMember CM1 = new CrewMember("Bill", "Engineer");
		CrewMember CM2 = new CrewMember("Carole", "Health Nut");
		CrewMember CM3 = new CrewMember("Noah", "Nibbler");
		CrewMember CM4 = new CrewMember("Kim", "Night Owl");
		
		
		JComboBox comboBox = new JComboBox(game.getCrewMemberTypes().toArray());
		CrewMember currentType = (CrewMember) comboBox.getSelectedItem();
		
		JLabel lblHealthValue = new JLabel(currentType.getHealth() + "/" + currentType.getMaxHealth());
		lblHealthValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHealthValue.setBounds(109, 96, 207, 32);
		panelCrewMember.add(lblHealthValue);
		
		JLabel lblHungerValue = new JLabel(currentType.getHunger() + "/" + currentType.getMaxHunger());
		lblHungerValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHungerValue.setBounds(109, 138, 207, 32);
		panelCrewMember.add(lblHungerValue);
		
		JLabel lblFatigueValue = new JLabel(currentType.getFatigue() + "/" + currentType.getMaxFatigue());
		lblFatigueValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFatigueValue.setBounds(109, 178, 207, 32);
		panelCrewMember.add(lblFatigueValue);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrewMember currentType = (CrewMember) comboBox.getSelectedItem();
				lblHealthValue.setText(currentType.getHealth() + "/" + currentType.getMaxHealth());
				lblHungerValue.setText(currentType.getHunger() + "/" + currentType.getMaxHunger());
				lblFatigueValue.setText(currentType.getFatigue() + "/" + currentType.getMaxFatigue());
			}
		});
		comboBox.setBounds(109, 52, 207, 32);
		panelCrewMember.add(comboBox);
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

		
		
		JToggleButton tglbtnCM1 = new JToggleButton("1", true);
		tglbtnCM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetToggleButtons();
				tglbtnCM1.setSelected(true);
				tfCMName.setText(CM1.getName());
				switch(CM1.getType()) {
				case "Engineer" :
					comboBox.setSelectedIndex(0);
					break;
				case "Health Nut":
					comboBox.setSelectedIndex(1);
					break;
				case "Nibbler":
					comboBox.setSelectedIndex(2);
					break;
				case "Night Owl":
					comboBox.setSelectedIndex(3);
				case "Protected":
					comboBox.setSelectedIndex(4);
				case "Regular":
					comboBox.setSelectedIndex(5);
				}
			}
		});
		tglbtnCM1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM1.setBounds(46, 158, 150, 150);
		frame.getContentPane().add(tglbtnCM1);
		CrewMemberToggleButtons.add(tglbtnCM1);
		
		
		JToggleButton tglbtnCM2 = new JToggleButton("2");
		tglbtnCM2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetToggleButtons();
				tglbtnCM2.setSelected(true);
				tfCMName.setText(CM2.getName());
				switch(CM2.getType()) {
				case "Engineer" :
					comboBox.setSelectedIndex(0);
					break;
				case "Health Nut":
					comboBox.setSelectedIndex(1);
					break;
				case "Nibbler":
					comboBox.setSelectedIndex(2);
					break;
				case "Night Owl":
					comboBox.setSelectedIndex(3);
				case "Protected":
					comboBox.setSelectedIndex(4);
				case "Regular":
					comboBox.setSelectedIndex(5);
				}
			}
		});
		tglbtnCM2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM2.setBounds(225, 158, 150, 150);
		frame.getContentPane().add(tglbtnCM2);
		CrewMemberToggleButtons.add(tglbtnCM2);
		
		JToggleButton tglbtnCM3 = new JToggleButton("3");
		tglbtnCM3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetToggleButtons();
				tglbtnCM3.setSelected(true);
				switch(CM3.getType()) {
				case "Engineer" :
					comboBox.setSelectedIndex(0);
					break;
				case "Health Nut":
					comboBox.setSelectedIndex(1);
					break;
				case "Nibbler":
					comboBox.setSelectedIndex(2);
					break;
				case "Night Owl":
					comboBox.setSelectedIndex(3);
				case "Protected":
					comboBox.setSelectedIndex(4);
				case "Regular":
					comboBox.setSelectedIndex(5);
				}
			}
		});
		tglbtnCM3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM3.setBounds(46, 337, 150, 150);
		frame.getContentPane().add(tglbtnCM3);
		CrewMemberToggleButtons.add(tglbtnCM3);
		
		JToggleButton tglbtnCM4 = new JToggleButton("4");
		tglbtnCM4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetToggleButtons();
				tglbtnCM4.setSelected(true);
				switch(CM4.getType()) {
				case "Engineer" :
					comboBox.setSelectedIndex(0);
					break;
				case "Health Nut":
					comboBox.setSelectedIndex(1);
					break;
				case "Nibbler":
					comboBox.setSelectedIndex(2);
					break;
				case "Night Owl":
					comboBox.setSelectedIndex(3);
				case "Protected":
					comboBox.setSelectedIndex(4);
				case "Regular":
					comboBox.setSelectedIndex(5);
				}
			}
		});
		tglbtnCM4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM4.setBounds(225, 337, 150, 150);
		frame.getContentPane().add(tglbtnCM4);
		CrewMemberToggleButtons.add(tglbtnCM4);
		
		
		JLabel lblSelectNumberOf = new JLabel("Number of Crew Members:");
		lblSelectNumberOf.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 20));
		lblSelectNumberOf.setBounds(46, 88, 337, 48);
		frame.getContentPane().add(lblSelectNumberOf);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tglbtnCM3.setEnabled(true);
				tglbtnCM4.setEnabled(true);
				switch(slider.getValue()) {
				case 2: 
					tglbtnCM3.setEnabled(false);
					tglbtnCM4.setEnabled(false);		
					break;
				case 3: 
					tglbtnCM4.setEnabled(false);
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
		
	}
	
	public void resetToggleButtons() {
		for (JToggleButton button : CrewMemberToggleButtons) {
			button.setSelected(false);
		}
	}
	
	public void updateType(CrewMember member) {
		
	}
	
}
