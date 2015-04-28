/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.service.CategoryService;
import java.util.List;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author mouadh
 */

//public class CategoryServiceImpl extends CRUDServiceImpl<Category, Long>{

public class CategoryServiceImpl implements CategoryService{

    Session session;

    public CategoryServiceImpl() {
    }
    
    
      
        

    @Override
    public void addCategory(Category c) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println(session.save(c)+"  Test Save Category !!!");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Category getCategoryById(Long id) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Category cc= (Category)session.load(Category.class, id);
        session.getTransaction().commit();
        session.close();
        return cc;
    }

    @Override
    public List<Category> getAllCategories() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Category> lc=session.createCriteria(Category.class).list();
        session.getTransaction().commit();
        session.close();
        return lc;
    }

    @Override
    public void deleteCategory(Long id) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(getCategoryById(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateCategory(Category c) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(c);
        session.getTransaction().commit();
        session.close();
    }

    
    
    
    
}
