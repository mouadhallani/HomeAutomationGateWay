/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.service.DeviceService;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
/**
 *
 * @author mouadh
 */

public class DeviceServiceImpl implements DeviceService{

    Session session;

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
        Device dd= (Device)session.load(Device.class, id);
        session.getTransaction().commit();
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
            session.delete(getDeviceById(id));
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
    
}
