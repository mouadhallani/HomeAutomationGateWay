/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.webservice;

import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Room;
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
public interface RoomWebService {
    
    
    @WebMethod
    ArrayList<Room> getAllRooms();
    
    @WebMethod
    Room getRoomById(@WebParam(name = "roomID") Long roomID);
    
    @WebMethod
    void addRoom(@WebParam(name = "room")Room room);
    
    @WebMethod
    boolean updateRoom(@WebParam(name = "room")Room room);
    
    @WebMethod
    boolean deleteRoom(@WebParam(name = "roomID") Long roomID);
    
    @WebMethod
    boolean attachDeviceToRoom(@WebParam(name = "device") Device device,@WebParam(name = "roomID") Long roomID);
    
    @WebMethod
    boolean detachDeviceFromRoom(@WebParam(name = "device") Device device,@WebParam(name = "roomID") Long roomID);
    
}
