package views;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import main.GameEnvironment;

/**
 * The window that explains the instructions of the game to the player. 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class InstructionsWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Creates the window application.
	 * 
	 * @param incomingGame A GameEnvironment containing all the contents of the
	 *                     game.
	 */
	public InstructionsWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * Calls the close window method in game environment.
	 */
	public void finishedWindow() {
		game.closeInstructionsWindow(this);
	}

	/**
	 * Initializes the contents of the frame. This includes a text display of the game instructions, and a continue button to proceed to the game.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("SPACE EXPLORERS");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnContinue = new JButton("CONTINUE");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnContinue.setBounds(256, 500, 273, 35);
		frame.getContentPane().add(btnContinue);
		
		JTextPane textPaneInstructions = new JTextPane();
		textPaneInstructions.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textPaneInstructions.setText(game.introductionText());
		textPaneInstructions.setBackground(UIManager.getColor("menu"));
		textPaneInstructions.setEditable(false);
		textPaneInstructions.setBounds(50, 86, 695, 401);
		frame.getContentPane().add(textPaneInstructions);
		
		JLabel lblTitle = new JLabel("INSTRUCTIONS\r\n");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(0, 0, 795, 60);
		frame.getContentPane().add(lblTitle);
		
		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(50, 62, 695, 2);
		frame.getContentPane().add(separatorTop);
	}
}
