package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import main.CrewMember;
import main.GameEnvironment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectPilotWindow {

	private JFrame frame;
	private GameEnvironment game;
	private CrewMember pilot1;
	private CrewMember pilot2;
	private JButton btnSelectPlanet;

	/**
	 * Create the application.
	 */
	public SelectPilotWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		game.closeSelectPilotWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox cBoxPilot2 = new JComboBox(game.getCrew().getCrewMembers().toArray());
		for (int i = 0; (cBoxPilot2.getSelectedItem() == game.getChosenCrewMember()); i++) {
			cBoxPilot2.setSelectedIndex(i);
		}

		JComboBox cBoxPilot1 = new JComboBox(game.getCrew().getCrewMembers().toArray());

		// The two selected pilots initially set.
		pilot1 = game.getChosenCrewMember();
		pilot2 = (CrewMember) cBoxPilot2.getSelectedItem();
		game.setChosenCrewMember(pilot1);
		game.setOtherChosenCrewMember(pilot2);

		JTextArea textAreaPilotInfo = new JTextArea();
		String info = pilotInfo(pilot1, pilot2);
		textAreaPilotInfo.setText(info);
		textAreaPilotInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textAreaPilotInfo.setWrapStyleWord(true);
		textAreaPilotInfo.setLineWrap(true);
		textAreaPilotInfo.setEditable(false);
		textAreaPilotInfo.setBounds(45, 109, 287, 351);
		frame.getContentPane().add(textAreaPilotInfo);

		cBoxPilot1.setSelectedItem(game.getChosenCrewMember());
		cBoxPilot1.setBounds(492, 85, 235, 22);
		frame.getContentPane().add(cBoxPilot1);
		cBoxPilot2.setBounds(492, 111, 235, 22);
		frame.getContentPane().add(cBoxPilot2);

		JButton btnNewButton = new JButton("Return ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		btnNewButton.setBounds(45, 515, 97, 25);
		frame.getContentPane().add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(367, 140, 360, 343);
		frame.getContentPane().add(panel);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(9, 11, 78, 32);
		panel.add(lblName);

		JLabel lblTrait = new JLabel("Trait:");
		lblTrait.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTrait.setBounds(9, 54, 78, 32);
		panel.add(lblTrait);

		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHealth.setBounds(9, 140, 78, 32);
		panel.add(lblHealth);

		JLabel lblHunger = new JLabel("Hunger:\r\n");
		lblHunger.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHunger.setBounds(9, 183, 78, 32);
		panel.add(lblHunger);

		JLabel lblFatigue = new JLabel("Fatigue:");
		lblFatigue.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFatigue.setBounds(183, 140, 78, 32);
		panel.add(lblFatigue);

		JTextArea textArea = new JTextArea(pilot1.description());
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBounds(9, 226, 337, 102);
		panel.add(textArea);

		JLabel lblHealthValue = new JLabel(pilot1.getHealth() + "/" + pilot1.getMaxHealth());
		lblHealthValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHealthValue.setBounds(96, 140, 78, 32);
		panel.add(lblHealthValue);

		JLabel lblHungerValue = new JLabel(pilot1.getHunger() + "/" + pilot1.getMaxHunger());
		lblHungerValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHungerValue.setBounds(96, 183, 78, 32);
		panel.add(lblHungerValue);

		JLabel lblFatigueValue = new JLabel(pilot1.getFatigue() + "/" + pilot1.getMaxFatigue());
		lblFatigueValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFatigueValue.setBounds(270, 140, 78, 32);
		panel.add(lblFatigueValue);

		JLabel lblTraitValue = new JLabel(pilot1.getType());
		lblTraitValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblTraitValue.setBounds(96, 54, 250, 32);
		panel.add(lblTraitValue);

		JLabel lblNameValue = new JLabel(pilot1.getName());
		lblNameValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNameValue.setBounds(96, 11, 250, 32);
		panel.add(lblNameValue);

		JLabel lblStatusValue = new JLabel(pilot1.getStatus());
		lblStatusValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblStatusValue.setBounds(96, 97, 250, 32);
		panel.add(lblStatusValue);

		JLabel lblActions = new JLabel("Actions");
		lblActions.setFont(new Font("Dialog", Font.BOLD, 16));
		lblActions.setBounds(183, 183, 78, 32);
		panel.add(lblActions);

		JLabel lblActionsValue = new JLabel(pilot1.getActionsLeft() + "/" + pilot1.getMaxActions());
		lblActionsValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblActionsValue.setBounds(270, 183, 78, 32);
		panel.add(lblActionsValue);

		JLabel label_13 = new JLabel("Status:");
		label_13.setFont(new Font("Dialog", Font.BOLD, 16));
		label_13.setBounds(9, 97, 78, 32);
		panel.add(label_13);

		JLabel lblNewLabel = new JLabel("Copilot:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(377, 114, 93, 22);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblMainPilot = new JLabel("Main Pilot:\r\n");
		lblMainPilot.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMainPilot.setBounds(377, 84, 93, 22);
		frame.getContentPane().add(lblMainPilot);

		JLabel lblPreparationToTravel = new JLabel("Preparation to travel!");
		lblPreparationToTravel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPreparationToTravel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreparationToTravel.setBounds(45, 0, 681, 71);
		frame.getContentPane().add(lblPreparationToTravel);

		JButton btnSelectPlanet_1 = new JButton("Select Planet");
		btnSelectPlanet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pilot2.canPilot()) {
					game.setChosenCrewMember(pilot1);
					game.setOtherChosenCrewMember(pilot2);
					finishedWindow();
					game.launchPilotWindow();
				} else {
					String message = pilot2 + " does not have the required actions, fatigue, or hunger to pilot!";
					JOptionPane.showMessageDialog(frame, message);
				}
			}
		});
		btnSelectPlanet_1.setBounds(562, 515, 165, 25);
		frame.getContentPane().add(btnSelectPlanet_1);

		// combo box 1 action listener for pilot 1
		cBoxPilot1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pilot1 = (CrewMember) cBoxPilot1.getSelectedItem();
				lblNameValue.setText(pilot1.getName());
				lblTraitValue.setText(pilot1.getType());
				lblHealthValue.setText(pilot1.getHealth() + "/" + pilot1.getMaxHealth());
				lblHungerValue.setText(pilot1.getHunger() + "/" + pilot1.getMaxHunger());
				lblFatigueValue.setText(pilot1.getFatigue() + "/" + pilot1.getMaxFatigue());
				lblActionsValue.setText(pilot1.getActionsLeft() + "/" + pilot1.getMaxActions());
				lblStatusValue.setText(pilot1.getStatus());
				textArea.setText(pilot1.description());
				if (pilot1.equals(pilot2)) {
					btnSelectPlanet_1.setEnabled(false);
				} else {
					btnSelectPlanet_1.setEnabled(true);
				}
				String info = pilotInfo(pilot1, pilot2);
				textAreaPilotInfo.setText(info);
			}
		});

		// combo box 2 action listener for pilot 2
		cBoxPilot2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pilot2 = (CrewMember) cBoxPilot2.getSelectedItem();
				lblNameValue.setText(pilot2.getName());
				lblTraitValue.setText(pilot2.getType());
				lblHealthValue.setText(pilot2.getHealth() + "/" + pilot2.getMaxHealth());
				lblHungerValue.setText(pilot2.getHunger() + "/" + pilot2.getMaxHunger());
				lblFatigueValue.setText(pilot2.getFatigue() + "/" + pilot2.getMaxFatigue());
				lblActionsValue.setText(pilot2.getActionsLeft() + "/" + pilot2.getMaxActions());
				lblStatusValue.setText(pilot2.getStatus());
				textArea.setText(pilot2.description());
				if (pilot1.equals(pilot2)) {
					btnSelectPlanet_1.setEnabled(false);
				} else {
					btnSelectPlanet_1.setEnabled(true);
				}
				String info = pilotInfo(pilot1, pilot2);
				textAreaPilotInfo.setText(info);
			}
		});
	}

	public String pilotInfo(CrewMember pilot1, CrewMember pilot2) {
		String info;
		if (pilot1.equals(pilot2)) {
			info = "The two crew members can not be the same.";
		} else {
			info = "Traveling to another planet requires two crew members to pilot the ship. "
					+ "\n\nBoth crew members must have 1 action remaining to pilot.\n\n" + pilot1
					+ "'s fatigue will increase by " + pilot1.getPilotFatigueCost() + " and hunger will increase by "
					+ pilot1.getPilotHungerCost() + ".\n\n" + pilot2 + "'s fatigue will increase by "
					+ pilot2.getPilotFatigueCost() + " and hunger will increase by " + pilot2.getPilotHungerCost();
		}
		return info;
	}
}
