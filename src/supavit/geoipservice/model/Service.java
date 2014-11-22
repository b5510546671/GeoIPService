package supavit.geoipservice.model;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingWorker;

import supavit.geoipservice.view.Gui;
import net.webservicex.*;

/**
 * A class that uses the GeoIPService, get country
 * 		from a given IP address. It also contacts 
 * 		with the web service.
 * 
 * @author Supavit 5510546671
 * @version 2014.11.22
 *
 */
public class Service extends SwingWorker<String, Void> {
	
	/** Pattern of the IPv4 address */
	private static final String PATTERN = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	
	/** GUI instance */
	private Gui gui = Gui.getInstance();
	
	/** The input IP address. */
	private String userIPAddress = "";
	
	public Service(){
		
	}
	
	/**
	 * Check if the IP is in the IPv4 address format.
	 * @param userIPAddress the IP address from the user
	 */
	public void checkIP(String userIPAddress){
		this.userIPAddress = userIPAddress;
		if(!validateIPAddress(userIPAddress)){
			gui.handleMalformedIPAddress();
			return;
		}
		try {
			this.execute();
	
		} catch (Exception e) {
			gui.setCountryLabel("Some error has occured.");
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

	@Override
	protected String doInBackground() throws Exception {
		try{
			gui.showProgressbar();
			
			this.get(15, TimeUnit.SECONDS);
			
			GeoIPService service = new GeoIPService();
			
			GeoIPServiceSoap proxy = service.getGeoIPServiceSoap();
			
			String countryName = proxy.getGeoIP(userIPAddress).getCountryName();
			
			return countryName;
		} catch(Exception e){
			gui.handleConnectionFailure();
			return "";
		}
	}
	@Override
	protected void done() {
		super.done();
		try {
			gui.closeProgressbar();
			gui.setCountryLabel(get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
}
