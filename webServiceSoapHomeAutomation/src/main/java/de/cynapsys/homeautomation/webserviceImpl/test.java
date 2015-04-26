/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.webserviceImpl;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mouadh
 */
@Component
public class test {
    
    
    public static void main (String args[]){
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/spring-config.xml");
            CategoryWebServiceImpl a = new CategoryWebServiceImpl();
            System.out.println(a.getAllCategories());
    }
    
}
