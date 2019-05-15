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
		label.setBounds(46, 12, 221, 25);
		contentPanel.add(label);
		
		// An actionsListener that is reused, so assign a variable to it
		ActionListener closeDialog = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentWindow.finishedWindow();
				game.launchPilotWindow();
				setVisible(false);
				dispose();
			}
		};
		JButton btnEatFood = new JButton("Eat Food");
		btnEatFood.addActionListener(closeDialog);
		btnEatFood.setBounds(46, 61, 221, 25);
		contentPanel.add(btnEatFood);
		
		JButton btnApplyMed = new JButton("Apply Medical Item");
		btnApplyMed.addActionListener(closeDialog);
		btnApplyMed.setBounds(46, 159, 221, 25);
		contentPanel.add(btnApplyMed);
		
		JButton btnRepairShip = new JButton("Repair ship shields");
		btnRepairShip.addActionListener(closeDialog);
		btnRepairShip.setBounds(46, 208, 221, 25);
		contentPanel.add(btnRepairShip);
		
		JButton btnSearchPlanet = new JButton("Search planet ");
		btnSearchPlanet.addActionListener(closeDialog);
		btnSearchPlanet.setBounds(46, 257, 221, 25);
		contentPanel.add(btnSearchPlanet);
		
		JButton btnPilotShip = new JButton("Pilot the ship");
		btnPilotShip.addActionListener(closeDialog);
		btnPilotShip.setBounds(46, 306, 221, 25);
		contentPanel.add(btnPilotShip);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(closeDialog);
		btnSleep.setBounds(46, 110, 221, 25);
		contentPanel.add(btnSleep);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
