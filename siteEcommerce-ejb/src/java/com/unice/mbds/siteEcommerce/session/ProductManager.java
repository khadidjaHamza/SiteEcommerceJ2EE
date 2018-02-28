/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.session;

import com.unice.mbds.siteEcommerce.entities.Product;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ProductManager {
    @PersistenceContext(unitName = "siteEcommerce-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Product> getAllProduct() {  
        Query query = em.createNamedQuery("Product.findAll");  
  
        return query.getResultList();  
    }  
  
    public Product update(Product product) {  
        return em.merge(product);  
    }
    
    public Product getProductByProductId(Long productId) {
        return  em.find(Product.class, productId);
        //(Product) em.createNamedQuery("Product.findById").setParameter("id", productId).getSingleResult();
    }
    
    public void addProduct(Product product) {
        em.persist(product);
    }

    public Collection<Product> getProductListByCategoryId(Long catgoryId) {
        return (Collection<Product>) em.createNamedQuery("Product.findByCategoryId").setParameter("catgoryId", catgoryId).getResultList();
    }
}
