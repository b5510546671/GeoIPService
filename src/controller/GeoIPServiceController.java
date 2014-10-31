package controller;

import view.Gui;

/**
 * Controller that links between model and view.
 * @author Supavit 5510546671
 * @version 2014.10.31
 *
 */
public class GeoIPServiceController {
	
	public GeoIPServiceController(){
		
	}
	
	public void start(){
		Gui ui = new Gui();
		ui.run();
	}
}
