/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.controller;

import de.cynapsys.homeautomation.entity.Room;
import de.cynapsys.homeautomation.service.RoomService;
import de.cynapsys.homeautomation.serviceImpl.RoomServiceImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mouadh
 */
@ManagedBean
@SessionScoped
public class RoomBean {
    
    
    List<Room> roomList;
    Room room;
    Room roomForUpdate;
    Room roomForDevices;
    
    
    RoomService roomService = new RoomServiceImpl();
    String id;

    @PostConstruct
    public void init() {
        roomList = roomService.getAllRooms();
        room = new Room();
        roomForUpdate = new Room();
        roomForDevices = new Room();
        System.out.println(roomList);
    }

    public void addRoom() {
        System.out.println("test add room");
        roomService.addRoom(room);
        roomList = roomService.getAllRooms();
    }

    public void deleteRoom(Room r) {
        System.out.println(" i am a function delete room");
        System.out.println(r);
        roomService.deleteRoom(r.getId());
        roomList = roomService.getAllRooms();

    }

    public void updateRoom() {
        System.out.println("i am update room" +roomForUpdate);
        roomService.updateRoom(roomForUpdate);
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoomForUpdate() {
        return roomForUpdate;
    }

    public void setRoomForUpdate(Room roomForUpdate) {
        this.roomForUpdate = roomForUpdate;
    }

    public Room getRoomForDevices() {
        return roomForDevices;
    }

    public void setRoomForDevices(Room roomForDevices) {
        this.roomForDevices = roomForDevices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
