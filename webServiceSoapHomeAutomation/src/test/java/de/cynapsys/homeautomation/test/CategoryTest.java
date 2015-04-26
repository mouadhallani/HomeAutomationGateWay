/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.test;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.service.DeviceService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author mouadh
 */
public class CategoryTest {
    
    ClassPathXmlApplicationContext cpx;
    CategoryService categoryService;
    DeviceService deviceService;
    
    public CategoryTest() {
    }
    
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
    
    @Transactional
    @Test
    public void testAddCategory(){
        
        Category c = new Category("category test", "description of category test emchiiiiiii");
        
        
        cpx = new ClassPathXmlApplicationContext("classpath:config/spring-config.xml");
        categoryService = cpx.getBean(CategoryService.class);
        deviceService = cpx.getBean(DeviceService.class);
        
        
        
        Device device = new Device("device name", "device description", 1000);
        Device device2 = new Device("device name 2", "device description 2", 1000);
        
        List<Device> dev = new ArrayList<>();
        
        dev.add(device);
        dev.add(device2);
        
        if(c.getDevices()==null){
        c.setDevices(new ArrayList<Device>());
        }
        c.getDevices().add(device);
        c.getDevices().add(device2);
        categoryService.save(c);
        
        
        c.setDescription("test Update hahaha");
        //categoryService.save(c);
        
        c = new Category("category test", "description of category test emchiiiiiii");
        //categoryService.save(c);
        
        c = new Category("category test", "description of category test emchiiiiiii222222222");
        //categoryService.save(c);
        
        System.out.println("List Category : "+categoryService.findAll());
        System.out.println("List Devices is : " +deviceService.findAll());
        cpx.close();
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}
