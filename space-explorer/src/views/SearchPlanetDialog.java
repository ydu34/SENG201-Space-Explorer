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

public class SearchPlanetDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public SearchPlanetDialog(JFrame parent, GameEnvironment game, CrewMemberWindow parentWindow) {
		super(parent, true);
		setBounds(100, 100, 375, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(47, 13, 255, 205);
			contentPanel.add(panel);
		}
		{
			JButton btnSearchPlanet = new JButton("SEARCH PLANET");
			btnSearchPlanet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.getChosenCrewMember().search(game.getMedItems(), game.getFoodItems(), game.getCrew(), game.getShip());
					setVisible(false);
					dispose();
					if (!(message.isEmpty())) {
						JOptionPane.showMessageDialog(parent, message);
					}
					parentWindow.finishedWindow();
					game.launchCrewMemberWindow();
				}
			});
			btnSearchPlanet.setFont(new Font("Dialog", Font.BOLD, 15));
			btnSearchPlanet.setBounds(47, 304, 255, 25);
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
			btnReturn.setFont(new Font("Dialog", Font.BOLD, 11));
			btnReturn.setBounds(140, 365, 205, 25);
			contentPanel.add(btnReturn);
		}
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBackground(SystemColor.menu);
		if (game.getCrew().getCurrentLocation().isShipPieceFound()) {
			textArea.setText("The lightspeed engine piece already found on the planet " + game.getCrew().getCurrentLocation() +"!");
		} else {
			textArea.setText("There could be a lightspeed engine piece on the planet " + game.getCrew().getCurrentLocation() +"!");
		}
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(47, 231, 255, 60);
		contentPanel.add(textArea);
	}
}
