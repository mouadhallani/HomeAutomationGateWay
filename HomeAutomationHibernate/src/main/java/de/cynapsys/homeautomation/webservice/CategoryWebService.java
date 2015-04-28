/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.webservice;

import de.cynapsys.homeautomation.entity.Category;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author mouadh
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CategoryWebService {

    @WebMethod
    ArrayList<Category> getAllCategories();

    @WebMethod
    Category getCategoryByID(@WebParam(name = "CategoryID") Long CategoryID);

    @WebMethod
    void addCategory(@WebParam(name = "Category") Category Category);

    @WebMethod
    boolean deleteCategory(@WebParam(name = "CategoryID") Long CategoryID);

    @WebMethod
    boolean updateCategory(@WebParam(name = "Category") Category Category);
}
