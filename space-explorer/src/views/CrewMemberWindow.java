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
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPerformAction = new JButton("Perform Action");
		btnPerformAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog actions = new JDialog(frame);
				actions.setVisible(true);
			}
		});
		btnPerformAction.setBounds(542, 504, 202, 25);
		frame.getContentPane().add(btnPerformAction);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setBounds(52, 504, 202, 25);
		frame.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(416, 118, 328, 329);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(23, 10, 78, 32);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Trait:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 16));
		label_1.setBounds(23, 52, 78, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Health:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 16));
		label_2.setBounds(23, 94, 78, 32);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Hunger:\r\n");
		label_3.setFont(new Font("Dialog", Font.BOLD, 16));
		label_3.setBounds(23, 136, 78, 32);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Fatigue:");
		label_4.setFont(new Font("Dialog", Font.BOLD, 16));
		label_4.setBounds(23, 178, 78, 32);
		panel.add(label_4);
		
		JTextArea textArea = new JTextArea(game.getCrew().getCrewMembers().get(0).description());
		textArea.setBounds(23, 220, 293, 71);
		panel.add(textArea);
		
		JLabel lblHealthValue = new JLabel();
		lblHealthValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHealthValue.setBounds(109, 96, 207, 32);
		panel.add(lblHealthValue);
		
		JLabel lblHungerValue = new JLabel();
		lblHungerValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHungerValue.setBounds(109, 138, 207, 32);
		panel.add(lblHungerValue);
		
		JLabel lblFatigueValue = new JLabel();
		lblFatigueValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFatigueValue.setBounds(109, 178, 207, 32);
		panel.add(lblFatigueValue);
		
		JLabel lblTraitValue = new JLabel();
		lblTraitValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblTraitValue.setBounds(109, 52, 207, 32);
		panel.add(lblTraitValue);
		
		JLabel lblNameValue = new JLabel();
		lblNameValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNameValue.setBounds(109, 10, 207, 32);
		panel.add(lblNameValue);
		
		// The default selected crew member when first entering the window
		CrewMember member = game.getCrew().getCrewMembers().get(0);
		lblNameValue.setText(member.getName());
		lblTraitValue.setText(member.getType());
		lblHealthValue.setText(member.getHealth() + "/" + member.getMaxHealth());
		lblHungerValue.setText(member.getHunger() + "/" + member.getMaxHunger());
		lblFatigueValue.setText(member.getFatigue() + "/" + member.getMaxFatigue());
		
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
				textArea.setText(member.description());
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
				textArea.setText(member.description());
			}
		});
		tglbtnCM1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM1.setBounds(52, 118, 150, 150);
		frame.getContentPane().add(tglbtnCM1);
		
	
		
		
		tglbtnCM2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM2.setBounds(231, 118, 150, 150);
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
				textArea.setText(member.description());
			}
		});
		tglbtnCM3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM3.setBounds(52, 297, 150, 150);
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
				textArea.setText(member.description());
			}
		});
		tglbtnCM4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCM4.setBounds(231, 297, 150, 150);
		frame.getContentPane().add(tglbtnCM4);
		
		
		JLabel lblNewLabel = new JLabel("THE CREW LOBBY ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 30, 690, 60);
		frame.getContentPane().add(lblNewLabel);
		
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
