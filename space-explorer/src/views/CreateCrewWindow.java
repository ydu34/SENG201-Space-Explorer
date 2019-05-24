package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.CrewMember;
import main.GameEnvironment;
import javax.swing.SwingConstants;

/**
 * A window that allows the player to create their crew. This includes naming
 * the ship, selecting the crew size, and also choosing their crew members. The
 * player can name and pick the trait of the crew member.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class CreateCrewWindow {

	private JFrame frame;
	private JTextField textFieldShipName;
	private GameEnvironment game;
	private JTextField textFieldName;
	private ArrayList<JToggleButton> CrewMemberToggleButtons = new ArrayList<JToggleButton>(); 																		
	private JComboBox comboBoxType;
	private Border BorderSelectedCrewMember;

	/**
	 * Creates the window application.
	 * 
	 * @param incomingGame A GameEnvironment containing all the contents of the
	 *                     game.
	 */
	public CreateCrewWindow(GameEnvironment incomingGame) {
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
		game.closeCreateCrewWindow(this);
	}

	/**
	 * Initializes the contents of the this window. This window includes a text
	 * field for ship name input, a slider for choosing the number of crew members,
	 * and four numbered buttons for players to personalize each of the crew
	 * members.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("SPACE EXPLORERS");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		CrewMember crewMember1 = new CrewMember("Bill", "Engineer", "/resources/astronautBlue.png");
		CrewMember crewMember2 = new CrewMember("Carole", "Health Nut", "/resources/astronautRed.png");
		CrewMember crewMember3 = new CrewMember("Noah", "Nibbler", "/resources/astronautTeal.png");
		CrewMember crewMember4 = new CrewMember("Kim", "Night Owl", "/resources/astronautPurple.png");

		JLabel lblNotifyMessage = new JLabel();
		lblNotifyMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotifyMessage.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNotifyMessage.setBounds(395, 493, 360, 25);
		frame.getContentPane().add(lblNotifyMessage);

		JPanel panelCrewMemberInfo = new JPanel();
		panelCrewMemberInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panelCrewMemberInfo.setBounds(385, 164, 360, 330);
		frame.getContentPane().add(panelCrewMemberInfo);

		panelCrewMemberInfo.setLayout(null);

		JLabel lblNameText = new JLabel("Name:");
		lblNameText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNameText.setBounds(11, 10, 78, 32);
		panelCrewMemberInfo.add(lblNameText);

		JLabel lblTypeText = new JLabel("Type:");
		lblTypeText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTypeText.setBounds(11, 52, 78, 32);
		panelCrewMemberInfo.add(lblTypeText);

		textFieldName = new JTextField("Bill");
		textFieldName.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldName.setBounds(91, 10, 236, 32);
		panelCrewMemberInfo.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblHealthText = new JLabel("Health:");
		lblHealthText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHealthText.setBounds(11, 94, 78, 32);
		panelCrewMemberInfo.add(lblHealthText);

		JLabel lblHungerText = new JLabel("Hunger:\r\n");
		lblHungerText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHungerText.setBounds(11, 136, 78, 32);
		panelCrewMemberInfo.add(lblHungerText);

		JLabel lblFatigueText = new JLabel("Fatigue:");
		lblFatigueText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFatigueText.setBounds(189, 94, 78, 32);
		panelCrewMemberInfo.add(lblFatigueText);

		comboBoxType = new JComboBox(game.getCrewMemberTypes().toArray());
		comboBoxType.setFont(new Font("Dialog", Font.PLAIN, 16));
		// Get the current selected type of crew member
		CrewMember currentType = (CrewMember) comboBoxType.getSelectedItem();

		JLabel lblHealthValue = new JLabel(currentType.getHealth() + "/" + currentType.getMaxHealth());
		lblHealthValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHealthValue.setBounds(100, 94, 78, 32);
		panelCrewMemberInfo.add(lblHealthValue);

		JLabel lblHungerValue = new JLabel(currentType.getHunger() + "/" + currentType.getMaxHunger());
		lblHungerValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblHungerValue.setBounds(100, 136, 78, 32);
		panelCrewMemberInfo.add(lblHungerValue);

		JLabel lblFatigueValue = new JLabel(currentType.getFatigue() + "/" + currentType.getMaxFatigue());
		lblFatigueValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFatigueValue.setBounds(278, 94, 78, 32);
		panelCrewMemberInfo.add(lblFatigueValue);

		comboBoxType.setBounds(91, 52, 236, 32);
		panelCrewMemberInfo.add(comboBoxType);

		JLabel lblShipName = new JLabel("Ship name:");
		lblShipName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblShipName.setBounds(50, 26, 337, 48);
		frame.getContentPane().add(lblShipName);

		textFieldShipName = new JTextField();
		textFieldShipName.setFont(new Font("Dialog", Font.PLAIN, 18));
		textFieldShipName.setText("Gattaca");
		textFieldShipName.setBounds(393, 37, 292, 30);
		frame.getContentPane().add(textFieldShipName);
		textFieldShipName.setColumns(10);

		BorderSelectedCrewMember = new MatteBorder(4, 4, 4, 4, Color.green);
		JToggleButton tglbtnCrewMember1 = new JToggleButton("", true);
		tglbtnCrewMember1.setBorder(BorderSelectedCrewMember);
		tglbtnCrewMember1.setIcon(new ImageIcon(CreateCrewWindow.class.getResource("/resources/astronautBlue.png")));
		tglbtnCrewMember1
				.setSelectedIcon(new ImageIcon(CreateCrewWindow.class.getResource("/resources/astronautBlue.png")));
		tglbtnCrewMember1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
					button.setBorder(null);
				}
				lblNotifyMessage.setText("");
				updateProfile(tglbtnCrewMember1, crewMember1);
			}
		});
		tglbtnCrewMember1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tglbtnCrewMember1.setBounds(50, 185, 145, 145);
		frame.getContentPane().add(tglbtnCrewMember1);

		CrewMemberToggleButtons.add(tglbtnCrewMember1);

		JToggleButton tglbtnCrewMember2 = new JToggleButton("");
		tglbtnCrewMember2.setIcon(new ImageIcon(CreateCrewWindow.class.getResource("/resources/astronautRed.png")));
		tglbtnCrewMember2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
					button.setBorder(null);
				}
				lblNotifyMessage.setText("");
				updateProfile(tglbtnCrewMember2, crewMember2);
			}
		});
		tglbtnCrewMember2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		tglbtnCrewMember2.setBounds(215, 185, 145, 145);

		frame.getContentPane().add(tglbtnCrewMember2);

		CrewMemberToggleButtons.add(tglbtnCrewMember2);

		JToggleButton tglbtnCrewMember3 = new JToggleButton("");
		tglbtnCrewMember3.setIcon(new ImageIcon(CreateCrewWindow.class.getResource("/resources/astronautTeal.png")));
		tglbtnCrewMember3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
					button.setBorder(null);
				}
				lblNotifyMessage.setText("");
				updateProfile(tglbtnCrewMember3, crewMember3);
			}
		});
		tglbtnCrewMember3.setFont(new Font("Tahoma", Font.PLAIN, 20));

		tglbtnCrewMember3.setBounds(50, 349, 145, 145);

		frame.getContentPane().add(tglbtnCrewMember3);

		CrewMemberToggleButtons.add(tglbtnCrewMember3);

		JToggleButton tglbtnCrewMember4 = new JToggleButton("");
		tglbtnCrewMember4.setIcon(new ImageIcon(CreateCrewWindow.class.getResource("/resources/astronautPurple.png")));
		tglbtnCrewMember4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : CrewMemberToggleButtons) {
					button.setSelected(false);
					button.setBorder(null);
				}
				lblNotifyMessage.setText("");
				updateProfile(tglbtnCrewMember4, crewMember4);
			}
		});
		tglbtnCrewMember4.setFont(new Font("Tahoma", Font.PLAIN, 20));

		tglbtnCrewMember4.setBounds(215, 349, 145, 145);

		frame.getContentPane().add(tglbtnCrewMember4);

		CrewMemberToggleButtons.add(tglbtnCrewMember4);

		JTextArea textArea = new JTextArea(currentType.description());
		textArea.setBackground(UIManager.getColor("Menu.background"));
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setLineWrap(true);
		textArea.setBounds(11, 181, 337, 102);
		panelCrewMemberInfo.add(textArea);
		textArea.setEditable(false);

		// The listener for the combo box
		comboBoxType.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				CrewMember currentType = (CrewMember) comboBoxType.getSelectedItem();
				lblHealthValue.setText(currentType.getHealth() + "/" + currentType.getMaxHealth());
				lblHungerValue.setText(currentType.getHunger() + "/" + currentType.getMaxHunger());
				lblFatigueValue.setText(currentType.getFatigue() + "/" + currentType.getMaxFatigue());
				textArea.setText(currentType.description());
			}
		});

		JLabel lblCrewSize = new JLabel("Number of Crew Members:");
		lblCrewSize.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCrewSize.setBounds(50, 88, 337, 48);
		frame.getContentPane().add(lblCrewSize);

		JSlider sliderCrewSize = new JSlider();
		sliderCrewSize.setFont(new Font("Dialog", Font.BOLD, 16));
		sliderCrewSize.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				tglbtnCrewMember3.setEnabled(true);
				tglbtnCrewMember4.setEnabled(true);
				switch (sliderCrewSize.getValue()) {
				case 2:
					tglbtnCrewMember3.setEnabled(false);
					if (tglbtnCrewMember3.isSelected()) {
						tglbtnCrewMember3.setSelected(false);
						tglbtnCrewMember1.doClick();
					}
				case 3:
					tglbtnCrewMember4.setEnabled(false);
					if (tglbtnCrewMember4.isSelected()) {
						tglbtnCrewMember4.setSelected(false);
						tglbtnCrewMember1.doClick();
					}
				}
			}
		});
		sliderCrewSize.setSnapToTicks(true);
		sliderCrewSize.setPaintTicks(true);
		sliderCrewSize.setPaintLabels(true);
		sliderCrewSize.setMajorTickSpacing(1);
		sliderCrewSize.setMinimum(2);
		sliderCrewSize.setMaximum(4);
		sliderCrewSize.setBounds(385, 79, 360, 55);
		frame.getContentPane().add(sliderCrewSize);

		JButton btnSave = new JButton("Save Crew Member");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String crewMemberName = textFieldName.getText().replaceFirst("\\s++$", "");
				if (crewMemberName.length() > 14 || crewMemberName.length() < 2 || crewMemberName.isEmpty()
						|| crewMemberName.startsWith(" ")) {
					lblNotifyMessage.setText("");
					String message = "The length of the name must be between 2 and 14 characters and cannot start with spaces.";
					JOptionPane.showMessageDialog(frame, message);
				} else {
					for (JToggleButton button : CrewMemberToggleButtons) {
						if (button.isSelected()) {
							if (button.equals(tglbtnCrewMember1)) {
								crewMember1.setName(textFieldName.getText());
								crewMember1.setType(((CrewMember) comboBoxType.getSelectedItem()).getType());
							} else if (button.equals(tglbtnCrewMember2)) {
								crewMember2.setName(textFieldName.getText());
								crewMember2.setType(((CrewMember) comboBoxType.getSelectedItem()).getType());
							} else if (button.equals(tglbtnCrewMember3)) {
								crewMember3.setName(textFieldName.getText());
								crewMember3.setType(((CrewMember) comboBoxType.getSelectedItem()).getType());
							} else if (button.equals(tglbtnCrewMember4)) {
								crewMember4.setName(textFieldName.getText());
								crewMember4.setType(((CrewMember) comboBoxType.getSelectedItem()).getType());
							}
						}
					}
					lblNotifyMessage.setText("Crew Member profile saved!");
				}
			}
		});
		btnSave.setBounds(11, 292, 337, 25);
		panelCrewMemberInfo.add(btnSave);

		JLabel lblActions = new JLabel("Actions:");
		lblActions.setFont(new Font("Dialog", Font.BOLD, 16));
		lblActions.setBounds(189, 136, 78, 32);
		panelCrewMemberInfo.add(lblActions);

		JLabel lblActionsValue = new JLabel(currentType.getActionsLeft() + "/" + currentType.getMaxActions());
		lblActionsValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblActionsValue.setBounds(278, 136, 78, 32);
		panelCrewMemberInfo.add(lblActionsValue);

		JButton btnNext = new JButton("Finish Crew Creation");
		btnNext.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String shipName = textFieldShipName.getText().replaceFirst("\\s++$", "");
				if (shipName.length() > 14 || shipName.length() < 2 || shipName.isEmpty() || shipName.startsWith(" ")) {
					String message = "The length of the ship name must be between 2 and 14 characters and cannot start with spaces.";
					JOptionPane.showMessageDialog(frame, message);
				} else {
					game.getShip().setName(shipName);
					ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
					switch (sliderCrewSize.getValue()) {
					case 4:
						crewMembers.add(game.createCrewMember(crewMember4));

					case 3:
						crewMembers.add(game.createCrewMember(crewMember3));

					case 2:
						crewMembers.add(game.createCrewMember(crewMember2));

						crewMembers.add(game.createCrewMember(crewMember1));

					}
					Collections.reverse(crewMembers);
					game.getCrew().setCrewMembers(crewMembers);
					finishedWindow();
				}
			}
		});

		btnNext.setBounds(545, 523, 200, 25);

		frame.getContentPane().add(btnNext);

		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(50, 148, 695, 2);
		frame.getContentPane().add(separatorTop);

		textFieldShipName.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent e) {
				enableButton();
			}

			public void removeUpdate(DocumentEvent e) {
				enableButton();
			}

			public void insertUpdate(DocumentEvent e) {
				enableButton();
			}

			public void enableButton() {
				if (textFieldShipName.getText().equals("")) {
					btnNext.setEnabled(false);
				} else {
					btnNext.setEnabled(true);
				}
			}
		});
	}

	/**
	 * Updates the crew member profile details according to the crew member number
	 * button selected.
	 * 
	 * @param toggleButton A JToggleButton object.
	 * @param crewMember   A CrewMember object.
	 */
	public void updateProfile(JToggleButton toggleButton, CrewMember crewMember) {
		toggleButton.setSelected(true);
		toggleButton.setBorder(BorderSelectedCrewMember);
		textFieldName.setText(crewMember.getName());
		switch (crewMember.getType()) {
		case "Engineer":
			comboBoxType.setSelectedIndex(0);
			break;
		case "Health Nut":
			comboBoxType.setSelectedIndex(1);
			break;
		case "Nibbler":
			comboBoxType.setSelectedIndex(2);
			break;
		case "Night Owl":
			comboBoxType.setSelectedIndex(3);
			break;
		case "Regular":
			comboBoxType.setSelectedIndex(4);
			break;
		case "Explorer":
			comboBoxType.setSelectedIndex(5);
			break;
		}
	}
}
