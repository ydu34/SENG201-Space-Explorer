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
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class OutpostWindow {

	private JFrame frame;
	private GameEnvironment game;
	private int totalCost = 0;

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
		OutpostWindow window = this;
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("SPACE EXPLORERS");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCoins = new JLabel("Coins Available:");
		lblCoins.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblCoins.setBounds(410, 450, 152, 33);
		frame.getContentPane().add(lblCoins);
		
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

		JComboBox comboBoxItems = new JComboBox(uniqueOutpostItems.toArray());
		comboBoxItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		// The current item that is selected by the player in the combo box
		Item currentItem = (Item) comboBoxItems.getSelectedItem();
		comboBoxItems.setBounds(50, 132, 290, 30);
		frame.getContentPane().add(comboBoxItems);
		
		JButton btnInventory = new JButton("View Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchInventoryWindow();
			}
		});
		btnInventory.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnInventory.setBounds(399, 515, 148, 25);
		frame.getContentPane().add(btnInventory);
		
		JLabel lblSeeItems = new JLabel("See what is for sale!");
		lblSeeItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeeItems.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSeeItems.setBounds(50, 97, 290, 30);
		frame.getContentPane().add(lblSeeItems);
		
		JPanel panelItemInfo = new JPanel();
		panelItemInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelItemInfo.setBounds(400, 97, 340, 310);
		frame.getContentPane().add(panelItemInfo);
		panelItemInfo.setLayout(null);
		
		JTextArea descriptionArea = new JTextArea(currentItem.getDescription());
		descriptionArea.setBackground(SystemColor.menu);
		descriptionArea.setEditable(false);
		descriptionArea.setLineWrap(true);
		descriptionArea.setWrapStyleWord(true);
		descriptionArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		descriptionArea.setBounds(35, 197, 273, 52);
		panelItemInfo.add(descriptionArea);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Dialog", Font.BOLD, 16));
		lblStock.setBounds(35, 129, 68, 22);
		panelItemInfo.add(lblStock);
		
		JLabel lblItemInfo = new JLabel("About this item");
		lblItemInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemInfo.setBounds(0, 0, 340, 50);
		lblItemInfo.setFont(new Font("Dialog", Font.BOLD, 20));
		panelItemInfo.add(lblItemInfo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(35, 61, 68, 22);
		panelItemInfo.add(lblName);
		
		JButton btnAddCart = new JButton("Add to Cart");
		
		btnAddCart.setBounds(35, 271, 273, 25);
		panelItemInfo.add(btnAddCart);
		btnAddCart.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		
		JLabel lblItemName = new JLabel("");
		lblItemName.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblItemName.setBounds(114, 61, 194, 22);
		lblItemName.setText(currentItem.getName());
		panelItemInfo.add(lblItemName);
		
		JLabel lblItemCount = new JLabel("");
		lblItemCount.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblItemCount.setBounds(114, 129, 194, 22);
		lblItemCount.setText(Integer.toString(itemFrequency.get(currentItem)));
		panelItemInfo.add(lblItemCount);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPrice.setBounds(35, 95, 68, 22);
		panelItemInfo.add(lblPrice);
		
		JLabel lblItemPrice = new JLabel("");
		lblItemPrice.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblItemPrice.setBounds(114, 95, 194, 22);
		lblItemPrice.setText(Integer.toString(currentItem.getPrice()));
		panelItemInfo.add(lblItemPrice);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDescription.setBounds(35, 163, 134, 22);
		panelItemInfo.add(lblDescription);
		
		JSeparator separatorInfoTop = new JSeparator();
		separatorInfoTop.setBounds(22, 51, 300, 2);
		panelItemInfo.add(separatorInfoTop);
		
		JSeparator separatorInfoBottom = new JSeparator();
		separatorInfoBottom.setBounds(22, 257, 300, 2);
		panelItemInfo.add(separatorInfoBottom);
		
		JButton btnBackToShip = new JButton("Return to ship");
		btnBackToShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchMainWindow();
			}
		});
		btnBackToShip.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnBackToShip.setBounds(612, 515, 136, 25);
		frame.getContentPane().add(btnBackToShip);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setText("Welcome to " + game.getCrew().getCurrentLocation() + " space outpost!");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 30));
		lblTitle.setBounds(0, 0, 795, 60);
		frame.getContentPane().add(lblTitle);
		
		JButton btnPurchase = new JButton("PURCHASE");
		btnPurchase.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPurchase.setBounds(50, 437, 290, 46);
		frame.getContentPane().add(btnPurchase);
		
		JButton btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		btnRemoveFromCart.setBounds(50, 403, 290, 25);
		frame.getContentPane().add(btnRemoveFromCart);
		btnRemoveFromCart.setEnabled(false);
		
		DefaultListModel<Item> listModel = new DefaultListModel();
		JScrollPane scrollPaneItems = new JScrollPane();
		scrollPaneItems.setSize(290, 220);
		scrollPaneItems.setLocation(50, 172);
		frame.getContentPane().add(scrollPaneItems);
		JList listItems = new JList(listModel);
		listItems.setBackground(SystemColor.menu);
		scrollPaneItems.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(10, 10, 10, 10)));
		scrollPaneItems.setViewportView(listItems);
		listItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listItems.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				btnRemoveFromCart.setEnabled(true);
			}
		});
		
		JLabel lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblTotalCost.setBounds(410, 420, 152, 33);
		frame.getContentPane().add(lblTotalCost);
		
		JLabel lblTotalCostValue = new JLabel(Integer.toString(totalCost));
		lblTotalCostValue.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTotalCostValue.setBounds(574, 420, 168, 33);
		frame.getContentPane().add(lblTotalCostValue);
		
		JLabel lblMoney = new JLabel(Integer.toString(game.getCrew().getMoney()));
		lblMoney.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMoney.setBounds(574, 450, 168, 33);
		frame.getContentPane().add(lblMoney);
		
		JLabel lblWarning = new JLabel("");
		lblWarning.setBounds(50, 503, 290, 24);
		frame.getContentPane().add(lblWarning);
		
		JSeparator separatorTop = new JSeparator();
		separatorTop.setBounds(50, 62, 695, 2);
		frame.getContentPane().add(separatorTop);
		
		JSeparator separatorBottom = new JSeparator();
		separatorBottom.setBounds(50, 503, 695, 2);
		frame.getContentPane().add(separatorBottom);
		
		comboBoxItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Item currentItem = (Item) comboBoxItems.getSelectedItem();
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
				
				listModel.addElement((Item) comboBoxItems.getSelectedItem());
				itemFrequency.replace((Item) comboBoxItems.getSelectedItem(), itemFrequency.get(comboBoxItems.getSelectedItem()) - 1);
				totalCost += ((Item) comboBoxItems.getSelectedItem()).getPrice();
				lblTotalCostValue.setText(Integer.toString(totalCost));
				if (itemFrequency.get(comboBoxItems.getSelectedItem()) <= 0){
					btnAddCart.setEnabled(false);
				} else {
					btnAddCart.setEnabled(true);
				}
				if (listModel.getSize() <= 0 || listItems.isSelectionEmpty()) {
					btnRemoveFromCart.setEnabled(false);
				} else {
					btnRemoveFromCart.setEnabled(true);
				}
			}
		});
		
		btnRemoveFromCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					itemFrequency.replace((Item) comboBoxItems.getSelectedItem(), itemFrequency.get(comboBoxItems.getSelectedItem()) + 1);
					btnAddCart.setEnabled(true);
					totalCost -= ((Item) listItems.getSelectedValue()).getPrice();
					listModel.removeElement(listItems.getSelectedValue());
					lblTotalCostValue.setText(Integer.toString(totalCost));
					if (listModel.getSize() <= 0 || listItems.isSelectionEmpty()) {
						btnRemoveFromCart.setEnabled(false);
					} else {
						btnRemoveFromCart.setEnabled(true);
					}
			}
		});
		
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpaceOutpost currentSpaceOutpost = game.getCrew().getCurrentLocation().getOutpost();
				if (listModel.getSize() == 0) {
					lblWarning.setText("There are no items to purchase!");
				}else if (totalCost <= game.getCrew().getMoney()) {
					for (int i = 0; i < listItems.getModel().getSize(); i++) {
						if (listItems.getModel().getElementAt(i) instanceof MedicalItem) {
							MedicalItem currentItem = (MedicalItem) listItems.getModel().getElementAt(i);
							currentSpaceOutpost.purchaseItem(currentItem, game.getCrew());
						}
						else {
							FoodItem currentItem = (FoodItem) listItems.getModel().getElementAt(i);
							currentSpaceOutpost.purchaseItem(currentItem, game.getCrew());
						}
					}
					lblMoney.setText(Integer.toString(game.getCrew().getMoney()));
					totalCost = 0;
					lblTotalCostValue.setText(Integer.toString(totalCost));
					listModel.clear();
					lblItemCount.setText(Integer.toString(itemFrequency.get(currentItem)));
					JOptionPane.showMessageDialog(frame, "Items purchased!");
					
				}
				else {
					lblWarning.setText("Sorry, you do not have enough coins!");	
				}
				
			}
		});
		
	}
}
