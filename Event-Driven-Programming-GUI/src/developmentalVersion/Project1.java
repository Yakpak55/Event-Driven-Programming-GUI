/* Project One - Spring 2024 - CNT 4714
 * Filename - InitialGUIxButtons.java
 * 
 * Description: Implements a GUI with transaction processing
 */

package developmentalVersion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Project1 extends JFrame{

	//Static variable for frame dimensions
	private static final int Width = 700;
	private static final int Height = 600;
	static int MaxItems = 5;
	static int itemCount = 0;
	
	private JLabel	empty_label, direct_label, id_number_label, quantity_label, item_name_label, total_items_label, cart_label;
	private JButton	blank_B, process_B, confirm_B, view_B, finish_B, new_B, exit_B; 
	private JTextField empty_text_boxes, id_number_text_field, quantity_text_field, item_text_field, total_text_field;
	private JTextField[] cartLineArray = new JTextField[MaxItems];
	
	private process_button_implement		proc_button_implement;
	private confirm_button_implement		confBHandler;
	private view_button_implement		view_button_implement;
	private finish_button_implement		fin_button_implement;
	private new__button_implement			new__button_implement;
	private	exit_button_implement			exit_button_implement	;
	
	//more static variable for formatting currency, percentages, and decimal values
	private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	private String ItemID, ItemName, Quantity, Full_price;
	private String Price;
	private Double price_to_pay_total;
	private Integer Discount, count = 0, number = 0;
	private Double SubTotal = 0.0, Tax = 0.0;
	private List<String> Data = new ArrayList<>();
	
	
public Project1()

{
	
	setTitle("Nile.com  - Spring 2024"); //title of the frame
	setSize(Width, Height); //frame size
	
	//make JLabel objects full
	blank_B = new JButton(" ");
	empty_label = new JLabel(" ",SwingConstants.RIGHT);
	
//what is written out on the north panel of gui	
	id_number_label = new JLabel("Enter item ID for Item #" + (itemCount+1) + ":", SwingConstants.RIGHT);
	quantity_label = new JLabel("Enter quantity for Item #" + (itemCount+1) + ":", SwingConstants.RIGHT);
	item_name_label = new JLabel("Details for Item #" + (itemCount+1) + ":", SwingConstants.RIGHT);
	total_items_label = new JLabel("Current Subtotal for " + (itemCount) + " item(s):", SwingConstants.RIGHT);
	cart_label = new JLabel("Your Shopping Cart Is Empty", SwingConstants.CENTER);
	
	direct_label = new JLabel(" USER CONTROLS ", SwingConstants.RIGHT);
	
	
//creates JTextField objects
	
	empty_text_boxes = new JTextField();
	id_number_text_field = new JTextField();
	quantity_text_field = new JTextField();
	item_text_field = new JTextField();
	total_text_field = new JTextField();
	cartLineArray = new JTextField[MaxItems];
	
	for (int counter = 0; counter<MaxItems; counter++)
	{
		cartLineArray[counter] = new JTextField();
	}
	
	
	
	process_B = new JButton("Find item #" + (itemCount+1));
	proc_button_implement = new process_button_implement();
	process_B.addActionListener(proc_button_implement);
	
	confirm_B = new JButton("Add item #"+ (itemCount+1) + "To Cart");
	confBHandler = new confirm_button_implement();
	confirm_B.addActionListener(confBHandler);
	
	view_B = new JButton("View Cart");
	view_button_implement = new view_button_implement();
	view_B.addActionListener(view_button_implement);
	
	finish_B = new JButton ("Check Out");
	fin_button_implement = new finish_button_implement();
	finish_B.addActionListener(fin_button_implement);
	
	new_B = new JButton ("Empty Cart - Start A New Order");
	new__button_implement = new new__button_implement();
	new_B.addActionListener(new__button_implement);
	
	exit_B = new JButton("Exit (Close App)");
	exit_button_implement	 = new exit_button_implement	();
	exit_B.addActionListener(exit_button_implement	);
	
	
	confirm_B.setEnabled(false);
	view_B.setEnabled(false);
	finish_B.setEnabled(false);
	empty_text_boxes.setEditable(false);
	empty_text_boxes.setBackground(Color.DARK_GRAY);
	empty_text_boxes.setVisible(false);
	total_text_field.setEditable(false);
	item_text_field.setEditable(false);

	for (int i = 0; i < MaxItems; i++)
	{
		cartLineArray[i].setEditable(false);
	}
	
	
	blank_B.setBackground(Color.DARK_GRAY);
	blank_B.setVisible(false);
	
	
	Container pane = getContentPane(); //content pane for the frame
	
	GridLayout grid1 = new GridLayout(6,2,8,8); //a 6 by 2 grid
	GridLayout grid2 = new GridLayout(7,2,10,4); //a 7 by 2 grid
	GridLayout grid3 = new GridLayout(5,1,2,2); //a 5 by 1 grid
	
	//creating the panels using border layout n = north, c = center, s = south
	JPanel nPanel = new JPanel();
	JPanel cPanel = new JPanel();
	JPanel sPanel = new JPanel();
	
	//set the pane layouts
	nPanel.setLayout(grid1);
	cPanel.setLayout(grid2);
	sPanel.setLayout(grid1);
	
	//add the panels to content pane
	pane.add(nPanel, BorderLayout.NORTH);
	pane.add(cPanel, BorderLayout.CENTER);
	pane.add(sPanel, BorderLayout.SOUTH);
	
	//style the backgrounds of gui
	pane.setBackground(Color.DARK_GRAY);
	nPanel.setBackground(Color.DARK_GRAY);
	cPanel.setBackground(Color.LIGHT_GRAY);
	sPanel.setBackground(Color.CYAN);
	
	

	nPanel.add(empty_label);
	nPanel.add(empty_text_boxes);
	id_number_label.setForeground(Color.YELLOW);
	nPanel.add(id_number_label);
	nPanel.add(id_number_text_field);
	quantity_label.setForeground(Color.YELLOW);
	nPanel.add(quantity_label);
	nPanel.add(quantity_text_field);
	item_name_label.setForeground(Color.RED);
	item_name_label.setFont(new Font("Calibri", Font.BOLD, 14));
	nPanel.add(item_name_label);
	nPanel.add(item_text_field);
	nPanel.add(total_items_label);
	nPanel.add(total_text_field);
	
	total_items_label.setFont(new Font("Calibri", Font.BOLD, 14));
	total_items_label.setForeground(Color.BLUE);
	
	cPanel.add(cart_label);
	cart_label.setHorizontalAlignment(JLabel.CENTER);
	cart_label.setForeground(Color.RED);
	cart_label.setFont(new Font("Calibri", Font.BOLD, 14));

	
	for(int i = 0; i < MaxItems; i++)
	{
		cPanel.add(cartLineArray[i]);
	}
	
	sPanel.add(direct_label);
	direct_label.setHorizontalAlignment(JLabel.CENTER);
	sPanel.add(blank_B);

//Initializing the south panel buttons fully
	sPanel.add(process_B);
	sPanel.add(confirm_B);
	sPanel.add(view_B);
	sPanel.add(finish_B);
	sPanel.add(new_B);
	sPanel.add(exit_B);
	
	
}


private class process_button_implement implements ActionListener //addButton to gui
{
	public void actionPerformed(ActionEvent e)
	{
		
		String[] cartArray = new String[MaxItems];
		int count = 0;
		
		if(itemCount < 5)
		{	
		item_name_label.setText("Details for Item #" + (itemCount+1) + ":");
		}
		
		File inputFile = new File("inventory.csv"); //for data input from user
		FileReader inputFileReader = null;
		BufferedReader inputBufReader = null;//scanner object from user
		Scanner aScanner = null;
		String inventoryLine;
		String itemIDFromFile;
		boolean found = false;
		
		String searchItem = id_number_text_field.getText();
		String searchQty = quantity_text_field.getText();
		
		//handler if nothing is entered in quantity field
		try {
			
			inputFileReader = new FileReader(inputFile);
			inputBufReader = new BufferedReader(inputFileReader);
			
			
			inventoryLine = inputBufReader.readLine();
			
			whileloop:while(inventoryLine != null)
			{
				aScanner = new Scanner(inventoryLine).useDelimiter("\\s*,\\s*");
				itemIDFromFile = aScanner.next();
				
				
				if(itemIDFromFile.equals(searchItem))
				{
					cartArray[count] = aScanner.next();
					
					//check if statement for if item is true or false
					String bool = aScanner.next();
				
					if(bool.equals("false"))
					{
						System.out.println("Item Found But Not In Stock");
						//Add pop up window
						String title = "NILE Dot Com - ERROR";
						JFrame frame_snipit = new JFrame("Not In Stock");
						JOptionPane.showMessageDialog(frame_snipit, "Sorry... that item is out of stock, please try another item",title, JOptionPane.INFORMATION_MESSAGE);
						id_number_text_field.setText("");
						quantity_text_field.setText("");
						
						found = true;
						break whileloop;
					}
					
					//Check if there is enough of an item in stock to complete purchase
					String qty = aScanner.next();
					int amount_avail = Integer.parseInt(qty);
					int search_amount_avail = Integer.parseInt(searchQty);
	
					if(amount_avail <= 0 || amount_avail < search_amount_avail)
					{
						System.out.println("Not Enough In Stock");
						//Add pop up window
						String title = "NILE Dot Com - ERROR";
						JFrame frame = new JFrame("Quantity pop up");
						String message_general = "Insufficient stock. Only " + amount_avail + " on hand. Please reduce the quantity.";
						JOptionPane.showMessageDialog(frame, message_general,title, JOptionPane.INFORMATION_MESSAGE);
						found = true;
						break whileloop;
					}
					
					//get price variable
					String price = aScanner.next();
					
					//Make the price with the inclusion of quantity and discount final/total
					Double pay_amount = Double.parseDouble(price);
					
					//make discount determiner basedf of item
					Integer discount = null;
					Double precentage_off = null;
					if(search_amount_avail <= 4)
					{
						discount = 0;
						precentage_off = .00;
						
						pay_amount = (pay_amount * search_amount_avail);
					}
					if(search_amount_avail >= 5 && search_amount_avail <= 9)
					{
						discount = 10;
						precentage_off = .10;
						
						Double discount_off = (pay_amount * search_amount_avail);
						pay_amount = discount_off - (discount_off * precentage_off);
					}
					if(search_amount_avail >= 10 && search_amount_avail <= 14)
					{
						discount = 15;
						precentage_off = .15;
						
						Double discount_off = (pay_amount * search_amount_avail);
						pay_amount = discount_off - (discount_off * precentage_off);
					}
					if(search_amount_avail >= 15)
					{
						discount = 20;
						precentage_off = .20;
						
						Double discount_off = (pay_amount * search_amount_avail);
						pay_amount = discount_off - (discount_off * precentage_off);
					}
					String formattedPrice = currencyFormat.format(pay_amount);
					
					
					
					found = true;
					
					
					
					item_text_field.setText(itemIDFromFile +" "+ cartArray[count] + " " + "$" + price + " " + searchQty + " " + discount + "% " + formattedPrice);
								
					
					//put item into cartLine array with all the data that has to be shown
					ItemID = itemIDFromFile;
					ItemName = cartArray[count];
					Price = price;
					price_to_pay_total = pay_amount;
					Quantity = searchQty;
					Discount = discount;
					Full_price = formattedPrice;
					
					//update the buttons to gui
					confirm_B.setEnabled(true);
					process_B.setEnabled(false);
					
					
					break whileloop;
				}
				else
				{
					inventoryLine = inputBufReader.readLine();
				}
			}
			if(found == false)
			{
				String title = "NILE Dot Com - ERROR";
				System.out.println("Search item not in file");
				JFrame frameSS = new JFrame("Not Existing");
				JOptionPane.showMessageDialog(frameSS, "item ID " + searchItem + " does not exist", title, JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		
		catch (FileNotFoundException fileNotFoundException) {
			JOptionPane.showMessageDialog(null,  "Error: File not found", "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
		}
		catch(IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error: Problem reading from file", "Nile DOt Com - ERROR" , JOptionPane.ERROR_MESSAGE);
		}
		
	} 
}

private class view_button_implement implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		
		StringBuilder formattedData = new StringBuilder();
		for (int i = 0; i < itemCount; i++)
		{
			formattedData.append((i + 1)).append(". ").append(Data.get(i)).append("\n");
		}
		
		String title = "NILE Dot Com - Current Shopping Cart Status";
		JFrame frame_snipit = new JFrame("View Cart");
		
		JOptionPane.showMessageDialog(frame_snipit,formattedData.toString() , title, JOptionPane.INFORMATION_MESSAGE);
	}
}

private class finish_button_implement implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		
		Tax = SubTotal * .06;
		Double Total = Tax + SubTotal;
		
		String formatTotal = currencyFormat.format(Total);
		
		String formatTax = currencyFormat.format(Tax);

		ZonedDateTime currentDateTime = ZonedDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm:ss z");
		String formatDateTime = currentDateTime.format(format);
		
		
		
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss", Locale.FRENCH);
        String formattedDateTime = now.format(formatter);
		
		
        String formatSub = currencyFormat.format(SubTotal);
	
		StringBuilder formattedData = new StringBuilder();
		for (int i = 0; i < itemCount; i++)
		{
			formattedData.append((i + 1)).append(". ").append(Data.get(i)).append("\n");
		}
		
		String title = "NILE Dot Com - Final Invoice";
		JFrame frame_snipit = new JFrame("Invoice");
		
		String line1 = "Date: " + formatDateTime;
		String line2 = "Number of line items: " + itemCount;
		String line3 = "Item# / ID / Title / Price / Qty / Disc % / Subtotal:";
		String line4 = formattedData.toString();
		String line5 = "Order Subtotal: " + formatSub;
		String line6 = "Tax rate:  6%";
		String line7 = "Tax amount:  " + formatTax;
		String line8 = "Order Total:  " + formatTotal;
		String line9 = "Thanks for shopping at Nile Dot Com!";
		
		String message_general = line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" + line5 + "\n" + line6 + "\n" + line7 + "\n" + line8 + "\n" + line9;
		
		StringBuilder contentBuilder = new StringBuilder();
		
		for (int i = 0; i < itemCount; i++)
		{
			contentBuilder.append(formattedDateTime).append(", ").append(Data.get(i)).append(" ").append(formatDateTime).append("\n");
		}
		
		
		JOptionPane.showMessageDialog(frame_snipit, message_general , title, JOptionPane.INFORMATION_MESSAGE);
		
		try (FileWriter fileWriter = new FileWriter("transactions.csv", true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
	
					bufferedWriter.write(contentBuilder.toString());
				} 
		
		catch (IOException e1)
				{
					e1.printStackTrace();
				}

		
		resetGUI();
	}
}

private class confirm_button_implement implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		number++;
		

		if(number ==5)
		{
			confirm_B.setEnabled(false);
			process_B.setEnabled(false);
			
			id_number_text_field.setEditable(false);
			id_number_text_field.setVisible(false);
			id_number_text_field.setBackground(Color.DARK_GRAY);
			quantity_text_field.setEditable(false);
			quantity_text_field.setVisible(false);
			quantity_text_field.setBackground(Color.DARK_GRAY);
			cartLineArray[count].setText("Item " + (itemCount+1) + " - SKU: " + ItemID + ", Desc: " + ItemName + ", Price Ea. $" + Price + " Qty: " + Quantity + ", Total: " + Full_price);
			itemCount++;
			
		}
		else {
		cartLineArray[count].setText("Item " + (itemCount+1) + " - SKU: " + ItemID + ", Desc: " + ItemName + ", Price Ea. $" + Price + " Qty: " + Quantity + ", Total: " + Full_price);
		id_number_text_field.setText("");
		quantity_text_field.setText("");
		process_B.setEnabled(true);
		confirm_B.setEnabled(false);
		itemCount++;
		count++;
		}
		
		
		view_B.setEnabled(true);
		finish_B.setEnabled(true);
		
		id_number_label.setText("Enter item ID for Item #" + (itemCount+1) + ":");
		quantity_label.setText("Enter quantity for Item #" + (itemCount+1) + ":");
		total_items_label.setText("Current Subtotal for "+ (itemCount) + " item(s)");
		cart_label.setText("Your Current Shopping Cart With "+ (itemCount) + " Item(s)");
		process_B.setText("Find item #" + (itemCount+1));
		
		Data.add(item_text_field.getText());
		

		Double pay_amount = Double.parseDouble(Price);
		SubTotal += price_to_pay_total;
		String FormattedSub = currencyFormat.format(SubTotal);
		total_text_field.setText(FormattedSub);
		
		
	}
}

private class new__button_implement implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		resetGUI();
	}	
}

private class exit_button_implement	 implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}

private void resetGUI() {
	
	itemCount = 0;
	count = 0;
	SubTotal = 0.0;
	number = 0;
	Data.clear();
	
	id_number_label.setText("Enter item ID for Item #" + (itemCount+1) + ":");
	quantity_label.setText("Enter quantity for Item #" + (itemCount+1) + ":");
	total_items_label.setText("Current Subtotal for "+ (itemCount) + " item(s)");
	cart_label.setText("Your Current Shopping Cart With "+ (itemCount) + " Item(s)");
	item_name_label.setText("Details for Item #" + (itemCount+1) + ":");
	process_B.setText("Find item #" + (itemCount+1));
	
	id_number_text_field.setText("");
	quantity_text_field.setText("");
	item_text_field.setText("");
	total_text_field.setText("");
	
	for (int i = 0; i < 5; i++)
	{
		cartLineArray[i].setText("");
	}
	
	id_number_text_field.setEditable(true);
	id_number_text_field.setVisible(true);
	id_number_text_field.setBackground(Color.WHITE);
	quantity_text_field.setEditable(true);
	quantity_text_field.setVisible(true);
	quantity_text_field.setBackground(Color.WHITE);
	
	process_B.setText("Find Item #" + (itemCount + 1));
	confirm_B.setText("Add item #" + (itemCount + 1));
	
	confirm_B.setEnabled(false);
    view_B.setEnabled(false);
    finish_B.setEnabled(false);
    process_B.setEnabled(true);
    finish_B.setEnabled(false);
}	

public static void main(String [] args)
{
	JFrame newStore = new Project1(); //creates frame object
	newStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	newStore.setLocationRelativeTo(null);
	newStore.setVisible(true); //display the frame
}

}
