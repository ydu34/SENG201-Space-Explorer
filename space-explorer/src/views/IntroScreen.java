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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		txtpnYourSpaceshipHas.setBounds(10, 10, 572, 62);
		txtpnYourSpaceshipHas.setBackground(UIManager.getColor("menu"));
		txtpnYourSpaceshipHas.setText("Your spaceship has been broken and its pieces are scattered throughout the surrounding planets. You will need to find the missing pieces of your spaceship so that you can repair it and get home.");
		
		JLabel lblHowManyDays = new JLabel("How many days do you want to play for?");
		lblHowManyDays.setBounds(203, 94, 186, 13);
		
		JSlider slider = new JSlider();
		slider.setBounds(55, 135, 483, 44);
		slider.setMajorTickSpacing(1);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setToolTipText("");
		slider.setMinimum(3);
		slider.setMaximum(10);
		
		JLabel lblHowManyCrew = new JLabel("How many crew members do you want?\n");
		lblHowManyCrew.setBounds(204, 220, 185, 13);
		
		JSlider slider_1 = new JSlider();
		slider_1.setBounds(52, 254, 488, 44);
		slider_1.setMaximum(4);
		slider_1.setMinimum(2);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMajorTickSpacing(1);
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(265, 324, 63, 21);
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frmSpaceExplorer.getContentPane().setLayout(null);
		frmSpaceExplorer.getContentPane().add(txtpnYourSpaceshipHas);
		frmSpaceExplorer.getContentPane().add(lblHowManyDays);
		frmSpaceExplorer.getContentPane().add(lblHowManyCrew);
		frmSpaceExplorer.getContentPane().add(slider_1);
		frmSpaceExplorer.getContentPane().add(slider);
		frmSpaceExplorer.getContentPane().add(btnAccept);
	}
}
