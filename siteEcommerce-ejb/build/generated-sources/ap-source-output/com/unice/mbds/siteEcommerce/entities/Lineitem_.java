package com.unice.mbds.siteEcommerce.entities;

import com.unice.mbds.siteEcommerce.entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-04T22:29:22")
@StaticMetamodel(Lineitem.class)
public class Lineitem_ { 

    public static volatile SingularAttribute<Lineitem, Integer> quantity;
    public static volatile SingularAttribute<Lineitem, Product> productId;
    public static volatile SingularAttribute<Lineitem, Double> subtotal;
    public static volatile SingularAttribute<Lineitem, Long> id;

}