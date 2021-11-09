package com.account;

import java.util.*;
import java.sql.*;

public class CustomerUtil {
	
	public static List<Customer> listCustomer() throws Exception{
		
		ArrayList<Customer> customerList = new ArrayList<>();
		
		Connection myconn = null;
		Statement mystmt = null;
		ResultSet result = null;
		
		String query = "SELECT * FROM CUSTOMER";
		
		try {
			myconn = DatabaseUtil.getConnection();
			mystmt = myconn.createStatement();
			result = mystmt.executeQuery(query);
			
			while(result.next()) {
				int id = result.getInt("ID");
				String firstName = result.getString("FIRSTNAME");
				String lastName = result.getString("LASTNAME");
				String email = result.getString("EMAIL");
				int amount = result.getInt("AMOUNT");
				
				customerList.add(new Customer(id,firstName,lastName,email,amount));
			}
			
		}
		finally {
			myconn.close();
			mystmt.close();
			result.close();
		}
		
		return customerList;
		
	}
	
	public static void addCustomer(Customer theCustomer) throws Exception {
		Connection myconn = null;
		PreparedStatement mystmt = null;
		
		String query = "INSERT INTO CUSTOMER(FIRSTNAME,LASTNAME,EMAIL,AMOUNT) VALUES(?,?,?,?)";
		
		try {
			myconn = DatabaseUtil.getConnection();
			mystmt = myconn.prepareStatement(query);
			
			mystmt.setString(1, theCustomer.getFirstName());
			mystmt.setString(2, theCustomer.getLastName());
			mystmt.setString(3, theCustomer.getEmail());
			mystmt.setInt(4, theCustomer.getAmount());
			
			mystmt.execute();
						
		}
		finally {
			myconn.close();
			mystmt.close();
		}
		
	}
	
	public static Customer fetchCustomer(int id) throws Exception {
		Connection myconn = null;
		PreparedStatement mystmt = null;
		ResultSet result = null;
		
		String query = "SELECT * FROM CUSTOMER WHERE ID=?";
		
		try {
			myconn = DatabaseUtil.getConnection();
			mystmt = myconn.prepareStatement(query);
			mystmt.setInt(1,id);
			
			result = mystmt.executeQuery();
			
			if(result.next()) {
				String firstName = result.getString("FIRSTNAME");
				String lastName = result.getString("LASTNAME");
				String email = result.getString("EMAIL");
				int amount = result.getInt("AMOUNT");
				
				return new Customer(firstName,lastName,email,amount);
			}
				
			return null;
		}
		finally {
			myconn.close();
			mystmt.close();
			result.close();
		}
	}
	
	public static void updateCustomer(int id,Customer theCustomer) throws Exception {
		Connection myconn = null;
		PreparedStatement mystmt = null;
		
		
		String query = "UPDATE CUSTOMER SET FIRSTNAME=?, "
				+ "LASTNAME=?, EMAIL=?, "
				+ "AMOUNT=? WHERE ID=?";
		
		try {
			myconn = DatabaseUtil.getConnection();
			mystmt = myconn.prepareStatement(query);
			
			mystmt.setString(1, theCustomer.getFirstName());
			mystmt.setString(2, theCustomer.getLastName());
			mystmt.setString(3, theCustomer.getEmail());
			mystmt.setInt(4, theCustomer.getAmount());
			mystmt.setInt(5, id);
			
			mystmt.execute();
		}
		finally {
			myconn.close();
			mystmt.close();
		}
	}

	public static void deleteCustomer(int id) throws Exception {
		Connection myconn = null;
		PreparedStatement mystmt = null;
		
		String query = "DELETE FROM CUSTOMER WHERE ID=?";
		
		try {
			myconn = DatabaseUtil.getConnection();
			mystmt = myconn.prepareStatement(query);
			mystmt.setInt(1, id);
			
			mystmt.execute();
		}
		finally {
			myconn.close();
			mystmt.close();
		}
		
	}
	
}
