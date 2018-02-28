package com.unice.mbds.siteEcommerce.entities;

import com.unice.mbds.siteEcommerce.entities.Category;
import com.unice.mbds.siteEcommerce.entities.Lineitem;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-04T22:29:22")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> image;
    public static volatile SingularAttribute<Product, Integer> quantity;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Long> id;
    public static volatile SingularAttribute<Product, Short> availability;
    public static volatile SingularAttribute<Product, String> type;
    public static volatile SingularAttribute<Product, Category> categoryId;
    public static volatile CollectionAttribute<Product, Lineitem> lineitemCollection;

}