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
import java.awt.Window.Type;

public class ActionsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private GameEnvironment game;

	/**
	 * Create the dialog.
	 */
	public ActionsDialog(JFrame parent, String title, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, title, true);
		setResizable(false);
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

		JButton btnEatFood = new JButton("Eat Food");
		btnEatFood.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JDialog eatFood = new EatFoodDialog(parent, "Space Explorers", game, parentWindow);
				eatFood.setVisible(true);
			}

		});
		btnEatFood.setBounds(12, 132, 301, 25);
		contentPanel.add(btnEatFood);

		JButton btnApplyMed = new JButton("Apply Medical Item");
		btnApplyMed.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JDialog applyMedicine = new ApplyMedicineDialog(parent, "Space Explorers", game, parentWindow);
				applyMedicine.setVisible(true);
			}

		});
		btnApplyMed.setBounds(12, 170, 301, 25);
		contentPanel.add(btnApplyMed);

		JButton btnRepairShip = new JButton("Repair ship shields");
		btnRepairShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				RepairShipDialog repairShip = new RepairShipDialog(parent, game, parentWindow);
				repairShip.setVisible(true);
			}
		});
		btnRepairShip.setBounds(12, 208, 301, 25);
		contentPanel.add(btnRepairShip);

		JButton btnSearchPlanet = new JButton("Search planet ");
		btnSearchPlanet.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				SearchPlanetDialog searchPlanet = new SearchPlanetDialog(parent, game, parentWindow);
				searchPlanet.setVisible(true);
			}
		});
		btnSearchPlanet.setBounds(12, 246, 301, 25);
		contentPanel.add(btnSearchPlanet);

		JButton btnPilotShip = new JButton("Pilot the ship");
		btnPilotShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentWindow.finishedWindow();
				game.launchSelectPilotWindow();
			}
		});
		btnPilotShip.setBounds(12, 284, 301, 25);
		contentPanel.add(btnPilotShip);

		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				SleepDialog sleep = new SleepDialog(parent, title, game, parentWindow);
				sleep.setVisible(true);
			}
		});
		btnSleep.setBounds(12, 94, 301, 25);
		contentPanel.add(btnSleep);

		JLabel lblNewLabel = new JLabel("Selected Crew Member:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 52, 147, 30);
		contentPanel.add(lblNewLabel);

		JLabel label_1 = new JLabel(game.getChosenCrewMember().getName());
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(164, 52, 147, 30);
		contentPanel.add(label_1);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnBack.setBounds(12, 322, 301, 25);
		contentPanel.add(btnBack);
	}
}
