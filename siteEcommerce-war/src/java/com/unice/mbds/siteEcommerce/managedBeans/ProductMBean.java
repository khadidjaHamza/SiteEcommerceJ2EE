/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.managedBeans;

import com.unice.mbds.siteEcommerce.entities.Product;
import com.unice.mbds.siteEcommerce.session.ProductManager;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named(value = "ProductMBean")
@ViewScoped
public class ProductMBean implements Serializable {  
    @EJB
    private ProductManager productManager;

    /**
     * Creates a new instance of ProductMBean
     */
    public ProductMBean() {
    }
     /** 
     * Renvoie la liste des produits pour affichage dans une DataTable 
     * @return 
     */  
    public List<Product> getProducts() {  
        return productManager.getAllProduct();  
    } 
    
}
