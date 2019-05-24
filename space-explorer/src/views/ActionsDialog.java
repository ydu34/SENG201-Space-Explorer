package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import main.GameEnvironment;

/**
 * The dialog that allows the player to select the action they want their selected
 * crew member to perform.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class ActionsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private GameEnvironment game;

	/**
	 * Creates the action dialog. This includes a list of action buttons for players
	 * to choose.
	 * 
	 * @param parent       A JFrame that launched this dialog
	 * @param game         A GameEnvironment object containing all the contents of
	 *                     the game.
	 * @param parentWindow A CrewMemberWindow that launched this dialog
	 */
	public ActionsDialog(JFrame parent, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, true);
		setResizable(false);
		setBounds(100, 100, 325, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblDialogTitle = new JLabel("Actions");
		lblDialogTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblDialogTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		lblDialogTitle.setBounds(0, 0, 319, 50);
		contentPanel.add(lblDialogTitle);

		JButton btnEatFood = new JButton("Eat Food");
		btnEatFood.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnEatFood.addActionListener(new ActionListener() {

			/**
			 * Sets the dialog visibility to false and opens a dialog that allows the crew
			 * member to consume a food item.
			 */
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JDialog eatFood = new EatFoodDialog(parent, game, parentWindow);
				eatFood.setVisible(true);
			}

		});
		btnEatFood.setBounds(15, 134, 289, 25);
		contentPanel.add(btnEatFood);

		JButton btnApplyMed = new JButton("Apply Medicine");
		btnApplyMed.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnApplyMed.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JDialog applyMedicine = new ApplyMedicineDialog(parent, game, parentWindow);
				applyMedicine.setVisible(true);
			}

		});
		btnApplyMed.setBounds(15, 170, 289, 25);
		contentPanel.add(btnApplyMed);

		JButton btnRepairShip = new JButton("Repair ship shields");
		btnRepairShip.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnRepairShip.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				RepairShipDialog repairShip = new RepairShipDialog(parent, game, parentWindow);
				repairShip.setVisible(true);
			}
		});
		btnRepairShip.setBounds(15, 206, 289, 25);
		contentPanel.add(btnRepairShip);

		JButton btnSearchPlanet = new JButton("Search planet ");
		btnSearchPlanet.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSearchPlanet.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				SearchPlanetDialog searchPlanet = new SearchPlanetDialog(parent, game, parentWindow);
				searchPlanet.setVisible(true);
			}
		});
		btnSearchPlanet.setBounds(15, 242, 289, 25);
		contentPanel.add(btnSearchPlanet);

		JButton btnPilotShip = new JButton("Pilot the ship to another planet");
		btnPilotShip.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnPilotShip.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				parentWindow.finishedWindow();
				game.launchSelectPilotWindow();
			}
		});
		btnPilotShip.setBounds(15, 278, 289, 25);
		contentPanel.add(btnPilotShip);

		JButton btnSleep = new JButton("Sleep");
		btnSleep.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSleep.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				SleepDialog sleep = new SleepDialog(parent, game, parentWindow);
				sleep.setVisible(true);
			}
		});
		btnSleep.setBounds(15, 98, 289, 25);
		contentPanel.add(btnSleep);

		JLabel lblCrewMemberText = new JLabel("Crew Member:");
		lblCrewMemberText.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblCrewMemberText.setBounds(15, 63, 124, 30);
		contentPanel.add(lblCrewMemberText);

		JLabel lblCrewMemberValue = new JLabel(game.getChosenCrewMember().getName());
		lblCrewMemberValue.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCrewMemberValue.setBounds(151, 63, 153, 30);
		contentPanel.add(lblCrewMemberValue);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnBack.setBounds(15, 314, 289, 25);
		contentPanel.add(btnBack);

		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(12, 52, 295, 2);
		contentPanel.add(separatorTop);
	}
}
