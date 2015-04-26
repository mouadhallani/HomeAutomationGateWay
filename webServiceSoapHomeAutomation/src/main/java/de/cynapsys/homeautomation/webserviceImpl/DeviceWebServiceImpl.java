/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.webserviceImpl;

import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.service.DeviceService;
import de.cynapsys.homeautomation.webservice.DeviceWebService;
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
@Component("DeviceWebServiceImpl")
@Scope("session")
@WebService(endpointInterface = "de.cynapsys.homeautomation.webservice.DeviceWebService")
public class DeviceWebServiceImpl implements DeviceWebService{

    
//        ClassPathXmlApplicationContext cpx; 
//        DeviceService deviceService; 
//        
//        
    @Autowired
    DeviceService deviceService;
//        
//        
//    public DeviceWebServiceImpl() {
//        
//        cpx = new ClassPathXmlApplicationContext("classpath:config/spring-config.xml");
//        deviceService = cpx.getBean(DeviceService.class);
//        
//    }

    @Override
    public ArrayList<Device> getAllDevices() {
        return (ArrayList)deviceService.findAll();
    }

    @Override
    public Device getDeviceByID(Long deviceID) {
        return (Device) deviceService.findOne(deviceID);
    }

    @Override
    public int getValue(Long deviceID) {
        Device device = getDeviceByID(deviceID);
        return device.getCurrentValue();
    }

    @Override
    public boolean setValue(Long deviceID, int value) {
        try{
            Device device = getDeviceByID(deviceID);
            device.setCurrentValue(value);
            deviceService.save(device);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public Long addDevice(Device device) {
        Device d= deviceService.save(device);
        return d.getId();
    }

    @Override
    public boolean deleteDevice(Long deviceID) {
        try{
            Device device = getDeviceByID(deviceID);
            deviceService.delete(device);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateDevice(Device device) {
        try{
            deviceService.save(device);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    
}
