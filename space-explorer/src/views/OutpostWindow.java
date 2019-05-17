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

public class OutpostWindow {

	private JFrame frame;
	private GameEnvironment game;
	private int moneyCounter = 0;

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
		lblCoins.setBounds(425, 489, 148, 15);
		frame.getContentPane().add(lblCoins);
		
		ArrayList<Item> outpostItems = new ArrayList<Item>();
		outpostItems.addAll(game.getCrew().getCurrentLocation().getOutpost().getFoodItems());
		outpostItems.addAll(game.getCrew().getCurrentLocation().getOutpost().getMedicalItems());
		ArrayList<Item> uniqueOutpostItems = new ArrayList<Item>(new TreeSet<Item>(outpostItems));
		Map<Item, Integer> itemFrequency = new HashMap<Item, Integer>();
		for (Item item: uniqueOutpostItems) {
			itemFrequency.put(item, Collections.frequency(outpostItems, item));
		}

		JComboBox ItemsCombo = new JComboBox(uniqueOutpostItems.toArray());
		Item currentItem = (Item) ItemsCombo.getSelectedItem();
		ItemsCombo.setBounds(73, 161, 283, 24);
		frame.getContentPane().add(ItemsCombo);
		
		JButton btnInventory = new JButton("View Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.launchInventoryPopUp();
			}
		});
		btnInventory.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnInventory.setBounds(425, 518, 148, 25);
		frame.getContentPane().add(btnInventory);
		
		JLabel lblItemsAvailableIn = new JLabel("See what is available in this outpost!");
		lblItemsAvailableIn.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 16));
		lblItemsAvailableIn.setBounds(73, 112, 283, 15);
		frame.getContentPane().add(lblItemsAvailableIn);
		
		JPanel panel = new JPanel();
		panel.setBounds(425, 112, 343, 335);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea descriptionArea = new JTextArea(currentItem.getDescription());
		descriptionArea.setBounds(35, 152, 273, 134);
		panel.add(descriptionArea);
		descriptionArea.setEditable(false);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(35, 126, 44, 15);
		panel.add(lblStock);
		
		JLabel lblItemInfo = new JLabel("About this item");
		lblItemInfo.setBounds(104, 28, 118, 22);
		lblItemInfo.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 16));
		panel.add(lblItemInfo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(35, 74, 44, 15);
		panel.add(lblName);
		
		JButton btnAddCart = new JButton("Add to Cart");
		
		btnAddCart.setBounds(35, 298, 273, 25);
		panel.add(btnAddCart);
		btnAddCart.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		
		JLabel lblItemName = new JLabel("");
		lblItemName.setBounds(104, 74, 133, 14);
		lblItemName.setText(currentItem.getName());
		panel.add(lblItemName);
		
		JLabel lblItemCount = new JLabel("");
		lblItemCount.setBounds(104, 126, 49, 14);
		lblItemCount.setText(Integer.toString(itemFrequency.get(currentItem)));
		panel.add(lblItemCount);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(35, 99, 44, 15);
		panel.add(lblPrice);
		
		JLabel lblItemPrice = new JLabel("");
		lblItemPrice.setBounds(104, 99, 44, 15);
		lblItemPrice.setText(Integer.toString(currentItem.getPrice()));
		panel.add(lblItemPrice);
		
		JButton btnBackToShip = new JButton("Back to Ship");
		btnBackToShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBackToShip.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnBackToShip.setBounds(632, 518, 136, 25);
		frame.getContentPane().add(btnBackToShip);
		
		JLabel lblWelcomeToOutpost = new JLabel("Welcome to Space Outpost!");
		lblWelcomeToOutpost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 25));
		lblWelcomeToOutpost.setBounds(212, 24, 361, 47);
		frame.getContentPane().add(lblWelcomeToOutpost);
		
		JButton btnPurchase = new JButton("PURCHASE");
		btnPurchase.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		btnPurchase.setBounds(73, 471, 283, 49);
		frame.getContentPane().add(btnPurchase);
		
		JButton btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		btnRemoveFromCart.setBounds(73, 437, 283, 25);
		frame.getContentPane().add(btnRemoveFromCart);
		btnRemoveFromCart.setEnabled(false);
		
		DefaultListModel listModel = new DefaultListModel();
		JList list = new JList(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				btnRemoveFromCart.setEnabled(true);
			}
		});
		list.setBounds(73, 196, 283, 230);
		frame.getContentPane().add(list);
		
		JLabel lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblTotalCost.setBounds(425, 459, 136, 15);
		frame.getContentPane().add(lblTotalCost);
		
		JLabel lblCost = new JLabel(Integer.toString(moneyCounter));
		lblCost.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCost.setBounds(586, 459, 49, 14);
		frame.getContentPane().add(lblCost);
		
		JLabel lblMoney = new JLabel(Integer.toString(game.getCrew().getMoney()));
		lblMoney.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMoney.setBounds(586, 489, 49, 14);
		frame.getContentPane().add(lblMoney);
		
		JLabel lblWarningSign = new JLabel("");
		lblWarningSign.setBounds(73, 529, 283, 14);
		frame.getContentPane().add(lblWarningSign);
		
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
