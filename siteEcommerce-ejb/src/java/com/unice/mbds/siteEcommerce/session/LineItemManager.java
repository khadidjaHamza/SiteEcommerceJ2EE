/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.session;

import com.unice.mbds.siteEcommerce.entities.Lineitem;
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
public class LineItemManager {
    @PersistenceContext(unitName = "siteEcommerce-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Lineitem> getAllLineItems() {  
        Query query = em.createNamedQuery("Lineitem.findAll");  
        return query.getResultList();  
    }  
  
    public Lineitem update(Lineitem lineitem) {  
        return em.merge(lineitem);  
    }
    
    public String delete(Lineitem lineitem) { 
        if (!em.contains(lineitem)) {
                lineitem = em.merge(lineitem);
            }
            em.remove(lineitem);
	return null;  
    }
    
}
