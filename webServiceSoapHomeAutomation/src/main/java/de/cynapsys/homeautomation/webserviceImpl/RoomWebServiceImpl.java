/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.webserviceImpl;

import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Room;
import de.cynapsys.homeautomation.service.RoomService;
import de.cynapsys.homeautomation.webservice.RoomWebService;
import java.util.ArrayList;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author mouadh
 */
@Component("RoomWebServiceImpl")
@Scope("session")
@WebService(endpointInterface = "de.cynapsys.homeautomation.webservice.RoomWebService")
public class RoomWebServiceImpl implements RoomWebService{

    
//            ClassPathXmlApplicationContext cpx; 
//        RoomService roomService;
    
    @Autowired
    RoomService roomService;;
        
//    public RoomWebServiceImpl() {
//        
//                cpx = new ClassPathXmlApplicationContext("classpath:config/spring-config.xml");
//        roomService = cpx.getBean(RoomService.class);
//    }
    
    @Override
    public Room getRoomById(Long roomID) {
        return roomService.findOne(roomID);
    }

    @Override
    public Long addRoom(Room room) {
        Room r = roomService.save(room);
        return r.getId();
    }

    @Override
    public boolean updateRoom(Room room) {
        try{
            roomService.save(room);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteRoom(Long roomID) {
        try{
            roomService.delete(roomID);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean attachDeviceToRoom(Device device, Long roomID) {
        try{
            Room r = getRoomById(roomID);
            ArrayList<Device> deviceList = (ArrayList)r.getDevices();
            deviceList.add(device);
            roomService.save(r);
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
            roomService.save(r);
            return true;
        }
        catch (Exception e){
            return false;
        }
    
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        return (ArrayList) roomService.findAll();
    }
    
}
