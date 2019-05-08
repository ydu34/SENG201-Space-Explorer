package views;

import main.GameEnvironment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class EatFoodPopUp {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public EatFoodPopUp(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeEatFoodPopUp(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 325, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHaveASnack = new JLabel("Have a Snack!");
		lblHaveASnack.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 20));
		lblHaveASnack.setBounds(82, 36, 136, 18);
		frame.getContentPane().add(lblHaveASnack);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 108, 90, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblCheckWhatYou = new JLabel("Check what you have:");
		lblCheckWhatYou.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		lblCheckWhatYou.setBounds(12, 81, 151, 15);
		frame.getContentPane().add(lblCheckWhatYou);
		
		JPanel panel = new JPanel();
		panel.setBounds(122, 107, 180, 179);
		frame.getContentPane().add(panel);
		
		JLabel lblAboutThisFood_1 = new JLabel("About this food");
		lblAboutThisFood_1.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 13));
		panel.add(lblAboutThisFood_1);
		
		JLabel lblAboutThisFood = new JLabel("");
		lblAboutThisFood.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 13));
		panel.add(lblAboutThisFood);
		
		JButton btnEat = new JButton("EAT");
		btnEat.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnEat.setBounds(12, 333, 90, 25);
		frame.getContentPane().add(btnEat);
		
		JButton btnNewButton = new JButton("Let's do something else!");
		btnNewButton.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 11));
		btnNewButton.setBounds(137, 335, 160, 25);
		frame.getContentPane().add(btnNewButton);
	}

}
