/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.test;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.network.DdnsEntity;
import de.cynapsys.homeautomation.entity.network.UpnpEntity;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.service.DeviceService;
import de.cynapsys.homeautomation.service.network.DDNSService;
import de.cynapsys.homeautomation.serviceImpl.CategoryServiceImpl;
import de.cynapsys.homeautomation.serviceImpl.DeviceServiceImpl;
import de.cynapsys.homeautomation.serviceImpl.network.DDNSServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mouadh
 */

public class CategoryTest {
    
    private CategoryService categoryService;

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCategory(){
        
        DeviceService ds = new DeviceServiceImpl();
        Device d = new Device("device", "device description", 11);
        //
        
        
//        categoryService = new CategoryServiceImpl();
//        System.out.println(categoryService.getAllCategories());
        
        DDNSService dDNSService = new DDNSServiceImpl();
        dDNSService.changeConfiguration(new DdnsEntity(1,"account", "password", "fsdfs"));
//        
//        
//        Category c = new Category("category 1", "description of category 1");
//        
//        
//        
//        Device device = new Device("device name", "device description 11 ", 1000);
//        Device device2 = new Device("device name 2", "device description 2 11", 1000);
//        
//        List<Device> dev = new ArrayList<>();
//        
//        dev.add(device);
//        dev.add(device2);
//        
//        if(c.getDevices()==null){
//        c.setDevices(new ArrayList<Device>());
//        }
//        c.getDevices().add(device);
//        c.getDevices().add(device2);
//        
//        categoryService.addCategory(c);
//        
//        
//        c.setDescription("test Update hahaha");
//        //categoryService.save(c);
////        
////        c = new Category("category test", "description of category test emchiiiiiii");
////        categoryService.save(c);
////        
////        c = new Category("category test", "description of category test emchiiiiiii222222222");
//        //categoryService.save(c);
//        
//        System.out.println("List Category : "+categoryService.getAllCategories());
    }

    /**
     * Test of getId method, of class Category.
     */

    
}
