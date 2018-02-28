/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yasmine
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id"),
    @NamedQuery(name = "Customer.findByBillingaddress", query = "SELECT c FROM Customer c WHERE c.billingaddress = :billingaddress"),
    @NamedQuery(name = "Customer.findByBillingcity", query = "SELECT c FROM Customer c WHERE c.billingcity = :billingcity"),
    @NamedQuery(name = "Customer.findByBillingzipcode", query = "SELECT c FROM Customer c WHERE c.billingzipcode = :billingzipcode"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
    @NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Customer.findByLastname", query = "SELECT c FROM Customer c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
    @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customer.findByShipingaddress", query = "SELECT c FROM Customer c WHERE c.shipingaddress = :shipingaddress"),
    @NamedQuery(name = "Customer.findByShipingcity", query = "SELECT c FROM Customer c WHERE c.shipingcity = :shipingcity"),
    @NamedQuery(name = "Customer.findByShipingzipcode", query = "SELECT c FROM Customer c WHERE c.shipingzipcode = :shipingzipcode")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "BILLINGADDRESS")
    private String billingaddress;
    @Size(max = 255)
    @Column(name = "BILLINGCITY")
    private String billingcity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BILLINGZIPCODE")
    private int billingzipcode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 255)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PHONE")
    private int phone;
    @Size(max = 255)
    @Column(name = "SHIPINGADDRESS")
    private String shipingaddress;
    @Size(max = 255)
    @Column(name = "SHIPINGCITY")
    private String shipingcity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SHIPINGZIPCODE")
    private int shipingzipcode;
    @OneToMany(mappedBy = "customerId")
    private Collection<Purchaseorder> purchaseorderCollection;

    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Customer(Long id, int billingzipcode, int phone, int shipingzipcode) {
        this.id = id;
        this.billingzipcode = billingzipcode;
        this.phone = phone;
        this.shipingzipcode = shipingzipcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    public String getBillingcity() {
        return billingcity;
    }

    public void setBillingcity(String billingcity) {
        this.billingcity = billingcity;
    }

    public int getBillingzipcode() {
        return billingzipcode;
    }

    public void setBillingzipcode(int billingzipcode) {
        this.billingzipcode = billingzipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getShipingaddress() {
        return shipingaddress;
    }

    public void setShipingaddress(String shipingaddress) {
        this.shipingaddress = shipingaddress;
    }

    public String getShipingcity() {
        return shipingcity;
    }

    public void setShipingcity(String shipingcity) {
        this.shipingcity = shipingcity;
    }

    public int getShipingzipcode() {
        return shipingzipcode;
    }

    public void setShipingzipcode(int shipingzipcode) {
        this.shipingzipcode = shipingzipcode;
    }

    @XmlTransient
    public Collection<Purchaseorder> getPurchaseorderCollection() {
        return purchaseorderCollection;
    }

    public void setPurchaseorderCollection(Collection<Purchaseorder> purchaseorderCollection) {
        this.purchaseorderCollection = purchaseorderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unice.mbds.siteEcommerce.entities.Customer[ id=" + id + " ]";
    }
    
}
