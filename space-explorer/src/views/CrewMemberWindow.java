package views;

import java.awt.EventQueue;
import main.CrewMember;
import main.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class CrewMemberWindow {

	private JFrame frame;
	private GameEnvironment game;
	private ArrayList<JToggleButton> CrewMemberToggleButtons = new ArrayList<JToggleButton>(); // used to contain all the toggle buttons that toggle crew members

	/**
	 * Create the application.
	 */
	public CrewMemberWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeCrewMemberWindow(this);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CrewMemberWindow window = this;
		frame = new JFrame();
		frame.setTitle("SPACE EXPLORERS");
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchMainWindow();
			}
		});
		btnBack.setBounds(590, 527, 154, 25);
		frame.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(375, 100, 370, 355);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(19, 13, 78, 22);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Trait:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		label_1.setBounds(19, 47, 78, 22);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Health:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 16));
		label_2.setBounds(19, 115, 78, 22);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Hunger:\r\n");
		label_3.setFont(new Font("Dialog", Font.BOLD, 16));
		label_3.setBounds(19, 149, 78, 22);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Fatigue:");
		label_4.setFont(new Font("Dialog", Font.BOLD, 16));
		label_4.setBounds(193, 115, 78, 22);
		panel.add(label_4);
		
		JTextArea textArea = new JTextArea(game.getCrew().getCrewMembers().get(0).description());
		textArea.setBackground(SystemColor.menu);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setLineWrap(true);
		textArea.setBounds(19, 209, 337, 100);
		panel.add(textArea);
		
		JLabel lblHealthValue = new JLabel();
		lblHealthValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHealthValue.setBounds(106, 115, 78, 22);
		panel.add(lblHealthValue);
		
		JLabel lblHungerValue = new JLabel();
		lblHungerValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHungerValue.setBounds(106, 149, 78, 22);
		panel.add(lblHungerValue);
		
		JLabel lblFatigueValue = new JLabel();
		lblFatigueValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFatigueValue.setBounds(280, 115, 78, 22);
		panel.add(lblFatigueValue);
		
		JLabel lblTraitValue = new JLabel();
		lblTraitValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblTraitValue.setBounds(106, 47, 250, 22);
		panel.add(lblTraitValue);
		
		JLabel lblNameValue = new JLabel();
		lblNameValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNameValue.setBounds(106, 13, 250, 22);
		panel.add(lblNameValue);
		
		JLabel lblStatusValue = new JLabel();
		lblStatusValue.setText((String) null);
		lblStatusValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblStatusValue.setBounds(106, 81, 250, 22);
		panel.add(lblStatusValue);
		
		// The default selected crew member when first entering the window
		CrewMember member = game.getCrew().getCrewMembers().get(0);
		lblNameValue.setText(member.getName());
		lblTraitValue.setText(member.getType());
		lblHealthValue.setText(member.getHealth() + "/" + member.getMaxHealth());
		lblHungerValue.setText(member.getHunger() + "/" + member.getMaxHunger());
		lblFatigueValue.setText(member.getFatigue() + "/" + member.getMaxFatigue());
		lblStatusValue.setText(member.getStatus());
		textArea.setText(member.description());
		
		
		
		
		JLabel lblActions = new JLabel("Actions");
		lblActions.setFont(new Font("Dialog", Font.BOLD, 16));
		lblActions.setBounds(193, 149, 78, 22);
		panel.add(lblActions);
		
		JLabel lblActionsValue = new JLabel(member.getActionsLeft() + "/" + member.getMaxActions());
		lblActionsValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblActionsValue.setBounds(280, 149, 78, 22);
		panel.add(lblActionsValue);
		
		JButton btnPerformAction = new JButton("Perform Action");
		btnPerformAction.setBounds(19, 321, 337, 25);
		panel.add(btnPerformAction);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Dialog", Font.BOLD, 16));
		lblStatus.setBounds(19, 81, 78, 22);
		panel.add(lblStatus);
		
		JLabel lblDescription = new JLabel("Description:\r\n");
		lblDescription.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDescription.setBounds(19, 183, 165, 22);
		panel.add(lblDescription);
		btnPerformAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JDialog actions = new ActionsDialog(frame, "Space Explorers", game, window);
				actions.setVisible(true);
			}
		});
		game.setChosenCrewMember(member);
		if (member.isAvailable()) {
			btnPerformAction.setEnabled(true);
		} else {
			btnPerformAction.setEnabled(false);
		}
		
		JToggleButton tglbtnCM2 = new JToggleButton("2");
		tglbtnCM2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
				}
				tglbtnCM2.setSelected(true);
				CrewMember member = game.getCrew().getCrewMembers().get(1);
				lblNameValue.setText(member.getName());
				lblTraitValue.setText(member.getType());
				lblHealthValue.setText(member.getHealth() + "/" + member.getMaxHealth());
				lblHungerValue.setText(member.getHunger() + "/" + member.getMaxHunger());
				lblFatigueValue.setText(member.getFatigue() + "/" + member.getMaxFatigue());
				lblActionsValue.setText(member.getActionsLeft() + "/" + member.getMaxActions());
				lblStatusValue.setText(member.getStatus());
				textArea.setText(member.description());
				game.setChosenCrewMember(member);
				if (member.isAvailable()) {
					btnPerformAction.setEnabled(true);
				} else {
					btnPerformAction.setEnabled(false);
				}
			}
		});
		
		JToggleButton tglbtnCM1 = new JToggleButton("1", true);
		tglbtnCM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
				}
				tglbtnCM1.setSelected(true);
				// Since tglbtnCM1 represents the first Crew Member it will get the 0th index of CrewMembers
				CrewMember member = game.getCrew().getCrewMembers().get(0);
				lblNameValue.setText(member.getName());
				lblTraitValue.setText(member.getType());
				lblHealthValue.setText(member.getHealth() + "/" + member.getMaxHealth());
				lblHungerValue.setText(member.getHunger() + "/" + member.getMaxHunger());
				lblFatigueValue.setText(member.getFatigue() + "/" + member.getMaxFatigue());
				lblActionsValue.setText(member.getActionsLeft() + "/" + member.getMaxActions());
				lblStatusValue.setText(member.getStatus());
				textArea.setText(member.description());
				game.setChosenCrewMember(member);
				if (member.isAvailable()) {
					btnPerformAction.setEnabled(true);
				} else {
					btnPerformAction.setEnabled(false);
				}
			}
		});
		tglbtnCM1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM1.setBounds(50, 130, 140, 140);
		frame.getContentPane().add(tglbtnCM1);
		
	
		
		
		tglbtnCM2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM2.setBounds(210, 130, 140, 140);
		frame.getContentPane().add(tglbtnCM2);
		
		JToggleButton tglbtnCM3 = new JToggleButton("3");
		tglbtnCM3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
				}
				tglbtnCM3.setSelected(true);
				CrewMember member = game.getCrew().getCrewMembers().get(2);
				lblNameValue.setText(member.getName());
				lblTraitValue.setText(member.getType());
				lblHealthValue.setText(member.getHealth() + "/" + member.getMaxHealth());
				lblHungerValue.setText(member.getHunger() + "/" + member.getMaxHunger());
				lblFatigueValue.setText(member.getFatigue() + "/" + member.getMaxFatigue());
				lblActionsValue.setText(member.getActionsLeft() + "/" + member.getMaxActions());
				lblStatusValue.setText(member.getStatus());
				textArea.setText(member.description());
				game.setChosenCrewMember(member);
				if (member.isAvailable()) {
					btnPerformAction.setEnabled(true);
				} else {
					btnPerformAction.setEnabled(false);
				}
			}
		});
		tglbtnCM3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM3.setBounds(50, 290, 140, 140);
		frame.getContentPane().add(tglbtnCM3);
		
		JToggleButton tglbtnCM4 = new JToggleButton("4");
		tglbtnCM4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
				}
				tglbtnCM4.setSelected(true);
				CrewMember member = game.getCrew().getCrewMembers().get(3);
				lblNameValue.setText(member.getName());
				lblTraitValue.setText(member.getType());
				lblHealthValue.setText(member.getHealth() + "/" + member.getMaxHealth());
				lblHungerValue.setText(member.getHunger() + "/" + member.getMaxHunger());
				lblFatigueValue.setText(member.getFatigue() + "/" + member.getMaxFatigue());
				lblActionsValue.setText(member.getActionsLeft() + "/" + member.getMaxActions());
				lblStatusValue.setText(member.getStatus());
				textArea.setText(member.description());
				game.setChosenCrewMember(member);
				if (member.isAvailable()) {
					btnPerformAction.setEnabled(true);
				} else {
					btnPerformAction.setEnabled(false);
				}
			}
		});
		tglbtnCM4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM4.setBounds(210, 290, 140, 140);
		frame.getContentPane().add(tglbtnCM4);
		
		
		JLabel lblNewLabel = new JLabel("The Crew Lobby!");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 795, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(50, 62, 695, 2);
		frame.getContentPane().add(separatorTop);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 503, 695, 2);
		frame.getContentPane().add(separator);
		
		// Add all the toggle buttons that toggle crew members into the array list for better management of them
		switch(game.getCrew().getCrewMembers().size()) {
		case 4:
			CrewMemberToggleButtons.add(tglbtnCM4);
		case 3:
			CrewMemberToggleButtons.add(tglbtnCM3);
		case 2:
			CrewMemberToggleButtons.add(tglbtnCM2);
		case 1:
			CrewMemberToggleButtons.add(tglbtnCM1);
		}
		
		// Disable Buttons for dead members or members that don't exit.
		switch(game.getCrew().getCrewMembers().size()) {
		case 0:
			tglbtnCM1.setEnabled(false);
		case 1:
			tglbtnCM2.setEnabled(false);
		case 2: 
			tglbtnCM3.setEnabled(false);
		case 3: 
			tglbtnCM4.setEnabled(false);
		}
		
	}
}
