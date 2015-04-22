package de.cynapsys.homeautomation.upnp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

/**
 *
 * @author DrLabman
 */
public class IPUtil {
	public static String getInternalIPAddress(){
		try {
			InetAddress addr = InetAddress.getLocalHost();
			// Get IP Address
			return addr.getHostAddress();
			//String hostname = addr.getHostName();
		} catch (UnknownHostException ex) {
		}
		return null;
	}
	
	public static void printInternalIP(){
		// Get IP Address
		String ipAddr = IPUtil.getInternalIPAddress();
		//String hostname = addr.getHostName();
		System.out.println("Internal (local) clients should use the address: " + ipAddr);
	}
	
	public static String getExternalIPAddress(){
		BufferedReader in = null;
		try {
//			URL whatismyip = new URL("http://myip.dnsomatic.com");
//			in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
//			return in.readLine(); //you get the IP as a String
                        
                        URL whatismyip = new URL("http://checkip.amazonaws.com");
                        
                        URLConnection connection = whatismyip.openConnection();
                        connection.addRequestProperty("Protocol", "Http/1.1");
                        connection.addRequestProperty("Connection", "keep-alive");
                        connection.addRequestProperty("Keep-Alive", "1000");
                        connection.addRequestProperty("User-Agent", "Web-Agent");
                        
                        in = new BufferedReader(new InputStreamReader(
                                        whatismyip.openStream()));

                        return in.readLine(); //you get the IP as a String  
		} catch (IOException ex) {
		} finally {
			try { in.close(); } catch (IOException ex) {}
		}
		return null;
	}
	
	public static void printExternalIP(){
		// Get IP Address
		String ipAddr = getExternalIPAddress();
		if (ipAddr != null){
			System.out.println("External (internet) clients should use the address: " + ipAddr);
		} else {
			System.out.println("Exception while attempting to get external ip address.");
		}
	}
}
