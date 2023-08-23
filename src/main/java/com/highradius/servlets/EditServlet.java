package com.highradius.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.implementation.*;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InvoiceDao invoiceDao = new InvoiceDaoImpl();		
		int editSerial = Integer.valueOf(request.getParameter("serialNo"));
		String newValue = request.getParameter("newDistributionChannel");

		Gson gson = new Gson();
		String errorString = "Oops! Data Updation Unsuccessful...";
		String jsonResponse = gson.toJson(errorString);
		
		boolean updated = invoiceDao.editInvoice(editSerial, newValue);
		if(updated)
			jsonResponse = gson.toJson("Great! Data Updation Successful...");
			
		response.getWriter().append(jsonResponse);		
	}
}