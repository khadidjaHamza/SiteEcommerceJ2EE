/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yasmine
 */
@Entity
@Table(name = "PURCHASEORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchaseorder.findAll", query = "SELECT p FROM Purchaseorder p"),
    @NamedQuery(name = "Purchaseorder.findById", query = "SELECT p FROM Purchaseorder p WHERE p.id = :id"),
    @NamedQuery(name = "Purchaseorder.findByCreationdate", query = "SELECT p FROM Purchaseorder p WHERE p.creationdate = :creationdate"),
    @NamedQuery(name = "Purchaseorder.findByItemid", query = "SELECT p FROM Purchaseorder p WHERE p.itemid = :itemid"),
    @NamedQuery(name = "Purchaseorder.findByTotalprice", query = "SELECT p FROM Purchaseorder p WHERE p.totalprice = :totalprice")})
public class Purchaseorder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "ITEMID")
    private BigInteger itemid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALPRICE")
    private double totalprice;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Customer customerId;

    public Purchaseorder() {
    }

    public Purchaseorder(Long id) {
        this.id = id;
    }

    public Purchaseorder(Long id, double totalprice) {
        this.id = id;
        this.totalprice = totalprice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public BigInteger getItemid() {
        return itemid;
    }

    public void setItemid(BigInteger itemid) {
        this.itemid = itemid;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
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
        if (!(object instanceof Purchaseorder)) {
            return false;
        }
        Purchaseorder other = (Purchaseorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unice.mbds.siteEcommerce.entities.Purchaseorder[ id=" + id + " ]";
    }
    
}
