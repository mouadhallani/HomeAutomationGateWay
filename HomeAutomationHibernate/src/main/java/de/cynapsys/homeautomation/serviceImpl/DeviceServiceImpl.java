/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl;

import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.service.DeviceService;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 *
 * @author mouadh
 */

public class DeviceServiceImpl implements DeviceService{

    private SessionFactory SessionFactory;

    @Override
    public void addDevice(Device c) {
        SessionFactory.getCurrentSession().save(c);
    }

    @Override
    public Device getDeviceById(Long id) {
        return (Device) SessionFactory.getCurrentSession().load(Device.class, id);
    }

    @Override
    public List<Device> getAllDevices() {
        return  SessionFactory.getCurrentSession().createCriteria(Device.class).list();
    }

    @Override
    public void deleteDevice(Long id) {
        SessionFactory.getCurrentSession().delete(getDeviceById(id));
    }

    @Override
    public void updateDevice(Device c) {
        SessionFactory.getCurrentSession().update(c);
    }
    
}
