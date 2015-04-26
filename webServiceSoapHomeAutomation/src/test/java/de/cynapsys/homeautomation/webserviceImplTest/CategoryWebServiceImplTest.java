/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.webserviceImplTest;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.webserviceImpl.CategoryWebServiceImpl;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mouadh
 */
public class CategoryWebServiceImplTest {
    
    static ClassPathXmlApplicationContext cpx;
    static CategoryService categoryService;
    
    public CategoryWebServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        cpx = new ClassPathXmlApplicationContext("classpath:config/spring-config.xml");
        categoryService = cpx.getBean(CategoryService.class);
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

    /**
     * Test of getCategoryService method, of class CategoryWebServiceImpl.
     */

    /**
     * Test of getAllCategories method, of class CategoryWebServiceImpl.
     */
    @Test
    public void testGetAllCategories() {
        System.out.println("getAllCategories");
        CategoryWebServiceImpl instance = new CategoryWebServiceImpl();
        ArrayList<Category> expResult = null;
        ArrayList<Category> result = (ArrayList )categoryService.findAll();
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCategoryByID method, of class CategoryWebServiceImpl.
     */
//    @Test
//    public void testGetCategoryByID() {
//        System.out.println("getCategoryByID");
//        Long CategoryID = 1L;
//        CategoryWebServiceImpl instance = new CategoryWebServiceImpl();
//        Category expResult = null;
//        Category result = instance.getCategoryByID(CategoryID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addCategory method, of class CategoryWebServiceImpl.
     */
//    @Test
//    public void testAddCategory() {
//        System.out.println("addCategory");
//        Category category = new Category("testCategory", "description test");
//        CategoryWebServiceImpl instance = new CategoryWebServiceImpl();
//        Long expResult = null;
//        Long result = instance.addCategory(category);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of deleteCategory method, of class CategoryWebServiceImpl.
     */
//    @Test
//    public void testDeleteCategory() {
//        System.out.println("deleteCategory");
//        Long CategoryID = 2L;
//        CategoryWebServiceImpl instance = new CategoryWebServiceImpl();
//        boolean expResult = true;
//        boolean result = instance.deleteCategory(CategoryID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of updateCategory method, of class CategoryWebServiceImpl.
     */
//    @Test
//    public void testUpdateCategory() {
//        System.out.println("updateCategory");
//        Category category = null;
//        CategoryWebServiceImpl instance = new CategoryWebServiceImpl();
//        boolean expResult = false;
//        boolean result = instance.updateCategory(category);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
