package views;

import main.FoodItem;
import java.awt.EventQueue;
import main.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;

public class OutpostWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public OutpostWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeOutpostWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCoins = new JLabel("Coins Available:");
		lblCoins.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblCoins.setBounds(425, 486, 136, 15);
		frame.getContentPane().add(lblCoins);
		
		JComboBox ItemsCombo = new JComboBox(game.getFoodItems().toArray());
		ItemsCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		FoodItem currentFood = (FoodItem) ItemsCombo.getSelectedItem();
		ItemsCombo.setBounds(73, 161, 283, 24);
		frame.getContentPane().add(ItemsCombo);
		
		JButton btnInventory = new JButton("View Inventory");
		btnInventory.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnInventory.setBounds(73, 518, 180, 25);
		frame.getContentPane().add(btnInventory);
		
		JLabel lblItemsAvailableIn = new JLabel("See what is available in this outpost!");
		lblItemsAvailableIn.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 16));
		lblItemsAvailableIn.setBounds(73, 112, 283, 15);
		frame.getContentPane().add(lblItemsAvailableIn);
		
		JPanel panel = new JPanel();
		panel.setBounds(425, 112, 343, 335);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(35, 125, 44, 15);
		panel.add(lblStock);
		
		JLabel lblItemInfo = new JLabel("About this item");
		lblItemInfo.setBounds(104, 28, 118, 22);
		lblItemInfo.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 16));
		panel.add(lblItemInfo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(35, 84, 44, 15);
		panel.add(lblName);
		
		JButton btnAddCart = new JButton("Add to Cart");
		btnAddCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddCart.setBounds(35, 298, 273, 25);
		panel.add(btnAddCart);
		btnAddCart.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		
		JTextArea textArea = new JTextArea(currentFood.getDescription());
		textArea.setBounds(35, 152, 273, 134);
		panel.add(textArea);
		textArea.setEditable(false);
		
		JButton btnBackToShip = new JButton("Back to Ship");
		btnBackToShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBackToShip.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnBackToShip.setBounds(571, 518, 180, 25);
		frame.getContentPane().add(btnBackToShip);
		
		JLabel lblWelcomeToOutpost = new JLabel("Welcome to Space Outpost!");
		lblWelcomeToOutpost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 25));
		lblWelcomeToOutpost.setBounds(234, 24, 331, 47);
		frame.getContentPane().add(lblWelcomeToOutpost);
		
		JButton button = new JButton("PURCHASE");
		button.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		button.setBounds(73, 435, 283, 49);
		frame.getContentPane().add(button);
		
		JButton btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		btnRemoveFromCart.setBounds(73, 361, 283, 25);
		frame.getContentPane().add(btnRemoveFromCart);
		
		JList list = new JList();
		list.setBounds(73, 238, 283, 111);
		frame.getContentPane().add(list);
		
		JLabel lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblTotalCost.setBounds(425, 459, 136, 15);
		frame.getContentPane().add(lblTotalCost);
	}
}
