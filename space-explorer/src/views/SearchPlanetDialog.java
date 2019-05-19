package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.GameEnvironment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

public class SearchPlanetDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
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
					String message = game.getChosenCrewMember().search(game.getMedItems(), game.getFoodItems(), game.getCrew(), game.getShip());
					setVisible(false);
					dispose();
					if (!(message.isEmpty())) {
						JOptionPane.showMessageDialog(parent, message);
					}
					parentWindow.updateProfile(game.getChosenCrewMember());
				}
			});
			btnSearchPlanet.setFont(new Font("Dialog", Font.BOLD, 15));
			btnSearchPlanet.setBounds(32, 335, 95, 25);
			contentPanel.add(btnSearchPlanet);
		}
		{
			JButton btnReturn = new JButton("Let's do something else!");
			btnReturn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					JDialog actions = new ActionsDialog(parent, "Space Explorers", game, parentWindow);
					actions.setVisible(true);
				}
			});
			btnReturn.setFont(new Font("Dialog", Font.PLAIN, 13));
			btnReturn.setBounds(130, 335, 192, 25);
			contentPanel.add(btnReturn);
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(32, 63, 290, 258);
		contentPanel.add(panel);
		
		JTextArea txtrAllowTheCrew = new JTextArea();
		txtrAllowTheCrew.setWrapStyleWord(true);
		txtrAllowTheCrew.setText("Allow the crew member to search the current planet for engine pieces. \r\n \r\nSearching uses up 1 action. The crew member also gains "
				+ game.getChosenCrewMember().getSearchFatigueCost() + " fatigue and " + game.getChosenCrewMember().getSearchHungerCost() + " hunger.");
		txtrAllowTheCrew.setLineWrap(true);
		txtrAllowTheCrew.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtrAllowTheCrew.setEditable(false);
		txtrAllowTheCrew.setBackground(SystemColor.menu);
		txtrAllowTheCrew.setBounds(12, 83, 261, 162);
		panel.add(txtrAllowTheCrew);
		
		JLabel lblPlanet = new JLabel("Planet:");
		lblPlanet.setBounds(12, 13, 128, 25);
		panel.add(lblPlanet);
		lblPlanet.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblPieceDetected = new JLabel("Piece detected: \r\n");
		lblPieceDetected.setBounds(12, 50, 128, 25);
		panel.add(lblPieceDetected);
		lblPieceDetected.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblPlanetValue = new JLabel(game.getCrew().getCurrentLocation().getName());
		lblPlanetValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlanetValue.setBounds(152, 13, 121, 25);
		panel.add(lblPlanetValue);
		
		JLabel lblPieceDetectedValue = new JLabel(""+ game.getCrew().getCurrentLocation().isPieceDetected());
		lblPieceDetectedValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPieceDetectedValue.setBounds(152, 50, 121, 25);
		panel.add(lblPieceDetectedValue);
		
		JLabel lblSearchThePlanet = new JLabel("Search the Planet!");
		lblSearchThePlanet.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchThePlanet.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSearchThePlanet.setBounds(32, 22, 290, 28);
		contentPanel.add(lblSearchThePlanet);
	}
}
