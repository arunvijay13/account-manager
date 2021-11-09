package com.account;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/CustomerServletController")
public class CustomerServletController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		String command = request.getParameter("COMMAND");
		try {
			if(command != null) {
				if(command.equals("LOAD")) {
					loadCustomer(request,response);
				}else if(command.equals("DELETE")) {
					deleteCustomer(request,response);
					listCustomers(request,response);
				}
			}else {
				listCustomers(request,response);
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("COMMAND");
		
		try {
			switch(command) {
				case "UPDATE":
					updateCustomer(request,response);
					break;
				case "ADD":
					addCustomer(request,response);
					break;
				default:
					listCustomers(request,response);
			}
			
			listCustomers(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		Customer theCustomer =  new Customer(firstName,lastName,email,amount);
		CustomerUtil.addCustomer(theCustomer);
		
	}
	
	private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<Customer> customerList = CustomerUtil.listCustomer();
		request.setAttribute("CUSTOMER_LIST", customerList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/list-customer.jsp");
		rd.forward(request, response);
	}
	
	private void loadCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Customer theCustomer = CustomerUtil.fetchCustomer(id);
		if(theCustomer != null) {
			theCustomer.setId(id);
			request.setAttribute("LOAD_CUSTOMER", theCustomer);
			RequestDispatcher rd = request.getRequestDispatcher("/edit-customer.jsp");
			rd.forward(request, response);
		}else {
			listCustomers(request,response);
		}
	}
	
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int amount = Integer.parseInt(request.getParameter("amount"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		Customer theCustomer = new Customer(id,firstName,lastName,email,amount);
		CustomerUtil.updateCustomer(id, theCustomer);
	}
	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerUtil.deleteCustomer(id);
	}
	
}
