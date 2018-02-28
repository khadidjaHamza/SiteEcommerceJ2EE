/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.session;

import com.unice.mbds.siteEcommerce.entities.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class CategoryManager {
    @PersistenceContext(unitName = "siteEcommerce-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Category> getAllCategories() {  
    Query query = em.createNamedQuery("Category.findAll");  
        return query.getResultList();  
    }  
  
    public Category update(Category category) {  
        return em.merge(category);  
    }
}
