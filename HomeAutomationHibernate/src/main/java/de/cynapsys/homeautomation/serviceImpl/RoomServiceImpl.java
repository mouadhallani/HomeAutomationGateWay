/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl;

import de.cynapsys.homeautomation.entity.Room;
import de.cynapsys.homeautomation.service.RoomService;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author mouadh
 */

public class RoomServiceImpl implements RoomService{

    private SessionFactory SessionFactory;
    @Override
    public void addRoom(Room c) {
        SessionFactory.getCurrentSession().save(c);
    }

    @Override
    public Room getRoomById(Long id) {
        return (Room) SessionFactory.getCurrentSession().load(Room.class, id);
    }

    @Override
    public List<Room> getAllRooms() {
        return  SessionFactory.getCurrentSession().createCriteria(Room.class).list();
    }

    @Override
    public void deleteRoom(Long id) {
        SessionFactory.getCurrentSession().delete(getRoomById(id));
    }

    @Override
    public void updateRoom(Room c) {
        SessionFactory.getCurrentSession().update(c);
    }  
}
