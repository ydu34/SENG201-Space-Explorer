package views;
import main.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Represents a window object that 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class InstructionsWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Creates the window application.
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
		
		JButton btnNewButton = new JButton("CONTINUE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnNewButton.setBounds(256, 500, 273, 35);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnYourCrewIs = new JTextPane();
		txtpnYourCrewIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnYourCrewIs.setText(game.introductionText());
		txtpnYourCrewIs.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtpnYourCrewIs.setBackground(UIManager.getColor("menu"));
		txtpnYourCrewIs.setEditable(false);
		txtpnYourCrewIs.setBounds(37, 76, 703, 411);
		frame.getContentPane().add(txtpnYourCrewIs);
		
		JLabel lblNewLabel = new JLabel("LOST IN SPACE ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(37, 13, 703, 50);
		frame.getContentPane().add(lblNewLabel);
	}
}
