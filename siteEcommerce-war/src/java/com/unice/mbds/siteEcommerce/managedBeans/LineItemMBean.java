/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.managedBeans;
import com.unice.mbds.siteEcommerce.DAO.LoginDAO;
import com.unice.mbds.siteEcommerce.entities.Lineitem;
import com.unice.mbds.siteEcommerce.session.LineItemManager;
import com.unice.mbds.siteEcommerce.session.ProductManager;
import com.unice.mbds.siteEcommerce.tools.SessionUtils;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

@Named(value = "lineItemMBean")
@ManagedBean
@SessionScoped
public class LineItemMBean {
    
    private int quantity;
    private double total = 0;
    @EJB
    private ProductManager productManager;
      @EJB
    private LineItemManager lineItemManager;

    /**
     * Creates a new instance of LineItemMBean
     */
    public LineItemMBean() {
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total += total;
    }
       /** 
     * Renvoie la liste des categories pour affichage dans une DataTable 
     * @return 
     */  
    public List<Lineitem> getLineitem() {  
        return lineItemManager.getAllLineItems();  
    }
    
    public String addItem(Long id){
       productManager.getProductByProductId(id);
        Lineitem lineitem = new Lineitem(id);
        lineitem.setProductId(productManager.getProductByProductId(id));
        lineitem.setQuantity(quantity);
        lineitem.setSubtotal(quantity * lineitem.getProductId().getPrice());
        setTotal(lineitem.getSubtotal());
        lineItemManager.update(lineitem);
      return "CartList";
    }
    
    public String deleteItem(Long id){
       productManager.getProductByProductId(id);
        Lineitem lineitem = new Lineitem(id);
        lineitem.setProductId(productManager.getProductByProductId(id));
        setTotal(- quantity*lineitem.getProductId().getPrice());
        lineItemManager.delete(lineitem);
      return "CartList";
    }
    
}
