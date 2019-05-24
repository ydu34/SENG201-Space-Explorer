package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import main.CrewMember;
import main.GameEnvironment;
import javax.swing.JSeparator;

/**
 * Represents a window that allows players to select the pilots.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class SelectPilotWindow {

	private JFrame frame;
	private GameEnvironment game;
	private CrewMember pilot1;
	private CrewMember pilot2;
	private JButton btnSelectPlanet;

	/**
	 * Creates the window application.
	 * 
	 * @param incomingGame A GameEnvironment containing all the contents of the
	 *                     game.
	 */
	public SelectPilotWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Calls the close window method in game environment.
	 */
	public void finishedWindow() {
		game.closeSelectPilotWindow(this);
	}

	/**
	 * Initializes the contents of the frame. This includes a panel displaying the
	 * cost of piloting the ship to the crew members, two combo boxes to select main
	 * pilot and co-pilot, a panel to display the selected crew member's details,
	 * and buttons to proceed selecting a new planet or return to actions window.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox comboBoxPilot2 = new JComboBox(game.getCrew().getCrewMembers().toArray());
		for (int i = 0; (comboBoxPilot2.getSelectedItem() == game.getChosenCrewMember()); i++) {
			comboBoxPilot2.setSelectedIndex(i);
		}

		JComboBox comboBoxPilot1 = new JComboBox(game.getCrew().getCrewMembers().toArray());

		// The two selected pilots initially set.
		pilot1 = game.getChosenCrewMember();
		pilot2 = (CrewMember) comboBoxPilot2.getSelectedItem();
		game.setChosenCrewMember(pilot1);
		game.setOtherChosenCrewMember(pilot2);

		JTextArea textAreaPilotInfo = new JTextArea();
		textAreaPilotInfo.setBackground(UIManager.getColor("Menu.background"));
		textAreaPilotInfo.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(10, 10, 10, 10)));
		String info = pilotInfo(pilot1, pilot2);
		textAreaPilotInfo.setText(info);
		textAreaPilotInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textAreaPilotInfo.setWrapStyleWord(true);
		textAreaPilotInfo.setLineWrap(true);
		textAreaPilotInfo.setEditable(false);
		textAreaPilotInfo.setBounds(50, 85, 296, 398);
		frame.getContentPane().add(textAreaPilotInfo);

		comboBoxPilot1.setSelectedItem(game.getChosenCrewMember());
		comboBoxPilot1.setBounds(510, 86, 235, 22);
		frame.getContentPane().add(comboBoxPilot1);
		comboBoxPilot2.setBounds(510, 112, 235, 22);
		frame.getContentPane().add(comboBoxPilot2);

		JButton btnReturn = new JButton("Return ");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		btnReturn.setBounds(50, 515, 97, 25);
		frame.getContentPane().add(btnReturn);

		JPanel panelCrewMemberInfo = new JPanel();
		panelCrewMemberInfo.setLayout(null);
		panelCrewMemberInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCrewMemberInfo.setBounds(385, 141, 360, 343);
		frame.getContentPane().add(panelCrewMemberInfo);

		JLabel lblNameText = new JLabel("Name:");
		lblNameText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNameText.setBounds(19, 12, 78, 32);
		panelCrewMemberInfo.add(lblNameText);

		JLabel lblTraitText = new JLabel("Trait:");
		lblTraitText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTraitText.setBounds(19, 55, 78, 32);
		panelCrewMemberInfo.add(lblTraitText);

		JLabel lblHealthText = new JLabel("Health:");
		lblHealthText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHealthText.setBounds(19, 141, 78, 32);
		panelCrewMemberInfo.add(lblHealthText);

		JLabel lblHungerText = new JLabel("Hunger:\r\n");
		lblHungerText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHungerText.setBounds(19, 184, 78, 32);
		panelCrewMemberInfo.add(lblHungerText);

		JLabel lblFatigueText = new JLabel("Fatigue:");
		lblFatigueText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFatigueText.setBounds(193, 141, 78, 32);
		panelCrewMemberInfo.add(lblFatigueText);

		JTextArea textAreaDescription = new JTextArea(pilot1.description());
		textAreaDescription.setBackground(UIManager.getColor("Menu.background"));
		textAreaDescription.setWrapStyleWord(true);
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textAreaDescription.setEditable(false);
		textAreaDescription.setBounds(19, 226, 327, 102);
		panelCrewMemberInfo.add(textAreaDescription);

		JLabel lblHealthValue = new JLabel(pilot1.getHealth() + "/" + pilot1.getMaxHealth());
		lblHealthValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHealthValue.setBounds(106, 141, 78, 32);
		panelCrewMemberInfo.add(lblHealthValue);

		JLabel lblHungerValue = new JLabel(pilot1.getHunger() + "/" + pilot1.getMaxHunger());
		lblHungerValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHungerValue.setBounds(106, 184, 78, 32);
		panelCrewMemberInfo.add(lblHungerValue);

		JLabel lblFatigueValue = new JLabel(pilot1.getFatigue() + "/" + pilot1.getMaxFatigue());
		lblFatigueValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFatigueValue.setBounds(280, 141, 78, 32);
		panelCrewMemberInfo.add(lblFatigueValue);

		JLabel lblTraitValue = new JLabel(pilot1.getType());
		lblTraitValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblTraitValue.setBounds(106, 55, 250, 32);
		panelCrewMemberInfo.add(lblTraitValue);

		JLabel lblNameValue = new JLabel(pilot1.getName());
		lblNameValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNameValue.setBounds(106, 12, 250, 32);
		panelCrewMemberInfo.add(lblNameValue);

		JLabel lblStatusValue = new JLabel(pilot1.getStatus());
		lblStatusValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblStatusValue.setBounds(106, 98, 250, 32);
		panelCrewMemberInfo.add(lblStatusValue);

		JLabel lblActions = new JLabel("Actions");
		lblActions.setFont(new Font("Dialog", Font.BOLD, 16));
		lblActions.setBounds(193, 184, 78, 32);
		panelCrewMemberInfo.add(lblActions);

		JLabel lblActionsValue = new JLabel(pilot1.getActionsLeft() + "/" + pilot1.getMaxActions());
		lblActionsValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblActionsValue.setBounds(280, 184, 78, 32);
		panelCrewMemberInfo.add(lblActionsValue);

		JLabel lblStatusText = new JLabel("Status:");
		lblStatusText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblStatusText.setBounds(19, 98, 78, 32);
		panelCrewMemberInfo.add(lblStatusText);

		JLabel lblPilot2Text = new JLabel("Pilot 2:");
		lblPilot2Text.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPilot2Text.setBounds(395, 115, 93, 22);
		frame.getContentPane().add(lblPilot2Text);

		JLabel lblPilot1Text = new JLabel("Pilot 1:");
		lblPilot1Text.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPilot1Text.setBounds(395, 85, 93, 22);
		frame.getContentPane().add(lblPilot1Text);

		JLabel lblWindowTitle = new JLabel("Preparation to travel!");
		lblWindowTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWindowTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindowTitle.setBounds(0, 0, 794, 60);
		frame.getContentPane().add(lblWindowTitle);

		JButton btnSelectPlanet_1 = new JButton("Select Planet");
		btnSelectPlanet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pilot2.canPilot() && pilot1.canPilot()) {
					game.setChosenCrewMember(pilot1);
					game.setOtherChosenCrewMember(pilot2);
					finishedWindow();
					game.launchSelectPlanetWindow();
				} else if (!(pilot1.canPilot()) && !(pilot2.canPilot())) {
					String message = pilot1 + " and " + pilot2
							+ " does not have the required actions, fatigue, or hunger to pilot!";
					JOptionPane.showMessageDialog(frame, message);
				} else if (!(pilot2.canPilot())) {
					String message = pilot2 + " does not have the required actions, fatigue, or hunger to pilot!";
					JOptionPane.showMessageDialog(frame, message);
				} else if (!(pilot1.canPilot())) {
					String message = pilot1 + " does not have the required actions, fatigue, or hunger to pilot!";
					JOptionPane.showMessageDialog(frame, message);
				}
			}
		});
		btnSelectPlanet_1.setBounds(580, 515, 165, 25);
		frame.getContentPane().add(btnSelectPlanet_1);
		
		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(50, 62, 695, 2);
		frame.getContentPane().add(separatorTop);
		
		JSeparator separatorBottom = new JSeparator();
		separatorBottom.setBounds(50, 503, 695, 2);
		frame.getContentPane().add(separatorBottom);

		// combo box 1 action listener for pilot 1
		comboBoxPilot1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pilot1 = (CrewMember) comboBoxPilot1.getSelectedItem();
				lblNameValue.setText(pilot1.getName());
				lblTraitValue.setText(pilot1.getType());
				lblHealthValue.setText(pilot1.getHealth() + "/" + pilot1.getMaxHealth());
				lblHungerValue.setText(pilot1.getHunger() + "/" + pilot1.getMaxHunger());
				lblFatigueValue.setText(pilot1.getFatigue() + "/" + pilot1.getMaxFatigue());
				lblActionsValue.setText(pilot1.getActionsLeft() + "/" + pilot1.getMaxActions());
				lblStatusValue.setText(pilot1.getStatus());
				textAreaDescription.setText(pilot1.description());
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
		comboBoxPilot2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pilot2 = (CrewMember) comboBoxPilot2.getSelectedItem();
				lblNameValue.setText(pilot2.getName());
				lblTraitValue.setText(pilot2.getType());
				lblHealthValue.setText(pilot2.getHealth() + "/" + pilot2.getMaxHealth());
				lblHungerValue.setText(pilot2.getHunger() + "/" + pilot2.getMaxHunger());
				lblFatigueValue.setText(pilot2.getFatigue() + "/" + pilot2.getMaxFatigue());
				lblActionsValue.setText(pilot2.getActionsLeft() + "/" + pilot2.getMaxActions());
				lblStatusValue.setText(pilot2.getStatus());
				textAreaDescription.setText(pilot2.description());
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

	/**
	 * Creates the display text of the conditions and costs to pilot.
	 * 
	 * @param pilot1 A CrewMember that is the first pilot.
	 * @param pilot2 A CrewMember that is the second pilot.
	 * @return Information on the requirements of piloting the ship.
	 */
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
