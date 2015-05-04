/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.service.CategoryService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author mouadh
 */
//public class CategoryServiceImpl extends CRUDServiceImpl<Category, Long>{
public class CategoryServiceImpl implements CategoryService {

    static transient Session session;

    public CategoryServiceImpl() {
    }


    @Override
    public Long addCategory(Category c) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long a = (Long) session.save(c);
        session.getTransaction().commit();
        session.close();
        System.out.println(a);
        return a;
    }

    @Override
    public Category getCategoryById(Long id) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Category where id = :id ");
        query.setParameter("id", id);

        Category cc = (Category) query.uniqueResult();

        session.close();
        return cc;
    }

    @Override
    public List<Category> getAllCategories() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Category> lc = session.createCriteria(Category.class).list();
        
        session.close();
        return removeDuplicates(lc);
    }

    private List<Category> removeDuplicates(List<Category> list) {
        List<Category> res = new ArrayList<>();
         for (Category c : list){
             if ( !res.contains(c)){
                 res.add(c);
             }
         }
         return res;
    }
     

    @Override
    public boolean deleteCategory(Long id) {

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            System.out.println("category will deleted is \n");
            session.delete(new Category(id, null, null));
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
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
