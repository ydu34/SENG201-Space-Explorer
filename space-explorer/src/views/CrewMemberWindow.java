package views;

import java.awt.EventQueue;
import main.CrewMember;
import main.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
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

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class CrewMemberWindow {

	private JFrame frame;
	private GameEnvironment game;
	private ArrayList<JToggleButton> CrewMemberToggleButtons = new ArrayList<JToggleButton>(); 
	private JLabel lblNameValue;
	private JLabel lblTraitValue;
	private JLabel lblHealthValue;
	private JLabel lblHungerValue;
	private JLabel lblFatigueValue;
	private JLabel lblActionsValue;
	private JLabel lblStatusValue;
	private JTextArea textAreaDescription;
	private JButton btnPerformAction;
	private JToggleButton tglbtnCrewMember1;
	private JToggleButton tglbtnCrewMember2;
	private JToggleButton tglbtnCrewMember3;
	private JToggleButton tglbtnCrewMember4;

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

		JPanel panelProfile = new JPanel();
		panelProfile.setLayout(null);
		panelProfile.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelProfile.setBounds(375, 100, 370, 355);
		frame.getContentPane().add(panelProfile);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(19, 13, 78, 22);
		panelProfile.add(lblName);

		JLabel lblTrait = new JLabel("Trait:");
		lblTrait.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTrait.setBounds(19, 47, 78, 22);
		panelProfile.add(lblTrait);

		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHealth.setBounds(19, 115, 78, 22);
		panelProfile.add(lblHealth);

		JLabel lblHunger = new JLabel("Hunger:\r\n");
		lblHunger.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHunger.setBounds(19, 149, 78, 22);
		panelProfile.add(lblHunger);

		JLabel lblFatigue = new JLabel("Fatigue:");
		lblFatigue.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFatigue.setBounds(193, 115, 78, 22);
		panelProfile.add(lblFatigue);

		textAreaDescription = new JTextArea(game.getCrew().getCrewMembers().get(0).description());
		textAreaDescription.setBackground(SystemColor.menu);
		textAreaDescription.setEditable(false);
		textAreaDescription.setWrapStyleWord(true);
		textAreaDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setBounds(19, 209, 337, 100);
		panelProfile.add(textAreaDescription);

		lblHealthValue = new JLabel();
		lblHealthValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHealthValue.setBounds(106, 115, 78, 22);
		panelProfile.add(lblHealthValue);

		lblHungerValue = new JLabel();
		lblHungerValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHungerValue.setBounds(106, 149, 78, 22);
		panelProfile.add(lblHungerValue);

		lblFatigueValue = new JLabel();
		lblFatigueValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFatigueValue.setBounds(280, 115, 78, 22);
		panelProfile.add(lblFatigueValue);

		lblTraitValue = new JLabel();
		lblTraitValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblTraitValue.setBounds(106, 47, 250, 22);
		panelProfile.add(lblTraitValue);

		lblNameValue = new JLabel();
		lblNameValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNameValue.setBounds(106, 13, 250, 22);
		panelProfile.add(lblNameValue);

		lblStatusValue = new JLabel();
		lblStatusValue.setText((String) null);
		lblStatusValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblStatusValue.setBounds(106, 81, 250, 22);
		panelProfile.add(lblStatusValue);

		lblActionsValue = new JLabel();
		lblActionsValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblActionsValue.setBounds(280, 149, 78, 22);
		panelProfile.add(lblActionsValue);

		// The default selected crew member when first entering the window
		CrewMember crewMember = game.getCrew().getCrewMembers().get(0);
		lblNameValue.setText(crewMember.getName());
		lblTraitValue.setText(crewMember.getType());
		lblHealthValue.setText(crewMember.getHealth() + "/" + crewMember.getMaxHealth());
		lblHungerValue.setText(crewMember.getHunger() + "/" + crewMember.getMaxHunger());
		lblFatigueValue.setText(crewMember.getFatigue() + "/" + crewMember.getMaxFatigue());
		lblStatusValue.setText(crewMember.getStatus());
		lblActionsValue.setText(crewMember.getActionsLeft() + "/" + crewMember.getMaxActions());
		textAreaDescription.setText(crewMember.description());

		JLabel lblActions = new JLabel("Actions");
		lblActions.setFont(new Font("Dialog", Font.BOLD, 16));
		lblActions.setBounds(193, 149, 78, 22);
		panelProfile.add(lblActions);

		btnPerformAction = new JButton("Perform Action");
		btnPerformAction.setBounds(19, 321, 337, 25);
		panelProfile.add(btnPerformAction);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Dialog", Font.BOLD, 16));
		lblStatus.setBounds(19, 81, 78, 22);
		panelProfile.add(lblStatus);

		JLabel lblDescription = new JLabel("Description:\r\n");
		lblDescription.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDescription.setBounds(19, 183, 165, 22);
		panelProfile.add(lblDescription);
		btnPerformAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JDialog actions = new ActionsDialog(frame, "Space Explorers", game, window);
				actions.setVisible(true);
			}
		});
		game.setChosenCrewMember(crewMember);
		if (crewMember.isAvailable()) {
			btnPerformAction.setEnabled(true);
		} else {
			btnPerformAction.setEnabled(false);
		}

		tglbtnCrewMember2 = new JToggleButton("");
		tglbtnCrewMember2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
					button.setBorder(null);
				}
				CrewMember crewMember = game.getCrew().getCrewMembers().get(1);
				Border solidBorder = new MatteBorder(4, 4, 4, 4, Color.green);
				tglbtnCrewMember2.setBorder(solidBorder);
				tglbtnCrewMember2.setSelected(true);
				updateProfile(crewMember);
			}
		});

		tglbtnCrewMember1 = new JToggleButton("", true);
		tglbtnCrewMember1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
					button.setBorder(null);
				}
				CrewMember crewMember = game.getCrew().getCrewMembers().get(0);
				Border solidBorder = new MatteBorder(4, 4, 4, 4, Color.green);
				tglbtnCrewMember1.setBorder(solidBorder);
				tglbtnCrewMember1.setSelected(true);
				updateProfile(crewMember);
			}
		});
		tglbtnCrewMember1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCrewMember1.setBounds(50, 130, 140, 140);
		frame.getContentPane().add(tglbtnCrewMember1);

		tglbtnCrewMember2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCrewMember2.setBounds(210, 130, 140, 140);
		frame.getContentPane().add(tglbtnCrewMember2);

		tglbtnCrewMember3 = new JToggleButton("");

		tglbtnCrewMember3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
					button.setBorder(null);
				}
				CrewMember crewMember = game.getCrew().getCrewMembers().get(2);
				Border solidBorder = new MatteBorder(4, 4, 4, 4, Color.green);
				tglbtnCrewMember3.setBorder(solidBorder);
				tglbtnCrewMember3.setSelected(true);
				updateProfile(crewMember);
			}
		});
		tglbtnCrewMember3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCrewMember3.setBounds(50, 290, 140, 140);
		frame.getContentPane().add(tglbtnCrewMember3);

		tglbtnCrewMember4 = new JToggleButton("");
		tglbtnCrewMember4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
					button.setBorder(null);
				}
				CrewMember crewMember = game.getCrew().getCrewMembers().get(3);
				Border solidBorder = new MatteBorder(4, 4, 4, 4, Color.green);
				tglbtnCrewMember4.setBorder(solidBorder);
				tglbtnCrewMember4.setSelected(true);
				updateProfile(crewMember);
			}
		});
		tglbtnCrewMember4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCrewMember4.setBounds(210, 290, 140, 140);
		frame.getContentPane().add(tglbtnCrewMember4);

		JLabel lblWindowTitle = new JLabel("The Crew Lobby!");
		lblWindowTitle.setFont(new Font("Dialog", Font.BOLD, 30));
		lblWindowTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblWindowTitle.setBounds(0, 0, 795, 60);
		frame.getContentPane().add(lblWindowTitle);

		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(50, 62, 695, 2);
		frame.getContentPane().add(separatorTop);

		JSeparator separatorBottom = new JSeparator();
		separatorBottom.setBounds(50, 503, 695, 2);
		frame.getContentPane().add(separatorBottom);

		// Add all the toggle buttons that toggle crew members into the array list for
		// better management of them
		switch (game.getCrew().getCrewMembers().size()) {
		case 4:
			CrewMemberToggleButtons.add(tglbtnCrewMember4);
		case 3:
			CrewMemberToggleButtons.add(tglbtnCrewMember3);
		case 2:
			CrewMemberToggleButtons.add(tglbtnCrewMember2);
		case 1:
			CrewMemberToggleButtons.add(tglbtnCrewMember1);
		}

		// Disable Buttons for dead members or members that don't exit.
		switch (game.getCrew().getCrewMembers().size()) {
		case 0:
			tglbtnCrewMember1.setEnabled(false);
		case 1:
			tglbtnCrewMember2.setEnabled(false);
		case 2:
			tglbtnCrewMember3.setEnabled(false);
		case 3:
			tglbtnCrewMember4.setEnabled(false);
		}
		
		initImages();
	}
	
	public void initImages() {
		switch (game.getCrew().getCrewMembers().size()) {
		case 4:
			tglbtnCrewMember4.setIcon(new ImageIcon(CrewMemberWindow.class.getResource(game.getCrew().getCrewMembers().get(3).getImage())));
		case 3:
			tglbtnCrewMember3.setIcon(new ImageIcon(CrewMemberWindow.class.getResource(game.getCrew().getCrewMembers().get(2).getImage())));
		case 2:
			tglbtnCrewMember2.setIcon(new ImageIcon(CrewMemberWindow.class.getResource(game.getCrew().getCrewMembers().get(1).getImage())));
		case 1:
			tglbtnCrewMember1.setIcon(new ImageIcon(CrewMemberWindow.class.getResource(game.getCrew().getCrewMembers().get(0).getImage())));
		}
	}

	public void updateProfile(CrewMember crewMember) {
		
		lblNameValue.setText(crewMember.getName());
		lblTraitValue.setText(crewMember.getType());
		lblHealthValue.setText(crewMember.getHealth() + "/" + crewMember.getMaxHealth());
		lblHungerValue.setText(crewMember.getHunger() + "/" + crewMember.getMaxHunger());
		lblFatigueValue.setText(crewMember.getFatigue() + "/" + crewMember.getMaxFatigue());
		lblActionsValue.setText(crewMember.getActionsLeft() + "/" + crewMember.getMaxActions());
		lblStatusValue.setText(crewMember.getStatus());
		textAreaDescription.setText(crewMember.description());
		game.setChosenCrewMember(crewMember);
		if (crewMember.isAvailable()) {
			btnPerformAction.setEnabled(true);
		} else {
			btnPerformAction.setEnabled(false);
		}
		if (game.gameOver()) {
			finishedWindow();
			game.launchGameOverWindow();
		}
	}
}
