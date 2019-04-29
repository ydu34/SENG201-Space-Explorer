package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class MainMenu {

	private JFrame frmSpaceExplorer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmSpaceExplorer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorer = new JFrame();
		frmSpaceExplorer.setResizable(false);
		frmSpaceExplorer.setTitle("Space Explorer");
		frmSpaceExplorer.setBounds(100, 100, 450, 300);
		frmSpaceExplorer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmSpaceExplorer.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(179))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrewCreation.callscreen();
				frmSpaceExplorer.dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		frmSpaceExplorer.getContentPane().setLayout(groupLayout);
	}
}
