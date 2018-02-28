/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.managedBeans;

import com.unice.mbds.siteEcommerce.entities.Customer;
import com.unice.mbds.siteEcommerce.session.CustomerManager;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "customerMBean")
@ViewScoped
public class CustomerMBean implements Serializable {  
    private List<Customer> customerList;  
  
    @EJB  
    private CustomerManager customerManager;  
  
    public CustomerMBean() {  
    }  
  
    /** 
     * Renvoie la liste des clients pour affichage dans une DataTable 
     * @return 
     */  
    public List<Customer>getCustomers() {  
        return customerManager.getAllCustomers();  
    }    
    
    
}
