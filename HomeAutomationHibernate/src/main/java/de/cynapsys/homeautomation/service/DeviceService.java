/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.service;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Room;
import java.util.List;


/**
 *
 * @author mouadh
 */
public interface DeviceService{
    
    public Long addDevice(Device d);
    public Device getDeviceById(Long id);
    public List<Device> getAllDevices();
    public boolean deleteDevice(Long id);
    public boolean updateDevice(Device d);
    public List<Device> getDevicesByRoom(Room r);
    public List<Device> getDevicesByCategory(Category c);
    
}
