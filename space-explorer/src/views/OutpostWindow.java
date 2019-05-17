package views;

import main.SpaceOutpost;

import main.Planet;
import main.Item;
import main.MedicalItem;

import java.awt.EventQueue;

import main.SpaceOutpost;
import main.FoodItem;
import main.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;

public class OutpostWindow {

	private JFrame frmSpaceExplorers;
	private GameEnvironment game;
	private int moneyCounter = 0;

	/**
	 * Create the application.
	 */
	public OutpostWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frmSpaceExplorers.setVisible(true);
	}

	public void closeWindow() {
		frmSpaceExplorers.dispose();
	}
	
	public void finishedWindow() {
		game.closeOutpostWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceExplorers = new JFrame();
		frmSpaceExplorers.setTitle("SPACE EXPLORERS");
		frmSpaceExplorers.setBounds(100, 100, 800, 600);
		frmSpaceExplorers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceExplorers.getContentPane().setLayout(null);
		
		JLabel lblCoins = new JLabel("Coins Available:");
		lblCoins.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblCoins.setBounds(414, 465, 148, 15);
		frmSpaceExplorers.getContentPane().add(lblCoins);
		
		// Create an array list to combine both the food items and the medical items to outpost items
		ArrayList<Item> outpostItems = new ArrayList<Item>();
		outpostItems.addAll(game.getCrew().getCurrentLocation().getOutpost().getFoodItems());
		outpostItems.addAll(game.getCrew().getCurrentLocation().getOutpost().getMedicalItems());
		
		// Create an array list and get the unique outpost items, so each item only appears once in the list.
		ArrayList<Item> uniqueOutpostItems = new ArrayList<Item>(new TreeSet<Item>(outpostItems));
		
		// Use a hash map to store the item and the frequency of the item.
		Map<Item, Integer> itemFrequency = new HashMap<Item, Integer>();
		for (Item item: uniqueOutpostItems) {
			itemFrequency.put(item, Collections.frequency(outpostItems, item));
		}

		JComboBox ItemsCombo = new JComboBox(uniqueOutpostItems.toArray());
		// The current item that is selected by the player in the combo box
		Item currentItem = (Item) ItemsCombo.getSelectedItem();
		ItemsCombo.setBounds(62, 146, 283, 24);
		frmSpaceExplorers.getContentPane().add(ItemsCombo);
		
		JButton btnInventory = new JButton("View Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.launchInventoryPopUp();
			}
		});
		btnInventory.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnInventory.setBounds(414, 512, 148, 25);
		frmSpaceExplorers.getContentPane().add(btnInventory);
		
		JLabel lblItemsAvailableIn = new JLabel("See what is available at this outpost!");
		lblItemsAvailableIn.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 16));
		lblItemsAvailableIn.setBounds(62, 109, 283, 24);
		frmSpaceExplorers.getContentPane().add(lblItemsAvailableIn);
		
		JPanel panel = new JPanel();
		panel.setBounds(414, 108, 343, 314);
		frmSpaceExplorers.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea descriptionArea = new JTextArea(currentItem.getDescription());
		descriptionArea.setEditable(false);
		descriptionArea.setLineWrap(true);
		descriptionArea.setWrapStyleWord(true);
		descriptionArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		descriptionArea.setBounds(35, 152, 273, 93);
		panel.add(descriptionArea);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStock.setBounds(35, 126, 68, 15);
		panel.add(lblStock);
		
		JLabel lblItemInfo = new JLabel("About this item");
		lblItemInfo.setBounds(104, 28, 118, 22);
		lblItemInfo.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 16));
		panel.add(lblItemInfo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(35, 74, 68, 15);
		panel.add(lblName);
		
		JButton btnAddCart = new JButton("Add to Cart");
		
		btnAddCart.setBounds(35, 265, 273, 25);
		panel.add(btnAddCart);
		btnAddCart.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		
		JLabel lblItemName = new JLabel("");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemName.setBounds(114, 74, 194, 14);
		lblItemName.setText(currentItem.getName());
		panel.add(lblItemName);
		
		JLabel lblItemCount = new JLabel("");
		lblItemCount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemCount.setBounds(114, 126, 194, 14);
		lblItemCount.setText(Integer.toString(itemFrequency.get(currentItem)));
		panel.add(lblItemCount);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrice.setBounds(35, 99, 68, 15);
		panel.add(lblPrice);
		
		JLabel lblItemPrice = new JLabel("");
		lblItemPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemPrice.setBounds(114, 99, 194, 15);
		lblItemPrice.setText(Integer.toString(currentItem.getPrice()));
		panel.add(lblItemPrice);
		
		JButton btnBackToShip = new JButton("Return to ship");
		btnBackToShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBackToShip.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnBackToShip.setBounds(621, 512, 136, 25);
		frmSpaceExplorers.getContentPane().add(btnBackToShip);
		
		JLabel lblWelcomeToOutpost = new JLabel();
		lblWelcomeToOutpost.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToOutpost.setText("Welcome to " + game.getCrew().getCurrentLocation() + " space outpost!");
		lblWelcomeToOutpost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 25));
		lblWelcomeToOutpost.setBounds(62, 21, 695, 47);
		frmSpaceExplorers.getContentPane().add(lblWelcomeToOutpost);
		
		JButton btnPurchase = new JButton("PURCHASE");
		btnPurchase.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		btnPurchase.setBounds(62, 456, 283, 49);
		frmSpaceExplorers.getContentPane().add(btnPurchase);
		
		JButton btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		btnRemoveFromCart.setBounds(62, 422, 283, 25);
		frmSpaceExplorers.getContentPane().add(btnRemoveFromCart);
		btnRemoveFromCart.setEnabled(false);
		
		DefaultListModel listModel = new DefaultListModel();
		JList list = new JList(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				btnRemoveFromCart.setEnabled(true);
			}
		});
		list.setBounds(62, 181, 283, 230);
		frmSpaceExplorers.getContentPane().add(list);
		
		JLabel lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblTotalCost.setBounds(414, 435, 136, 15);
		frmSpaceExplorers.getContentPane().add(lblTotalCost);
		
		JLabel lblCost = new JLabel(Integer.toString(moneyCounter));
		lblCost.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCost.setBounds(575, 436, 182, 14);
		frmSpaceExplorers.getContentPane().add(lblCost);
		
		JLabel lblMoney = new JLabel(Integer.toString(game.getCrew().getMoney()));
		lblMoney.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMoney.setBounds(575, 466, 182, 14);
		frmSpaceExplorers.getContentPane().add(lblMoney);
		
		JLabel lblWarningSign = new JLabel("");
		lblWarningSign.setBounds(62, 526, 283, 14);
		frmSpaceExplorers.getContentPane().add(lblWarningSign);
		
		ItemsCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Item currentItem = (Item) ItemsCombo.getSelectedItem();
				descriptionArea.setText(currentItem.getDescription());
				lblItemName.setText(currentItem.getName());
				lblItemPrice.setText(Integer.toString(currentItem.getPrice()));
				lblItemCount.setText(Integer.toString(itemFrequency.get(currentItem)));
				if (itemFrequency.get(currentItem) == 0) {
					btnAddCart.setEnabled(false);
				} else {
					btnAddCart.setEnabled(true);
				}
			}
		});

		btnAddCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listModel.addElement(ItemsCombo.getSelectedItem());
				itemFrequency.replace((Item) ItemsCombo.getSelectedItem(), itemFrequency.get(ItemsCombo.getSelectedItem()) - 1);
				moneyCounter += ((Item) ItemsCombo.getSelectedItem()).getPrice();
				lblCost.setText(Integer.toString(moneyCounter));
				if (itemFrequency.get(ItemsCombo.getSelectedItem()) == 0) {
					btnAddCart.setEnabled(false);
				} else {
					btnAddCart.setEnabled(true);
				}
			}
		});
		
		btnRemoveFromCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemFrequency.replace((Item) ItemsCombo.getSelectedItem(), itemFrequency.get(ItemsCombo.getSelectedItem()) + 1);
				btnAddCart.setEnabled(true);
				moneyCounter -= ((Item) list.getSelectedValue()).getPrice();
				listModel.removeElement(list.getSelectedValue());
				lblCost.setText(Integer.toString(moneyCounter));
				btnRemoveFromCart.setEnabled(false);
			}
		});
		
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpaceOutpost currentSpaceOutpost = game.getCrew().getCurrentLocation().getOutpost();
				if (moneyCounter <= game.getCrew().getMoney()) {
					for (int i = 0; i < list.getModel().getSize(); i++) {
						if (list.getModel().getElementAt(i) instanceof MedicalItem) {
							MedicalItem currentItem = (MedicalItem) list.getModel().getElementAt(i);
							currentSpaceOutpost.purchaseItem(currentItem, game.getCrew());
						}
						else {
							FoodItem currentItem = (FoodItem) list.getModel().getElementAt(i);
							currentSpaceOutpost.purchaseItem(currentItem, game.getCrew());
						}
					}
					lblMoney.setText(Integer.toString(game.getCrew().getMoney()));
					moneyCounter = 0;
					lblCost.setText(Integer.toString(moneyCounter));
					listModel.clear();
					
				}
				else {
					lblWarningSign.setText("Sorry, you do not have enough coins!");	
				}
			}
		});
		
	}
}
