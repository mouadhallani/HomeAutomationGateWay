/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.service.CategoryService;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author mouadh
 */

//public class CategoryServiceImpl extends CRUDServiceImpl<Category, Long>{

public class CategoryServiceImpl implements CategoryService{

    static Session session;

    public CategoryServiceImpl() {
    }
    
    
      
        

    @Override
    public Long addCategory(Category c) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long a = (Long)session.save(c);
        session.getTransaction().commit();
        session.close();
        System.out.println(a);
        return a;
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
    public boolean deleteCategory(Long id) {
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(getCategoryById(id));
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException hibernateException) {
            return false;
        }
        
    }

    @Override
    public boolean updateCategory(Category c) {
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(c);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException hibernateException) {
            return false;
        }
    }

    
    
    
    
}
