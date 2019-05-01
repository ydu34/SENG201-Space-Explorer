package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Checkbox;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Font;
import javax.swing.JList;

public class CreateCrewScreen {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCrewScreen window = new CreateCrewScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateCrewScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(299, 69, 269, 198);
		
		JLabel lblCrewName = new JLabel("Crew Name:");
		lblCrewName.setBounds(306, 38, 78, 19);
		lblCrewName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(402, 40, 166, 19);
		textField.setColumns(10);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(27, 10, 94, 74);
		panel_1.add(btnNewButton_1);
		
		JButton button = new JButton("New button");
		button.setBounds(144, 10, 94, 74);
		panel_1.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(27, 99, 94, 74);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(144, 99, 94, 74);
		panel_1.add(button_2);
		frame.getContentPane().add(lblCrewName);
		frame.getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("Start Adventure!");
		btnNewButton.setBounds(185, 317, 188, 21);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 38, 242, 229);
		frame.getContentPane().add(panel);
	}
}
