package de.cynapsys.homeautomation.upnp;


import org.teleal.cling.UpnpService;
import org.teleal.cling.UpnpServiceImpl;
import org.teleal.cling.model.meta.Action;
import org.teleal.cling.model.meta.ActionArgument;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.meta.Service;
import org.teleal.cling.model.types.UDAServiceId;
import org.teleal.cling.registry.DefaultRegistryListener;
import org.teleal.cling.registry.Registry;
import org.teleal.cling.registry.RegistryListener;
import org.teleal.cling.support.igd.PortMappingListener;
import org.teleal.cling.support.model.PortMapping;

/**
 * Handles UPnP calls needed for the server to automatically open a port on a
 * router.
 * 
 * @author DrLabman
 */
public class UPnP {
	private static UpnpService upnpService = null;
	
	/**
	 * Start up the upnpService and register the port
	 * 
	 * @param port 
	 */
	public static void RegisterPort(int port){
		if (upnpService != null){
			System.out.println("Warning: UPnP service already started, will shutdown and restart.");
			UnregisterPort();
		}
				
		String ipAddr = IPUtil.getInternalIPAddress();
		if (ipAddr != null){
			// Port Mapping
			PortMapping desiredMapping = new PortMapping(port, ipAddr, PortMapping.Protocol.TCP, "Home Automation Port Mapping");
			upnpService = new UpnpServiceImpl( new PortMappingListener(desiredMapping));//, CreateListenerToPrintUPnPDeviceData());
			                 System.out.println(upnpService.getRouter());
                        upnpService.getControlPoint().search();
		} else {
			System.out.println("Error getting internal IP address.");
			System.out.println("Unable to setup UPnP NAT port mapping without IP address.");
		}
	}
	
	/**
	 * Shutdown the upnpService to unregister the port mapping.
	 */
	public static void UnregisterPort(){
		if (upnpService != null)
			upnpService.shutdown();
		
		upnpService = null;
	}
	
}
