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
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.SystemColor;

public class CreateCrewWindow {

	private JFrame frame;
	private JTextField textFieldShipName;
	private GameEnvironment game;
	private JTextField tfCMName;
	private ArrayList<JToggleButton> CrewMemberToggleButtons = new ArrayList<JToggleButton>(); // used to contain all
																								// the toggle buttons
																								// that toggle crew
																								// members

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
		frame.setTitle("SPACE EXPLORERS");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		CrewMember CM1 = new CrewMember("Bill", "Engineer");
		CrewMember CM2 = new CrewMember("Carole", "Health Nut");
		CrewMember CM3 = new CrewMember("Noah", "Nibbler");
		CrewMember CM4 = new CrewMember("Kim", "Night Owl");

		JLabel lblNotify = new JLabel();
		lblNotify.setBounds(373, 489, 360, 25);
		frame.getContentPane().add(lblNotify);

		JPanel panelCrewMember = new JPanel();
		panelCrewMember.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panelCrewMember.setBounds(373, 158, 360, 330);
		frame.getContentPane().add(panelCrewMember);

		panelCrewMember.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(11, 10, 78, 32);
		panelCrewMember.add(lblName);

		JLabel lblTrait = new JLabel("Trait:");
		lblTrait.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTrait.setBounds(11, 52, 78, 32);
		panelCrewMember.add(lblTrait);

		tfCMName = new JTextField("Bill");
		tfCMName.setBounds(80, 10, 236, 32);
		panelCrewMember.add(tfCMName);
		tfCMName.setColumns(10);

		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHealth.setBounds(11, 94, 78, 32);
		panelCrewMember.add(lblHealth);

		JLabel lblHunger = new JLabel("Hunger:\r\n");
		lblHunger.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHunger.setBounds(11, 136, 78, 32);
		panelCrewMember.add(lblHunger);

		JLabel lblFatigue = new JLabel("Fatigue:");
		lblFatigue.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFatigue.setBounds(189, 94, 78, 32);
		panelCrewMember.add(lblFatigue);

		JComboBox cBoxTrait = new JComboBox(game.getCrewMemberTypes().toArray());
		// Get the current selected type of crew member
		CrewMember currentType = (CrewMember) cBoxTrait.getSelectedItem();

		JLabel lblHealthValue_1 = new JLabel(currentType.getHealth() + "/" + currentType.getMaxHealth());
		lblHealthValue_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHealthValue_1.setBounds(100, 94, 78, 32);
		panelCrewMember.add(lblHealthValue_1);

		JLabel lblHungerValue_1 = new JLabel(currentType.getHunger() + "/" + currentType.getMaxHunger());
		lblHungerValue_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHungerValue_1.setBounds(100, 136, 78, 32);
		panelCrewMember.add(lblHungerValue_1);

		JLabel lblFatigueValue_1 = new JLabel(currentType.getFatigue() + "/" + currentType.getMaxFatigue());
		lblFatigueValue_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFatigueValue_1.setBounds(278, 94, 78, 32);
		panelCrewMember.add(lblFatigueValue_1);

		cBoxTrait.setBounds(80, 52, 236, 32);
		panelCrewMember.add(cBoxTrait);

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

		JToggleButton tglbtnCM1 = new JToggleButton("1", true);
		tglbtnCM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
				}
				lblNotify.setText("");
				tglbtnCM1.setSelected(true);
				tfCMName.setText(CM1.getName());
				switch (CM1.getType()) {
				case "Engineer":
					cBoxTrait.setSelectedIndex(0);
					break;
				case "Health Nut":
					cBoxTrait.setSelectedIndex(1);
					break;
				case "Nibbler":
					cBoxTrait.setSelectedIndex(2);
					break;
				case "Night Owl":
					cBoxTrait.setSelectedIndex(3);
					break;
				case "Protected":
					cBoxTrait.setSelectedIndex(4);
					break;
				case "Regular":
					cBoxTrait.setSelectedIndex(5);
					break;
				}
			}
		});
		tglbtnCM1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM1.setBounds(45, 171, 140, 140);
		frame.getContentPane().add(tglbtnCM1);

		CrewMemberToggleButtons.add(tglbtnCM1);

		JToggleButton tglbtnCM2 = new JToggleButton("2");
		tglbtnCM2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
				}
				lblNotify.setText("");
				tglbtnCM2.setSelected(true);
				tfCMName.setText(CM2.getName());
				switch (CM2.getType()) {
				case "Engineer":
					cBoxTrait.setSelectedIndex(0);
					break;
				case "Health Nut":
					cBoxTrait.setSelectedIndex(1);
					break;
				case "Nibbler":
					cBoxTrait.setSelectedIndex(2);
					break;
				case "Night Owl":
					cBoxTrait.setSelectedIndex(3);
					break;
				case "Protected":
					cBoxTrait.setSelectedIndex(4);
					break;
				case "Regular":
					cBoxTrait.setSelectedIndex(5);
					break;
				}
			}
		});
		tglbtnCM2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		tglbtnCM2.setBounds(210, 171, 140, 140);

		frame.getContentPane().add(tglbtnCM2);

		CrewMemberToggleButtons.add(tglbtnCM2);

		JToggleButton tglbtnCM3 = new JToggleButton("3");
		tglbtnCM3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
				}
				lblNotify.setText("");
				tglbtnCM3.setSelected(true);
				tfCMName.setText(CM3.getName());
				switch (CM3.getType()) {
				case "Engineer":
					cBoxTrait.setSelectedIndex(0);
					break;
				case "Health Nut":
					cBoxTrait.setSelectedIndex(1);
					break;
				case "Nibbler":
					cBoxTrait.setSelectedIndex(2);
					break;
				case "Night Owl":
					cBoxTrait.setSelectedIndex(3);
					break;
				case "Protected":
					cBoxTrait.setSelectedIndex(4);
					break;
				case "Regular":
					cBoxTrait.setSelectedIndex(5);
					break;
				}
			}
		});
		tglbtnCM3.setFont(new Font("Tahoma", Font.PLAIN, 20));

		tglbtnCM3.setBounds(45, 335, 140, 140);

		frame.getContentPane().add(tglbtnCM3);

		CrewMemberToggleButtons.add(tglbtnCM3);

		JToggleButton tglbtnCM4 = new JToggleButton("4");
		tglbtnCM4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
				}
				lblNotify.setText("");
				tglbtnCM4.setSelected(true);
				tfCMName.setText(CM4.getName());
				switch (CM4.getType()) {
				case "Engineer":
					cBoxTrait.setSelectedIndex(0);
					break;
				case "Health Nut":
					cBoxTrait.setSelectedIndex(1);
					break;
				case "Nibbler":
					cBoxTrait.setSelectedIndex(2);
					break;
				case "Night Owl":
					cBoxTrait.setSelectedIndex(3);
					break;
				case "Protected":
					cBoxTrait.setSelectedIndex(4);
					break;
				case "Regular":
					cBoxTrait.setSelectedIndex(5);
					break;
				}
			}
		});
		tglbtnCM4.setFont(new Font("Tahoma", Font.PLAIN, 20));

		tglbtnCM4.setBounds(210, 335, 140, 140);

		frame.getContentPane().add(tglbtnCM4);

		CrewMemberToggleButtons.add(tglbtnCM4);

		JTextArea textArea = new JTextArea(currentType.description());
		textArea.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textArea.setBackground(SystemColor.menu);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setLineWrap(true);
		textArea.setBounds(11, 181, 337, 102);
		panelCrewMember.add(textArea);
		textArea.setEditable(false);

		// The listener for the combo box
		cBoxTrait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrewMember currentType = (CrewMember) cBoxTrait.getSelectedItem();
				lblHealthValue_1.setText(currentType.getHealth() + "/" + currentType.getMaxHealth());
				lblHungerValue_1.setText(currentType.getHunger() + "/" + currentType.getMaxHunger());
				lblFatigueValue_1.setText(currentType.getFatigue() + "/" + currentType.getMaxFatigue());
				textArea.setText(currentType.description());
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
				switch (slider.getValue()) {
				case 2:
					tglbtnCM3.setEnabled(false);
					if (tglbtnCM3.isSelected()) {
						tglbtnCM3.setSelected(false);
						tglbtnCM1.doClick();
					}
				case 3:
					tglbtnCM4.setEnabled(false);
					if (tglbtnCM4.isSelected()) {
						tglbtnCM4.setSelected(false);
						tglbtnCM1.doClick();
					}
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
							CM1.setType(((CrewMember) cBoxTrait.getSelectedItem()).getType());
						} else if (button.equals(tglbtnCM2)) {
							CM2.setName(tfCMName.getText());
							CM2.setType(((CrewMember) cBoxTrait.getSelectedItem()).getType());
						} else if (button.equals(tglbtnCM3)) {
							CM3.setName(tfCMName.getText());
							CM3.setType(((CrewMember) cBoxTrait.getSelectedItem()).getType());
						} else if (button.equals(tglbtnCM4)) {
							CM4.setName(tfCMName.getText());
							CM4.setType(((CrewMember) cBoxTrait.getSelectedItem()).getType());
						}
					}
				}
				lblNotify.setText("Crew Member profile saved");
			}
		});
		btnSave.setBounds(11, 292, 337, 25);
		panelCrewMember.add(btnSave);

		JLabel lblActions = new JLabel("Actions:");
		lblActions.setFont(new Font("Dialog", Font.BOLD, 16));
		lblActions.setBounds(189, 136, 78, 32);
		panelCrewMember.add(lblActions);

		JLabel lblActionsValue = new JLabel(currentType.getActionsLeft() + "/" + currentType.getMaxActions());
		lblActionsValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblActionsValue.setBounds(278, 136, 78, 32);
		panelCrewMember.add(lblActionsValue);

		JButton btnNext = new JButton("Finish Crew Creation");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.getShip().setName(textFieldShipName.getText());
				ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
				switch (slider.getValue()) {
				case 4:
					crewMembers.add(game.createCrewMember(CM4));
				case 3:
					crewMembers.add(game.createCrewMember(CM3));
				case 2:
					crewMembers.add(game.createCrewMember(CM2));
					crewMembers.add(game.createCrewMember(CM1));
				}
				Collections.reverse(crewMembers);
				game.getCrew().setCrewMembers(crewMembers);
				finishedWindow();
			}
		});

		btnNext.setBounds(573, 515, 160, 25);

		frame.getContentPane().add(btnNext);

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
				if (textFieldShipName.getText().equals("")) {
					btnNext.setEnabled(false);
				} else {
					btnNext.setEnabled(true);
				}
			}
		});
	}
}
