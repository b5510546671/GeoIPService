package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * A class for creating the User Interface.
 * @author Supavit 5510546671
 * @version 2014.10.31
 *
 */
public class Gui extends JFrame{
	
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
	
	/**
	 * Initializes a new user interface.
	 */
	public Gui(){
		setTitle("GeoIP Service");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(700,100));
		initComponents();
	}
	
	public void initComponents(){
		inputLabel = new JLabel("IP address: ");
		
		countryLabel = new JLabel();
		
		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new SubmitBtn());
		submitBtn.addKeyListener(new SubmitBtn());
		
		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ClearBtn());
		
		ipField = new JTextField("...IP address...",25);
		ipField.grabFocus();
		
		panel = new JPanel();
		
		panel.add(inputLabel);
		panel.add(ipField);
		panel.add(submitBtn);
		panel.add(clearBtn);
		add(panel);
	}
	
	/**
	 * Run the user interface.
	 */
	public void run(){
		pack();
		setVisible(true);
	}
	
	
	/**
	 * Submit Button action.
	 * @author Supavit 5510546671
	 *
	 */
	class SubmitBtn implements ActionListener, KeyListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//startFeedRss(urlField.getText());
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				//startFeedRss(urlField.getText());
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
			
		}
		
	}
}
