package views;

import main.CrewMember;
import main.Engineer;
import main.GameEnvironment;
import main.HealthNut;
import main.Nibbler;
import main.NightOwl;
import main.Protected;
import main.Regular;

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
import java.util.Collections;

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
		
		
		CrewMember CM1 = new CrewMember("Bill", "Engineer");
		CrewMember CM2 = new CrewMember("Carole", "Health Nut");
		CrewMember CM3 = new CrewMember("Noah", "Nibbler");
		CrewMember CM4 = new CrewMember("Kim", "Night Owl");
		
		JPanel panelCrewMember = new JPanel();
		panelCrewMember.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCrewMember.setBounds(410, 158, 328, 329);
		frame.getContentPane().add(panelCrewMember);
		panelCrewMember.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(23, 10, 78, 32);
		panelCrewMember.add(lblName);
		
		JLabel lblTrait = new JLabel("Trait:");
		lblTrait.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTrait.setBounds(23, 52, 78, 32);
		panelCrewMember.add(lblTrait);
		
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
		textArea.setBounds(23, 220, 293, 71);
		panelCrewMember.add(textArea);
		
		
		JComboBox traitComboBox = new JComboBox(game.getCrewMemberTypes().toArray());
		CrewMember currentType = (CrewMember) traitComboBox.getSelectedItem();
		
		JLabel lblHealthValue_1 = new JLabel(currentType.getHealth() + "/" + currentType.getMaxHealth());
		lblHealthValue_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHealthValue_1.setBounds(109, 96, 207, 32);
		panelCrewMember.add(lblHealthValue_1);
		
		JLabel lblHungerValue_1 = new JLabel(currentType.getHunger() + "/" + currentType.getMaxHunger());
		lblHungerValue_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHungerValue_1.setBounds(109, 138, 207, 32);
		panelCrewMember.add(lblHungerValue_1);
		
		JLabel lblFatigueValue_1 = new JLabel(currentType.getFatigue() + "/" + currentType.getMaxFatigue());
		lblFatigueValue_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFatigueValue_1.setBounds(109, 178, 207, 32);
		panelCrewMember.add(lblFatigueValue_1);
		
		
		traitComboBox.setBounds(109, 52, 207, 32);
		panelCrewMember.add(traitComboBox);
		
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
					traitComboBox.setSelectedIndex(0);
					break;
				case "Health Nut":
					traitComboBox.setSelectedIndex(1);
					break;
				case "Nibbler":
					traitComboBox.setSelectedIndex(2);
					break;
				case "Night Owl":
					traitComboBox.setSelectedIndex(3);
					break;
				case "Protected":
					traitComboBox.setSelectedIndex(4);
					break;
				case "Regular":
					traitComboBox.setSelectedIndex(5);
					break;
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
					traitComboBox.setSelectedIndex(0);
					break;
				case "Health Nut":
					traitComboBox.setSelectedIndex(1);
					break;
				case "Nibbler":
					traitComboBox.setSelectedIndex(2);
					break;
				case "Night Owl":
					traitComboBox.setSelectedIndex(3);
					break;
				case "Protected":
					traitComboBox.setSelectedIndex(4);
					break;
				case "Regular":
					traitComboBox.setSelectedIndex(5);
					break;
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
				tfCMName.setText(CM3.getName());
				switch(CM3.getType()) {
				case "Engineer" :
					traitComboBox.setSelectedIndex(0);
					break;
				case "Health Nut":
					traitComboBox.setSelectedIndex(1);
					break;
				case "Nibbler":
					traitComboBox.setSelectedIndex(2);
					break;
				case "Night Owl":
					traitComboBox.setSelectedIndex(3);
					break;
				case "Protected":
					traitComboBox.setSelectedIndex(4);
					break;
				case "Regular":
					traitComboBox.setSelectedIndex(5);
					break;
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
				tfCMName.setText(CM4.getName());
				switch(CM4.getType()) {
				case "Engineer" :
					traitComboBox.setSelectedIndex(0);
					break;
				case "Health Nut":
					traitComboBox.setSelectedIndex(1);
					break;
				case "Nibbler":
					traitComboBox.setSelectedIndex(2);
					break;
				case "Night Owl":
					traitComboBox.setSelectedIndex(3);
					break;
				case "Protected":
					traitComboBox.setSelectedIndex(4);
					break;
				case "Regular":
					traitComboBox.setSelectedIndex(5);
					break;
				}
			}
		});
		tglbtnCM4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM4.setBounds(225, 337, 150, 150);
		frame.getContentPane().add(tglbtnCM4);
		CrewMemberToggleButtons.add(tglbtnCM4);
		
		// The listener for the combo box 
		traitComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblHealthValue_1.setText(currentType.getHealth() + "/" + currentType.getMaxHealth());
				lblHungerValue_1.setText(currentType.getHunger() + "/" + currentType.getMaxHunger());
				lblFatigueValue_1.setText(currentType.getFatigue() + "/" + currentType.getMaxFatigue());
				
			}
		});
		
		
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
		
		JButton btnSave = new JButton("Save Crew Member");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					if (button.isSelected()) {
						if (button.equals(tglbtnCM1)) {
							CM1.setName(tfCMName.getText());
							CM1.setType(((CrewMember) traitComboBox.getSelectedItem()).getType());
						} else if (button.equals(tglbtnCM2)) {
							CM2.setName(tfCMName.getText());
							CM2.setType(((CrewMember) traitComboBox.getSelectedItem()).getType());
						} else if (button.equals(tglbtnCM3)) {
							CM3.setName(tfCMName.getText());
							CM3.setType(((CrewMember) traitComboBox.getSelectedItem()).getType());
						} else if (button.equals(tglbtnCM4)) {
							CM4.setName(tfCMName.getText());
							CM4.setType(((CrewMember) traitComboBox.getSelectedItem()).getType());
						}
					}
				}
			}
		});
		btnSave.setBounds(23, 294, 293, 25);
		panelCrewMember.add(btnSave);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.getCrew().setName(textFieldShipName.getText());
				ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
				switch(slider.getValue()) {
				case 4:
					crewMembers.add(createCrewMember(CM4));
				case 3:
					crewMembers.add(createCrewMember(CM3));
				case 2:
					crewMembers.add(createCrewMember(CM2));
					crewMembers.add(createCrewMember(CM1));
				}
				Collections.reverse(crewMembers);
				game.getCrew().setCrewMembers(crewMembers);
				finishedWindow();
			}
			
			public CrewMember createCrewMember(CrewMember member) {
				switch(member.getType()) {
				case "Engineer":
					return new Engineer(member.getName());
				case "Health Nut":
					return new HealthNut(member.getName());
				case "Nibbler":
					return new Nibbler(member.getName());
				case "Night Owl":
					return new NightOwl(member.getName());
				case "Protected":
					return new Protected(member.getName());
				case "Regular":
					return new Regular(member.getName());
				}
				return null;
			}
		});
		
		
		btnNext.setBounds(624, 506, 114, 25);
		frame.getContentPane().add(btnNext);
		
	}
	
	public void resetToggleButtons() {
		for (JToggleButton button : CrewMemberToggleButtons) {
			button.setSelected(false);
		}
	}
	
}
