package views;

import main.GameEnvironment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JSlider;

public class IntroScreen {

	private JFrame frmSpaceExplorer;
	private GameEnvironment game;


	/**
	 * Create the application.
	 */
	public IntroScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorer.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorer = new JFrame();
		frmSpaceExplorer.setTitle("Space Explorer");
		frmSpaceExplorer.setResizable(false);
		frmSpaceExplorer.setBounds(100, 100, 600, 400);
		frmSpaceExplorer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane txtpnYourSpaceshipHas = new JTextPane();
		txtpnYourSpaceshipHas.setBackground(UIManager.getColor("menu"));
		txtpnYourSpaceshipHas.setText("Your spaceship has been broken and its pieces are scattered throughout the surrounding planets. You will need to find the missing pieces of your spaceship so that you can repair it and get home.");
		
		JLabel lblHowManyDays = new JLabel("How many days do you want to play for?");
		
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(1);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setToolTipText("");
		slider.setMinimum(3);
		slider.setMaximum(10);
		
		JLabel lblHowManyCrew = new JLabel("How many crew members do you want?\n");
		
		JSlider slider_1 = new JSlider();
		slider_1.setMaximum(4);
		slider_1.setMinimum(2);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMajorTickSpacing(1);
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		GroupLayout groupLayout = new GroupLayout(frmSpaceExplorer.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addComponent(txtpnYourSpaceshipHas, GroupLayout.PREFERRED_SIZE, 572, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addComponent(lblHowManyDays)
					.addGap(160))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(165)
					.addComponent(lblHowManyCrew)
					.addContainerGap(190, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(slider_1, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
							.addGap(66))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(slider, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
							.addGap(71))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnYourSpaceshipHas, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblHowManyDays)
					.addGap(32)
					.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(lblHowManyCrew)
					.addGap(18)
					.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
		);
		frmSpaceExplorer.getContentPane().setLayout(groupLayout);
	}
}
