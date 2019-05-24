package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.FoodItem;
import main.GameEnvironment;
import main.Item;
import main.MedicalItem;
import main.SpaceOutpost;

/**
 * The window that allows the player to view the items available in the outpost
 * and purchase the items. This window also contains a button that leads to the
 * player's inventory.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class OutpostWindow {

	private JFrame frame;
	private GameEnvironment game;
	private int totalCost = 0;
	private Item currentItem;

	/**
	 * Creates the window application.
	 * 
	 * @param incomingGame A GameEnvironment containing all the contents of the
	 *                     game.
	 */
	public OutpostWindow(GameEnvironment incomingGame) {
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
		game.closeOutpostWindow(this);
	}

	/**
	 * Initializes the contents of the frame. This includes a combo box of items
	 * available to purchase, display of total cost and coins available, a cart list
	 * of items selected, a panel displaying the selected item details, buttons to
	 * purchase, add to cart, remove from cart, view inventory, and return to ship.
	 */
	private void initialize() {
		OutpostWindow window = this;
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("SPACE EXPLORERS");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCoinsAvailabelText = new JLabel("Coins Available:");
		lblCoinsAvailabelText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCoinsAvailabelText.setBounds(410, 450, 152, 33);
		frame.getContentPane().add(lblCoinsAvailabelText);

		// Create an array list to combine both the food items and the medical items to
		// outpost items
		ArrayList<Item> outpostItems = new ArrayList<Item>();
		outpostItems.addAll(game.getCrew().getCurrentLocation().getOutpost().getFoodItems());
		outpostItems.addAll(game.getCrew().getCurrentLocation().getOutpost().getMedicalItems());

		// Create an array list and get the unique outpost items, so each item only
		// appears once in the list.
		ArrayList<Item> uniqueOutpostItems = new ArrayList<Item>(new TreeSet<Item>(outpostItems));

		// Use a hash map to store the item and the frequency of the item.
		Map<Item, Integer> itemFrequency = new HashMap<Item, Integer>();
		for (Item item : uniqueOutpostItems) {
			itemFrequency.put(item, Collections.frequency(outpostItems, item));
		}

		JComboBox comboBoxItems = new JComboBox(uniqueOutpostItems.toArray());
		comboBoxItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		// The current item that is selected by the player in the combo box
		currentItem = (Item) comboBoxItems.getSelectedItem();
		comboBoxItems.setBounds(50, 121, 290, 30);
		frame.getContentPane().add(comboBoxItems);

		JButton btnInventory = new JButton("View Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchInventoryWindow();
			}
		});
		btnInventory.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnInventory.setBounds(555, 515, 190, 25);
		frame.getContentPane().add(btnInventory);

		JLabel lblComboBoxItemsTitle = new JLabel("See what is for sale!");
		lblComboBoxItemsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblComboBoxItemsTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblComboBoxItemsTitle.setBounds(50, 86, 290, 30);
		frame.getContentPane().add(lblComboBoxItemsTitle);

		JPanel panelItemInfo = new JPanel();
		panelItemInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelItemInfo.setBounds(407, 97, 338, 310);
		frame.getContentPane().add(panelItemInfo);
		panelItemInfo.setLayout(null);

		JTextArea descriptionArea = new JTextArea(currentItem.getDescription());
		descriptionArea.setBackground(UIManager.getColor("Menu.background"));
		descriptionArea.setEditable(false);
		descriptionArea.setLineWrap(true);
		descriptionArea.setWrapStyleWord(true);
		descriptionArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		descriptionArea.setBounds(35, 197, 273, 52);
		panelItemInfo.add(descriptionArea);

		JLabel lblStockText = new JLabel("Stock:");
		lblStockText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblStockText.setBounds(35, 129, 68, 22);
		panelItemInfo.add(lblStockText);

		JLabel lblpanelItemInfoTitle = new JLabel("About this item");
		lblpanelItemInfoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblpanelItemInfoTitle.setBounds(0, 0, 340, 50);
		lblpanelItemInfoTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		panelItemInfo.add(lblpanelItemInfoTitle);

		JLabel lblNameText = new JLabel("Name:");
		lblNameText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNameText.setBounds(35, 61, 68, 22);
		panelItemInfo.add(lblNameText);

		JButton btnAddCart = new JButton("Add to Cart");

		btnAddCart.setBounds(35, 271, 273, 25);
		panelItemInfo.add(btnAddCart);
		btnAddCart.setFont(new Font("Dialog", Font.PLAIN, 16));

		JLabel lblNameValue = new JLabel("");
		lblNameValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNameValue.setBounds(114, 61, 194, 22);
		lblNameValue.setText(currentItem.getName());
		panelItemInfo.add(lblNameValue);

		JLabel lblStockValue = new JLabel("");
		lblStockValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblStockValue.setBounds(114, 129, 194, 22);
		lblStockValue.setText(Integer.toString(itemFrequency.get(currentItem)));
		panelItemInfo.add(lblStockValue);

		JLabel lblPriceText = new JLabel("Price:");
		lblPriceText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPriceText.setBounds(35, 95, 68, 22);
		panelItemInfo.add(lblPriceText);

		JLabel lblPriceValue = new JLabel("");
		lblPriceValue.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblPriceValue.setBounds(114, 95, 194, 22);
		lblPriceValue.setText(Integer.toString(currentItem.getPrice()));
		panelItemInfo.add(lblPriceValue);

		JLabel lblDescriptionText = new JLabel("Description:");
		lblDescriptionText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDescriptionText.setBounds(35, 163, 134, 22);
		panelItemInfo.add(lblDescriptionText);

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
		btnBackToShip.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnBackToShip.setBounds(50, 515, 190, 25);
		frame.getContentPane().add(btnBackToShip);

		JLabel lblTitle = new JLabel();
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setText("Welcome to " + game.getCrew().getCurrentLocation() + " space outpost!");
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 30));
		lblTitle.setBounds(0, 0, 795, 60);
		frame.getContentPane().add(lblTitle);

		JButton btnPurchase = new JButton("PURCHASE");
		btnPurchase.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPurchase.setBounds(50, 426, 290, 46);
		frame.getContentPane().add(btnPurchase);

		JButton btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnRemoveFromCart.setBounds(50, 392, 290, 25);
		frame.getContentPane().add(btnRemoveFromCart);
		btnRemoveFromCart.setEnabled(false);

		DefaultListModel<Item> listModel = new DefaultListModel();
		JScrollPane scrollPaneItems = new JScrollPane();
		scrollPaneItems.setSize(290, 220);
		scrollPaneItems.setLocation(50, 161);
		frame.getContentPane().add(scrollPaneItems);
		JList listItems = new JList(listModel);
		listItems.setBackground(UIManager.getColor("Menu.background"));
		scrollPaneItems.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(10, 10, 10, 10)));
		scrollPaneItems.setViewportView(listItems);
		listItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listItems.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				btnRemoveFromCart.setEnabled(true);
			}
		});

		JLabel lblTotalCostText = new JLabel("Total Cost:");
		lblTotalCostText.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTotalCostText.setBounds(410, 420, 152, 33);
		frame.getContentPane().add(lblTotalCostText);

		JLabel lblTotalCostValue = new JLabel(Integer.toString(totalCost));
		lblTotalCostValue.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTotalCostValue.setBounds(574, 420, 168, 33);
		frame.getContentPane().add(lblTotalCostValue);

		JLabel lblCoinsAvailableValue = new JLabel(Integer.toString(game.getCrew().getMoney()));
		lblCoinsAvailableValue.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCoinsAvailableValue.setBounds(574, 450, 168, 33);
		frame.getContentPane().add(lblCoinsAvailableValue);

		JLabel lblWarningText = new JLabel("");
		lblWarningText.setBounds(50, 474, 290, 24);
		frame.getContentPane().add(lblWarningText);

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
				lblNameValue.setText(currentItem.getName());
				lblPriceValue.setText(Integer.toString(currentItem.getPrice()));
				lblStockValue.setText(Integer.toString(itemFrequency.get(currentItem)));
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
				itemFrequency.replace((Item) comboBoxItems.getSelectedItem(),
						itemFrequency.get(comboBoxItems.getSelectedItem()) - 1);
				totalCost += ((Item) comboBoxItems.getSelectedItem()).getPrice();
				lblTotalCostValue.setText(Integer.toString(totalCost));
				if (itemFrequency.get(comboBoxItems.getSelectedItem()) <= 0) {
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
				itemFrequency.replace((Item) comboBoxItems.getSelectedItem(),
						itemFrequency.get(comboBoxItems.getSelectedItem()) + 1);
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
					lblWarningText.setText("There are no items to purchase!");
				} else if (totalCost <= game.getCrew().getMoney()) {
					for (int i = 0; i < listItems.getModel().getSize(); i++) {
						if (listItems.getModel().getElementAt(i) instanceof MedicalItem) {
							MedicalItem currentItem = (MedicalItem) listItems.getModel().getElementAt(i);
							currentSpaceOutpost.purchaseMedicalItem(currentItem, game.getCrew());
						} else {
							FoodItem currentItem = (FoodItem) listItems.getModel().getElementAt(i);
							currentSpaceOutpost.purchaseFoodItem(currentItem, game.getCrew());
						}
					}
					currentItem = (Item) comboBoxItems.getSelectedItem();
					lblCoinsAvailableValue.setText(Integer.toString(game.getCrew().getMoney()));
					totalCost = 0;
					lblTotalCostValue.setText(Integer.toString(totalCost));
					listModel.clear();
					lblStockValue.setText(Integer.toString(itemFrequency.get(currentItem)));
					JOptionPane.showMessageDialog(frame, "Items purchased!");

				} else {
					lblWarningText.setText("Sorry, you do not have enough coins!");
				}

			}
		});

	}

}
