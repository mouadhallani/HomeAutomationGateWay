/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.webservice;

import de.cynapsys.homeautomation.entity.Device;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author mouadh
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface DeviceWebService {
    
    @WebMethod
    ArrayList<Device> getAllDevices();
    
    @WebMethod 
    Device getDeviceByID(@WebParam(name = "deviceID") Long deviceID);
    
    @WebMethod
    int getValue(@WebParam(name = "deviceID") Long deviceID);
    
    @WebMethod
    boolean setValue(@WebParam(name = "deviceID") Long deviceID, @WebParam(name = "value") int value);
    
    @WebMethod
    void addDevice(@WebParam(name = "device")Device device);
    
    @WebMethod
    boolean deleteDevice(@WebParam(name = "deviceID") Long deviceID);
    
    @WebMethod
    boolean updateDevice(@WebParam(name = "device")Device device);
    
}
