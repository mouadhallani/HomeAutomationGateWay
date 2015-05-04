/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Room;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.service.DeviceService;
import java.util.List;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
/**
 *
 * @author mouadh
 */

public class DeviceServiceImpl implements DeviceService{

    static transient Session session;

    @Override
    public Long addDevice(Device d) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long id=(Long)session.save(d);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public Device getDeviceById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Device where id = :id ");
        query.setParameter("id", id);
        
        Device dd= (Device)query.uniqueResult();
        session.close();
        return dd;
    }

    @Override
    public List<Device> getAllDevices() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Device> lc=session.createCriteria(Device.class).list();
        session.getTransaction().commit();
        session.close();
        return lc;
    }

    @Override
    public boolean deleteDevice(Long id) {
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(new Device(id, null, null, 0));
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException hibernateException) {
            return false;
        }
    }

    @Override
    public boolean updateDevice(Device d) {
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(d);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException hibernateException) {
            return false;
        }
    }

    @Override
    public List<Device> getDevicesByRoom(Room r) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Device> lc= session.createCriteria(Device.class).list();
        session.getTransaction().commit();
        session.close();
        return lc;
    }

    @Override
    public List<Device> getDevicesByCategory(Category c) {
        CategoryService cs = new CategoryServiceImpl();
        Category cc=cs.getCategoryById(c.getId());
        return cc.getDevices();
        
    }
    
}
