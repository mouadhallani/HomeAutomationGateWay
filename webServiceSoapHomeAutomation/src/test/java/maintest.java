/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.service.CategoryService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author mouadh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/applicationContext.xml" })
public class maintest {
    
    
    
    private static ClassPathXmlApplicationContext context;
    private static CategoryService cs;
    
    
    public maintest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
         context = new ClassPathXmlApplicationContext(
				"config/applicationContext.xml");
		 cs = context.getBean(CategoryService.class);
        
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
    public void connectionTest(){
        
        Category c = new Category(1000L, "device1", "description device 1");

        cs.save(c);
        context.close();
        

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
