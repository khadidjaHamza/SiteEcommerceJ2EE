/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.managedBeans;

import com.unice.mbds.siteEcommerce.entities.Category;
import com.unice.mbds.siteEcommerce.session.CategoryManager;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "categoryMBean")
@ViewScoped
public class CategoryMBean implements Serializable{
    @EJB
    private CategoryManager categoryManager;

    
    /**
     * Creates a new instance of CategoryMBean
     */
    public CategoryMBean() {
    }
    
   /** 
     * Renvoie la liste des categories pour affichage dans une DataTable 
     * @return 
     */  
    public List<Category> getCategory() {  
        return categoryManager.getAllCategories();  
    }
}
