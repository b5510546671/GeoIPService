package controller;

import model.Service;

/**
 * Controller that links between model and view.
 * @author Supavit 5510546671
 * @version 2014.11.04
 *
 */
public class GeoIPServiceController {
	
	public GeoIPServiceController(){}
	
	/**
	 * Make a contact with model to send the input IP address 
	 * 		from view and get the result back from model to
	 * 		return to view. 
	 * @param ipAddress the IP address from user
	 */
	public void retrieveCountryFromIPAddress(String ipAddress){
		Service service = new Service();
		service.checkIP(ipAddress);
	}
	
}
