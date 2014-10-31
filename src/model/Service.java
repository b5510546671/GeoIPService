package model;

import net.webservicex.*;

/**
 * A class that uses the GeoIPService, get country
 * 		from a given IP address. It also contacts 
 * 		with the web service.
 * 
 * @author Supavit 5510546671
 * @version 2014.10.31
 *
 */
public class Service {
	
	/**
	 * Creating the GeoIPService and get the country name of the provided IP address.
	 * @param userIPAddress the IP address from the user.
	 * @return country of that IP address
	 */
	public String IPAddressService(String userIPAddress){
		GeoIPService service = new GeoIPService();
		
		GeoIPServiceSoap proxy = service.getGeoIPServiceSoap();
		
		GeoIP country = proxy.getGeoIP(userIPAddress);
		
		return country.getCountryName();
		
	}
}
