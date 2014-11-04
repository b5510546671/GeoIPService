package main;

import view.Gui;
import controller.GeoIPServiceController;

/**
 * The main class of this project.
 * @author Supavit 5510546671
 * @version 2014.11.04
 *
 */
public class Main {
	/**
	 * The main method that controls the whole application.
	 * @param args command line arguments
	 */
	public static void main(String[] args){
		Gui ui = Gui.getInstance();
		GeoIPServiceController controller = new GeoIPServiceController();
		ui.setController(controller);
		ui.run();
	}
}
