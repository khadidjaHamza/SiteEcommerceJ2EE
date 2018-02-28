/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.session;

import com.unice.mbds.siteEcommerce.entities.Purchaseorder;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Yasmine
 */
@Stateless
@LocalBean
public class PurchaseOrderManager {
    
    @PersistenceContext(unitName = "siteEcommerce-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public void executeOrder(Purchaseorder order) {
        em.persist(order);
    }

    public List<Purchaseorder> getAllProduct() {  
        Query query = em.createNamedQuery("Purchaseorder.findAll");  
        return query.getResultList();  
    }  
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
