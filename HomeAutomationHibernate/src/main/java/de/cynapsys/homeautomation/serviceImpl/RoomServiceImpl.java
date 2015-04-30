/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl;

import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Room;
import de.cynapsys.homeautomation.service.RoomService;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

/**
 *
 * @author mouadh
 */

public class RoomServiceImpl implements RoomService{

    Session session;
    
    @Override
    public Long addRoom(Room r) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long id=(Long)session.save(r);
        session.getTransaction().commit();
        session.close();
        return id;
   }

    @Override
    public Room getRoomById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Room rr= (Room)session.load(Room.class, id);
        session.getTransaction().commit();
        session.close();
        return rr;
    }

    @Override
    public List<Room> getAllRooms() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Room> lr=session.createCriteria(Room.class).list();
        session.getTransaction().commit();
        session.close();
        return lr;
    }

    @Override
    public boolean deleteRoom(Long id) { 
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(getRoomById(id));
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException hibernateException) {
            return false;
        }
    }

    @Override
    public boolean updateRoom(Room r) {
            try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(r);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException hibernateException) {
            return false;
        }
    }  
}
