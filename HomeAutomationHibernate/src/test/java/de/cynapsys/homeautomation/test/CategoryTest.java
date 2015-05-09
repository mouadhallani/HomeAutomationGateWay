/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.test;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Room;
import de.cynapsys.homeautomation.entity.network.UpnpEntity;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.service.DeviceService;
import de.cynapsys.homeautomation.service.network.UpnpService;
import de.cynapsys.homeautomation.serviceImpl.DeviceServiceImpl;
import de.cynapsys.homeautomation.serviceImpl.network.UpnpServiceImpl;
import de.cynapsys.homeautomation.upnp.IPUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
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
        
        
        try {
            Socket socket = new Socket();
            String ip = IPUtil.getExternalIPAddress();
            socket.connect(new InetSocketAddress(InetAddress.getByName(ip), 1200), 200);
            System.out.println("OK");
            socket.close();
            
        } catch (Exception ex) {
            System.out.println("KO");
        }
//        UpnpService upnpService = new UpnpServiceImpl();
//        try {
//            System.out.println("find : "+ upnpService.getUpnpByPort(12) ) ;
//        } catch (Exception e) {
//            UpnpEntity entity =new UpnpEntity(12);
//            upnpService.addPort(entity);
//        }
        
//        DeviceService ds = new DeviceServiceImpl();
//        Device d = new Device("device", "device description", 11);
//        Room r = new Room();
//        r.setId(1L);
//        Category c = new Category();
//        c.setId(27L);
//        
//        d.setRoom(r);
//        d.setCategory(c);
//        
//        ds.addDevice(d);
        //
        
        //System.out.println(ds.getAllDevices());
        
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        String ro1="{id=2, name=test, description=jhkjhk}\r\n";
//        String ro="Room{id=1, name=zzzz, description=zzzzzdfsdfd}";
//        ro1=ro1.replace("\n", "").replace("\r", "");
//        ro1=ro1.replaceFirst("Room", "");
//        ro1=ro1.replaceAll("=", ":\"");
//        ro1=ro1.replaceAll(",", "\",");
//        ro1=ro1.replaceAll("}", "\"}");
//        System.out.println(ro1);
//        Room r=null;
//        try {
//            r = mapper.readValue(ro1, Room.class);
//        } catch (IOException ex) {
//            Logger.getLogger(CategoryTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//                System.out.println("I am a converted room "+r);
 
        //System.out.println(new Room(2L, "test", "jhkjhk"));
        
//        categoryService = new CategoryServiceImpl();
//        System.out.println(categoryService.getAllCategories().size());
        
//        DDNSService dDNSService = new DDNSServiceImpl();
//        dDNSService.changeConfiguration(new DdnsEntity(1,"account", "password", "fsdfs"));
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
