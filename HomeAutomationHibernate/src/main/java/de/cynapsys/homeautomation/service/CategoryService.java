/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.service;

import de.cynapsys.homeautomation.entity.Category;
import java.util.List;

/**
 *
 * @author mouadh
 */

//public interface CategoryService extends CRUDService<Category, Long>{
public interface CategoryService{   
    
    public Long addCategory(Category c);
    public Category getCategoryById(Long id);
    public List<Category> getAllCategories();
    public boolean deleteCategory(Long id);
    public boolean updateCategory(Category c);
    
    
}
