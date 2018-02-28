/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.managedBeans;

import com.unice.mbds.siteEcommerce.DAO.LoginDAO;
import com.unice.mbds.siteEcommerce.entities.Customer;
import com.unice.mbds.siteEcommerce.tools.SessionUtils;

import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@Named(value = "loginMBean")
@ManagedBean
@SessionScoped
public class LoginMBean implements Serializable {

   private static final long serialVersionUID = 1094801825228386363L;
	private String pwd;
	private String msg;
	private String user;
        
    private Long id;
    private String billingaddress;
    private String billingcity;
    private int billingzipcode;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private int phone;
    private String shipingaddress;
    private String shipingcity;
    private int shipingzipcode;
    /**
     * Creates a new instance of LoginMBean
     */
    public LoginMBean() {
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
    
	//validate login
        public String validateUsernamePassword() {
		boolean valid = LoginDAO.validate(firstname, password); 
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("firstname", firstname);
			return "CartList";
		} else {
			
                        FacesMessage message = new FacesMessage();
                        message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        message.setSummary("ERROR MESSAGE");
                        message.setDetail(" Username / Passowrd Incorrect Aucun compte associé a ces identifiants");
                        FacesContext.getCurrentInstance().addMessage("formId:loginID", message);
                  
			return "Login";
		}
	}
        //add Customer
        public String validateUsernamePasswordAdd() {
		String valid = LoginDAO.add(firstname,lastname,email,password,billingaddress,shipingaddress,billingzipcode,shipingzipcode,billingcity,shipingcity,phone); 
		if ("success".equals(valid)) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("firstname", firstname);
                        System.out.println("Data Added Successfully");
			return "CartList";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Error",
							"Le compte n'a pas pu etre créé veuillez réesseyer"));
                        FacesMessage message = new FacesMessage();
                        message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        message.setSummary("ERROR MESSAGE");
                        message.setDetail("Error Le compte n'a pas pu etre créé veuillez réesseyer");
                        FacesContext.getCurrentInstance().addMessage("formId:loginID", message);
			return "CreateCustomer";
		}
	}
       
       
        //logout event, invalidate session
	public String logout() {
          
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
       
}
