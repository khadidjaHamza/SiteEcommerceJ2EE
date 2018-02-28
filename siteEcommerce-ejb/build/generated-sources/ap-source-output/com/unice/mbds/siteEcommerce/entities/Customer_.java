package com.unice.mbds.siteEcommerce.entities;

import com.unice.mbds.siteEcommerce.entities.Purchaseorder;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-04T22:29:22")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> billingcity;
    public static volatile SingularAttribute<Customer, String> firstname;
    public static volatile CollectionAttribute<Customer, Purchaseorder> purchaseorderCollection;
    public static volatile SingularAttribute<Customer, Integer> billingzipcode;
    public static volatile SingularAttribute<Customer, Integer> shipingzipcode;
    public static volatile SingularAttribute<Customer, String> lastname;
    public static volatile SingularAttribute<Customer, String> billingaddress;
    public static volatile SingularAttribute<Customer, String> shipingaddress;
    public static volatile SingularAttribute<Customer, String> password;
    public static volatile SingularAttribute<Customer, Integer> phone;
    public static volatile SingularAttribute<Customer, String> shipingcity;
    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile SingularAttribute<Customer, String> email;

}