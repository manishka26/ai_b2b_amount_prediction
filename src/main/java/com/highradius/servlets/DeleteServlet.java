package com.highradius.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InvoiceDao invoiceDao = new InvoiceDaoImpl();		
		int deleteSerial = Integer.valueOf(request.getParameter("serialNo"));

		Gson gson = new Gson();
		String errorString = "Oops! Data Deletion Unsuccessful...";
		String jsonResponse = gson.toJson(errorString);
		
		boolean deleted = invoiceDao.deleteInvoice(deleteSerial);
		if(deleted)
			jsonResponse = gson.toJson("Great! Data Deletion Successful...");
			
		response.getWriter().append(jsonResponse);		
	}
}