package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

/**
 * A class that creates and show the progress bar.
 * @author Supavit 5510546671
 * @version 2014.11.16
 *
 */
public class ProgressBar extends JFrame{
	
	/** Panel that contains progress bar. */
	private JPanel progressPanel;
	
	/** Progress bar */
	private JProgressBar bar;
	
	public ProgressBar(){
		init();
	}
	
	/**
	 * Initializes all components.
	 */
	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		progressPanel = new JPanel();
		
		bar = new JProgressBar();
		bar.setStringPainted(true);
		bar.setString("Requesting");
		bar.setIndeterminate(true);
		bar.setForeground(Color.red);
		bar.setBackground(Color.black);
				
		progressPanel.add(bar);
		add(progressPanel);
		pack();
		setVisible(true);
	}
	
	/**
	 * Close progress bar.
	 */
	public void stopProgressBar(){
		bar.setIndeterminate(false);
		bar.setString("Done");
		setVisible(false);
		dispose();
	}
}
