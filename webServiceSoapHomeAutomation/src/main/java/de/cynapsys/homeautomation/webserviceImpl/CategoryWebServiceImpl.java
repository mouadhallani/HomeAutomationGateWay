/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.webserviceImpl;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.webservice.CategoryWebService;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mouadh
 */
@Component("CategoryWebServiceImpl")
@Scope("session")
@WebService(endpointInterface = "de.cynapsys.homeautomation.webservice.CategoryWebService")
public class CategoryWebServiceImpl implements CategoryWebService {

    
//    ClassPathXmlApplicationContext cpx; 
//        CategoryService categoryService; 
//        
//        
    @Autowired
    CategoryService categoryService;

//    public CategoryWebServiceImpl() {
//        
////        cpx = new ClassPathXmlApplicationContext("classpath:config/spring-config.xml");
////        categoryService = cpx.getBean(CategoryService.class);
//        
//    }
        
        

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ArrayList<Category> getAllCategories() {
        return (ArrayList) categoryService.findAll();
    }

    @Override
    public Category getCategoryByID(Long CategoryID) {
        return categoryService.findOne(CategoryID);
    }

    @Override
    public Long addCategory(Category category) {
        Category a = categoryService.save(category);
        return a.getId();
    }

    @Override
    public boolean deleteCategory(Long CategoryID) {
        try {
            categoryService.delete(CategoryID);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCategory(Category category) {

        try {
            categoryService.save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
