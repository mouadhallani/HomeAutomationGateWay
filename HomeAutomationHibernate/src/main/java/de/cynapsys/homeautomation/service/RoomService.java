/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.service;

import de.cynapsys.homeautomation.entity.Room;
import java.util.List;
import java.util.List;


/**
 *
 * @author mouadh
 */
public interface RoomService {
    public Long addRoom(Room d);
    public Room getRoomById(Long id);
    public List<Room> getAllRooms();
    public boolean deleteRoom(Long id);
    public boolean updateRoom(Room d);
}
