package main;

import view.Gui;
import controller.GeoIPServiceController;

/**
 * The main class of this project.
 * @author Supavit 5510546671
 * @version 2014.10.31
 *
 */
public class Main {
	/**
	 * The main method that controls the whole application.
	 * @param args command line arguments
	 */
	public static void main(String[] args){
		Gui ui = new Gui();

		GeoIPServiceController controller = new GeoIPServiceController();

		ui.setController(controller);
		ui.run();
	}
}
