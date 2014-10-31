package view;

import java.awt.Dimension;

import javax.swing.*;

public class Gui extends JFrame{
	
	private JLabel countryLabel;
	
	private JButton submitBtn;
	
	private JButton clearBtn;
	
	private JTextField ipField;
	
	
	/**
	 * Initializes a new user interface.
	 */
	public Gui(){
		setTitle("GeoIP Service");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1135,500));
		initComponents();
	}
	
	public void initComponents(){
		
	}
	
	/**
	 * Run the user interface.
	 */
	public void run(){
		pack();
		setVisible(true);
	}
}
