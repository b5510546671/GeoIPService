package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	/** Pattern of the IPv4 address */
	private static final String PATTERN = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	
	public Service(){
		
	}
	
	/**
	 * Check if the IP is in the IPv4 address format.
	 * @param userIPAddress the IP address from the user
	 * @return country name if the IP is correct, 
	 * 		"Invalid IP address" statement otherwise
	 */
	public String checkIP(String userIPAddress){
		if(!validateIPAddress(userIPAddress)) return "Invalid IP address";
		return IPAddressService(userIPAddress);
	}
	
	/**
	 * Creating the GeoIPService and get the country name of the provided IP address.
	 * @param userIPAddress the IP address from the user.
	 * @return country of that IP address
	 */
	public String IPAddressService(String userIPAddress){
		try{
			GeoIPService service = new GeoIPService();
			
			GeoIPServiceSoap proxy = service.getGeoIPServiceSoap();
			
			GeoIP country = proxy.getGeoIP(userIPAddress);
			
			return country.getCountryName();
		} catch(Exception e){
			return "Some error has occured. Please try again later.";
		}
	}
	
	/**
	 * Validates the IP address from user.
	 * @param ipAddress IP address from user
	 * @return true if valid, false otherwise
	 */
	public boolean validateIPAddress(String ipAddress){          
		Pattern pattern = Pattern.compile(PATTERN);
	    Matcher matcher = pattern.matcher(ipAddress);
	    return matcher.matches();             
	}
	
}
