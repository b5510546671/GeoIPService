package controller;

import model.Service;
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
	
	/**
	 * Make a contact with model to send the input IP address 
	 * 		from view and get the result back from model to
	 * 		return to view. 
	 * @param ipAddress the IP address from user
	 * @return country name of that IP
	 */
	public String retrieveCountryFromIPAddress(String ipAddress){
		Service service = new Service();
		String countryName = service.checkIP(ipAddress);
		return countryName;
	}
}
