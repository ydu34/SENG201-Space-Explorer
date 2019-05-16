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

public class InstructionsWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public InstructionsWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeInstructionsWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		txtpnYourCrewIs.setText("Your crew is lost in space in a unknown galaxy. Your spaceship's lightspeed engines are borken and scattered throughout the surrounding planets. You will need to find the missing pieces of your spaceship so that you can repair it and travel back to Earth. \r\n\r\nEach day you may perform crew member actions. Each crew member has two actions that can be used. ");
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
