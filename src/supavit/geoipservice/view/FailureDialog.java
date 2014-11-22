package supavit.geoipservice.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Dialog Box to inform connection failure
 * 		to user.
 * @author Supavit 5510546671
 * @version 2014.11.22
 *
 */
public class FailureDialog extends JFrame{
	
	/** Label that tells connection failure. */
	private JLabel textLabel;
	
	/** Panel that contains all labels and buttons. */
	private JPanel panel;
	
	/** Retry button. */
	private JButton retryBtn;
	
	/** Exit button. */
	private JButton exitBtn;
	
	/** Gui instance. */
	private Gui gui = Gui.getInstance();
	
	public FailureDialog(){
		setTitle("Error");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}
	
	/**
	 * Initializes all the components.
	 */
	public void init(){
		
		textLabel = new JLabel("Connection failure. Please try again later.");
		
		panel = new JPanel();
		
		retryBtn = new JButton("Retry");
		retryBtn.addActionListener( new RetryBtn() );
		
		exitBtn = new JButton("Exit");
		exitBtn.addActionListener( new ExitBtn() );
		
		panel.add(textLabel);
		panel.add(retryBtn);
		panel.add(exitBtn);
		add(panel);
		
		pack();
		setVisible(true);
		setLocation(300, 100);
	}
	
	/**
	 * Exit button action.
	 * @author Supavit 5510546671
	 * @version 2014.11.22
	 *
	 */
	class ExitBtn implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			dispose();
			gui.setVisible(false);
			gui.dispose();
		}
		
	}
	
	/**
	 * Retry button action.
	 * @author Supavit 5510546671
	 * @version 2014.11.22
	 *
	 */
	class RetryBtn implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			gui.startGeoIPService(gui.getIP());
			setVisible(false);
		}

		
	}
}
