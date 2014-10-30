package main;

import net.webservicex.*;

public class Main {
	public static void main(String[] args){
		GeoIPService service = new GeoIPService();
		
		GeoIPServiceSoap proxy = service.getGeoIPServiceSoap();
		
		String userIPAddress = "165.132.13.37";
		GeoIP country = proxy.getGeoIP(userIPAddress);
		
		System.out.println(country.getCountryName() + " " + country.getCountryCode());
		
	}
}
