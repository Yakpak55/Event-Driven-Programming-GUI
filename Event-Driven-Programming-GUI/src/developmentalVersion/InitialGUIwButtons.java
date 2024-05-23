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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialGUIwButtons extends JFrame{

	//Static variable for frame dimensions
	private static final int Width = 700;
	private static final int Height = 600;
	
	private JLabel	blankLabel, controlLabel, idLabel, qtyLabel, itemLabel, totalLabel, cartLabel;
	private JButton	blankB, processB, confirmB, viewB, finishB, newB, exitB; 
	private JTextField blankTextFieldS, blankTextField, blankTextField2, blankTextField3, blankTextField4, blankTextField5, idTextField, qtyTextField, itemTextField, totalTextField;
	
	
	private ProcessBHandler		procBHandler;
	private ConfirmBHandler		confBHandler;
	private ViewBHandler		viewBHandler;
	private FinishBHandler		finBHandler;
	private NewBHandler			newBHandler;
	private	ExitBHandler		exitBHandler;
	
	//more static variables for formatting currency, percentages, and decimal values
	
	//define arrays for holding items in cart
	
	static int MaxItems = 5;
	static int itemCount = 0;
	
public InitialGUIwButtons()

{
	
	setTitle("Nile.com  - Spring 2024"); //Title of frame
	setSize(Width, Height); //frame size
	
	//make JLabel objects
	blankB = new JButton(" ");
	blankLabel = new JLabel(" ",SwingConstants.RIGHT);
	
//what is written out on the north panel	
	idLabel = new JLabel("Enter item ID for Item #" + (itemCount+1) + ":", SwingConstants.RIGHT);
	qtyLabel = new JLabel("Enter quantity for Item #" + (itemCount+1) + ":", SwingConstants.RIGHT);
	itemLabel = new JLabel("Details for Item #" + (itemCount+1) + ":", SwingConstants.RIGHT);
	totalLabel = new JLabel("Current Subtotal for " + (itemCount) + " item(s):", SwingConstants.RIGHT);
	cartLabel = new JLabel("Your Shopping Cart Is Empty", SwingConstants.CENTER);
	
	controlLabel = new JLabel(" USER CONTROLS ", SwingConstants.RIGHT);
	
	
//Inistiate JTextField objects
	
	blankTextField = new JTextField();
	blankTextFieldS = new JTextField();
	blankTextField2 = new JTextField();
	blankTextField3 = new JTextField();
	blankTextField4 = new JTextField();
	blankTextField5 = new JTextField();
	idTextField = new JTextField();
	qtyTextField = new JTextField();
	itemTextField = new JTextField();
	totalTextField = new JTextField();
	
	
	
	
	processB = new JButton("Find item #" + (itemCount+1));
	procBHandler = new ProcessBHandler();
	processB.addActionListener(procBHandler);
	
	confirmB = new JButton("Add item #"+ (itemCount + 1) + "To Cart");
	confBHandler = new ConfirmBHandler();
	confirmB.addActionListener(confBHandler);
	
	viewB = new JButton("View Cart");
	viewBHandler = new ViewBHandler();
	viewB.addActionListener(viewBHandler);
	
	finishB = new JButton ("Check Out");
	finBHandler = new FinishBHandler();
	finishB.addActionListener(finBHandler);
	
	newB = new JButton ("Empty Cart - Start A New Order");
	newBHandler = new NewBHandler();
	newB.addActionListener(newBHandler);
	
	exitB = new JButton("Exit (Close App)");
	exitBHandler = new ExitBHandler();
	exitB.addActionListener(exitBHandler);
	
	
	confirmB.setEnabled(true);
	viewB.setEnabled(true);
	finishB.setEnabled(true);
	blankTextFieldS.setEditable(false);
	blankTextFieldS.setBackground(Color.DARK_GRAY);
	blankTextFieldS.setVisible(false);
	totalTextField.setEditable(false);
	itemTextField.setEditable(false);
	blankTextField.setEditable(false);
	blankTextField2.setEditable(false);
	blankTextField3.setEditable(false);
	blankTextField4.setEditable(false);
	blankTextField5.setEditable(false);
	
	
	
	blankB.setBackground(Color.DARK_GRAY);
	blankB.setVisible(false);
	
	
	Container pane = getContentPane(); //content pane for frame
	
	GridLayout grid1 = new GridLayout(6,2,8,8); //a 6 by 2 grid
	GridLayout grid2 = new GridLayout(7,2,10,4); //a 7 by 2 grid
	GridLayout grid3 = new GridLayout(5,1,2,2); //a 5 by 1 grid
	
	//creating panels using border layout n = north, c = center, s = south
	JPanel nPanel = new JPanel();
	JPanel cPanel = new JPanel();
	JPanel sPanel = new JPanel();
	
	//set pane layouts
	nPanel.setLayout(grid1);
	cPanel.setLayout(grid2);
	sPanel.setLayout(grid1);
	
	//add panels to content pane
	pane.add(nPanel, BorderLayout.NORTH);
	pane.add(cPanel, BorderLayout.CENTER);
	pane.add(sPanel, BorderLayout.SOUTH);
	
	//style the backgrounds
	pane.setBackground(Color.DARK_GRAY);
	nPanel.setBackground(Color.DARK_GRAY);
	cPanel.setBackground(Color.LIGHT_GRAY);
	sPanel.setBackground(Color.green);
	
	
//	centerFrame(Width, Height);
	
	nPanel.add(blankLabel);
	nPanel.add(blankTextFieldS);
	idLabel.setForeground(Color.YELLOW);
	nPanel.add(idLabel);
	nPanel.add(idTextField);
	qtyLabel.setForeground(Color.YELLOW);
	nPanel.add(qtyLabel);
	nPanel.add(qtyTextField);
	itemLabel.setForeground(Color.RED);
	itemLabel.setFont(new Font("Calibri", Font.BOLD, 14));
	nPanel.add(itemLabel);
	nPanel.add(itemTextField);
	nPanel.add(totalLabel);
	nPanel.add(totalTextField);
	
	totalLabel.setFont(new Font("Calibri", Font.BOLD, 14));
	totalLabel.setForeground(Color.BLUE);
	
	cPanel.add(cartLabel);
	cartLabel.setHorizontalAlignment(JLabel.CENTER);
	cartLabel.setForeground(Color.RED);
	cartLabel.setFont(new Font("Calibri", Font.BOLD, 14));
	
	cPanel.add(blankTextField);
	cPanel.add(blankTextField2);
	cPanel.add(blankTextField3);
	cPanel.add(blankTextField4);
	cPanel.add(blankTextField5);
	
	
	sPanel.add(controlLabel);
	controlLabel.setHorizontalAlignment(JLabel.CENTER);
	sPanel.add(blankB);

	
// Added the north panel words that show up next to the blank fields	
	//nPanel.add(blankB);
	
	
//	nPanel.add(idLabel);
//	idLabel.setHorizontalAlignment(JLabel.LEFT);
//	
//	nPanel.add(qtyLabel);
//	qtyLabel.setHorizontalAlignment(JLabel.LEFT);
//	
//	nPanel.add(itemLabel);
//	itemLabel.setHorizontalAlignment(JLabel.LEFT);
//	
//	nPanel.add(totalLabel);
//	totalLabel.setHorizontalAlignment(JLabel.LEFT);

//Initializing the south panel buttons	
	sPanel.add(processB);
	sPanel.add(confirmB);
	sPanel.add(viewB);
	sPanel.add(finishB);
	sPanel.add(newB);
	sPanel.add(exitB);
	
	
}

public void centerFrame(int fWidth, int fHeight)
{
//	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//	
//	
//	int xPositionFrame = (screen.width - fWidth / 2);
//	int yPositionFrame = (screen.height - fHeight / 2);
//	
//	setBounds(xPositionFrame, yPositionFrame, fWidth, fHeight);
	
}

private class ProcessBHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("The Find Item Button Was Clicked...");
		
	} 
}

private class ViewBHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("The View Cart Button Was Clicked..");
	}
}

private class FinishBHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("The Check Out Button Was Clicked...");
	}
}

private class ConfirmBHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("The Add Item To Cart Button Was Clicked..");
	}
}

private class NewBHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Empty Cart Button Was Clicked..");
	}	
}

private class ExitBHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Exit Button Was Clicked...");
		System.exit(0);
	}
}
public static void main(String [] args)
{
	JFrame newStore = new InitialGUIwButtons(); //create frame object
	newStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	newStore.setLocationRelativeTo(null);
	newStore.setVisible(true); //display frame
}

}
