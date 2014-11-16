package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.InetAddress;

import javax.swing.*;

import controller.GeoIPServiceController;

/**
 * A class for creating the User Interface.
 * @author Supavit 5510546671
 * @version 2014.11.16
 *
 */
public class Gui extends JFrame{
	
	/** Controller of the application */
	private GeoIPServiceController controller;
	
	/** Label for the word 'IP address' */
	private JLabel inputLabel;
	
	/** The country of the input IP address */
	private JLabel countryLabel;
	
	/** Submit input button */
	private JButton submitBtn;
	
	/** Clear text field button */
	private JButton clearBtn;
	
	/** Text field for user to input IP address */
	private JTextField ipField;
	
	/** Panel for keeping all user interface components */
	private JPanel panel;
	
	/** Progress bar that is shown during making request. */
	private ProgressBar bar;
	
	/** Instance of graphical user interface for this class */
	private static Gui instance = new Gui();
	
	/**
	 * Initializes a new user interface.
	 */
	public Gui(){
		setTitle("GeoIP Service");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(530,110));
		setResizable(false);
		initComponents();
	}
	
	/**
	 * Get instance of this class.
	 * @return instance of this class
	 */
	public static Gui getInstance(){
		return instance;
	}
	
	/**
	 * Initialize all components on the screen.
	 */
	public void initComponents(){
		inputLabel = new JLabel("IP address: ");
		
		countryLabel = new JLabel();
		
		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new SubmitBtn());
		submitBtn.addKeyListener(new SubmitBtn());
		getRootPane().setDefaultButton(submitBtn);
		
		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ClearBtn());
		
		ipField = new JTextField("158.108.212.12",25);
		ipField.grabFocus();
		
		panel = new JPanel();
		
		panel.add(inputLabel);
		panel.add(ipField);
		panel.add(submitBtn);
		panel.add(clearBtn);
		panel.add(countryLabel, BorderLayout.PAGE_END);
		add(panel);
	}
	
	/**
	 * Set controller of this user interface.
	 * @param controller the controller to be set
	 */
	public void setController(GeoIPServiceController controller){
		this.controller = controller;
	}
	
	/**
	 * Get controller of this user interface.
	 * @return controller of this user interface
	 */
	public GeoIPServiceController getController(){
		return this.controller;
	}
	
	/**
	 * Starting the GeoIP Service by asking the country name 
	 * 		from the controller and sending	the given IP address 
	 * 		to the controller at the same time.
	 * @param ipAddress the given IP address
	 */
	public void startGeoIPService(String ipAddress){
		this.controller.retrieveCountryFromIPAddress(ipAddress);
	}
	
	/**
	 * Set name of country to the label.
	 * @param countryName name of country to be set
	 */
	public void setCountryLabel(String countryName){
		this.countryLabel.setText(countryName);
	}
	
	/**
	 * Show dialog box for error message due to
	 * 		Internet connection failure.
	 */
	public void handleConnectionFailure(){
		JOptionPane.showMessageDialog(this, 
				"Connection failure. Please try again later.",
			    "Error.",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Show dialog box for error message due to
	 * 		invalid IP address.
	 */
	public void handleMalformedIPAddress(){
		JOptionPane.showMessageDialog(this,
			    "Invalid IP address. Please check your input IP address.",
			    "Error.",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Show progress bar during making request to the server.
	 */
	public void showProgressbar(){
		bar = new ProgressBar();
	}
	
	/**
	 * Close progress bar when the country name is shown.
	 */
	public void closeProgressbar(){
		bar.stopProgressBar();
	}
	/**
	 * Run the user interface.
	 */
	public void run(){
		pack();
		setVisible(true);
		setLocation(300, 100);
	}
	
	
	/**
	 * Submit Button action.
	 * @author Supavit 5510546671
	 *
	 */
	class SubmitBtn implements ActionListener, KeyListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			startGeoIPService(ipField.getText());
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				startGeoIPService(ipField.getText());
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
	}
	
	/**
	 * Clear Button action.
	 * @author Supavit 5510546671
	 *
	 */
	class ClearBtn implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ipField.setText("");
			ipField.grabFocus();
			countryLabel.setText("");
		}
		
	}
}
