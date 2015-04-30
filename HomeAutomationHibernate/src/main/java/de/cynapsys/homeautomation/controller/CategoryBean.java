/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.controller;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.serviceImpl.CategoryServiceImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mouadh
 */

@ManagedBean
@SessionScoped
public class CategoryBean {
    
    List<Category> categoryList;
    Category category;
    CategoryService categoryService = new CategoryServiceImpl();
    
    @PostConstruct
    public void init(){
        categoryList=categoryService.getAllCategories();
        category = new Category();
    }
    
    public void addCategory(){
        
        System.out.println("test add category");
        categoryService.addCategory(category);
        categoryList=categoryService.getAllCategories();
    }
    
    
    public boolean deleteCategory(Long CategoryID) {
            return categoryService.deleteCategory(CategoryID);
    }

    
    public boolean updateCategory(Category category) {
            return categoryService.updateCategory(category);
    }
    
    
    

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    
    
    
}
