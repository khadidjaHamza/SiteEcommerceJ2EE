package com.unice.mbds.siteEcommerce.entities;

import com.unice.mbds.siteEcommerce.entities.Customer;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-04T22:29:22")
@StaticMetamodel(Purchaseorder.class)
public class Purchaseorder_ { 

    public static volatile SingularAttribute<Purchaseorder, BigInteger> itemid;
    public static volatile SingularAttribute<Purchaseorder, Date> creationdate;
    public static volatile SingularAttribute<Purchaseorder, Double> totalprice;
    public static volatile SingularAttribute<Purchaseorder, Customer> customerId;
    public static volatile SingularAttribute<Purchaseorder, Long> id;

}