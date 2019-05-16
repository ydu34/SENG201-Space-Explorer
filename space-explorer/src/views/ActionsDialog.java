package views;

import main.GameEnvironment;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActionsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private GameEnvironment game;
	
	
	/**
	 * Create the dialog.
	 */
	public ActionsDialog(JFrame parent, String title, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, title, true);
		setBounds(100, 100, 325, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Actions");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(46, 13, 221, 25);
		contentPanel.add(label);
		
		// An actionsListener that is reused, so assign a variable to it
		ActionListener closeDialog = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		};
		JButton btnEatFood = new JButton("Eat Food");
		btnEatFood.addActionListener(closeDialog);
		btnEatFood.setBounds(12, 94, 301, 25);
		contentPanel.add(btnEatFood);
		
		JButton btnApplyMed = new JButton("Apply Medical Item");
		btnApplyMed.addActionListener(closeDialog);
		btnApplyMed.setBounds(12, 170, 301, 25);
		contentPanel.add(btnApplyMed);
		
		JButton btnRepairShip = new JButton("Repair ship shields");
		btnRepairShip.addActionListener(closeDialog);
		btnRepairShip.setBounds(12, 208, 301, 25);
		contentPanel.add(btnRepairShip);
		
		JButton btnSearchPlanet = new JButton("Search planet ");
		btnSearchPlanet.addActionListener(closeDialog);
		
		btnSearchPlanet.setBounds(12, 246, 301, 25);
		contentPanel.add(btnSearchPlanet);
		
		JButton btnPilotShip = new JButton("Pilot the ship");
		btnPilotShip.addActionListener(closeDialog);
		btnPilotShip.setBounds(12, 284, 301, 25);
		contentPanel.add(btnPilotShip);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(closeDialog);
		btnPilotShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentWindow.finishedWindow();
				game.launchPilotWindow();
			}
		});	
		btnSleep.setBounds(12, 132, 301, 25);
		contentPanel.add(btnSleep);
		
		JLabel lblNewLabel = new JLabel("Crew Member:");
		lblNewLabel.setBounds(12, 52, 147, 30);
		contentPanel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel(game.getChosenCrewMember().getName());
		label_1.setBounds(164, 52, 147, 30);
		contentPanel.add(label_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(closeDialog);
		btnBack.setBounds(12, 322, 301, 25);
		contentPanel.add(btnBack);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
