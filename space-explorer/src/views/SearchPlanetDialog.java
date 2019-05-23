package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import main.GameEnvironment;

/**
 * The dialog displays the information on search planet and allows crew members to search the current planet.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class SearchPlanetDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Creates the dialog. This includes a panel displaying the planet details and
	 * the cost of searching the planet to the crew members, and buttons to search
	 * or return to the actions window.
	 * 
	 * @param parent       A JFrame that launches this dialog.
	 * @param game         A GameEnvironment object containing all the contents of
	 *                     the game.
	 * @param parentWindow A CrewMemberWindow that launched this dialog.
	 */
	public SearchPlanetDialog(JFrame parent, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, true);
		setResizable(false);
		setBounds(100, 100, 375, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnSearchPlanet = new JButton("SEARCH");
			btnSearchPlanet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.getChosenCrewMember().search(game.getGameMedicalItems(), game.getGameFoodItems(),
							game.getCrew());
					setVisible(false);
					dispose();
					if (!(message.isEmpty())) {
						JOptionPane.showMessageDialog(parent, message);
					}
					parentWindow.updateProfile(game.getChosenCrewMember());
				}
			});
			btnSearchPlanet.setFont(new Font("Dialog", Font.BOLD, 16));
			btnSearchPlanet.setBounds(30, 353, 110, 25);
			contentPanel.add(btnSearchPlanet);
		}
		{
			JButton btnReturn = new JButton("Do something else!");
			btnReturn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					JDialog actions = new ActionsDialog(parent, game, parentWindow);
					actions.setVisible(true);
				}
			});
			btnReturn.setFont(new Font("Dialog", Font.PLAIN, 16));
			btnReturn.setBounds(144, 353, 200, 25);
			contentPanel.add(btnReturn);
		}

		JPanel panelSearchInfo = new JPanel();
		panelSearchInfo.setLayout(null);
		panelSearchInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSearchInfo.setBounds(30, 63, 314, 277);
		contentPanel.add(panelSearchInfo);

		JTextArea txtrAllowTheCrew = new JTextArea();
		txtrAllowTheCrew.setWrapStyleWord(true);
		txtrAllowTheCrew.setText(
				"Allow the crew member to search the current planet for engine pieces. \r\n \r\nSearching uses up 1 action. The crew member also gains "
						+ game.getChosenCrewMember().getSearchFatigueCost() + " fatigue and "
						+ game.getChosenCrewMember().getSearchHungerCost() + " hunger.");
		txtrAllowTheCrew.setLineWrap(true);
		txtrAllowTheCrew.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtrAllowTheCrew.setEditable(false);
		txtrAllowTheCrew.setBackground(UIManager.getColor("Menu.background"));
		txtrAllowTheCrew.setBounds(12, 83, 290, 181);
		panelSearchInfo.add(txtrAllowTheCrew);

		JLabel lblPlanet = new JLabel("Planet:");
		lblPlanet.setBounds(12, 13, 128, 25);
		panelSearchInfo.add(lblPlanet);
		lblPlanet.setFont(new Font("Dialog", Font.PLAIN, 16));

		JLabel lblPieceDetected = new JLabel("Part detected: \r\n");
		lblPieceDetected.setBounds(12, 50, 128, 25);
		panelSearchInfo.add(lblPieceDetected);
		lblPieceDetected.setFont(new Font("Dialog", Font.PLAIN, 16));

		JLabel lblPlanetValue = new JLabel(game.getCrew().getCurrentLocation().getName());
		lblPlanetValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlanetValue.setBounds(152, 13, 150, 25);
		panelSearchInfo.add(lblPlanetValue);

		JLabel lblPieceDetectedValue = new JLabel(game.getCrew().getCurrentLocation().planetPieceDetected());
		lblPieceDetectedValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPieceDetectedValue.setBounds(152, 50, 150, 25);
		panelSearchInfo.add(lblPieceDetectedValue);

		JLabel lblSearchThePlanet = new JLabel("Search the Planet!");
		lblSearchThePlanet.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchThePlanet.setFont(new Font("Dialog", Font.BOLD, 30));
		lblSearchThePlanet.setBounds(0, 0, 369, 50);
		contentPanel.add(lblSearchThePlanet);

		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(30, 52, 314, 2);
		contentPanel.add(separatorTop);
	}
}
