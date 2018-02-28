/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unice.mbds.siteEcommerce.DAO;

import com.unice.mbds.siteEcommerce.utils.DataConnect;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class LoginDAO {

	public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select firstname, password from Customer where firstname = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, password);
                      
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
        
         //Register
        public static String add(String firstName, String lastName, String email, String password, String billingAddress, 
                                 String shipingAddress, int billingZipCode, int shipingZipCode, 
                                 String billingCity, String shipingCity, int phone) {
        int i = 0;
          // create random object
      Random randomno = new Random();

      // create byte array
      byte[] nbyte = new byte[5];
      // put the next byte in the array
      randomno.nextBytes(nbyte);
        byte [] v = {0,-1};
        BigInteger id = new BigInteger(nbyte);
//Math.abs(rand);
        if (firstName != null) {
            PreparedStatement ps = null;
            Connection con = null;
            try {
                if (DataConnect.getConnection() != null) {
                    con = DataConnect.getConnection();
                    if (con != null) {
                        String sql = "INSERT INTO Customer(id,firstName, email, lastName, password, billingAddress,"
                                + " shipingAddress, billingZipCode, shipingZipCode, billingCity, shipingCity, phone) VALUES"
                                + "                       (?,?,?,?,?,?,?,?,?,?,?,?)";
                        ps = con.prepareStatement(sql);
                        ps.setObject(1, id);
                        ps.setString(2, firstName);
                        ps.setString(4, lastName);
                        ps.setString(3, email);
                        ps.setString(5, password);
                        ps.setString(6, billingAddress);
                        ps.setString(7, shipingAddress);
                        ps.setInt(8, billingZipCode);
                        ps.setInt(9, shipingZipCode);
                        ps.setString(10, billingCity);
                        ps.setString(11, shipingCity);
                        ps.setInt(12, phone);
                        
                        i = ps.executeUpdate();
                        System.out.println("Data Added Successfully");
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    con.close();
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (i > 0) {
            return "success";
        } else
            return "unsuccess";
    }
}
