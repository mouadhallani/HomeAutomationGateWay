/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.webserviceImpl;

import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Room;
import de.cynapsys.homeautomation.service.RoomService;
import de.cynapsys.homeautomation.serviceImpl.RoomServiceImpl;
import de.cynapsys.homeautomation.webservice.RoomWebService;
import java.util.ArrayList;
import javax.jws.WebService;

/**
 *
 * @author mouadh
 */

@WebService(endpointInterface = "de.cynapsys.homeautomation.webservice.RoomWebService")
public class RoomWebServiceImpl implements RoomWebService{

    
//            ClassPathXmlApplicationContext cpx; 
//        RoomService roomService;
    

    RoomService roomService = new RoomServiceImpl();
        
//    public RoomWebServiceImpl() {
//        
//                cpx = new ClassPathXmlApplicationContext("classpath:config/spring-config.xml");
//        roomService = cpx.getBean(RoomService.class);
//    }
    
    @Override
    public Room getRoomById(Long roomID) {
        return roomService.getRoomById(roomID);
    }

    @Override
    public Long addRoom(Room room) {
        return roomService.addRoom(room);
    }

    @Override
    public boolean updateRoom(Room room) {

          return  roomService.updateRoom(room);

    }

    @Override
    public boolean deleteRoom(Long roomID) {

           return roomService.deleteRoom(roomID);

    }

    @Override
    public boolean attachDeviceToRoom(Device device, Long roomID) {
        try{
            Room r = getRoomById(roomID);
            ArrayList<Device> deviceList = (ArrayList)r.getDevices();
            deviceList.add(device);
            roomService.updateRoom(r);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean detachDeviceFromRoom(Device device, Long roomID) {
        try{
            Room r = getRoomById(roomID);
            ArrayList<Device> deviceList = (ArrayList)r.getDevices();
            deviceList.remove(device);
            roomService.updateRoom(r);
            return true;
        }
        catch (Exception e){
            return false;
        }
    
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        return (ArrayList) roomService.getAllRooms();
    }
    
}
